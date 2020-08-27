/**
 * @ 작성자 : 송수진
 * @ 작성일 : 2020. 3. 13.
 * @ 설   명 : 구매자모드 > 치킨
 */

package buyer;

import java.util.Calendar;
import java.util.GregorianCalendar;

import data.Data;
import data.Stock;

public class ActionChicken {

	Data data;
	private String[] str;
	private int num;
	private Stock temp;
	private Stock temp2;

	public void action() {
		printChicken();
	}

	// 치킨 메뉴 출력하기
	public void printChicken() {
		/// ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★3.13 캘린더 추가하고 if~else 로 나눴음 기혜
		Calendar cal = new GregorianCalendar();
		if (cal.get(Calendar.HOUR_OF_DAY) < Buyer.data.getTimeSale()) {
			System.out.println();
			System.out.println("[치킨 메뉴]");
			System.out.println();

			for (int i = 0; i < Buyer.data.getChicken().size(); i++) {
				System.out.format("%d. %-5s\t  %,36d원\n", i + 1, Buyer.data.getChicken().get(i).getName(),
						Buyer.data.getChicken().get(i).getPrice());
			}

		} else {
			System.out.println();
			System.out.println("[타임 세일 치킨 메뉴]");
			System.out.println();

			for (int i = 0; i < Buyer.data.getTimeChicken().size(); i++) {
				System.out.format("%d. %-5s\t  %,36d원\n", i + 1, Buyer.data.getTimeChicken().get(i).getName(),
						Buyer.data.getTimeChicken().get(i).getPrice());
			}
		}
		System.out.println(Buyer.printLine);
		System.out.print("메뉴를 선택하세요(홈→*, 뒤로가기→/) : ");

		// 입력받은 값 split으로 분리하기
		str = Buyer.data.inputString().split(",");

		num = Integer.parseInt(str[0]); // 입력한 수 2 (양념치킨 선택)
		temp = Buyer.data.getChicken().get(num - 1); // 1번지인 양념치킨을 temp에 담기
		temp2 = Buyer.data.getTimeChicken().get(num - 1);

		if (str.length == 1) { // 길이가 1이면 뼈 선택
			inputChicken(); // 뼈 일때의 치킨 추가 메소드

		} else {
			System.out.println("\n메뉴를 정확히 입력해주세요.\n");
			printChicken();
		}

	}

	// 뼈 일때의 치킨 추가 메소드
	void inputChicken() { // temp데이터 수량 확인 후 장바구니 추가 및 수량 빠지기
		Calendar cal = new GregorianCalendar();
		if (cal.get(Calendar.HOUR_OF_DAY) < Buyer.data.getTimeSale()) {
			if (temp.getNum() != 0) {
				Buyer.shoppingCart.getChicken().add(temp);
				temp.setNum(temp.getNum() - 1);
			} else {
				System.out.println("품절된 상품입니다.");
			}
		}
		else {
			if (temp.getNum() != 0) {
				Buyer.shoppingCart.getChicken().add(temp2);
				temp.setNum(temp.getNum() - 1);
			} else {
				System.out.println("품절된 상품입니다.");
			}
		}
		

	}

}