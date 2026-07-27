// class Solution {
//     public int minCostClimbingStairs(int[] cost) {
//         int n=cost.length;
//          return Math.min(
//                 recc(cost, n - 1),
//                 recc(cost, n - 2)
//         );//because we wanted to reach the top. suppose arr len is 3(0,1,2), we can reach top(at 3) by min(2 or 1)
//     }
//     public int recc(int[] cost, int n){//this only finds to reach the last index(2) with min cost
//         //initialization
//         if(n==0) return cost[0];
//         if(n==1) return cost[1];
//         if(n==-1) return 0;
//         //pick
//         int onestep=cost[n]+recc(cost,n-2);
//         int twostep=cost[n]+recc(cost,n-1);
//         return Math.min(onestep,twostep);

//     }
// }
//MEMOIZATION
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int dp[]=new int [n+1];
        Arrays.fill(dp,-1);
        return Math.min((recc(dp,cost,n-1)), (recc(dp,cost,n-2)));
    }
    public int recc(int dp[], int cost[], int n){
        //initialization
        if(n==0 || n==1) return cost[n];
        //check
        if(dp[n]!=-1) return dp[n];
        //one step
        int onestep=cost[n]+recc(dp,cost,n-1);
        int twostep=cost[n]+recc(dp,cost,n-2);
        dp[n]= Math.min(onestep, twostep);
        return dp[n];

    }
}