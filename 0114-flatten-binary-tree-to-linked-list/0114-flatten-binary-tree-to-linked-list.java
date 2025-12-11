/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private TreeNode nextRight = null;
    public void flatten(TreeNode root) {
        if (root == null) return;

        // Step 1: Flatten right subtree
        flatten(root.right);

        // Step 2: Flatten left subtree
        flatten(root.left);

        // Step 3: Attach flattened pieces
        root.left = null;
        root.right = nextRight;

        // Step 4: Move nextRight forward
        nextRight = root;
    }
}