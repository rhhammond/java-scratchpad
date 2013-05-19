public class CannotNarrow {

	public static void main(String[] args) {
		new CannotNarrow.go(3);		// this is an int, will not match either signature!
	}

	void go(short s) { System.out.println("short"); }

	void go(short... shorts) { System.out.println("short..."); }
}
