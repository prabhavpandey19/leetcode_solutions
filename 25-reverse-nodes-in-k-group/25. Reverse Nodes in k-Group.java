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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode x = new ListNode();
        x.next = head;
        ListNode curr = head;
        ListNode prev = head;
        int count = k;
        while(count>1 && curr != null) {
            curr = curr.next;
            count--;
        }
        if (curr == null) {
            return x.next;
        }
        
        ListNode rightGroup = curr.next;
        curr.next = null;
        prev = reverseList(prev);
        rightGroup = reverseKGroup(rightGroup,k);
        x.next.next = rightGroup;
        return prev;


    }
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

}