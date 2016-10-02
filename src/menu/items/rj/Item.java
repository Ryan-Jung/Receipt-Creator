package menu.items.rj;

import java.math.BigDecimal;
/**
 * All items or products that need to be displayed on the receipt should extend this
 * class.
 *
 */
public abstract class Item {
	protected final String NAME;
	protected final int CALORIES;
	protected final BigDecimal PRICE;
	
	public Item(String name, int calories, BigDecimal price){
		NAME = name;
		CALORIES = calories;
		PRICE = price;
	}

	/**
	 * 
	 * @return- The name of this product.
	 */
	public String getName(){
		return NAME;
	}
	/**
	 * 
	 * @return - The price of this product.
	 */
	public BigDecimal getPrice(){
		return PRICE;
	}
	/**
	 * 
	 * @return- The amount of calories this product has.
	 */
	public int getCalories(){
		return CALORIES;
	}
}
