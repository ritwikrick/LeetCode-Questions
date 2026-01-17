class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        csum(ans,list,candidates,target,0,candidates.length);
        return ans;
    }
    public void csum(List<List<Integer>> ans,List<Integer> list,int nums[],int target,int i,int n){

        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if (target < 0 || i == nums.length) {
            return;
        }
        //add
        list.add(nums[i]);
        csum(ans,list,nums,target-nums[i],i,n);

        //skip
        list.remove(list.size()-1);
        csum(ans,list,nums,target,i+1,n);
    }
}