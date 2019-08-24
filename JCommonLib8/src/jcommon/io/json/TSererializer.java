package jcommon.io.json;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.thrift.protocol.*;
import org.apache.thrift.*;
import org.apache.thrift.transport.*;

import java.lang.String;
import java.util.List;

public class TSererializer {

//    public TMemoryBuffer m_buffer;
//    public TProtocol m_protocol;
//
//    public ThriftJsonUtil() {
//        m_buffer = new TMemoryBuffer(128);
//        m_protocol = new TSimpleJSONProtocol(m_buffer);
//        m_buffer.open();
//
//    }
//
//    private <T extends TBase> void write(T obj) {
//        try {
//            obj.write(m_protocol);
//        } catch (TException ex) {
//        }
//    }
    static public <T extends TBase> void Deserialize(T obj, String data) {
        org.apache.thrift.transport.TMemoryInputTransport aBuffer = null;
        try {
            aBuffer = new org.apache.thrift.transport.TMemoryInputTransport(data.getBytes("iso-8859-1"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(TSererializer.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        TProtocol aProtocol = new TSimpleJSONProtocol(aBuffer);
        try {
            aBuffer.open();
        } catch (TTransportException e1) {
            e1.printStackTrace();
        }
        try {
            obj.read(aProtocol);
        } catch (TException e) {
            e.printStackTrace();
        }
    }

    public static <T extends TBase> String Serialize(T obj) {
        TMemoryBuffer buffer = new TMemoryBuffer(128);
        TProtocol protocol = new TSimpleJSONProtocol(buffer);
        buffer.open();
        try {
            obj.write(protocol);
        } catch (TException ex) {
            Logger.getLogger(TSererializer.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        try {
            return new String(buffer.getArray(), 0, buffer.length(), "iso-8859-1");
        } catch (Exception ex) {
        }
        return null;

    }

    static public <T extends TBase> String Serialize(List<T> list) {
        TMemoryBuffer buffer = new TMemoryBuffer(128);
        TProtocol protocol = new TSimpleJSONProtocol(buffer);
        buffer.open();

        //
        try {
            protocol.writeListBegin(new TList(TType.STRUCT, list.size()));
            for (T aIterator : list) {
                aIterator.write(protocol);
            }
            protocol.writeListEnd();
            ////
        } catch (TException ex) {
        }
        try {
            //return m_buffer.toString(new String(""));//return new String( m_buffer.getBuffer() );
            return new String(buffer.getArray(), 0, buffer.length());
        } catch (Exception ex) {
            System.out.println("Loi");
        }
        return null;
    }
//
//    private <T extends TBase> String serializeObject(T obj) {
//        write(obj);
//        try {
//            return new String(m_buffer.getArray(), 0, m_buffer.length() ,"iso-8859-1" );
//        } catch (Exception ex) {
//        }
//        return null;
//    }
//    
//	public <T extends TBase> String serializeObject(List<T> list)
//	{
//		//
//		try {
//		m_protocol.writeListBegin(new TList(TType.STRUCT, list.size()));
//        for (T aIterator : list)
//        {
//        	aIterator.write(m_protocol);
//        }
//        m_protocol.writeListEnd();		
//		////
//		}
//		catch(TException ex)
//		{
//			
//		}
//		try 
//		{
//			//return m_buffer.toString(new String(""));//return new String( m_buffer.getBuffer() );
//			return new String (m_buffer.getArray() , 0, m_buffer.length() );
//		} catch( Exception ex )
//		{
//				System.out.println("Loi");
//		}
//		return null;
//	} 	
//	
}
