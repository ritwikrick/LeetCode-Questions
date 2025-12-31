class Solution {
    public int maxSubArray(int[] nums) {
        // int maxsum=Integer.MIN_VALUE;
        // for(int i=0;i<nums.length;i++){
        //     int sum=0;
        //     for(int j=i;j<nums.length;j++){
        //         sum=sum+nums[j];
        //         maxsum=Math.max(maxsum,sum);
        //     }
        // }
        // return maxsum;
        int maxsum=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            maxsum=Math.max(maxsum,sum);
            if(sum<0){
                sum=0;
            }
        }
        return maxsum;
    }
}