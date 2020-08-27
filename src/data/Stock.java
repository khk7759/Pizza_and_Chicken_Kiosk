//만든이: 3팀
package data;

import java.util.ArrayList;

// clone() 메소드를 위한 Cloneable 구현
public class Stock implements Cloneable{
   private String name;
   private int price;
   private int num;
   
   // ActionChicken의 (순살) 표기를 장바구니에서만 해주기 위해 clone() 메소드 생성 - 수진
   @Override
   public Object clone() {
      return new Stock(name, price, 1);
   }
   
   public Object clone1() {
	   return  new Stock(name, price, num);
   }
   
   public Stock(String name, int price) {
      this.name = name;
      this.price = price;
   }
   
   public Stock(String name, int price,int num) {
      this.name = name;
      this.price = price;
      this.num = num;
   }
   
   public int getPrice() {
      return price;
   }

   public void setPrice(int price) {
      this.price = price;
   }

   public int getNum() {
      return num;
   }

   public void setNum(int num) {
      this.num = num;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getName() {
      return this.name;
   }
}

