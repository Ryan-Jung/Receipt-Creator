package menu.items.rj;

import java.math.BigDecimal;
/**
 * All items or products that need to be displayed on the receipt should implement this
 * interface.
 *
 */
public interface Item {

	/**
	 * 
	 * @return- The name of this product.
	 */
	public String getName();
	/**
	 * 
	 * @return - The price of this product.
	 */
	public BigDecimal getPrice();
	/**
	 * 
	 * @return- The amount of calories this product has.
	 */
	public int getCalories();
	/**
	 * Returns a string containing the facts about the product.
	 */
	public String getFacts();
}
