/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package openstars.log.simplelog;


import jcommon.transport.client.ClientFactory;
import jcommon.transport.client.TClientInfo;
/**
 *
 * @author trungthanh
 */
public class SimpleLogger {
    public boolean isCompactProtocol = false; // default is binary protocol
    private String m_host;
    private int m_port;
    
    public SimpleLogger(String host, int port, boolean isCompact)          
    {
        m_host = host;
        m_port = port;
        isCompactProtocol = isCompact;
    }
    
    public SimpleLogger(String host, int port)          
    {
        m_host = host;
        m_port = port;
        isCompactProtocol = false;
    }
    
    TClientInfo getClient()
    {
        if (isCompactProtocol){
            return ClientFactory.getClient(m_host, m_port, SimpleLogService.Client.class,  org.apache.thrift.protocol.TCompactProtocol.class );            
        }
        else {
            return ClientFactory.getClient(m_host, m_port, SimpleLogService.Client.class,  org.apache.thrift.protocol.TBinaryProtocol.class );
        }            
    }
    
   
    public void log(java.lang.String aLog) throws org.apache.thrift.TException
    {
        TClientInfo aInfo = getClient();
        aInfo.sureOpen();
        int aRes = 0;
        SimpleLogService.Client aClient = (SimpleLogService.Client)aInfo.getClient();
        try {
                aClient.log(aLog);
        } catch(Exception e) {
        
        }
        aInfo.cleanUp();
        
    }

    public void multiLog(java.util.List<java.lang.String> aLogs) throws org.apache.thrift.TException{
        TClientInfo aInfo = getClient();
        aInfo.sureOpen();
        int aRes = 0;
        SimpleLogService.Client aClient = (SimpleLogService.Client)aInfo.getClient();
        try {
                aClient.multiLog(aLogs);
        } catch(Exception e) {
        
        }
        aInfo.cleanUp();        
    }

    public void logOneway(java.lang.String aLog) throws org.apache.thrift.TException{
        TClientInfo aInfo = getClient();
        aInfo.sureOpen();
        int aRes = 0;
        SimpleLogService.Client aClient = (SimpleLogService.Client)aInfo.getClient();
        try {
                aClient.logOneway(aLog);
        } catch(Exception e) {
        
        }
        aInfo.cleanUp();              
    }

    public void multiLogOneway(java.util.List<java.lang.String> aLog) throws org.apache.thrift.TException{
        TClientInfo aInfo = getClient();
        aInfo.sureOpen();
        int aRes = 0;
        SimpleLogService.Client aClient = (SimpleLogService.Client)aInfo.getClient();
        try {
                aClient.multiLogOneway(aLog);
        } catch(Exception e) {
        
        }
        aInfo.cleanUp();         
    }

    public void log2(java.lang.String category, java.lang.String aLog) throws org.apache.thrift.TException{
        TClientInfo aInfo = getClient();
        aInfo.sureOpen();
        int aRes = 0;
        SimpleLogService.Client aClient = (SimpleLogService.Client)aInfo.getClient();
        try {
                aClient.log2(category, aLog);
        } catch(Exception e) {
        
        }
        aInfo.cleanUp();         
    }

    public void logOneway2(java.lang.String category, java.lang.String aLog){
        TClientInfo aInfo = getClient();
        aInfo.sureOpen();
        int aRes = 0;
        SimpleLogService.Client aClient = (SimpleLogService.Client)aInfo.getClient();
        try {
                aClient.logOneway2(category, aLog);
        } catch(Exception e) {
        
        }
        aInfo.cleanUp();             
    }
}
