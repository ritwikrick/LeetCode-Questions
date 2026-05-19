class Solution {
    // public int uniquePathsWithObstacles(int[][] obstacleGrid) {

    //     int m=obstacleGrid.length;
    //     int n=obstacleGrid[0].length;
    //     if(m==1 && n==1 && obstacleGrid[0][0]==1){
    //         return 0;
    //     }
    //     if(m==1 && n==1 && obstacleGrid[0][0]==0){
    //         return 1;
    //     }
    //     return recc(obstacleGrid,m-1,n-1);
    // }
    // public int recc(int arr[][],int m, int n){
    //     int ways=0;
    //     //base case
    //     if(m==0 && n==0){
    //         return arr[m][n] == 1 ? 0 : 1;
    //     }
    //     if(m<0 || n<0){
    //         return 0;
    //     }
    //     if(arr[m][n]!=1){
    //          ways=recc(arr,m-1,n)+recc(arr, m, n-1);
    //     }
    //     return ways;
    // }

    //MEMOIZATION
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        if(m==1 && n==1 && obstacleGrid[0][0]==1){
            return 0;
        }
        if(m==1 && n==1 && obstacleGrid[0][0]==0){
            return 1;
        }

        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return recc(dp,obstacleGrid,m-1,n-1);
    }
    public int recc(int dp[][], int arr[][],int m, int n){
        int ways=0;
        //base case
        if(m==0 && n==0){
            return arr[m][n] == 1 ? 0 : 1;
        }
        if(m<0 || n<0){
            return 0;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        if(arr[m][n]!=1){
             ways=recc(dp,arr,m-1,n)+recc(dp,arr, m, n-1);
             
        }
        dp[m][n]=ways;
        return dp[m][n];
    }
}