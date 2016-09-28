package menu.items.rj;


public abstract class Extra extends Item {
	protected double sugarContent;

	public double getSugarContent(){
		return sugarContent;
	}

	@Override
	public void printFacts() {
		System.out.println("Name:" + getName() + "\t$" + price);
		System.out.println("\tCalories: " + calories + "Sugar " + getSugarContent() + "g");
		
	}
	

}
