/**
 * Date : 2020. 3. 12.
 * Writer : Choi Cheol Nyeong
 * Contents : 구매하는 클래스 
 */
package buyer;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import data.Coupon;
import data.Money;
import data.Pizza;
import data.Set;
import data.ShoppingCart;
import data.Stock;

public class ActionBuy {

   private boolean coupon;
   private boolean coupon2;

   private int discount;

   private int userMoney; // 사용자가 낸돈.

   private boolean cardFlag; // 카드결제인지 현금결제인지 판단할 플래그

   private int[] moneyNum = new int[8];

   public void action() {
      action_Cart();
   }

   public void action_Cart() {

      coupon = false;
      coupon2 = false;
      cardFlag = false;
      userMoney = 0;

      Buyer.cleaner();
      System.out.println("[장바구니]");
      Buyer.print_ShoppingCart();
      System.out.printf("합계%,40d원", cart_Total());
      System.out.println();
      System.out.println("메뉴를 선택해주세요.");

      System.out.println("1. 결제하기");
      System.out.print(Buyer.message_1);

      switch (Buyer.data.inputString()) {

      case "1":
         action_Buy();
         break;

      case "*":

         break;
      }
   }

   // 장바구니의 상품의 합계
   public int cart_Total() {
      int total = 0;
      for (Pizza temp : Buyer.shoppingCart.getPizza())
         total += temp.getPrice();
      for (Stock temp : Buyer.shoppingCart.getChicken())
         total += temp.getPrice();
      for (Stock temp : Buyer.shoppingCart.getSide())
         total += temp.getPrice();
      for (Stock temp : Buyer.shoppingCart.getDrink())
         total += temp.getPrice();
      for (Stock temp : Buyer.shoppingCart.getAdultDrink())
         total += temp.getPrice();
      for (Set temp : Buyer.shoppingCart.getSet())
         total += temp.getPrice();

      if (coupon2) {
         return (int) (total - total * discount / 100.0); // 할인율
      } else {

         return total;
      }
   }

   public void action_Buy() {
      if (cart_Total() != 0) {
         System.out.print("결제하실 수단을 선택해주세요. 1. 카드/ 2.현금 : ");
         // System.out.print("(홈 ▶ ＊ ，뒤로가기 ▶ /) : ");
         switch (Buyer.data.inputString()) {
         case "1":
            cardFlag = true;
            coupon_Check();

            if (coupon) {

               coupon2 = true;
            }

            buy_Check();

            break;
         case "2":
            coupon_Check();

            // 현금 들어와야하는 부분
            cash_Check();

            buy_Check();
            break;
         }
      } else {
         flush_ShoppingCart();
      }

   }

   public void cash_Check() {
      int temp;
      if (coupon) {
         temp = (int) (cart_Total() - cart_Total() * discount / 100.0); // 할인율
         coupon2 = true;
      } else {
         temp = cart_Total();
      }

      while (temp > userMoney) {
    	 System.out.println();
         System.out.println("총 결제 금액 " + temp + "원");
         System.out.println("현재 입력 금액 " + userMoney + "원");
         System.out.println();
         System.out.println("투입하실 금액을 입력해주세요.");
         System.out.println();
         System.out.print(Buyer.message_1);
         userMoney += Buyer.data.input();
         System.out.println();
      }

   }

   public void coupon_Check() {
      boolean flag = false;
      String temp;
      Coupon tempCoupon = null;

      System.out.print("\n쿠폰을 소지하셨습니까(Y/N)? : ");
      
      char ch = Buyer.data.inputString().charAt(0);
      if (ch == 'Y' || ch == 'y') {
         // 쿠폰번호 입력

         while (true) {
            System.out.println("쿠폰 번호를 입력해주세요.");
            System.out.print(Buyer.message_1);
            temp = Buyer.data.inputString();
            for (int i = 0; i < Buyer.data.getCoupon().size(); i++) {
               if (Buyer.data.getCoupon().get(i).getName().equals(temp)) {
                  tempCoupon = Buyer.data.getCoupon().get(i);
                  flag = true;
               }
            }

            if (flag) {
               discount = tempCoupon.getDiscount();
               System.out.println("쿠폰 번호가 일치합니다.");
               System.out.println("전체 품목의 " + discount + "%가 할인됩니다.");
               coupon = true;
               tempCoupon = null; // 사용된 쿠폰 널로 변경후 가비지 컬렉터 대상이 됩니다 .
               break;
            }
            System.out.println("쿠폰번호가 일치하지 않아요.");
         }

      } else {

      }
   }

   public void buy_Check() {

      System.out.print("결제하시겠습니까(Y/N)?  ");
      char ch = Buyer.data.inputString().charAt(0);
      if (ch == 'Y' || ch == 'y') {
         buy_ShoppingCart();
         printBill(cart_Total(), Buyer.shoppingCart);
      } else {
         Buyer.restore();
         Buyer.actionBuyerFlag = false;
         // flush_ShoppingCart();// 결제를 안한다면 장바구니를 비워준다.
         return;
      }
   }

   public void buy_ShoppingCart() {// 장바구니에서 구매하는 메소드
      int sideCount=0;
      for (Pizza temp : Buyer.shoppingCart.getPizza()) {
         Buyer.data.getSalesData().getPizzaSD().add(temp);
         
         if(Buyer.takeOut) // 포장으로할때만 포장용기가 빠진다.
         Buyer.data.getPack().get(0).setNum(Buyer.data.getPack().get(0).getNum()+(-1));

      }
      for (Stock temp : Buyer.shoppingCart.getChicken()) {
         Buyer.data.getSalesData().getChickenSD().add(temp);
         
         if(Buyer.takeOut)
         Buyer.data.getPack().get(1).setNum(Buyer.data.getPack().get(1).getNum()+(-1));
      }
      for (Stock temp : Buyer.shoppingCart.getSide()) {
         Buyer.data.getSalesData().getSideSD().add(temp);
         sideCount++;

      }
      for (Stock temp : Buyer.shoppingCart.getDrink()) {
         Buyer.data.getSalesData().getDrinkSD().add(temp);
         
      }
      for (Stock temp : Buyer.shoppingCart.getAdultDrink()) {
         Buyer.data.getSalesData().getAdultDrinkSD().add(temp);
        
      }
      
      for(int i=0; i<sideCount; i+=3)
         if(Buyer.takeOut)
         Buyer.data.getPack().get(2).setNum(Buyer.data.getPack().get(2).getNum()+(-1));
      
      for (Set temp : Buyer.shoppingCart.getSet()) {
         
         Buyer.data.getSalesData().getSetSD().add(temp);
         if(Buyer.takeOut)
         Buyer.data.getPack().get(3).setNum(Buyer.data.getPack().get(3).getNum()+(-1));

      }

   }

   public void flush_ShoppingCart() {// 장바구니에서 다시 목록으로 반환하기
      String temp;
      for (int i = 0; i < Buyer.shoppingCart.getSide().size(); i++) {
         temp = Buyer.shoppingCart.getSide().get(i).getName();
         for (int k = 0; k < Buyer.data.getSide().size(); k++) {
            if (temp == Buyer.data.getSide().get(k).getName())
               Buyer.data.getSide().get(k).setNum(Buyer.data.getSide().get(k).getNum() + 1);// ++;
         }

      }
   }

   // 영수증 출력 메소드
   public void printBill(int money, ShoppingCart cart) {
      int change = 0;
      Calendar now = new GregorianCalendar();

      System.out.println("결제 완료~!!!");

      // 카드결제인 경우
      if (cardFlag) {

         if (Buyer.sellerNum == 0) { // 방문자 수가 1이면 초기화하고 쌓이기

            // 당일 매출에 넣기
            //Buyer.data.setTotalMoneyDay(258500); // 초기값으로 초기화
            Buyer.data.setTotalMoneyDay(Buyer.data.getTotalMoneyDay() + money); // 초기값인 258500원에 계산완료된 money가 쌓이도록

            // 이번달 매출에 넣기
            int m = now.get(Calendar.MONTH) + 1; // 이번달 : 3
            int[] temp = Buyer.data.getTotalMoneyMonth();
            temp[m - 1] = (temp[m - 1] + money); // TotalMoneyMonth 3-1번지에 money 넣기
            Buyer.data.setTotalMoneyMonth(temp);

         } else { // 방문자 수가 1이 아니면 그냥 기존에 가지고 있던거에서 계속 쌓이도록

            // 당일 매출에 넣기
            Buyer.data.setTotalMoneyDay(Buyer.data.getTotalMoneyDay() + money); // 그냥 넣어주기

            // 이번달 매출에 넣기
            int m = now.get(Calendar.MONTH) + 1; // 이번달 : 3
            int[] temp = Buyer.data.getTotalMoneyMonth();
            temp[m - 1] = (temp[m - 1] + money);
            Buyer.data.setTotalMoneyMonth(temp);
         }

         // 현금결제인 경우
      } else {

         if (Buyer.sellerNum == 0) { // 방문자 수가 1이면 초기화하고 쌓이기

            // 당일 매출에 넣기
            Buyer.data.setTotalMoneyDay(258500); // 초기값으로 초기화
            Buyer.data.setTotalMoneyDay(Buyer.data.getTotalMoneyDay() + userMoney); // 초기값인 258500원에 계산완료된
                                                                  // userMoney가 쌓이도록

            // 이번달 매출에 넣기
            int m = now.get(Calendar.MONTH) + 1; // 이번달 : 3
            int[] temp = Buyer.data.getTotalMoneyMonth();
            temp[m - 1] = (temp[m - 1] + userMoney);
            Buyer.data.setTotalMoneyMonth(temp);

         } else { // 방문자 수가 1이 아니면 그냥 기존에 가지고 있던거에서 계속 쌓이도록

            Buyer.data.setTotalMoneyDay(Buyer.data.getTotalMoneyDay() + userMoney); // 그냥 넣어주기

            // 이번달 매출에 넣기
            int m = now.get(Calendar.MONTH) + 1; // 이번달 : 3
            int[] temp = Buyer.data.getTotalMoneyMonth();
            temp[m - 1] = (temp[m - 1] + userMoney);
            Buyer.data.setTotalMoneyMonth(temp);
         }
      }

      System.out.println();
      Buyer.cleaner();
      System.out.println("[영수증]");
      System.out.println();

      System.out.format("[합계]                                         %,7d원\n", money);
      Buyer.print_ShoppingCart();
      System.out.format("결제금액                                       %,7d원\n", money);
      if (cardFlag) {
         System.out.println("받은금액                                      +카드결제+       ");
         System.out.format("거스름돈                                       %,7d원\n", 0);
      } else {
         Money[] arr = Buyer.data.getMoney();
         change = userMoney - money;
         System.out.format("받은금액                                       %,7d원\n", userMoney);
         System.out.format("거스름돈                                       %,7d원\n", change);

         for (int i = 0; i < moneyNum.length; i++) {
            moneyNum[i] = 0;
         }
         minChange(change);

         for (int i = 0; i < moneyNum.length; i++) {
            if (moneyNum[i] != 0) {
               System.out.format("                          " + "                %,6d원 x %d개\n", arr[i].getName(),
                     moneyNum[i]);
            }
         }

      }

      System.out.println(Buyer.printLine);
      System.out.println("               주문번호 A-" + ++Buyer.sellerNum);

      if (coupon == false && Buyer.data.getCouponStandard() != 0) {
         switch (Buyer.data.getCouponStandard()) {

         case 1:
            if (Buyer.data.getCouponMoney() <= money) {
               System.out.println("   쿠폰번호를 다음 결제시 입력해주시면 ");

               System.out.println("   할인이 됩니다!    <" + makeCouponName(Buyer.data.getNowDiscount()) + ">");

            }

            break;
         case 2:
            if (Buyer.data.getCouponMoney() >= money) {
               System.out.println("   쿠폰번호를 다음 결제시 입력해주시면 ");

               System.out.println("   할인이 됩니다!    <" + makeCouponName(Buyer.data.getNowDiscount()) + ">");

            }
            break;

         }

      }
      System.out.println("       이용해주셔서 감사합니다.");
      System.out.println();
      System.out.println("     사용 완료시 아무 키나 입력해주세요. :");
      // Buyer.data.input();
      Buyer.sc.nextLine();
      Buyer.actionBuyerFlag = false;

   }

   // 조건에 맞는 쿠폰 발행
   String makeCouponName(int discount) {
      Random rdCoupon = new Random();
      String name1 = "";
      boolean flag;
      do {
         flag = false;
         for (int i = 0; i < 5; i++) {

            int num = rdCoupon.nextInt(2); // 영어 인지 숫자인지 기준

            if (num == 0) { // 만약 숫자면 여기서 발생
               name1 += rdCoupon.nextInt(10); // 0~9
            } else if (num == 1) { // 영어면 여기서 발생
               name1 += (char) (rdCoupon.nextInt(26) + 97); // a~z
            }

         }

         for (int j = 0; j < Buyer.data.getCoupon().size(); j++) { // 기존의 쿠폰 이름과 겹치지 않을경우 this name으로 설정
            {

               if (name1.equals(Buyer.data.getCoupon().get(j).getName())) {
                  flag = true;
               }
            }

         }

      } while (flag);

      Buyer.data.getCoupon().add(new Coupon(name1, discount));
      return name1;
   }

   // 거스름돈에서 잔돈 빠지는 알고리즘 (최소 권종수)
   void minChange(int money) {
      int temp;
      Money[] arr = Buyer.data.getMoney();
      int a = 0, b = 0;
      // int sum=0;
      for (int i = 0; i < arr.length; i++) {
         // System.out.println(i+" "+arr[i]);
         // System.out.println("m" +money );
         if (money == 0)
            break;

         if (money / arr[i].getName() > 0) {

            a = money / arr[i].getName();

            if (arr[i].getNum() < a)
               continue;

            b = money % arr[i].getName();
            money = b;
            temp = arr[i].getNum();
            temp -= a;
            moneyNum[i] += a;
            arr[i].setNum(temp);

         } // System.out.println(i+" "+a);
            // sum+=a;
         a = 0;
      }

      // System.out.println(sum+"!!!!!!!!!!");
   }

}