package menu.items.rj.maincoursemeals;

import java.math.BigDecimal;

import menu.items.rj.MainCourse;

public class Burrito extends MainCourse {
	public Burrito(){
		this.name = "BURRITO";
		this.calories = 750;
		this.price = BigDecimal.valueOf(3.99);
	}
}
