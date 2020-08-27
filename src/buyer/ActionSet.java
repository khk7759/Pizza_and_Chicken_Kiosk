/**
 * @ 작성자 : 송수진
 * @ 작성일 : 2020. 3. 14.
 * @ 설   명 : 구매자모드 > 세트
 */

package buyer;

import data.Data;
import data.Pizza;
import data.Set;
import data.Stock;

public class ActionSet {

   private int setMenu;
   private Pizza tempPizza;
   private Stock tempChicken;
   private Stock tempSide;
   private Stock tempDrink;
   private int setCase;
   private Set setTemp;

   
   public void action()
   {
      printSet();
   }
   // 세트 메뉴 출력하기
   public void printSet() {
      
      System.out.println("[세트메뉴 화면]");
      System.out.println();

      // 세트메뉴를 케이스 분리하여 출력해야 함
      for (int i = 0; i < Buyer.data.getSet().size(); i++) {
         
         Buyer.cleaner();
            
            // ★★등록된 메뉴 출력문★★
            //--------------------------모두 선택되었을 때---------------------------------------------------   
            if(!(Buyer.data.getSet().get(i).getChicken() == null) && !(Buyer.data.getSet().get(i).getSide() == null) && !(Buyer.data.getSet().get(i).getDrink() == null)) {   
               
               System.out.format("%d. %s + %s + %s + %s %,5d원\n", (i + 1), Buyer.data.getSet().get(i).getPizza().getName(), Buyer.data.getSet().get(i).getChicken().getName(), 
                     Buyer.data.getSet().get(i).getSide().getName(), Buyer.data.getSet().get(i).getDrink().getName(), Buyer.data.getSet().get(i).getPrice());
            
            //--------------------------0이 1개일 때---------------------------------------------------   
               // 치킨만 0일 때
            }else if(Buyer.data.getSet().get(i).getChicken() == null && !(Buyer.data.getSet().get(i).getSide() == null) && !(Buyer.data.getSet().get(i).getDrink() == null)) {
               System.out.format("%d. %-5s\t + %s + %s\t %,13d원\n", (i + 1), Buyer.data.getSet().get(i).getPizza().getName(), 
                     Buyer.data.getSet().get(i).getSide().getName(), Buyer.data.getSet().get(i).getDrink().getName(), Buyer.data.getSet().get(i).getPrice());
               
               // 사이드만 0일 때
            }else if(Buyer.data.getSet().get(i).getSide() == null && !(Buyer.data.getSet().get(i).getChicken() == null) && !(Buyer.data.getSet().get(i).getDrink() == null)) {
               System.out.format("%d. %-5s\t + %s + %s\t %,13d원\n", (i + 1), Buyer.data.getSet().get(i).getPizza().getName(), 
                     Buyer.data.getSet().get(i).getChicken().getName(), Buyer.data.getSet().get(i).getDrink().getName(), Buyer.data.getSet().get(i).getPrice());
               
               // 음료만 0일 때
            }else if(Buyer.data.getSet().get(i).getDrink() == null && !(Buyer.data.getSet().get(i).getChicken() == null) && !(Buyer.data.getSet().get(i).getSide() == null)) {
               System.out.format("%d. %-5s\t + %s + %s\t %,13d원\n", (i + 1), Buyer.data.getSet().get(i).getPizza().getName(), 
                     Buyer.data.getSet().get(i).getChicken().getName(), Buyer.data.getSet().get(i).getSide().getName(), Buyer.data.getSet().get(i).getPrice());
               
            //--------------------------0이 2개일 때---------------------------------------------------
               // 치킨과 사이드가 0일 때
            }else if(Buyer.data.getSet().get(i).getChicken() == null && Buyer.data.getSet().get(i).getSide() == null && !(Buyer.data.getSet().get(i).getDrink() == null)) {
               System.out.format("%d. %-5s\t + %s\t\t %,13d원\n", (i + 1), Buyer.data.getSet().get(i).getPizza().getName(), 
                     Buyer.data.getSet().get(i).getDrink().getName(), Buyer.data.getSet().get(i).getPrice());
               
               // 치킨과 음료가 0일 때
            }else if(Buyer.data.getSet().get(i).getChicken() == null && Buyer.data.getSet().get(i).getDrink() == null && !(Buyer.data.getSet().get(i).getSide() == null)) {
               System.out.format("%d. %-5s\t + %s\t\t %,13d원\n", (i + 1), Buyer.data.getSet().get(i).getPizza().getName(), 
                     Buyer.data.getSet().get(i).getSide().getName(), Buyer.data.getSet().get(i).getPrice());
               
               // 사이드와 음료가 0일 때
            }else if(Buyer.data.getSet().get(i).getSide() == null && Buyer.data.getSet().get(i).getDrink() == null && !(Buyer.data.getSet().get(i).getChicken() == null)) {
               System.out.format("%d. %-5s\t + %s\t\t %,13d원\n", (i + 1), Buyer.data.getSet().get(i).getPizza().getName(), 
                     Buyer.data.getSet().get(i).getChicken().getName(), Buyer.data.getSet().get(i).getPrice());
            }
            
      }

      System.out.print(Buyer.printLine);
      System.out.print("메뉴를 선택하세요(홈→*, 뒤로가기→/) : ");

      setMenu = Buyer.data.input();            // 입력한 수 2 (두번째 세트메뉴)
      
      setCase = Buyer.data.getSet().get(setMenu - 1).getSetCase(); // 입력한 수의 번지수의 setcase를 판단하기! 두번째는 사이드가 없는 Case 3!

      setTemp = Buyer.data.getSet().get(setMenu - 1);            // 2. 포테이토피자 + 양념치킨 + 콜라 - 35,000원
      
      switch (setCase) {   // 입력한 케이스대로 temp에 담을 곳 찾아가기

      case 1:

         for (int i = 0; i < Buyer.data.getPizza().size(); i++) {    // 피자

            String temp = Buyer.data.getPizza().get(i).getName();    // temp = 기존 피자 메뉴에 있는값
            if (temp.equals(setTemp.getPizza().getName())) {      // 선택한 세트에 있는 값이 기존 피자 메뉴의 값과 같으면
               tempPizza = Buyer.data.getPizza().get(i);

            }

         }
         for (int i = 0; i < Buyer.data.getChicken().size(); i++) {// 치킨 -> 6개 등록되어 있으면

            String temp = Buyer.data.getChicken().get(i).getName(); // 치킨 메뉴에 있는값 / 0번지 ~ 5번지의 치킨 이름
            if (temp.equals(setTemp.getChicken().getName())) {   // 세트에 있는값 / 두번째 메뉴의 치킨인 "양념치킨"이 치킨메뉴에 "양념치킨"과 일치하면?
               tempChicken = Buyer.data.getChicken().get(i);   // 그 양념치킨 객체를 tempChicken에 담기

            }

         }

         for (int i = 0; i < Buyer.data.getSide().size(); i++) {// 사이드

            String temp = Buyer.data.getSide().get(i).getName(); // 사이드 메뉴에 있는값
            if (temp.equals(setTemp.getSide().getName())) {// 사이드에 있는값
               tempSide = Buyer.data.getSide().get(i);

            }

         }

         for (int i = 0; i < Buyer.data.getDrink().size(); i++) {// 음료

            String temp = Buyer.data.getDrink().get(i).getName(); // 음료 메뉴에 있는값
            if (temp.equals(setTemp.getDrink().getName())) {// 음료에 있는값
               tempDrink = Buyer.data.getDrink().get(i);

            }

         }

         break;
      case 2:

         for (int i = 0; i < Buyer.data.getPizza().size(); i++) { // 피자

            String temp = Buyer.data.getPizza().get(i).getName(); // 피자 메뉴에 있는값
            if (temp.equals(setTemp.getPizza().getName())) {// 세트에 있는값
               tempPizza = Buyer.data.getPizza().get(i);

            }

         }

         for (int i = 0; i < Buyer.data.getSide().size(); i++) {// 사이드

            String temp = Buyer.data.getSide().get(i).getName(); // 사이드 메뉴에 있는값
            if (temp.equals(setTemp.getSide().getName())) {// 사이드에 있는값
               tempSide = Buyer.data.getSide().get(i);

            }

         }

         for (int i = 0; i < Buyer.data.getDrink().size(); i++) {// 음료

            String temp = Buyer.data.getDrink().get(i).getName(); // 음료 메뉴에 있는값
            if (temp.equals(setTemp.getDrink().getName())) {// 음료에 있는값
               tempDrink = Buyer.data.getDrink().get(i);

            }

         }

         break;
      case 3:

         for (int i = 0; i < Buyer.data.getPizza().size(); i++) { // 피자

            String temp = Buyer.data.getPizza().get(i).getName(); // 피자 메뉴에 있는값
            if (temp.equals(setTemp.getPizza().getName())) {// 세트에 있는값
               tempPizza = Buyer.data.getPizza().get(i);

            }

         }

         for (int i = 0; i < Buyer.data.getChicken().size(); i++) {// 치킨

            String temp = Buyer.data.getChicken().get(i).getName(); // 치킨 메뉴에 있는값
            if (temp.equals(setTemp.getChicken().getName())) {// 세트에 있는값
               tempChicken = Buyer.data.getChicken().get(i);

            }

         }

         for (int i = 0; i < Buyer.data.getDrink().size(); i++) {// 음료

            String temp = Buyer.data.getDrink().get(i).getName(); // 음료 메뉴에 있는값
            if (temp.equals(setTemp.getDrink().getName())) {// 음료에 있는값
               tempDrink = Buyer.data.getDrink().get(i);

            }

         }


         break;
      case 4:

         for (int i = 0; i < Buyer.data.getPizza().size(); i++) { // 피자

            String temp = Buyer.data.getPizza().get(i).getName(); // 피자 메뉴에 있는값
            if (temp.equals(setTemp.getPizza().getName())) {// 세트에 있는값
               tempPizza = Buyer.data.getPizza().get(i);

            }

         }

         for (int i = 0; i < Buyer.data.getChicken().size(); i++) {// 치킨

            String temp = Buyer.data.getChicken().get(i).getName(); // 치킨 메뉴에 있는값
            if (temp.equals(setTemp.getChicken().getName())) {// 세트에 있는값
               tempChicken = Buyer.data.getChicken().get(i);

            }

         }

         for (int i = 0; i < Buyer.data.getSide().size(); i++) {// 사이드

            String temp = Buyer.data.getSide().get(i).getName(); // 사이드 메뉴에 있는값
            if (temp.equals(setTemp.getSide().getName())) {// 사이드에 있는값
               tempSide = Buyer.data.getSide().get(i);

            }

         }

         break;
      case 5:

         for (int i = 0; i < Buyer.data.getPizza().size(); i++) { // 피자

            String temp = Buyer.data.getPizza().get(i).getName(); // 피자 메뉴에 있는값
            if (temp.equals(setTemp.getPizza().getName())) {// 세트에 있는값
               tempPizza = Buyer.data.getPizza().get(i);

            }

         }

         for (int i = 0; i < Buyer.data.getDrink().size(); i++) {// 음료

            String temp = Buyer.data.getDrink().get(i).getName(); // 음료 메뉴에 있는값
            if (temp.equals(setTemp.getDrink().getName())) {// 음료에 있는값
               tempDrink = Buyer.data.getDrink().get(i);

            }

         }

         break;
      case 6:

         for (int i = 0; i < Buyer.data.getPizza().size(); i++) { // 피자

            String temp = Buyer.data.getPizza().get(i).getName(); // 피자 메뉴에 있는값
            if (temp.equals(setTemp.getPizza().getName())) {// 세트에 있는값
               tempPizza = Buyer.data.getPizza().get(i);

            }

         }

         for (int i = 0; i < Buyer.data.getSide().size(); i++) {// 사이드

            String temp = Buyer.data.getSide().get(i).getName(); // 사이드 메뉴에 있는값
            if (temp.equals(setTemp.getSide().getName())) {// 사이드에 있는값
               tempSide = Buyer.data.getSide().get(i);

            }

         }

         break;
      case 7:

         for (int i = 0; i < Buyer.data.getPizza().size(); i++) { // 피자

            String temp = Buyer.data.getPizza().get(i).getName(); // 피자 메뉴에 있는값
            if (temp.equals(setTemp.getPizza().getName())) {// 세트에 있는값
               tempPizza = Buyer.data.getPizza().get(i);

            }

         }

         for (int i = 0; i < Buyer.data.getChicken().size(); i++) {// 치킨

            String temp = Buyer.data.getChicken().get(i).getName(); // 치킨 메뉴에 있는값
            if (temp.equals(setTemp.getChicken().getName())) {// 세트에 있는값
               tempChicken = Buyer.data.getChicken().get(i);

            }

         }

         break;

      }
      
      inputSet();   // temp에 담고 나서 장바구니에 담기고, 수량빠지는 메소드 호출하기

   }

   // 세트메뉴 선택 메소드
   void inputSet() { // temp데이터 수량 확인 후 장바구니 추가 및 수량 빠지기

      // 피자, 치킨, 사이드, 음료 중 하나라도 0일 경우 품절
      
      switch(setCase) {
      case 1:    // 피자 치킨 사이드 음료 모두 다 있을 때
         if ((tempPizza.getNum() == 0) || (tempChicken.getNum() == 0) || (tempSide.getNum() == 0) || (tempDrink.getNum() == 0)) {
            System.out.println("품절된 상품입니다.");

            // 아니라면 장바구니에 세트메뉴 담기
         } else {
            Buyer.shoppingCart.getSet().add(new Set(tempPizza, tempChicken, tempSide, tempDrink, setTemp.getPrice(), 1));
            tempPizza.setNum(tempPizza.getNum() - 1);
            tempChicken.setNum(tempChicken.getNum() - 1);
            tempSide.setNum(tempSide.getNum() - 1);
            tempDrink.setNum(tempDrink.getNum() - 1);
         }
         
         break;
      case 2:    // 치킨이 0일 때
         if ((tempPizza.getNum() == 0) || (tempSide.getNum() == 0) || (tempDrink.getNum() == 0)) {
            System.out.println("품절된 상품입니다.");

            // 아니라면 장바구니에 세트메뉴 담기
         } else {
            Buyer.shoppingCart.getSet().add(new Set(tempPizza, null, tempSide, tempDrink, setTemp.getPrice(), 2));
            tempPizza.setNum(tempPizza.getNum() - 1);
            tempSide.setNum(tempSide.getNum() - 1);
            tempDrink.setNum(tempDrink.getNum() - 1);
         }
         break;
      case 3:    // 사이드가 0일 때
         
         if ((tempPizza.getNum() == 0) || (tempChicken.getNum() == 0) || (tempDrink.getNum() == 0)) {
            System.out.println("품절된 상품입니다.");

            // 아니라면 장바구니에 세트메뉴 담기
         } else {
            Buyer.shoppingCart.getSet().add(new Set(tempPizza, tempChicken, null, tempDrink, setTemp.getPrice(), 3));
            tempPizza.setNum(tempPizza.getNum() - 1);
            tempChicken.setNum(tempChicken.getNum() - 1);
            tempDrink.setNum(tempDrink.getNum() - 1);
         }

         break;
      case 4:    // 음료가 0일 때
         if ((tempPizza.getNum() == 0) || (tempChicken.getNum() == 0) || (tempSide.getNum() == 0)) {
            System.out.println("품절된 상품입니다.");

            // 아니라면 장바구니에 세트메뉴 담기
         } else {
            Buyer.shoppingCart.getSet().add(new Set(tempPizza, tempChicken, tempSide, null, setTemp.getPrice(), 4));
            tempPizza.setNum(tempPizza.getNum() - 1);
            tempChicken.setNum(tempChicken.getNum() - 1);
            tempSide.setNum(tempSide.getNum() - 1);
         }
         break;
      case 5:    // 치킨, 사이드가 0일 때
         if ((tempPizza.getNum() == 0) || (tempDrink.getNum() == 0)) {
            System.out.println("품절된 상품입니다.");

            // 아니라면 장바구니에 세트메뉴 담기
         } else {
            Buyer.shoppingCart.getSet().add(new Set(tempPizza, null, null, tempDrink, setTemp.getPrice(), 5));
            tempPizza.setNum(tempPizza.getNum() - 1);
            tempDrink.setNum(tempDrink.getNum() - 1);
         }
         break;
      case 6:    // 치킨, 음료가 0일 때
         if ((tempPizza.getNum() == 0) || (tempSide.getNum() == 0)) {
            System.out.println("품절된 상품입니다.");

            // 아니라면 장바구니에 세트메뉴 담기
         } else {
            Buyer.shoppingCart.getSet().add(new Set(tempPizza, null, tempSide, null, setTemp.getPrice(), 6));
            tempPizza.setNum(tempPizza.getNum() - 1);
            tempSide.setNum(tempSide.getNum() - 1);
         }
         break;
      case 7:    // 사이드, 음료가 0일 때
         if ((tempPizza.getNum() == 0) || (tempChicken.getNum() == 0)) {
            System.out.println("품절된 상품입니다.");

            // 아니라면 장바구니에 세트메뉴 담기
         } else {
            Buyer.shoppingCart.getSet().add(new Set(tempPizza, tempChicken, null, null, setTemp.getPrice(), 7));
            tempPizza.setNum(tempPizza.getNum() - 1);
            tempChicken.setNum(tempChicken.getNum() - 1);
         }
         break;
         
      }
      for (int n = 0; n < tempPizza.getIngredient().size(); n++) {
         for (int n1 = 0; n1 < Buyer.data.getIngredient().size(); n1++) {
            if (tempPizza.getIngredient().get(n).getName().equals(Buyer.data.getIngredient().get(n1).getName())) {
               Buyer.data.getIngredient().get(n1).setNum(
                     Buyer.data.getIngredient().get(n1).getNum() - tempPizza.getIngredient().get(n).getNum());
               break;
            }

         }
      }
   }


}