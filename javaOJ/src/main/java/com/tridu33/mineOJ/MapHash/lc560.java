package com.tridu33.mineOJ.MapHash;


import java.lang.*;
import java.util.*;

/* @Desc:


 */
public class lc560 {
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int res = 0, pre = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);// 和pre-k => 次数
            for (int i = 0; i < nums.length; i++) {
                pre += nums[i];
                if (map.containsKey(pre - k)) {
                    res += map.get(pre - k);
                }
                map.put(pre, map.getOrDefault(pre, 0) + 1);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new lc560().new Solution();
        System.out.println(sol.subarraySum(new int[]{1, 1, 1}, 2));
    }
}