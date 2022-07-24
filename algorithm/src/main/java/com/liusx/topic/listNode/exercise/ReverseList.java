package com.liusx.topic.listNode.exercise;

import com.liusx.topic.listNode.SingleList;

import java.util.Stack;

/**
 * @author ：liusx
 * @date ：Created in 2022/7/23 22:17
 * @description：反转链表习题
 * @version:
 */
public class ReverseList {

    // fixme 这种方式行不通了，因为LeetCode不让使用栈这个结构
    // 反转单链表
    public static SingleList reverseSingleList1(SingleList<String> node) {
        // 如果是新开辟一个链表，那就是借助一个栈，先压栈在弹栈就可以完成翻转了
        if (null == node.getNext()) {
            return node;
        }
        // 该种方法借助两个额外空间。
        SingleList<String> head = node;
        Stack<String> temp = new Stack<>();

        temp.push(node.getValue());
        while (null != node.getNext()) {
            node = node.getNext();
            temp.push(node.getValue());
        }
        node = head;
        while (!temp.empty()) {
            node.setValue(temp.pop());
            node = node.getNext();
        }
        return head;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // 普通迭代方式
    public static ListNode reverseList1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        return null;
    }

    // 递归方法 翻转链表
    ListNode reverse(ListNode head) {
        if(null == head || head.next == null){
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return head;
    }

    // 递归方法 翻转链表前n个数
    ListNode successor = null;// 后驱节点
    ListNode reverseN(ListNode head,int n) {
        if(n == 1){
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    // 递归方法 翻转链表的部分数据
    ListNode reverseBetween(ListNode head,int m,int n) {
        if(m == 1){
            return reverseN(head,n);
        }
        // 这个地方是要记录后去节点
        head.next = reverseBetween(head.next,m-1,n-1);
        return head;
    }




    public static void main(String[] args) {
        SingleList<String> node1 = new SingleList<>();
        node1.setValue("1");
        SingleList<String> node2 = new SingleList<>();
        node2.setValue("2");
        SingleList<String> node3 = new SingleList<>();
        node3.setValue("3");
        SingleList<String> node4 = new SingleList<>();
        node4.setValue("4");
        SingleList<String> node5 = new SingleList<>();
        node5.setValue("5");
        SingleList<String> node6 = new SingleList<>();
        node6.setValue("6");
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);

        ssout(node1);
        SingleList node7 = reverseSingleList1(node1);
        ssout(node7);
        System.out.println(node7);
    }

    private static void ssout(SingleList<String> node1) {
        StringBuilder sb = new StringBuilder("{");
        while (node1.getNext() != null) {
            sb.append(node1.getValue());
            node1 = node1.getNext();
            sb.append(" -> ");
        }
        sb.append(node1.getValue());
        sb.append("}");
        System.out.println(sb.toString());
    }


    // 反转双链表


}
