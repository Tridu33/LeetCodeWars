默认升序小顶堆，大顶堆小顶堆的两种定义方案：

Comparator定义大根堆
```java

```
Lambda定义小根堆

```java
PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((o1,o2)->o1-o2);
```

# 单调队列模板
```java


```