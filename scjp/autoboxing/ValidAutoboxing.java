public class ValidAutoboxing {
	public static void main(String[] args) {
		autobox(123);
		autobox(123,456);
	}

	static void autobox(Integer i) {
		System.out.println(i);
	}

	static void autobox(Integer... ints) {
		for(Integer i : ints) System.out.print(i + " ");
	}
}
