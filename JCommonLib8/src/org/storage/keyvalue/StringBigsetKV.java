/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.storage.keyvalue;

import jcommon.transport.client.ClientFactory;
import jcommon.transport.client.TClientInfo;
import openstars.storage.bigset.*;

/**
 *
 * @author trungthanh
 */
public class StringBigsetKV {
     public boolean isCompactProtocol = false; // default is binary protocol
    private String m_host;
    private int m_port;
   
    
    public StringBigsetKV(String host, int port, boolean isCompact)          
    {
        m_host = host;
        m_port = port;
        isCompactProtocol = isCompact;
    }
    
    public StringBigsetKV(String host, int port)          
    {
        m_host = host;
        m_port = port;
        isCompactProtocol = false;
    }    
    
    TClientInfo getClient()
    {
        if (isCompactProtocol){
            return ClientFactory.getClient(m_host, m_port, TStringBigSetKVService.Client.class,  org.apache.thrift.protocol.TCompactProtocol.class );            
        }
        else {
            return ClientFactory.getClient(m_host, m_port, TStringBigSetKVService.Client.class,  org.apache.thrift.protocol.TBinaryProtocol.class );
        }            
    }
    
    public TPutItemResult putItem(String bsKey,  TItem item ) {
        TClientInfo aInfo = getClient();
        aInfo.sureOpen();
        TPutItemResult aRes ;
        TStringBigSetKVService.Client aClient = (TStringBigSetKVService.Client)aInfo.getClient();
        try {
            aRes =  aClient.bsPutItem(bsKey, item);
        } catch(Exception e) {
            
            aInfo.close();
            //retry
            aInfo = getClient();
            aInfo.sureOpen();
           
            aClient = (TStringBigSetKVService.Client)aInfo.getClient();
            try {
                aRes =  aClient.bsPutItem(bsKey, item);
            } catch(Exception e2) {
                aRes = new TPutItemResult();
                aRes.ok = false;
                aRes.error = TErrorCode.EUnknownException;
                return aRes; // Ignore error connection 
            }
        }
        aInfo.cleanUp();
        return aRes;
       
    }
    
    public TItemResult getItem(java.lang.String bsKey, java.nio.ByteBuffer itemKey) {
        TClientInfo aInfo = getClient();
        aInfo.sureOpen();
        TItemResult aRes ;
        TStringBigSetKVService.Client aClient = (TStringBigSetKVService.Client)aInfo.getClient();
        try {
            aRes = aClient.bsGetItem(bsKey, itemKey);
        } catch(Exception e) {
            
            aInfo.close();
            //retry
            aInfo = getClient();
            aInfo.sureOpen();
           
            aClient = (TStringBigSetKVService.Client)aInfo.getClient();
            try {
                aRes =  aClient.bsGetItem(bsKey, itemKey);
            } catch(Exception e2) {
                aRes = new TItemResult();               
                aRes.error = TErrorCode.EUnknownException;
                return aRes; // Ignore error connection 
            }
        }
        aInfo.cleanUp();
        return aRes;
      
    }
    
    public long getTotalCount(java.lang.String bsKey) {
        TClientInfo aInfo = getClient();
        aInfo.sureOpen();
        long aRes ;
        TStringBigSetKVService.Client aClient = (TStringBigSetKVService.Client)aInfo.getClient();
        try {
            aRes = aClient.getTotalCount(bsKey);
        } catch(Exception e) {
            
            aInfo.close();
            //retry
            aInfo = getClient();
            aInfo.sureOpen();
           
            aClient = (TStringBigSetKVService.Client)aInfo.getClient();
            try {
                aRes =  aClient.getTotalCount(bsKey);
            } catch(Exception e2) {
                aRes = -1;
                return aRes; // Ignore error connection 
            }
        }
        aInfo.cleanUp();
        return aRes;
    }
    
    public TItemSetResult getSlice(java.lang.String bsKey, int fromPos, int count)
    {
        TClientInfo aInfo = getClient();
        aInfo.sureOpen();
        TItemSetResult aRes ;
        TStringBigSetKVService.Client aClient = (TStringBigSetKVService.Client)aInfo.getClient();
        try {
            aRes = aClient.bsGetSlice(bsKey, fromPos, count);
        } catch(Exception e) {
            
            aInfo.close();
            //retry
            aInfo = getClient();
            aInfo.sureOpen();
           
            aClient = (TStringBigSetKVService.Client)aInfo.getClient();
            try {
                aRes =   aClient.bsGetSlice(bsKey, fromPos, count);
            } catch(Exception e2) {
                aRes = new TItemSetResult();               
                aRes.error = TErrorCode.EUnknownException;
                return aRes; // Ignore error connection 
            }
        }
        aInfo.cleanUp();
        return aRes;        
    }

    public TItemSetResult getSliceFromItem(java.lang.String bsKey, java.nio.ByteBuffer fromKey, int count) 
    {
        TClientInfo aInfo = getClient();
        aInfo.sureOpen();
        TItemSetResult aRes ;
        TStringBigSetKVService.Client aClient = (TStringBigSetKVService.Client)aInfo.getClient();
        try {
            aRes = aClient.bsGetSliceFromItem(bsKey, fromKey, count);
        } catch(Exception e) {
            
            aInfo.close();
            //retry
            aInfo = getClient();
            aInfo.sureOpen();
           
            aClient = (TStringBigSetKVService.Client)aInfo.getClient();
            try {
                aRes = aClient.bsGetSliceFromItem(bsKey, fromKey, count);
            } catch(Exception e2) {
                aRes = new TItemSetResult();               
                aRes.error = TErrorCode.EUnknownException;
                return aRes; // Ignore error connection 
            }
        }
        aInfo.cleanUp();
        return aRes;              
    }

    public TItemSetResult getSliceR(java.lang.String bsKey, int fromPos, int count)
    {
        TClientInfo aInfo = getClient();
        aInfo.sureOpen();
        TItemSetResult aRes ;
        TStringBigSetKVService.Client aClient = (TStringBigSetKVService.Client)aInfo.getClient();
        try {
            aRes = aClient.bsGetSliceR(bsKey, fromPos, count);
        } catch(Exception e) {
            
            aInfo.close();
            //retry
            aInfo = getClient();
            aInfo.sureOpen();
           
            aClient = (TStringBigSetKVService.Client)aInfo.getClient();
            try {
                aRes =   aClient.bsGetSliceR(bsKey, fromPos, count);
            } catch(Exception e2) {
                aRes = new TItemSetResult();               
                aRes.error = TErrorCode.EUnknownException;
                return aRes; // Ignore error connection 
            }
        }
        aInfo.cleanUp();
        return aRes;          
    }

    public TItemSetResult getSliceFromItemR(java.lang.String bsKey, java.nio.ByteBuffer fromKey, int count) 
    {
        TClientInfo aInfo = getClient();
        aInfo.sureOpen();
        TItemSetResult aRes ;
        TStringBigSetKVService.Client aClient = (TStringBigSetKVService.Client)aInfo.getClient();
        try {
            aRes = aClient.bsGetSliceFromItemR(bsKey, fromKey, count);
        } catch(Exception e) {
            
            aInfo.close();
            //retry
            aInfo = getClient();
            aInfo.sureOpen();
           
            aClient = (TStringBigSetKVService.Client)aInfo.getClient();
            try {
                aRes = aClient.bsGetSliceFromItemR(bsKey, fromKey, count);
            } catch(Exception e2) {
                aRes = new TItemSetResult();               
                aRes.error = TErrorCode.EUnknownException;
                return aRes; // Ignore error connection 
            }
        }
        aInfo.cleanUp();
        return aRes;
    }

    public TItemSetResult rangeQuery(java.lang.String bsKey, java.nio.ByteBuffer startKey,
            java.nio.ByteBuffer endKey) 
    {
        TClientInfo aInfo = getClient();
        aInfo.sureOpen();
        TItemSetResult aRes ;
        TStringBigSetKVService.Client aClient = (TStringBigSetKVService.Client)aInfo.getClient();
        try {
            aRes = aClient.bsRangeQuery(bsKey, startKey, endKey);
        } catch(Exception e) {
            
            aInfo.close();
            //retry
            aInfo = getClient();
            aInfo.sureOpen();
           
            aClient = (TStringBigSetKVService.Client)aInfo.getClient();
            try {
                aRes = aClient.bsRangeQuery(bsKey, startKey, endKey);
            } catch(Exception e2) {
                aRes = new TItemSetResult();               
                aRes.error = TErrorCode.EUnknownException;
                return aRes; // Ignore error connection 
            }
        }
        aInfo.cleanUp();
        return aRes;        
    }

}
