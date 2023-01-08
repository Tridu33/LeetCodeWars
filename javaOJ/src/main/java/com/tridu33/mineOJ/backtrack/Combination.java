package com.tridu33.mineOJ.backtrack;

import java.util.*;
import java.lang.*;

public class Combination {
    public static void main(String[] args) {
        Combination.Sol sol = new Combination().new Sol();
        System.out.println(sol.combine(4, 3));
    }

    class Sol {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        public List<List<Integer>> combine(int n, int k) {
            combineHelper(n, k, 1);
            return result;
        }

        /**
         * 每次从集合中选取元素，可选择的范围随着选择的进行而收缩，调整可选择的范围，就是要靠startIndex
         *
         * @param startIndex 用来记录本层递归的中，集合从哪里开始遍历（集合就是[1,...,n] ）。
         */
        private void combineHelper(int n, int k, int startIndex) {
            //终止条件
            if (path.size() == k) {
                result.add(new ArrayList<>(path));
                return;
            }
            for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
                path.add(i);
                combineHelper(n, k, i + 1);
                path.removeLast();
            }
        }
    }
}
