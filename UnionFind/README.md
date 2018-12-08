# Union Find

- Find Group

## Helper Class

```java
class UnionFind {
    int[] father;

    UnionFind(int n) {
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }

    // 1 (average)
    int find(int a) {
        if (father[a] == a) {
            return a;
        }
        return father[a] = find(father[a]);
    }

    // 1 (average)
    void connect(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);
        
        if (root_a != root_b) {
            father[root_a] = root_b;
        }
    }
}
```

## Graph

```java
```

## 2D Array

```java
```

## Binary Tree

```java
```

|Title|Difficulty|
|-----|---------|
|[200. Number of Islands](../LeetCode/200_Number_of_Islands/README.md)|Medium|