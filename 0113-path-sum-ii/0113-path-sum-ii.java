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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        int sum=0;
        find(list,ans,root,targetSum,sum);
        return list;
    }
    public void find(List<List<Integer>> list,List<Integer> ans,TreeNode root, int ts,int sum){
        if(root==null){
            return ;
        }
        sum+=root.val;
        ans.add(root.val);
        if(sum==ts && root.left==null && root.right==null){
            list.add(new ArrayList<>(ans));
        }
        find(list,ans,root.left,ts,sum) ;
        find(list,ans,root.right,ts,sum);
        ans.remove(ans.size() - 1);
    }
}