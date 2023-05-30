
1寻找最长：

如果窗口满足条件，R向右滑动扩大窗口，更新最优值；

如果窗口不满足条件，L向右缩小窗口。

2寻找最短：

如果窗口满足条件，L向右滑动缩小窗口，更新最优值；

如果窗口不满足条件，R向右扩大窗口。

- 最长模板:
```java
初始化left, right, result, bestResult
for (右指针没有到结尾) {
    窗口扩大, 加入right对应元素, 更新当前result
    while (result不满足要求) {
        窗口缩小, 移除left对应元素, left右移
    }
    更新最优结果bestResult
    right++;
}
返回bestResult;
```


- 最短模板:
```java
初始化left, right, result, bestResult
for (右指针没有到结尾) {
    窗口扩大, 加入right对应元素, 更新当前result
    while (result满足要求) {
        更新最优结果bestResult
        窗口缩小, 移除left对应元素, left右移
    }
    right++;
}
返回bestResult;
```
1208 209 3无重复字符的最长子串 1004最大连续1的个数 尽量使字符串相等1208 
340 1151 159 1100