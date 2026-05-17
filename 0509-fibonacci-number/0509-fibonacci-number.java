class Solution {
    // public int fib(int n) {
    //     //TC= 2^n; since at every step we have 2 states
    //     if(n==0 || n==1){
    //         return n;
    //     }
    //     return fib(n-1)+ fib(n-2);
    // }
    ////////////////////////////////////////////////////////////////////////////////
    //MEMOIZATION- O(N), but it used extra space, one is recursion stack, and array.
    // public int fib(int n) {
    //     int dp[]=new int[n+1];
    //     Arrays.fill(dp,-1);
    //     return rec(n, dp);
    // }
    // public int rec(int n, int dp[]) {
        
    //     if(n==0 || n==1){
    //         return n;
    //     }
    //     if(dp[n]!=-1){
    //         return dp[n];
    //     }
    //     dp[n]=fib(n-1)+ fib(n-2);
    //     return dp[n];
    // }

    ///////////////////////////////////////////////
    //TABULATION- BOTTOM->UP APPROACH
    //TC- O(N)
    //SC- O(N)
    // public int fib(int n) {
    //     if(n==0 || n==1) return n;
    //     int dp[]=new int[n+1];
    //     dp[0]=0;
    //     dp[1]=1;
    //     for(int i=2;i<=n;i++){
    //         dp[i]=dp[i-1]+dp[i-2];
    //     }
    //     return dp[n];
    // }
    ///////////////////////////////////////////
    //TABULATION- BOTTOM->UP APPROACH
    //TC- O(N)
    //SC- O(1)
    public int fib(int n) {
        if(n==0 || n==1) return n;
        int prev1=1;
        int prev2=0;
        int ans=0;
        for(int i=2;i<=n;i++){
            ans=prev1+prev2;
            prev2=prev1;
            prev1=ans;

        }
        return ans;
    }

}