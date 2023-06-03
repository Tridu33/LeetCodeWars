package com.tridu33.mineOJ.Arrays.others;
/**
 * @Date 1/16/2023.
 */

import java.lang.*;
import java.util.*;
/* @Desc:
示例 1：

输入：hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
输出：true
解释：Alice 手中的牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
示例 2：

输入：hand = [1,2,3,4,5], groupSize = 4
输出：false
解释：Alice 手中的牌无法被重新排列成几个大小为 4 的组。

 */
public class lc846 {
    public static void main(String[] args) {
        Solution sol = new lc846().new Solution();
        boolean res = sol.isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8},3);
        System.out.println(res);
    }

    class Solution {
        public boolean isNStraightHand(int[] hand, int groupSize) {
            if (hand.length % groupSize != 0) {
                return false;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < hand.length; i++) {
                map.put(hand[i], 1 + map.getOrDefault(hand[i], 0));
            }
            int[] numSorted = new int[map.size()];
            int idx = 0;
            for (Map.Entry<Integer, Integer> entry :
                    map.entrySet()) {
                numSorted[idx++] = entry.getKey();
            }
            int[] counts = new int[map.size()];
            Arrays.sort(numSorted);// 升序 优先队列也可以
            for (int i = 0; i < numSorted.length; i++) {
                counts[i] = map.get(numSorted[i]);
            }
            for (int i = 0; i < numSorted.length; i++) {
                int cnt = counts[i];
                if (cnt == 0) {
                    continue;
                }// key
                for (int j = i + 0; j <= i + groupSize - 1 && i + groupSize - 1 <= numSorted.length - 1; j++) {
                    if (j + 1 <= i + groupSize - 1  && numSorted[j] > numSorted[j + 1]) {
                        return false;
                    }
                    counts[j] -= cnt;
                }
            }
            return true;
        }
    }


}
