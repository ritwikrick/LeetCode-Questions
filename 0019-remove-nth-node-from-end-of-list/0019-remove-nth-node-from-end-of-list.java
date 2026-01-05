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
        
        int len=1;
        ListNode curr=head;
        while(curr.next!=null){
            len++;
            curr=curr.next;
        }
        if(len==n) return head.next;

        curr=head;
        int l=1;
        while(l<(len-n)){
            l++;
            curr=curr.next;
        }
        curr.next=curr.next.next;

        return head;
    }
}