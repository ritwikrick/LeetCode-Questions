/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node curr=head;
        while(curr!=null){
            if(curr.child==null){
                curr=curr.next;
                continue;
            }
            Node nextt=curr.next;
            curr.next=flatten(curr.child);
            curr.next.prev=curr;//for reverse connection->
            curr.child=null;

            while(curr.next!=null){//to join last child pointer to nextt
                curr=curr.next;
            }
            if(nextt!=null){
                curr.next=nextt;
                nextt.prev=curr;
            }
        }
        return head;
       
    }
}