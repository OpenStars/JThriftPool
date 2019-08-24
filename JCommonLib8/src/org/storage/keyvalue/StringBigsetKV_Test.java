/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.storage.keyvalue;

import openstars.storage.bigset.*;

/**
 *
 * @author trungthanh
 */
public class StringBigsetKV_Test {
    static long startTime;
    static long totalRunned = 0;
    static int testNum = 100000;
    static long totalReadRunned = 0;
    
    static class internalThread implements Runnable{
        String bsName = "testBS";
        internalThread(String aBsName){
            bsName = aBsName;
        }
        
        void doWrite(){
            StringBigsetKV aKV = new StringBigsetKV("127.0.0.1", 17407);
            long startTime = System.currentTimeMillis();
            for (int i =0 ; i < testNum; i++ , totalRunned ++ ){
                TItem aItem = new TItem();
                aItem.setKey(Integer.toString(i).getBytes());
                aItem.setValue((Integer.toString(i) + "_Value").getBytes() );
                aKV.putItem(bsName, aItem);
                if ( i % 1000 == 999){
                    long timeRunned = System.currentTimeMillis() - startTime;
                    System.out.println("Single Thread Done "+ (i+1) +" items in " + (timeRunned) + " ms rate " + (i * 1000/timeRunned) + " rps" );
                    System.out.println("Total Done "+ (totalRunned+1) +" items in " + (timeRunned) + " ms rate " + (totalRunned * 1000/timeRunned) + " rps" );
                }


            }            
        }
        
        void doRead(){
            // test read
            StringBigsetKV aKV = new StringBigsetKV("127.0.0.1", 17407);
            long startReadTime = System.currentTimeMillis();
            for (int i =0 ; i < testNum; i++ , totalReadRunned ++ ){
                TItemResult aRes = aKV.getItem(bsName,  java.nio.ByteBuffer.wrap(Integer.toString(i).getBytes()) );
                if (aRes.error != TErrorCode.EGood
                        || !aRes.item.value.equals( java.nio.ByteBuffer.wrap( ( (Integer.toString(i) + "_Value").getBytes())  ) ) ){
                    System.out.println("Error get key for "+i);
                }
                
                if ( i % 1000 == 999){
                    long timeRunned = System.currentTimeMillis() - startReadTime;
                    System.out.println("Single Thread Read  "+ (i+1) +" items in " + (timeRunned) + " ms rate " + (i * 1000/timeRunned) + " rps" );
                    System.out.println("Total Read "+ (totalReadRunned+1) +" items in " + (timeRunned) + " ms rate " + (totalReadRunned * 1000/timeRunned) + " rps" );
                }
                
            }
            System.out.println("Total count: " + aKV.getTotalCount("testBS") );

        }
        
        public void run(){
              
//            doWrite();
            
            doRead();
            
        }
        

    };
    
   
    
    public static void main(String[] args) {
        
        long startTime = System.currentTimeMillis();
        Thread aThread1 = new Thread(new internalThread("bigset1") );
        aThread1.start();
        
        Thread aThread2 = new Thread(new internalThread("bigset2") );
        aThread2.start();
        Thread aThread3 = new Thread(new internalThread("bigset3") );
        aThread3.start();
        Thread aThread4 = new Thread(new internalThread("bigset4") );
        aThread4.start();
        
        try {
            aThread1.join();
            aThread2.join();
            aThread3.join();
            aThread4.join();
        } catch(Exception e){
            
        }

        
    }
}
