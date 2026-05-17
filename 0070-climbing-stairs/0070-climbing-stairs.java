class Solution {
    // public int climbStairs(int n) {
    //     //fibonacci variant- using recursion
    //     // if(n==0 || n==1) return 1;
    //     // return climbStairs(n-1) + climbStairs(n-2);
    //     //////////////////////////////////////////////////////////////

    //     //Memoization
    //      tc- O(n)
            //sc- O(n)+O(n)[array+ recursion stack]
    //     int dp[]=new int[n+1];
    //     Arrays.fill(dp,-1);
    //     return solve(dp,n);
    // }
    // public int solve(int dp[], int n){
    //     if(n<=2) return n;
    //     if(dp[n]!=-1){
    //         return dp[n];
    //     }
    //     dp[n]=solve(dp,n-1)+solve(dp,n-2);
    //     return dp[n];

    // }

    //-------------------------------------
    // //TABULATION
    // public int climbStairs(int n) {
    //     //TC- O(N)
    //     //SC-O(N)[ARRAY]
    //     if(n<=2) return n;
    //    int dp[]=new int[n+1];
    //    dp[1]=1;
    //    dp[2]=2;
    //    for(int i=3;i<=n;i++){
    //         dp[i]=dp[i-1]+dp[i-2];
    //    }
    //    return dp[n];
    // }

    //TABULATION
    public int climbStairs(int n) {
        //TC- O(N)
        //SC-O(1)
        if(n<=2) return n;
        int prev1=2;
        int prev2=1;
        int ans=0;
       for(int i=3;i<=n;i++){
            ans=prev1+prev2;
            prev2=prev1;
            prev1=ans;
       }
       return ans;
    }
    
}