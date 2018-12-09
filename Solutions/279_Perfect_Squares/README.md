# [279. Perfect Squares](https://leetcode.com/problems/perfect-squares/)

## Type

- Math
- Dynamic Programming

## Explain

Backtracking is the naive method that should come out of mind firstly. Since we don't list all possible combinations, `DP` is a better choice.
The best solution for this problem is by using `four-square theorem`.

## Code

### Solution 1 - Backtracking (Not Accepted)

```java
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
```

### Solution 2 - Dynamic Programming

```java
/**
 * Type: Dynamic Programming
 * Time: n*sqrt(n)
 * Space: n
 */
class Solution {
    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        
        // f[i] repesents the least number of perfect square numbers of i.
        int[] f = new int[n + 1];
        Arrays.fill(f, Integer.MAX_VALUE);
        
        for (int i = 0; i * i <= n; i++) {
            f[i * i] = 1;
        }
        
        for (int i = 0; i <= n; i++) {
            for (int j = 1; i + j * j <= n; j++) {
                // From i to i + j * j, should be 1 more perfect number.
                f[i + j * j] = Math.min(f[i + j * j], f[i] + 1);
            }
        }
        
        return f[n];
    }
}
```

### Solution 3 - Math

According to `four-square theorem`, any positive integer can be the sum of less than 4 integers' square. This means any positive integer can be the sum of square from `[1, 2, 3, 4]`.

If an integer is divisible by 4, we can keep divide it by 4, which will not effect our result, such as `1^2 + 2^2 + 3^2 + 4^4`. If an integer is divisible by 8, the result is 4 (Just remember. Don't know how to prove).

So now the result can be 1 or 2 or 3. We can use a `for loop` to test if result is 1 or 2. Otherwise the result is 3.

```java
/**
 * Type: Math
 * Time: sqrt(n) (worst case)
 * Space: 1
 */
class Solution {
    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        
        while (n % 4 == 0) {
            n /= 4;
        }
        
        if (n % 8 == 7) {
            return 4;
        }
        
        // 1 or 2
        for (int i = 0; i * i <= n; i++) {
            int j = (int)Math.sqrt(n - i * i);
            if (j * j + i * i == n) {
                int res = 0;
                if (j > 0) res++;
                if (i > 0) res++;
                return res;
            }
        }
        
        return 3;
    }
}
```