# [168. Excel Sheet Column Title](https://leetcode.com/problems/excel-sheet-column-title/)

## Type

- Math

## Explain

It is not typical number conversion problem. In normally number conversion, all numnber has a `0` number, so every time we do `mod` operation, we can use the reminder directly for getting current digit character.

For example, when we do demical to hex `17(10) => 11(16)`, `17 % 16 => 1`, and then `17 / 16 % 16 => 1`. So we have `11(16)` for `17(10)`.

However, in this situation, we don't have `0` character, the character starts from `A` which is `1`. Since when we do conversion base on 26, we should have `0` based index system, we can regard a number as `index + 1`.

For `28`, we have `(25 + 1) + (1 + 1)`. 25 and 1 are indices in the formulation. Every time before we do a `mod` operation, we should have `minus 1` operation:

```java
while (n > 0) {
    n--;
    sb.append((char)(n % 26 + 'A'));
    n /= 26;
}
```

## Code

### Solution 1

```java
/**
 * Type: Math
 * Time: logn
 * Space: 1
 */
class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char)(n % 26 + 'A'));
            n /= 26;
        }

        return sb.reverse().toString();
    }
}
```