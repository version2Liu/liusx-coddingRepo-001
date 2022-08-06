package com.algorithm.memory.ListNode;

import com.liusx.structure.basic.ListNode;
import com.liusx.util.NumberUtil;
import com.liusx.util.PrintUtil;

/**
 * @author ：liusx
 * @date ：Created in 2022/8/4 07:12
 * @description：链表基本功
 * @version:
 */
public class ReverseListNode08 {
    // 迭代
    static ListNode reverse0806(ListNode head){
        if(null == head || null == head.next){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while(null != curr){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // 返回翻转过后的头结点
        return prev;
    }
    static ListNode reverse0806N(ListNode head, int n){
        if(n == 1){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        // 只要前n个数没有反转完 就一直反转
        while(n > 0){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            n--;
        }
        // 反转完以后 将反转过的和没反转的接起来
        head.next = curr;
        return prev;
    }
    // 穿针引线法
    static ListNode reverse0806Between(ListNode head, int left , int right){
        // 先把链表之间的关系构建出来
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        // 找到左边界
        ListNode pre = dummyNode;
        for(int i = 0; i < left-1;i++){
            pre = pre.next;
        }
        // 找右边界
        ListNode rightNode = pre;
        for(int i = 0; i < right - left + 1;i++){
            rightNode = rightNode.next;
        }
        // 分裂
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;
        // 断开链接
        pre.next = null;
        rightNode.next = null;
        // 反转
        reverseVoid(leftNode);
        // 接腿
        pre.next = rightNode;
        leftNode.next=curr;
        return dummyNode.next;
    }

    // 递归
    static ListNode reverse0806D(ListNode head){
        if(null == head || null == head.next){
            return head;
        }
        ListNode last = reverse0806D(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
    static ListNode successor ;
    static ListNode reverse0806DN(ListNode head, int n){
        if(n == 1){
            successor = head.next;
            return head;
        }
        ListNode last = reverse0806DN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
    static ListNode reverse0806DBetween(ListNode head, int m, int n){
        if(m == 1){
            return reverse0806DN(head,n);
        }
        // 这个地方 递归的结果必须有变量记录，并且需要将 head的next指向这个记录值，是因为m==1的时候的处理结果导致的
        // m==1的时候，是把当前链表的前N个节点全部反转了，反转之后返回的是结果是链表的尾结点，因此需要记录，并且把这个尾结点和头结点接上
        // 因此有下面的两句代码。
        ListNode next = reverse0806DBetween(head.next, m - 1, n - 1);
        head.next = next;
        return head;
    }


    private static void reverseVoid(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode prev = null;
        ListNode curr = head;
        while(null != curr){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }

    public static void main(String[] args) {
        ListNode head = NumberUtil.getIntegerListNodeByNum(16);
        PrintUtil.printListNode(head);
        ListNode node = reverse0806DBetween(head,6,10);
        PrintUtil.printListNode(node);
    }

}
