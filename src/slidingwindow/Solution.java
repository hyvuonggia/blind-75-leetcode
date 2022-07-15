package slidingwindow;

public class Solution {
	/*
	 * Problem:  Best Time to Buy and Sell Stock ( https://leetcode.com/problems/best-time-to-buy-and-sell-stock/ ) 
	 * Solution: https://www.youtube.com/watch?v=1pkOgXD63yU 
	 * Note:     find local min and search for local max, sliding window
	 * Time:     O(n) 
	 * Space:    O(1)
	 */
	public int maxProfit(int[] prices) {
		int left = 0;
		int right = 1;
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
}
