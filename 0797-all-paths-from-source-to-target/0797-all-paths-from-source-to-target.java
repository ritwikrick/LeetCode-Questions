class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        path.add(0);
        dfs(ans,path,graph,0);
        return ans;
    }
    public void dfs(List<List<Integer>> ans,List<Integer> path,int[][] graph, int curr ){
        int target=graph.length-1;
        if(curr==target){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<graph[curr].length;i++){
            int neibh=graph[curr][i];
            path.add(neibh);
            dfs(ans,path,graph,neibh);
            //backtrack
            path.remove(path.size()-1);
        }
    }
}