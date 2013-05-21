interface ValidInterface {
	static int number = 123;			// interfaces can have static fields, must be initialized
	static final String CONST = "constant"; 
	public void main(String[] args);		// main() can be defined as an instance method
	public abstract void methodOne();		// public and abstract can be optionally specified
	boolean methodTwo();				// public and abstract are implicit
}
