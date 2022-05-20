package string;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	
	/*
	 *	Problem:  Valid Anagram (https://leetcode.com/problems/valid-anagram/)
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
		
		if(map1.size() == 0) {
			return true;
		}
		return false;

    }
}
