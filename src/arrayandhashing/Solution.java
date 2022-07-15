package arrayandhashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

	/*
	 * Problem:  Contains Duplicate ( https://leetcode.com/problems/contains-duplicate/ ) 
	 * Solution: https://www.youtube.com/watch?v=3OamzN90kPg
	 * Note:     hashset to get unique values in array, to check for duplicates easily
	 * Time:     O(n)
	 * Space:    O(n)
	 */
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set1 = new HashSet<>();
		for (int i : nums) {
			set1.add(i);
		}
		return set1.size() == nums.length;
	}

	/*
	 *	Problem:  Valid Anagram ( https://leetcode.com/problems/valid-anagram/ )
	 *	Solution: https://www.youtube.com/watch?v=9UtInBqnCgA
	 *	Note: 	  hashmap to count each char in str1, decrement for str2;
	 *	Time: 	  O(s+t)
	 *	Space:    O(s+t)
	 */
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		Map<Character, Integer> map1 = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map1.containsKey(c)) {
				map1.put(c, map1.get(c) + 1);
			} else {
				map1.put(c, 1);
			}
		}

		for (int i = 0; i < s.length(); i++) {
			char c = t.charAt(i);
			if (map1.containsKey(c)) {
				if (map1.get(c) == 1) {
					map1.remove(c);
				} else {
					map1.put(c, map1.get(c) - 1);
				}
			} else {
				return false;
			}
		}

		if (map1.size() == 0) {
			return true;
		}
		return false;
	}
	
	/*
	 * Problem:  Best Time to Buy and Sell Stock ( https://leetcode.com/problems/best-time-to-buy-and-sell-stock/ ) 
	 * Solution: https://www.youtube.com/watch?v=1pkOgXD63yU 
	 * Note:     find local min and search for local max, sliding window
	 * Time:     O(n) 
	 * Space:    O(1)
	 */
	public int maxProfit(int[] prices) {
		int left = 0; // buy
		int right = 1; // sell
		int maxProfit = 0;

		while (right < prices.length) {
			if (prices[left] < prices[right]) {
				int profit = prices[right] - prices[left];
				maxProfit = Math.max(maxProfit, profit);
			} else {
				left = right;
			}
			right += 1;
		}

		return maxProfit;
	}

	/*
	 * Problem:  Two Sum ( https://leetcode.com/problems/two-sum/ ) 
	 * Solution: https://www.youtube.com/watch?v=KLlXCFG5TnA
	 * Note:     use hash map to instantly check for difference value, map will add index of last occurrence of a num, don't use same element twice;
	 * Time:     O(n) 
	 * Space:    O(n)
	 */
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int diff = target - nums[i];
			if (map.containsKey(diff)) {
				return new int[] { map.get(diff), i };
			}
			map.put(nums[i], i);
		}
		return null;
	}

	/*
	 * Problem:  Product of Array Except Self ( https://leetcode.com/problems/product-of-array-except-self/ ) 
	 * Solution: https://www.youtube.com/watch?v=bNvIQI2wAjk
	 * Note:     make two passes, first in-order, second in-reverse, to compute products
	 * Time:     O(n) 
	 * Space:    O(1)
	 */
	public int[] productExceptSelf(int[] nums) {
		int[] result = new int[nums.length];
		Arrays.fill(result, 1);
		
		int prefix = 1;
		for (int i = 0; i < nums.length; i++) {
			result[i] = prefix;
			prefix *= nums[i];
		}
		
		int postfix = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			result[i] *= postfix;
			postfix *= nums[i];
		}
		
		return result;
	}
	
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
