package com.tridu33.JavaNotes.jvm.classLoader;

public class ClassLoader {
    // UserClassLoader用户自定义类加载器,由jdk.internal.loader.ClassLoaders$PlatformClassLoader实现
    // AppClassLoader 由sun.misc.Launcher$AppClassLoader实现。由于这个类加载器是ClassLoader中的getSystemClassLoader()方法的返回值，所以一般也称它为系统类加载器。它负责加载用户类路径（ClassPath）上所指定的类库
    // extends
    // ExtClassLoader(java) 由sun.misc.Launcher$ExtClassLoader实现，它负责加载<JAVA_HOME>\lib\ext目录中的，或者被java.ext.dirs系统变量所指定的路径中的所有类库
    // extends BootstrapClassloader(c++)<JAVA_HOME>\lib目录中的
    public static void main(String[] args) {
        ClassLoader test = new ClassLoader();
        System.out.println(test.getClass().getClassLoader());//AppClassLoader
        System.out.println(test.getClass().getClassLoader().getParent());//jdk.internal.loader.ClassLoaders$PlatformClassLoader
        System.out.println(test.getClass().getClassLoader().getParent().getParent());
    }
}
