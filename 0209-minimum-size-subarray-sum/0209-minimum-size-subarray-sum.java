class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minlen=Integer.MAX_VALUE;
        int l=0;
        int sum=0;
        for(int r=0;r<nums.length;r++){
            sum+=nums[r];
            while(sum>=target){
                minlen=Math.min(minlen,r-l+1);
                sum=sum-nums[l];
                l++;
            }
        }
        if(minlen==Integer.MAX_VALUE) return 0;
        return minlen;
    }
}