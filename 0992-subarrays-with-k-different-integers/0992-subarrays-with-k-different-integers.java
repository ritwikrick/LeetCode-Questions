class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return exact(nums,k)-exact(nums,k-1);
    }
    public int exact(int nums[],int k){
        // HashMap<Integer,Integer> map=new HashMap<>();
        // int left=0;
        // int count=0;
        // for(int right=0;right<nums.length;right++){
        //     map.put(nums[right],map.getOrDefault(nums[right],0)+1);
        //     while(map.size()>k){
        //         map.put(nums[left],map.get(nums[left])-1);
        //         if(map.get(nums[left])==0) map.remove(nums[left]);
        //         left++;
        //     }
        //     if(map.size()<=k) count+=right-left+1;
        // }
        // return count;
        HashMap<Integer,Integer> map=new HashMap<>();
        int l=0;
        int c=0;
        for(int r=0;r<nums.length;r++){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(map.size()>k){
                map.put(nums[l],map.get(nums[l])-1);
                if(map.get(nums[l])==0){
                    map.remove(nums[l]);
                }
                l++;
            }
            if(map.size()<=k){
                c+=r-l+1;
            }
        }
        return c;
    }
}