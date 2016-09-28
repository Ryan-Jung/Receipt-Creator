package builder.menu.rj;

import menu.items.rj.Item;
import menu.items.rj.extras.*;
/**
 * Makes 'extras'
 *
 */
public class MakeExtra implements ItemCreator {

	@Override
	public Item makeProduct(String product) {
		switch(product.toLowerCase()){
			case "fries":
				return new Fries();
			case "icecream":
				return new IceCream();
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
