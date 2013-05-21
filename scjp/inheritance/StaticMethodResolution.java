/* static methods cannot be overriden, they are resolved at compile-time by the reference's type */

class GrandParent { static void go() { System.out.println("GrandParent"); } }

class Parent extends GrandParent { static void go() { System.out.println("Parent"); } }

public class StaticMethodResolution extends Parent {
	
	public static void main(String[] args) {
		GrandParent gp = new Parent();
		Parent p = new StaticMethodResolution();
		StaticMethodResolution m = new StaticMethodResolution();
		gp.go();
		p.go();
		m.go();
	}

	static void go() { System.out.println("Child"); }
}

