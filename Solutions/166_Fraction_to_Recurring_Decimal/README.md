# [166. Fraction to Recurring Decimal](https://leetcode.com/problems/fraction-to-recurring-decimal/)

## Type

- Math

## Explain

If `numerator` is divisible by `denominator`, return result directly.

If not, use a `HashMap` to map `reminder` to `index`. Then we use a while loop to keep get the `reminder`, if there is a duplicate `reminder`, it means there will be a repeating fraction after the `.`.

If there is no repeating fraction, the last 3 character should be `(0)`. So we have to replace it.

## Code

### Solution 1

```java
/**
 * Type: Math
 * Time: n (unknown)
 * Space: n (unknown)
 */
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) return "";

        StringBuilder sb = new StringBuilder();

        if (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) sb.append('-');

        long divd = Math.abs((long) numerator);
        long divs = Math.abs((long) denominator);

        sb.append(divd / divs);
        long res = divd % divs;

        if (res == 0) return sb.toString();

        sb.append('.');
        Map<Long, Integer> map = new HashMap<>();
        while (!map.containsKey(res)) {
            map.put(res, sb.length());
            sb.append(10 * res / divs);
            res = res * 10 % divs;
        }

        int index = map.get(res);
        sb.insert(index, '(');
        sb.append(')');
        return sb.toString().replace("(0)", "");
    }
}
```