import builder.menu.rj.Order;

public class SampleProgram {
	
	public static void main (String[] args){
		Order.printAvailableItems();
		String [] customerOrder = {"Burrito", "coke", "Ice Cream", "Burger", "Fries"};
		Order order = new Order(customerOrder);
		order.printReceipt();
		
	}
}
