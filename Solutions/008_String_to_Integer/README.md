# [8. String to Integer (atoi)](https://leetcode.com/problems/string-to-integer-atoi/)

## Type

- Math

## Explain

<strong>Conditions need to be considered: </strong>

1. If `str` is null, return 0.
2. If `str` only contains whitespaces, return 0.
3. ----after `trim()`-----
4. Only the first character can be `-` or `+`.
5. If leading characters are `0` ignore them.
6. `+00001` or `0000-1` should return 0 directly.
7. If current `num` is larger than `Integer.MAX_VALUE`, return `Integer.MAX_VALUE` or `Integer.MIN_VALUE` according to `isNegative`.
8. After the first character, break traversal if reach a non-digit character.


## Code

### Solution 1 - (long) num

```java
/**
 * Type: Math
 * Time: n
 * Space: n
 */
class Solution {
    public int myAtoi(String str) {
        if (str == null) return 0;

        str = str.trim();
        if (str.length() == 0) return 0;

        boolean isNegative = false;
        long num = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0) {
                if ((c == '-' || c == '+')) {
                    isNegative = c == '-';
                    continue;
                }
                if (c == '0') continue;
            }

            if (!Character.isDigit(c)) break;
            long temp = num * 10 + c - '0';
            if (temp > Integer.MAX_VALUE) return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            num = temp;
        }

        if (num == 0) return 0;
        return isNegative ? (int)(-num) : (int)num;
    }
}
```