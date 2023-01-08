package com.tridu33.mineOJ.LinkedList;

/*
["MyLinkedList",
"addAtHead","addAtTail","addAtIndex","get",[1],[3],[1,2],[1]
"deleteAtIndex","get","get",[1],[1],[3]
"deleteAtIndex","deleteAtIndex","get",[3],[0],[0]
"deleteAtIndex","get"], [0],[0]
* */

public class myLinkedList {
    public static void main(String[] args) {
        System.out.println("Exp5_1!");
        MyLinkedList3 obj = new MyLinkedList3();
        obj.addAtHead(1);
        obj.printlist();
        obj.addAtTail(3);
        obj.printlist();
        obj.addAtIndex(1, 2);
        obj.printlist();
        obj.get(1);
        obj.printlist();
        obj.deleteAtIndex(1);
        obj.printlist();
        obj.get(1);
        obj.get(3);
        obj.deleteAtIndex(3);
        obj.printlist();
        obj.deleteAtIndex(0);
        obj.printlist();
        obj.get(0);
        obj.deleteAtIndex(0);
        obj.printlist();
        obj.get(0);
    }
}

class ListNode3 {
    int val;
    ListNode3 next;
    ListNode3 prev;

    public ListNode3(int val) {
        val = val;
    }
}


class MyLinkedList3 {

    private int size;
    private ListNode3 vhead;
    private ListNode3 vtail;

    public MyLinkedList3() {
        size = 0;
        vhead = new ListNode3(-1);
        vtail = new ListNode3(-1);
        vtail.prev = vhead;
        vhead.next = vtail;
    }

    public void printlist() {
        ListNode3 temp = vhead;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
        ;
        System.out.println("size : " + size + "\n");
        return;
    }

    public int get(int index) {
        if (index >= size || index < 0) {
            return -1;
        }
        ListNode3 cur = vhead;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
        return;
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
        return;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        } else if (index <= 0) {
            index = 0;
            ListNode3 tempHead = vhead.next;
            vhead.next = new ListNode3(val);
            vhead.next.next = tempHead;
            size++;
            tempHead.prev = vhead.next;
            vhead.next.prev = vhead;
            return;
        }
        ListNode3 pre = vhead;
        for (int i = 0; i <= index - 1; i++) {
            pre = pre.next;
        }
        ListNode3 temp = pre.next;
        pre.next = new ListNode3(val);
        pre.next.next = temp;
        size++;
        temp.prev = pre.next;
        pre.next.prev = pre;
        return;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode3 pre = vhead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;//delete
        pre.next.prev = pre;
        size--;
        return;
    }
}


