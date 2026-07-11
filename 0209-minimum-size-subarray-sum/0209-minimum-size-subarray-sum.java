class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum=0;
        int minl=Integer.MAX_VALUE;
        int left=0;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            while(sum>=target){
                minl=Math.min(minl,right-left+1);
                sum=sum-nums[left];
                left++;
            }
        }
        if( minl==Integer.MAX_VALUE) return 0;
        return minl;
    }
}