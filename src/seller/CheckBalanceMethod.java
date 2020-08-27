package seller;

import java.util.Calendar;
import java.util.GregorianCalendar;

import buyer.Buyer;
import data.Data;
import data.Money;

public class CheckBalanceMethod {
   Data data;
   private String str[];

   public CheckBalanceMethod(Data data) {
      this.data = data;
   }

   // 잔고 출력 및 추가 메소드
   void checkBalance() {
      Money[] money;

      System.out.println("[잔고 확인]");

      Calendar now = new GregorianCalendar();
      System.out.printf("\n오늘 날짜 : %tF\n\n", now);
      System.out.format("★ 현재 잔고 : %,8d ★\n", getTotalMoney());
      System.out.println();
      System.out.println("잔고 추가");
      for (int i = 0; i < data.getMoney().length; i++) {
         System.out.format("%d. %,6d원 - %2d개\n", (i + 1), data.getMoney()[i].getName(), data.getMoney()[i].getNum());
      }
      System.out.print(Buyer.printLine);
      addBalance();

   }

   void addBalance() {
      System.out.println("추가할 잔고를 입력하세요(번호,개수)");
      System.out.print(Buyer.message_1);
      str = data.inputString().split(",");
      data.getMoney()[Integer.parseInt(str[0]) - 1]
            .setNum(data.getMoney()[Integer.parseInt(str[0]) - 1].getNum() + Integer.parseInt(str[1]));
      Buyer.cleaner();
      checkBalance();
   }

   int getTotalMoney() {
      int temp = 0;
      for (int i = 0; i < 8; i++) {
         temp += data.getMoney()[i].getName() * data.getMoney()[i].getNum();
      }
      return temp;
   }

}