/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vtp.platform.profile;

import jcommon.transport.client.ClientFactory;
import jcommon.transport.client.TClientInfo;
import openstars.platform.profile.*;

/**
 *
 * @author trungthanh
 */
public class VTPProfileServiceClient {
    public boolean isCompactProtocol = false; // default is binary protocol
    private String m_host;
    private int m_port;
    
    public VTPProfileServiceClient(String host, int port, boolean isCompact)          
    {
        m_host = host;
        m_port = port;
        isCompactProtocol = isCompact;
    }
    
    public VTPProfileServiceClient(String host, int port)          
    {
        m_host = host;
        m_port = port;
        isCompactProtocol = false;
    }    
    
    TClientInfo getClient()
    {
        if (isCompactProtocol){
            return ClientFactory.getClient(m_host, m_port, TPlatformProfileService.Client.class,  org.apache.thrift.protocol.TCompactProtocol.class );            
        }
        else {
            return ClientFactory.getClient(m_host, m_port, TPlatformProfileService.Client.class,  org.apache.thrift.protocol.TBinaryProtocol.class );
        }            
    }
    
    public TErrorCode putData(long key, TPlatformProfile data) 
    {
        TClientInfo aInfo = getClient();
        aInfo.sureOpen();
        TErrorCode aRes ;
        TPlatformProfileService.Client aClient = (TPlatformProfileService.Client)aInfo.getClient();
        try {
            aRes =  aClient.putData(key, data);
        } catch(Exception e) {
            
            aInfo.close();
            //retry
            aInfo = getClient();
            aInfo.sureOpen();
           
            aClient = (TPlatformProfileService.Client)aInfo.getClient();
            try {
                aRes =   aClient.putData(key, data);
            } catch(Exception e2) {
                aRes = TErrorCode.EUnknown;
                return aRes; // Ignore error connection 
            }
        }
        aInfo.cleanUp();
        return aRes;        
    }

    public TDataResult getData(long key) {
        TClientInfo aInfo = getClient();
        aInfo.sureOpen();
        TDataResult aRes ;
        TPlatformProfileService.Client aClient = (TPlatformProfileService.Client)aInfo.getClient();
        try {
            aRes =  aClient.getData(key);
        } catch(Exception e) {
            
            aInfo.close();
            //retry
            aInfo = getClient();
            aInfo.sureOpen();
           
            aClient = (TPlatformProfileService.Client)aInfo.getClient();
            try {
                aRes =   aClient.getData(key);
            } catch(Exception e2) {
                aRes = new TDataResult();
                aRes.errorCode = TErrorCode.EUnknown;
                aRes.data = null;
                return aRes; // Ignore error connection 
            }
        }
        aInfo.cleanUp();
        return aRes;       
    }

    public java.lang.String setExtData(long uid, java.lang.String extKey, java.lang.String extValue) 
    {
        TClientInfo aInfo = getClient();
        aInfo.sureOpen();
        String aRes = null;
        TPlatformProfileService.Client aClient = (TPlatformProfileService.Client)aInfo.getClient();
        try {
            aRes =  aClient.setExtData(uid, extKey, extValue);
        } catch(Exception e) {
            
            aInfo.close();
            //retry
            aInfo = getClient();
            aInfo.sureOpen();
           
            aClient = (TPlatformProfileService.Client)aInfo.getClient();
            try {
                aRes =  aClient.setExtData(uid, extKey, extValue);
            } catch(Exception e2) {
               
               return aRes; // Ignore error connection 
            }
        }
        aInfo.cleanUp();
        return aRes;       
        
    }

    public java.lang.String getExtData(long uid, java.lang.String extKey){
        TClientInfo aInfo = getClient();
        aInfo.sureOpen();
        String aRes = null;
        TPlatformProfileService.Client aClient = (TPlatformProfileService.Client)aInfo.getClient();
        try {
            aRes =  aClient.getExtData(uid, extKey);
        } catch(Exception e) {
            
            aInfo.close();
            //retry
            aInfo = getClient();
            aInfo.sureOpen();
           
            aClient = (TPlatformProfileService.Client)aInfo.getClient();
            try {
                aRes =   aClient.getExtData(uid, extKey);
            } catch(Exception e2) {
               return aRes; // Ignore error connection 
            }
        }
        aInfo.cleanUp();
        return aRes;   
    }

    
}
