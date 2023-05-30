package com.tridu33.mineOJ.Arrays.sorts;
import java.lang.*;
import java.util.*;
import java.util.stream.Collectors;
/*
*  https://juejin.cn/post/7030329485249478669
*/

public class MySorts {

    class Student implements Comparable<Student> {
//        Collections.sort(list4Students);
//        Arrays.sort(list4Students);
        int sum;
        public Student(int sum) {
            this.sum = sum;
        }

        @Override
        public int compareTo(Student o) {
            return this.sum - o.sum;
        }
        @Override
        public String  toString(){
            String sum1 = ((Integer) this.sum).toString();
            return sum1;
        }

    }
    private static void testSortArrays(){
        int [] arr = new int[] {1,2,3};
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println(list);
    }
    class SortTest {
        public void test() {
//            Scanner sc = new Scanner(System.in);
//            int n = sc.nextInt();
            System.out.print("排序前：");
            int[] arr = new int[]{114,2,3,4,514}; // 数组大小可以定义
            System.out.println(Arrays.toString(arr));
            List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
            Collections.sort(list,Collections.reverseOrder());//List集合
            Integer[] arrInteger = list.toArray(new Integer[0]);
//            Arrays.sort(arrInteger, Collections.reverseOrder());/
            Arrays.sort(arrInteger, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            Arrays.parallelSort(arrInteger, 0,5,new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });//包装类数组 Integer[]
//            Arrays.sort(arr,0,5);//int[]
//            Arrays.parallelSort(arr);//int[]
            System.out.print("排序后：");
            System.out.println(Arrays.toString(arrInteger));
            for(int i = 0;i < 5;i ++) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    public static void main(String[] args){
        testSortArrays();
        MySorts cur = new MySorts();
        SortTest test1 = cur.new SortTest();
        test1.test();

        // List<Student>
        List<Student> list4Students = new ArrayList<>();
        for (int i = 0; i < 3; i++) list4Students.add(cur.new Student(i));
        Collections.sort(list4Students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.sum - o2.sum;
            }
        });
        System.out.println("");
        System.out.println(list4Students);
        //Student[]
        Student[] arr4students = new Student[3];
        for (int i = 0; i < 3; i++) {
            arr4students[i] = cur.new Student(i);
        }
        Arrays.sort(arr4students, new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o1.sum - o2.sum;
                    }
                });
        System.out.println(Arrays.toString(arr4students));
    }
}




