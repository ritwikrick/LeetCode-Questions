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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return null;
        ListNode curr=head;
        int size=0;
        while(curr!=null){
            size++;
            curr=curr.next;
        }
        if(size==n){
            return head.next;
        }
        int k=size-n;
        int i=1;
        curr=head;
        while(curr!=null){
            if(i==k){
                curr.next=curr.next.next;
            }
            curr=curr.next;
            i++;
        }
        return head;
    }
}