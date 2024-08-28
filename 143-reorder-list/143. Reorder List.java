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
    public void reorderList(ListNode head) {
        ListNode reverse = head;
        ListNode slow = head;
        while (reverse != null && reverse.next != null) {
            slow = slow.next;
            reverse = reverse.next.next;
        }
        reverse = reverseList(slow.next);
        slow.next = null;
        slow = head;
        while (reverse != null) {
            ListNode t1 = slow.next;
            ListNode t2 = reverse.next;
            slow.next = reverse; 
            reverse.next = t1;
            slow = t1;
            reverse = t2;
        }
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