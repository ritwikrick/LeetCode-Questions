class Solution {
    // public int minCostClimbingStairs(int[] cost) {
    //     int n=cost.length;
    //     return recc(cost, n);
    // }
    // public int recc(int cost[], int n){
    //     if(n<=1) return 0;
    //     int prev1= cost[n-1]+ recc(cost,n-1);
    //     int prev2= cost[n-2]+ recc(cost,n-2);
    //     int ans=Math.min(prev1, prev2);
    //     return ans;
    // }

    // public int minCostClimbingStairs(int[] cost) {
    //     int n=cost.length;
    //     int dp[]=new int[n+1];
    //     Arrays.fill(dp,-1);
    //     return recc(dp,cost, n);
    // }
    // public int recc(int dp[], int cost[], int n){
    //     if(n<=1) return 0;

    //     if(dp[n]!=-1){
    //         return dp[n];
    //     }
    //     int prev1= cost[n-1]+ recc(dp,cost,n-1);
    //     int prev2= cost[n-2]+ recc(dp,cost,n-2);
    //     dp[n]=Math.min(prev1, prev2);
    //     return dp[n];
    // }

    //-------------------------
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        if(n<=1) return 0;
        int dp[]=new int [n+1];
        dp[0]=0;
        dp[1]=0;
        for(int i=2;i<=cost.length;i++){
            int one=cost[i-1]+ dp[i-1];
            int two= cost[i-2]+ dp[i-2];
            dp[i]=Math.min(one,two);
        }
        return dp[n];
    }
}