class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];

        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                if (!dfs(graph, i, color, 1))
                    return false;
            }
        }
        return true;
    }

    public boolean dfs(int[][] graph, int node, int[] color, int c) {
        color[node] = c;

        for (int i = 0; i < graph[node].length; i++) {
            int nei = graph[node][i];

            if (color[nei] == 0) {
                if (!dfs(graph, nei, color, -c))
                    return false;
            } 
            else if (color[nei] == c) {
                return false;
            }
        }

        return true;
    }
}
