package jcommon.transport.client;
import java.util.*;
import java.lang.*;
import org.apache.thrift.protocol.*;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;


public class ClientFactoryTest {

	
    public static void main(String[] args) throws Exception
    {
    	
    	TClientInfo aInfo = ClientFactory.getClient("localhost", 9900, TestClient1.class, TBinaryProtocol.class ) ;
    	TestClient1 aCl = (TestClient1)aInfo.getClient();
    	ClientFactory.releaseClient(aInfo);
    	System.out.println("da release");
    	aInfo = ClientFactory.getClient("localhost", 9900, TestClient1.class, TBinaryProtocol.class ) ;
    	System.out.println("da get lai");

    	ClientFactory.releaseClient(aInfo);
    	System.out.println("da release 2");
    	aInfo = ClientFactory.getClient("localhost", 9900, TestClient1.class, TBinaryProtocol.class ) ;
    	System.out.println("da get lai 2");
    	
    	aInfo = ClientFactory.getClient("localhost", 9900, TestClient1.class, TBinaryProtocol.class ) ;
    	System.out.println("da tao moi");
    	((TestClient1)aInfo.m_client).Test();
    }	
}
