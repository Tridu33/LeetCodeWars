package com.tridu33.mineOJ.Greedy;
/**
 * 
 */

import java.lang.*;
import java.util.*;

/* @Desc:


 */
public class lc860 {
    public static void main(String[] args) {
        Solution sol = new lc860().new Solution();
        System.out.println(sol.lemonadeChange(new int[]{
                5, 5, 5, 10, 20
        }));
    }

    class pockets {
        int five = 0;
        int ten = 0;
        int twenty = 0;
    }

    class Solution {
        public boolean lemonadeChange(int[] bills) {
            pockets pack = new pockets();
            for (int i = 0; i < bills.length; i++) {
                switch (bills[i]) {
                    case 5:
                        pack.five++;
                        break;
                    case 10:
                        if (pack.five < 0) {
                            return false;
                        }
                        pack.five--;
                        pack.ten++;
                        break;
                    case 20:
                        if (pack.ten > 0 && pack.five > 0) {
                            pack.ten--;
                            pack.five--;
                            pack.twenty++;
                        } else if (pack.five >= 3) {
                            pack.five -= 3;
                            pack.twenty++;
                        } else {
                            return false;
                        }
                }
            }
            return true;
        }
    }
}
