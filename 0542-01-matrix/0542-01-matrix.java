class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] ans = new int[m][n];
        boolean[][] vis = new boolean[m][n];

        // 1. Initialize: Add all 0s to the queue and mark them visited
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j, 0}); // {row, col, distance}
                    vis[i][j] = true;
                }
            }
        }

        int[] rdir = {1, 0, -1, 0};
        int[] cdir = {0, 1, 0, -1};

        // 2. Standard BFS: Radiate outwards from all 0s simultaneously
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int dist = curr[2];

            ans[r][c] = dist;

            for (int d = 0; d < 4; d++) {
                int nr = r + rdir[d];
                int nc = c + cdir[d];

                // If neighbor is valid and not visited, it's the next "level"
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !vis[nr][nc]) {
                    vis[nr][nc] = true;
                    q.add(new int[]{nr, nc, dist + 1});
                }
            }
        }

        return ans;
    }
}