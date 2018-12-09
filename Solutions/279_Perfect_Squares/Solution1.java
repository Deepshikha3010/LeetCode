/**
 * Type: Backtracking
 * Time: sqrt(n) + oo
 * Space: sqrt(n) + oo (stack depth)
 */
class Solution {
    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        
        // sqrt(n)
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            list.add(i * i);
        }
        
        Collections.reverse(list);
        int count = findShortest(list, 0, n, 0);
        return count != Integer.MAX_VALUE ? count : 0;
    }
    
    // Since each number can be taken for unlimited times, time complexity here can be oo.
    private int findShortest(List<Integer> list, int index, int target, int count) {
        if (target == 0) {
            return count;
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = index; i < list.size(); i++) {
            int cur = list.get(i);
            if (cur > target) continue;
            min = Math.min(min, findShortest(list, i, target - cur, count + 1));
        }
        
        return min;
    }
}