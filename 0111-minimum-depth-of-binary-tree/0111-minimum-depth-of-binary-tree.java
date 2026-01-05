class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // If left child is null, go right
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }

        // If right child is null, go left
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        // If both children exist, take minimum
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
