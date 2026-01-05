class Solution {
    public int majorityElement(int[] nums) {
        // int ans=0;
        // for(int i=0;i<nums.length;i++){
        //     int c=0;
        //     for(int j=0;j<nums.length;j++){
        //         if(nums[i]==nums[j]){
        //             c++;
        //         }
        //     }
        //      if(c>nums.length/2){
        //             ans=nums[i];
        //         }
        // }
        // return ans;
        int candidate=nums[0];
        int count=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==candidate){
                count++;
            }else{
                count--;
                if(count==0){
                    candidate=nums[i];
                    count=1;
                }
            }
        }
        return candidate;
    }
}