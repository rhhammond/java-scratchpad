/* You can not access a parent's parent using 'super' */

class Parent{}

public class InvalidSuperSuper extends Parent {	
	public static void main (String[] args) {
		new InvalidSuperSuper().go();
	}
	
	public void go() {
		Sysetem.out.println(super.super);
	}
}





