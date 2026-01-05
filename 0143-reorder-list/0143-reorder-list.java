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
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode prev=null;
        ListNode curr=slow.next;
        ListNode nextt;
        while(curr!=null){
            nextt=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextt;
        } 
        ListNode rhead=prev;
        slow.next=null;
        reorder(head,rhead);
    }
    public void reorder(ListNode l, ListNode r){
        ListNode temp=new ListNode(-1);
        while(l!=null && r!=null){
            ListNode lnext=l.next;
            ListNode rnext=r.next;
            l.next=r;
            r.next=lnext;;
            l=lnext;
            r=rnext;
        }
        
    }
}