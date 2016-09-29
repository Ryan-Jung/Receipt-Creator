package builder.menu.rj;

import menu.items.rj.Item;
import java.util.HashMap;
import java.util.Stack;

public abstract class ItemCreator {
	/**
	 * Gets all Items in a given package and puts them into a HashMap. The key
	 * should be the class name in lower case and the value stored in the HashMap should
	 * be an instance of that Item.
	 */
	public abstract void loadHashMap();
	/**
	 * Checks if item is in the loaded HashMap.
	 * @param product - The item to check.
	 * @return True if items exists, false otherwise.
	 */
	public abstract boolean itemExists(String product);

	/**
	 * Returns an instance of the specified product. Refers to the loaded Hash Map for list
	 * of products.
	 * @param product - The name of the product you would like.
	 * @return - An instance of the specified product. Returns null if the product doesn't
	 * exist.
	 */
	public abstract Item makeProduct(String product);
	
	/**
	 * Takes in a a class's fully qualified name and returns the class name. For example if the class 
	 * path name is menu.items.rj.Drinks.Coke this method would return 'coke'.
	 * @param fullyQualifiedName
	 * @return - The name of the class to lower case.
	 */
	public String getNameOfProduct(String fullyQualifiedName){
		Stack<Character> charStack = new Stack<Character>();
		int i = fullyQualifiedName.length()-1;
		while(fullyQualifiedName.charAt(i) != '.'){
			charStack.push(fullyQualifiedName.charAt(i));
			i--;
		}
		
		String productName = "";
		while(!charStack.isEmpty()){
			productName += charStack.pop();
		}
		return productName.toLowerCase();
	}
	
}
