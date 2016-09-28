package menu.items.rj.maincoursemeals;

import java.math.BigDecimal;

import menu.items.rj.MainCourse;


public class Burger extends MainCourse {

	public Burger(){
		this.name = "Burger";
		this.price = BigDecimal.valueOf(4.50);
		this.calories = 1000;
	}	
	
}
