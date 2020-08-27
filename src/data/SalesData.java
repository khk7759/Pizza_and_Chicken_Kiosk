package data;

import java.util.ArrayList;

public class SalesData {

   public ArrayList<Pizza> getPizzaSD() {
      return pizzaSD;
   }

   public void setPizzaSD(ArrayList<Pizza> pizzaSD) {
      this.pizzaSD = pizzaSD;
   }

   public ArrayList<Stock> getChickenSD() {
      return chickenSD;
   }

   public void setChickenSD(ArrayList<Stock> chickenSD) {
      this.chickenSD = chickenSD;
   }

   public ArrayList<Stock> getSideSD() {
      return sideSD;
   }

   public void setSideSD(ArrayList<Stock> sideSD) {
      this.sideSD = sideSD;
   }

   public ArrayList<Stock> getDrinkSD() {
      return drinkSD;
   }

   public void setDrinkSD(ArrayList<Stock> drinkSD) {
      this.drinkSD = drinkSD;
   }

   public ArrayList<Stock> getAdultDrinkSD() {
      return adultDrinkSD;
   }

   public void setAdultDrinkSD(ArrayList<Stock> adultDrinkSD) {
      this.adultDrinkSD = adultDrinkSD;
   }

   public ArrayList<Set> getSetSD() {
      return setSD;
   }

   public void setSetSD(ArrayList<Set> setSD) {
      this.setSD = setSD;
   }

   private ArrayList<Pizza> pizzaSD = new ArrayList<Pizza>();
   private ArrayList<Stock> chickenSD = new ArrayList<Stock>();
   private ArrayList<Stock> sideSD = new ArrayList<Stock>();
   private ArrayList<Stock> drinkSD = new ArrayList<Stock>();
   private ArrayList<Stock> adultDrinkSD = new ArrayList<Stock>();
   private ArrayList<Set> setSD = new ArrayList<Set>();

//   // 피자
//   {
//      ArrayList<Stock> temp = new ArrayList<Stock>();
//      Stock temp2 = new Stock("양파", 1000);
//      temp2.setNum(2);
//      temp.add(temp2);
//      temp2 = new Stock("페페로니", 1000);
//      temp2.setNum(1);
//      temp.add(temp2);
//      temp2 = new Stock("피망", 1000);
//      temp2.setNum(1);
//      temp.add(temp2);
//      temp2 = new Stock("올리브", 1000);
//      temp2.setNum(1);
//      temp.add(temp2);
//
//      pizzaSD.add(new Pizza("콤비네이션", new Stock("고급치즈", 1000), new Stock("토마토소스", 1000), temp, 18000));
//
//      temp = new ArrayList<Stock>();
//      temp2 = new Stock("양파", 1000);
//      temp2.setNum(2);
//      temp.add(temp2);
//      temp2 = new Stock("페페로니", 1000);
//      temp2.setNum(1);
//      temp.add(temp2);
//      temp2 = new Stock("피망", 1000);
//      temp2.setNum(1);
//      temp.add(temp2);
//      temp2 = new Stock("올리브", 1000);
//      temp2.setNum(1);
//      temp.add(temp2);
//      temp2 = new Stock("감자", 1000);
//      temp2.setNum(2);
//      temp.add(temp2);
//
//      pizzaSD.add(new Pizza("포테이토피자", new Stock("기본치즈", 1000), new Stock("토마토소스", 1000), temp, 20000));
//
//      temp = new ArrayList<Stock>();
//      temp2 = new Stock("양파", 1000);
//      temp2.setNum(2);
//      temp.add(temp2);
//      temp2 = new Stock("페페로니", 1000);
//      temp2.setNum(1);
//      temp.add(temp2);
//      temp2 = new Stock("피망", 1000);
//      temp2.setNum(1);
//      temp.add(temp2);
//      temp2 = new Stock("올리브", 1000);
//      temp2.setNum(1);
//      temp.add(temp2);
//      temp2 = new Stock("감자", 1000);
//      temp2.setNum(2);
//      temp.add(temp2);
//
//      
//
//   }
//
//   // 치킨
//   {
//      chickenSD.add(new Stock("후라이드치킨", 15000));
//      chickenSD.add(new Stock("후라이드치킨", 15000));
//
//   }
//
//   // 사이드
//   {
//      sideSD.add(new Stock("치즈오븐스파게티", 10000));
//      sideSD.add(new Stock("치즈스틱", 5000));
//      sideSD.add(new Stock("감자튀김", 8000));
//      sideSD.add(new Stock("감자튀김", 8000));
//      sideSD.add(new Stock("감자튀김", 8000));
//      sideSD.add(new Stock("갈릭디핑소스", 1000));
//      sideSD.add(new Stock("갈릭디핑소스", 1000));
//      sideSD.add(new Stock("갈릭디핑소스", 1000));
//      sideSD.add(new Stock("피클", 1500));
//      sideSD.add(new Stock("피클", 1500));
//      sideSD.add(new Stock("피클", 1500));
//
//   }
//
//   // 음료 drink
//   {
//      drinkSD.add(new Stock("사이다", 2000));
//      drinkSD.add(new Stock("콜라", 2000));
//      drinkSD.add(new Stock("콜라", 2000));
//      drinkSD.add(new Stock("콜라", 2000));
//   }
//
//   // 성인음료 adultDrink
//   {
//      adultDrinkSD.add(new Stock("캔맥주", 5000));
//      adultDrinkSD.add(new Stock("캔맥주", 5000));
//      adultDrinkSD.add(new Stock("캔맥주", 5000));
//   }
//
//   // 세트메뉴
//   {
//      ArrayList<Stock> temp = new ArrayList<Stock>();
//
//      Stock temp2 = new Stock("양파", 1000);
//      temp2.setNum(2);
//      temp.add(temp2);
//
//      temp2 = new Stock("페페로니", 1000);
//      temp2.setNum(1);
//      temp.add(temp2);
//
//      temp2 = new Stock("피망", 1000);
//      temp2.setNum(1);
//      temp.add(temp2);
//
//      temp2 = new Stock("올리브", 1000);
//      temp2.setNum(1);
//      temp.add(temp2);
//
//      setSD.add(new Set(new Pizza("콤비네이션", new Stock("고급치즈", 1000), new Stock("토마토소스", 1000), temp, 1000),
//            new Stock("후라이드치킨", 15000), null, new Stock("사이다", 2000), 31000, 3));
//
//      temp = new ArrayList<Stock>();
//
//      temp2 = new Stock("양파", 1000);
//      temp2.setNum(2);
//      temp.add(temp2);
//
//      temp2 = new Stock("페페로니", 1000);
//      temp2.setNum(1);
//      temp.add(temp2);
//      temp2 = new Stock("피망", 1000);
//      temp2.setNum(1);
//      temp.add(temp2);
//      temp2 = new Stock("올리브", 1000);
//      temp2.setNum(1);
//      temp.add(temp2);
//      temp2 = new Stock("감자", 1000);
//      temp2.setNum(2);
//      temp.add(temp2);
//
//      setSD.add(new Set(new Pizza("콤비네이션", new Stock("기본치즈", 1000), new Stock("토마토소스", 1000), temp, 1000),
//            new Stock("양념치킨", 15000), new Stock("감자튀김", 5000), new Stock("콜라", 2000), 35000, 1));
//
//      temp = new ArrayList<Stock>();
//
//      temp2 = new Stock("양파", 1000);
//      temp2.setNum(2);
//      temp.add(temp2);
//
//      temp2 = new Stock("페페로니", 1000);
//      temp2.setNum(1);
//      temp.add(temp2);
//      temp2 = new Stock("피망", 1000);
//      temp2.setNum(1);
//      temp.add(temp2);
//      temp2 = new Stock("올리브", 1000);
//      temp2.setNum(1);
//      temp.add(temp2);
//      temp2 = new Stock("감자", 1000);
//      temp2.setNum(2);
//      temp.add(temp2);
//
//      setSD.add(new Set(new Pizza("포테이토피자", new Stock("기본치즈", 1000), new Stock("토마토소스", 1000), temp, 1000),
//            new Stock("양념치킨", 15000), new Stock("치즈오븐스파게티", 5000), new Stock("콜라", 2000), 35000, 1));
//   }

}