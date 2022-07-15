package greedy;

public class Solution {
	/*
	 * Problem:  Maximum Subarray ( https://leetcode.com/problems/maximum-subarray/ ) 
	 * Solution: https://www.youtube.com/watch?v=5WZl3MMT0Eg
	 * Note:     pattern: prev subarray cant be negative, dynamic programming: compute max sum for each prefix
	 * Time:     O(n) 
	 * Space:    O(1)
	 */
	public int maxSubArray(int[] nums) {
		int maxSub = nums[0];
		int currentSum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (currentSum < 0) {
				currentSum = 0;
			}
			currentSum += nums[i];
			maxSub = Math.max(maxSub, currentSum);
		}
		return maxSub;
		
		// BRUTE FORCE O(n^2)
//		int max = Integer.MIN_VALUE;
//		int currentSum = 0;
//		for (int i = 0; i < nums.length; i++) {
//			currentSum = 0;
//			for (int j = i; j < nums.length; j++) {
//				currentSum += nums[j];
//				max = Math.max(max, currentSum);
//			}
//		}
//		return max;
	}
}
