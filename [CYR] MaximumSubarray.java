import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumSubarray {

	public static void main(String[] args) {

		Solution solution = new Solution();

		/*
		 * 53. Maximum Subarray Easy
		 * 
		 * Given an integer array nums, find the contiguous subarray 
		 * (containing at least one number) which has the largest sum and return its sum.
		 * 
		 * Example 1:
		 * 
		 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4] 
		 * Output: 6 
		 * Explanation: [4,-1,2,1] has the largest sum = 6. 
		 * 
		 * Example 2:
		 * 
		 * Input: nums = [1] 
		 * Output: 1 
		 * 
		 * Example 3:
		 * 
		 * Input: nums = [5,4,-1,7,8] 
		 * Output: 23
		 */
		int[] nums = {5,4,-1,7,8};
		int output = solution.maxSubArray(nums);

		System.out.println("Output : " + output);
	}

	static class Solution {

		public int maxSubArray(int[] nums) {
			int sum = 0, maxSum = Integer.MIN_VALUE;

			for (int num : nums) {
				sum = Math.max(sum, 0) + num;
				maxSum = Math.max(maxSum, sum);
			}

			return maxSum;
		}
	}
}
