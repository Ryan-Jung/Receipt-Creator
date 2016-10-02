package builder.menu.rj;

import menu.items.rj.Item;
import java.util.HashMap;
import java.util.List;

import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import io.github.lukehutch.fastclasspathscanner.scanner.ScanResult;

public class ItemFactory {
	
	private static final String PACKAGE_PREFIX = "menu.items.rj";
	private static HashMap<String, Item> itemHM = new HashMap<String, Item>();
	
	
	/**
	 * Gets all Items in a given package and puts them into a HashMap. The key
	 * is the simple class name to lower case and the value stored in the HashMap is 
	 * an instance of that Item.
	 */
	public void loadHashMap() {
		
		//Get all concrete classes implementing the Item interface in menu.rj.item
		ScanResult scanResult = new FastClasspathScanner(PACKAGE_PREFIX).scan();
		List<String> subclasses = scanResult.getNamesOfSubclassesOf(Item.class);
		
		for(String item : subclasses){
			Class<?> ItemClass;
			try {
				ItemClass = Class.forName(item);
				String productName = ItemClass.getSimpleName().toLowerCase();
				itemHM.put(productName, (Item) ItemClass.newInstance());	
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * Checks if item is in the loaded HashMap.
	 * @param product - The item to check.
	 * @return True if items exists, false otherwise.
	 */
	public boolean itemExists(String product) {
		//since no class names have spaces
		product = product.toLowerCase().replaceAll("\\s+","");
		return itemHM.containsKey(product);
	}

	/**
	 * Returns an instance of the specified product. Refers to the loaded Hash Map for list
	 * of products.
	 * @param product - The name of the product you would like.
	 * @return - An instance of the specified product. Returns null if the product doesn't
	 * exist.
	 */
	public Item makeProduct(String product) {
		product = product.toLowerCase().replaceAll("\\s+", "");
		return itemHM.get(product);
	}
	
//	/**
//	 * Takes in a a class's fully qualified name and returns the class name. For example if the class 
//	 * path name is menu.items.rj.Drinks.Coke this method would return 'coke'.
//	 * @param fullyQualifiedName
//	 * @return - The name of the class to lower case.
//	 */
//	public String getNameOfProduct(String fullyQualifiedName){
//		Stack<Character> charStack = new Stack<Character>();
//		int i = fullyQualifiedName.length()-1;
//		while(fullyQualifiedName.charAt(i) != '.'){
//			charStack.push(fullyQualifiedName.charAt(i));
//			i--;
//		}
//		String productName = "";
//		while(!charStack.isEmpty()){
//			productName += charStack.pop();
//		}
//		return productName.toLowerCase();
//	}
	
}
