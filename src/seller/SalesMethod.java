/**
 * @ 작성자 : 송수진
 * @ 작성일 :2020. 3. 10.
 * @ 설   명 : 판매자모드 > 메뉴추가 > 사이드
 */

package seller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;

import buyer.Buyer;
import data.Data;
import data.Pizza;
import data.SalesData;
import data.Set;
import data.Stock;

public class SalesMethod {
   Data data;
   SalesData salesData;

   
   public static int adultDrinkCnt;
   
   
   int []pizzaCount = new int[10];
   int [] chickenCount = new int[10];
   int [] sideCount =new int[10];
   int [] drinkCount = new int[10];
   int [] adultDrinkCount = new int[10];
   

   CheckBalanceMethod checkBalanceMethod;

   public SalesMethod(Data data) {
      this.data = data;
      checkBalanceMethod = new CheckBalanceMethod(data);
      
     
      
   }
   
   
   

   public void printSales() {
      
      System.out.println("\n[매출확인]");
      System.out.println();

      System.out.println("1. 일별 매출 확인 및 관리");
      System.out.println("2. 월별 매출 확인 및 관리");
      System.out.println("=======================================================");
      System.out.println("관리할 매출 메뉴를 선택하세요");
      System.out.print("(홈→*, 뒤로가기→/) : ");

      switch (data.input()) {
      case 1:
        Buyer.cleaner();
         dailySales(); // 일별 수량 체크 메소드
         Buyer.inputString();
         break;
      case 2:
        Buyer.cleaner();
         monthlySales(); // 월별 매출 확인 메소드
         Buyer.inputString();
         break;
      }

   }

   void setCheck() {
       for (int k = 0; k < data.getSalesData().getSetSD().size(); k++) { // 기존 가지고 있던 세트메뉴의 크기만큼

            int setCase = data.getSalesData().getSetSD().get(k).getSetCase(); // k번째의

            Set setTemp = data.getSalesData().getSetSD().get(k);
            switch (setCase) {

            case 1:
               
               for (int i = 0; i < data.getPizza().size(); i++) {//피자 

                  String temp = data.getPizza().get(i).getName(); // 피자 메뉴에 있는값 
                  if (temp.equals(setTemp.getPizza().getName())) {//세트에 있는값 
                     //pizzaCnt++;
                     //System.out.println(data.getPizza().indexOf(data.getSalesData().getPizzaSD().get(i)));
                     //pizzaCount[data.getPizza().indexOf(data.getSalesData().getPizzaSD().get(i))]++;
                     pizzaCount[i]++;
                     //System.out.println("세트에 "+temp+"가 들어있네");
                  } 

               }
               for (int i = 0; i < data.getChicken().size(); i++) {//치킨

                  String temp = data.getChicken().get(i).getName(); // 치킨 메뉴에 있는값 
                  if (temp.equals(setTemp.getChicken().getName())) {//세트에 있는값 
                     //chickenCnt++;
                     //System.out.println("세트에 "+temp+"가 들어있네");
                     chickenCount[i]++;
                  }

               }
               //System.out.println("사이드 크기 : "+data.getSide().size());
               for (int i = 0; i < data.getSide().size(); i++) {//사이드

                  String temp = data.getSide().get(i).getName(); // 사이드 메뉴에 있는값 
                  if (temp.equals(setTemp.getSide().getName())) {//세트에 있는값 
                     //sideCnt++;
                     //System.out.println("세트에 "+temp+"가 들어있네");
                     sideCount[i]++;

                  }

               }
               for (int i = 0; i < data.getDrink().size(); i++) {//음료

                  String temp = data.getDrink().get(i).getName(); // 음료 메뉴에 있는값 
                  if (temp.equals(setTemp.getDrink().getName())) {//세트에 있는값 
                     //drinkCnt++;
                     //System.out.println("세트에 "+temp+"가 들어있네");
                     drinkCount[i]++;

                  }

               }

               break;
            case 2:
               
               for (int i = 0; i < data.getPizza().size(); i++) {//피자 

                  String temp = data.getPizza().get(i).getName(); // 피자 메뉴에 있는값 
                  if (temp.equals(setTemp.getPizza().getName())) {//세트에 있는값 
                     //pizzaCnt++;
                     //System.out.println(data.getPizza().indexOf(data.getSalesData().getPizzaSD().get(i)));
                     //pizzaCount[data.getPizza().indexOf(data.getSalesData().getPizzaSD().get(i))]++;
                     pizzaCount[i]++;
                     //System.out.println("세트에 "+temp+"가 들어있네");
                  } 

               }
            
               //System.out.println("사이드 크기 : "+data.getSide().size());
               for (int i = 0; i < data.getSide().size(); i++) {//사이드

                  String temp = data.getSide().get(i).getName(); // 사이드 메뉴에 있는값 
                  if (temp.equals(setTemp.getSide().getName())) {//세트에 있는값 
                     //sideCnt++;
                     //System.out.println("세트에 "+temp+"가 들어있네");
                     sideCount[i]++;

                  }

               }
               for (int i = 0; i < data.getDrink().size(); i++) {//음료

                  String temp = data.getDrink().get(i).getName(); // 음료 메뉴에 있는값 
                  if (temp.equals(setTemp.getDrink().getName())) {//세트에 있는값 
                     //drinkCnt++;
                     //System.out.println("세트에 "+temp+"가 들어있네");
                     drinkCount[i]++;

                  }

               }
               break;
            case 3:
               
               for (int i = 0; i < data.getPizza().size(); i++) {//피자 

                  String temp = data.getPizza().get(i).getName(); // 피자 메뉴에 있는값 
                  if (temp.equals(setTemp.getPizza().getName())) {//세트에 있는값 
                     //pizzaCnt++;
                     //System.out.println(data.getPizza().indexOf(data.getSalesData().getPizzaSD().get(i)));
                     //pizzaCount[data.getPizza().indexOf(data.getSalesData().getPizzaSD().get(i))]++;
                     pizzaCount[i]++;
                     //System.out.println("세트에 "+temp+"가 들어있네");
                  } 

               }
               for (int i = 0; i < data.getChicken().size(); i++) {//치킨

                  String temp = data.getChicken().get(i).getName(); // 치킨 메뉴에 있는값 
                  if (temp.equals(setTemp.getChicken().getName())) {//세트에 있는값 
                     //chickenCnt++;
                     //System.out.println("세트에 "+temp+"가 들어있네");
                     chickenCount[i]++;
                  }

               }
               
               for (int i = 0; i < data.getDrink().size(); i++) {//음료

                  String temp = data.getDrink().get(i).getName(); // 음료 메뉴에 있는값 
                  if (temp.equals(setTemp.getDrink().getName())) {//세트에 있는값 
                     //drinkCnt++;
                     //System.out.println("세트에 "+temp+"가 들어있네");
                     drinkCount[i]++;

                  }

               }
               break;
            case 4:
               
               for (int i = 0; i < data.getPizza().size(); i++) {//피자 

                  String temp = data.getPizza().get(i).getName(); // 피자 메뉴에 있는값 
                  if (temp.equals(setTemp.getPizza().getName())) {//세트에 있는값 
                     //pizzaCnt++;
                     //System.out.println(data.getPizza().indexOf(data.getSalesData().getPizzaSD().get(i)));
                     //pizzaCount[data.getPizza().indexOf(data.getSalesData().getPizzaSD().get(i))]++;
                     pizzaCount[i]++;
                     //System.out.println("세트에 "+temp+"가 들어있네");
                  } 

               }
               for (int i = 0; i < data.getChicken().size(); i++) {//치킨

                  String temp = data.getChicken().get(i).getName(); // 치킨 메뉴에 있는값 
                  if (temp.equals(setTemp.getChicken().getName())) {//세트에 있는값 
                     //chickenCnt++;
                     //System.out.println("세트에 "+temp+"가 들어있네");
                     chickenCount[i]++;
                  }

               }
               //System.out.println("사이드 크기 : "+data.getSide().size());
               for (int i = 0; i < data.getSide().size(); i++) {//사이드

                  String temp = data.getSide().get(i).getName(); // 사이드 메뉴에 있는값 
                  if (temp.equals(setTemp.getSide().getName())) {//세트에 있는값 
                     //sideCnt++;
                     //System.out.println("세트에 "+temp+"가 들어있네");
                     sideCount[i]++;

                  }

               }
               
               break;
            case 5:
               
               for (int i = 0; i < data.getPizza().size(); i++) {//피자 

                  String temp = data.getPizza().get(i).getName(); // 피자 메뉴에 있는값 
                  if (temp.equals(setTemp.getPizza().getName())) {//세트에 있는값 
                     //pizzaCnt++;
                     //System.out.println(data.getPizza().indexOf(data.getSalesData().getPizzaSD().get(i)));
                     //pizzaCount[data.getPizza().indexOf(data.getSalesData().getPizzaSD().get(i))]++;
                     pizzaCount[i]++;
                     //System.out.println("세트에 "+temp+"가 들어있네");
                  } 

               }

               for (int i = 0; i < data.getDrink().size(); i++) {//음료

                  String temp = data.getDrink().get(i).getName(); // 음료 메뉴에 있는값 
                  if (temp.equals(setTemp.getDrink().getName())) {//세트에 있는값 
                     //drinkCnt++;
                     //System.out.println("세트에 "+temp+"가 들어있네");
                     drinkCount[i]++;

                  }

               }
               break;
            case 6:
               
               for (int i = 0; i < data.getPizza().size(); i++) {//피자 

                  String temp = data.getPizza().get(i).getName(); // 피자 메뉴에 있는값 
                  if (temp.equals(setTemp.getPizza().getName())) {//세트에 있는값 
                     //pizzaCnt++;
                     //System.out.println(data.getPizza().indexOf(data.getSalesData().getPizzaSD().get(i)));
                     //pizzaCount[data.getPizza().indexOf(data.getSalesData().getPizzaSD().get(i))]++;
                     pizzaCount[i]++;
                     //System.out.println("세트에 "+temp+"가 들어있네");
                  } 

               }
               
               //System.out.println("사이드 크기 : "+data.getSide().size());
               for (int i = 0; i < data.getSide().size(); i++) {//사이드

                  String temp = data.getSide().get(i).getName(); // 사이드 메뉴에 있는값 
                  if (temp.equals(setTemp.getSide().getName())) {//세트에 있는값 
                     //sideCnt++;
                     //System.out.println("세트에 "+temp+"가 들어있네");
                     sideCount[i]++;

                  }

               }
               
               break;
            case 7:
               
               for (int i = 0; i < data.getPizza().size(); i++) {//피자 

                  String temp = data.getPizza().get(i).getName(); // 피자 메뉴에 있는값 
                  if (temp.equals(setTemp.getPizza().getName())) {//세트에 있는값 
                     //pizzaCnt++;
                     //System.out.println(data.getPizza().indexOf(data.getSalesData().getPizzaSD().get(i)));
                     //pizzaCount[data.getPizza().indexOf(data.getSalesData().getPizzaSD().get(i))]++;
                     pizzaCount[i]++;
                     //System.out.println("세트에 "+temp+"가 들어있네");
                  } 

               }
               for (int i = 0; i < data.getChicken().size(); i++) {//치킨

                  String temp = data.getChicken().get(i).getName(); // 치킨 메뉴에 있는값 
                  if (temp.equals(setTemp.getChicken().getName())) {//세트에 있는값 
                     //chickenCnt++;
                     //System.out.println("세트에 "+temp+"가 들어있네");
                     chickenCount[i]++;
                  }

               }
               
               break;

            }

         }

   }
   
   void flushArray(int [] arr) {
      for(int i=0; i<arr.length; i++) {
         arr[i]=0;
      }
   }
   // 일별 매출 확인 메소드
   void dailySales() {
      flushArray(pizzaCount);
      flushArray(chickenCount);
      flushArray(sideCount);
      flushArray(drinkCount);

      Calendar now = new GregorianCalendar();

      System.out.println("\n[일별 매출 확인 및 관리]");
      System.out.printf("\n오늘 날짜 : %tF\n\n", now);
      System.out.println("[당일 매출]");
      System.out.println("  메뉴\t\t\t\t\t   \t    수량");
      
      
      setCheck();
     
      // 세트메뉴 수량 체크 → 매출에 있는 세트에 있는 피자를 피자데이터랑 비교해서 같으면 피자의 수량을 증가
      // 매출에 있는 세트에 있는 치킨을 치킨데이터랑 비교해서 같으면 피자의 수량을 증가
      // 단, if else 문 나눠서 그곳에 객체가 존재할 경우에만 체크하기?
      // 4개 다 있을때?

      // 각 피자는 피자, 치킨은 치킨 , 사이드는 사이드, 음료는 음료 체크해서 String이 피자, 치킨, 사이드, 음료를 다 비교해서 있으면
      // 각각의 수량을 증가시키기

      // 피자 수량 체크
      for (int i = 0; i < data.getPizza().size(); i++) {
         //pizzaCnt = 0; // 피자 메뉴별 수량

         String temp = data.getPizza().get(i).getName();

         for (int j = 0; j < data.getSalesData().getPizzaSD().size(); j++) {

            if (temp.equals(data.getSalesData().getPizzaSD().get(j).getName())) {
               
               pizzaCount[i]++;
            }
         }
         
         

         if (pizzaCount[i] > 0)
            System.out.format("- %-9s\t %,29d개\n", data.getPizza().get(i).getName(), pizzaCount[i]);

      }

      // 치킨 수량 체크
      for (int i = 0; i < data.getChicken().size(); i++) {
         

         String temp = data.getChicken().get(i).getName();

         for (int j = 0; j < data.getSalesData().getChickenSD().size(); j++) {

            if (temp.equals(data.getSalesData().getChickenSD().get(j).getName())) {
               chickenCount[i]++;
            }
         }

         if (chickenCount[i] > 0)
            System.out.format("- %-5s\t  %,36d개\n", data.getChicken().get(i).getName(), chickenCount[i]);

      }

      // 사이드 수량 체크
      for (int i = 0; i < data.getSide().size(); i++) {
         

         String temp = data.getSide().get(i).getName();

         for (int j = 0; j < data.getSalesData().getSideSD().size(); j++) {

            if (temp.equals(data.getSalesData().getSideSD().get(j).getName())) {
               
               sideCount[i]++;
            }
         }

         if (sideCount[i] > 0)
            System.out.format("- %-12s\t\t  %,20d개\n", data.getSide().get(i).getName(), sideCount[i]);

      }

      // 음료 수량 체크
      for (int i = 0; i < data.getDrink().size(); i++) {
        

         String temp = data.getDrink().get(i).getName();

         for (int j = 0; j < data.getSalesData().getDrinkSD().size(); j++) {

            if (temp.equals(data.getSalesData().getDrinkSD().get(j).getName())) {
               
               drinkCount[i]++;
            }
         }

         if (drinkCount[i] > 0)
            System.out.format("- %-5s\t  %,36d개\n", data.getDrink().get(i).getName(), drinkCount[i]);

      }

      // 성인음료 수량 체크
      for (int i = 0; i < data.getAdultDrink().size(); i++) {
         adultDrinkCnt = 0; // 성인음료 메뉴별 수량

         String temp = data.getAdultDrink().get(i).getName();

         for (int j = 0; j < data.getSalesData().getAdultDrinkSD().size(); j++) {

            if (temp.equals(data.getSalesData().getAdultDrinkSD().get(j).getName())) {
               adultDrinkCnt++;
            }
         }

         if (adultDrinkCnt > 0)
            System.out.format("- %-5s\t\t  %,28d개\n", data.getAdultDrink().get(i).getName(), adultDrinkCnt);

      }
      

      System.out.println("=======================================================");

      // 당일 매출 총 금액 출력
      System.out.format("당일 매출 총 금액 : \t\t\t %,13d원\n", data.getTotalMoneyDay());
      // 잔고 확인
      System.out.format("            \t\t\t + 현재 잔고 %,9d원\n", checkBalanceMethod.getTotalMoney());

      // 이번 달 매출 누적 출력
      System.out.println();

      // 이번달 → int m = rightNow.get(Calendar.MONTH) + 1;
      int m = now.get(Calendar.MONTH) + 1; // 3

      System.out.format("이번 달 매출 누적 합산 금액 : \t\t %,13d원\n", data.getTotalMoneyMonth()[m - 1]);
      System.out.print("(홈→*, 뒤로가기→/) : ");
      
   }

   
   // 월별 매출 확인 메소드
   void monthlySales() {

      Calendar now = new GregorianCalendar();
     

      System.out.println("\n[월별 매출 확인 및 관리]");
      System.out.printf("\n오늘 날짜 : %tF\n\n", now);
      System.out.println("[올해의 월별 매출]");
      System.out.println("월(月)\t\t\t금액");

      int m = now.get(Calendar.MONTH) + 1; // 3

      int sum = 0; // 월별 매출 총 합산 금액
      for (int i = 0; i < m - 1; i++) {
         System.out.format("%d월 \t\t\t %,15d원\n", i + 1, data.getTotalMoneyMonth()[i]);
         sum += data.getTotalMoneyMonth()[i];
      }
      System.out.println("=======================================================");

      System.out.printf("월별 매출 총 합산 금액 : \t %,15d원\n", sum);
      System.out.print("(홈→*, 뒤로가기→/) : ");

   }

}