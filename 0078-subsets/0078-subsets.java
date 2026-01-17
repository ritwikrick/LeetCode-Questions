class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        ArrayList<Integer>list=new ArrayList<>();
        subset(ans,list,0,nums.length,nums);
        return ans;
    }
    public void subset(List<List<Integer>> ans, ArrayList<Integer> list,int i,int n, int nums[]){

        if(i==n){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        subset(ans,list,i+1,n,nums);
        list.remove(list.size()-1);
        subset(ans,list,i+1,n,nums);
    }
}