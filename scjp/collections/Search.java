import java.util.*;

class Search {
	public static void main(String[] args) {
		int[] nums = {123, 4, -5, 555, 98765};
		
		// trying to search before sorting will result in meaningless results!
		System.out.println("Before sorting: " + Arrays.toString(nums));
		System.out.println("Index of 4: " + Arrays.binarySearch(nums, 4));
		System.out.println("Insertion point for 5: " + Arrays.binarySearch(nums, 5));
		
		Arrays.sort(nums);
		System.out.println("After sorting: " + Arrays.toString(nums));
		System.out.println("Index of 4: " + Arrays.binarySearch(nums, 4));
		System.out.println("Insertion point for 5: " + Arrays.binarySearch(nums, 5));		// insertion point for missing element = -(index + 1)
	}
}
