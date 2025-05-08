import java.util.*;

public class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length, m = moveTime[0].length;
        // dist[x][y][p]: min time to reach (x,y) when next move costs (p==0?1:2)
        int[][][] dist = new int[n][m][2];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);

        // Min‑heap entries: {time, x, y, parity}
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        dist[0][0][0] = 0;
        pq.offer(new int[]{0, 0, 0, 0});

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int time = cur[0], x = cur[1], y = cur[2], p = cur[3];
            if (x == n-1 && y == m-1) 
                return time;
            if (time > dist[x][y][p]) 
                continue;

            int moveCost = (p == 0 ? 1 : 2);
            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx<0||ny<0||nx>=n||ny>=m) continue;

                // WAIT until allowed, THEN move
                int startTime = Math.max(time, moveTime[nx][ny]);  
                int arrival  = startTime + moveCost;  
                int np = 1 - p;

                if (arrival < dist[nx][ny][np]) {
                    dist[nx][ny][np] = arrival;
                    pq.offer(new int[]{arrival, nx, ny, np});
                }
            }
        }
        return -1;  // unreachable
    }
}
