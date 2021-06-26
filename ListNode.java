package donaldAlgorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    
    
    class Solution {
//206. Reverse Linked List *
        public ListNode reverseList(ListNode head) {
            Stack<Integer> s = new Stack<>();
            
            ListNode ans = new ListNode(0);
            ListNode curr = ans;
            
            while(head != null) {
                s.push(head.val);
                head = head.next;
            }
            
            int l = s.size();
            for(int  i = 0 ; i < l ; i++){
                ans.next = new ListNode(s.pop());
                ans = ans.next;
            }
            
            return curr.next;
        }
        
//21. Merge Two Sorted Lists *
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode ans = new ListNode(0);
            ListNode curr = ans;
            
            Queue<Integer> q1 = new LinkedList<>();
            Queue<Integer> q2 = new LinkedList<>();
            
            while(l1 != null) {
                q1.offer(l1.val);
                l1 = l1.next;
            }
            
            while(l2 != null) {
                q2.offer(l2.val);
                l2 = l2.next;
            }
            
            while(q1.peek() != null && q2.peek() != null) {
                if(q1.peek() >= q2.peek()) {
                    ans.next = new ListNode(q2.poll());
                }else {
                    ans.next = new ListNode(q1.poll());
                }
                ans = ans.next;
            }
            
            if(q1.peek() == null) {
                while(q2.peek() != null) {
                    ans.next = new ListNode(q2.poll());
                    ans = ans.next;
                }
            }else {
                while(q1.peek() != null) {
                    ans.next = new ListNode(q1.poll());
                    ans = ans.next;
                }
            }
            return curr.next;
        }
    }
    
//83. Remove Duplicates from Sorted List *
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode p = head;
        ListNode q = head.next;
        
        while (q != null) {
            if (p.val == q.val) {
                p.next = q.next;
                q = p.next;
            }
            else {
                p = p.next;
                q = q.next;
            }
        }
        return head;
    }

//876. Middle of the Linked List *
    public ListNode middleNode(ListNode head) {
        if(head.next==null) return head;
        
        int count=0;
        ListNode temp=head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
       // System.out.println(count);
        
        int mid=count/2;
        int i=0;
        while(i<mid){
            head=head.next;
            i++;
        }
        
        return head;
    }
    
    public static void main(String[] args) {
    	ListNode l1 = new ListNode();
    	ListNode l2 = new ListNode();
    }
}