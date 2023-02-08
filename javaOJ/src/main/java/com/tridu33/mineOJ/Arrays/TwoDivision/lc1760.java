package com.tridu33.mineOJ.Arrays.TwoDivision;
import java.lang.*;
import java.util.*;

public class lc1760 {

    class Solution {
        private boolean check(int tryMid,int[] nums,int maxOperations){
            // 二分基本就是check函数不同需要根据题目来想
            int ops = 0;
            for(int i =0;i< nums.length;i++){
                ops += ((nums[i]-1)/tryMid);
            }
            return ops <= maxOperations;
        }
        public int minimumSize(int[] nums, int maxOperations) {
            // 第一步先找二分边界
            int l = 1;
            // maxOperations 很大，比如 INF 时必然分割为1，最小开销值
            int r = Arrays.stream(nums).max().getAsInt();
            // maxOperations 很大，比如 0 时最大开销值是数组中最大值

            // [l,r]中，check 函数是当前开销所需操作数ops <= maxOperation，则[xxx,v,ooo]，
            // 说明使用”寻找[xxx,v,ooo]满足 check区间[v,ooo]的最小左边界v 的二分模板：
            // 这里的模板根据左右区间开闭一般又可以各分为三种，随便选一种：
            while(l<r){
                int mid = l+r >> 1;
                if( check(mid,nums,maxOperations) ){
                    r = mid;
                }else{
                    l = mid+1;
                }
            }
            return l;
        }
    }

}
