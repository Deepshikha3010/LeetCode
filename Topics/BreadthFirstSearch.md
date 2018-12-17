# Breadth-First Search

## Usage

- Check minimum steps/distance

Normally use `queue` with its `size`, as `queue` is first in first out. Sometimes use rolling `stack` to keep `zigzag` order.

## 2D Array Minimum Distance

<strong>1. Find the closest `dst` spot</strong>

Put all `dst` cells into queue before BFS. Every cell will be update only once. (If a cell has already been update, the next update will have more steps)

When there is no obstacles, we can use DP (Two Sweep). Like `01 Matrix`.

- [286. Walls and Gates](../Solutions/286_Walls_and_Gates/README.md)
- [542. 01 Matrix](../Solutions/542_01_Matrix/README.md)

<strong>2. Find the shortest distance sum to all `dst` spots</strong>

Have to test all `dst` to one `src`.

- [317. Shortest Distance from All Buildings](./Solutions/317_Shortest_Distance_from_All_Buildings/README.md)

## Graph Minimum Distance

<strong>1. Find tree root</strong>

Start from leaves, which only have 1 edge connected. A tree-like graph has no more than 2 roots.

- [310. Minimum Height Trees](../Solutions/310_Minimum_Height_Trees/README.md)

<strong>2. Find shortest path</strong>

Either `BFS` or `Dijkstra`. If K limitation is small, `BFS` can be more efficient.

- [743. Network Delay Time](../Solutions/743_Network_Delay_Time/README.md)
- [787. Cheapest Flights Within K Stops](../Solutions/787_Cheapest_Flights_Within_K_Stops/README.md)
- [815. Bus Routes](../Solutions/815_Bus_Routes/README.md)