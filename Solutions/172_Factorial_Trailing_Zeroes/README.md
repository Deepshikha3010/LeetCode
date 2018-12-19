# [172. Factorial Trailing Zeroes](https://leetcode.com/problems/factorial-trailing-zeroes/)

## Type

- Math

## Explain

<strong>Brute Force: </strong>

Get the result of `n!` and then check its trailing zeros. If `n` is too big, `n!` will exceed the `long` or `double`'s range.

<strong>Math: </strong>

`10!` can be regarded as:

```md
10 * 9 * ... * 5 * ... * 1
```

Then we have:

```md
(5 * 2) * 9 * ... * (5) * ... * 1
```

Only `5 * 2 = 10`, since the presence of `2` can be much more than `5`, we can count how many `5` in `n!`. Use a loop to check how many numbers smaller than `n` have factor `5`.

We know numbers under `n`, every 5 number there will be a number divisible by 5. However, we should also consider the number that can be divisible by 5^2 .. 5^x. Such as 25 and 125:

```java
int count = 0;
while (n >= 5) {
    count += n / 5;
    n /= 5;
}
```

## Code

### Solution 1 - Brute Force (No Accepted)

```java
/**
 * Type: Brute Force
 * Time: n
 * Space: 1
 */
class Solution {
    public int trailingZeroes(int n) {
        if (n == 0) return 0;

        long num = 1;
        n = Math.abs(n);

        while (n != 0) {
            num *= n--;
        }

        System.out.println(num);

        int count = 0;
        while (num != 0) {
            int d = (int)(num % 10);
            if (d == 0) count++;
            else break;
            num /= 10;
        }

        return count;
    }
}
```

### Solution 2 - Math

```java
/**
 * Type: Math
 * Time: logn
 * Space: 1
 */
class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }

        return count;
    }
}
```