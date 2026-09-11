class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSame(p, q);
    }
    
    public boolean isSame(TreeNode p, TreeNode q) {
        // Case 1: both nodes are null -> trees match at this position
        if (p == null && q == null) {
            return true;
        }
        
        // Case 2: exactly one node is null -> structure mismatch
        if (p == null) {
            return false;
        }
        if (q == null) {
            return false;
        }
        
        // Case 3: both nodes exist, but values differ -> mismatch
        if (p.val != q.val) {
            return false;
        }
        
        // Case 4: values match, now check left and right subtrees separately
        boolean leftSame = isSame(p.left, q.left);
        boolean rightSame = isSame(p.right, q.right);
        
        if (leftSame == true) {
            if (rightSame == true) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}