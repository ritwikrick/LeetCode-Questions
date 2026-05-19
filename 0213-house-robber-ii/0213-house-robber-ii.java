class Solution {
    // public int rob(int[] nums) {
    //     int n=nums.length;
    //     int includefirst=reccfirst(nums,n-2);
    //     int includelast=recclast(nums,n-1);
    //     return Math.max(includefirst, includelast);
    // }
    // public int reccfirst(int nums[], int n){
    //     //base case
    //     if(n<0) return 0;
    //     //work
    //     int pick=nums[n]+reccfirst(nums,n-2);
    //     int skip=reccfirst(nums,n-1);
    //     return Math.max(pick,skip);
    // }
    // public int recclast(int nums[], int n){//n=index
    //     //base case
    //     if(n<=0) return 0;
    //     //work
    //     int pick=nums[n]+recclast(nums,n-2);
    //     int skip=recclast(nums,n-1);
    //     return Math.max(pick,skip);
    // }

    //Memoization

    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        int includefirst=reccfirst(dp,nums,n-2);
        Arrays.fill(dp,-1);
        int includelast=recclast(dp,nums,n-1);
        return Math.max(includefirst, includelast);
    }
    public int reccfirst(int dp[], int nums[], int n){
        //base case
        if(n<0) return 0;

        if(dp[n]!=-1){
            return dp[n];
        }
        //work
        int pick=nums[n]+reccfirst(dp,nums,n-2);
        int skip=reccfirst(dp,nums,n-1);
        dp[n]= Math.max(pick,skip);
        return dp[n];
    }
    public int recclast(int dp[], int nums[], int n){//n=index
        //base case
        
        if(n<=0) return 0;

         if(dp[n]!=-1){
            return dp[n];
        }
        //work
        int pick=nums[n]+recclast(dp,nums,n-2);
        int skip=recclast(dp,nums,n-1);
        dp[n]=Math.max(pick,skip);
        return dp[n];
    }
}