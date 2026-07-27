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

    public int rob(int[] nums) {
        int n=nums.length;
        int dp[]= new int[n+1];
        Arrays.fill(dp,-1);
        return recc(dp,nums,n-1);
    }
    public int recc(int dp[], int nums[], int n){
        //initialization same as recusrion
       if(n==0) return nums[0];
       if(n<0) return 0;
       //check
       if(dp[n]!=-1){
            return dp[n];
       }
       //pick
       int pick=nums[n]+recc(dp,nums,n-2);
       int notpick=recc(dp,nums,n-1);
       dp[n]=Math.max(pick,notpick);
       return dp[n];

    }
}
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
    // public int rob(int[] nums) {
    //     int n=nums.length;
    //     int dp[]=new int[n];
    //     Arrays.fill(dp,-1);
    //     return recc(dp,nums, n-1);
    // }
    // public int recc(int dp[],int nums[], int n){
    //     //base case
    //     if(n<0){
    //         return 0;
    //     }
    //     //Storing values in dp array
    //     if(dp[n]!=-1){
    //         return dp[n];
    //     }

    //     //pick
    //     int pick=nums[n]+recc(dp,nums,n-2);
    //     int skip=recc(dp,nums,n-1);
    //     dp[n]= Math.max(pick,skip);
    //     return dp[n];
    // }

    //Tabulation
//     public int rob(int[] nums) {
//         int n=nums.length;
//         int dp[]=new int[n];
//         //initialize
//         dp[0]=nums[0];
//         dp[1]=Math.max(nums[0], nums[1]);
//         for(int i=2;i<n;i++){
//             int pick=nums[i]+dp[i-2];
//             int skip=dp[i-1];
//             dp[i]= Math.max(pick,skip);
//         }
//         return dp[n-1];
//     }
// }