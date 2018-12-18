# [765. Couples Holding Hands](https://leetcode.com/problems/couples-holding-hands/)

## Type

- Greedy
- Union Find

## Explain

Couples list can be like:

```md
0 1 | 5 4 | 2 3
```

<strong>Greedy: </strong>

Step by step make sure every couple positions are couple numbers. `num ^ 1` make sure `odd - 1` or `even + 1`:

```md
0 => 1
1 => 0
```

It has to be `even + 1 = odd`.

<strong>Union Find: </strong>

Situation 1:

```md
0 2 | 5 4 | 1 3
```

We can swap `2` with `1`.

```md
0 1 | 5 4 | 2 3
```

This means if the `first` element of couple1 and couple2 and the `second` element of couple1 and couple2 are binded together, once we merge the first elements into same group and `count++`, we don't have to do `count++` when we encounter the second elements.

Situation 2:

```md
0 2 | 5 1 | 4 3
```

We should swap `1` with `4` to have:

```md
0 2 | 5 4 | 1 3
```

Then we have the situation 1. So before that when we encounter slot `5 1`, we merge them into one group and do `count++`.

## Code

### Solution 1 - Greedy

```java
/**
 * Type: Greedy
 * Time: n^2
 * Space: 1
 */
class Solution {
    public int minSwapsCouples(int[] row) {
        if (row == null || row.length == 0) return 0;

        int res = 0;
        for (int i = 0; i < row.length; i += 2) {
            if (row[i + 1] == (row[i] ^ 1)) continue;

            res++;
            for (int j = i + 1; j < row.length; j++) {
                if (row[j] == (row[i] ^ 1)) {
                    row[j] = row[i + 1];
                    row[i + 1] = row[i] ^ 1;
                    break;
                }
            }
        }

        return res;
    }
}
```

### Solution 2 - Union Find

```java
/**
 * Type: Union Find
 * Time: n
 * Space: n
 */
class Solution {
    private class UF {
        int[] f;

        UF(int n) {
            this.f =  new int[n];
            for (int i = 0; i < n; i++) {
                f[i] = i;
            }
        }

        int find(int x) {
            if (f[x] == x) {
                return x;
            }
            return f[x] = find(f[x]);
        }

        void connect(int a, int b) {
            int root_a = find(a);
            int root_b = find(b);
            if (root_a != root_b) {
                f[root_a] = root_b;
            }
        }
    }

    public int minSwapsCouples(int[] row) {
        if (row == null || row.length == 0) {
            return 0;
        }

        int n = row.length;
        int count = 0;
        UF uf = new UF(n);

        for (int i = 0; i < n; i += 2) {
            int root_a = uf.find(row[i] / 2);
            int root_b = uf.find(row[i + 1] / 2);
            if (root_a != root_b) {
                uf.connect(root_a, root_b);
                count++;
            }
        }

        return count;
    }
}
```