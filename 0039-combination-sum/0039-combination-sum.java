class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> ds=new ArrayList<>();
        findCombinations(0,candidates,target,ds,ans);
        return ans; 
    }
    private void findCombinations(int idx, int []candidates,int target,List<Integer> ds ,List<List<Integer>> ans){
        if(idx==candidates.length){
            if(target==0){
                ans.add(new ArrayList<>(ds));
            }
        return;
        }
        if(candidates[idx]<=target){
            ds.add(candidates[idx]);
            findCombinations(idx,candidates,target-candidates[idx],ds,ans);
            ds.remove(ds.size()-1);
        }
        findCombinations(idx+1,candidates,target,ds,ans);
    }
}