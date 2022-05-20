package array;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	/*
	 *	Problem:  Contains Duplicate (https://leetcode.com/problems/contains-duplicate/)
	 *	Solution: https://www.youtube.com/watch?v=3OamzN90kPg
	 *	Note: 	  hashset to get unique values in array, to check for duplicates easily
	 *	Time:     O(n)
	 *	Space: 	  O(n)
	 */
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set1 = new HashSet<>();
		for (int i : nums) {
			set1.add(i);
		}
		return set1.size() == nums.length;
    }
}
