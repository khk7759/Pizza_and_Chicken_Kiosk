/**
 * @ 작성자 : 송수진
 * @ 작성일 : 2020. 3. 15.
 * @ 설   명 : 판매자모드 > 메뉴관리 > 세트메뉴
 */

package seller;

import buyer.Buyer;
import data.Data;
import data.Set;

public class SetMethod {
   Data data;

   public SetMethod(Data data) {
      this.data = data;
   }

   public void printSet() {
      String[] str;
      System.out.println("[세트]");
      System.out.println();
      for (int i = 0; i < data.getSet().size(); i++) {
         
         // ★★등록된 메뉴 출력문★★
         //--------------------------모두 선택되었을 때---------------------------------------------------   
         if(!(data.getSet().get(i).getChicken() == null) && !(data.getSet().get(i).getSide() == null) && !(data.getSet().get(i).getDrink() == null)) {   
            
            System.out.format("%d. %s + %s + %s + %s %,20d원\n", (i + 1), data.getSet().get(i).getPizza().getName(), data.getSet().get(i).getChicken().getName(), 
                  data.getSet().get(i).getSide().getName(), data.getSet().get(i).getDrink().getName(), data.getSet().get(i).getPrice());
         
         //--------------------------0이 1개일 때---------------------------------------------------   
            // 치킨만 0일 때
         }else if(data.getSet().get(i).getChicken() == null && !(data.getSet().get(i).getSide() == null) && !(data.getSet().get(i).getDrink() == null)) {
            System.out.format("%d. %-5s\t + %s + %s\t %,28d원\n", (i + 1), data.getSet().get(i).getPizza().getName(), 
                  data.getSet().get(i).getSide().getName(), data.getSet().get(i).getDrink().getName(), data.getSet().get(i).getPrice());
            
            // 사이드만 0일 때
         }else if(data.getSet().get(i).getSide() == null && !(data.getSet().get(i).getChicken() == null) && !(data.getSet().get(i).getDrink() == null)) {
            System.out.format("%d. %-5s\t + %s + %s\t %,28d원\n", (i + 1), data.getSet().get(i).getPizza().getName(), 
                  data.getSet().get(i).getChicken().getName(), data.getSet().get(i).getDrink().getName(), data.getSet().get(i).getPrice());
            
            // 음료만 0일 때
         }else if(data.getSet().get(i).getDrink() == null && !(data.getSet().get(i).getChicken() == null) && !(data.getSet().get(i).getSide() == null)) {
            System.out.format("%d. %-5s\t + %s + %s\t %,28d원\n", (i + 1), data.getSet().get(i).getPizza().getName(), 
                  data.getSet().get(i).getChicken().getName(), data.getSet().get(i).getSide().getName(), data.getSet().get(i).getPrice());
            
         //--------------------------0이 2개일 때---------------------------------------------------
            // 치킨과 사이드가 0일 때
         }else if(data.getSet().get(i).getChicken() == null && data.getSet().get(i).getSide() == null && !(data.getSet().get(i).getDrink() == null)) {
            System.out.format("%d. %-5s\t + %s\t\t %,28d원\n", (i + 1), data.getSet().get(i).getPizza().getName(), 
                  data.getSet().get(i).getDrink().getName(), data.getSet().get(i).getPrice());
            
            // 치킨과 음료가 0일 때
         }else if(data.getSet().get(i).getChicken() == null && data.getSet().get(i).getDrink() == null && !(data.getSet().get(i).getSide() == null)) {
            System.out.format("%d. %-5s\t + %s\t\t %,28d원\n", (i + 1), data.getSet().get(i).getPizza().getName(), 
                  data.getSet().get(i).getSide().getName(), data.getSet().get(i).getPrice());
            
            // 사이드와 음료가 0일 때
         }else if(data.getSet().get(i).getSide() == null && data.getSet().get(i).getDrink() == null && !(data.getSet().get(i).getChicken() == null)) {
            System.out.format("%d. %-5s\t + %s\t\t %,28d원\n", (i + 1), data.getSet().get(i).getPizza().getName(), 
                  data.getSet().get(i).getChicken().getName(), data.getSet().get(i).getPrice());
         }
         
      }
      
      
      System.out.println("========================================================================");
      System.out.println("- 추가 (1)");
      System.out.println("- 수정 (2,세트메뉴 번호)");
      System.out.println("- 삭제 (3,세트메뉴 번호)");
      System.out.print(Buyer.message_1);
      str = data.inputString().split(",");

      switch (Integer.parseInt(str[0])) {
      case 1:
        Buyer.cleaner();
         setAdd(str);
         break;
      case 2:
        Buyer.cleaner();
         setModify(str); 
         break;
      case 3:
        Buyer.cleaner();
         setDelete(str);
         break;
      }

   }
   
   // 세트메뉴 추가 메소드
   void setAdd(String[] str) {
      String[] str1;      // 추가 과정에서 입력받을 String[]
      System.out.println("\n[세트 구성하기]");
      System.out.println();
      System.out.println("피자");
      for (int i=0;i<data.getPizza().size();i++) {
         System.out.printf("%d. %s   ", (i+1), data.getPizza().get(i).getName());
      }
      System.out.println("\n\n치킨");
      for (int i=0;i<data.getChicken().size();i++) {
         System.out.printf("%d. %s   ", (i+1), data.getChicken().get(i).getName());
      }
      System.out.println("\n\n사이드");
      for (int i=0;i<data.getSide().size();i++) {
         System.out.printf("%d. %s   ", (i+1), data.getSide().get(i).getName());
      }
      System.out.println("\n\n음료");
      for (int i=0;i<data.getDrink().size();i++) {
         System.out.printf("%d. %s   ", (i+1), data.getDrink().get(i).getName());
      }
      
      System.out.println("\n========================================================================");
      System.out.print("- 추가 (피자번호, 치킨번호, 사이드번호, 음료번호, 가격) : ");
      str1 = data.inputString().split(",");
      
      if (str1.length != 5) {
         setAdd(str);
      }
      
      int pizza = Integer.parseInt(str1[0]);
      int chicken = Integer.parseInt(str1[1]);
      int side = Integer.parseInt(str1[2]);
      int drink = Integer.parseInt(str1[3]);
      int price = Integer.parseInt(str1[4]);
      
      
      if (pizza == 0) {
         System.out.println("피자는 필수 선택입니다.");
         setAdd(str);
      }
      
      int cnt = 0;
      for (int i=0;i<str1.length-1;i++) {
         if(Integer.parseInt(str1[i]) > 0) {   // 0이상의 수로 입력된 개수 확인
            cnt++;                     // i번째 수가 0보다 크면 cnt 증가
         }
      }
      
      if(cnt < 2) {                     // -> cnt가 2개 미만이면 안되고 2개 이상이면 가능
         System.out.println("세트 구성요소는 2개부터 가능합니다.");
         setAdd(str);
      }else {
         
         // ★★입력받은 수 대로 리스트에 신규 추가하기★★
         //--------------------------모두 선택되었을 때---------------------------------------------------   
         if(chicken != 0 && side != 0 && drink != 0) {
        	 if(data.getSet().size()<10)
        	 data.getSet().add(new Set(data.getPizza().get(pizza-1), data.getChicken().get(chicken-1), data.getSide().get(side-1), data.getDrink().get(drink-1), price, 1));
            Buyer.cleaner();
            printSet();
            
         //--------------------------0이 1개일 때---------------------------------------------------   
            // 치킨만 0일 때
         }else if(chicken == 0 && side != 0 && drink != 0) {   // 치킨만 객체 생성 안하기
        	 if(data.getSet().size()<10)
        	 data.getSet().add(new Set(data.getPizza().get(pizza-1), null, data.getSide().get(side-1), data.getDrink().get(drink-1), price, 2));
            Buyer.cleaner();
            printSet();
            
            // 사이드만 0일 때
         }else if(side == 0 && chicken != 0 && drink != 0) {      // 사이드만 객체 생성 안하기
        	 if(data.getSet().size()<10)
        	 data.getSet().add(new Set(data.getPizza().get(pizza-1), data.getChicken().get(chicken-1), null, data.getDrink().get(drink-1), price, 3));
            Buyer.cleaner();
            printSet();
            
            // 음료만 0일 때
         }else if(drink == 0 && chicken != 0 && side != 0) {      // 음료만 객체 생성 안하기
        	 if(data.getSet().size()<10)
        	 data.getSet().add(new Set(data.getPizza().get(pizza-1), data.getChicken().get(chicken-1), data.getSide().get(side-1), null, price, 4));
            Buyer.cleaner();
            printSet();
            
         //--------------------------0이 2개일 때---------------------------------------------------   
            // 치킨과 사이드가 0일 때
         }else if(chicken == 0 && side == 0  && drink != 0) {   // 치킨이랑 사이드 객체 생성 안하기
        	 if(data.getSet().size()<10)
        	 data.getSet().add(new Set(data.getPizza().get(pizza-1), null, null, data.getDrink().get(drink-1), price, 5));
            Buyer.cleaner();
            printSet();
            
            // 치킨과 음료가 0일 때
         }else if(chicken == 0 && drink == 0  && side != 0) {   // 치킨이랑 음료 객체 생성 안하기
        	 if(data.getSet().size()<10)
        	 data.getSet().add(new Set(data.getPizza().get(pizza-1), null, data.getSide().get(side-1), null, price, 6));
            Buyer.cleaner();
            printSet();
            
            // 사이드와 음료가 0일 때
         }else if(drink == 0 && side == 0 && chicken != 0) {      // 사이드랑 음료 객체 생성 안하기
        	 if(data.getSet().size()<10)
        	 data.getSet().add(new Set(data.getPizza().get(pizza-1), data.getChicken().get(chicken-1), null, null, price, 7));
            Buyer.cleaner();
            printSet();
         }
      }
            
   }
   
   // 세트메뉴 수정 메소드
   void setModify(String[] str) {
      String[] str2;      // 수정 과정에서 입력받을 String[]
      
      System.out.println("\n[세트 수정하기]");
      int n = Integer.parseInt(str[1]);
      
      // ★★선택한 메뉴 출력문★★
      //--------------------------모두 선택되었을 때---------------------------------------------------   
      if(!(data.getSet().get(n-1).getChicken() == null) && !(data.getSet().get(n-1).getSide() == null) && !(data.getSet().get(n-1).getDrink() == null)) {   
         
         System.out.format("%d. %s + %s + %s + %s - %,6d원\n", n, data.getSet().get(n-1).getPizza().getName(), data.getSet().get(n-1).getChicken().getName(), 
               data.getSet().get(n-1).getSide().getName(), data.getSet().get(n-1).getDrink().getName(), data.getSet().get(n-1).getPrice());
      
      //--------------------------0이 1개일 때---------------------------------------------------   
         // 치킨만 0일 때
      }else if(data.getSet().get(n-1).getChicken() == null && !(data.getSet().get(n-1).getSide() == null) && !(data.getSet().get(n-1).getDrink() == null)) {
         System.out.format("%d. %s + %s + %s - %,6d원\n", n, data.getSet().get(n-1).getPizza().getName(), 
               data.getSet().get(n-1).getSide().getName(), data.getSet().get(n-1).getDrink().getName(), data.getSet().get(n-1).getPrice());
         
         // 사이드만 0일 때
      }else if(data.getSet().get(n-1).getSide() == null && !(data.getSet().get(n-1).getChicken() == null) && !(data.getSet().get(n-1).getDrink() == null)) {
         System.out.format("%d. %s + %s + %s - %,6d원\n", n, data.getSet().get(n-1).getPizza().getName(), 
               data.getSet().get(n-1).getChicken().getName(), data.getSet().get(n-1).getDrink().getName(), data.getSet().get(n-1).getPrice());
         
         // 음료만 0일 때
      }else if(data.getSet().get(n-1).getDrink() == null && !(data.getSet().get(n-1).getChicken() == null) && !(data.getSet().get(n-1).getSide() == null)) {
         System.out.format("%d. %s + %s + %s - %,6d원\n", n, data.getSet().get(n-1).getPizza().getName(), 
               data.getSet().get(n-1).getChicken().getName(), data.getSet().get(n-1).getSide().getName(), data.getSet().get(n-1).getPrice());
         
      //--------------------------0이 2개일 때---------------------------------------------------
         // 치킨과 사이드가 0일 때
      }else if(data.getSet().get(n-1).getChicken() == null && data.getSet().get(n-1).getSide() == null && !(data.getSet().get(n-1).getDrink() == null)) {
         System.out.format("%d. %s + %s - %,6d원\n", n, data.getSet().get(n-1).getPizza().getName(), 
               data.getSet().get(n-1).getDrink().getName(), data.getSet().get(n-1).getPrice());
         
         // 치킨과 음료가 0일 때
      }else if(data.getSet().get(n-1).getChicken() == null && data.getSet().get(n-1).getDrink() == null && !(data.getSet().get(n-1).getSide() == null)) {
         System.out.format("%d. %s + %s - %,6d원\n", n, data.getSet().get(n-1).getPizza().getName(), 
               data.getSet().get(n-1).getSide().getName(), data.getSet().get(n-1).getPrice());
         
         // 사이드와 음료가 0일 때
      }else if(data.getSet().get(n-1).getSide() == null && data.getSet().get(n-1).getDrink() == null && !(data.getSet().get(n-1).getChicken() == null)) {
         System.out.format("%d. %s + %s - %,6d원\n", n, data.getSet().get(n-1).getPizza().getName(), 
               data.getSet().get(n-1).getChicken().getName(), data.getSet().get(n-1).getPrice());
      }
      
      // 등록되어있는 각 메뉴 리스트 출력
      System.out.println();
      System.out.println("피자");
      for (int i=0;i<data.getPizza().size();i++) {
         System.out.printf("%d. %s   ", (i+1), data.getPizza().get(i).getName());
      }
      System.out.println("\n\n치킨");
      for (int i=0;i<data.getChicken().size();i++) {
         System.out.printf("%d. %s   ", (i+1), data.getChicken().get(i).getName());
      }
      System.out.println("\n\n사이드");
      for (int i=0;i<data.getSide().size();i++) {
         System.out.printf("%d. %s   ", (i+1), data.getSide().get(i).getName());
      }
      System.out.println("\n\n음료");
      for (int i=0;i<data.getDrink().size();i++) {
         System.out.printf("%d. %s   ", (i+1), data.getDrink().get(i).getName());
      }
      
      System.out.println("\n========================================================================");
      System.out.print("- 수정 (피자번호, 치킨번호, 사이드번호, 음료번호, 가격) : ");
      str2 = data.inputString().split(",");

      
      if (str2.length != 5) {
         setAdd(str);
      }
      
      int pizza = Integer.parseInt(str2[0]);
      int chicken = Integer.parseInt(str2[1]);
      int side = Integer.parseInt(str2[2]);
      int drink = Integer.parseInt(str2[3]);
      int price = Integer.parseInt(str2[4]);
      
      if (pizza == 0) {
         System.out.println("피자는 필수 선택입니다.");
         setAdd(str);
      }
      
      int cnt = 0;
      for (int i=0;i<str2.length-1;i++) {
         if(Integer.parseInt(str2[i]) > 0) {   // 0이상의 수로 입력된 개수 확인
            cnt++;      // i번째 수가 0보다 크면 cnt 증가
         }
      }
      
      if(cnt < 2) { // -> cnt가 2개 미만이면 안되고 2개 이상이면 가능
         System.out.println("세트 구성요소는 2개부터 가능합니다.");
         setAdd(str);
      }else {
         
         // ★★입력받은 수 대로 리스트에 수정하기★★
         //--------------------------모두 선택되었을 때---------------------------------------------------   
         if(chicken != 0 && side != 0 && drink != 0) {
            
            data.getSet().set(n-1, new Set(data.getPizza().get(pizza-1), data.getChicken().get(chicken-1), data.getSide().get(side-1), data.getDrink().get(drink-1), price, 1));
            Buyer.cleaner();
            printSet();
            
         //--------------------------0이 1개일 때---------------------------------------------------   
            // 치킨만 0일 때
         }else if(chicken == 0 && side != 0 && drink != 0) {      // 치킨만 객체 생성 안하기
            data.getSet().set(n-1, new Set(data.getPizza().get(pizza-1), null, data.getSide().get(side-1), data.getDrink().get(drink-1), price, 2));
            Buyer.cleaner();
            printSet();
            
            // 사이드만 0일 때
         }else if(side == 0 && chicken != 0 && drink != 0) {      // 사이드만 객체 생성 안하기
            data.getSet().set(n-1, new Set(data.getPizza().get(pizza-1), data.getChicken().get(chicken-1), null, data.getDrink().get(drink-1), price, 3));
            Buyer.cleaner();
            printSet();
            
            // 음료만 0일 때
         }else if(drink == 0 && chicken != 0 && side != 0) {      // 음료만 객체 생성 안하기
            data.getSet().set(n-1, new Set(data.getPizza().get(pizza-1), data.getChicken().get(chicken-1), data.getSide().get(side-1), null, price, 4));
            Buyer.cleaner();
            printSet();
            
         //--------------------------0이 2개일 때---------------------------------------------------   
            // 치킨과 사이드가 0일 때
         }else if(chicken == 0 && side == 0  && drink != 0) {   // 치킨이랑 사이드 객체 생성 안하기
            data.getSet().set(n-1, new Set(data.getPizza().get(pizza-1), null, null, data.getDrink().get(drink-1), price, 5));
            Buyer.cleaner();
            printSet();
            
            // 치킨과 음료가 0일 때
         }else if(chicken == 0 && drink == 0  && side != 0) {   // 치킨이랑 음료 객체 생성 안하기
            data.getSet().set(n-1, new Set(data.getPizza().get(pizza-1), null, data.getSide().get(side-1), null, price, 6));
            Buyer.cleaner();
            printSet();
            
            // 사이드와 음료가 0일 때
         }else if(drink == 0 && side == 0 && chicken != 0) {      // 사이드랑 음료 객체 생성 안하기
            data.getSet().set(n-1, new Set(data.getPizza().get(pizza-1), data.getChicken().get(chicken-1), null, null, price, 7));
            Buyer.cleaner();
            printSet();
         }
      }
   }
   
   // 세트메뉴 삭제 메소드
   void setDelete(String[] str) {
      int num = Integer.parseInt(str[1]);
      data.getSet().remove(num - 1);
      printSet();
   }
   
}