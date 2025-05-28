import java.util.*;

class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        List<Integer>[] graph1 = buildGraph(edges1, n);
        List<Integer>[] graph2 = buildGraph(edges2, m);

        // Compute maximum reachable nodes in graph2 within k - 1 steps
        int maxReachableInGraph2 = 0;
        if (k > 0) {
            for (int i = 0; i < m; ++i) {
                maxReachableInGraph2 = Math.max(maxReachableInGraph2, dfs(graph2, i, -1, k - 1));
            }
        }

        // For each node in graph1, compute reachable nodes within k steps and add max from graph2
        int[] result = new int[n];
        for (int i = 0; i < n; ++i) {
            result[i] = dfs(graph1, i, -1, k) + maxReachableInGraph2;
        }

        return result;
    }

    // Helper method to perform DFS and count reachable nodes within given steps
    private int dfs(List<Integer>[] graph, int current, int parent, int stepsRemaining) {
        if (stepsRemaining < 0) {
            return 0;
        }
        int count = 1; // Count the current node
        for (int neighbor : graph[current]) {
            if (neighbor != parent) {
                count += dfs(graph, neighbor, current, stepsRemaining - 1);
            }
        }
        return count;
    }

    // Helper method to build adjacency list from edge list
    private List<Integer>[] buildGraph(int[][] edges, int size) {
        List<Integer>[] graph = new ArrayList[size];
        for (int i = 0; i < size; ++i) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        return graph;
    }
}
