/**
 * Type: BFS
 * Time: V
 * Space: V
 */
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0) return 0;
        
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.offer(id);
        set.add(id);
        
        int sum = 0;
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sum += map.get(cur).importance;
            for (int next : map.get(cur).subordinates) {
                if (set.contains(next)) continue;
                queue.offer(next);
                set.add(next);
            }
        }
        
        return sum;
    }
}