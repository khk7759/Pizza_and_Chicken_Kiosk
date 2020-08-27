//작성자 : 길동규

package buyer;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import data.*;
import seller.*;
import main.Main;

public class Buyer {

	public static Scanner sc = new Scanner(System.in);

	public static Seller seller = new Seller();
	public static Data data;

	public static ActionPizza actionPizza = new ActionPizza();
	public static ActionChicken actionChicken = new ActionChicken();
	public static ActionDrink actionDrink = new ActionDrink();
	public static ActionSide actionSide = new ActionSide();
	public static ActionSet actionSet = new ActionSet();
	public static ActionRandom actionRandom = new ActionRandom();
	public static ActionBuy actionBuy = new ActionBuy();

	public static ShoppingCart shoppingCart;

	public static String printLine = "========================================================\n";
	public static String message_1 = "메뉴를 선택하세요(홈→*) : ";

	public String[] printMainMenuStr = { "[메뉴]\n", "1.피자", "2.치킨", "3.사이드", "4.음료", "5.세트", "6.이벤트 랜덤 메뉴",
			"7.장바구니(결제하기)" };

	public static boolean actionBuyerFlag;

	private boolean buyFlag; // 결재여부
	static boolean takeOut; // 포장여부
	public static int sellerNum; // 결재 완료된 횟수()

	/*
	 * -------- static method --------
	 * 
	 * public static void cleaner() //콘솔정리 public static String inputMsg() // 기본 메세지
	 * 입/출력 public static int inputInt() // 숫자 입력 public static String inputString()
	 * // 문자열만 입력
	 * 
	 * public static void print_ShoppingCart() //장바구니 출력 public static void
	 * print_ShoppingCartSub(ArrayList<Stock> data) //장바구니 리스트 하나 출력 public static
	 * void print_ShoppingCartSub_pizza(ArrayList<Pizza> data) //장바구니 피자리스트 출력
	 * public static void print_ShoppingCartSub_set(ArrayList<Set> data) //장바구니
	 * 세트리스트 출력
	 * 
	 * 
	 * -------- method --------
	 * 
	 * //public void action(Data data) //buyer 프로그램 실행 //public void setting_buyer()
	 * //buyer field 셋팅 //public void setting_data(Data data) //Buyer.data, 장바구니 셋팅
	 * //public void check_TakeOut() //포장,선택확인 //public void action_mainMenu()
	 * //장바구니에 메뉴담기 //public void print_mainMenu() //판매메인메뉴 출력 //public void
	 * addStock() //미결재시 재고복구
	 * 
	 */
//----------------------------------  static method   ----------------------------------
	public static void cleaner()// 콘솔정리
	{
		System.out.printf(
				"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}

	public static String inputMsg() {// 기본 메세지 입/출력
		System.out.printf("%s", Buyer.message_1);
		String str = sc.nextLine();
		str.replaceAll(" ", "");
		if (str.equals(""))
			return null;

		if (str.equals("*"))
			throw new GoHomeException();
		return str;
	}

	public static int inputInt() // 숫자만 받아옴
	{
		String str = sc.nextLine();

		if ("*".equals(str.replaceAll(" ", "")))
			goHome();

		str = str.replaceAll(" ", "").replaceAll("[^0-9]", "");

		if (str.equals(""))
			return (Integer) null;

		return Integer.parseInt(str);
	}

	public static String inputString() // 문자열만 받아옴
	{
		String str = sc.nextLine().replaceAll(" ", "");

		if ("*".equals(str.replaceAll(" ", "")))
			goHome();

		if (str.equals(""))
			return null;
		return str;
	}

	static public void goHome() {
		throw new GoHomeException();
	}

//----------------------------------  static method - ShoppingCart   ---------------------
	public static void print_ShoppingCart() // 장바구니 출력
	{
		System.out.print(Buyer.printLine);
		print_ShoppingCartSub_pizza(shoppingCart.getPizza());
		print_ShoppingCartSub(shoppingCart.getChicken());
		print_ShoppingCartSub(shoppingCart.getDrink());
		print_ShoppingCartSub(shoppingCart.getAdultDrink());
		print_ShoppingCartSub(shoppingCart.getSide());
		print_ShoppingCartSub_set(shoppingCart.getSet());

		System.out.print(Buyer.printLine);

	}

	public static void print_ShoppingCartSub(ArrayList<Stock> data) { // 장바구니의 하나의 리스트 출력
		for (int i = 0; i < data.size(); i++) {

			System.out.format("%-12s\t\t  %,20d원\n", data.get(i).getName(), data.get(i).getPrice());
			
		}

	}

	public static void print_ShoppingCartSub_pizza(ArrayList<Pizza> data) { // 장바구니의 피자 리스트 출력
		for (int i = 0; i < data.size(); i++) {

			System.out.format("%-11s\t  %,28d원\n", data.get(i).getName(), data.get(i).getPrice());
			
		}

	}

	public static void print_ShoppingCartSub_set(ArrayList<Set> data) { // 장바구니의 세트 리스트 출력
		for (int i = 0; i < data.size(); i++) {

			// ★★등록된 메뉴 출력문★★
			// --------------------------모두 선택되었을때---------------------------------------------------
			
			if (!(data.get(i).getChicken() == null) && !(data.get(i).getSide() == null)
					&& !(data.get(i).getDrink() == null)) {

				System.out.format("%s + %s + %s + %s   %,6d원\n", data.get(i).getPizza().getName(),
						data.get(i).getChicken().getName(), data.get(i).getSide().getName(),
						data.get(i).getDrink().getName(), data.get(i).getPrice());

				// --------------------------0이 1개일때---------------------------------------------------
				// 치킨만 0일 때
			} else if (data.get(i).getChicken() == null && !(data.get(i).getSide() == null)
					&& !(data.get(i).getDrink() == null)) {
				System.out.format("%-5s + %s + %s   %,21d원\n", data.get(i).getPizza().getName(),
						data.get(i).getSide().getName(), data.get(i).getDrink().getName(), data.get(i).getPrice());

				// 사이드만 0일 때
			} else if (data.get(i).getSide() == null && !(data.get(i).getChicken() == null)
					&& !(data.get(i).getDrink() == null)) {
				System.out.format("%-5s + %s + %s   %,21d원\n", data.get(i).getPizza().getName(),
						data.get(i).getChicken().getName(), data.get(i).getDrink().getName(), data.get(i).getPrice());

				// 음료만 0일 때
			} else if (data.get(i).getDrink() == null && !(data.get(i).getChicken() == null)
					&& !(data.get(i).getSide() == null)) {
				System.out.format("%-5s + %s + %s   %,21d원\n", data.get(i).getPizza().getName(),
						data.get(i).getChicken().getName(), data.get(i).getSide().getName(), data.get(i).getPrice());

				// --------------------------0이 2개일때---------------------------------------------------
				// 치킨과 사이드가 0일 때
			} else if (data.get(i).getChicken() == null && data.get(i).getSide() == null
					&& !(data.get(i).getDrink() == null)) {
				System.out.format("%-5s\t + %s\t   %,19d원\n", data.get(i).getPizza().getName(),
						data.get(i).getDrink().getName(), data.get(i).getPrice());

				// 치킨과 음료가 0일 때
			} else if (data.get(i).getChicken() == null && data.get(i).getDrink() == null
					&& !(data.get(i).getSide() == null)) {
				System.out.format("%-5s\t + %s\t   %,19d원\n", data.get(i).getPizza().getName(),
						data.get(i).getSide().getName(), data.get(i).getPrice());

				// 사이드와 음료가 0일 때
			} else if (data.get(i).getSide() == null && data.get(i).getDrink() == null
					&& !(data.get(i).getChicken() == null)) {
				System.out.format("%-5s\t + %s\t   %,19d원\n", data.get(i).getPizza().getName(),
						data.get(i).getChicken().getName(), data.get(i).getPrice());
			}

		}

	}

//----------------------------------   method   ----------------------------------   

	public void action(Data data) {
		try {
			if (sellerNum == 0)
				seller.set_seller(data);

			if (shoppingCart != null && actionBuyerFlag) {
				restore();

			} // 결재안하고 홈으로 올 때 재고에 다시 수량추가

			setting_buyer();

			check_TakeOut();

			setting_data(data); // 여기안에서 콜론데이터를 생성해서 data.clone에 매칭

			action_mainMenu();

			if (buyFlag)
				actionBuy.action_Cart();

		} catch (GoHomeException e) {

		}
	}

	private void setting_buyer() {
		takeOut = false;
		buyFlag = false;
		actionBuyerFlag = true;

	}

	private void setting_data(Data data) {

		Buyer.data = data;

		Buyer.shoppingCart = new ShoppingCart();

	}

	private void check_TakeOut() {
		boolean flag = true;

		go: while (flag) {
			cleaner();
			System.out.printf("[매장/포장]\n\n" + "1. 포장하기\n" + "2. 먹고가기 \n%s", printLine);

			while (true) {
				switch (inputMsg()) {
				case "1":
					flag = false;
					takeOut = true;
					return;
				case "2":
					flag = false;
					return;
				case "/":
					goHome();
				case "_____":
					seller.action();
					continue go;
				}
			}
		}
	}

	void action_mainMenu() {// mainMenu실행

		boolean flag = true;
		boolean shoppingCart_isNull;

		while (flag) {
			print_mainMenu();

			shoppingCart_isNull = true;
			while (shoppingCart_isNull) {
				shoppingCart_isNull = false;

				switch (inputMsg()) {
				case "1":
					cleaner();
					actionPizza.action();
					break;
				case "2":
					cleaner();
					actionChicken.action();
					break;
				case "3":
					cleaner();
					actionSide.action();
					break;
				case "4":
					cleaner();
					actionDrink.action();
					break;
				case "5":
					cleaner();
					actionSet.action();
					break;
				case "6":
					for (int i = 0; i < Buyer.data.getRandomPizza().size()
							+ Buyer.data.getRandomChicken().size(); i++) {
						if (Buyer.data.getRandomPizza().get(i).getNum() == 0
								|| Buyer.data.getRandomChicken().get(i).getNum() == 0) {
							System.out.println("지금은 이벤트 상품 판매가 불가합니다.");
							break;
						} else {
							cleaner();
							actionRandom.action();
							break;
						}
					}

					break;
				case "7":
					shoppingCart_isNull = flag = shoppingCart_isNull(); // 7.장바구니(결제하기)
					break;
				case "/":
					check_TakeOut();
					break; // 뒤로가기
				case "*":
					goHome();
				}
			}
		}
	}

	private boolean shoppingCart_isNull() {
		boolean isNull = false;

		if (shoppingCart.getPizza().size() != 0)
			isNull = true;
		if (shoppingCart.getChicken().size() != 0)
			isNull = true;
		if (shoppingCart.getSide().size() != 0)
			isNull = true;
		if (shoppingCart.getDrink().size() != 0)
			isNull = true;
		if (shoppingCart.getAdultDrink().size() != 0)
			isNull = true;
		if (shoppingCart.getSet().size() != 0)
			isNull = true;
		if (shoppingCart.getSide().size() != 0)
			isNull = true;

		if (isNull) {
			buyFlag = true;
			return false;
		}

		System.out.println("장바구니가 비어있습니다.");
		return true;

	}

	private void print_mainMenu() {// mainMenu출력
		cleaner();
		for (String str : printMainMenuStr)
			System.out.println(str);

		print_ShoppingCart();
	}

	static void restore() {// 미결재시 재고복구

        // Pizza

        for (int n = 0; n < shoppingCart.getPizza().size(); n++) {
           for (int m = 0; m < data.getPizza().size(); m++)
              if (data.getPizza().get(m).getCheese().getName().equals(shoppingCart.getPizza().get(n).getCheese().getName())) {
                 data.getCheese().get(m).setNum(data.getCheese().get(m).getNum()+1); //+= shoppingCart.getPizza().get(n).getCheese().getNum();
                 break;
              }

           for (int m = 0; m < data.getPizza().size(); m++)
              if (data.getPizza().get(m).getSauce().getName()
                    .equals(shoppingCart.getPizza().get(n).getSauce().getName())) {
                 data.getSauce().get(m).setNum(data.getSauce().get(m).getNum()+1); //+= shoppingCart.getPizza().get(n).getSauce().getNum();
                 break;
              }

           for (int m = 0; m < data.getPizza().size(); m++)
              if (data.getDough().get(m).getName()
                    .equals(shoppingCart.getPizza().get(n).getDough().getName())) {
                 data.getDough().get(m).setNum(data.getDough().get(m).getNum()+1); //+= shoppingCart.getPizza().get(n).getDough().getNum();
                 break;
              }

           for (int m1 = 0; m1 < shoppingCart.getPizza().get(n).getIngredient().size(); m1++)
              for (int m2 = 0; m2 < data.getIngredient().size(); m2++)
                 if (shoppingCart.getPizza().get(n).getIngredient().get(m1).getName()
                       .equals(data.getIngredient().get(m2).getName())) {
                    data.getIngredient().get(m2).setNum(data.getIngredient().get(m2).getNum()+shoppingCart.getPizza().get(n).getIngredient().get(m1).getNum()); //+= shoppingCart.getPizza().get(n).getIngredient().get(m1).getNum();
                    break;
                 }
        } // Pizza

        // chicken
        for (int n = 0; n < shoppingCart.getChicken().size(); n++) {
           for (int m = 0; m < data.getChicken().size(); m++)
              if (data.getChicken().get(m).getName().equals(shoppingCart.getChicken().get(n).getName())) {
                 data.getChicken().get(m).setNum(data.getChicken().get(m).getNum()+1); //+= shoppingCart.getChicken().get(n).getNum();
                 break;
              }
        }

        // drink
        for (int n = 0; n < shoppingCart.getDrink().size(); n++) {
           for (int m = 0; m < data.getDrink().size(); m++)
              if (data.getDrink().get(m).getName().equals(shoppingCart.getDrink().get(n).getName())) {
                 data.getDrink().get(m).setNum(data.getDrink().get(m).getNum()+1); //+= shoppingCart.getDrink().get(n).getNum();
                 break;
              }
        }

        // side
        for (int n = 0; n < shoppingCart.getSide().size(); n++) {
           for (int m = 0; m < data.getSide().size(); m++)
              if (data.getSide().get(m).getName().equals(shoppingCart.getSide().get(n).getName())) {
                 data.getSide().get(m).setNum(data.getSide().get(m).getNum()+1); //+= shoppingCart.getSide().get(n).getNum();
                 break;
              }
           
           
        }
       
     // set
        for (int n = 0; n < shoppingCart.getSet().size(); n++) {
           if(shoppingCart.getSet().get(n) != null){
              if(shoppingCart.getSet().get(n).getPizza() != null) {
                 for(int n2 = 0; n2 < Buyer.data.getPizza().size(); n2++) {
                    if(shoppingCart.getSet().get(n).getPizza().getName().equals(Buyer.data.getPizza().get(n2).getName())){
                       Buyer.data.getPizza().get(n2).setNum(Buyer.data.getPizza().get(n2).getNum() + 1);
                       break;
                    }
                 }
                 
                 for (int m = 0; m < data.getPizza().size(); m++) {
                       if (data.getPizza().get(m).getCheese().getName().equals(shoppingCart.getSet().get(n).getPizza().getCheese().getName())) {
                           data.getPizza().get(m).getCheese().setNum(data.getPizza().get(m).getCheese().getNum()+shoppingCart.getSet().get(n).getPizza().getCheese().getNum()); //+= shoppingCart.getPizza().get(n).getCheese().getNum();
                           break;
                        }
                 }
                     for (int m = 0; m < data.getPizza().size(); m++){
                        if (data.getPizza().get(m).getSauce().getName().equals(shoppingCart.getSet().get(n).getPizza().getSauce().getName())) {
                           data.getPizza().get(m).getSauce().setNum(data.getPizza().get(m).getSauce().getNum()+shoppingCart.getSet().get(n).getPizza().getSauce().getNum()); //+= shoppingCart.getPizza().get(n).getSauce().getNum();
                           break;
                        }
                     }        
                     for (int m = 0; m < data.getPizza().size(); m++) {
                        if (data.getPizza().get(m).getDough().getName().equals(shoppingCart.getSet().get(n).getPizza().getDough().getName())) {
                           data.getPizza().get(m).getDough().setNum(data.getPizza().get(m).getDough().getNum()+shoppingCart.getSet().get(n).getPizza().getDough().getNum()); //+= shoppingCart.getPizza().get(n).getDough().getNum();
                           break;
                        }
                    }
                     for (int m1 = 0; m1 < shoppingCart.getSet().get(n).getPizza().getIngredient().size(); m1++) {
                        for (int m2 = 0; m2 < data.getIngredient().size(); m2++) {
                           if (shoppingCart.getSet().get(n).getPizza().getIngredient().get(m1).getName().equals(data.getIngredient().get(m2).getName())) {
                              data.getIngredient().get(m2).setNum(data.getIngredient().get(m2).getNum()+shoppingCart.getSet().get(n).getPizza().getIngredient().get(m1).getNum()); //+= shoppingCart.getPizza().get(n).getIngredient().get(m1).getNum();
                              break;
                           }
                        }
                    }
              }
              
              if(shoppingCart.getSet().get(n).getChicken() != null) {
                 for(int n2 = 0; n2 < Buyer.data.getChicken().size(); n2++) {
                    if(shoppingCart.getSet().get(n).getChicken().getName().equals(Buyer.data.getChicken().get(n2).getName())){
                       Buyer.data.getChicken().get(n2).setNum(Buyer.data.getChicken().get(n2).getNum() + 1);
                       break;
                    }
                 }
              }
              
              if(shoppingCart.getSet().get(n).getSide() != null) {
                 for(int n2 = 0; n2 < Buyer.data.getSide().size(); n2++) {
                    if(shoppingCart.getSet().get(n).getSide().getName().equals(Buyer.data.getSide().get(n2).getName())){
                       Buyer.data.getSide().get(n2).setNum(Buyer.data.getSide().get(n2).getNum() + 1);
                       break;
                    }
                 }
              }
              
              if(shoppingCart.getSet().get(n).getDrink() != null) {
                 for(int n2 = 0; n2 < Buyer.data.getDrink().size(); n2++) {
                    if(shoppingCart.getSet().get(n).getDrink().getName().equals(Buyer.data.getDrink().get(n2).getName())){
                       Buyer.data.getDrink().get(n2).setNum(Buyer.data.getDrink().get(n2).getNum() + 1);
                       break;
                    }
                 }
              }
           }
           
           
        }
        shoppingCart = null;
  }
}