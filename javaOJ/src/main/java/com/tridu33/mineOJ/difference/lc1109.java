package com.tridu33.mineOJ.difference;

import java.lang.*;
import java.util.*;

public class lc1109 {
    public static void main(String[] args) {
        Solution sol = new lc1109().new Solution();
        int[][]bookings =new int[][]{{1,2,10},{2,3,20},{2,5,25}};
        int n =5;
        System.out.println(Arrays.toString(sol.corpFlightBookings( bookings, n)));
    }

    class Solution {
        public int[] corpFlightBookings(int[][] bookings, int n) {
            // 1）对于原始数组arr[a, b, c, d]，其差分数组为：diff[a, b-a, c-b, d-c]

            // 2）差分数组的前缀和数组 == 原始数组，即：求差分数组的前缀和数组，即可还原回去。[a, a + b-a, a+b-a + c-b, ...]

            // 3）对原始数组的区间增加，可以转化为对其差分数组的两点增加（ O(n) -> O(1) ）：
            //    假设对arr[i ... j]区间每个元素全部增加delta，则等价于：diff[i] += delta，diff[j+1] -= delta
            int[] nums = new int[n];
            for(int[] booking:bookings){
                int l = booking[0];
                int r = booking[1];
                int inc = booking[2];
                nums[l-1] += inc;
                if(r<n){
                    nums[r]-=inc;
                }
            }
            for(int i=1;i<n;i++){
                nums[i] += nums[i-1];
            }
            return nums;
        }
    }

}