package com.liusx.topic.listNode.exercise;

import com.liusx.structure.basic.ListNode;

/**
 * @author ：liusx
 * @date ：Created in 2023/4/1 15:23
 * @description：链表结构练习
 * @version:
 */
public class ListNodeExercise {


    public static ListNode reverse(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }




    public static void main(String[] args) {

    }
}
