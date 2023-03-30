package com.tridu33.JavaNotes.jvm.init;
//https://bbs.huaweicloud.com/blogs/252131
class Other {
    public static Other o1 = new Other();

    public static Other o2 = new Other();
    {
        System.out.println("构造块");
    }
    static {
        System.out.println("静态块");
    }

    public static void main(String[] args) {
        Other other = new Other();
    }
}
