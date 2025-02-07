## [200. Number of Islands](https://leetcode.com/problems/number-of-islands)

## Problem Statement
Given an `m x n` 2D binary grid `grid` which represents a map of `'1'`s (land) and `'0'`s (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are surrounded by water.

---

## Examples

### Example 1:
#### Input:
```plaintext
grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
```
#### Output:
```plaintext
1
```

### Example 2:
#### Input:
```plaintext
grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
```
#### Output:
```plaintext
3
```

---

## Constraints
- `m == grid.length`
- `n == grid[i].length`
- `1 <= m, n <= 300`
- `grid[i][j]` is either `'0'` or `'1'`.

---

## Approach
To solve this problem, you can use:
- **Depth-First Search (DFS)**: Traverse the grid and mark connected land cells as visited.
- **Breadth-First Search (BFS)**: Use a queue to explore all connected land cells.
- **Union-Find (Disjoint Set)**: Efficiently group connected components.

Choose the approach based on efficiency and implementation preference.

---

### **Approach (Breadth-First Search - BFS)**
1. **Iterate** through each cell in the grid.
2. When a land cell (`'1'`) is found, **start a BFS** from that cell.
3. Use a **queue** to explore all connected land cells.
4. **Mark visited cells** as `'0'` to avoid revisiting.
5. **Increment island count** whenever a BFS starts.

---

### **Complexity Analysis**
- **Time Complexity:** O(m * n) → Each cell is visited once.
- **Space Complexity:** O(min(m, n)) → BFS queue can grow up to the size of the shortest dimension.

---