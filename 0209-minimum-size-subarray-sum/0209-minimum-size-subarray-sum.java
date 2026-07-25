class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res=Integer.MAX_VALUE;;
        int left=0;
        int sum=0;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            while(sum>=target){
                res=Math.min(res,right-left+1);
                sum=sum-nums[left];
                left++;
            }
        }
        if(res==Integer.MAX_VALUE) res=0;
        return res;
    }
}