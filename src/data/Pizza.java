//만든이: 김홍경
package data;

import java.util.ArrayList;

import buyer.Buyer;

public class Pizza  implements Cloneable {
   private String name;
   private int price;

   private Stock cheese;
   private Stock sauce;
   private Stock dough;
   private int num;
   
   public int getNum() {
      return num;
   }
   public void setNum(int num) {
      this.num = num;
   }
   private ArrayList<Stock> ingredient = new ArrayList<Stock>();
   
   private boolean custom;
   
   public Pizza(String name,Stock cheese, Stock sauce,ArrayList<Stock> ingredient, int price) {
      this.name = name;
      this.cheese = cheese;
      this.sauce = sauce;
      this.ingredient = ingredient;
      this.price = price;
      dough = new Stock("오리지널", 0);
   }
   
   public Pizza(String name,Stock cheese, Stock sauce,ArrayList<Stock> ingredient, int price, int num) {
      this.name = name;
      this.cheese = cheese;
      this.sauce = sauce;
      this.ingredient = ingredient;
      this.price = price;
      this.num = num;
      dough = new Stock("오리지널", 0);
   }
   
   public Stock getCheese() {
      return this.cheese;
   }

   public ArrayList<Stock> getIngredient() {
      return this.ingredient;
   }
   
   @Override
   public Pizza clone()
  {   
     ArrayList<Stock> ingredient = new ArrayList<Stock>();
     
     for(int n = 0; n < this.ingredient.size(); n++)   {
        ingredient.add(new Stock(this.ingredient.get(n).getName(), this.ingredient.get(n).getNum()));
        ingredient.get(n).setPrice(this.ingredient.get(n).getPrice());
     }
     
        Pizza pizza = new Pizza(name, cheese, sauce, ingredient, price);
        pizza.setDough(Buyer.data.getDough().get(0));
        return pizza;
  }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public int getPrice() {
      return price;
   }
   public void setPrice(int price) {
      this.price = price;
   }
   public Stock getSauce() {
      return sauce;
   }
   public void setSauce(Stock sauce) {
      this.sauce = sauce;
   }
   public Stock getDough() {
      return dough;
   }
   public void setDough(Stock dough) {
      this.dough = dough;
   }
   public boolean isCustom() {
      return custom;
   }
   public void setCustom(boolean custom) {
      this.custom = custom;
   }
   public void setCheese(Stock cheese) {
      this.cheese = cheese;
   }
   public void setIngredient(ArrayList<Stock> ingredient) {
      this.ingredient = ingredient;
   }
   
}