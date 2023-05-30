树的递归分为两类:

找一条边的，提前返回left,right

遍历一棵树找最优的，暂存left,right最后返回值

---

# BFS
139
130
317
505
529
1263
1197
815
934


不确定枚举到第几层
```python
queue = [初始节点]
visited = [初始节点]
while queue 非空
    cur = queue.pop()
    for 节点 in cur的所有相邻节点：
        if 节点 not in visited:
            visited.append(节点)
            queue.push(该节点)
```

需要确定遍历到第几层level
```python
queue = [初始节点]
visited = [初始节点]
level = 0
while queue 非空
    size = queue.size()
    while(size--):
        cur = queue.pop()
        for 节点 in cur的所有相邻节点：
            if 节点 not in visited:
                visited.append(节点)
                queue.push(该节点)
    level++
```

BFS基本模板(四个方向)



# DFS
934 
1102
685
531 533 
332
337 打家劫舍3
113 路经总和3

[岛屿类问题的通用解法--DFS遍历框架](https://www.jianshu.com/p/6132f7914947)
200岛屿数量，DFS
201岛屿的周长 （Easy）
202岛屿的最大面积 （Medium）
203最大人工岛 （Hard）
```c
void dfs(int[][] grid, int r, int c) {
    // 判断 base case
    if (!inArea(grid, r, c)) {
        return;
    }
    // 如果这个格子不是岛屿，直接返回
    if (grid[r][c] != 1) {
        return;
    }
    grid[r][c] = 2; // 将格子标记为「已遍历过」
    
    // 访问上、下、左、右四个相邻结点
    dfs(grid, r - 1, c);
    dfs(grid, r + 1, c);
    dfs(grid, r, c - 1);
    dfs(grid, r, c + 1);
}

// 判断坐标 (r, c) 是否在网格中
boolean inArea(int[][] grid, int r, int c) {
    return 0 <= r && r < grid.length 
            && 0 <= c && c < grid[0].length;
}
```
[LeetCode 二叉树系统题解](https://www.jianshu.com/p/e0bbf80f7541)，
前中后序，递归回溯八皇后，排列组合等。
DFS递归版本模板：前，中，后，DFS统一迭代版模板
