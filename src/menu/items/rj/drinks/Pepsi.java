package menu.items.rj.drinks;

import menu.items.rj.Drink;

public class Pepsi extends Drink {
	public Pepsi(String size){
		this.name = "PEPSI";
		this.size = size;
		setValuesForSize(size);
	}
	
}
