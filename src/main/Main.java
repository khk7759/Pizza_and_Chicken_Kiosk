//작성자 : 길동규
package main;

import buyer.Buyer;
import data.Data;
   
public class Main {
   
   public static Buyer buyer;
   
   public static void main(String[] args){
      
      Data data = new Data();

      buyer = new Buyer();
      
      while(true)
      {  
         buyer.action(data);
      }
   }
}