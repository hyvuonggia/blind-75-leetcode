package array;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		
		// Contains Duplicate
		int[] arr1 = {1, 2, 3, 4};
		System.out.println(solution.containsDuplicate(arr1));
		
		// Best Time to Buy and Sell Stock
		int[] arr2 = {7,1,5,3,6,4};
		System.out.println(solution.maxProfit(arr2));
	}
}
