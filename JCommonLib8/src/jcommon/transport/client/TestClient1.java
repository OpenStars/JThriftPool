package jcommon.transport.client;
import org.apache.thrift.*;
import org.apache.thrift.protocol.*;
import java.lang.System;
public class TestClient1  {
	static int aRefCount = 0;
	
	TestClient1(TProtocol proto)
	{
		System.out.println("constructor 1 " + proto.getClass().getName() );
		System.out.println(Integer.toString(aRefCount));
		aRefCount++;
		
	}
	
	public void Test()
	{
		System.out.println("Ref count is : "+Integer.toString(aRefCount));
		
	}
}
