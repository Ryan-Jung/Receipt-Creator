package menu.items.rj;

import java.math.BigDecimal;

public abstract class Item {
	protected String name;
	protected BigDecimal price;
	protected int calories;
	/**
	 * 
	 * @return- The name of this product.
	 */
	public String getName(){
		return name.toUpperCase();
	}
	/**
	 * 
	 * @return - The price of this product.
	 */
	public BigDecimal getPrice(){
		return price;
	}
	/**
	 * 
	 * @return- The amount of calories this product has.
	 */
	public int getCalories(){
		return calories;
	}
	/**
	 * Prints the facts about the product.
	 */
	public abstract void printFacts();
}
