package com.tridu33.mineOJ.MapHash;
/**
 * @Date 6/4/2023$.
 */

import java.lang.*;
import java.util.*;

/**
 * nums[23, 2, 4, 6, 7]
 * sums[23,25,29,35,42]
 * 0, 1, 2, 3, 4
 * 当子数组从零开始[0,i]
 * sum[i]%k = 0,i>=1
 * 当sum[prevIndex]存在，子数组不从零开始
 * (sums[i]-sum[prevIndex])%k=0
 * sums[i]%k = sum[prevIndex]%k
 * hash: sum[prevIndex]%k => prevIndex
 **/
public class lc523 {
    class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            int len = nums.length;
            if (len < 2) return false;
            int[] sums = new int[len];
            sums[0] = nums[0] % k;
            for (int i = 1; i < nums.length; i++) {
                sums[i] = (sums[i - 1] + nums[i]) % k;
            }
            System.out.println(Arrays.toString(sums));
            // remainder => preIndex
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);//除了第一个元素余数为零外，剩下index>=1的只要余数为零，不需要做差，[0,index)本身子数组就有和为零，所以要加这个映射
            for (int i = 0; i < sums.length; i++) {
                if (map.containsKey(sums[i])) {
                    int prevIndex = map.get(sums[i]);
                    if (i - prevIndex >= 2) {
                        return true;
                    }
                } else {
                    map.put(sums[i], i);
                }
            }
            return false;
        }

        public boolean checkSubarraySum0(int[] nums, int k) {
            int m = nums.length;
            if (m < 2) {
                return false;
            }
            // 余数 => 第一次出现的下标
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            map.put(0, -1);
            int remainder = 0;
            for (int i = 0; i < m; i++) {
                remainder = (remainder + nums[i]) % k;
                if (map.containsKey(remainder)) {
                    int prevIndex = map.get(remainder);
                    if (i - prevIndex >= 2) {
                        return true;
                    }
                } else {
                    map.put(remainder, i);
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println((0 + 6) % 6);
        Solution sol = new lc523().new Solution();
        //        System.out.println(sol.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 13));
        System.out.println(sol.checkSubarraySum(new int[]{23, 2, 4, 6, 6}, 7));
    }
}
