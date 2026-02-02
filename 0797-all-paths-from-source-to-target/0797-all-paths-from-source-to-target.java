class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        path.add(0);
        dfs(ans,path,0,graph);
        return ans;
    }
    public void dfs(List<List<Integer>> ans,List<Integer> path, int node, int[][] graph){
        int target=graph.length-1;
        //node=index
        if(node==target){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<graph[node].length;i++){
            int neibh=graph[node][i];
            path.add(neibh);
            dfs(ans,path,neibh,graph);
            path.remove(path.size()-1);
        }
    }
}