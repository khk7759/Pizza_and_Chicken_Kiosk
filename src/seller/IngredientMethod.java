/**
 * Date : 2020. 3. 10.
 * Writer : Choi Cheol Nyeong
 * Contents : 재료 메소드 구성 
 */
package seller;

import java.util.ArrayList;

import buyer.Buyer;
import data.Data;
import data.Stock;   


public class IngredientMethod {
   Data data;

   public IngredientMethod(Data data) {
      this.data = data;
   }

   public void printIngredient() {
      String[] str;
      System.out.println("[재료]");
      System.out.println();
      System.out.println("1. 치즈");
      System.out.println("2. 피자 소스");
      System.out.println("3. 재료");
      System.out.println("4. 도우");
      System.out.print(Buyer.printLine);
      System.out.println("추가 (재료 번호) ");
      System.out.print(Buyer.message_1);
      str = data.inputString().split(",");

      switch (Integer.parseInt(str[0])) {
      case 1:
         Buyer.cleaner();
         cheesePirnt();
         break;
      case 2:
         Buyer.cleaner();
         sausePrint();
         break;
      case 3:
         Buyer.cleaner();
         ingredientPrint();
         break;
      case 4:
         Buyer.cleaner();
         doughPrint();
         break;
      }

   }

   void cheesePirnt() {
      String [] str;
      System.out.println("[치즈]");
      System.out.println();
      System.out.println("");
      for (int i = 0; i < data.getCheese().size(); i++) {
         System.out.format("%d %-5s\t  %,36d\n", i + 1, data.getCheese().get(i).getName(),data.getCheese().get(i).getPrice());
      }
      System.out.print(Buyer.printLine);

      System.out.println("추가 (1, 재료이름, 가격)");
      System.out.println("삭제 (2, 재료 번호)");
      System.out.print(Buyer.message_1);
      str = data.inputString().split(",");
      
         
         switch (Integer.parseInt(str[0])) {
         case 1:
            addStock(str, data.getCheese());
            break;
         case 2:
            deleteStock(str, data.getCheese());
            break;
         }

   }

   void sausePrint() {
      String [] str;
      System.out.println("[피자소스]");
      System.out.println();
      System.out.println("");
      for (int i = 0; i < data.getSauce().size(); i++) {
         System.out.format("%d %-5s\t  %,36d\n", i + 1, data.getSauce().get(i).getName(),data.getSauce().get(i).getPrice());
      }
      System.out.print(Buyer.printLine);

      System.out.println("추가 (1, 재료이름, 가격)");
      System.out.println("삭제 (2, 재료 번호)");
      System.out.print(Buyer.message_1);
      str = data.inputString().split(",");
      switch (Integer.parseInt(str[0])) {
         case 1:
            addStock(str, data.getSauce());
            break;
         case 2:
            deleteStock(str, data.getSauce());
            break;
         }

   }

   void ingredientPrint() {
	   int count=0;
      String str[];
      System.out.println("[재료]");
      System.out.println();
      System.out.println("");
      for (int i = 0; i < data.getIngredient().size(); i++) {
    	  count++;
         if(i%2==0)
         System.out.format("%d. %-6s\t  %,8d  ", i + 1, data.getIngredient().get(i).getName(),data.getIngredient().get(i).getPrice());
         else
            System.out.format("%d. %-8s\t  %,5d\n", i + 1, data.getIngredient().get(i).getName(),data.getIngredient().get(i).getPrice());   
      }
      if(count%2!=0)
          System.out.println();

      System.out.print(Buyer.printLine);

      System.out.println("추가 (1, 재료이름, 가격)");
      System.out.println("삭제 (2, 재료 번호)");
      System.out.print(Buyer.message_1);
      str = data.inputString().split(",");
      switch (Integer.parseInt(str[0])) {
         case 1:
            addStock(str, data.getIngredient());
            break;
         case 2:
            deleteStock(str, data.getIngredient());
            break;
         }

   }
   
   void doughPrint()
   {
      String str[];
      System.out.println("[도우]\n\n");
      for (int i = 0; i < data.getDough().size(); i++) {
         System.out.format("%d %-5s\t  %,36d\n", i + 1, data.getDough().get(i).getName(),data.getDough().get(i).getPrice());
      }
      System.out.print(Buyer.printLine);

      System.out.println("추가 (1, 재료이름, 가격)");
      System.out.println("삭제 (2, 재료 번호)");
      System.out.print(Buyer.message_1);
      str = data.inputString().split(",");
      switch (Integer.parseInt(str[0])) {
         case 1:
            addStock(str, data.getDough());
            break;
         case 2:
            deleteStock(str, data.getDough());
            break;
         }
   }
   
   void addStock(String[] str,ArrayList<Stock> list) {
         list.add(new Stock(str[1], Integer.parseInt(str[2])));
         Buyer.cleaner();
         printIngredient();
      }
      
      void modifyStock(String[] str,ArrayList<Stock> list) {
         int num = Integer.parseInt(str[1]);
         list.get(num - 1).setPrice(Integer.parseInt(str[2]));
         Buyer.cleaner();
         printIngredient();
      }
      
      void deleteStock(String[] str,ArrayList<Stock> list) {
         int num = Integer.parseInt(str[1]);
         list.remove(num - 1);
         Buyer.cleaner();
         printIngredient();
      }

}