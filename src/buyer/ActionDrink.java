package buyer;

import java.util.Scanner;
import java.util.ArrayList;
import data.Data;
import data.Stock;

public class ActionDrink {

   private String str;
   private int num;
   private Stock temp; // Drink
   private Stock temp2; // AdultDrink
   static boolean flag = false;
   
   int cnt = 0;
   
   public void action()
   {
      printDrink();
   }
   void printDrink() {
     flag = false;
     Buyer.cleaner();
      System.out.println("[음료 화면]");
      System.out.println();

      for (int i = 0; i < Buyer.data.getDrink().size(); i++) {
         System.out.format("%d. %-5s\t  %,36d원\n", (i + 1), Buyer.data.getDrink().get(i).getName(),
                Buyer.data.getDrink().get(i).getPrice());
      }

      for (int i = Buyer.data.getDrink().size(); i < (Buyer.data.getDrink().size())
            + (Buyer.data.getAdultDrink().size()); i++) {
         System.out.format("%d. %-5s\t  %,22d원(성인인증음료)\n", (i + 1),
               Buyer.data.getAdultDrink().get(i - Buyer.data.getDrink().size()).getName(),
               Buyer.data.getAdultDrink().get(i - Buyer.data.getDrink().size()).getPrice());
      }

      System.out.print(Buyer.printLine);
      System.out.print(Buyer.message_1);

      str = Buyer.data.inputString(); // 입력아서 str에 담음

      num = Integer.parseInt(str); // num = 4 // num 은 갯수(가격)
      if (num > 0 && num <= Buyer.data.getDrink().size()) { // 1, 2, 3 -> 일반음료

         temp = Buyer.data.getDrink().get(num - 1); // 3번지 = temp 의 병맥주가 서브장바구니

         if (temp.getNum() != 0) { // 일반음료의 재고가 0이 아니면

            Buyer.shoppingCart.getDrink().add(temp); // 장바구니에 음료수 담기
            temp.setNum(temp.getNum() - 1); // 재고 수량 -1
         } else { // 일반음료의 재고가 0이면 품절
            System.out.println("품절된 상품입니다.");
         }

      } else if (num > Buyer.data.getDrink().size()
            && num <= Buyer.data.getDrink().size() + Buyer.data.getAdultDrink().size()) { // 4, 5 성인음료

         int drinkSize = Buyer.data.getDrink().size(); // 3
         temp2 = Buyer.data.getAdultDrink().get(num - drinkSize - 1); // 3번지 = temp 의 병맥주가 서브장바구니

         cnt = 0;
         if (temp2.getNum() != 0) // 성인음료의 재고가 0이 아니면
          
            
               // 성인인증 ok여부
            do {// 성인인증 성공시 
               // 성인인증 절차 메소드 호출                
                  if (checkAdult()) {                     
                     
                  Buyer.shoppingCart.getAdultDrink().add(temp2); // 장바구니에 음료수 담기
                  temp2.setNum(temp2.getNum() - 1); // 재고 수량 -1
                  flag = true;
                     
               } else {   // 성인인증 실패시 
                  
                  
                  //do {
                     cnt++;
                     flag=false;
                     if(cnt==3)
                        flag=true;
                     
                  //} while ((cnt < 3)); 

               }         
            } while (flag == false);
            
      
         else
         { // 성인음료의 재고가 0이면 품절
            System.out.println("품절된 상품입니다.");
         }
         
         
         
         //
         if(cnt==3) {
           
            print2();
         }
         
         
         
      }
   }
   
   void print2() {
      System.out.println("[음료 화면]");
       System.out.println();
       System.out.println("음료의 사이즈 "+Buyer.data.getDrink().size());
       for (int i = 0; i < Buyer.data.getDrink().size(); i++) {
          System.out.format("%d. %-5s\t  %,36d원\n", (i + 1), Buyer.data.getDrink().get(i).getName(),
                Buyer.data.getDrink().get(i).getPrice());
       }
          System.out.print(Buyer.printLine);
          System.out.print(Buyer.message_1);

          str = Buyer.data.inputString();
          num = Integer.parseInt(str);
          
          if (num > 0 && num <= Buyer.data.getDrink().size()) { // 1, 2, 3 -> 일반음료

              temp = Buyer.data.getDrink().get(num - 1); // 3번지 = temp 의 병맥주가 서브장바구니

              if (temp.getNum() != 0) { // 일반음료의 재고가 0이 아니면

                 Buyer.shoppingCart.getDrink().add(temp); // 장바구니에 음료수 담기
                 temp.setNum(temp.getNum() - 1); // 재고 수량 -1
              } else { // 일반음료의 재고가 0이면 품절
                 System.out.println("품절된 상품입니다.");
              }

           }
          
       }
   

   /*void printDrinkFalse() {   // 실험한 잔재들
      System.out.println("[음료 화면]");
      System.out.println();

      for (int i = 0; i < Buyer.data.getDrink().size(); i++) {
         System.out.format("%d. %s - %d개 %,6d\n", (i + 1), Buyer.data.getDrink().get(i).getName(),
               Buyer.data.getDrink().get(i).getNum(), Buyer.data.getDrink().get(i).getPrice());
      }
      System.out.print(printLine);
      System.out.print("메뉴를 선택하세요(홈→*, 뒤로가기→/) : ");
   }*/

   boolean checkAdult() { // 주민등록번호 검사 메소드

      String bunho;
      String su = "234567-8923451";
      int na;

      System.out.println("\n[성인인증]");
      System.out.println();
      do {
         System.out.println("주민번호 13자리를 입력해주세요.");
         System.out.println("Ex)990101-4123234");
         System.out.print(Buyer.printLine);
         System.out.print(Buyer.message_1);
         bunho = Buyer.data.inputString();

         if (bunho.length() > 14 || bunho.length() < 14)
            System.out.println("\n>> 잘못 입력되었습니다... 다시 입력해주세요!!\n");

      } while (bunho.length() != 14);

      int sum = 0;

      for (int i = 0; i < 13; i++) {

         if (i == 6) {
            continue;
         }

         sum += Integer.parseInt(bunho.substring(i, i + 1)) * Integer.parseInt(su.substring(i, i + 1));

      }

      na = sum % 11;
      na = 11 - na;

      if (na == 10 || na == 11) {
         na = na % 10;
      }

      if (na == Integer.parseInt(bunho.substring(13, 14))) {
         System.out.println("정확한 주민번호입니다.");
         
         return true;
         
      } else {
         if(cnt!=2)
         System.out.println("\n잘못된 주민번호 입니다. 다시 입력해주세요.");
         return false;
      }

   }
}