public class CannotComparePrimitivesToInstances {
	public static void main(String[] args) { if(new float[0] == 4.2f) System.out.println("hi"); } //compiler error, can't compare primitive to object
}
