package com.tridu33.mineOJ.Simulation;
/**
 * @Date 6/4/2023$.
 */

import java.lang.*;
import java.util.*;

/* @Desc:


 */
public class lc2086 {
    class Solution {
        public int minimumBuckets(String street) {
            if ("H".equals(street) ||
                    street.startsWith("HH") ||
                    street.endsWith("HH") ||
                    street.contains("HHH")) {
                return -1;
            }

            int res = 0;
            for (char c : street.toCharArray()) {
                if (c == 'H') {
                    ++res;
                }
            }

            for (int i = 0; i < street.length() - 2; ++i) {
                if (street.charAt(i) == 'H' &&
                        street.charAt(i + 1) == '.' &&
                        street.charAt(i + 2) == 'H') {
                    --res;
                    i += 2;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new lc2086().new Solution();
        System.out.println(sol.minimumBuckets("H..H"));
    }

}
