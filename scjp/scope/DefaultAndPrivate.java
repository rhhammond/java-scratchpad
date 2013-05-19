class Fields {
	int packageInt=123;
	protected int protectedInt=456;
}

public class DefaultAndPrivate {

	public static void main(String[] args) {
		Fields f=new Fields();
		System.out.println(f.packageInt); 	//default = package scope
		System.out.println(f.protectedInt);	//protected = default + inheritance
	}
}
	
