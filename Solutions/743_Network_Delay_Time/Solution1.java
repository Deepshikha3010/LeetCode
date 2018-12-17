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