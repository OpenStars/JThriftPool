package jcommon.transport.client;
import org.apache.thrift.*;
import org.apache.thrift.protocol.*;
import java.lang.System;
public class TestClient2  {
	static int aRefCount = 0;
	TestClient2(TProtocol proto)
	{
		System.out.println("constructor 1 " + proto.getClass().getName() );
		aRefCount++;
		
	}
}
