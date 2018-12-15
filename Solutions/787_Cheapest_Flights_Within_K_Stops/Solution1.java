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