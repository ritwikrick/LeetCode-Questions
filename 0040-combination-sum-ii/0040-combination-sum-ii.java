class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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
        csum(ans,list,nums,target-nums[i],i+1,n);

        //skip duplicate
        int next = i + 1;
        while (next < nums.length && nums[next] == nums[i]) {
            next++;
        }

        //skip
        list.remove(list.size()-1);
        csum(ans,list,nums,target,next,n);
    }
}















// class Solution {
//     public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//         Arrays.sort(candidates);
//         List<List<Integer>> ans=new ArrayList<>();
//         List<Integer> list=new ArrayList<>();
//         HashSet<ArrayList<Integer>> set=new HashSet<>();
//         csum(list,set,candidates,target,0,candidates.length);
//         return new ArrayList<>(set);
//     }
//     public void csum(List<Integer> list,HashSet<ArrayList<Integer>> set,int nums[],int target,int i,int n){
//         if(target==0){
//             set.add(new ArrayList<>(list));
//         }
//         if(target<0 || i==n){
//             return;
//         }
//         //add
//         list.add(nums[i]);
//         csum(list,set,nums,target-nums[i],i+1,n);
//         //skip
//         list.remove(list.size()-1);
//         csum(list,set,nums,target,i+1,n);
//     }
// }
