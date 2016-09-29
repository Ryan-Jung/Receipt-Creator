package builder.menu.rj;

import java.util.HashMap;
import java.util.List;
import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import io.github.lukehutch.fastclasspathscanner.scanner.ScanResult;
import menu.items.rj.Item;
import menu.items.rj.MainCourse;
import menu.items.rj.maincoursemeals.*;
/**
 * Makes main course meals.
 *
 */
public class MakeMainCourse extends ItemCreator{
	//All main course meals should be in this package.
	private static final String PACKAGE_PREFIX = "menu.items.rj.maincoursemeals";
	private HashMap<String, Item> mainCourseHM = new HashMap<String, Item>();
	
	public MakeMainCourse(){
		loadHashMap();
	}
	
	@Override
	public Item makeProduct(String product) {
		return mainCourseHM.get(product);
	}

	@Override
	public void loadHashMap() {
		//Get all subclasses of MainCourse in 'menu.items.rj.maincoursemeals'
		ScanResult scanResult = new FastClasspathScanner(PACKAGE_PREFIX).scan();
		List<String> subclasses = scanResult.getNamesOfSubclassesOf(MainCourse.class.getName());
		
		for(String item : subclasses){
			Class<?> mealCourseClass;
			try {
				
				mealCourseClass = Class.forName(item);
				String productName = getNameOfProduct(item);
				mainCourseHM.put(productName, (Item) mealCourseClass.newInstance());
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	
	@Override
	public boolean itemExists(String product) {
		product = product.toLowerCase();
		return mainCourseHM.containsKey(product);
	}


}
