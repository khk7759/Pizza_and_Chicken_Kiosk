package seller;

import buyer.Buyer;
import buyer.GoHomeException;
import data.*;

public class ExitMethod {

   Data data;

   void printExit() {

      System.out.println("[프로그램 종료]");
      System.out.println();
      System.out.println("프로그램을 종료하시겠습니까? (Y/N)");
      System.out.print("(홈→*, 뒤로가기→/): ");

      switch (Buyer.inputString()) {
      case "Y": case "y":
         System.out.println("\n프로그램이 종료되었습니다.");
         System.exit(-1);
         break;
      case "N": case "n":
         throw new GoHomeException();
      
      }
   }
}