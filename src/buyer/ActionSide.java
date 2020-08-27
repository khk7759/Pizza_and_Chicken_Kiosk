/**
 * Date : 2020. 3. 11.
 * Writer : Choi Cheol Nyeong
 * Contents : 사이드 메뉴 
 */

package buyer;

import java.util.ArrayList;

import data.Data;
import data.Stock;

public class ActionSide {
	public void action() {
		printSide();
	}

	public void printSide() {

		String str;
		int num;
		Stock temp;
		System.out.println("[사이드메뉴 화면]");
		System.out.println();
		for (int i = 0; i < Buyer.data.getSide().size(); i++) {
			System.out.format("%d. %-12s\t\t  %,20d원\n", i + 1, Buyer.data.getSide().get(i).getName(),
					Buyer.data.getSide().get(i).getPrice());
		}

		System.out.print(Buyer.printLine + Buyer.message_1);
		str = Buyer.data.inputString();
		num = Integer.parseInt(str);
		temp = Buyer.data.getSide().get(num - 1);
		if (temp.getNum() != 0) {
			Buyer.shoppingCart.getSide().add(temp);
			temp.setNum(temp.getNum() - 1);
			// System.out.println(temp1.get(0).name);
		} else {
			System.out.println("품절된 상품입니다.");
		}

	}

}
