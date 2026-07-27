// class Solution {
//     public int climbStairs(int n) {
//         return recc(n); 
//     }
//     public int recc(int n){
//         if(n==0 || n==1){
//             return 1;
//         }
//         if(n<0){
//             return 0;
//         }
//         return recc(n-1)+recc(n-2);
//     }
// }

class Solution {
    public int climbStairs(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return recc(n,dp);
    }
    public int recc(int n, int dp[]){
        //Step 1: Initialization
        if(n==0){
            //we have 1 way- ie.to not move
            return 1;
        }
        if(n<0){
            //we cant go under land
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n]=recc(n-1,dp)+ recc(n-2,dp);
        return dp[n];

    }
}