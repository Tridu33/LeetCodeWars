[TOC]
# List<\*>
```java
List<Integer> list = new ArrayList<>;
list.add(ele);
list.get(index);
for(int i =0 ;i<len;i++){
    list.get(i);
}
list = [0,1,2,3,4,5];
list.add(2,-1);// = [0,1,-1,2,3,4,5]
list.add(index,ele);//任意下标插入
Arrays.toString(int[]类型);
Arrays.deepToString(int[]类型);
for(Iterator i = list.iterator();i.hasNext();){
    Integer num = (Integer)i.next();
}
List <*> list = new LinkedList();
list.add(ele)就是list.addLast(ele);
list.addFirst(ele);
list.getLast();
list.getFirst();
```
# \*[] 和 List<\*>的转换
```java
int[] nums = new int[] {1,2,3};
Integer[] newNums = Arrays.stream(nums).boxed.toArray(new Integer[0]);
```
# Deque
```java 
Deque<*> stk = new ArrayDeque<*>();当作栈用的时候推荐写法
Deque<*> stk = new LinkedList<*>();当作队列用的时候推荐
```

| Stack   | Queue     | PriorityQueue | Deque         | Error      |
|---------|-----------|---------------|---------------|------------|
|         | add(e)    | add(e)        | addLast(e)    | exception  |
|         | offer(e)  | offer(e)      | offerLast(e)  | false      |
| pop()   | remove()  | remove()      | removeFirst() | exception  |
|         | poll()    | poll()        | pollFirst()   | null       |
|         | element() |               | getFirst      | exception  |
| peek()  | peek()    | peek()        | peekFirst()   | null       |
| push(e) |           |               | addFirst(e)   | exception  |
|         |           |               | addFirst(e)   | false      |
# Sort
`MySorts.java`

# Random

```java
(int)Math.random(1*(r-l+1)+l);//[l,...,r]
Random rand = new Random(种子);
int i = rand.nextInt(100);//[0,100)整数
```


