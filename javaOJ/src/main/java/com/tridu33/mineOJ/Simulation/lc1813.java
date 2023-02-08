package com.tridu33.mineOJ.Simulation;

public class lc1813 {

    class Solution {
        public boolean areSentencesSimilar(String sentence1, String sentence2) {
            String[] strs1 = sentence1.split(" "), strs2 = sentence2.split(" ");
            int n1 = strs1.length, n2 = strs2.length;
            if (n1 < n2) {
                return areSentencesSimilar(sentence2, sentence1);
            }
            int l1 = 0, point1 = n1 - 1, l2 = 0, point2 = n2 - 1;
            while (l1 < n1 && l2 < n2 &&
                    strs1[l1].equals(strs2[l2])) {
                l1++;
                l2++;
            }
            while (point1 >= 0 && point2 >= 0 &&
                    strs1[point1].equals(strs2[point2])) {
                point1--;
                point2--;
            }
            return l2 > point2;
        }
    }

}
