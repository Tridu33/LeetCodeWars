package com.tridu33.mineOJ.Arrays.others;


import java.lang.*;

/* @Desc:


 */
public class lc845 {
    class Solution {
        public int longestMountain(int[] arr) {
            var ans = 0;
            var left = 0;
            while (left + 2 < arr.length) { // 山脉最少需要3
                var right = left + 1;
                if (arr[left + 1] > arr[left]) { // 确保left是个山脚
                    while (right < arr.length - 1 && arr[right] < arr[right + 1]) {
                        right++;// 先将right移动到山顶
                    }
                    if (right < arr.length - 1 && arr[right] > arr[right + 1]) { // 确保right此时是山顶
                        while (right < arr.length - 1 && arr[right] > arr[right + 1]) {
                            right++; // 移动到下一个山脚
                        }
                        ans = Math.max(ans, right - left + 1);
                    } else {
                        right++;
                    }
                }
                left = right;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution sol = new lc845().new Solution();
        System.out.println(sol.longestMountain(new int[]{2, 1, 4, 7, 3, 2, 5}));
    }

}
