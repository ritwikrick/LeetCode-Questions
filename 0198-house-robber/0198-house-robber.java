class Solution {
    public int rob(int[] nums) {
        int dp[]=new int[nums.length+1];
        Arrays.fill(dp, -1);
        return solve(dp,0,nums);
    }
    public int solve(int dp[], int n, int nums[]){
        if(n>=nums.length){
            return 0;
        }
        
        if(dp[n]!=-1){
            return dp[n];
        }
        //pick
        int val1=nums[n]+solve(dp,n+2,nums);
        //not pick
        int val2= solve(dp,n+1,nums);
        dp[n]= Math.max(val1,val2);
        return dp[n];

    }
}