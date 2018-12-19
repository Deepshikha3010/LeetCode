# [67. Add Binary](https://leetcode.com/problems/add-binary/)

## Type

- Math

## Explain

Only use one loop to do `digit add` operation:

```java
int n1 = index1 >= 0 ? a.charAt(index1--) - '0' : 0;
int n2 = index2 >= 0 ? b.charAt(index2--) - '0' : 0;
```

## Code

### Solution 1

```java
/**
 * Type: Math
 * Time: n
 * Space: 1
 */
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int index1 = a.length() - 1, index2 = b.length() - 1;
        int res = 0;

        while (index1 >= 0 || index2 >= 0) {
            int n1 = index1 >= 0 ? a.charAt(index1--) - '0' : 0;
            int n2 = index2 >= 0 ? b.charAt(index2--) - '0' : 0;

            int sum = n1 + n2 + res;
            int cur = sum % 2;
            res = sum / 2;
            sb.append(cur);
        }

        if (res != 0) sb.append(res);

        return sb.reverse().toString();
    }
}
```