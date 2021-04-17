import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LeetCodeEasySolutions {

	public static void main(String[] args) {

		long beforeTime = System.currentTimeMillis();

		Solutions solution = new Solutions();
		Object obj = null;
		/*TwoSum*/
		obj = Arrays.toString(solution.twoSum(new int[] { 2, 7, 11, 15 }, 9));
		System.out.println("TwoSum: " + obj);
		
		/*Valid Parentheses*/
		obj = solution.isValid("()[]{}");
		System.out.println("Valid Parentheses: " + obj);
		
		/*Merge Two Sorted Lists*/
		ListNode l1 = new ListNode(1,new ListNode(2,new ListNode(4,new ListNode(6))));
		ListNode l2 = new ListNode(1,new ListNode(3,new ListNode(4,new ListNode(5))));
		ListNode rslt = solution.mergeTwoLists(l1, l2);
		System.out.print("Merge Two Sorted Lists: [");
		while (rslt != null) {
			System.out.print(rslt.val + " ");
			rslt = rslt.next;
		}
		System.out.println("]");
		
		long afterTime = System.currentTimeMillis();
		System.out.println("##################################\nrunTime: " + (afterTime - beforeTime));
	}

	static class Solutions {

		/*
		 * .21. Merge Two Sorted Lists
		 *
		 * Definition for singly-linked list.
		 * public class ListNode {
		 *     int val;
		 *     ListNode next;
		 *     ListNode() {}
		 *     ListNode(int val) { this.val = val; }
		 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		 * }
		 */
		public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			if (l1 == null || l2 == null) {
				return  l1 == null? l2: l1;
			} else {
				if (l1.val < l2.val) {
					return new ListNode(l1.val, mergeTwoLists(l1.next, l2));
				} else {
					return new ListNode(l2.val, mergeTwoLists(l1, l2.next));
				}
			}
		}

		/*
		 * .20. Valid Parentheses
		 */
		public boolean isValid(String s) {
			Stack<Character> stack = new Stack<>();
			Map<Character,Character> map = new HashMap<>();
			{
				map.put('(', ')');
				map.put('[', ']');
				map.put('{', '}');
			}
			
			for (int i = 0; i < s.length(); i++) {
				char item = s.charAt(i);
				if (item == '(' || item == '[' || item == '{') {
					stack.push(item);
				} else {
					if (stack.isEmpty() || item != map.get(stack.pop())) {
						return false;
					}
				}
			}
			
			return true;
		}

		/*
		 * .1. TwoSum
		 */
		public int[] twoSum(int[] nums, int target) {
			for (int i = 0; i < nums.length - 1; i++) {
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[i] + nums[j] == target) {
						return new int[] { i, j };
					}
				}
			}
			return new int[] { 0, 0 };
		}

	}
	
	static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
}
