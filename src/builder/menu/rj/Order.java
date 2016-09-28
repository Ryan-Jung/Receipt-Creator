package builder.menu.rj;

import menu.items.rj.Item;

/**
 * The customer's order.
 *
 */
public class Order {
	private String [] customerOrder;
	private Item [] itemList;
	
	public Order(String [] orderList){
		customerOrder = orderList;
		itemList = new Item[orderList.length];
	}
	
	public void makeOrder(){
		for(int i = 0 ; i < itemList.length; i++){
			
		}
	}
	private Item makeItem(String product){
		return null;
		
	}
	
	
}
