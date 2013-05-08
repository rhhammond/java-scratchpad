class Parent { 
	public void doIt() { System.out.println("dooooooooooo it"); }
}

public class ValidSuperAndThisUsage extends Parent {
	public static void main (String[] args) {
		new ValidSuperAndThisUsage().howdy();
	}

	public void howdy() {
		this.doIt();
		super.doIt();
	}
}
	
