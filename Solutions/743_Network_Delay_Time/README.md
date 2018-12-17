# [743. Network Delay Time](https://leetcode.com/problems/network-delay-time/)

## Type

- Depth-first Search
- Greedy

## Explain

A naive solution is `DFS`: for each node, travere all path, and calculate the minimum value for each node. The time complexity is `V^2`.

<strong>Dijkstra: </strong>

Logic is almost the same as [787_Cheapest_Flights_Within_K_Stops](../787_Cheapest_Flights_Within_K_Stops/README.md). Since the the information transition happens at the same time, we record the maximum time around them.

## Code

### Solution 1 - Dijkstra

```java
/**
 * Type: Dijkstra
 * Time: E + ElogE
 * Space: V*E (Graph) + E (Heap)
 */
class Solution {
    private class Entry {
        int node;
        int val;
        Map<Integer, Integer> nexts;
        Entry(int node) {
            this.node = node;
            val = Integer.MAX_VALUE;
            nexts = new HashMap<>();
        }
    }

    public int networkDelayTime(int[][] times, int N, int K) {
        if (times == null || times.length == 0) return 0;

        // Time: E
        // Space: V*E
        Map<Integer, Entry> map = new HashMap<>();
        for (int[] time : times) {
            int from = time[0];
            int to = time[1];
            int val = time[2];
            if (!map.containsKey(from)) map.put(from, new Entry(from));
            if (!map.containsKey(to)) map.put(to, new Entry(to));
            map.get(from).nexts.put(to, val);
        }

        if (map.size() < N) return -1;

        map.get(K).val = 0;

        // Space: E (size of heap)
        PriorityQueue<Entry> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        pq.offer(map.get(K));

        // Time: ElogE
        while (!pq.isEmpty()) {
            Entry cur = pq.poll();
            Map<Integer, Integer> nexts = cur.nexts;
            for (int next : nexts.keySet()) {
                int newVal = cur.val + nexts.get(next);
                if (newVal < map.get(next).val) {
                    map.get(next).val = newVal;
                    pq.offer(map.get(next));
                }
            }
        }

        int res = 0;
        for (Entry e : map.values()) {
            if (res == Integer.MAX_VALUE) return -1;
            res = Math.max(e.val, res);
        }

        return res;
    }
}
```

```java
/**
 * Type: Dijkstra
 * Time: E + ElogE
 * Space: V*E + E
 */
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        if (times == null || times.length == 0) return 0;

        Map<Integer, List<int[]>> map = new HashMap<>();
        // Space: E*V
        // Time: E
        for (int[] time : times) {
            int from = time[0];
            int to = time[1];
            int val = time[2];
            if (!map.containsKey(from)) map.put(from, new ArrayList<>());
            map.get(from).add(new int[]{to, val});
        }

        Map<Integer, Integer> dist = new HashMap<>();

        // Space: n
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[]{K, 0});
        // Space: V
        dist.put(K, 0);

        // Time: nlogn
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            List<int[]> nexts = map.getOrDefault(cur[0], new ArrayList<>());
            for (int[] next : nexts) {
                int newVal = cur[1] + next[1];
                int preVal = dist.getOrDefault(next[0], Integer.MAX_VALUE);
                if (newVal < preVal) {
                    dist.put(next[0], newVal);
                    pq.offer(new int[]{next[0], newVal});
                }
            }
        }

        if (dist.size() < N) return -1;

        int res = 0;
        for (int val : dist.values()) {
            res = Math.max(val, res);
        }

        return res;
    }
}
```