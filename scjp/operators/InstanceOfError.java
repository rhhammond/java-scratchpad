class One {}
class Two {}
public class InstanceOfError {
	public static void main(String[] args) {
		if(new One() instanceof Two) System.out.println("hi");	// instanceof cannot compare objects that are not in the same class hierarchy
	}
}
