package com.tridu33.mineOJ.Arrays.LeftRight2Points;

 /* 题目
 示例 1：

输入：plants = [2,2,3,3], capacityA = 5, capacityB = 5
输出：1
解释：
- 最初，Alice 和 Bob 的水罐中各有 5 单元水。
- Alice 给植物 0 浇水，Bob 给植物 3 浇水。
- Alice 和 Bob 现在分别剩下 3 单元和 2 单元水。
- Alice 有足够的水给植物 1 ，所以她直接浇水。Bob 的水不够给植物 2 ，所以他先重新装满水，再浇水。
所以，两人浇灌所有植物过程中重新灌满水罐的次数 = 0 + 0 + 1 + 0 = 1 。
示例 2：

输入：plants = [2,2,3,3], capacityA = 3, capacityB = 4
输出：2
解释：
- 最初，Alice 的水罐中有 3 单元水，Bob 的水罐中有 4 单元水。
- Alice 给植物 0 浇水，Bob 给植物 3 浇水。
- Alice 和 Bob 现在都只有 1 单元水，并分别需要给植物 1 和植物 2 浇水。
- 由于他们的水量均不足以浇水，所以他们重新灌满水罐再进行浇水。
所以，两人浇灌所有植物过程中重新灌满水罐的次数 = 0 + 1 + 1 + 0 = 2 。
示例 3：

输入：plants = [5], capacityA = 10, capacityB = 8
输出：0
解释：
- 只有一株植物
- Alice 的水罐有 10 单元水，Bob 的水罐有 8 单元水。因此 Alice 的水罐中水更多，她会给这株植物浇水。
所以，两人浇灌所有植物过程中重新灌满水罐的次数 = 0 。

 * */

import java.lang.*;
import java.util.*;

public class lc2105 {
    public static void main(String[] args) {
        Solution sol = new lc2105().new Solution();
        System.out.println(sol.minimumRefill(new int[]{2, 2, 3, 3}, 5, 5));

    }

    class Solution {
        public int minimumRefill(int[] plants, int capacityA, int capacityB) {
            int res = 0;   // 灌满水罐次数
            int n = plants.length;   // 两人位置
            int posa = 0, posb = n - 1;   // 两人剩余水量
            int vala = capacityA, valb = capacityB;
            // 模拟相遇前的浇水过程
            while (posa < posb) {
                if (vala < plants[posa]) {
                    ++res;
                    vala = capacityA - plants[posa];
                } else {
                    vala -= plants[posa];
                }
                ++posa;
                if (valb < plants[posb]) {
                    ++res;
                    valb = capacityB - plants[posb];
                } else {
                    valb -= plants[posb];
                }
                --posb;
            }
            // 模拟相遇后可能的浇水过程
            if (posa == posb) {
                if (vala >= valb && vala < plants[posa]) {
                    ++res;
                }
                if (vala < valb && valb < plants[posb]) {
                    ++res;
                }
            }
            return res;
        }
    }


}
