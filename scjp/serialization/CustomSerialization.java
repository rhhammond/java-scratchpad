import java.io.*;

class Parent { 
	int parentNum;						// this deserializes to '0', Parent is not Serializable! 
}

public class CustomSerialization extends Parent implements Serializable {

	transient String val;
	int num;

	public static void main(String[] args) {
		CustomSerialization cs = new CustomSerialization();
		
		cs.num = 123;
		cs.parentNum = 456;
		cs.val = "Howdy";

		try {
			
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream os = new ObjectOutputStream(bos);
			os.writeObject(cs);

			ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
			ObjectInputStream is = new ObjectInputStream(bis);
			CustomSerialization cs2 = (CustomSerialization)is.readObject();
			
			System.out.println(cs);
			System.out.println(cs2);
		
		} catch(Exception e) { 
			e.printStackTrace(); 
		}

	}
	
	private void writeObject(ObjectOutputStream os) {
		try {
			os.defaultWriteObject();
			os.writeObject(val);			// serialize transient value
		} catch (Exception e) { e.printStackTrace(); }
	}

	private void readObject(ObjectInputStream is) {
		try {
			is.defaultReadObject();
			val = (String)is.readObject();		// deserialize transient value
		} catch (Exception e) { e.printStackTrace(); }
	}

	public String toString() { return val + " " + num + " " + parentNum; }
}
