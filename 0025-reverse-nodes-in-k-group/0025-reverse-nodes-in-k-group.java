class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prev = null;   // ✅ Now used correctly as previous group tail

        while (temp != null) {

            ListNode kthnode = findKth(temp, k);

            // ✅ Important null check to avoid crash
            if (kthnode == null) {
                if (prev != null) {
                    prev.next = temp;
                }
                break;
            }

            ListNode next = kthnode.next;
            kthnode.next = null;

            // ✅ Store reversed head properly
            ListNode newHead = reversell(temp);

            if (temp == head) {
                head = newHead;
            } else {
                prev.next = newHead;
            }

            // ✅ Move prev and temp correctly
            prev = temp;
            temp = next;
        }

        return head;
    }

    public ListNode reversell(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    } 

    public ListNode findKth(ListNode head, int k) {
        int c = 1;
        while (head != null) {
            if (c == k) return head;
            head = head.next;
            c++;
        }
        return null;
    }
}
