package menu.items.rj;

import java.math.BigDecimal;

public class Burrito extends MainCourse {
	public Burrito(){
		this.name = "BURRITO";
		this.calories = 750;
		this.price = BigDecimal.valueOf(3.99);
	}
}
