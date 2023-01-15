package com.tridu33.mineOJ.Arrays;

import java.lang.*;
import java.util.*;

public class AllSort {
    public static void main(String[] args) {
        Solution sol = new AllSort().new Solution();
        System.out.println(Arrays.toString(sol.BubbleSort(new int[]{5,1,1,2,0,0})));
        System.out.println(Arrays.toString(sol.SelectSort(new int[]{5,1,1,2,0,0})));
        System.out.println(Arrays.toString(sol.quickSort(new  int[]{5,1,1,2,0,0})));
        System.out.println(Arrays.toString(sol.insertSort(new int[]{5,1,1,2,0,0})));
        System.out.println(Arrays.toString(sol.shellSort(new int[]{5,1,1,2,0,0})));
        System.out.println(Arrays.toString(sol.mergeSort(new int[]{5,1,1,2,0,0})));
        System.out.println(Arrays.toString(sol.heapSort(new int[]{5,1,1,2,0,0})));
        /*
         * 计数排序（了解）
         * 基数排序（了解）
         * 桶排序（了解）
         * */
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    class Solution {
        public int[] BubbleSort(int[] nums) {
            int len = nums.length;
            int temp;
            for (int i = len - 1; i >= 0; i--) {
                for (int j = 1; j <= i; j++) {
                    if (nums[j] < nums[j - 1]) {
                        temp = nums[j];
                        nums[j] = nums[j - 1];
                        nums[j - 1] = temp;
                    }
                    ;
                }
                ;
            }
            return nums;
        }

        public int[] SelectSort(int[] nums) {
            int len = nums.length;
            for (int i = len - 1; i >= 0; i--) {
                int indexforcurmax = i;
                for (int j = 0; j <= i; j++) {
                    if (nums[indexforcurmax] < nums[j]) {
                        indexforcurmax = j;
                    }
                    ;
                }
                ;
                swap(nums, indexforcurmax, i);
            }
            return nums;
        }

        public int[] quickSort(int[] nums) {
            /*
             *
             * random_patition(nums,l,r)
             * */
            randomQuickSort(nums, 0, nums.length - 1);
            return nums;
        }

        private void randomQuickSort(int[] nums, int l, int r) {
            if (l < r) {
                int pos = randomPartition(nums, l, r);
                randomQuickSort(nums, l, pos - 1);
                randomQuickSort(nums, pos + 1, r);
            }
        }

        ;

        private int randomPartition(int[] nums, int l, int r) {
            int temp = new Random().nextInt(r - l + 1) + l;// l+[0,r-l+1)
            swap(nums, temp, r);
//            return partition(nums, l, r);
            return partition_easy(nums, l, r);
        }

        private int partition(int[] nums, int l, int r) {
            // l-1,            [l, ..., r-1],                 nums[r]==pivot
            // smallerLopen, tranverseIndex(smaller/bigger)
            int pivot = nums[r];
            int smallerLopen = l - 1;
            for (int tranverseIndex = l; tranverseIndex <= r - 1; tranverseIndex++) {
                if (nums[tranverseIndex] <= pivot) {
                    smallerLopen++;
                    swap(nums, smallerLopen, tranverseIndex);
                }
            }
            swap(nums, smallerLopen + 1, r);
            return smallerLopen + 1;
        }

        private int partition_easy(int nums[], int l, int r) {
            // [s, ..., e] nums[r]==pivot
            int pivot = nums[r];
            int s = l, e = r - 1;
            while (s <= e) {
                while (s <= e && nums[s] <= pivot) {
                    s++;
                }
                ;
                while (s <= e && nums[e] >= pivot) {
                    e--;
                }
                ;
                if (s <= e) {
                    swap(nums, s, e);
                }
            }
            swap(nums, s, r);
            return s;
        }

        public int[] insertSort(int[] nums) {
            int len = nums.length;
            for (int sortedRopen = 1; sortedRopen <= len - 1; sortedRopen++) {
                int var2BeInserted = nums[sortedRopen];
                int probe = sortedRopen - 1;
                while (probe >= 0 && var2BeInserted < nums[probe]) {
                    nums[probe + 1] = nums[probe];
                    probe--;
                }
                ;
                nums[probe + 1] = var2BeInserted;
            }
            ;
            return nums;
        }

        public int[] shellSort(int[] nums) {
            int len = nums.length;
            for (int gap = len / 2; gap >= 1; gap = gap / 2) {
                // gap: n/2, (n/2)/2, ..., 1
                for (int sortedRopen = gap; sortedRopen <= len - 1; sortedRopen++) {// 这里是连续的分组，下面是间隔地跳
                    int var2BeInserted = nums[sortedRopen];
                    int probe = sortedRopen - gap;
                    while (probe >= 0 && var2BeInserted < nums[probe]) {
                        nums[probe + gap] = nums[probe];
                        probe = probe - gap;
                    }
                    nums[probe + gap] = var2BeInserted;
                }
            }
            return nums;
        }

        public int[] mergeSort(int[] nums) {
            if (nums == null || nums.length == 0) {
                return nums;
            }
            ;
            mergeSortLR(nums, 0, nums.length - 1);
            return nums;
        }

        private void mergeSortLR(int[] nums, int l, int r) {
            if (l >= r) {
                return;
            }
            ;
            int mid = l + ((r - l) >> 1);
            mergeSortLR(nums, l, mid);
            mergeSortLR(nums, mid + 1, r);
            merge2sortedArray(nums, l, mid, r);
        }

        private void merge2sortedArray(int[] nums, int l, int mid, int r) {
            int[] temp = new int[r - l + 1];
            int i = 0;
            int p1 = l, p2 = mid + 1;
            // merge 2 temp nums
            while (p1 <= mid && p2 <= r) {
                temp[i++] = nums[p1] < nums[p2] ? nums[p1++] : nums[p2++];
            }
            // 2 选 1 , 执行其中一条剩下的那些
            while (p1 <= mid) temp[i++] = nums[p1++];
            while (p2 <= r) temp[i++] = nums[p2++];
            // 复制到nums数组中
            for (int j = 0; j < temp.length; j++) nums[l + j] = temp[j];
            return;
        }

        public int[] heapSort(int[] nums) {
            if (nums == null || nums.length <= 1) {
                return nums;
            }
            int len = nums.length;
            //1.构建大顶堆
            //从第一个非叶子结点 floor[(len-1)/2] 从下至上，从右至左调整结构
            for (int i = (len - 1) / 2; i >= 0; i--) {
                sink(nums, i, len - 1);
            }
            ;
            //2.交换堆顶元素与末尾元素 + 调整sink堆结构
            for (int last = len - 1; last > 0; ) {
                swap(nums, 0, last--);// put the lastest one nums[0] to the last position
                sink(nums, 0, last);
                System.out.println("=" + Arrays.toString(nums));
            }
            return nums;
        }

        /*   [0,1,2,3, ..., N=len-1]
         *   完全二叉树: 整数k = floor((2k+1 - 1)/2) = floor((2k+2 - 1)/2)
         *           k         (k-1)/2     (k-1)/2
         *         /   \        /  \        /  \
         *        2k+1 2k+2    k   k+1     k-1  k是偶数
         * */
        private void sink(int[] nums, int k, int last) {
            while ((2 * k + 1) <= last) {
                int probe = 2 * k + 1;
                if ((2 * k + 2) <= last) probe = (nums[2 * k + 1] > nums[2 * k + 2]) ? 2 * k + 1 : 2 * k + 2;
                if (nums[k] > nums[probe]) {
                    break;
                }
                swap(nums, probe, k);
                k = probe;
            }
            return;
        }
    }

}
