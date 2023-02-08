package com.tridu33.mineOJ.Arrays.SlidingWindows;

import java.util.*;
import java.lang.*;

public class lc2537 {

    class Solution {

        public long countGood(int[] nums, int k) {
            long cnt = 0L;
            int l = 0, n = nums.length, pairs = 0;
            Map<Integer, Integer> number4times = new HashMap<Integer, Integer>();
            for (int r = 0; r < nums.length; r++) {
                pairs += number4times.getOrDefault(nums[r], 0);
                //第五个1，就多出来四对。10=4+3+2+1
                number4times.put(
                        nums[r],
                        1 + number4times.getOrDefault(nums[r], 0)
                );
                while (pairs >= k) {
                    // 满足条件
                    number4times.put(
                            nums[l],
                            number4times.get(nums[l]) - 1
                    );
                    pairs -= number4times.get(nums[l]);//五个1变四个1，减少四对

                    cnt += (n - r);
                    // 更新结果[l,r]到[l,n-1]均满足，有n-1-r+1 = n-r个满足的子数组。
                    // 例2有[0,5][1,6][2,6]可供调试

                    l++; // 缩小窗口
                }
            }
            return cnt;
        }
    }
}