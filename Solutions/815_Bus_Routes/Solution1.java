/**
 * Type: BFS
 * Time: E*V
 * Space: E*V
 */
class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (routes == null || routes.length == 0 || routes[0].length == 0) return -1;
        
        if (S == T) return 0;
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j : routes[i]) {
                if (!map.containsKey(j)) map.put(j, new ArrayList<>());
                map.get(j).add(i);
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        Set<Integer> visited = new HashSet<>();
        
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int bus : map.get(cur)) {
                    if (visited.contains(bus)) continue;
                    visited.add(bus);
                    for (int next : routes[bus]) {
                        if (next == cur) continue;
                        if (next == T) return count;
                        queue.offer(next);
                    }
                }
            }
        }
        
        return -1;
    }
}