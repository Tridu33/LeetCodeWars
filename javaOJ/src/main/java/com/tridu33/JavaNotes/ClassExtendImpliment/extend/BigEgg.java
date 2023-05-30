package com.tridu33.JavaNotes.ClassExtendImpliment.extend;

public class BigEgg extends Egg {
    class Yolk {
        public Yolk(){System.out.println("BigEgg.yolk");}
    }
    public  BigEgg(){new BigEgg.Yolk();}

    public static void main(String[] args) {
        new BigEgg();
    }
}
