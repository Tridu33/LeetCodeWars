package com.tridu33.JavaNotes.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.*;

//https://www.cnblogs.com/fzz9/p/7738381.html
// Java反射使用总结 - 一二三冲鸭的文章 - 知乎
//https://zhuanlan.zhihu.com/p/80519709
class getMethodDemo {
    public static void main(String[] args) throws Exception {
        String className = "com.tridu33.JavaNotes.reflect.Person";
        Class<?> c = Class.forName(className);

        //获取公共方法：
        Method[] pubMethods = c.getMethods();

        //获取私有方法：
        Method[] priMethods = c.getDeclaredMethods();


        //获取单个方法：按方法名和参数获取

        //获取单个の静态方法：function1
        Method staMethod = c.getMethod("function1",null);
        //获取单个の无参数方法：function2
        Method nullMethod = c.getMethod("function2",null);
        //获取单个の有参数方法：function3
        Method moreMethod = c.getMethod("function3",String.class,int.class);
        //获取单个の私有方法：function4
        Method priMethod = c.getDeclaredMethod("function4",null);

        //打印查看效果
        System.out.println("[Person类的公共方法及父类方法:]");
        for(Method m:pubMethods){
            System.out.println(m);
        }
        System.out.println("[Person类的私有方法:]");
        for(Method m:priMethods){
            System.out.println(m);
        }
        System.out.println("[按方法名和参数类型获取的方法4个方法:]");
        System.out.println(staMethod);
        System.out.println(nullMethod);
        System.out.println(moreMethod);
        System.out.println(priMethod);
    }
}
class invokeDemo {
    public static void main(String[] args) throws Exception {
        String className = "com.tridu33.JavaNotes.reflect.Person";
        Class<?> c = Class.forName(className);

        //获取有参数的方法：function3
        Method moreMethod = c.getDeclaredMethod("function3",String.class,int.class);

        //使用之前我们需要创建一个该类对象：
        Object obj = c.newInstance();
        moreMethod.setAccessible(true);//设置访问权限
        Object value = moreMethod.invoke(obj,"李四",20);

        //打印查看效果
        System.out.println(value);
    }
}
class Person {
    private String name;
    private int age;
    public Person(){
        super();
    }
    public Person(String name,int age){
        super();
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public static void function1(){
        System.out.println("function");
    }
    public void function2(){
        System.out.println("function");
    }
    public void function3(String s,int i){
        System.out.println(s+":::"+i);
    }
    @SuppressWarnings("unused")
    private void function4(){
        System.out.println("function");
    }
}
class getFieldDemo {
    // Field获取字段的本质
    public static void main(String[] args) throws Exception {
        String className = "com.tridu33.JavaNotes.reflect.Person";
        Class<?> c = Class.forName(className);

        //获取私有字段
        Field nameField = c.getDeclaredField("name");
        Field ageField = c.getDeclaredField("age");

        //使用字段（使用之前我们需要一个该类对象）
        Object obj = c.newInstance();

        //使用set()方法设置字段值
        nameField.setAccessible(true);
        ageField.setAccessible(true);//暴力访问
        nameField.set(obj, "张三");
        ageField.set(obj,20);

        //打印查看效果
        System.out.println("获取到的字段：");
        System.out.println("name:"+nameField);
        System.out.println("age:"+ageField);
        System.out.println("字段设置的值：name="+nameField.get(obj)+",age="+ageField.get(obj));
    }
}
public class getClass4Methods {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Person p = new Person();
        /*
        * Person p = new Person();等价于Class.forName("bean.Person").newInstance();
        * */
        // 方法一 : 调用运行时类的.class属性
        Class c1 = Person.class;
        System.out.println("方法一 : 调用运行时类的.class属性: "+c1.toString());

        // 方法二 : 通过运行时类的对象，调用getClass()方法
        Class c2 = p.getClass();
        System.out.println("方法二 : 通过运行时类的对象，调用getClass()方法: "+c2.toString());

        // 方法三 : 调用Class的静态方法forName
        Class c3 = Class.forName("com.tridu33.JavaNotes.reflect.Person");//指明包名
        System.out.println("方法三 : 调用Class的静态方法forName: "+c3.toString());

        // 方法四 ：通过类的加载器
        ClassLoader classLoader = Person.class.getClassLoader();
        Class c4 = classLoader.loadClass("com.tridu33.JavaNotes.reflect.Person");
        System.out.println("方法四 ：通过类的加载器: "+c4.toString());

        // 新建对象的本质
        Person obj0 = new Person("List",20);
        // 等价于下面这两步
        Class c;
        c = Class.forName("com.tridu33.JavaNotes.reflect.Person");
        //1、获取这个带有参数的构造器
        Constructor<?> con = c.getConstructor(String.class,int.class);
        //2、使用构造器来创建：
        Object obj = con.newInstance("LiSi",20);


    }
}
