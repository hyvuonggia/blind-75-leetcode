package dynamic_programming;

public class Solution {
	/*
	 * Problem:  Maximum Product Subarray ( https://leetcode.com/problems/maximum-product-subarray/ ) 
	 * Solution: https://youtu.be/lXVy6YWFcRM				
	 * Note:     dp: compute max and max-abs-val for each prefix subarr;
	 * Time:     O(n) 
	 * Space:    O(1)
	 */
	public int maxProduct(int[] nums) {
		if (nums.length == 0 || nums == null) {
			return 0;
		}
		
		int max = nums[0];
		int min = nums[0];
		int result = nums[0];
		
		for (int i = 1; i < nums.length; i++) {
			int temp = max;
			max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
			min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
			result = Math.max(max, result);
		}
		return result;
		
		// BRUTE FORCE O(n^2)
//		int max = Integer.MIN_VALUE;
//		int currentProduct = 1;
//		for (int i = 0; i < nums.length; i++) {
//			currentProduct = 1;
//			for (int j = i; j < nums.length; j++) {
//				currentProduct *= nums[j];
//				max = Math.max(max, currentProduct);
//			}
//		}
//        return max;
    }
}
