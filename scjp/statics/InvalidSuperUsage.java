/* Like 'this', the 'super' keyword cannot be used from a static context */

class Parent { 
	public	static void hi() { System.out.println("Hi"); }
}

public class InvalidSuperUsage extends Parent {
	public static void main(String[] args) {
		super.hi(); //compiler error
	}
}
