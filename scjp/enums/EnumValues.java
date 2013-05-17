public class EnumValues {
	enum MyEnum {
		ONE { public String toString() {return "UNO";}}, 
		TWO { public String toString() {return "DOS";}}, 
		THREE { public String toString() {return "TRES";}};
	}

	public static void main(String[] args) {
		for(MyEnum e : MyEnum.values()) System.out.println(e);
	}
}
