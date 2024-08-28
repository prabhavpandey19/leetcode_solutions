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
	 public ListNode rotateRight(ListNode head, int k) {
	        if(head==null||k==0) {
	        	return head;
	        }
		 	int n=1;
	        ListNode curr=head;
	        while(curr.next!=null) {
	        	n++;
	        	curr=curr.next;
	        }
         if(n==1||k%n==0) {
	        	return head;
	        }
	        ListNode tail=curr;
	        k=k%n;
	        curr=head;
	        while(k>0) {
	        	curr=curr.next;
	        	k--;
	        }
	        ListNode slow=head;
	        while(curr.next!=null) {
	        	curr=curr.next;
	        	slow=slow.next;
	        }
	        ListNode newHead=slow.next;
	        slow.next=null;
	        tail.next=head;
	        return newHead;
	        
	    }
}