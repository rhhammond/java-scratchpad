import java.util.*;

class A {}
class B extends A {}

public class InvalidWildcard {
	public static void main(String[] args) {
		List<A> l = new ArrayList<A>();
		l.add(new B());
		go(l);
		
	}

	public static void go(List<? extends A> l) {
		l.add(new B());		// should be a compiler error, can't add to a collection that uses 'extends' with a wildcard
	}
}
