/*
 * @ 작성자 : 장기혜
 * @ 작성일 : 2020.03.10
 * @ 설  명 : 판매자모드>메뉴추가>음료
 */

package seller;

import buyer.Buyer;
import data.Data;
import data.Stock;

public class DrinkMethod {
	Data data;

	public DrinkMethod(Data data) {
		this.data = data;
	}

	public void printDrink() {
		String[] str;
		System.out.println();
		System.out.println("[음료]");
		System.out.println();
		for (int i = 0; i < data.getDrink().size(); i++) {
			System.out.format("%d. %-5s\t  %,36d원\n", (i + 1), data.getDrink().get(i).getName(),
					data.getDrink().get(i).getPrice());
		}
		for (int i = data.getDrink().size(); i < (data.getDrink().size()) + (data.getAdultDrink().size()); i++) {
			System.out.format("%d. %-5s\t  %,21d원 (성인인증음료)\n", (i + 1),
					data.getAdultDrink().get(i - data.getDrink().size()).getName(),
					data.getAdultDrink().get(i - data.getDrink().size()).getPrice());
		}
		System.out.print(Buyer.printLine);
		System.out.println("- 추가 (1,음료명, 가격,성인인증여부(Y/N))");
		System.out.println("- 수정 (2,수정할 음료 번호,수정할 가격)");
		System.out.println("- 삭제 (3,음료 번호)");
		System.out.print(Buyer.message_1);
		str = data.inputString().split(",");
		switch (Integer.parseInt(str[0])) {
		case 1:
			Buyer.cleaner();
			if (data.getDrink().size() + data.getAdultDrink().size() < 10)
				drinkAdd(str);
			printDrink();
			break;
		case 2:
			Buyer.cleaner();
			drinkModify(str);
			printDrink();
			break;
		case 3:
			Buyer.cleaner();
			drinkDelete(str);
			printDrink();
			break;
		}
	}

	void drinkAdd(String[] str) {
		if (str[3].charAt(0) == 'Y' || str[3].charAt(0) == 'y') {
			data.getAdultDrink().add(new Stock(str[1], Integer.parseInt(str[2])));
			Buyer.cleaner();
			printDrink();
		} else if (str[3].charAt(0) == 'N' || str[3].charAt(0) == 'n') {
			data.getDrink().add(new Stock(str[1], Integer.parseInt(str[2])));
			Buyer.cleaner();
			printDrink();
		}

	}

	void drinkModify(String[] str) {
		int num = Integer.parseInt(str[1]);
		if (num > data.getDrink().size()) {
			data.getAdultDrink().get(num - data.getDrink().size() - 1).setPrice(Integer.parseInt(str[2]));
			Buyer.cleaner();
			printDrink();
		} else {
			data.getDrink().get(num - 1).setPrice(Integer.parseInt(str[2]));
			Buyer.cleaner();
			printDrink();
		}

	}

	void drinkDelete(String[] str) {
		int num = Integer.parseInt(str[1]);

		if (num > data.getDrink().size()) {
			data.getAdultDrink().remove(num - data.getDrink().size() - 1);
			Buyer.cleaner();
			printDrink();
		}

		else {
			data.getDrink().remove(num - 1);
			Buyer.cleaner();
			printDrink();
		}

	}

}