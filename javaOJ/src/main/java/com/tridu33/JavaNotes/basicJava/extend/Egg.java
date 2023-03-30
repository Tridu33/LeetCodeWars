package com.tridu33.JavaNotes.basicJava.extend;

public class Egg {
    class Yolk {
        public Yolk(){System.out.println("Egg.yolk");}
    }
    public  Egg(){new Yolk();}
}
