package menu.items.rj.drinks;

import menu.items.rj.Drink;

public class Coke extends Drink {
	

	public Coke(String size){
		this.name = "Coke";
		this.size = size;
		setValuesForSize(size);
	}
	

}
