# [529. Minesweeper](https://leetcode.com/problems/minesweeper/)

## Type

- Breadth-first Search

## Explain

If first click is not `mine`, use `BFS`. Since we determine a cell's content after we check the mine number around, we should not put valid surround cells into queue at beginning.

There is no apparent time difference between 2 solutions below.

## Code

### Solution 1 - BFS

Two issues should be noticed in this version:

1. Since a cell's content is determined by surrounding mine's number, we should change cell's content when it is polled out of the queue, instead of before put into it. 
2. Since we cannot change cell's content before putting it into the queue, we should create a `visited` 2d array to avoid duplicated search.

```java
/**
 * Type: BFS
 * Time: m*n
 * Space: m*n
 */
class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null || board.length == 0 || board[0].length == 0) return board;
        
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> temp;
        boolean[][] visited = new boolean[board.length][board[0].length];
        visited[click[0]][click[1]] = true;
        
        queue.offer(click);
        
        int[] h = new int[]{0, 1, 0, -1, -1, 1, -1, 1};
        int[] v = new int[]{1, 0, -1, 0, -1, 1, 1, -1};
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            temp = new LinkedList<>();
            int count = 0;
            
            for (int i = 0; i < 8; i++) {
                int newY = cur[0] + h[i], newX = cur[1] + v[i];
                if (isValid(board, newY, newX, visited)) {
                    if (board[newY][newX] == 'M') {
                        count++;
                    } else {
                        temp.offer(new int[]{newY, newX});
                    }
                }
            }
            
            if (count != 0) {
                board[cur[0]][cur[1]] = (char)(count + '0');
            } else {
                board[cur[0]][cur[1]] = 'B';
                while (!temp.isEmpty()) {
                    int[] next = temp.poll();
                    visited[next[0]][next[1]] = true;
                    queue.offer(next);
                }
            }
        }
        
        return board;
    }
    
    private boolean isValid(char[][] board, int y, int x, boolean[][] visited) {
        return y >= 0 && y < board.length && x >= 0 && x < board[0].length && !visited[y][x];
    }
}
```

### Solution 2 - BFS (No visited array)

We use `count` to determine if we should add surrounding cells into queue. If they should be put into queue, they can be change to `B` at the same time.

```java
/**
 * Type: BFS
 * Time: m*n
 * Space: m*n
 */
class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null || board.length == 0 || board[0].length == 0) return board;
        
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> temp;
        queue.offer(click);
        board[click[0]][click[1]] = 'B';
        
        int[] h = new int[]{0, 1, 0, -1, -1, 1, -1, 1};
        int[] v = new int[]{1, 0, -1, 0, -1, 1, 1, -1};
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            temp = new LinkedList<>();
            int count = 0;
            
            for (int i = 0; i < 8; i++) {
                int newY = cur[0] + h[i], newX = cur[1] + v[i];
                if (inBound(board, newY, newX)) {
                    if (board[newY][newX] == 'M') {
                        count++;
                    } else if (board[newY][newX] == 'E') {
                        temp.offer(new int[]{newY, newX});
                    }
                }
            }
            
            if (count != 0) {
                board[cur[0]][cur[1]] = (char)(count + '0');
            }
            while (count == 0 && !temp.isEmpty()) {
                int[] next = temp.poll();
                board[next[0]][next[1]] = 'B';
                queue.offer(next);
            }
        }
        
        return board;
    }
    
    private boolean inBound(char[][] board, int y, int x) {
        return y >= 0 && y < board.length && x >= 0 && x < board[0].length;
    }
}
```