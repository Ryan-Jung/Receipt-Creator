package builder.menu.rj;

import menu.items.rj.Item;
import java.util.HashMap;

public interface ItemCreator {
	/**
	 * Gets all Items in a given package and puts them into a HashMap. The key
	 * should be the class name in lower case and the value stored in the HashMap should
	 * be an instance of that Item.
	 */
	public void loadHashMap();
	/**
	 * Checks if item is in the loaded HashMap.
	 * @param product - The item to check.
	 * @return True if items exists, false otherwise.
	 */
	public boolean itemExists(String product);

	/**
	 * Returns an instance of the specified product. Refers to the loaded Hash Map for list
	 * of products.
	 * @param product - The name of the product you would like.
	 * @return - An instance of the specified product. Returns null if the product doesn't
	 * exist.
	 */
	public Item makeProduct(String product);
	
}
