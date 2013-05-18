public class WideningOverAutoboxing {
	
	public static void main (String[] args) {
		widenBeforeAutobox(123);
	}

	public static void widenBeforeAutobox(long l) { System.out.println("long"); }
	public static void widenBeforeAutobox(Integer i) { System.out.println("Integer"); }
}
