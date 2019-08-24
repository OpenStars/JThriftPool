/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.storage.keyvalue;


import jcommon.transport.client.ClientFactory;
import jcommon.transport.client.TClientInfo;
import openstars.storage.keyvalue.*;

/**
 *
 * @author trungthanh
 */
public class RemoteKVStorage {
    public boolean isCompactProtocol = false; // default is binary protocol
    private String m_host;
    private int m_port;
    
    public RemoteKVStorage(String host, int port, boolean isCompact)          
    {
        m_host = host;
        m_port = port;
        isCompactProtocol = isCompact;
    }
    
    public RemoteKVStorage(String host, int port)          
    {
        m_host = host;
        m_port = port;
        isCompactProtocol = false;
    }    
    
    TClientInfo getClient()
    {
        if (isCompactProtocol){
            return ClientFactory.getClient(m_host, m_port, KVDataService.Client.class,  org.apache.thrift.protocol.TCompactProtocol.class );            
        }
        else {
            return ClientFactory.getClient(m_host, m_port, KVDataService.Client.class,  org.apache.thrift.protocol.TBinaryProtocol.class );
        }            
    }
    
    public int put(String key, String value){
        TClientInfo aInfo = getClient();
        aInfo.sureOpen();
        int aRes = 0;
        KVDataService.Client aClient = (KVDataService.Client)aInfo.getClient();
        try {
                aRes =  aClient.put(key , value);
        } catch(Exception e) {
            aInfo.close();
            aRes = -1;
        }
        aInfo.cleanUp();
        return aRes;
    }
    
    public String get(String key)
    {
        TClientInfo aInfo = getClient();
        String _return = null;
        aInfo.sureOpen();
        KVDataService.Client aClient = (KVDataService.Client)aInfo.getClient();
        try {
                _return = aClient.get(key );
        } catch(Exception e) {
            aInfo.close();
            aInfo.sureOpen();
        }
        aInfo.cleanUp();
        return _return;
    }
}
