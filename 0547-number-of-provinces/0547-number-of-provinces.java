class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean []vis=new boolean[isConnected.length];
        int c=0;
        int n=isConnected.length;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                c++;
                dfs(i,isConnected,vis);
            }
        }
        return c;

    }
    public void dfs(int curr,int[][] graph,boolean vis[]){
        vis[curr]=true;
        for (int j = 0; j < graph.length; j++) {
            if (graph[curr][j] == 1 && !vis[j]) { // connected & not visited
                dfs(j, graph, vis);
            }
        }
    }
}