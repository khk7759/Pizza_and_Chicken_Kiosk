//만든이: 길동규
package data;

import java.util.ArrayList;

public class ShoppingCart {
	private ArrayList<Pizza> pizza = new ArrayList<Pizza>();
	private ArrayList<Stock> chicken = new ArrayList<Stock>();
	private ArrayList<Stock> side = new ArrayList<Stock>();
	private ArrayList<Stock> drink = new ArrayList<Stock>();
	private ArrayList<Stock> adultDrink = new ArrayList<Stock>();
	private ArrayList<Set>   set = new ArrayList<Set>();
	public ArrayList<Pizza> getPizza() {
		return pizza;
	}
	public void setPizza(ArrayList<Pizza> pizza) {
		this.pizza = pizza;
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
	public ArrayList<Stock> getAdultDrink() {
		return adultDrink;
	}
	public void setAdultDrink(ArrayList<Stock> adultDrink) {
		this.adultDrink = adultDrink;
	}
	public ArrayList<Set> getSet() {
		return set;
	}
	public void setSet(ArrayList<Set> set) {
		this.set = set;
	}
	
}