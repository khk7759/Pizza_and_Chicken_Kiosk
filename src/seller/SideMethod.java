/**
 * @ 작성자 : 송수진
 * @ 작성일 :2020. 3. 10.
 * @ 설   명 : 판매자모드 > 메뉴추가 > 사이드
 */

package seller;

import java.util.Iterator;

import buyer.Buyer;
import data.Data;
import data.Stock;

public class SideMethod {
   Data data;

   public SideMethod(Data data) {
      this.data = data;
   }

   public void printSide() {
      String[] str;
      System.out.println("[사이드]");
      System.out.println();
      
      // for문 통해서 출력해보기
//      for (int i = 0; i < data.side.size(); i++) {
//         System.out.format("%d. %10s - %,6d원\n", (i + 1), data.side.get(i).name, data.side.get(i).price);
//      }
      
      Iterator<Stock> it = data.getSide().iterator();
      
      int i=0;
      while(it.hasNext()) {
         Stock vo = it.next();
         System.out.format("%d. %-12s\t\t  %,20d원\n", (i + 1), vo.getName(), vo.getPrice());
         i++;
      }
      
      System.out.print(Buyer.printLine);
      System.out.println("- 추가 (1,사이드 명, 가격)");
      System.out.println("- 수정 (2,수정할 사이드 번호,수정할 가격)");
      System.out.println("- 삭제 (3,사이드 번호)");
      System.out.print(Buyer.message_1);
      str = data.inputString().split(",");
      
      switch (Integer.parseInt(str[0])) {
      case 1:
    	  if(data.getSide().size()<10)
         sideAdd(str);
    	  //printSide();
         break;
      case 2:
         sideModify(str); 
        // printSide();
         break;
      case 3:
         sideDelete(str);
         //printSide();
         break;
      }

   }
   
   void sideAdd(String[] str) {
      data.getSide().add(new Stock(str[1], Integer.parseInt(str[2])));
      Buyer.cleaner();
      printSide();
   }
   
   void sideModify(String[] str) {
      int num = Integer.parseInt(str[1]);
      data.getSide().get(num - 1).setPrice(Integer.parseInt(str[2]));
      Buyer.cleaner();
      printSide();
   }
   
   void sideDelete(String[] str) {
      int num = Integer.parseInt(str[1]);
      data.getSide().remove(num - 1);
      Buyer.cleaner();
      printSide();
   }
   
   
}