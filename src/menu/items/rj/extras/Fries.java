package menu.items.rj.extras;

import java.math.BigDecimal;

import menu.items.rj.Extra;

public class Fries extends Extra {
	public Fries(){
		this.name = "FRIES";
		this.price = BigDecimal.valueOf(2.59);
		this.sugarContent = 0;
	}
	
}
