public class WideningOverVarArgs {
	
	public static void main(String[] args) {
		int[] a = new int[1];
		widenBeforeVarArgs(a);
	}

	static void widenBeforeVarArgs(Object o) { System.out.println("Object"); }
	static void widenBeforeVarArgs(int[]... arrays) { System.out.println("int[]..."); }
}
