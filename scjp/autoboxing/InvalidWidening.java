public class InvalidWidening {
	
	static void main (String[] args) {
		autoboxAndWiden(123);
		autoboxAndWiden(123,456);
	}

	static void autoboxAndWiden(Long l) {
		System.out.println(l);
	}

	static void autoboxAndWiden(Long... longs) {
		for(Long l : longs) System.out.print(l + " ");
	}
}
