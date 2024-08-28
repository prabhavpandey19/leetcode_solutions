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
         public ListNode partition(ListNode head, int x) {
        ListNode d1=new ListNode();
        ListNode d1h=d1;
        ListNode d2=new ListNode();
        ListNode d2h=d2;
        ListNode curr=head;
        while(curr!=null) {
        	ListNode temp=curr;
        	curr=curr.next;
        	if(temp.val<x) {
        		d1.next=temp;
        		d1=d1.next;
        		d1.next=null;
        	}else {
        		d2.next=temp;
        		d2=d2.next;
        		d2.next=null;
        	}
        	
        }
        d1.next=d2h.next;
        return d1h.next;
    }
}