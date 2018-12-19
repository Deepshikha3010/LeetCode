# [29. Divide Two Integers](https://leetcode.com/problems/divide-two-integers/)

## Type

- Binary Search
- Bit Manipulation

## Explain

<strong>Use `<<` to do Binary Search: </strong>

The essense of division is to figure out how many divsiors can sum up to dividend.

`<<` rule as below:

```md
1 << 1 => 1 * 2^1 => 2
1 << 0 => 1 * 2^0 => 1
1 << -1 => 2^31 − 1
```

Let's say `32 / 3`.

```md
3 << 0 => 3 * 1 => 3
3 << 1 => 3 * 2 => 6
3 << 2 => 3 * 4 => 12
3 << 3 => 3 * 8 => 24
3 << 4 => 3 * 16 => 48 // Beyond 32
```

So we got `shift == 4`. We want to have 3 * 8 (shift == 3) = 24. And then `dividend` = 32 - 24 = 8.

```md
3 << 0 => 3 * 1 => 3
3 << 1 => 3 * 2 => 6
3 << 2 => 3 * 4 => 12 // Beyond 8
```

So we got `shift == 2`. We want to have 3 * 2 (shift == 1) = 6. And then `dividend` = 8 - 6 = 2. Now `dividend` is smaller than `divisor`. Then we get the result as `res = 1 << 3 + 1 << 1 => 8 + 2 => 10`

The progress is like `3 * 8 + 3 * 2` => `3 * (8 + 2)` => `3 * 10 = 30`.

## Code

### Solution 1 - Binary Search

```java
/**
 * Type: Binary Search
 * Time: logn
 * Space: 1
 */
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) return Integer.MAX_VALUE;
            else if (divisor == 1) return Integer.MIN_VALUE;
        }

        boolean isNegative = false;

        if (dividend < 0 && divisor < 0) isNegative = false;
        else if (dividend < 0 || divisor < 0) isNegative = true;

        long divd = Math.abs((long) dividend);
        long divs = Math.abs((long) divisor);

        int res = 0;
        while (divd >= divs) {
            int shift  = 0;
            while ((divs << shift) <= divd) {
                shift++;
            }
            res += 1 << (shift - 1);
            divd -= divs << (shift - 1);
        }

        return isNegative ? -res : res;
    }
}
```