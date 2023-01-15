package com.tridu33.mineOJ.Simulation;
/**
 * @Date 1/10/2023.
 */

import java.lang.*;
import java.util.*;

/* @Desc:
输入：
["DataStream", "consec", "consec", "consec", "consec"]
[[4, 3], [4], [4], [4], [3]]
输出：
[null, false, false, true, false]

解释：


 */
public class lc2526 {
    public static void main(String[] args) {
        /**
         * Your DataStream object will be instantiated and called as such:
         *
         */
        DataStream dataStream = new lc2526().new DataStream(4, 3); // value = 4, k = 3
        System.out.println(dataStream.consec(4)); // 数据流中只有 1 个整数，所以返回 False 。
        System.out.println(dataStream.consec(4)); // 数据流中只有 2 个整数
        // 由于 2 小于 k ，返回 False 。
        System.out.println(dataStream.consec(4)); // 数据流最后 3 个整数都等于 value， 所以返回 True 。
        System.out.println(dataStream.consec(3)); // 最后 k 个整数分别是 [4,4,3] 。
        System.out.println(dataStream.consec(4)); // 数据流中只有 1 个整数，所以返回 False 。
        System.out.println(dataStream.consec(4)); // 数据流中只有 2 个整数
        // 由于 2 小于 k ，返回 False 。
        System.out.println(dataStream.consec(4)); // 数据流最后 3 个整数都等于 value， 所以返回 True 。
        // 由于 3 不等于 value ，返回 False 。
    }

    class DataStream {
        private int value;
        private int k;
        private int count;

        public DataStream(int value, int k) {
            this.value = value;
            this.k = k;
        }

        public boolean consec(int num) {
            if (num == this.value) {
                this.count++;
            } else {
                this.count = 0;
            }
            if (this.count >= this.k) {
                return true;
            }
            return false;
        }
    }

    class DataStreamBad {

        private Deque<Integer> dq = new ArrayDeque();
        private Integer value;
        private Integer k;

        public DataStreamBad(int value, int k) {
            this.value = new Integer(value);
            this.k = new Integer(k);
        }

        public boolean consec(int num) {
            while (dq.size() >= k) {
                dq.pollFirst();
            }
            dq.addLast(num);
            if (dq.size() < k) {
                return false;
            }
            boolean flag = true;
            for (int i = 0; i < k; i++) {
                Integer cur = dq.pollFirst();
                if (!cur.equals(this.value)) {
                    flag = false;
                }
                dq.addLast(cur);
            }
            return flag;
        }
    }


}
