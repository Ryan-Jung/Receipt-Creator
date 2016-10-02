package menu.items.rj;

import java.math.BigDecimal;

public class Burrito implements Item {
	
	private static final String NAME = "BURRIOT";
	private static final BigDecimal PRICE = BigDecimal.valueOf(3.99);
	private static final int CALORIES = 550;
	

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
