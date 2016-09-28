package menu.items.rj;

import java.math.BigDecimal;

public abstract class Drink extends Item  {
	protected String size;
	
	public String getSize(){
		return size.toUpperCase();
	}
	/**
	 * Helper function to set values for price and  calories depending on size
	 * @param size - Drink size.
	 */
		protected void setValuesForSize(String size){
			size = size.toLowerCase();
			switch(size){
				case "small":
					this.calories = 150;
					this.price = BigDecimal.valueOf(.99);
					break;
				case "medium":	
					this.calories = 250;
					this.price = BigDecimal.valueOf(1.49);
					break;
				case "large":
					this.calories = 300;
					this.price = BigDecimal.valueOf(2.89);
					break;
			}
	}
	@Override
	public void printFacts(){
		System.out.println("Product: " + getSize() + " " + getName() + "\t$" + price);
		System.out.println("\tCalories: " + calories);
	}

}
