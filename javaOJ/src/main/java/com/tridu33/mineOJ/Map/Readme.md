[TOC]


# HashSet<\*>基于HashMap实现
对于 HashSet 而言，它是基于 HashMap 实现的，底层采用 HashMap 来保存元素。Map 中的 key 实际就是要添加的元素，value 是一个固定的对象。
```java
//源码中无参构造方法，完成map的创建
public HashSet() {
    map = new HashMap<>();
}
```

可以理解为基于数组和链表实现的HashSet集合存储的对象不重复，一般都需要重写存储对象的HashCode()和equals()方法。
Hash值用来寻址数组的链表头，如果HashCode则新元素和相同Hash的链表元素比较 equals() 方法，相等就不再重复插入。
```java
HASHsET<String> set = new HashSet<>();
set.clear();
set.add(ele);
set.contains(ele);
set.remove(ele);
for(String str:set){...}
```

# TreeSet<\*>
```java
TreeSet<Integer> nums = new TreeSet<>();// 默认自然升序
nums.方法 add(e)size()remove(e)addAll(treeSet2)removeAll()first()last()pollFirst()pollLast()isEmpty()clear()contains(e)
Interator<Integer> iter = nums.iterator();
while(iter.haNext){iter.next()};

s1.addAll(s2);
s1.retainAll(s2);//交集
s1.removeAll(s2);
s1.containsAll(s2);
```


---




# HashMap<\*,\*>\*[] 
Hashtable: 与 HashMap类似,不同的是:key和value的值均不允许为null;它支持线程的同步，即任一时刻只有一个线程能写Hashtable,因此也导致了Hashtale在写入时会比较慢。
```java
HashMap<Integer,String> map = new HashMap<>();
map.方法 get(key)put(key,ele)remove(ele)size()clear()isEmpty()
        containsKey(key)contsinsValue(value)replace(key,newValue)
        putIfAbsent(key,value)getOrDefault(k,defaultValue)
for(Integer key:map.keySet()){}
```
merge方法将新的值赋值到 key （如果不存在）或更新给定的key 值对应的 value

```java
default V merge(K key, V value,
        BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
    //判断value和remappingFunction都不为空        
    Objects.requireNonNull(remappingFunction);
    Objects.requireNonNull(value);
    //通过key去获取旧值 若无这个key则null
    V oldValue = get(key);
    //新值 = 旧值为null则新值=null，旧值不为null则新值=  remappingFunction.apply(旧值, 新值);
    V newValue = (oldValue == null) ? value :
               remappingFunction.apply(oldValue, value);
    //判断新值为null的话           
    if(newValue == null) {
        //移除这个key
        remove(key);
    } else {
        //不为null的话，重新put
        put(key, newValue);
    }
    return newValue;
}
```
# TreeMap<\*,\*>
在实现原理上LinkedHashMap是双向链表，TreeMap/TreeSet是红黑树。
1.HashMap、Hashtable不是有序的；

2.TreeMap和LinkedHashMap是有序的（TreeMap默认 Key 升序，LinkedHashMap则记录了插入顺序）。
