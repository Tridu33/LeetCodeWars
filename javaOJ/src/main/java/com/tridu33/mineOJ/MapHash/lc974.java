package com.tridu33.mineOJ.MapHash;


import java.lang.*;
import java.util.*;

/* @Desc:


 */
public class lc974 {
    class Solution {
        public int subarraysDivByK(int[] nums, int k) {
            // $P[i] mod k$
            // 前缀和模k => 出现次数
            Map<Integer, Integer> record = new HashMap<Integer, Integer>();
            record.put(0, 1);// 前缀和本身被k整除
            int sum = 0, ans = 0;
            for (int elem : nums) {
                sum += elem;
                // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
                int modulus = (sum % k + k) % k;//java不能写成modulus = total % k
                int same = record.getOrDefault(modulus, 0);
                ans += same;
                record.put(modulus, same + 1);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution sol = new lc974().new Solution();
        System.out.println(sol.subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
    }

}
