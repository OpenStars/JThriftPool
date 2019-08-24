package jcommon.transport.client;

import java.lang.reflect.Constructor;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import java.lang.System;

public class TClientInfo {

    public Object m_client;
    public TProtocol m_protocol;
    public TTransport m_transport;
    public TProtocolFactory m_protoFactory;
    public Class m_clientClass;
    public Class m_protocolClass;
    protected String m_host;
    protected int m_port;
    private long m_createTime;

    public TClientInfo() {
        m_createTime=System.currentTimeMillis();
    }

    public <T extends Object> T getClientT() {
        if (sureOpen()) {
            return (T) m_client;
        }
        return null;
    }

    public TClientInfo(String host, int port, Class clientClass, Class protocolClass) {
        m_createTime=System.currentTimeMillis();
        //System.out.println("Create new TClientInfo protocolClass: " + protocolClass.toString());
        m_host = new String(host);
        m_port = port;
        m_clientClass = clientClass;
        m_protocolClass = protocolClass;
        m_protoFactory = ClientFactory.getProtocolFactory(host, port, clientClass);
        doOpen();
    }

    protected TProtocol createProtocol(TTransport aTransport) {
        if (m_protocolClass == TBinaryProtocol.class) {
            //System.out.println("Create new BIn protocol 1 nhe");
            return new TBinaryProtocol(aTransport);
        } else if (m_protocolClass == TCompactProtocol.class) {
            //System.out.println("Create new TCompactProtocol");
            return new TCompactProtocol(aTransport);
        }else if (m_protoFactory != null) {
            ////System.out.println("return m_protoFactory.getProtocol ");
            return m_protoFactory.getProtocol(aTransport);
        }
        ////System.out.println("Create new BIn protocol 2 nhe");
        return new TBinaryProtocol(aTransport);
    }

    public Object getClient() {
        if (sureOpen()) {
            ////System.out.println("sureOpen roi");
            return m_client;
        }
        ////System.out.println("getClient =null");
        return null;
    }

    public boolean doOpen() {
        try {
            m_transport = new TFramedTransport(new TSocket(m_host, m_port));
            ////System.out.println("check 1");
            m_protocol = createProtocol(m_transport);//new TBinaryProtocol(m_transport);
            Class aClass = m_clientClass;
            ////System.out.println("check 1.2" + aClass.getName());
            Constructor aConstructor = aClass.getDeclaredConstructor(TProtocol.class);
            //Constructor aConstructor = aClass.getDeclaredConstructor(m_protocol.getClass() );
            ////System.out.println("check 2");


            Object aArgs[] = new Object[1];
            aArgs[0] = m_protocol;
            ////System.out.println("check 3");

            Object aObj = aConstructor.newInstance(aArgs);
            ////System.out.println("check 4");

            m_client = aObj;
            ////System.out.println("tao  xong");
            m_transport.open();
            //System.out.println("mo xong");
        } catch (Exception ex) {
            ////System.out.println("Loi roi exception: " + ex.getMessage() );
            return false;
        }
        return m_transport.isOpen();
    }

    public Boolean isOpen() {
        if (m_transport == null || m_protocol == null || m_client == null) {
            return false;
        }
        return m_transport.isOpen();
    }

    public void close() {
        if (m_transport == null || m_protocol == null || m_client == null) {
            m_transport = null;
            m_protocol = null;
            m_client = null;
            return;
        }
        try {
            m_transport.flush();
            m_transport.close();
            m_transport = null;
            m_protocol = null;
            m_client = null;
        } catch (Exception ex) {
        }
    }

    public boolean sureOpen() {
        if (isOpen()) {
            ////System.out.println("sureOpen mo roi");
            return true;
        }
        close();
        ////System.out.println("close ");
        ////System.out.println("doOpen ");
        return doOpen();
    }

    public void cleanUp() {
        // keep client in 10 min
        if (System.currentTimeMillis() - m_createTime < 600000)
            ClientFactory.releaseClient(this);
        else
            close();
    }
};