package builder.menu.rj;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import io.github.lukehutch.fastclasspathscanner.scanner.ScanResult;
import menu.items.rj.Item;
import menu.items.rj.MainCourse;
import menu.items.rj.maincoursemeals.*;
/**
 * Makes main course meals.
 *
 */
public class MakeMainCourse implements ItemCreator{
	private HashMap<String, Item> mainCourseHM = new HashMap<String, Item>();
	
	public MakeMainCourse(){
		loadHashMap();
	}
	
	@Override
	public Item makeProduct(String product) {
		switch(product.toLowerCase()){
			case "burger":
				return new Burger();
			case "burrito":
				return new Burrito();
			default: 
				return null;
		}
	}

	@Override
	public void loadHashMap() {
		ScanResult scanResult = new FastClasspathScanner("menu.items.rj.maincoursemeals").scan();
		List<String> subclasses = scanResult.getNamesOfSubclassesOf(MainCourse.class.getName());
		for(String item : subclasses){
			Class<?> mealCourseClass;
			try {
				mealCourseClass = Class.forName(item);
				String productName = getNameOfProduct(item);
				mainCourseHM.put(productName, 
						(Item) mealCourseClass.newInstance());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * Takes in a a class's fully qualified name and returns the class name. For example if the class 
	 * path name is menu.items.rj.Drinks.Coke this method would return 'coke'.
	 * @param fullyQualifiedName
	 * @return - The name of the class to lower case.
	 */
	public String getNameOfProduct(String fullyQualifiedName){
		Stack<Character> charStack = new Stack<Character>();
		int i = fullyQualifiedName.length()-1;
		while(fullyQualifiedName.charAt(i) != '.'){
			charStack.push(fullyQualifiedName.charAt(i));
			i--;
		}
		
		String productName = "";
		while(!charStack.isEmpty()){
			productName += charStack.pop();
		}
		return productName.toLowerCase();
	}
	
	@Override
	public boolean itemExists(String product) {
		product = product.toLowerCase();
		if(mainCourseHM.get(product) == null){
			return false;
		}else{
			return true;
		}
	}


}
