class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean vis[][]=new boolean[n][m];
        int c=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    c++;
                    dfs(i,j,grid,vis);
                }
            }
        }
        return c;
    }
    public void dfs(int r,int c,char[][] grid,boolean vis[][]){
        vis[r][c]=true;
        int n=grid.length;
        int m=grid[0].length;
        int delRow[]={-1,0,+1,0};
        int delCol[]={0,+1,0,-1};
        for(int i=0;i<4;i++){
            int nr=r+delRow[i];
            int nc=c+delCol[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]=='1' && !vis[nr][nc]){
                dfs(nr,nc,grid,vis);
            }
        }


    }
}