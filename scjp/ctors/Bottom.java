/*
Order of execution during instantiation:	
	1) static initializer
	2) call super()
	3) initializer block
	4) constructor body
*/
class Top {
	static { System.out.println("Static Top initializer"); }
	{ System.out.println("Top initializer"); }
	public Top(){ System.out.println("Top ctor"); }
}

class Middle extends Top {
	static { System.out.println("Static Middle initializer"); }
	{ System.out.println("Middle initializer"); }
	public Middle(){ System.out.println("Middle ctor");}
}

public class Bottom extends Middle {
	static { System.out.println("Static Bottom initializer"); }
	{ System.out.println("Bottom initializer"); }
	public Bottom(){ System.out.println("Bottom ctor"); }
	public static void main(String[] args) {
		new Bottom();
		System.out.println("\nRound 2!\n");
		new Bottom();
	}
}
