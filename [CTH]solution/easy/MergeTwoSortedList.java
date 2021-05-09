/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode t1 = l1.next;
        ListNode t2 = l2.next;
        ListNode newhead = null;
        if (l1.val < l2.val){
            newhead = l1;
            newhead.next = mergeTwoLists(t1, l2);
        } else {
            newhead = l2;
            newhead.next = mergeTwoLists(l1, t2);
        }
        return newhead;
    }
}