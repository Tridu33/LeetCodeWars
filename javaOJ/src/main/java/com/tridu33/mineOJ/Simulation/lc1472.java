package com.tridu33.mineOJ.Simulation;

/**
 * @Date 2/8/2023.
 */

import java.lang.*;
import java.util.*;
/* @Desc:
输入：
["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"]
[["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]]
输出：
[null,null,null,null,"facebook.com","google.com","facebook.com",null,"linkedin.com","google.com","leetcode.com"]

解释：
BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
browserHistory.visit("google.com");       // 你原本在浏览 "leetcode.com" 。访问 "google.com"
browserHistory.visit("facebook.com");     // 你原本在浏览 "google.com" 。访问 "facebook.com"
browserHistory.visit("youtube.com");      // 你原本在浏览 "facebook.com" 。访问 "youtube.com"
browserHistory.back(1);                   // 你原本在浏览 "youtube.com" ，后退到 "facebook.com" 并返回 "facebook.com"
browserHistory.back(1);                   // 你原本在浏览 "facebook.com" ，后退到 "google.com" 并返回 "google.com"
browserHistory.forward(1);                // 你原本在浏览 "google.com" ，前进到 "facebook.com" 并返回 "facebook.com"
browserHistory.visit("linkedin.com");     // 你原本在浏览 "facebook.com" 。 访问 "linkedin.com"
browserHistory.forward(2);                // 你原本在浏览 "linkedin.com" ，你无法前进任何步数。
browserHistory.back(2);                   // 你原本在浏览 "linkedin.com" ，后退两步依次先到 "facebook.com" ，然后到 "google.com" ，并返回 "google.com"
browserHistory.back(7);                   // 你原本在浏览 "google.com"， 你只能后退一步到 "leetcode.com" ，并返回 "leetcode.com"


 */
public class lc1472 {
    public static void main(String[] args) {
        BrowserHistory sol = new lc1472().new BrowserHistory("leetcode.com");
    }

    class BrowserHistory {
        Deque<String> s1 = new LinkedList<>();
        Deque<String> s2 = new LinkedList();
        public BrowserHistory(String homepage) {
            s1.push(homepage);
        }

        public void visit(String url) {
            s1.push(url);
            s2.clear();
        }

        public String back(int steps) {
            for(int i = 0;i < steps && s1.size() > 1;i++){
                s2.push(s1.pop());
            }
            return s1.peek();
        }

        public String forward(int steps) {
            for(int i = 0;i < steps && !s2.isEmpty();i++){
                s1.push(s2.pop());
            }
            return s1.peek();
        }
    }

}
