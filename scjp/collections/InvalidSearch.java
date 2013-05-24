import java.util.*;

class Flurb { 
	final int x;
	Flurb(int x) {this.x = x;}
}

public class InvalidSearch {
	public static void main(String[] args) {
		Flurb f1 = new Flurb(1);
		Flurb f2 = new Flurb(123);
		Flurb f3 = new Flurb(555);

		Flurb[] fa = {f1,f2,f3};

		Comparator<Flurb> modComparator = new Comparator<Flurb>() {
			public int compare(Flurb one, Flurb two) {
				return (one.x % 5) - (two.x %5);
			}
		};

		Arrays.sort(fa, modComparator);
		for(Flurb f : fa) System.out.print(f.x + " ");
		System.out.println("\n"+Arrays.binarySearch(fa, f1, modComparator));
		System.out.println(Arrays.binarySearch(fa, f2));				// Exception, must search using the comparator used to sort!
		
	}
}
