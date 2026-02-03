class Solution {
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        boolean vis[][]=new boolean[n][m];
        //1st col and last col
        for(int i=0;i<n;i++){
            if(board[i][0]=='O') dfs(i,0,vis,board);
            if(board[i][m-1] =='O') dfs(i,m-1,vis,board);
        }
        //top row, last row
        for(int i=0;i<m;i++){
            if(board[0][i]=='O') dfs(0,i,vis,board);
            if(board[n-1][i]=='O') dfs(n-1,i,vis,board);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O') board[i][j]='X';
                if(board[i][j]=='#') board[i][j]='O';
            }
        }
    }
    public void dfs(int r, int c, boolean vis[][], char board[][]){
        vis[r][c]=true;
        board[r][c]='#';
        int n=board.length;
        int m=board[0].length;
        int delrow[]={-1,0,+1,0};
        int delcol[]={0,+1,0,-1};
        for(int i=0;i<4;i++){
            int nr=r+delrow[i];
            int nc=c+delcol[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m && !vis[nr][nc] && board[nr][nc]=='O'){
                
                dfs(nr,nc,vis,board);
            }
        }
    }
}