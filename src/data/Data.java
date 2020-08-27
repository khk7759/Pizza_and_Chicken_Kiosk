//만든이: 3팀

package data;

import java.util.List;
import java.util.Scanner;

import buyer.Buyer;

import java.util.ArrayList;

import java.io.*;

public class Data {

//----------------------------------   Stock   ----------------------------------
   private ArrayList<Coupon> coupon = new ArrayList<Coupon>();
   private ArrayList<Set> set = new ArrayList<Set>();
   private ArrayList<Stock> chicken = new ArrayList<Stock>();
   private ArrayList<Stock> side = new ArrayList<Stock>();
   private ArrayList<Stock> drink = new ArrayList<Stock>();
   private ArrayList<Stock> pack = new ArrayList<Stock>();
   private ArrayList<Stock> adultDrink = new ArrayList<Stock>();

   private ArrayList<Stock> randomChicken = new ArrayList<Stock>();
   private ArrayList<Set> randomSet = new ArrayList<Set>();

   // 3.13 기혜 추가
   private ArrayList<Stock> timeChicken = new ArrayList<Stock>();

   // ---------------------------------- pizza ----------------------------------
   private ArrayList<Pizza> pizza = new ArrayList<Pizza>();

   public int getTimeSale() {
      return timeSale;
   }

   public void setTimeSale(int timeSale) {
      this.timeSale = timeSale;
   }

   private ArrayList<Pizza> randomPizza = new ArrayList<Pizza>();
   // 3.13 기혜 추가
   private ArrayList<Pizza> timePizza = new ArrayList<Pizza>();

   private ArrayList<Stock> cheese = new ArrayList<Stock>();
   private ArrayList<Stock> sauce = new ArrayList<Stock>();
   private ArrayList<Stock> ingredient = new ArrayList<Stock>();
   private ArrayList<Stock> dough = new ArrayList<Stock>();

//----------------------------------   money   ----------------------------------   
   private int totalMoneyDay;
   private int[] totalMoneyMonth = new int[12];

   private Money[] money = new Money[8];

// ---------------------------------- SalesData------------------------------------
   private SalesData salesData = new SalesData();

// ---------------------------------- gifts --------------------------------------
   // ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
   private ArrayList<Stock> gifts = new ArrayList<Stock>();

   // ----------------------------------- time sale
   // ------------------------------------------
   private int timeSale = 24;
// ---------------------------------- discount------------------------------

   private int nowDiscount = 20;
// ---------------------------------- coupon --------------------------------------
   private int couponMoney = 0; // 쿠폰 발행 기준 금액

   private int couponStandard; // 쿠폰 발행 기준 이상 이하

//----------------------------------   임시 data   ----------------------------------   
   public Data() {

      money[0] = new Money(50000, 5);
      money[1] = new Money(10000, 20);
      money[2] = new Money(5000, 0);
      money[3] = new Money(1000, 50);
      money[4] = new Money(500, 50);
      money[5] = new Money(100, 50);
      money[6] = new Money(50, 50);
      money[7] = new Money(10, 50);

      totalMoneyMonth[0] = 5000000;
      totalMoneyMonth[1] = 2000000;
      totalMoneyMonth[2] = 3000000;

   }

   public ArrayList<Coupon> getCoupon() {
      return coupon;
   }

   public void setCoupon(ArrayList<Coupon> coupon) {
      this.coupon = coupon;
   }

   public ArrayList<Set> getSet() {
      return set;
   }

   public void setSet(ArrayList<Set> set) {
      this.set = set;
   }

   public ArrayList<Stock> getChicken() {
      return chicken;
   }

   public void setChicken(ArrayList<Stock> chicken) {
      this.chicken = chicken;
   }

   public ArrayList<Stock> getSide() {
      return side;
   }

   public void setSide(ArrayList<Stock> side) {
      this.side = side;
   }

   public ArrayList<Stock> getDrink() {
      return drink;
   }

   public void setDrink(ArrayList<Stock> drink) {
      this.drink = drink;
   }

   public ArrayList<Stock> getPack() {
      return pack;
   }

   public void setPack(ArrayList<Stock> pack) {
      this.pack = pack;
   }

   public ArrayList<Stock> getAdultDrink() {
      return adultDrink;
   }

   public void setAdultDrink(ArrayList<Stock> adultDrink) {
      this.adultDrink = adultDrink;
   }

   public ArrayList<Stock> getRandomChicken() {
      return randomChicken;
   }

   public void setRandomChicken(ArrayList<Stock> randomChicken) {
      this.randomChicken = randomChicken;
   }

   public ArrayList<Set> getRandomSet() {
      return randomSet;
   }

   public void setRandomSet(ArrayList<Set> randomSet) {
      this.randomSet = randomSet;
   }

   public ArrayList<Pizza> getPizza() {
      return pizza;
   }

   public void setPizza(ArrayList<Pizza> pizza) {
      this.pizza = pizza;
   }

   public ArrayList<Pizza> getRandomPizza() {
      return randomPizza;
   }

   public void setRandomPizza(ArrayList<Pizza> randomPizza) {
      this.randomPizza = randomPizza;
   }

   // 3.13 기혜 추가 ★★
   public ArrayList<Pizza> getTimePizza() {
      return timePizza;
   }

   public void setTimePizza(ArrayList<Pizza> timePizza) {
      this.timePizza = timePizza;
   }

   public ArrayList<Stock> getTimeChicken() {
      return timeChicken;
   }

   public void setTimeChicken(ArrayList<Stock> timeChicken) {
      this.timeChicken = timeChicken;
   }
   /// -----------------------------

   public ArrayList<Stock> getCheese() {
      return cheese;
   }

   public void setCheese(ArrayList<Stock> cheese) {
      this.cheese = cheese;
   }

   public ArrayList<Stock> getSauce() {
      return sauce;
   }

   public void setSauce(ArrayList<Stock> sauce) {
      this.sauce = sauce;
   }

   public ArrayList<Stock> getIngredient() {
      return ingredient;
   }

   public void setIngredient(ArrayList<Stock> ingredient) {
      this.ingredient = ingredient;
   }

   public ArrayList<Stock> getDough() {
      return dough;
   }

   public void setDough(ArrayList<Stock> dough) {
      this.dough = dough;
   }

   public int getTotalMoneyDay() {
      return totalMoneyDay;
   }

   public ArrayList<Stock> getGifts() {
      return gifts;
   }

   public void setGifts(ArrayList<Stock> gifts) {
      this.gifts = gifts;
   }

   public void setTotalMoneyDay(int totalMoneyDay) {
      this.totalMoneyDay = totalMoneyDay;
   }

   public int[] getTotalMoneyMonth() {
      return totalMoneyMonth;
   }

   public void setTotalMoneyMonth(int[] totalMoneyMonth) {
      this.totalMoneyMonth = totalMoneyMonth;
   }

   public Money[] getMoney() {
      return money;
   }

   public void setMoney(Money[] money) {
      this.money = money;
   }

   public SalesData getSalesData() {
      return salesData;
   }

   public void setSalesData(SalesData salesData) {
      this.salesData = salesData;
   }

   public int getNowDiscount() {
      return nowDiscount;
   }

   public void setNowDiscount(int nowDiscount) {
      this.nowDiscount = nowDiscount;
   }

   public int getCouponMoney() {
      return couponMoney;
   }

   public void setCouponMoney(int couponMoney) {
      this.couponMoney = couponMoney;
   }

   public int getCouponStandard() {
      return couponStandard;
   }

   public void setCouponStandard(int couponStandard) {
      this.couponStandard = couponStandard;
   }

//★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★3/13기혜 추가!!!!!!!

   public void copyTimeSaleChicken(Stock c) {
      Stock temp = new Stock("", 0);

      temp.setName(c.getName());
      temp.setPrice(c.getPrice());
      getTimeChicken().add(temp);

   }

//---------------------------------------------------------------------------------------------

   // 치킨
   {
//===============★★★★★★★★★★★★★★★★★★★★★★★기혜야 정신차리고 copyTimeSaleChicken(new Stock("후라이드치킨", 15000)); 잘 추가해라

      chicken.add(new Stock("후라이드치킨", 15000, 10));
      copyTimeSaleChicken(new Stock("후라이드치킨", 15000));

      chicken.add(new Stock("양념치킨", 15000, 5));
      copyTimeSaleChicken(new Stock("양념치킨", 15000));

      chicken.add(new Stock("허니갈릭치킨", 16000, 3));
      copyTimeSaleChicken(new Stock("허니갈릭치킨", 16000));

      chicken.add(new Stock("로스트치킨", 15000, 5));
      copyTimeSaleChicken(new Stock("로스트치킨", 15000));

      chicken.add(new Stock("간장치킨", 16000, 3));
      copyTimeSaleChicken(new Stock("간장치킨", 16000));

      chicken.add(new Stock("치토스", 15000,10));
      copyTimeSaleChicken(new Stock("치토스", 15000));

   }
   // 치즈
   {
      cheese.add(new Stock("기본치즈", 1000));
      cheese.add(new Stock("고급치즈", 2000));
   }
   // 피자 소스
   {
      sauce.add(new Stock("토마토소스", 1000));
      sauce.add(new Stock("바베큐소스", 2000));
      sauce.add(new Stock("핫소스", 2000));
   }

   // 재료
   {
      ingredient.add(new Stock("감자", 1000, 20));
      ingredient.add(new Stock("고구마", 2000, 20));
      ingredient.add(new Stock("양파", 2000, 20));
      ingredient.add(new Stock("페페로니", 2000, 20));
      ingredient.add(new Stock("베이컨", 2000, 20));
      ingredient.add(new Stock("버섯", 2000, 20));
      ingredient.add(new Stock("올리브", 2000, 20));
      ingredient.add(new Stock("치즈", 2000, 20));
      ingredient.add(new Stock("새우", 2000, 20));
      ingredient.add(new Stock("옥수수", 2000, 20));
   }

   // 피자
   {

      ArrayList<Stock> temp = new ArrayList<Stock>();
      Stock temp2 = new Stock("양파", 1000);
      temp2.setNum(2);
      temp.add(temp2);
      temp2 = new Stock("페페로니", 1000);
      temp2.setNum(1);
      temp.add(temp2);
      temp2 = new Stock("피망", 1000);
      temp2.setNum(1);
      temp.add(temp2);
      temp2 = new Stock("올리브", 1000);
      temp2.setNum(1);
      temp.add(temp2);

      pizza.add(new Pizza("콤비네이션", new Stock("고급치즈", 1000), new Stock("토마토소스", 1000), temp, 20000, 5));

      temp = new ArrayList<Stock>();
      temp2 = new Stock("양파", 1000);
      temp2.setNum(2);
      temp.add(temp2);
      temp2 = new Stock("페페로니", 1000);
      temp2.setNum(1);
      temp.add(temp2);
      temp2 = new Stock("피망", 1000);
      temp2.setNum(1);
      temp.add(temp2);
      temp2 = new Stock("올리브", 1000);
      temp2.setNum(1);
      temp.add(temp2);
      temp2 = new Stock("감자", 1000);
      temp2.setNum(2);
      temp.add(temp2);

      pizza.add(new Pizza("포테이토피자", new Stock("기본치즈", 1000), new Stock("토마토소스", 1000), temp, 22000, 5));


   

   }

   // 세트메뉴
   {
      ArrayList<Stock> temp = new ArrayList<Stock>();

      Stock temp2 = new Stock("양파", 1000);
      temp2.setNum(2);
      temp.add(temp2);

      temp2 = new Stock("페페로니", 1000);
      temp2.setNum(1);
      temp.add(temp2);

      temp2 = new Stock("피망", 1000);
      temp2.setNum(1);
      temp.add(temp2);

      temp2 = new Stock("올리브", 1000);
      temp2.setNum(1);
      temp.add(temp2);

      set.add(new Set(new Pizza("콤비네이션", new Stock("고급치즈", 1000), new Stock("토마토소스", 1000), temp, 1000),
            new Stock("후라이드치킨", 15000), new Stock("치즈스틱", 5000), new Stock("사이다", 2000), 31000, 1));

      temp = new ArrayList<Stock>();

      temp2 = new Stock("양파", 1000);
      temp2.setNum(2);
      temp.add(temp2);

      temp2 = new Stock("페페로니", 1000);
      temp2.setNum(1);
      temp.add(temp2);
      temp2 = new Stock("피망", 1000);
      temp2.setNum(1);
      temp.add(temp2);
      temp2 = new Stock("올리브", 1000);
      temp2.setNum(1);
      temp.add(temp2);
      temp2 = new Stock("감자", 1000);
      temp2.setNum(2);
      temp.add(temp2);

      set.add(new Set(new Pizza("포테이토피자", new Stock("기본치즈", 1000), new Stock("토마토소스", 1000), temp, 1000),
            new Stock("양념치킨", 15000), null, new Stock("콜라", 2000), 35000, 3));

      temp = new ArrayList<Stock>();

      temp2 = new Stock("양파", 1000);
      temp2.setNum(2);
      temp.add(temp2);

      temp2 = new Stock("페페로니", 1000);
      temp2.setNum(1);
      temp.add(temp2);
      temp2 = new Stock("피망", 1000);
      temp2.setNum(1);
      temp.add(temp2);
      temp2 = new Stock("올리브", 1000);
      temp2.setNum(1);
      temp.add(temp2);
      temp2 = new Stock("감자", 1000);
      temp2.setNum(2);
      temp.add(temp2);

      set.add(new Set(new Pizza("포테이토피자", new Stock("기본치즈", 1000), new Stock("토마토소스", 1000), temp, 1000),
            new Stock("양념치킨", 15000), null, null, 35000, 7));
   }

   // 도우
   {
      dough.add(new Stock("오리지널", 0, 50));
      dough.add(new Stock("씬도우", 2000,50));
      dough.add(new Stock("치즈크러스트", 3000, 50));
   }

   // 음료 drink
   {
      drink.add(new Stock("사이다", 2000, 5));
      drink.add(new Stock("콜라", 2000, 3));
      drink.add(new Stock("환타", 2000, 5));
   }

   // 성인음료 adultDrink
   {
      adultDrink.add(new Stock("병맥주", 4000, 4));
      adultDrink.add(new Stock("캔맥주", 5000, 2));
   }
   // 사이드
   {
      side.add(new Stock("치즈오븐스파게티", 10000, 5));
      side.add(new Stock("까르보나라", 11000, 10));
      side.add(new Stock("치즈스틱", 5000, 3));
      side.add(new Stock("감자튀김", 8000, 5));
      side.add(new Stock("갈릭디핑소스", 1000, 2));
      side.add(new Stock("핫소스", 1000, 1));
      side.add(new Stock("치킨무", 1000, 5));
      side.add(new Stock("피클", 1500, 10));
      side.add(new Stock("파마산치즈", 1000, 5));
      side.add(new Stock("핫소스", 1000, 7));

   }

   // 사은품 gifts
   {
      gifts.add(new Stock("콜라", 0));
   }

   // 쿠폰coupon
   {
      coupon.add(new Coupon("aaa77", 20));
   }
   // 포장용기박스
   {
      pack.add(new Stock("피자박스",0,50));
      pack.add(new Stock("치킨박스",0,50));
      pack.add(new Stock("사이드박스",0,100));
      pack.add(new Stock("세트박스",0,50));
      
   }

//----------------------------------   method   ----------------------------------      

   public int input() {

      return Buyer.inputInt();
   }

   public String inputString() {

      return Buyer.inputString();
   }

}