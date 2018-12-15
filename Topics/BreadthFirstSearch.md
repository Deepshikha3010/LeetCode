# Breadth-First Search

- Check minimum steps/distance
- Traverse by level

Normally use `queue` with its `size`, as `queue` is first in first out. Sometimes use rolling `stack` to keep `zigzag` order.

## 2D Array

### Find Continuous Area

### Minimum Distance

<strong>1. Find the closet `dst` spot</strong>

Put all `dst` cells into queue before BFS. Every cell will be update only once. (If a cell has already been update, the next update will have more steps)

- [286. Walls and Gates](../Solutions/286_Walls_and_Gates/README.md)
- [542. 01 Matrix](../Solutions/542_01_Matrix/README.md): When there is no obstacles, we can use DP (Two Sweep).

<strong>2. Find the shortest distance sum to all `dst` spots:</strong>

Have to test all `dst` to one `src`.

- [317. Shortest Distance from All Buildings](./Solutions/317_Shortest_Distance_from_All_Buildings/README.md)

## Graph

### Minimum Distance

## Tree