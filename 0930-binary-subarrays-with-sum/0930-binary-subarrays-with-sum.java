class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // int c=0;
        // for(int i=0;i<nums.length;i++){
        //     int sum=0;
        //     for(int j=i;j<nums.length;j++){
        //         sum+=nums[j];
        //         if(sum==goal){
        //             c++;
        //         }
        //     }
        // }
        // return c;
        // HashMap<Integer,Integer> map=new HashMap<>();
        // map.put(0,1);
        // int psum=0;
        // int c=0;
        // for(int i=0;i<nums.length;i++){
        //     psum+=nums[i];
        //     if(map.containsKey(psum-goal)){
        //         c=c+map.get(psum-goal);
        //     }
        //     map.put(psum,map.getOrDefault(psum,0)+1);
        // }
        // return c;
        return countt(nums,goal)- countt(nums,goal-1);
    }
    public int countt(int[] nums,int k){
        if(k<0) return 0;
        int left=0, count=0,sum=0;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            while(sum>k){
                sum-=nums[left];
                left++;
            }
            if(sum<=k){
                count+=right-left+1;
            }
        }
        return count;
    }
}