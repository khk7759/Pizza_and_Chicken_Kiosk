package seller;

import java.util.ArrayList;

import buyer.Buyer;
import data.Data;
import data.Pizza;
import data.Stock;

/**
 * Date : 2020. 3. 10. Writer : Choi Cheol Nyeong Contents : 피자메뉴 출력 피자 추가,수정,삭제
 */
public class PizzaMethod {
	Data data;

	public PizzaMethod(Data data) {
		this.data = data;
	}

	public void printPizza() {
		String[] str;
		System.out.println("[피자]");
		System.out.println();
		for (int i = 0; i < data.getPizza().size(); i++) {
			System.out.format("%d. %-9s\t %,29d원\n", (i + 1), data.getPizza().get(i).getName(),
					data.getPizza().get(i).getPrice());
		}
		System.out.println(Buyer.printLine);
		System.out.println("- 추가 (1)");
		System.out.println("- 수정 (2,수정할 피자 번호)");
		System.out.println("- 삭제 (3,피자 번호)");
		System.out.print(Buyer.message_1);

		str = data.inputString().split(",");

		switch (Integer.parseInt(str[0])) {
		case 1:
			System.out.println();
			 if(data.getPizza().size()<10)
			pizzaAdd();
			 printPizza();
			break;
		case 2:
			System.out.println();
			pizzaModify(str);
			printPizza();
			break;
		case 3:
			System.out.println();
			pizzaDelete(str);
			printPizza();
			break;
		}

	}

	void pizzaAdd() {
		String[] str;
		String[] str2;
		String temp1;
		Stock temp2;
		Stock temp3;
		ArrayList<Stock> temp4 = new ArrayList<Stock>();
		int temp5;
		System.out.println("[추가]");
		System.out.print("피자의 이름: ");
		temp1 = data.inputString();
		System.out.println("피자의 재료");

		System.out.print("치즈 → ");
		for (int i = 0; i < data.getCheese().size(); i++) {
			System.out.printf("%d %s ", i + 1, data.getCheese().get(i).getName());
		}
		System.out.print(" : ");
		temp2 = data.getCheese().get(data.input() - 1);

		System.out.print("소스 → ");
		for (int i = 0; i < data.getSauce().size(); i++) {
			System.out.printf("%d %s ", i + 1, data.getSauce().get(i).getName());
		}
		System.out.print(" : ");
		temp3 = data.getSauce().get(data.input() - 1);
		System.out.print("재료 → ");
		for (int i = 0; i < data.getIngredient().size(); i++) {
			System.out.printf("%s ", data.getIngredient().get(i).getName());		
		}
		System.out.println();
		System.out.println("필요한 재료 입력(ex.감자:2,양파:1) : ");
		str = data.inputString().split(",");
		for (int i = 0; i < str.length; i++) {
			str2 = str[i].split(":");
			Stock s = new Stock(str2[0], 0);
			s.setNum(Integer.parseInt(str2[1]));
			temp4.add(s);
		}
		System.out.print("피자의 가격 : ");
		temp5 = data.input();
		pizzaOk(temp1, temp2, temp3, temp4, temp5);

	}

	void pizzaOk(String temp1, Stock temp2, Stock temp3, ArrayList<Stock> temp4, int temp5) {
		System.out.println();
		System.out.println("[추가]");
		System.out.println("피자의 이름 : " + temp1);
		System.out.println("피자의 재료 : " + temp2.getName() + ", " + temp3.getName());
		System.out.print("토핑 :");
		for (int i = 0; i < temp4.size(); i++) {
			System.out.printf("%s %d ", temp4.get(i).getName(), temp4.get(i).getNum());
		}
		System.out.println();
		System.out.format("피자의 가격 : %,d원\n", temp5);
		System.out.print("추가하려면 (Y / N) : ");
		if (data.inputString().charAt(0) == 'Y' || data.inputString().charAt(0) == 'y') {
			data.getPizza().add(new Pizza(temp1, temp2, temp3, temp4, temp5, 10));

		}

	}

	void pizzaOk2(int num, String temp1, Stock temp2, Stock temp3, ArrayList<Stock> temp4, int temp5) {
		System.out.println();
		System.out.println("[추가]");
		System.out.println("피자의 이름 : " + temp1);
		System.out.println("피자의 재료 : " + temp2.getName() + ", " + temp3.getName());
		System.out.print("토핑 :");
		for (int i = 0; i < temp4.size(); i++) {
			System.out.printf("%s %d ", temp4.get(i).getName(), temp4.get(i).getNum());
		}
		System.out.println();
		System.out.format("피자의 가격 : %,d원\n", temp5);
		System.out.print("추가하려면 (Y / N) : ");
		if (data.inputString().charAt(0) == 'Y' || data.inputString().charAt(0) == 'y') {
			Pizza p2 = new Pizza(temp1, temp2, temp3, temp4, temp5);
			data.getPizza().set(num, p2);

		}
	}

	void pizzaModify(String[] s) {
		int num = Integer.parseInt(s[1]);
		Pizza p = data.getPizza().get(num - 1);
		System.out.println();
		System.out.println("[수정]");
		System.out.println();
		System.out.println("피자의 이름 : " + p.getName());
		System.out.println("피자의 재료 : " + p.getCheese().getName() + ", " + p.getSauce().getName());
		System.out.print("토핑 :");
		for (int i = 0; i < p.getIngredient().size(); i++) {
			System.out.printf("%s %d ", p.getIngredient().get(i).getName(), p.getIngredient().get(i).getNum());
		}
		System.out.println();
		System.out.format("피자의 가격 : %,d원\n", p.getPrice());
//               if(data.inputString().charAt(0)=='Y') {
//                  data.pizza.add(new Pizza(p.name, p.getCheese(), p.getSause(), p.getIngredient(), p.price));
//               }

		System.out.println(Buyer.printLine);

		String[] str;
		String[] str2;
		String temp1;
		Stock temp2;
		Stock temp3;
		ArrayList<Stock> temp4 = new ArrayList<Stock>();
		int temp5;
		System.out.println();
		System.out.println("[수정]");
		System.out.print("피자의 이름: ");
		temp1 = data.inputString();
		System.out.println("피자의 재료");

		System.out.print("치즈 → ");
		for (int i = 0; i < data.getCheese().size(); i++) {
			System.out.printf("%d %s ", i + 1, data.getCheese().get(i).getName());
		}
		System.out.print(" : ");
		temp2 = data.getCheese().get(data.input() - 1);

		System.out.print("소스 → ");
		for (int i = 0; i < data.getSauce().size(); i++) {
			System.out.printf("%d %s ", i + 1, data.getSauce().get(i).getName());
		}
		System.out.print(" : ");
		temp3 = data.getSauce().get(data.input() - 1);
		System.out.print("재료 → ");
		for (int i = 0; i < data.getIngredient().size(); i++) {
			System.out.printf("%s ", data.getIngredient().get(i).getName());
		}
		System.out.println();
		System.out.println("필요한 재료 입력(ex.감자:2,양파:1) : ");
		str = data.inputString().split(",");
		for (int i = 0; i < str.length; i++) {
			str2 = str[i].split(":");
			Stock st = new Stock(str2[0], 0);
			st.setNum(Integer.parseInt(str2[1]));
			temp4.add(st);
		}
		System.out.print("피자의 가격 : ");
		temp5 = data.input();
		pizzaOk2(num - 1, temp1, temp2, temp3, temp4, temp5);

	}

	void pizzaDelete(String[] str) {
		int num = Integer.parseInt(str[1]);
		data.getPizza().remove(num - 1);
	}

}