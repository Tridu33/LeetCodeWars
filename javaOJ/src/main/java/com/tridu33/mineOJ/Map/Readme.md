[TOC]
# HashSet<\*>
```java

```
# HashMap<\*,\*>\*[] 
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
# TreeSet<\*>
```java

```
# TreeMap<\*,\*>
```java

```