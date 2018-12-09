/**
 * Type: BFS
 * Time: V
 * Space: V
 */
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            List<Integer> res = new ArrayList<>(Arrays.asList(0));
            return res;
        }
        
        List<Set<Integer>> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            map.get(edge[1]).add(edge[0]);
            map.get(edge[0]).add(edge[1]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i).size() == 1) queue.offer(i);
        }
        
        while (!queue.isEmpty() && n > 2) {
            int size = queue.size();
            n -= size;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                Set<Integer> nexts = map.get(cur);
                for (int next : nexts) {
                    map.get(next).remove(cur);
                    if (map.get(next).size() == 1) queue.offer(next);
                }
            }
        }
        
        return new ArrayList<>(queue);
    }
}