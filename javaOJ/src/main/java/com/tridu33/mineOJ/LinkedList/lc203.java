package com.tridu33.mineOJ.LinkedList;


import java.lang.*;
import java.util.*;

/* @Desc:


 */
public class lc203 {

    class Solution {
        public ListNode removeElementsRec(ListNode head, int val) {
            if (head == null) {
                return head;
            }
            head.next = removeElements(head.next, val);
            return head.val == val ? head.next : head;
        }
        public ListNode removeElements1(ListNode head, int val) {
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;
            ListNode temp = dummyHead;
            while (temp.next != null) {
                if (temp.next.val == val) {
                    temp.next = temp.next.next;
                } else {
                    temp = temp.next;
                }
            }
            return dummyHead.next;
        }
        public ListNode removeElements(ListNode head, int val) {
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ListNode pre = dummyHead, cur = head;
            while (cur != null) {
                if (cur.val == val) {
                    pre.next = cur.next;
                    cur = cur.next;
                } else {
                    pre = cur;
                    cur = cur.next;
                }
            }
            return dummyHead.next;
        }
    }

    public static void main(String[] args) {
        Solution sol = new lc203().new Solution();
    }

}
