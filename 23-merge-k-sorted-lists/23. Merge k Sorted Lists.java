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
   public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length <= 0) {
            return null;
        }
        return merge(lists,0,lists.length-1);
    }

    private ListNode merge(ListNode[] lists, int s, int e) {
        if (s==e) {
            return lists[s];
        }
        int mid = s + (e-s) / 2;
        ListNode left = merge(lists,s,mid);
        ListNode right = merge(lists,mid+1,e);
        return mergeTwoLists(left,right);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list2 == null) {
            return list1;
        }
        if (list1 == null) {
            return list2;
        }
        ListNode head = new ListNode();
        ListNode curr = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if (list1 != null) {
            curr.next = list1;
        } else if (list2 != null){
            curr.next = list2;
        }
        return head.next;
    }


}