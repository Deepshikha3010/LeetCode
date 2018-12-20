# [171. Excel Sheet Column Number](https://leetcode.com/problems/excel-sheet-column-number/)

## Type

- Math

## Explain

We should have a `base` value for each digit. String like `AB`:

- For `B`, `B => 2`. So we have `26^0 * 2 => 2`.
- For `A`, `A => 1`. So we have `26^1 * 1 => 26`.

The result would be `2 + 26 => 28`. Since `'A' - 'A' => 0`, we should add `1` for each calculation: `'A' + 1 - 'A' => 1`.

## Code

### Solution 1

```java
/**
 * Type: Math
 * Time: n
 * Space: 1
 */
class Solution {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) return 0;

        int index = 0;
        int n = s.length() - 1;
        int count = 0;
        while (n - index >= 0) {
            char c = s.charAt(n - index);
            int base = (int)(Math.pow(26, index));
            int d = base * (c + 1 - 'A');
            count += d;
            index++;
        }

        return count;
    }
}
```