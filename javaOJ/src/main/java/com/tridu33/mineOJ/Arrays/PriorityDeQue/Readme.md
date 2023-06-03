默认升序小顶堆，大顶堆小顶堆的3种定义方案：

- Comparator定义大根堆
- Lambda定义小根堆

```java
PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((o1,o2)->o1-o2);
// 默认升序，数组头部元素最小，是小根堆 
// o1.getValue() - o2.getValue();
/*
小根堆升序的等价写法：
o1===o2 | return  0;
o1 > o2 | return  1;// (this)o1-(next)o2>0
o1 < o2 | return -1;// o1-o2<0    
同理，大根堆降序的等价写法：
o1===o2 | return  0;
o1 > o2 | return -1;// (next)o2-(this)o1>0
o1 < o2 | return  1;// o2-o1<0                                  
* */
```
- 类定义时Override方法
```java
@Override
int CompareTo(类nextObj){
    //升序小根堆
    if(this.val === nextObj.val){return 0;}
    else if(this.val > nextObj.val){return 1;}
    else if(this.val < nextObj.val){return -1;};
}
```
PriorityQueue模板 `topK.java`
# 单调队列
[labuladong单调队列模板](https://github.com/jiajunhua/labuladong-fucking-algorithm/blob/master/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E7%B3%BB%E5%88%97/%E5%8D%95%E8%B0%83%E9%98%9F%E5%88%97.md)
滑动窗口最大值`lc239.java` [lc406单调队列身高排队模板题](https://github.com/jiajunhua/labuladong-fucking-algorithm/blob/master/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E7%B3%BB%E5%88%97/%E5%8D%95%E8%B0%83%E9%98%9F%E5%88%97.md)
