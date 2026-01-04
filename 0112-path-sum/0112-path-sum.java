class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum = 0;
        return isFind(root, sum, targetSum);
    }

    public boolean isFind(TreeNode root, int sum, int targetSum) {
        if (root == null) return false;

        sum += root.val;

        // leaf node check
        // if (root.left == null && root.right == null) {
        //     return sum == targetSum;
        // }
        if(sum==targetSum && root.left==null &&root.right==null){
            return true;
        }

        return isFind(root.left, sum, targetSum)
            || isFind(root.right, sum, targetSum);
    }
}
