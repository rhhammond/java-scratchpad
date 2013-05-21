class Parent {
	int field = 123;
}

public class FieldsCantBeOverridden extends Parent {
	int field = 456;
	
	public static void main(String[] args) {
		Parent p = new FieldsCantBeOverridden();
		System.out.println(p.field);			// prints '123'
	}
}

