public class WideningOverload {
	public static void main(String[] args) {
		objectOrInteger(123);
	}
	
	static void objectOrInteger(Object o) { System.out.println("Object"); }
	static void objectOrInteger(Integer i) { System.out.println("Integer"); }
}
