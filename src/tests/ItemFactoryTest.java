package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import builder.menu.rj.ItemFactory;

public class ItemFactoryTest {
	

	//Test to see if items are properly loaded into hash map
	@Test
	public void testLoadHashMap() {
		ItemFactory itemFact = ItemFactory.getInstance();
		itemFact.loadHashMap();
		assertTrue(itemFact.itemExists("burger"));
		assertNotNull(itemFact.makeProduct("burger"));
		assertNull(itemFact.makeProduct("nonExistantProduct"));
	}

}
