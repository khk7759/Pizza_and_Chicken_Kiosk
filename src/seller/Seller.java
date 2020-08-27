package seller;



import buyer.Buyer;
import buyer.GoHomeException;
import data.Coupon;
import data.Data;

public class Seller {
   Data data;
   ChickenMethod chickenmothd;
   IngredientMethod ingredientMethod;
   PizzaMethod pizzamethod;
   DrinkMethod drinkmethod;
   OrderMethod ordermethod;
   SalesMethod salesMethod;
   EventMethod eventMethod;
   CheckBalanceMethod checkBalanceMethod;
   SideMethod sideMethod;
   SetMethod setMethod;
   
   ModeTransMethod modeTransMethod;
   ExitMethod exitMethod;
   Coupon coupon;
   
   public void action() {
      sellPrint();
   }

   public void set_seller(Data data) {
      this.data = data;

      chickenmothd = new ChickenMethod(data);
      ingredientMethod = new IngredientMethod(data);
      pizzamethod = new PizzaMethod(data);
      drinkmethod = new DrinkMethod(data);
      ordermethod = new OrderMethod(data);
      sideMethod = new SideMethod(data);

      setMethod = new SetMethod(data);
      salesMethod = new SalesMethod(data);
      eventMethod = new EventMethod(data);
      checkBalanceMethod = new CheckBalanceMethod(data);
      coupon = new Coupon(data);
      modeTransMethod = new ModeTransMethod();
      exitMethod = new ExitMethod();

   }
   
   void print() {
      Buyer.cleaner();
      System.out.println("[판매자 모드]");
      System.out.println();
      System.out.println("1. 잔고 확인");
      System.out.println("2. 메뉴 관리");
      System.out.println("3. 재고 관리 및 발주하기");
      System.out.println("4. 이벤트 관리");
      System.out.println("5. 매출 확인");
      System.out.println("6. 사용자 모드 전환");
      System.out.println("7. 프로그램 종료");
      System.out.println(Buyer.printLine);
      System.out.print("메뉴를 선택하세요(홈→*) : ");

   }
   void manageMenu() {
      while (true) {
         Buyer.cleaner();
         System.out.println("[메뉴 관리]");
         System.out.println();
         System.out.println("1. 피자");
         System.out.println("2. 치킨");
         System.out.println("3. 사이드");
         System.out.println("4. 음료");
         System.out.println("5. 세트");
         System.out.println("6. 재료");
         System.out.println(Buyer.printLine);
         System.out.print("추가 및 수정할 메뉴를 선택하세요(홈→*) : ");

         switch (data.input()) {
         case 1:
            Buyer.cleaner();
            pizzamethod.printPizza();
            break;
         case 2:
            Buyer.cleaner();
            chickenmothd.printChicken();
            break;
         case 3:
            Buyer.cleaner();
            sideMethod.printSide();
            break;
         case 4:
            Buyer.cleaner();
            drinkmethod.printDrink();
            break;
         case 5:
            Buyer.cleaner();
             setMethod.printSet();
            break;
         case 6:
            Buyer.cleaner();
            ingredientMethod.printIngredient();
            break;
         case 10 :
            return;
         }
      }
   }

   public void sellPrint() {

      while (true) {

         try {
            print();
            switch (data.input()) {

            case 1:
               Buyer.cleaner();
               checkBalanceMethod.checkBalance();
               return;
            case 2:
               Buyer.cleaner();
               manageMenu();
               return;

            case 3:
               // printStock();
               Buyer.cleaner();
               ordermethod.printOrderMethod();
               return;
            case 4:
               Buyer.cleaner();
               eventMethod.printEventMethod();
               return;
            case 5:
               Buyer.cleaner();
               salesMethod.printSales();
               return;
            case 6:
               Buyer.cleaner();
               modeTransMethod.printMode();
               return;
            case 7:
               Buyer.cleaner();
               exitMethod.printExit();
               return;

            }
         } catch (GoHomeException e) {

         }

      }
            
      }

}