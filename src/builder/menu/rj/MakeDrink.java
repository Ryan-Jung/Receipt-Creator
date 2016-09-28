package builder.menu.rj;

import menu.items.rj.Item;
import menu.items.rj.drinks.*;
/**
 * Makes drinks.
 *
 */
public class MakeDrink implements ItemCreator{

	
	@Override
	public Item makeProduct(String product) {
		//Default size is small
		switch(product.toLowerCase()){
			case "coke":
				return new Coke("SMALL");
			case "pepsi":
				return new Pepsi("SMALL");
			default:
				return null;
		}
	}
	/**
	 * For ordering a drink with a specific size. Only small, medium, and large
	 * sizes are available.
	 * @param product - The name of the product
	 * @param size - The size of the drink.
	 * @return - The drink or null if the product doesn't exist.
	 */
	public Item makeProduct(String product, String size){
		
		if(!size.equalsIgnoreCase("SMALL") || !size.equalsIgnoreCase("MEDIUM")||
				!size.equalsIgnoreCase("LARGE")){ 
			return null;
		}
		
		switch(product.toLowerCase()){
			case "coke":
				return new Coke(size);
			case "pepsi":
				return new Pepsi(size);
			default:
				return null;
		}
	}
	@Override
	public void loadHashMap() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean itemExists(String product) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
