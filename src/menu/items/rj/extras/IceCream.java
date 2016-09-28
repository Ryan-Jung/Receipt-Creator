package menu.items.rj.extras;

import java.math.BigDecimal;

import menu.items.rj.Extra;

public class IceCream  extends Extra{
	public IceCream(){
		this.name = "VANILLA ICE CREAM";
		this.price = BigDecimal.valueOf(1.99);
		this.calories = 350;
		this.sugarContent = 15.2;
	}
}
