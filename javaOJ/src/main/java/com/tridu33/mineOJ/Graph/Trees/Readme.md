BTtranverse.java是二叉树遍历的标准模板。

- 二叉树节点的深度(前序遍历)：指从根节点到该节点的最长简单路径边的条数。
- 二叉树节点的高度(后序遍历)：指从该节点到叶子节点的最长简单路径边的条数。

递归三部曲：
- 确定递归函数的参数和返回值 
- 总结如下三点：

如果需要搜索整棵二叉树且不用处理递归返回值，递归函数就不要返回值。（113.路径总和ii）
如果需要搜索整棵二叉树且需要处理递归返回值，递归函数就需要返回值。 （236. 二叉树的最近公共祖先）
如果要搜索其中一条符合条件的路径，那么递归一定需要返回值，因为遇到符合条件的路径了就要及时返回。（112. 路径总和）

- 确定终止条件


- 确定单层递归的逻辑

只有寻找某一条边（或者一个节点）的时候，递归函数会有bool类型的返回值。

搜索一条边的写法：
```java
if (递归函数(root->left)) return ;
if (递归函数(root->right)) return ;
```
搜索整个树写法：
```java
left = 递归函数(root->left);  // 左
right = 递归函数(root->right); // 右
left与right的逻辑处理;         // 中
```

在递归函数有返回值的情况下：如果要搜索一条边，递归函数返回值不为空的时候，立刻返回，如果搜索整个树，直接用一个变量left、right接住返回值，这个left、right后序还有逻辑处理的需要，也就是后序遍历中处理中间节点的逻辑（也是回溯）。

有返回值，插入修改删除裁剪更方便，可以通过递归函数的返回值来处理节点指针。669 701 450

树的递归分为两类:
- 找一条边的，提前返回left,right
分支里面return
- 遍历一棵树找最优的，暂存left,right最后返回值
最后return func(root.left,root.right)的返回值的表达式，
比如左右分支返回值同时为真，其中一个分支为真，左右分支深度取更大值等。



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
后序遍历（左右中）就是天然的回溯过程
前中后序，递归回溯八皇后，排列组合等。
DFS递归版本模板：前，中，后，DFS统一迭代版模板
