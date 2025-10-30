class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];
            adj.get(prereq).add(course); // directed edge: prereq → course
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] pathVis = new boolean[numCourses];
        Stack<Integer> s = new Stack<>();

        // Detect cycle + topological sort
        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) {
                if (isCycle(i, adj, vis, pathVis, s)) {
                    return new int[0]; // cycle found
                }
            }
        }

        int[] ans = new int[numCourses];
        int i = 0;
        while (!s.isEmpty()) {
            ans[i++] = s.pop();
        }
        return ans;
    }

    // DFS helper
    public boolean isCycle(int curr, ArrayList<ArrayList<Integer>> adj,
                           boolean[] vis, boolean[] pathVis, Stack<Integer> s) {
        vis[curr] = true;
        pathVis[curr] = true;

        for (int neighbor : adj.get(curr)) {
            if (!vis[neighbor]) {
                if (isCycle(neighbor, adj, vis, pathVis, s)) return true;
            } else if (pathVis[neighbor]) {
                return true; // cycle detected
            }
        }

        pathVis[curr] = false;
        s.push(curr); // topological order
        return false;
    }
}
