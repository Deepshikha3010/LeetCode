/**
 * Type: Dijkstra
 * Time: ElogE + E
 * Space: E
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