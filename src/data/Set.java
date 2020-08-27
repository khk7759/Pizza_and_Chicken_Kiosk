/**
 * @ 작성자 : 송수진
 * @ 작성일 :2020. 3. 10.
 * @ 설   명 : 세트메뉴 VO
 */

package data;

import java.util.ArrayList;

public class Set {
   private Pizza pizza;
   private int price;
   // public Stock[] set = new Stock[3]; // 치킨 사이드 음료
   // public ArrayList<Stock> set = new ArrayList<Stock>();
   private Stock chicken;
   private Stock side;
   private Stock drink;
   private int setCase;
   
   public int getSetCase() {
      return setCase;
   }

   public void setSetCase(int setCase) {
      this.setCase = setCase;
   }

   public Set(Pizza pizza, Stock chicken, Stock side, Stock drink, int price, int setCase) {
      this.pizza = pizza;
      this.chicken = chicken;
      this.side = side;
      this.drink = drink;
      this.price = price;
      this.setCase = setCase;
   }

   public Pizza getPizza() {
      return pizza;
   }

   public void setPizza(Pizza pizza) {
      this.pizza = pizza;
   }

   public int getPrice() {
      return price;
   }

   public void setPrice(int price) {
      this.price = price;
   }

   public Stock getChicken() {
      return chicken;
   }

   public void setChicken(Stock chicken) {
      this.chicken = chicken;
   }

   public Stock getSide() {
      return side;
   }

   public void setSide(Stock side) {
      this.side = side;
   }

   public Stock getDrink() {
      return drink;
   }

   public void setDrink(Stock drink) {
      this.drink = drink;
   }

}