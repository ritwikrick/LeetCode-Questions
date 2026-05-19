class Solution {
    // public int rob(int[] nums) {
    //     int n=nums.length;
    //     return recc(nums,n-1);
    // }
    // public int recc(int nums[], int idx){
    //     if(idx==0){
    //         return nums[0];
    //     }
    //     if(idx==-1){
    //         return 0;
    //     }
    //     int pick= nums[idx]+ recc(nums,idx-2);
    //     int nopick=recc(nums,idx-1);
    //     int ans= Math.max(pick, nopick);
    //     return ans;
    // }

    // public int rob(int[] nums) {
    //     int n=nums.length;
    //     int dp[]=new int[n+1];
    //     Arrays.fill(dp,-1);
    //     return recc(dp,nums,n-1);
    // }
    // public int recc(int dp[], int nums[], int idx){
    //     if(idx==0){
    //         return nums[0];
    //     }
    //     if(idx==-1){
    //         return 0;
    //     }
    //     if(dp[idx]!=-1){
    //         return dp[idx];
    //     }
    //     int pick= nums[idx]+ recc(dp,nums,idx-2);
    //     int nopick=recc(dp,nums,idx-1);
    //     dp[idx]= Math.max(pick, nopick);
    //     return dp[idx];
    // }
    //recursion
    // public int rob(int[] nums) {
    //     int n=nums.length;
    //     return recc(nums, n-1);
    // }
    // public int recc(int nums[], int n){
    //     //base case
    //     if(n<0){
    //         return 0;
    //     }

    //     //pick
    //     int pick=nums[n]+recc(nums,n-2);
    //     int skip=recc(nums,n-1);
    //     return Math.max(pick,skip);
    // }

    //memoization
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return recc(dp,nums, n-1);
    }
    public int recc(int dp[],int nums[], int n){
        //base case
        if(n<0){
            return 0;
        }
        //Storing values in dp array
        if(dp[n]!=-1){
            return dp[n];
        }

        //pick
        int pick=nums[n]+recc(dp,nums,n-2);
        int skip=recc(dp,nums,n-1);
        dp[n]= Math.max(pick,skip);
        return dp[n];
    }
}