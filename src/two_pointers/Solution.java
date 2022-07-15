package two_pointers;

public class Solution {
	
	
	/*
	 * Problem:  Valid Palindrome ( https://leetcode.com/problems/valid-palindrome/ ) 
	 * Solution: https://www.youtube.com/watch?v=jJXJ16kPFWg
	 * Note:     2 pointers, one from start, one from end
	 * Time:     O(n) 
	 * Space:    O(1)
	 */
	public boolean isPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;

		while (start < end) {
			while (start < end && !isAlphaNum(s.charAt(start))) {
				start++;
			}
			while (start < end && !isAlphaNum(s.charAt(end))) {
				end--;
			}
			if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	private boolean isAlphaNum(char c) {
		if ((int) c >= 97 && (int) c <= 122 || (int) c >= 65 && (int) c <= 90 || (int) c >= 48 && (int) c <= 57) {
			return true;
		}
		return false;
	}
}
