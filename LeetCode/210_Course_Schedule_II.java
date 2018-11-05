class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return new int[0];
        }
        
        List[] map = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            map[i] = new ArrayList<Integer>();
        }
        
        for (int[] pair : prerequisites) {
            int pre = pair[1];
            int cur = pair[0];
            map[pre].add(cur);
            degree[cur]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        
        if (queue.size() == 0) {
            return new int[0];
        }
        
        int[] res = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res[index] = cur;
            index++;
            if (map[cur] != null) {
                for (int i = 0; i < map[cur].size(); i++) {
                    int next = (int) map[cur].get(i);
                    degree[next]--;
                    if (degree[next] <= 0) {
                        queue.offer(next);
                    }
                }
            }
        }
        
        return index == numCourses ? res : new int[0];
    }
}