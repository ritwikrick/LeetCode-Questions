/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;

        // connect left child to right child
        if (root.left != null) {
            root.left.next = root.right;
        }

        // connect right child to next subtree's left child
        if (root.right != null && root.next != null) {
            root.right.next = root.next.left;
        }

        // recurse on left and right
        connect(root.left);
        connect(root.right);

        return root;
    }
}