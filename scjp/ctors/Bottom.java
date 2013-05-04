/* Static initializer blocks are executed before ctors! */

class Top {
	{ System.out.println("Top initializer"); }
	public Top(){ System.out.println("Top ctor"); }
}

class Middle extends Top {
	{ System.out.println("Middle initializer"); }
	public Middle(){ System.out.println("Middle ctor");}
}

public class Bottom extends Middle {
	{ System.out.println("Bottom initializer"); }
	public Bottom(){ System.out.println("Bottom ctor"); }
	public static void main(String[] args) {
		new Bottom();
	}
}
