class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>() ;
        List<Integer> list=new ArrayList<>();
        HashSet<ArrayList<Integer>> set=new HashSet<>();
        subset(ans,list,set,nums,0,nums.length);
        return new ArrayList<>(set); 
    }
    public void subset(List<List<Integer>> ans,List<Integer> list,HashSet<ArrayList<Integer>> set, int nums[],int i,int n){
        if(i==n){
            set.add(new ArrayList<>(list));
            return;
        }
        //add
        list.add(nums[i]);
        subset(ans,list,set,nums,i+1,n);
        //skip
        list.remove(list.size()-1);
        subset(ans,list,set,nums,i+1,n);
    }
}