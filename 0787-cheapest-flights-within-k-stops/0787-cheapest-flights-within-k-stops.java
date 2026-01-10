import java.util.*;

class Pair {
    int first, second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Tuple {
    int first, second, third;
    Tuple(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            adj.get(flights[i][0]).add(
                new Pair(flights[i][1], flights[i][2])
            );
        }

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, src, 0)); // stops, node, cost

        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;

        while (!q.isEmpty()) {
            Tuple it = q.poll();
            int stops = it.first;
            int node = it.second;
            int cost = it.third;

            if (stops > K) continue;

            for (Pair iter : adj.get(node)) {
                int adjNode = iter.first;
                int edw = iter.second;

                if (cost + edw < dist[adjNode] && stops <= K) {
                    dist[adjNode] = cost + edw;
                    q.add(new Tuple(stops + 1, adjNode, cost + edw));
                }
            }
        }

        if (dist[dst] == (int) 1e9) return -1;
        return dist[dst];
    }
}
