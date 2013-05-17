
//Unless otherwise specified, a call to super() will be injected into all constructors

class Parent{
	public Parent(String s) {System.out.println("Parent");};
}

public class MissingParentCtor extends Parent{
	public MissingParentCtor(String s) {
		// call to super() fails here.  Have to call super(s)	
		System.out.println(s);
	}

	public static void main(String[] args) { new MissingParentCtor("howdy"); }
}
