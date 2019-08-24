package jcommon.transport.client;
import java.util.*;
import java.lang.*;
import java.lang.reflect.*;
import org.apache.thrift.*;
import org.apache.thrift.protocol.*;
import org.apache.thrift.transport.*;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;;

public class ClientFactory  {
	// need object pool here

	
	static HashMap < String , Stack<TClientInfo> > m_clients = new HashMap < String , Stack<TClientInfo> > ();
	static HashMap< String , TProtocolFactory > m_factories = new HashMap< String , TProtocolFactory > ();
	static ReentrantLock m_lock = new ReentrantLock();
	static public void setFactory(String host, int port, Class clientClass , TProtocolFactory protocolFactory)
	{
		m_lock.lock();
		m_factories.put( getKey(host , port , clientClass) , protocolFactory);
		m_lock.unlock();
	}
	
	public static TProtocolFactory getProtocolFactory(String host, int port, Class clientClass)
	{
		String aKey = getKey(host, port, clientClass);
		TProtocolFactory aResult;
		m_lock.lock();
		aResult = m_factories.get(aKey);	
		m_lock.unlock();
		return aResult;
	}
	
	static private String getKey(String host, int port, Class clientClass)
	{
		return clientClass.getName() + "_" + host + Integer.toString(port);
	}

	public static TClientInfo fastGetClient(String host, int port, Class clientClass)
	{
		m_lock.lock();
		
		String aKey = getKey(host, port, clientClass);
		Stack<TClientInfo> aContainer = m_clients.get(aKey);
		TClientInfo aResult;
		if (aContainer == null)
			aResult = null;
		else if (aContainer.empty())
			aResult = null;
		else aResult = aContainer.pop();
		m_lock.unlock();
		return aResult;
	}
	
	public static TClientInfo getClient(String host, int port, Class clientClass, Class protocolClass)
	{
		TClientInfo aInfo = fastGetClient(host, port, clientClass);
		if (aInfo != null)
			return aInfo;
		aInfo = new TClientInfo( host,  port,  clientClass,  protocolClass);
		return aInfo;
	}
	
	static void releaseClient(TClientInfo aClientInfo)
	{
		m_lock.lock();
				
		String aKey = getKey(aClientInfo.m_host, aClientInfo.m_port, aClientInfo.m_clientClass);
		Stack<TClientInfo> aContainer = m_clients.get(aKey);
		if (aContainer == null)
		{
			aContainer = new Stack<TClientInfo>();
			aContainer.push(aClientInfo);
			m_clients.put(aKey , aContainer);
			m_lock.unlock();

			return;
		}
		aContainer.push(aClientInfo);
		m_lock.unlock();		
	}



}
