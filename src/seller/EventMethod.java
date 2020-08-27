/*
 * @ 작성자 : 장기혜
 * @ 작성일 : 2020.03.10
 * @ 설  명 : 
 */
package seller;

import data.Data;
import data.Stock;
import data.Set;

import data.Coupon;
import data.Pizza;
import java.util.Random;

import buyer.Buyer;

public class EventMethod {
	Data data;
	String[] str;

	public EventMethod(Data data) {
		this.data = data;

	}

	public void printEventMethod() {
		System.out.println();
		System.out.println("[이벤트 관리]");
		System.out.println();
		System.out.println("1. 타임세일 이벤트 관리");
		System.out.println("2. 쿠폰 발행 이벤트 관리");
		System.out.println("3. 랜덤메뉴 이벤트 관리");
		System.out.println(Buyer.printLine);
		System.out.print("관리할 이벤트를 선택하세요");
		System.out.print("(홈→*) : ");

		switch (data.input()) {

		// 타임세일 이벤트 관리
		case 1:
			Buyer.cleaner();
			System.out.println("[타임세일 이벤트 관리]");
			System.out.println();
			System.out.println("1.시간 설정 관리");
			System.out.println("2.메뉴 및 가격 설정 관리");
			System.out.println(Buyer.printLine);
			System.out.print("관리할 목록을 선택하세요");
			System.out.print("(홈→*) : ");

			switch (data.input()) {
			case 1:
				Buyer.cleaner();
				timeSale();
				break;
			case 2:
				Buyer.cleaner();
				timeSaleMenu();
				break;
			}
			break;

		// 쿠폰 발행 이벤트 관리
		case 2:
			Buyer.cleaner();
			System.out.println("[쿠폰 발행 이벤트 관리]");
			System.out.println();
			System.out.println("1.쿠폰 설정 관리");
			System.out.println("2.쿠폰 발행 기준 관리");
			System.out.println(Buyer.printLine);
			System.out.print("관리할 목록을 선택하세요(홈→*) : ");
			switch (data.input()) {
			case 1:
				Buyer.cleaner();
				couponModify();
				break;
			case 2:
				Buyer.cleaner();
				couponStendardMethod();
				break;
			}
			break;

		// 랜덤메뉴 이벤트 관리
		case 3:
			Buyer.cleaner();
			System.out.println("[랜덤 메뉴 이벤트 관리]");
			System.out.println();
			System.out.println("1. 랜덤 메뉴 설정하기");
			System.out.println("2. 가위바위보 게임 사은품 설정하기");
			System.out.println(Buyer.printLine);
			System.out.print("관리할 목록을 선택하세요");
			System.out.print("(홈→*) : ");
			switch (data.input()) {
			case 1:
				Buyer.cleaner();
				System.out.println("[랜덤 메뉴 설정하기]");
				System.out.println();
				System.out.println("1. 피자");
				System.out.println("2. 치킨");
				System.out.println("3. 랜덤 메뉴 설정 확인하기");
				System.out.println(Buyer.printLine);
				System.out.print("관리할 목록을 선택하세요(홈→*) : ");
				switch (data.input()) {
				case 1:
					Buyer.cleaner();
					randomPizzeSetMethod();
					break;
				case 2:
					Buyer.cleaner();
					randomChickenSetMethod();
					break;
				case 3:
					Buyer.cleaner();
					randomSetMethod();
					break;
				}
				break;
			case 2:
				Buyer.cleaner();
				giftSetMethod();
				break;
			}

		} // 이벤트 관리 메인 화면 1번째 switch end
	}// printEventMethod() end

// --------------------------------------------------------------- 타임세일 시간 설정 메소드
	void timeSale() {
		char answer;
		System.out.println();
		System.out.println("[타임세일 시간 설정 관리]");
		System.out.print("타임 세일 시간을 설정하시겠습니까?(Y/N) : ");
		answer = data.inputString().charAt(0);

		if (answer == 'y' || answer == 'Y') {
			System.out.println();
			System.out.println("타임 세일 시간을 몇 시로 설정하시겠습니까?");
			System.out.print("(오후 12시가 넘어가면 ex.13시로 입력)(홈→*) : ");
			data.setTimeSale(data.input());
			System.out.println();
			System.out.printf("타임 세일 시간이 %d시로 설정되었습니다.\n", data.getTimeSale());
		}
		System.out.print(Buyer.message_1);
		Buyer.inputString();

	}

//-------------------------------------------------------------------- 타임세일 메뉴 설정 메소드
	void timeSaleMenu() {

		char answer;

		// 치킨메뉴 중 선택
		System.out.println("[치킨 메뉴 및 가격 설정 관리]");

		System.out.println();

		for (int i = 0; i < data.getChicken().size(); i++) {
			System.out.format("%d. %-5s\t  %,36d원\n", (i + 1), data.getChicken().get(i).getName(),
					data.getChicken().get(i).getPrice());

		}
		System.out.println(Buyer.printLine);

		do {
			System.out.print("가격 할인을 설정 하시겠습니까?(Y/N) : ");
			answer = data.inputString().charAt(0);

			if (answer == 'y' || answer == 'Y') {
				System.out.println("- 설정(설장할 치킨 번호,적용할 할인율 입력(,구분)");
				System.out.print("(홈→*) : ");
				str = data.inputString().split(",");
				data.setNowDiscount(Integer.parseInt(str[1]));
				double minus = ((100 - data.getNowDiscount()) / 100.0);
				data.getTimeChicken().get(Integer.parseInt(str[0]) - 1)
						.setPrice((int) (data.getTimeChicken().get(Integer.parseInt(str[0]) - 1).getPrice() * minus));
			}
		} while (answer != 'N' && answer != 'n');

		System.out.println();
		System.out.println();
		System.out.println("[타임 세일 치킨 메뉴] 설정 확인");
		System.out.println();
		for (int i = 0; i < data.getTimeChicken().size(); i++) {
			System.out.format("%d. %-5s\t  %,36d원\n", (i + 1), data.getTimeChicken().get(i).getName(),
					data.getTimeChicken().get(i).getPrice());

		}
		System.out.println(Buyer.printLine);
		System.out.print(Buyer.message_1);
		Buyer.inputString();

	}

//----------------------------------------------------------------------------- 쿠폰 할인율 설정 메소드
	void couponModify() {
		System.out.println("[쿠폰 설정 관리]");
		System.out.printf("현재 설정 쿠폰  할인율 : %d\n", data.getNowDiscount());
		System.out.println(Buyer.printLine);
		System.out.print("적용할 할인율 입력(홈→*) : ");
		data.setNowDiscount(data.input());
		System.out.printf("%d%% 할인 쿠폰이 적용되었습니다.\n", data.getNowDiscount());
		System.out.println();
		System.out.print(Buyer.message_1);
		Buyer.inputString();

	}

//------------------------------------------------------------------------------- 쿠폰 기준 설정 메소드
	void couponStendardMethod() {
		do {
			System.out.println("쿠폰 발행 기준 금액을 입력해주세요(1.이상 2.이하, 금액)");
			System.out.print("(홈→*) : ");
			str = data.inputString().split(",");

			if (Integer.parseInt(str[0]) == 1) { // 이상

				data.setCouponMoney(Integer.parseInt(str[1]));
				data.setCouponStandard(1);

				System.out.format("구매자가 %,d원 이상 구매 시 쿠폰이 발행됩니다.\n", data.getCouponMoney());

			} else if ((Integer.parseInt(str[0]) == 2)) { // 이하

				data.setCouponMoney(Integer.parseInt(str[1]));
				data.setCouponStandard(2);

				System.out.format("고객이 %,d원 이하 구매 시 쿠폰이 발행됩니다.\n", data.getCouponMoney());
			}

		} while (Integer.parseInt(str[0]) != 1 && Integer.parseInt(str[0]) != 2);
		System.out.println();
		System.out.print(Buyer.message_1);
		Buyer.inputString();
	}

//---------------------------------------------------------------------------------- 사은품 설정 메소드
	void giftSetMethod() {
		System.out.println();
		System.out.println("[가위바위보 게임 사은품 설정하기]");
		System.out.println("음료에 한해서만 설정 가능!");
		for (int i = 0; i < data.getDrink().size(); i++) {
			System.out.format("%d. %6s\n", (i + 1), data.getDrink().get(i).getName());
		}
		System.out.println(Buyer.printLine);
		System.out.printf("현재 사은품 : %s", data.getGifts().get(0).getName());
		System.out.println();
		System.out.print("어떤 제품을 사은품으로 설정하시겠습니까?(음료번호) : ");

		int num = data.input();

		Stock temp = new Stock("", 0, 0);
		temp.setName(data.getDrink().get(num - 1).getName());
		temp.setPrice(data.getDrink().get(num - 1).getPrice());
		temp.setNum(data.getDrink().get(num - 1).getNum());

		data.getGifts().get(0).setPrice(0);

		System.out.printf("[%s]제품이 사은품으로 설정되었습니다.(홈→*) : \n", data.getGifts().get(0).getName());
		Buyer.inputString();
	}

//--------------------------------------------------------------------------------- 랜덤 메뉴 피자 메소드
	void randomPizzeSetMethod() {
		char answer;
		System.out.println();
		System.out.println("[피자]");
		System.out.println();
		for (int i = 0; i < data.getPizza().size(); i++) {
			System.out.format("%d. %-9s\t %,29d원\n", (i + 1), data.getPizza().get(i).getName(),
					data.getPizza().get(i).getPrice());
		}
		System.out.println(Buyer.printLine);
		System.out.println("- 1. 추가");
		System.out.println("- 2. 삭제 ");
		System.out.print("(홈→*) : ");

		// ============ 피자 추가
		switch (data.input()) {

		case 1:
			do {
				System.out.println();
				System.out.print("[랜덤 메뉴 이벤트]목록에 피자를 추가하시겠습니까?(Y/N) : ");
				answer = data.inputString().charAt(0);

				if (answer == 'y' || answer == 'Y') {
					System.out.print("추가할 피자 번호,적용할 할인율 입력 (홈→*): ");
					str = data.inputString().split(",");

					Pizza temp = new Pizza("", null, null, null, 0, 0);
					temp.setName(data.getPizza().get(Integer.parseInt(str[0]) - 1).getName());
					temp.setCheese(data.getPizza().get(Integer.parseInt(str[0]) - 1).getCheese());
					temp.setSauce(data.getPizza().get(Integer.parseInt(str[0]) - 1).getSauce());
					temp.setIngredient(data.getPizza().get(Integer.parseInt(str[0]) - 1).getIngredient());
					temp.setPrice(data.getPizza().get(Integer.parseInt(str[0]) - 1).getPrice());
					temp.setNum(data.getPizza().get(Integer.parseInt(str[0]) - 1).getNum());
					data.getRandomPizza().add(temp);

					double minus = ((100 - data.getNowDiscount()) / 100.0);
					data.getRandomPizza().get(Integer.parseInt(str[0]) - 1).setPrice(
							(int) (data.getRandomPizza().get(Integer.parseInt(str[0]) - 1).getPrice() * minus));

				}
			} while (answer != 'N' && answer != 'n');

			Buyer.cleaner();
			System.out.println("[피자 랜덤 메뉴]");
			System.out.println();
			for (int i = 0; i < data.getRandomPizza().size(); i++) {
				System.out.format("- %-9s\t %,29d원\n", data.getRandomPizza().get(i).getName(),
						data.getRandomPizza().get(i).getPrice());
			}
			System.out.println(Buyer.printLine);
			System.out.print(Buyer.message_1);
			Buyer.inputString();

			break;
		case 2:
			do {
				System.out.println();
				System.out.print("[랜덤 메뉴 이벤트]목록에 피자를 삭제하시겠습니까?(Y/N) : ");
				answer = data.inputString().charAt(0);

				if (answer == 'y' || answer == 'Y') {
					System.out.println();
					System.out.println("[피자 랜덤 메뉴]");
					System.out.println();
					for (int i = 0; i < data.getRandomPizza().size(); i++) {
						System.out.format("- %-5s %,36d원\n", data.getRandomPizza().get(i).getName(),
								data.getRandomPizza().get(i).getPrice());
					}
					System.out.println(Buyer.printLine);
					System.out.print("삭제할 피자 번호입력 (홈→*): ");

					data.getRandomPizza().remove(data.input());
				}
			} while (answer != 'N' && answer != 'n');
			System.out.print(Buyer.message_1);
			Buyer.inputString();

			break;
		}
	}

//------------------------------------------------------------------------------------- 랜덤 메뉴 치킨 메소드
	void randomChickenSetMethod() {

		char answer;
		System.out.println();
		System.out.println("[치킨]");
		System.out.println();
		for (int i = 0; i < data.getChicken().size(); i++) {
			System.out.format("%d. %-5s\t  %,36d원\n", (i + 1), data.getChicken().get(i).getName(),
					data.getChicken().get(i).getPrice());
		}
		System.out.println(Buyer.printLine);
		System.out.println("- 1. 추가");
		System.out.println("- 2. 삭제 ");
		System.out.print("(홈→*) : ");

		// ===========================치킨 추가
		switch (data.input()) {
		case 1:
			do {
				System.out.println();
				System.out.print("[랜덤 메뉴 이벤트]목록에 치킨을 추가하시겠습니까?(Y/N) : ");
				answer = data.inputString().charAt(0);

				if (answer == 'y' || answer == 'Y') {
					System.out.print("추가할 치킨 번호,적용할 할인율 입력 (홈→*): ");
					str = data.inputString().split(",");

					Stock temp = new Stock("", 0, 0);
					temp.setName(data.getChicken().get(Integer.parseInt(str[0]) - 1).getName());
					temp.setPrice(data.getChicken().get(Integer.parseInt(str[0]) - 1).getPrice());
					temp.setNum(data.getChicken().get(Integer.parseInt(str[0]) - 1).getNum());
					data.getRandomChicken().add(temp);

					data.setNowDiscount(Integer.parseInt(str[1]));
					double minus = ((100 - data.getNowDiscount()) / 100.0);
					data.getRandomChicken().get(Integer.parseInt(str[0]) - 1).setPrice(
							(int) (data.getRandomChicken().get(Integer.parseInt(str[0]) - 1).getPrice() * minus));

				}

			} while (answer != 'N' && answer != 'n');
			
			Buyer.cleaner();
			System.out.println("[치킨 랜덤 메뉴]");
			System.out.println();
			for (int i = 0; i < data.getRandomChicken().size(); i++) {
				System.out.format("- %-5s\t  %,36d원\n", data.getChicken().get(i).getName(),
						data.getRandomChicken().get(i).getPrice());
			}
			System.out.println(Buyer.printLine);
			System.out.print(Buyer.message_1);
			Buyer.inputString();
			break;

		// ============================= 치킨 삭제
		case 2:
			do {
				System.out.println();
				System.out.print("[랜덤 메뉴 이벤트]목록에 치킨을 삭제하시겠습니까?(Y/N) : ");
				answer = data.inputString().charAt(0);

				if (answer == 'y' || answer == 'Y') {
					System.out.println();
					System.out.println("[치킨 랜덤 메뉴]");
					for (int i = 0; i < data.getRandomChicken().size(); i++) {
						System.out.format("- %-5s\t  %,36d원\n", data.getChicken().get(i).getName(),
								data.getRandomChicken().get(i).getPrice());
					}
					System.out.println(Buyer.printLine);
					System.out.print("삭제할 치킨 번호입력 (홈→*): ");
					data.getRandomChicken().remove(data.input());
				}
			} while (answer != 'N' && answer != 'n');
			System.out.print(Buyer.message_1);
			Buyer.inputString();
			break;

		}

	}

//------------------------------------------------------------------------ 랜덤 세트 메소드 + 랜덤 메뉴 이벤트 확인
	void randomSetMethod() {
		System.out.println();
		System.out.println("[랜덤 메뉴 이벤트]");
		System.out.println();
		System.out.println("1. 세트 랜덤 메뉴");
		System.out.println();
		for (int i = 0; i < data.getRandomPizza().size(); i++) {
			for (int j = 0; j < data.getRandomChicken().size(); j++) {

				System.out.format("- %-5s\t + %-5s\t %,21d원\n", data.getRandomPizza().get(i).getName(),
						data.getChicken().get(j).getName(),
						data.getRandomPizza().get(i).getPrice() + data.getRandomChicken().get(j).getPrice());
			}
		}

		System.out.println();
		System.out.println();
		System.out.println("2. 피자 랜덤 메뉴");
		System.out.println();
		for (int i = 0; i < data.getRandomPizza().size(); i++) {
			System.out.format("- %-9s\t %,29d원\n", data.getRandomPizza().get(i).getName(),
					data.getRandomPizza().get(i).getPrice());
		}
		System.out.println();
		System.out.println();
		System.out.println("3. 치킨 랜덤 메뉴");
		System.out.println();
		for (int i = 0; i < data.getRandomChicken().size(); i++) {
			System.out.format("- %-5s\t  %,36d원\n", data.getChicken().get(i).getName(),
					data.getRandomChicken().get(i).getPrice());
		}
		System.out.println(Buyer.printLine);
		System.out.print(Buyer.message_1);
		Buyer.inputString();

	} // 랜덤 세트 메소드 end

}// class end