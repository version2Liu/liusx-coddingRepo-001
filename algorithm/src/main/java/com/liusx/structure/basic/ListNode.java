package com.liusx.structure.basic;

/**
 * @author ：liusx
 * @date ：Created in 2021/11/24 20:09
 * @description：链表数据结构
 * @version: 1.0
 */

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }


    private void traverse(ListNode head) {
        for (ListNode p = head; p != null; p = p.next) {
            //迭代访问 p.val
            System.out.println("p.val is = " + p.val);
        }
    }

    private void traverseRecur(ListNode head) {
        //递归访问 head.val
        traverse(head.next);
    }



}
