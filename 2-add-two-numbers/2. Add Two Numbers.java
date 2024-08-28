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
   public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode curr = head;
        int car = 0;
        while (l1 != null && l2 != null) {
            int val = l2.val + l1.val + car;
            car = val / 10;
            curr.next = new ListNode(val % 10);
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
            // printListNodeValues(head);
            // System.out.println();
        }
        
        while (l1 != null) {
            int val = l1.val + car;
            car = val / 10;
            curr.next = new ListNode(val % 10);
            curr = curr.next;
            l1 = l1.next;
            // printListNodeValues(head);
            // System.out.println();
        }

        while (l2 != null) {
            int val = l2.val + car;
            car = val / 10;
            curr.next = new ListNode(val % 10);
            curr = curr.next;
            l2 = l2.next;
            // printListNodeValues(head);
            // System.out.println();
        }
        if (car != 0) {
            curr.next = new ListNode(car);
        }
        return head.next;
    }

    public static void printListNodeValues(ListNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        printListNodeValues(node.next);
    }
}