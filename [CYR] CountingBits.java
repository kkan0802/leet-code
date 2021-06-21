import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountingBits {

	public static void main(String[] args) {

		Solution solution = new Solution();

		/*
		 * 338. Counting Bits
		 * 
		 * Given an integer n, return an array ans of length n + 1 such that for each i
		 * (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
		 * 
		 * Example 1:
		 * 
		 * Input: n = 2 
		 * Output: [0,1,1] 
		 * Explanation: 
		 * 0 --> 0 
		 * 1 --> 1 
		 * 2 --> 10
		 * 
		 * Example 2:
		 * 
		 * Input: n = 5 
		 * Output: [0,1,1,2,1,2] 
		 * Explanation: 
		 * 0 --> 0 
		 * 1 --> 1 
		 * 2 --> 10 
		 * 3 --> 11 
		 * 4 --> 100 
		 * 5 --> 101
		 * 
		 */
		
		int n = 2;
		int[] output = solution.countBits(n);
		
		System.out.println("Output : " + output);

	}

	static class Solution {

		public int[] countBits(int num) {
			/*
			 * Explanation : if supposedely we have num = 5 0 --> 0 1 --> 1 2 --> 10 3 -->
			 * 11 4 --> 100 5 --> 101 if y is odd,then 1s in y = (y/2)+1 if y is even,then
			 * 1s in y = (y/2) e.g,let y = 3,then 1s in y = 3/2 = 1+1 = 2 let y = 4,y = 4/2
			 * = 2(no of 1s in 2) = 1
			 */
			int[] result = new int[num + 1];
			result[0] = 0;
			for (int i = 1; i <= num; i++) {
				if (i % 2 == 0) {
					result[i] = result[i / 2];
				} else {
					result[i] = result[i / 2] + 1;
				}
			}
			return result;
		}
	}
}
