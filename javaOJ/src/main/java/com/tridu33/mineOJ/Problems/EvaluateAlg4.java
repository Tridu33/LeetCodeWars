package com.tridu33.mineOJ.Problems;

import java.util.*;

/*
 * https://leetcode.cn/problemset/all/?page=1&search=%E8%AE%A1%E7%AE%97%E5%99%A8
 * */
public class EvaluateAlg4
{
    public static void main(String[] args)
    {
        System.out.println("Usage: \n" +
                "Enter two line to End.\n" +
                "Example: ( ( sqrt ( 4 ) + 2 ) - ( 2 * 6 ) ).空格分隔括号神教 \n" +
                "");
        Scanner sc=new Scanner(System.in);
        String str = "";
        while(sc.hasNextLine()){
            str = sc.nextLine();
            if(str.equals("") || str.equals("#") || str.equals(";")){ break;}
//            str = standlize(str);
            String[] sVec = str.split("\\s+");
            evalDijkstra(sVec);
        }
        return;
    }
    private static void evalDijkstra(String [] sVec){
        Integer index = 0;
        Deque<String> ops = new ArrayDeque<>();
        Deque<Double> vars = new ArrayDeque<>();
        while (index <= sVec.length-1)
        { // Read token, push if operator.
            String s = sVec[index++];
            if (s.equals("(")) ;
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals("sqrt")) ops.push(s);
            else if (s.equals(")"))
            { // Pop, evaluate, and push result if token is ")".
                String op = ops.pop();
                double v = vars.pop();
                if (op.equals("+")) v = vars.pop() + v;
                else if (op.equals("-")) v = vars.pop() - v;
                else if (op.equals("*")) v = vars.pop() * v;
                else if (op.equals("/")) v = vars.pop() / v;
                else if (op.equals("sqrt")) v = Math.sqrt(v);
                vars.push(v);
            } // Token not operator or paren: push double value.
            else vars.push(Double.parseDouble(s));
        }
        System.out.println("res = "+vars.pop());
    }
}