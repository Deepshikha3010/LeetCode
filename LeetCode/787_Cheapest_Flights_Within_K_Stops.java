/**
 * Type: Dijkstra
 * Time: E + nlogn (E: flights number)
 * Space: n (n: size of heap)
 */

class Solution {
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
      Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
      for (int[] f : flights) {
          if (!prices.containsKey(f[0])) {
              prices.put(f[0], new HashMap<>());
          }
          prices.get(f[0]).put(f[1], f[2]);
      }
      PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[0], o2[0]));
      
      pq.add(new int[]{0, src, K + 1});
      
      while (!pq.isEmpty()) {
          int[] top = pq.poll();
          int price = top[0];
          int city = top[1];
          int stops = top[2];
          
          if (city == dst) {
              return price;
          }
          
          if (stops > 0) {
              Map<Integer, Integer> adj = prices.getOrDefault(city, new HashMap<>());
              for (int a : adj.keySet()) {
                  pq.add(new int[]{price + adj.get(a), a, stops - 1});
              }
          }
      }
      
      return -1;
  }
}