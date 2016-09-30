import builder.menu.rj.MakeMainCourse;
import menu.items.rj.Burger;

public class Test {
	public static void main(String[] args){
		MakeMainCourse mmc = new MakeMainCourse();
		mmc.loadHashMap();
		System.out.println(mmc.getNameOfProduct("hehe.hehe.hehe.Hello.World"));
	}
}
