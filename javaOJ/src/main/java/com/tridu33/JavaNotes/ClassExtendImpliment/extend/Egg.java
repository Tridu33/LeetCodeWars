package com.tridu33.JavaNotes.ClassExtendImpliment.extend;

public class Egg {
    class Yolk {
        public Yolk(){System.out.println("Egg.yolk");}
    }
    public  Egg(){new Yolk();}
}
