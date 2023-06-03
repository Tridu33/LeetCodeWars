package com.tridu33.mineOJ.String;
/**
 * @Date 6/4/2023$.
 */

import java.lang.*;
import java.util.*;

/* @Desc:


 */
public class lc402 {
    class Solution {
        public String removeKdigits(String num, int k) {
            Deque<Character> stack = new ArrayDeque<>(num.length());
            for(char c : num.toCharArray()){
                while(k > 0 && !stack.isEmpty() && c < stack.peek()){
                    stack.pop();
                    k--;
                }
                if( c != '0' ||
                        (!stack.isEmpty() && c=='0')){
                    stack.push(c);

                }
            }

            while( k > 0 && !stack.isEmpty()){
                stack.pop();
                k--;
            }

            StringBuffer buffer = new StringBuffer();
            while(!stack.isEmpty()){
                buffer.append(stack.pollLast());
            }

            return buffer.length() == 0 ? "0" : buffer.toString();
        }
    }
    public static void main(String[] args) {
        Solution sol = new lc402().new Solution();
        System.out.println(sol.removeKdigits("1432219",3));
    }

}
