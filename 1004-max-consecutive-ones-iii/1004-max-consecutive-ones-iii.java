class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans=0;
        // for(int i=0;i<nums.length;i++){
        //     for(int j=i;j<nums.length;j++){
        //         int fone=0;
        //         for(int p=i;p<=j;p++){
        //              if(nums[p]==1){
        //                 fone++;
        //             }
        //         }
        //         int len=j-i+1;
        //         int change=len-fone;
        //         if(change<=k){
        //             ans=Math.max(ans,len);
        //         }

        //     }
        // }
        int left=0;
        int one=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]==1){
                one++;
            }
            int len=right-left+1;
            if(len-one>k){
                if(nums[left]==1){
                    one--;
                }
                left++;
            }
            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
}