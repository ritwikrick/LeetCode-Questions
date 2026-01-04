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
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;

        int level=1;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        int sum=0;
        int anslevel=1;
        int maxsum=Integer.MIN_VALUE;
        while(!q.isEmpty()){
            TreeNode curr=q.remove();
            if(curr==null){
                if(maxsum<sum){
                    maxsum=sum;
                    anslevel=level;
                }
                if(q.isEmpty()){
                    break;
                }
                q.add(null);
                level++;
                sum=0; 
            }else{
                sum+=curr.val;
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
        }
        return anslevel;
    }
}