package com.liusx.structure.basic;

/**
 * @author ：liusx
 * @date ：Created in 2021/11/24 20:09
 * @description：链表数据结构
 * @version: 1.0
 */

public class ListNode {

    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
        this.next = null;
    }

    static void traverse(ListNode head) {
        for (ListNode p = head; p != null; p = p.next) {
            //迭代访问 p.val
            System.out.println("p.val is = " + p.val);
        }
    }


    static void traverseRecur(ListNode head){
        //递归访问 head.val
        traverse(head.next);
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        traverseRecur(head);

    }

}
