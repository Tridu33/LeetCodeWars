package com.tridu33.mineOJ.Arrays.stks;

import java.lang.*;
import java.util.*;

/* @Desc:


 */
public class lc1472 {
    class BrowserHistory {
        Deque<String> bStk = new ArrayDeque<>();
        Deque<String> fStk = new ArrayDeque<>();

        public BrowserHistory(String homepage) {
            bStk.offer(homepage);
        }

        public void visit(String url) {
            String top = bStk.peek();
            if (!top.equals(url)) {
                bStk.push(url);
            }
            fStk.clear();
        }

        public String back(int steps) {
            while (bStk.size()>1 && steps-- > 0) {
                fStk.push(bStk.pop());
            }
            return bStk.peek();
        }

        public String forward(int steps) {
            String res = "";
            while (!fStk.isEmpty() && steps-- > 0) {
                bStk.push(fStk.pop());
                if (!bStk.isEmpty()) {
                    res = bStk.peek();
                } else {
                    return res;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        BrowserHistory sol = new lc1472().new BrowserHistory("leetcode.com");
        sol.visit("google.com");
        sol.visit("facebook.com");
        sol.visit("youtube.com");
        System.out.println(sol.back(1));
        System.out.println(sol.back(1));
        System.out.println(sol.forward(1));
        sol.visit("linkedin.com");
        System.out.println(sol.forward(2));
        System.out.println(sol.back(2));
        System.out.println(sol.back(7));
    }

}
