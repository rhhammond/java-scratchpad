public class MethodVarsMustBeInitialized {
	
	public static void main(String[] args) { go();}
	
	static void go() {
		int i;
		i++;	// compiler error, i must be initialize
	}
}
