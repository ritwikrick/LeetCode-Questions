class Solution {
    // public int uniquePaths(int m, int n) {
    //     return recc(m-1,n-1);
    // }
    // public int recc(int m, int n){
    //     //base case
    //     if(m==0 && n==0){
    //         return 1;
    //     }
    //     if(m<0 || n<0){
    //         return 0;
    //     }
    //     //work=up+left
    //     int ways=recc(m-1,n)+recc(m,n-1);
    //     return ways;
    // }

    //MEMOIZATION
    public int uniquePaths(int m, int n) {
        int dp[][]=new int [m+1][n+1];
        for(int i=0;i<m+1;i++){
            Arrays.fill(dp[i],-1);
        }
        return recc(dp,m,n);
    }
    public int recc(int dp[][], int m, int n){
        //base case
        if(m==1 && n==1){
            dp[m][n]=1;
            return 1;
        }
        if(m==0 || n==0){
            dp[m][n]=0;
            return 0;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        //work=up+left
        dp[m][n]=recc(dp,m-1,n)+recc(dp,m,n-1);
        return dp[m][n];
    }
}