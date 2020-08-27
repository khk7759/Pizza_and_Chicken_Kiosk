/**
 * Date : 2020. 3. 14.
 * Writer : 장기혜
 * Contents : 
 */

package buyer;

import java.util.ArrayList;
import java.util.Random;

import data.Data;
import data.Pizza;
import data.Set;
import data.Stock;


public class ActionRandom {
   
   private Random rdMenu = new Random();
   private int choice; // 랜덤 피자
   private int choice2; // 랜덤 치킨
   private int comGame; // 가위 바위 보

   private Stock cTemp; // 치킨 담을 곳
   private Pizza pTemp; // 피자 담을 곳
   private Stock dTemp=null; // 사은품 담을 곳
   private String str;
   private int num;

   
   public void action()
   {
      printRandom();
   }
    void printRandom() {
      System.out.println();
      System.out.println("[이벤트 랜덤 메뉴 화면] ★대박 할인★");
      System.out.println();
      System.out.println("1. 세트 랜덤 메뉴");
      System.out.println("2. 피자 랜덤 메뉴");
      System.out.println("3. 치킨 랜덤 메뉴");
      System.out.println("==================================================================");
      System.out.println("==================================================================");
      System.out.println(Buyer.message_1); // 메뉴를 선택하세요

      str = Buyer.data.inputString();
      num = Integer.parseInt(str);

      switch (num) {
      // 세트 랜덤 메뉴 선택시
      case 1:

    	  System.out.println("==================================================================");
         System.out.println(" [ ■□■□■□■ 섞는중.... ■□■□■□■ ]");
         System.out.println();
         choice = rdMenu.nextInt(Buyer.data.getRandomPizza().size()); // 랜덤 피자 번호의 숫자
         choice2 = rdMenu.nextInt(Buyer.data.getRandomChicken().size()); // 랜덤 치킨 번호의 숫자

         int cost = 0;// 원가
         for (int i = 0; i < Buyer.data.getPizza().size(); i++) {
            if (Buyer.data.getRandomPizza().get(choice).getName().equals(Buyer.data.getPizza().get(i).getName())) {
               cost += Buyer.data.getPizza().get(i).getPrice();
               break;
            }
         }
         for (int i = 0; i < Buyer.data.getChicken().size(); i++) {
            if (Buyer.data.getRandomChicken().get(choice2).getName()
                  .equals(Buyer.data.getChicken().get(i).getName())) {
               cost += Buyer.data.getChicken().get(i).getPrice();
               break;
            }
         }

         System.out.printf("▶ [ %s + %s ] 이 선택 되었습니다!!\n", Buyer.data.getRandomPizza().get(choice).getName(),
               Buyer.data.getRandomChicken().get(choice2).getName());
         System.out.format("★ 원가 %d원 → 이벤트가 %,d원 ★ 우와 할인 대박 많이 한당~!\n", cost,
               Buyer.data.getRandomPizza().get(choice).getPrice()
                     + Buyer.data.getRandomChicken().get(choice2).getPrice());
         break;

      // 피자 랜덤 메뉴 선택시
      case 2:
    	  System.out.println("==================================================================");
         System.out.println(" [ ■□■□■□■ 섞는중.... ■□■□■□■ ]");
         System.out.println();
         choice = rdMenu.nextInt(Buyer.data.getRandomPizza().size());

         cost = 0;// 원가
         for (int i = 0; i < Buyer.data.getPizza().size(); i++) {
            if (Buyer.data.getRandomPizza().get(choice).getName().equals(Buyer.data.getPizza().get(i).getName())) {
               cost = Buyer.data.getPizza().get(i).getPrice();
               break;
            }
         }
         System.out.printf("▶ [ %s ] 이 선택 되었습니다!!\n", Buyer.data.getRandomPizza().get(choice).getName());
         System.out.format("★ 원가 %d원 → 이벤트가 %,d원 ★ 우와 할인 대박 많이 한당~!\n", cost,
               Buyer.data.getRandomPizza().get(choice).getPrice());
         break;

      // 치킨 랜덤 메뉴 선택시
      case 3:
    	  System.out.println("==================================================================");
         System.out.println(" [ ■□■□■□■ 섞는중.... ■□■□■□■ ]");
         System.out.println();
         choice2 = rdMenu.nextInt(Buyer.data.getRandomChicken().size());

         cost = 0;// 원가
         for (int i = 0; i < Buyer.data.getChicken().size(); i++) {
            if (Buyer.data.getRandomChicken().get(choice2).getName()
                  .equals(Buyer.data.getChicken().get(i).getName())) {
               cost = Buyer.data.getChicken().get(i).getPrice();
               break;
            }
         }
         System.out.printf("▶ [ %s ] 이 선택 되었습니다!!\n", Buyer.data.getRandomChicken().get(choice2).getName());
         System.out.format("★ 원가 %d원 → 이벤트가 %,d원 ★ 우와 할인 대박 많이 한당~!\n", cost,
               Buyer.data.getRandomChicken().get(choice2).getPrice());
         break;
      }

      System.out.println();
      System.out.print("구매 하시겠습니까? Y/N (홈→*, 뒤로가기→/) : ");
      str = Buyer.data.inputString();
      char answer = str.charAt(0);

      if (answer == 'y' || answer == 'Y') {

         // 가위바위보 이벤트
         String[] game = { "가위", "바위", "보" };
         comGame = rdMenu.nextInt(3) + 1;

         System.out.println("==================================================================");
         System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
         System.out.println();
         System.out.println("             [ 이벤트 타임!!!! ]");
         System.out.println("    가위바위보 게임에서 승리하면 상품을 드립니다!!!");
         System.out.println();
         System.out.println("       [고객님]       vs       [사장님]       ");
         System.out.println();
         System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★");
         System.out.println("==================================================================");

         int user;

         do {
            System.out.print("1.가위    2.바위    3.보   (홈→*, 뒤로가기→/) : ");
            str = Buyer.data.inputString();
            user = Integer.parseInt(str);
            System.out.println("==================================================================");
            System.out.println();
            System.out.printf("         %s         vs         %s       ", game[user - 1], game[comGame - 1]);
            System.out.println();

            // 구매자가 승리할 경우
            if ((comGame == 1 && user == 2) || (comGame == 2 && user == 3) || (comGame == 3 && user == 1)) {
               System.out.println();
               System.out.printf("[ 고객님의 승리!!! 『%s』 를 증정해드립니다!!! ]\n", Buyer.data.getGifts().get(0).getName());
               System.out.println();
               // 승리시에만 사은품  설정
               dTemp = Buyer.data.getGifts().get(0);

               // 컴퓨터가 승리할 경우
            } else if ((comGame == 1 && user == 3) || (comGame == 2 && user == 1) || (comGame == 3 && user == 2)) {
               System.out.println();
               System.out.printf(" [ 고객님의 패배!!! 아쉽게도 꽝!ㅠ_ㅠ ]\n", Buyer.data.getGifts());
               System.out.println();
               dTemp = null;

            } else {
               System.out.println();
               System.out.println(" [ 무승부 입니다ㅇㅅㅇ 다시!! ] ");
               System.out.println();
               dTemp = null;
            }

         } while (comGame == user);
         System.out.println();
         System.out.println("==================================================================");
         System.out.print("계속 하려면 y/Y를 입력하세요(홈→*) : ");
 		 Buyer.inputString();
         
         
         pTemp = Buyer.data.getRandomPizza().get(choice);
         cTemp = Buyer.data.getRandomChicken().get(choice2);
         
         
         switch (num) {

         // 랜덤 세트 구매 시 장바구니에 담기
         case 1:

            // 치킨 이름 구분해서 확인한 후에 가격 설정하고 템프에 담아주기
            shoppingChicken();

            // 장바구니에 담기
            Buyer.shoppingCart.getSet()
                  .add(new Set(pTemp, cTemp, null, null, pTemp.getPrice() + cTemp.getPrice(), 7));
            // 피자 수량 감소
            shoppingPizza();
            
            // 치킨 수량 감소 
            shoppingChicken();

            // 졌다면 여기서 담길게 없음
            if (dTemp != null) {
               dTemp.setName(dTemp.getName()+("사은품"));
               Buyer.shoppingCart.getDrink().add(dTemp);
               shoppingGifts();
            }

            break;

         // 랜덤 피자 구매 시 장바구니에 담기
         case 2:
 
            Buyer.shoppingCart.getPizza().add(pTemp);
            // 피자 수량 감소
            shoppingPizza();

            // 졌다면 여기서 담길게 없음
            if (dTemp != null) {
               dTemp.setName(dTemp.getName()+("사은품"));
               Buyer.shoppingCart.getDrink().add(dTemp);
               shoppingGifts();
            }

            break;

         // 랜덤 치킨 구매 시 장바구니에 담기
         case 3:
            shoppingChicken();

            Buyer.shoppingCart.getChicken().add(cTemp);
            // 치킨 수량 감소 
            shoppingChicken();

            // 졌다면 여기서 담길게 없음
            if (dTemp != null) {
               dTemp.setName(dTemp.getName()+("사은품"));
               Buyer.shoppingCart.getDrink().add(dTemp);
               shoppingGifts();
            }

            break;

         }
      }

   }

//--------------------------------------------------------------------------------------------------------------   
   void shoppingPizza() {

      // 피자 이름 구분해서 확인한 후에 수량 줄여주기
      // 원래 피자의 개수, 랜덤 피자의 개수 다 감소 시켜줘야 함
      for (int i = 0; i < Buyer.data.getPizza().size(); i++) {
         if (Buyer.data.getRandomPizza().get(choice).getName().equals(Buyer.data.getPizza().get(i).getName())) {
            Buyer.data.getPizza().get(i).setNum(Buyer.data.getPizza().get(i).getNum() - 1);
         }
      }
      pTemp.setNum(pTemp.getNum() - 1);

   }

//--------------------------------------------------------------------------------------------------------------
   void shoppingChicken() {
      // 치킨 이름 구분해서 확인한 후에 수량 줄여주기
      // 원래 치킨의 개수, 랜덤 치킨의 개수 다 감소 시켜줘야 함
      for (int i = 0; i < Buyer.data.getChicken().size(); i++) {
         if (Buyer.data.getRandomChicken().get(choice2).getName().equals(Buyer.data.getChicken().get(i).getName())) {

            Buyer.data.getChicken().get(i).setNum(Buyer.data.getChicken().get(i).getNum() - 1);           
         }
      }
      cTemp.setNum(cTemp.getNum() - 1);

   }

//--------------------------------------------------------------------------------------------------------------   
   void shoppingGifts() {
   // 음료 이름 구분해서 확인한 후에 수량 줄여주기
     // 원래 음료의 개수, 랜덤 음료의 개수 다 감소 시켜줘야 함
      for (int i = 0; i < Buyer.data.getDrink().size(); i++) {
         if (Buyer.data.getGifts().get(0).equals(Buyer.data.getDrink().get(i).getName())) {
            Buyer.data.getDrink().get(i).setNum(Buyer.data.getDrink().get(i).getNum() - 1);            
         }
      }
      dTemp.setNum(dTemp.getNum() - 1);
   }

}// class end