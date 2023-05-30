package com.tridu33.jvm.javap;

import java.util.Optional;
import java.util.function.Predicate;

public class SeeThisPointer {
    /*
    javap此文件查看java是怎么处理this的,类似于python的self
    把当前实例对象的引用作为第一个参数传递给方法 xxx.method(A,B) ==> xxx.method(this,A,B):
    LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0      56     0  this   Lcom/tridu33/JavaNotes/javap/Salary
    * */
    private double salary;
    public boolean modifySalary(double byPercent, Predicate<Double> predicateRaise){
        boolean valid = Optional.of(predicateRaise).map(
                predicate -> predicate.test(this.salary*byPercent/100)
        ).orElse(false);
        if(valid){
            this.salary += this.salary * byPercent/100;
            // javap查看如何处理this
        }
        return valid;
    }
}
