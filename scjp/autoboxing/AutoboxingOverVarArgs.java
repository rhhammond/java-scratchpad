public class AutoboxingOverVarArgs {

	public static void main(String[] args) {
		autoboxBeforeVarArgs(123);
	}

	static void autoboxBeforeVarArgs(Integer i) { System.out.println("Integer"); }
	static void autoboxBeforeVarArgs(int... ints) { System.out.println("int..."); }
}
