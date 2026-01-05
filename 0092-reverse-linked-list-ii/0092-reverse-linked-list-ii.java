class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 1️⃣ Move prev to node before 'left'
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // 2️⃣ Start reversing
        ListNode curr = prev.next;
        ListNode prevNode = null;

        for (int i = left; i <= right; i++) {
            ListNode nextNode = curr.next;
            curr.next = prevNode;
            prevNode = curr;
            curr = nextNode;
        }
        //prevNode is the head now
    

        // 3️⃣ Reconnect the reversed part
        prev.next.next=curr;// tail of reversed part → remaining list
        prev.next=prevNode;   // node before left → new head of reversed part

        return dummy.next;
    }
}
