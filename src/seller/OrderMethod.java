/*
 * @ 작성자 : 장기혜
 * @ 작성일 : 2020.03.10
 * @ 설  명 : 판매자모드> 재고 확인 및 수동 발주
 */

package seller;

import buyer.Buyer;
import data.Data;

public class OrderMethod {
   Data data;

   public OrderMethod(Data data) {
      this.data = data;
   }

   public void printOrderMethod() {

      String[] str;

      System.out.println("[재고 확인 및 수동 발주]");
      System.out.println();
      System.out.println("1. 피자");
      System.out.println("2. 치킨");
      System.out.println("3. 사이드");
      System.out.println("4. 음료");
      System.out.println("5. 포장용기");
      System.out.print(Buyer.printLine);
      System.out.print("재고를 확인할 메뉴를 선택하세요");
      System.out.print(Buyer.message_1);

      switch (data.input()) {
      case 1:
         Buyer.cleaner();
         System.out.println("[피자]의 재고 확인");
         System.out.println();
         for (int i = 0; i < data.getDough().size(); i++) {
            System.out.printf("%d. %-6s\t  %,36d개\n", (i + 1), data.getDough().get(i).getName(),
                  data.getDough().get(i).getNum());
         }
         for (int i = data.getDough().size(); i < (data.getDough().size()) + (data.getIngredient().size()); i++) {
            System.out.printf("%d. %-7s\t  %,36d개 \n", (i + 1),
                  data.getIngredient().get(i - data.getDough().size()).getName(),
                  data.getIngredient().get(i - data.getDough().size()).getNum());
         }
         System.out.print(Buyer.printLine);
         System.out.println("수동 발주할 재료와 수량을 선택하세요 (재료 번호,주문 수량)");
         System.out.print(Buyer.message_1);

         str = data.inputString().split(",");
         if (Integer.parseInt(str[0]) <= data.getDough().size()) {
            data.getDough().get(Integer.parseInt(str[0]) - 1)
                  .setNum(data.getDough().get(Integer.parseInt(str[0]) - 1).getNum() + Integer.parseInt(str[1]));

            data.getDough().get(Integer.parseInt(str[0]) - 1)
                  .setNum(data.getDough().get(Integer.parseInt(str[0]) - 1).getNum() + Integer.parseInt(str[1])); // 위에꺼
                                                                                          // 복사

            System.out.printf("%s +%d개 수동 발주 완료되었습니다.\n",
                  data.getDough().get(Integer.parseInt(str[0]) - 1).getName(), Integer.parseInt(str[1]));
         } else if (Integer.parseInt(str[0]) > data.getDough().size()) {
            data.getIngredient().get(Integer.parseInt(str[0]) - data.getDough().size() - 1)
                  .setNum(data.getIngredient().get(Integer.parseInt(str[0]) - data.getDough().size() - 1).getNum()
                        + Integer.parseInt(str[1]));
            System.out.printf("%s +%d개 수동 발주 완료되었습니다.\n",
                  data.getIngredient().get(Integer.parseInt(str[0]) - data.getDough().size() - 1).getName(),
                  Integer.parseInt(str[1]));
         }
         System.out.println();
         System.out.print(Buyer.message_1);
         Buyer.inputString();
         break;

      case 2:
         Buyer.cleaner();
         System.out.println("[치킨]의 재고 확인");
         System.out.println();
         for (int i = 0; i < data.getChicken().size(); i++) {
            System.out.printf("%d. %-5s\t  %,36d개\n", (i + 1), data.getChicken().get(i).getName(),
                  data.getChicken().get(i).getNum());
         }
         System.out.print(Buyer.printLine);
         System.out.println("수동 발주할 재료와 수량을 선택하세요 (재료 번호, 주문 수량)");
         System.out.print(Buyer.message_1);
         str = data.inputString().split(",");
         data.getChicken().get(Integer.parseInt(str[0]) - 1)
               .setNum(data.getChicken().get(Integer.parseInt(str[0]) - 1).getNum() + Integer.parseInt(str[1]));
         System.out.printf("%s +%d개 수동 발주 완료되었습니다.\n", data.getChicken().get(Integer.parseInt(str[0]) - 1).getName(),
               Integer.parseInt(str[1]));
         System.out.println();
         System.out.print(Buyer.message_1);
         Buyer.inputString();
         break;

      case 3:
         Buyer.cleaner();
         System.out.println("[사이드]의 재고 확인");
         System.out.println();
         for (int i = 0; i < data.getSide().size(); i++) {
            System.out.printf("%d. %-12s\t\t  %,20d개\n", (i + 1), data.getSide().get(i).getName(),
                  data.getSide().get(i).getNum());
         }
         System.out.print(Buyer.printLine);
         System.out.println("수동 발주할 재료와 수량을 선택하세요 (재료 번호, 주문 수량)");
         System.out.print(Buyer.message_1);
         str = data.inputString().split(",");
         data.getSide().get(Integer.parseInt(str[0]) - 1)
               .setNum(data.getSide().get(Integer.parseInt(str[0]) - 1).getNum() + Integer.parseInt(str[1]));
         System.out.printf("%s +%d개 수동 발주 완료되었습니다.\n", data.getSide().get(Integer.parseInt(str[0]) - 1).getName(),
               Integer.parseInt(str[1]));
         System.out.println();
         System.out.print(Buyer.message_1);
         Buyer.inputString();
         break;

      case 4:
         Buyer.cleaner();
         System.out.println("[음료]의 재고 확인");
         System.out.println();
         for (int i = 0; i < data.getDrink().size(); i++) {
            System.out.printf("%d. %-5s\t  %,36d개\n", (i + 1), data.getDrink().get(i).getName(),
                  data.getDrink().get(i).getNum());
         }
         for (int i = data.getDrink().size(); i < (data.getDrink().size()) + (data.getAdultDrink().size()); i++) {
            System.out.format("%d. %-5s\t  %,21d개 (성인인증음료)\n", (i + 1),
                  data.getAdultDrink().get(i - data.getDrink().size()).getName(),
                  data.getAdultDrink().get(i - data.getDrink().size()).getNum());
         }
         System.out.print(Buyer.printLine);
         System.out.println("수동 발주할 재료와 수량을 선택하세요 (재료 번호, 주문 수량)");
         System.out.print(Buyer.message_1);
         str = data.inputString().split(",");
         if (Integer.parseInt(str[0]) <= data.getDrink().size()) {
            data.getDrink().get(Integer.parseInt(str[0]) - 1)
                  .setNum(data.getDrink().get(Integer.parseInt(str[0]) - 1).getNum() + Integer.parseInt(str[1]));
            System.out.printf("%s +%d개 수동 발주 완료되었습니다.\n",
                  data.getDrink().get(Integer.parseInt(str[0]) - 1).getName(), Integer.parseInt(str[1]));
         } else if (Integer.parseInt(str[0]) > data.getDrink().size()) {
            data.getAdultDrink().get(Integer.parseInt(str[0]) - data.getDrink().size() - 1)
                  .setNum(data.getAdultDrink().get(Integer.parseInt(str[0]) - data.getDrink().size() - 1).getNum()
                        + Integer.parseInt(str[1]));
            System.out.printf("%s +%d개 수동 발주 완료되었습니다.\n",
                  data.getAdultDrink().get(Integer.parseInt(str[0]) - data.getDrink().size() - 1).getName(),
                  Integer.parseInt(str[1]));
         }
         System.out.println();
         System.out.print(Buyer.message_1);
         Buyer.inputString();
         break;

      case 5:
         Buyer.cleaner();
         System.out.println("[포장용기]의 재고 확인");
         System.out.println();
         for (int i = 0; i < data.getPack().size(); i++) {
            System.out.printf("%d. %-5s\t  %,36d개\n", (i + 1), data.getPack().get(i).getName(),
                  data.getPack().get(i).getNum());
         }
         System.out.print(Buyer.printLine);
         System.out.println("수동 발주할 재료와 수량을 선택하세요 (재료 번호, 주문 수량)");
         System.out.print(Buyer.message_1);
         str = data.inputString().split(",");
         data.getPack().get(Integer.parseInt(str[0]) - 1)
               .setNum(data.getPack().get(Integer.parseInt(str[0]) - 1).getNum() + Integer.parseInt(str[1]));

         System.out.printf("%s +%d개 수동 발주 완료되었습니다.\n", data.getPack().get(Integer.parseInt(str[0]) - 1).getName(),
               Integer.parseInt(str[1]));
         System.out.println();
         System.out.print(Buyer.message_1);
         Buyer.inputString();
         break;

      }

   }

}