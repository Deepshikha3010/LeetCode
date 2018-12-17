# [787. Cheapest Flights Within K Stops](https://leetcode.com/problems/cheapest-flights-within-k-stops/)

## Type

-   Breadth-first Search
-   Heap

## Explain

The graph should be a sparse graph, which means E ~ V. So the time complexity of `BFS` is E\*K (worst case).

When K is large, we can use `Dijkstra`. Time complexity is ElogE + E.

## Code

### Solution 1 - BFS

```java
/**
 * Type: BFS
 * Time: E*K
 * Space: E*K
 */
class Solution {
    private class Flight {
        int city;
        int price;
        Map<Integer, Integer> nexts;

        Flight(int city) {
            this.city = city;
            this.price = Integer.MAX_VALUE;
            this.nexts = new HashMap<>();
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (src == dst) return 0;

        Map<Integer, Flight> map = new HashMap<>();

        for (int i = 0; i < flights.length; i++) {
            int from = flights[i][0];
            int to = flights[i][1];
            int price = flights[i][2];
            if (!map.containsKey(from)) map.put(from, new Flight(from));
            if (!map.containsKey(to)) map.put(to, new Flight(to));
            map.get(from).nexts.put(to, price);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0});

        while (K >= 0 && !queue.isEmpty()) {
            int size = queue.size();
            K--;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                Map<Integer, Integer> nexts = map.get(cur[0]).nexts;
                for (int next : nexts.keySet()) {
                    Flight nextFlight = map.get(next);
                    int nextPrice = cur[1] + nexts.get(next);
                    if (nextFlight.price > nextPrice) {
                        nextFlight.price = nextPrice;
                        queue.offer(new int[]{next, nextPrice});
                    }
                }
            }
        }

        return map.get(dst).price != Integer.MAX_VALUE ? map.get(dst).price : -1;
    }
}
```

### Solution 2 - Dijkstra

```java
/**
 * Type: Dijkstra
 * Time: ElogE + E*V
 * Space: E + V*E
 */
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (src == dst) return 0;

        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        for (int i = 0; i < flights.length; i++) {
            int from = flights[i][0];
            int to = flights[i][1];
            int price = flights[i][2];
            if (!map.containsKey(from)) map.put(from, new HashMap<>());
            map.get(from).put(to, price);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[]{src, 0, K});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[0] == dst) return cur[1];
            if (cur[2] < 0 || !map.containsKey(cur[0])) continue;
            for (int next : map.get(cur[0]).keySet()) {
                pq.offer(new int[]{next, cur[1] + map.get(cur[0]).get(next), cur[2] - 1});
            }
        }

        return -1;
    }
}
```
