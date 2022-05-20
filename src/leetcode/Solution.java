package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	
	//Arrays & Hashing
	
	/*
	 *	Problem:  Contains Duplicate (https://leetcode.com/problems/contains-duplicate/)
	 *	Solution: https://www.youtube.com/watch?v=3OamzN90kPg
	 */
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i : nums) {
			set.add(i);
		}
		return set.size() == nums.length;
    }
	
	
	
	
}
