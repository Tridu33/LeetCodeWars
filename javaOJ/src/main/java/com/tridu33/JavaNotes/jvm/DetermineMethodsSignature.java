package com.tridu33.JavaNotes.jvm;

import java.util.function.Function;

public class DetermineMethodsSignature {
    public interface MyFunction extends Function<Object,String> {}
    public static void consume(Function<Object,String> mapping) { System.out.println("jdk mapping");   }
    public static void consume(MyFunction mapping) { System.out.println("myFunction mapping");   }
    public static void main(String[] args) {
        consume((Function<Object,String>) Object::toString );
        consume((MyFunction) Object::toString );
        consume( Object::toString );
        consume(null);
    }
}
