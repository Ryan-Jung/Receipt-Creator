package builder.menu.rj;

import menu.items.rj.Item;
import java.util.HashMap;
import java.util.List;

import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import io.github.lukehutch.fastclasspathscanner.scanner.ScanResult;

public class ItemFactory {
	
	private static final String PACKAGE_PREFIX = "menu.items.rj";
	private static HashMap<String, Item> itemHM = new HashMap<String, Item>();
	private static ItemFactory instance = new ItemFactory();
	
	//not to be instantiated, call getInstance() to get object.
	private ItemFactory(){
		loadHashMap();
	}
	
	/**
	 * Gets all concrete classes that extend the Item class in the package 'menu.items.rj'
	 * and loads that into the HashMap. The key is the simple class name to lower case and 
	 * the value stored in the HashMap is an instance of that Item. 
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
	 * Checks if item is in the loaded HashMap. Assumes the given Sting is lowercased
	 * and has no whitespace.
	 * @param product - The item to check.
	 * @return True if items exists, false otherwise.
	 */
	public boolean itemExists(String product) {
		return itemHM.containsKey(product);
	}

	/**
	 * Returns an instance of the specified product. Refers to the loaded Hash Map for list
	 * of products. Assumes the given String is lowercased and has no whitespace.
	 * @param product - The name of the product you would like.
	 * @return - An instance of the specified product. Returns null if the product doesn't
	 * exist.
	 */
	public Item makeProduct(String product) {
		return itemHM.get(product);
	}
	/**
	 * @return - An instance of ItemFactory.
	 */
	public static ItemFactory getInstance(){
		return instance;
	}
	/**
	 * 
	 * @return The item HashMap.
	 */
	public static HashMap<String, Item> getHashMap(){
		return itemHM;
	}
	
	

}
