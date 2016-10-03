package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import builder.menu.rj.Order;
import menu.items.rj.*;

public class OrderTest {
	//Test the StringOneComesFirst method which checks if first String
	//comes before second String in the alphabet
	@Test
	public void StringOneComesFirstTest() {
		String [] listOne = { "   Hello Wolrd" , "x e a s" };
		Order a = new Order(listOne);
		String [] listTwo = {"x e a s", "   Hello Wolrd"};
		listOne = a.lowerCaseList(listOne);
		listTwo = a.lowerCaseList(listTwo);
		
		assertTrue(a.stringOneLessThanStringTwo(listOne[0], listOne[1]));
		assertFalse(a.stringOneLessThanStringTwo(listTwo[0], listTwo[1]));
		assertTrue(a.stringOneLessThanStringTwo("hello", "hello"));
	}
	//Test if getOrder() returns customer's order
	@Test
	public void getOrderTest(){
		String [] orderList = {"cat, dog, eel"};
		Order a = new Order(orderList);
		assertArrayEquals(orderList, a.getOrder());
	}
	//Test if sortList() sorts properly
	@Test
	public void sortListTest(){
		String [] testList = {"lala" , "hello" , "hEllo", " A b c" , "zYxzS", "hel lo"};
		String [] answer = {"abc", "hello", "hello", "hello" , "lala", "zyxzs"};
		
		Order order = new Order(testList);
		testList = order.sortList(testList);
		assertArrayEquals(testList,answer);
		
	}
	// Test if item list contains instances of given item. 
	@Test
	public void getItemList(){
		String [] orderList = {"burger", "burRito", "COKE"};
		Order order = new Order(orderList);
		Item [] list = order.getItemList();
		assertTrue(list[0] instanceof Burger);
		assertTrue(list[1] instanceof Burrito);
		assertTrue(list[2] instanceof Coke);
		//non-existent item
		String [] orderList2 = {"iliketoeatcake :) "};
		Order order2 = new Order(orderList2);
		assertTrue(order2.getItemList()[0] == null);
	}
}
