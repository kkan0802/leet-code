import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MergeTwoSortedLists {

	public static void main(String[] args) {

		Solution solution = new Solution();

		/*
		 * 21. Merge Two Sorted Lists
		 * 
		 * Merge two sorted linked lists and return it as a sorted list. The list should
		 * be made by splicing together the nodes of the first two lists.
		 * 
		 * Example 1:
		 * 
		 * Input: l1 = [1,2,4], l2 = [1,3,4] 
		 * Output: [1,1,2,3,4,4] 
		 * 
		 * Example 2:
		 * 
		 * Input: l1 = [], l2 = [] 
		 * Output: [] 
		 * 
		 * Example 3:
		 * 
		 * Input: l1 = [], l2 = [0] 
		 * Output: [0]
		 */
		
		ListNode l1 = new ListNode(1,new ListNode(2,new ListNode(4,new ListNode(6))));
		ListNode l2 = new ListNode(1,new ListNode(3,new ListNode(4,new ListNode(5))));
		ListNode rslt = solution.mergeTwoLists(l1, l2);
		System.out.print("Merge Two Sorted Lists: [");
		while (rslt != null) {
			System.out.print(rslt.val + " ");
			rslt = rslt.next;
		}
		System.out.println("]");

	}

	static class Solution {

		public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        ListNode head = new ListNode();
	        ListNode tail = head;

	        while (l1 != null || l2 != null) {
	            if (l2 == null || (l1 != null && l1.val < l2.val)) {
	                tail.next = l1;
	                tail = l1;
	                l1 = l1.next;
	            } else {
	                tail.next = l2;
	                tail = l2;
	                l2 = l2.next;
	            }
	        }

	        return head.next;
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
