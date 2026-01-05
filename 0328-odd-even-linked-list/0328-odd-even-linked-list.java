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
    public ListNode oddEvenList(ListNode head) {
        ListNode ans=new ListNode(0);
        ListNode odd=ans;
        ListNode evenhead=new ListNode(0);
        ListNode even=evenhead;
        

        int c=1;
        ListNode curr=head;
        while(curr!=null){
            if(c%2!=0){
                odd.next=curr;
                odd=odd.next;
            }else{
                even.next=curr;
                even=even.next;
            }
            curr=curr.next;
            c++;
        }
        odd.next=evenhead.next;
        even.next=null;
        return ans.next;
    }
}