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
    private HashMap<Integer,Integer> map;
    private int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        idx=postorder.length-1;
        return build(postorder,0,postorder.length-1);
    }
    private TreeNode build(int postorder[],int left,int right){
        if(left>right) return null;
        int rootval=postorder[idx];
        idx--;
        TreeNode root=new TreeNode(rootval);
        int mid=map.get(rootval);
        root.right=build(postorder,mid+1,right);
        root.left=build(postorder,left,mid-1);
        return root;
    }
}