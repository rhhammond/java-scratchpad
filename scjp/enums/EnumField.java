public class EnumField {
	enum Animals {
		DOG("woof"), CAT("meow"), COW("moo");
		String sound;
		Animals(String s) {sound = s;}
	}

	static Animals a;
	
	public static void main(String[] args) {
		System.out.println(a);			//null
		System.out.println(a.DOG);		//DOG - no NPE, static reference to DOG	
		System.out.println(a.CAT.sound);	//meow - no NPE, static reference to CAT.sound
	}
}
