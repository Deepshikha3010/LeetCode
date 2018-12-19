# [263. Ugly Number](https://leetcode.com/problems/ugly-number/)

## Type

- Math

## Explain

Every straightforward solution.

For solution 2, if a num has divided all `2` factor, it should not be divisble by `4`.

## Code

### Solution 1

```java
/**
 * Type: Math
 * Time: logn
 * Space: 1
 */
class Solution {
    public boolean isUgly(int num) {
        if (num <= 0) return false;

        while (num % 2 == 0) num /= 2;
        while (num % 3 == 0) num /= 3;
        while (num % 5 == 0) num /= 5;

        return num == 1;
    }
}
```

### Solution 2

```java
/**
 * Type: Math
 * Time: logn
 * Space: 1
 */
class Solution {
    public boolean isUgly(int num) {
        if (num <= 0) return false;

        for (int i = 2; i < 6; i++) {
            while (num % i == 0) num /= i;
        }

        return num == 1;
    }
}
``