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
		customerOrder = null;
		itemList = new Item[orderList.length];
	}
	
	public void makeOrder(){
		for(int i = 0 ; i < itemList.length; i++){
			
		}
	}
	public Item makeItem(String product){
		return null;
		
	}
	
	public String[] sortList(String[] list){
		list = lowerCaseList(list);
		for(int i = 0; i < list.length; i++){
			
		}
		return list;
	}
	
	/**
	 * Removes white space and makes all letters in String lowercase so they can
	 * be more easily compared. Since the ASCII value of 'B' is less than a comparisons
	 * become more difficult.
	 * @param list - list to lowercase
	 * @return - the lowercase list
	 */
	public String[] lowerCaseList(String [] list){
		for(int i = 0; i < list.length; i++){
			list[i] = list[i].toLowerCase().replaceAll("//s+", "");
		}
		return list;	
	}
	
	
}
