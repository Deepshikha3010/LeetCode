# [773. Sliding Puzzle](https://leetcode.com/problems/sliding-puzzle/)

## Type

- Graph
- Breadth-first Search

## Explain

It is actually a perumutation problem, since we have to figure out the steps, we use level based `BFS`.

## Code

### Solution 1 - BFS

```java
/**
 * Type: BFS
 * Time: (m*n)! (worst case: permutation)
 * Space: (m*n)!
 */
class Solution {
    private class Entry {
        int y, x;
        String state;
        Entry(int y, int x, String state) {
            this.y = y;
            this.x = x;
            this.state = state;
        }
    }
    
    public int slidingPuzzle(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return -1;
        
        int m = board.length, n = board[0].length;
        
        String goal = "123450";
        Entry e = new Entry(-1, -1, "");
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                e.state += board[i][j];
                if (board[i][j] == 0) {
                    e.y = i;
                    e.x = j;
                }
            }
        }
        
        if (e.state.equals(goal)) return 0;
        
        Queue<Entry> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(e);
        visited.add(e.state);
        
        int[] h = new int[]{0, 1, 0, -1};
        int[] v = new int[]{1, 0, -1, 0};
        
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                Entry cur = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int newY = cur.y + h[k], newX = cur.x + v[k];
                    if (inBound(board, newY, newX)) {
                        String s = swap(cur, newY, newX, n);
                        if (visited.contains(s)) continue;
                        if (s.equals(goal)) return count;
                        visited.add(s);
                        queue.offer(new Entry(newY, newX, s));
                    }
                }
            }
        }
        
        return -1;
    }
    
    private String swap(Entry e, int y, int x, int len) {
        int cur = e.y * len + e.x;
        int next = y * len + x;
        char[] arr = e.state.toCharArray();
        char temp = arr[cur];
        arr[cur] = arr[next];
        arr[next] = temp;
        return String.valueOf(arr);
    }
    
    private boolean inBound(int[][] board, int y, int x) {
        return y >= 0 && y < board.length && x >= 0 && x < board[0].length;
    }
}
```