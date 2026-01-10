class Solution {
    static class pair{
        int dist;
        int row;
        int col;
        pair(int dist,int row,int col){
            this.dist=dist;
            this.row=row;
            this.col=col;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        PriorityQueue<pair>pq=new PriorityQueue<pair>((a,b)->a.dist-b.dist);
        int arr[][]=new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.MAX_VALUE;
            }
        }
        arr[0][0]=0;
        pq.add(new pair(0,0,0));
        int dr[]={-1,0,+1,0};
        int dc[]={0,+1,0,-1};
        while(!pq.isEmpty()){
            pair curr=pq.remove();
            int diff=curr.dist;
            int nr=curr.row;
            int nc=curr.col;

            if(nr==m-1 && nc==n-1) return diff;
            for(int i=0;i<4;i++){
                int newr=nr+dr[i];
                int newc=nc+dc[i];
                if(newr>=0 && newc>=0 && newr<m && newc<n){
                    int effort=Math.max(Math.abs(heights[nr][nc]- heights[newr][newc]),diff);
                    if(effort<arr[newr][newc]){
                        arr[newr][newc]=effort;
                        pq.add(new pair(effort,newr,newc));
                    }
                }
            }
        }
    return 0;

    }
}