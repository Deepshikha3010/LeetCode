class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return true;
        }
        int[] degrees = new int[numCourses];
        List<Integer>[] map = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int[] pair = prerequisites[i];
            int next = pair[0];
            int pre = pair[1];
            map[pre].add(next);
            degrees[next]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degrees[i] == 0) {
                queue.offer(i);               
            }
        }
        
        int count = 0;
        while(!queue.isEmpty()) {
            int pre = queue.poll();
            count++;
            int n = map[pre].size();
            for (int i = 0; i < n; i++) {
                int next = map[pre].get(i);
                degrees[next]--;
                if (degrees[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return count == numCourses;
    }
}