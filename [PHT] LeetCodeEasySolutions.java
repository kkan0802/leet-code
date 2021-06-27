import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class LeetCodeEasySolutions {

	public static void main(String[] args) {

		long beforeTime = System.currentTimeMillis();

		Solutions solution = new Solutions();
		Object obj = null;
		/*TwoSum*/
		obj = Arrays.toString(solution.twoSum(new int[] { 2, 7, 11, 15 }, 9));
		System.out.println("TwoSum: " + obj);
		System.out.println("##################################");
		
		/*Valid Parentheses*/
		obj = solution.isValid("()[]{}");
		System.out.println("Valid Parentheses: " + obj);
		System.out.println("##################################");
		
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
		System.out.println("##################################");
		
		/*Maximum Subarray*/
		obj = solution.maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 });
		System.out.println("Maximum Subarray: " + obj);
		System.out.println("##################################");
		
		/*Climbing Stairs*/
		obj = solution.climbStairs(7);
		System.out.println("Climbing Stairs: " + obj);
		System.out.println("##################################");
		
		/*Binary Tree Inorder Traversal*/
		TreeNode t1 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
		TreeNode t2 = new TreeNode(1, null, new TreeNode(2));
		TreeNode t3 = new TreeNode(1, new TreeNode(2), null);
		System.out.println("Binary Tree Inorder Traversal case1: " + solution.inorderTraversal(t1));
		System.out.println("Binary Tree Inorder Traversal case2: " + solution.inorderTraversal(t2));
		System.out.println("Binary Tree Inorder Traversal case3: " + solution.inorderTraversal(t3));
		System.out.println("##################################");
		
		/*Symmetric Tree*/
		TreeNode st1 = new TreeNode(1, new TreeNode(2, new TreeNode(3),  new TreeNode(4)), new TreeNode(2, new TreeNode(3),  new TreeNode(4)));
		TreeNode st2 = new TreeNode(1, new TreeNode(2, null,  new TreeNode(2)), new TreeNode(2, null, new TreeNode(3)));
		System.out.println("Symmetric Tree case1: " + solution.isSymmetric(st1));
		System.out.println("Symmetric Tree case2: " + solution.isSymmetric(st2));
		System.out.println("##################################");
		
		/*Maximum Depth of Binary Tree*/
		TreeNode md1 = new TreeNode(1, new TreeNode(2, new TreeNode(3),  new TreeNode(4)), new TreeNode(2, new TreeNode(3),  new TreeNode(4)));
		TreeNode md2 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15, new TreeNode(3), null),  new TreeNode(7)));
		System.out.println("Maximum Depth of Binary Tree case1: " + solution.maxDepth(md1));
		System.out.println("Maximum Depth of Binary Tree case2: " + solution.maxDepth(md2));
		System.out.println("##################################");
		
		/*Best Time to Buy and Sell Stock*/
		System.out.println("Best Time to Buy and Sell Stock case1: " + solution.maxProfit(new int[]{7,1,5,3,6,4}));
		System.out.println("Best Time to Buy and Sell Stock case2: " + solution.maxProfit(new int[]{7,6,4,3,1}));
		System.out.println("##################################");
		
		/*Single Number*/
		System.out.println("Single Number case1: " + solution.singleNumber(new int[]{2,2,1}));
		System.out.println("Single Number case2: " + solution.singleNumber(new int[]{4,1,2,1,2}));
		System.out.println("##################################");
		
		/*Linked List Cycle*/
		ListNode llc = new ListNode(3,new ListNode(2,new ListNode(0,new ListNode(-4))));
		System.out.println("Linked List Cycle case1: " + solution.hasCycle(llc));
		System.out.println("##################################");
		
		/*Intersection of Two Linked Lists*/
		ListNode headA = new ListNode(4,new ListNode(1,new ListNode(8,new ListNode(4,new ListNode(5)))));
		ListNode headB = new ListNode(5,new ListNode(6,new ListNode(1,new ListNode(8,new ListNode(4,new ListNode(5))))));
		System.out.println("Intersection of Two Linked Lists: " + solution.getIntersectionNode(headA, headB));
		System.out.println("##################################");
		
		/*Majority Element*/
		System.out.println("Majority Element case1: " + solution.majorityElement(new int[] {3,2,3}));
		System.out.println("Majority Element case2: " + solution.majorityElement(new int[] {2,2,1,1,1,2,2}));
		System.out.println("##################################");
		
		/*Reverse Linked List*/
		ListNode rl = solution.reverseList(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5))))));
		System.out.print("Reverse Linked List: [");
		while (rl != null) {
			System.out.print(rl.val + " ");
			rl = rl.next;
		}
		System.out.println("]");
		System.out.println("##################################");
		
		long afterTime = System.currentTimeMillis();
		System.out.println("##################################\nrunTime: " + (afterTime - beforeTime) + "ms");
	}

	static class Solutions {

		/*
		 * 206. Reverse Linked List
		 */
		public ListNode reverseList(ListNode head) {
			if (head == null) {
				return head;
			}
			ListNode prev = head;
			ListNode temp = head.next;
			while (temp != null) {
				ListNode next = temp.next;
				temp.next = prev;
				prev = temp;
				temp = next;
			}
			head.next = null;
			return prev;
		}

		/*
		 * 169. Majority Element
		 */
		public int majorityElement(int[] nums) {
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				if (map.get(nums[i]) == null) {
					map.put(nums[i], 1);
				} else {
					map.put(nums[i], map.get(nums[i])+1);
				}
			}
			Set<Integer> keySet = map.keySet();
			
			int resultkey = 0;
			int resultValue = 0;
			
			for (Integer key: keySet) {
				if (Math.max(resultValue, map.get(key)) == map.get(key)) {
					resultValue = map.get(key);
					resultkey = key;
				}
			}
			
			return resultkey;
		}

		/*
		 * 160. Intersection of Two Linked Lists
		 */
		public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
			
			List<Integer> listA = new ArrayList<>();
			List<Integer> listB = new ArrayList<>();
			
			ListNode target = headA;
			
			while(headA != null) {
				listA.add(headA.val);
				headA = headA.next;
			}
			while(headB != null) {
				listB.add(headB.val);
				headB = headB.next;
			}
			int idx = -1;
			if (listA.size() >= listB.size()) {
				for (int i = 0; i < listB.size(); i++) {
					Integer a = listA.subList(listA.size()-listB.size()+i, listA.size()).parallelStream().reduce(0, Integer::sum);
					Integer b = listB.subList(0+i, listB.size()).parallelStream().reduce(0, Integer::sum);
					if (a == b) {
						idx = i+1;
						break;
					}
				}
			} else {
				for (int i = 0; i < listA.size(); i++) {
					Integer a = listA.subList(0+i, listA.size()).parallelStream().reduce(0, Integer::sum);
					Integer b = listB.subList(listB.size()-listA.size()+i, listB.size()).parallelStream().reduce(0, Integer::sum);
					if (a == b) {
						idx = i+1;
						break;
					}
				}
				
			}
			
			if (idx < 0) {
				return null;
			} else {
				for (int i = 0; i < idx; i++) {
					target = target.next;
				}
				System.out.println("value => " + target.val);
				return target;
			}
			
		}

		/*
		 * 155. Min Stack
		 */
		static class MinStack {

			private Stack<Integer> stack;
			private Stack<Integer> minStack;

			public MinStack() {
				stack = new Stack<>();
				minStack = new Stack<>();
			}

			public void push(int val) {
				if (this.stack.isEmpty()) {
					this.stack.push(val);
					this.minStack.push(val);
					return;
				}
				this.stack.push(val);
				if (this.minStack.peek() > val)
					this.minStack.push(val);
				else
					this.minStack.push(this.minStack.peek());
			}

			public void pop() {
				if (this.stack.isEmpty())
					return;
				this.stack.pop();
				this.minStack.pop();
			}

			public int top() {
				return this.stack.peek();
			}

			public int getMin() {
				return this.minStack.peek();
			}
		}

		/*
		 * 141. Linked List Cycle
		 */
		public boolean hasCycle(ListNode head) {
			Set<ListNode> nodesSeen = new HashSet<>();
			while (head != null) {
				if (nodesSeen.contains(head)) {
					return true;
				}
				nodesSeen.add(head);
				head = head.next;
			}
			return false;
		}

		/*
		 * 136. Single Number
		 */
		public int singleNumber(int[] nums) {
			Map<Integer, Integer> mp = new HashMap<>();
			for (final int i : nums) {
				mp.put(i, mp.get(i) != null?mp.get(i)+1: 1);
			}
			for (final int key : mp.keySet()) {
				if (mp.get(key) == 1) return key;
			}
			return 0;
		}

		/*
		 * 121. Best Time to Buy and Sell Stock
		 */
		public int maxProfit(int[] prices) {
			int minVal = 10000, maxVal = -1;
			for (final int i : prices) {
				if (minVal != Math.min(minVal, i)) {
					minVal = i;
					maxVal = -1;
				}
				if (maxVal != Math.max(maxVal, i)) {
					maxVal = i;
				}
			}
			return (maxVal - minVal) < 0? 0: (maxVal - minVal);
		}

		/*
		 * 104. Maximum Depth of Binary Tree
		 */
		public int maxDepth(TreeNode root) {
			int leftDepth = 1;
			int rightDepth = 1;
			
			if (root.left != null)  {
				leftDepth += maxDepth(root.left);
			}
			if (root.right != null)  {
				rightDepth += maxDepth(root.right);
			}
			
			return Math.max(leftDepth, rightDepth);
		}

		/*
		 * .101. Symmetric Tree
		 */
		public boolean isSymmetric(TreeNode root) {
			
			if (root.left == null && root.right == null) {
				return true;
			} else if (root.left == null || root.right == null) {
				return false;
			} else if ((root.left.val == root.right.val) && !isSymmetric(root.left) || !isSymmetric(root.right)) {
				return false;
			}
			
			return true;
		}

		/*
		 * .94. Binary Tree Inorder Traversal
		 * 
		 * Definition for a binary tree node.
		 * public class TreeNode {
		 *     int val;
		 *     TreeNode left;
		 *     TreeNode right;
		 *     TreeNode() {}
		 *     TreeNode(int val) { this.val = val; }
		 *     TreeNode(int val, TreeNode left, TreeNode right) {
		 *         this.val = val;
		 *         this.left = left;
		 *         this.right = right;
		 *     }
		 * }
		 */
		public List<Integer> inorderTraversal(TreeNode root) {
			List<Integer> curr = new ArrayList<Integer>();
			
			if (root.left != null) {
				curr.addAll(inorderTraversal(root.left));
			}
			curr.add(root.val);
			if (root.right != null) {
				curr.addAll(inorderTraversal(root.right));
			}
			
			return curr;
		}

		/*
		 * .70. Climbing Stairs
		 */
		public int climbStairs(int n) {
			if (n == 1) {
				return 1;
			}
			int cnt = 1;
			
			for (int i = 1; i<= n/2; i++) {
				int tmp1 = 1;
				int tmp2 = 1;
				for (int j = n-i; j > n-i*2; j--) {
					tmp1 = tmp2 * j;
				}
				for (int k = i; k > 0; k--) {
					tmp2 = tmp2 * k;
				}
				cnt += tmp1 / tmp2;
			}
			
			return cnt;
		}

		/*
		 * .53. Maximum Subarray
		 */
		public int maxSubArray(int[] nums) {
			int sumNum = nums[0];
			int curMax = nums[0];
			for (final int i : nums) {
				sumNum = Math.max(i, sumNum + i);
				curMax = Math.max(sumNum, curMax);
			}
			return curMax;
		}

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

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

}
