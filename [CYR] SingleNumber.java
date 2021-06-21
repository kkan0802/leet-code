import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingleNumber {

	public static void main(String[] args) {

		Solution solution = new Solution();

		/*
		 * 136. Single Number 
		 * 
		 * Given a non-empty array of integers nums, every element
		 * appears twice except for one. Find that single one.
		 * 
		 * You must implement a solution with a linear runtime complexity and use only
		 * constant extra space.
		 * 
		 * Example 1:
		 * 
		 * Input: nums = [2,2,1] 
		 * Output: 1
		 * 
		 * Example 2:
		 * 
		 * Input: nums = [4,1,2,1,2] 
		 * Output: 4 
		 * 
		 * Example 3:
		 * 
		 * Input: nums = [1] 
		 * Output: 1
		 */
		
		int[] nums = { 4, 1, 2, 1, 2 };
		int output = solution.singleNumber(nums);
		System.out.println("Output : " + output);
	}

	static class Solution {
		public int singleNumber(int[] nums) {
			List<Integer> no_duplicate_list = new ArrayList<>();

			for (int i : nums) {
				if (!no_duplicate_list.contains(i)) {
					no_duplicate_list.add(i);
				} else {
					no_duplicate_list.remove(new Integer(i));
				}
			}
			return no_duplicate_list.get(0);
		}
	}
}
