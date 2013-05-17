public class EnumOverriding {
	enum Wacky {
		BIZARRE { void print() { System.out.println("Totally bizarre dude!"); } },
		TRIPPY { void print() { System.out.println("I'm freaking out, man"); } },
		BORING;		
		void print() {System.out.println("This is pretty boring.");}
	}
	
	static Wacky w = Wacky.BORING;
	public static void main(String[] args) {
		w.print();
		w = Wacky.BIZARRE;
		w.print();
		w = Wacky.TRIPPY;
		w.print();
	}
}
