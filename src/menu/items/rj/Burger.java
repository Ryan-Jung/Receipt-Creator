package menu.items.rj;

import java.math.BigDecimal;


public class Burger implements Item {
	private static final String NAME = "BURGER";
	private static final BigDecimal PRICE = BigDecimal.valueOf(4.50);
	private static final int CALORIES = 670;

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public BigDecimal getPrice() {
		return PRICE;
	}

	@Override
	public int getCalories() {
		return CALORIES;
	}


}
