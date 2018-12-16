/**
 * Type: BFS
 * Time: E*V
 * Space: V
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return true;
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indegrees = new HashMap<>();
        
        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[0];
            int to = prerequisite[1];
            if (!map.containsKey(from)) map.put(from, new ArrayList<>());
            if (!indegrees.containsKey(to)) indegrees.put(to, 0);
            map.get(from).add(to);
            indegrees.put(to, indegrees.get(to) + 1);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!indegrees.containsKey(i)) {
                queue.offer(i);
                visited.add(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (!map.containsKey(cur)) continue;
            for (int next : map.get(cur)) {
                if (visited.contains(next)) continue;
                indegrees.put(next, indegrees.get(next) - 1);
                if (indegrees.get(next) <= 0) {
                    queue.offer(next);
                    visited.add(next);
                }
            }
        }
        
        return visited.size() == numCourses;
    }
}