/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package openstars.log.simplelog;

/**
 *
 * @author trungthanh
 */
public class SimpleLogger_Test {
     public static void main(String[] args) {
         SimpleLogger aLogger = new SimpleLogger("127.0.0.1", 9897 , true);
         try {
            aLogger.log2("Shop_Selling_", "10\tprice_100\ttotal_1000");
         } catch (Exception e){
             
         }
     }
}
