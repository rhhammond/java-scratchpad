public class InvalidMethodScope {
	static int var = 7;				//var = class scope
	
	public static void main(String[] args) {
		new InvalidMethodScope().go(var);
		System.out.println(var);
	}

	void go(int var) {
		var++;					//var = method parameter (method scope)
		for(int var = 3; var < 6; var++);	//var = block parameter (cannot redefine variable within method scope, compiler error)
		System.out.println(var);	
	}
}
