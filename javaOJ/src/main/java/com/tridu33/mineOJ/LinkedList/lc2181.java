package com.tridu33.mineOJ.LinkedList;

/* 题目
输入：head = [0,3,1,0,4,5,2,0]
输出：[4,11]
解释：
上图表示输入的链表。修改后的链表包含：
- 标记为绿色的节点之和：3 + 1 = 4
- 标记为红色的节点之和：4 + 5 + 2 = 11

 */

 import java.lang.*;

 public class lc2181 {
     public static void main(String[] args) {
         Solution sol = new lc2181().new Solution();
         ListNode head = new ListNode(0, new ListNode(3, new ListNode(1, new ListNode(0))));
     }


class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode pre = head, cur = head.next;
        while (cur != null) {
            if (cur.val != 0) {
                pre.val = pre.val + cur.val;
            }
            if (cur.val == 0 && cur.next != null) {
                pre = pre.next;
                pre.val = 0;
            }
            if (cur.val == 0 && cur.next == null) {
                pre.next = null;
            }
            cur = cur.next;
        }

        return head;
    }
}
 }