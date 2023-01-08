package JavaNotes;

import java.util.*;
import java.lang.*;

public class ComparableAndComparator {
    public static void main(String[] args) {

        List<Student> list = new ArrayList<Student>();
        list.add(new Student("Hello1",32));
        list.add(new Student("Hello2",100));
        list.add(new Student("Hello3",19));
        list.add(new Student("Hello4",34));

        System.out.println("===================未排序结果========================");

        for (Student student : list) {
            System.out.println(student.toString());
        }

        System.out.println("===============Comparable接口排序结果=================");

        Collections.sort(list);
        for (Student student : list) {
            System.out.println(student.toString());
        }


        System.out.println("===============Comparator接口排序结果=================");
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.age == o1.getAge() &&o1.name == o2.getName()){
                    return 0;
                }else if(o1.age < o2.age){
                    return 1;
                }else{
                    return -1;
                }
            }
        });

        for (Student student : list) {
            System.out.println(student.toString());
        }

        System.out.println("===============lambda表达式排序结果===================");

        Collections.sort(list,(o1,o2)->(o1.getAge()-o2.getAge()));
        list.forEach(student->{
            System.out.println(student.toString());
        });


    }
}


class Student implements Comparable<Student> {

    protected String name;

    protected int age;

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

    public Student(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public Student() {
        super();

    }

    @Override
    public int compareTo(Student o) {
        if(this.age == o.getAge() &&this.name == o.getName()){
            return 0;
        }else if(this.age > o.getAge()){
            return 1;
        }else{
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Student[name="+this.name+",age="+this.age+"]";
    }
}
