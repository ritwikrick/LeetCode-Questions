import java.util.*;

class Solution {

    static class Pair {
        int city, cost, stops;

        Pair(int city, int cost, int stops) {
            this.city = city;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < flights.length; i++) {
            int from = flights[i][0];
            int to = flights[i][1];
            int price = flights[i][2];
            graph[from].add(new int[]{to, price});
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> a.cost - b.cost
        );

        // stops array (important optimization)
        int[] stopsArr = new int[n];
        Arrays.fill(stopsArr, Integer.MAX_VALUE);

        pq.add(new Pair(src, 0, 0));

        while (!pq.isEmpty()) {

            Pair cur = pq.poll();
            int city = cur.city;
            int cost = cur.cost;
            int stops = cur.stops;

            if (city == dst) return cost;

            if (stops > k || stops > stopsArr[city]) continue;

            stopsArr[city] = stops;

            for (int i = 0; i < graph[city].size(); i++) {
                int[] nei = graph[city].get(i);

                pq.add(new Pair(
                        nei[0],
                        cost + nei[1],
                        stops + 1
                ));
            }
        }

        return -1;
    }
}