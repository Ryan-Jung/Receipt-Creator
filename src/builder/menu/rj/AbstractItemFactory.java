package builder.menu.rj;

import menu.items.rj.Drink;
import menu.items.rj.Extra;
import menu.items.rj.MainCourse;

public abstract class AbstractItemFactory {
	
	public abstract MainCourse getMainCourse();
	
	public abstract Drink getDrink();
	
	public abstract Extra getExtra();
	

}
