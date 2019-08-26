/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vtppassportsample;

import openstars.platform.profile.TDataResult;
import openstars.platform.profile.TPlatformProfile;
import vtp.platform.profile.*;

import java.sql.*;  

/**
 *
 * @author trungthanh
 */
public class VTPPassportSample {
    static int numTest = 250000;
    static long startTime = 0;
    static long totalRunned = 0;
    static long totalReadRunned = 0;
    
      
    static class internalThread implements Runnable{
        long offset = 0;
        internalThread(long startID){
            offset = startID;
        }
        
        void doWrite(){
            long startTime = System.currentTimeMillis();
            
            VTPProfileServiceClient aClient = new VTPProfileServiceClient("127.0.0.1", 8879, true); // Todo: Sửa port cho đúng 
            for (long i = offset; i < offset+numTest; i ++ ,totalRunned ++){
                TPlatformProfile aProfile = new TPlatformProfile();
                aProfile.displayName = "VTP User "+i;
                aProfile.trustedEmails = new java.util.HashMap<java.lang.String,java.lang.Boolean>();
                aProfile.trustedEmails.put("vtpuser_"+ i +"_mail@vtp.vn", true);
                aProfile.username = "vtpuser_" + i;
                aClient.putData(i, aProfile);

                if ( i % 1000 == 999){
                    long timeRunned = System.currentTimeMillis() - startTime;
                    System.out.println("Single Thread Done "+ (i - offset) +" items in " + (timeRunned) + " ms rate " + ( (i-offset) * 1000/timeRunned) + " rps" );
                    System.out.println("Total Done "+ (totalRunned+1) +" items in " + (timeRunned) + " ms rate " + (totalRunned * 1000/timeRunned) + " rps" );
                }

            }       
        
         
        }
        
        void doRead(){
            //testRead
            VTPProfileServiceClient aClient = new VTPProfileServiceClient("127.0.0.1", 8879, true); // Todo: Sửa port cho đúng 

            long startTime = System.currentTimeMillis();
            
            for (long i = offset; i < numTest+ offset; i ++ , totalReadRunned++ ){
                TDataResult aResult = aClient.getData(i);
                if (aResult.data == null || !aResult.data.username.equals("vtpuser_" + i)){
                    System.out.println("Get Data failed "+i);
                }
                if ( i % 1000 == 999){
                    long timeRunned = System.currentTimeMillis() - startTime;
                    System.out.println("Single Thread Read "+ (i-offset+1) +" items in " + (timeRunned) + " ms rate " + ( (i-offset) * 1000/timeRunned) + " rps" );
                    System.out.println("Total Read Done "+ (totalReadRunned+1) +" items in " + (timeRunned) + " ms rate " + (totalReadRunned * 1000/timeRunned) + " rps" );
                }
            }

          
        }
        
        public void run(){
              
            doWrite();
            
            doRead();
            
        }
        

        
    };
    
    static class MySQLTest implements Runnable{
        long offset = 0;
        public MySQLTest(int aStartID){
            offset = aStartID;
        }
        
        void doWrite(){
            try{  
                startTime = System.currentTimeMillis();
                Class.forName("com.mysql.jdbc.Driver");  
                Connection con=DriverManager.getConnection(  
                "jdbc:mysql://localhost:3306/vtp","vtp","vtppwd");  
                //here sonoo is database name, root is username and password  
                for (long i = offset; i< offset + numTest; i++, totalRunned++){
                    Statement stmt = con.createStatement();  
                    String query = "insert into passportProfile (UID, username, displayname, trustedEmails) VALUES ("
                            + i +","
                            + "\"vtp_user_" + i + "\","
                            + "\"VTP User " + i + "\","
                            + "\"vtp_user_" + i + "@vtp.vn\"" +
                            ");";
//                    System.out.println(query);
                    stmt.executeUpdate(query);
                    
                    if ( i % 1000 == 999){
                        long timeRunned = System.currentTimeMillis() - startTime;
                        System.out.println("Single Thread Write "+ (i-offset+1) +" items in " + (timeRunned) + " ms rate " + ( (i-offset) * 1000/timeRunned) + " rps" );
                        System.out.println("Total Write Done "+ (totalRunned+1) +" items in " + (timeRunned) + " ms rate " + (totalRunned * 1000/timeRunned) + " rps" );
                    }

                }
//                Statement stmt=con.createStatement();  
//                String query =
//                ResultSet rs=stmt.executeQuery("select * from emp");  
//                while(rs.next())  
//                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
//                con.close();  
                
            }
            catch(Exception e){
                System.out.println(e);
            }              
        }
        
        void doRead(){
            try{  
                startTime = System.currentTimeMillis();
                Class.forName("com.mysql.jdbc.Driver");  
                //here sonoo is database name, root is username and password  
                Connection con=DriverManager.getConnection(  
                "jdbc:mysql://localhost:3306/vtp","vtp","vtppwd");  
                for (long i = offset; i< offset + numTest; i++, totalReadRunned++){
                    Statement stmt = con.createStatement();  
                    String query = "select * from passportProfile WHERE (UID="
                            + i + ");";
//                    System.out.println(query);
                    stmt.executeQuery(query);
//                    con.close(); 
                    if ( i % 1000 == 999){
                        long timeRunned = System.currentTimeMillis() - startTime;
                        System.out.println("Single Thread Read "+ (i-offset+1) +" items in " + (timeRunned) + " ms rate " + ( (i-offset) * 1000/timeRunned) + " rps" );
                        System.out.println("Total Read Done "+ (totalReadRunned+1) +" items in " + (timeRunned) + " ms rate " + (totalReadRunned * 1000/timeRunned) + " rps" );
                    }

                }
                
            }
            catch(Exception e){
                System.out.println(e);
            }              
        }
        public void run(){
           doWrite();
           doRead();
        }
    }
    /**
     * @param args the command line arguments
     */
    static void testNoSQL(){
          startTime = System.currentTimeMillis();
        
        // TODO code application logic here
        Thread aThread1 = new Thread(new internalThread(0) );
        aThread1.start();
        
        Thread aThread2 = new Thread(new internalThread(numTest) );
        aThread2.start();
        Thread aThread3 = new Thread(new internalThread(numTest*2) );
        aThread3.start();
        Thread aThread4 = new Thread(new internalThread(numTest*3) );
        aThread4.start();
        
        try {
            aThread1.join();
            aThread2.join();
            aThread3.join();
            aThread4.join();
        } catch(Exception e){
            
        }
    }
    
    static void testMySQL(){
  // TODO code application logic here
        try {
            Thread aThread1 = new Thread(new MySQLTest(0) );
            Thread aThread2 = new Thread(new MySQLTest(numTest) );
            Thread aThread3 = new Thread(new MySQLTest(numTest*2) );
            Thread aThread4 = new Thread(new MySQLTest(numTest*3) );
            aThread1.start();
            aThread2.start();
            aThread3.start();
            aThread4.start();
            aThread1.join();
            aThread2.join();
            aThread3.join();
            aThread4.join();
        } catch (Exception e){
            
        }
    }
    public static void main(String[] args) {
//        testMySQL();
        testNoSQL();
    }
    
}
