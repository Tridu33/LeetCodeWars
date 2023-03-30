package traning.tridu33;
import java.lang.*;
import java.math.BigDecimal;
import java.util.*;

public class TestKit {

    @org.junit.jupiter.api.Test
    public static void main(String[] args) {
        Tests t = new TestKit().new Tests();
        t.testIntegerMin();
//        t.testTreeSetException();
        t.testArrayAsLists();
        t.testAsSubLists();
//        t.testAutoboxing();
        t.testCanNotUseFloatInLoop();
        t.testDecimalAdd();
        t.testDoubleDivideByZero();

        t.testFinalizeOnlyRunOnce();
        t.testInc();
        t.testIntegerCompare();
        t.testIntOverFlow();
        t.testLinkedHashMap();
        t.testMap();
        t.testPrecision();
        t.testRex();
        t.testRemoveInFor();
        t.testStreamLazyEvaluation();
        t.testStringSplit();
        t.testSwitch();
        t.testThreadPoolShutdown();
        t.testTrue();

    }
    class Tests {
        private void testIntegerMin(){
            System.out.println("Abs Integer Min value is minus!");
            System.out.println(Math.abs(Integer.MIN_VALUE));
        }
        private void testTreeSet() throws NullPointerException{
            System.out.println("Exception");
            Set<String> set = new HashSet<>();
            set.add(null);
            System.out.println(set);

            Set<String> treeset = new TreeSet<>();
            treeset.add(null);
            System.out.println(treeset);
        }
        private void testArrayAsLists(){
            System.out.println("");
            String[] arr = new String[]{"1","2","3"};
            List<String> asList = Arrays.asList(arr);
            arr[0] = "f";
            System.out.println(asList);
            asList.set(0,"xxx");
            System.out.println(asList);
            System.out.println(Arrays.toString(arr));
        }
        private void testAsSubLists(){
            System.out.println("");
            List<Integer> list = Arrays.asList(1,2,3).subList(1,3);
            for (Integer i:
                 list) {
                System.out.println(i);
            }
        }
        private void testAutoboxing(){
            System.out.println("auto boxing");
            Long a = null;
            Long b = 1111L;
            System.out.println(a < b);
        }
        private void testCanNotUseFloatInLoop(){
            System.out.println("某些情况下有问题");
            for (float flt = (float) 2000000000; flt < 2000000050; flt++) {
                System.out.println("test");
            }
        }
        private void testDecimalAdd(){
            System.out.println("Decimal");
            BigDecimal a = new BigDecimal("2.0");
            BigDecimal b = new BigDecimal("2.00");
            a.add(b);
            BigDecimal c = a.add(b);
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);

        }
        private void testDoubleDivideByZero(){
            System.out.println("Double/0");
            System.out.println(1.0 / 0);
            System.out.println(-1.0 / 0);
            System.out.println(0.0 / 0);
//            System.out.println(1 / 0);// Exception
        }
        private void testFinalizeOnlyRunOnce(){
            System.out.println("");

        }
        private void testInc(){
            System.out.println("");

        }
        private void testIntegerCompare(){
            System.out.println("");

        }
        private void testIntOverFlow(){
            System.out.println("");

        }
        private void testLinkedHashMap(){
            System.out.println("");

        }
        private void testMap(){
            System.out.println("");

        }
        private void testPrecision(){
            System.out.println("");

        }
        private void testRex(){
            System.out.println("");

        }
        private void testRemoveInFor(){
            System.out.println("");

        }
        private void testStreamLazyEvaluation(){
            System.out.println("");

        }
        private void testStringSplit(){
            System.out.println("");

        }
        private void testSwitch(){
            System.out.println("");

        }
        private void testThreadPoolShutdown(){
            System.out.println("");

        }
        private void testTrue(){
            System.out.println("test true");
            String ssa = "true";
            System.out.println(Boolean.parseBoolean(ssa));
            System.out.println(Boolean.valueOf(ssa));//把 string="true" 转换成布尔类型 最好需要用valueOf 这个API

            //当且仅当以参数命名的系统属性存在，且等于 “true” 字符串时，才返回 true。（从 JavaTM 1.0.2 平台开始，字符串的测试不再区分大小写
            System.out.println(Boolean.getBoolean(ssa));
            // 这个getBoolean不是转换方法，而是获取Java系统属性的方法。
            // create 2 boolean primitives bool1, bool2
            boolean bool1, bool2;

            /**
             *  using System class's setProprty method, set the values of
             *  system properties demo1, demo2.
             */
            System.setProperty("demo1","true");
            System.setProperty("demo2","abcd");

            // retrieve value of system properties to s1, s2
            String s1 = System.getProperty("demo1");
            String s2 = System.getProperty("demo2");

            // assign result of getBoolean on demo1, demo2 to bool1, bool2
            bool1 = Boolean.getBoolean("demo1");
            bool2 = Boolean.getBoolean("demo2");

            String str1 = "boolean value of system property demo1 is " + bool1;
            String str2 = "System property value of demo1 is " + s1;
            String str3 = "boolean value of system property demo2 is " + bool2;
            String str4 = "System property value of demo2 is " + s2;

            // print bool1, bool2 and s1, s2 values
            System.out.println( str1 );
            System.out.println( str2 );
            System.out.println( str3 );
            System.out.println( str4 );
        }
    }

}
