package builder.menu.rj;


import java.math.BigDecimal;

import menu.items.rj.Item;

/**
 * The customer's order.
 *
 */
public class Order {
	private String [] customerOrder;
	private Item [] itemList;
	
	public Order(String [] orderList){
		customerOrder = sortList(orderList);
		makeOrder();
	}
	/**
	 * Creates instances of the given item in the customer order and stores them
	 * in the Item List.
	 */
	private void makeOrder(){
		ItemFactory itemFactory = ItemFactory.getInstance();
		itemList = new Item[customerOrder.length]; 
		
		for(int i = 0 ; i < itemList.length; i++){
			if(itemFactory.itemExists(customerOrder[i])){
				itemList[i] = itemFactory.makeProduct(customerOrder[i]);
			}else{
				itemList[i] = null;
			}
		}
	}
	/**
	 * Sorts list alphabetically using insertion sort.
	 * @param list - The list to sort
	 * @return- The sorted list
	 */
	public String[] sortList(String[] list){
		list = lowerCaseList(list);
		
		for(int i = 1; i < list.length; i++){
			//keep swapping until element is put in proper place
			int j = i;
			while(j > 0 && stringOneLessThanStringTwo(list[j], list[j-1])){
				String temp = list[j-1];
				list[j-1] = list[j];
				list[j] = temp;
				j--;
			}
		}
		return list;
	}
	/**
	 * Compares the ASCII values of characters in each String to see which String comes 
	 * first alphabetically. Will not work as intended if the Strings are not lowercased
	 * without whitespace.
	 * @param str1 - A lowercased no space string
	 * @param str2 - A lowercased no space string
	 * @return - True if str1 comes before str2 alphabetically. False otherwise.
	 */
	public boolean stringOneLessThanStringTwo(String str1, String str2){
		int length = 0;
		//only need to check up to lowest length string
		if(str1.length() <= str2.length())
			length = str1.length();
		else
			length = str2.length();
		
		int i = 0;
		while(i < length){
			if((int) str1.charAt(i) < (int)str2.charAt(i)){
				return true;
			}else if(str1.charAt(i) == str2.charAt(i)){
				i++;
				continue;
			}else{
				return false;
			}
		}
		//If neither string comes first
		return true;
	}
	/**
	 * Removes white space and makes all letters in String lowercase so they can
	 * be more easily compared. Since the ASCII value of 'B' is less than a comparisons
	 * become more difficult.
	 * @param list - The list to lowercase.
	 * @return - The list with lowercased entries.
	 */
	public String[] lowerCaseList(String [] list){
		for(int i = 0; i < list.length; i++){
			list[i] = list[i].toLowerCase().replaceAll("\\s+", "");
		}
		return list;	
	}
	/**
	 * 
	 * @return - Returns the customer's order sorted alphabetically.
	 */
	public String[] getOrder(){
		return customerOrder;
	}
	/**
	 * 
	 * @return - Returns the created items. Returns null if item list contains nothing.
	 */
	public Item[] getItemList(){
		return itemList;
	}
	/**
	 * Prints the facts about each item in the item list. If an entry in item list is null it will not 
	 * be printed.
	 */
	public void printReceipt(){
		int totalCalories = 0;
		BigDecimal totalPrice = BigDecimal.valueOf(0);
		System.out.printf("%-20s %-20s %-20s %n", "NAME:", "PRICE:", "CALORIES:");
		for(Item item : itemList){
			if(item == null){
				continue;
			}
			System.out.printf("%-20s %-20s %-20s %n" , item.getName(), item.getPrice(), item.getCalories());
			totalPrice = totalPrice.add(item.getPrice());
			totalCalories += item.getCalories();
		}
		System.out.printf("%-13s %-17s %-12s", "", "Total: " + totalPrice, "Calories: " + totalCalories);
	}
	/**
	 * Prints all the items that can be made by the item factory.
	 */
	public static void printAvailableItems(){
		for(String productName : ItemFactory.getHashMap().keySet()){
			System.out.println(productName.toUpperCase());
		}
	}
	
}
