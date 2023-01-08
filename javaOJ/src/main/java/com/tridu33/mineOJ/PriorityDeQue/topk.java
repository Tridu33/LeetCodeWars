package com.tridu33.mineOJ.PriorityDeQue;


import java.lang.*;
import java.util.*;
public class topk {
    public static void main(String[] args) {
        Solution sol = new topk().new Solution();
        System.out.println(Arrays.toString(sol.topKFrequent(new int[]{1,1,1,2,2,3},2)));
        System.out.println(Arrays.toString(sol.topKFrequent2(new int[]{1,1,1,2,2,3},2)));

    }
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int num:nums){
                map.put(num, map.getOrDefault(num,0)+1);
            };
            Set<Map.Entry<Integer,Integer>> entries = map.entrySet();
            // small:o1-o2
            // big  :o2-o1
            Queue<Map.Entry<Integer,Integer>> minHeap =
                    new java.util.PriorityQueue<>(
                            new Comparator<Map.Entry<Integer,Integer>>(){
                                @Override
                                public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2) {
                                    return o1.getValue() - o2.getValue();
                                }
                            });
//        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>((o1,o2)->o1.getValue()-o2.getValue());
            for(Map.Entry<Integer,Integer> entry:entries){
                minHeap.offer(entry);
                if(minHeap.size() > k){
                    minHeap.poll();
                }
            };
            int [] res = new int[k];
            for(int i = k-1;i>=0;i--){
                if(minHeap.size()>0)res[i] = minHeap.poll().getKey();
            }
            return res;
        }
        public int[] topKFrequent2(int[] nums, int k) {
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int num:nums){
                map.put(num, map.getOrDefault(num,0)+1);
            };
            Set<Map.Entry<Integer,Integer>> entries = map.entrySet();
            // small小根堆:o1-o2
            // big  大根堆:o2-o1
            PriorityQueue<Map.Entry<Integer,Integer>> maxHeap =
                    new PriorityQueue<>((o1,o2)->o2.getValue()-o1.getValue());
            for(Map.Entry<Integer,Integer> entry:entries){
                maxHeap.offer(entry);
            };
            int [] res = new int[k];
            for(int i = 0;i<k;i++){
                if(maxHeap.size()>0)res[i] = maxHeap.poll().getKey();
            }
            return res;
        }
    }
}
