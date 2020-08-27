package seller;

import buyer.Buyer;
import data.Data;
import data.Pizza;
import data.Stock;

public class ChickenMethod {
   Data data;

   public ChickenMethod(Data data) {
      this.data = data;
   }

   public void printChicken() {
      String[] str;
      System.out.println("[치킨]");
      System.out.println();
      for (int i = 0; i < data.getChicken().size(); i++) {
         System.out.format("%d. %-5s\t  %,36d원\n", (i + 1), data.getChicken().get(i).getName(), data.getChicken().get(i).getPrice());
      }
      System.out.print(Buyer.printLine);
      System.out.println("- 추가 (1,치킨 명, 가격)");
      System.out.println("- 수정 (2,수정할 치킨 번호,수정할 가격)");
      System.out.println("- 삭제 (3,치킨 번호)");
      System.out.print(Buyer.message_1);
      str = data.inputString().split(",");
      
      switch (Integer.parseInt(str[0])) {
      case 1:
        Buyer.cleaner();
        if(data.getChicken().size()<10)
         chickenAdd(str);
         printChicken();
         break;
      case 2:
        Buyer.cleaner();
         chichenModify(str);
         printChicken();
         break;
      case 3:
        Buyer.cleaner();
         chichenDelete(str);
         printChicken();
         break;
      }

   }
   
   void chickenAdd(String[] str) {
      data.getChicken().add(new Stock(str[1], Integer.parseInt(str[2])));
      
//=========================================================================3.13 기혜 추가      
      data.copyTimeSaleChicken(new Stock(str[1], Integer.parseInt(str[2])));
      
      
//-----------------------------------------------------------------------------------------------      
      
   }
   
   void chichenModify(String[] str) {
      int num = Integer.parseInt(str[1]);
      data.getChicken().get(num - 1).setPrice(Integer.parseInt(str[2]));
   }
   
   void chichenDelete(String[] str) {
      int num = Integer.parseInt(str[1]);
      data.getChicken().remove(num - 1);
   }
   
   
}