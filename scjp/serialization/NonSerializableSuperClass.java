import java.io.*;

class Parent {
	private String val;
	
	public Parent(String s) { val = s; }		// this will fail deserialization. A non-serializable superclass must have a no-arg constructor

	public String getVal() { return val; }
}

class Child extends Parent implements Serializable {
	public Child(String s) {super(s);}
}

public class NonSerializableSuperClass {

	public static void main(String[] args) {
		Child c = new Child("hi");
	 	try {	
			ByteArrayOutputStream bs = new ByteArrayOutputStream();
			ObjectOutputStream os = new ObjectOutputStream(bs);
			os.writeObject(c);
			
			ByteArrayInputStream bis = new ByteArrayInputStream(bs.toByteArray());
			ObjectInputStream is = new ObjectInputStream(bis);
			Child c2 = (Child)is.readObject();

			System.out.println(c2.getVal());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
