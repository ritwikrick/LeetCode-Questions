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
    public int minDiffInBST(TreeNode root) {
        int min=Integer.MAX_VALUE;
        if(root==null){
            return 0;
        }
        ArrayList<Integer> ll=new ArrayList<>();
        inorder(ll,root);
        for(int i=1;i<ll.size();i++){
            int dif=(ll.get(i)-ll.get(i-1));
            if(dif<min){
                 min=dif;
            } 
        }
        return min;


    }
    public static void inorder(ArrayList<Integer> ll,TreeNode root){
        if(root==null) return;
        inorder(ll,root.left);
        ll.add(root.val);
        inorder(ll,root.right);
    }
}