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