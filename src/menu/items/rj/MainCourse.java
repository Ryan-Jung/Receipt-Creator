package menu.items.rj;


public abstract class MainCourse extends Item {
	
	@Override
	public void printFacts() {
		System.out.println("Product: " + getName() + "  $" + price);
		System.out.println("\tCalories: " + calories);
		
	}

}
