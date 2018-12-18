# [9. Palindrome Number](https://leetcode.com/problems/palindrome-number/)

## Type

- Math

## Explain

Use `x % 10` and `x / 10` to reverse `x`, so we don't need to use `String` to do so.

## Code

### Solution 1

```java
/**
 * Type: Math
 * Time: log10n
 * Space: 1
 */
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int num = 0;
        int x0 = x;
        while (x != 0) {
            int d = x % 10;
            int temp = num * 10 + d;
            if (temp / 10 != num) return false;
            num = temp;
            x /= 10;
        }

        return x0 == num;
    }
}
```