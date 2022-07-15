package arrayandhashing;

import java.util.Arrays;


public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();

		// Contains Duplicate
		int[] arr1 = { 1, 2, 3, 4 };
		assert solution.containsDuplicate(arr1);

		// Valid Anagram
		assert solution.isAnagram("cat", "tac");

		// Two Sum
		int[] arr2 = { 1, 2, 3 };
		assert Arrays.toString(solution.twoSum(arr2, 4)).equals(Arrays.toString(new int[] { 0, 2 }));

		// Product of Array Except Self
		int[] arr3 = { 1, 2, 3, 4 };
		assert Arrays.toString(solution.productExceptSelf(arr3)).equals(Arrays.toString(new int[] { 24, 12, 8, 6 }));
	}
}
