package seller;

import buyer.Buyer;
import buyer.GoHomeException;
import data.*;

public class ModeTransMethod {

   Data data;

   public void printMode() {
      Buyer.cleaner();
      System.out.println("\n[사용자 모드 전환]");
      System.out.println();
      System.out.println("판매자 모드를 종료하고 사용자 모드로 전환하시겠습니까?");
      System.out.println();
      System.out.println("※사용자 모드로 전환시 판매자 모드에서 수정된 데이터들은\n  사용자 모드에 적용되어 출력됩니다.");
      System.out.println();
      System.out.print(Buyer.printLine);
      System.out.println("예/아니오 를 입력하세요 (Y/N)");
      System.out.print(Buyer.message_1);    

      switch (Buyer.inputString()) {
      case "Y": case "y":
         return;
      case "N": case "n": 
         throw new GoHomeException();
      }
      
   }
}