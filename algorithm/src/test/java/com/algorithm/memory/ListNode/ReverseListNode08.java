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
    static ListNode reverse0806(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (null != curr) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // 返回翻转过后的头结点
        return prev;
    }

    static ListNode reverse0806N(ListNode head, int n) {
        if (n == 1) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        // 只要前n个数没有反转完 就一直反转
        while (n > 0) {
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
    static ListNode reverse0806Between(ListNode head, int left, int right) {
        // 先把链表之间的关系构建出来
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        // 找到左边界
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        // 找右边界
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
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
        leftNode.next = curr;
        return dummyNode.next;
    }

    // 递归
    static ListNode reverse0806D(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode last = reverse0806D(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    static ListNode successor;

    static ListNode reverse0806DN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverse0806DN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    static ListNode reverse0806DBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverse0806DN(head, n);
        }
        // 这个地方 递归的结果必须有变量记录，并且需要将 head的next指向这个记录值，是因为m==1的时候的处理结果导致的
        // m==1的时候，是把当前链表的前N个节点全部反转了，反转之后返回的是结果是链表的尾结点，因此需要记录，并且把这个尾结点和头结点接上
        // 因此有下面的两句代码。
        ListNode next = reverse0806DBetween(head.next, m - 1, n - 1);
        // 注意此处，m和n位置处断开的链表是怎么接上的。注意：n位置的链表接上的操作是在reverse0806DN这个方法里面完成的
        // 因此我们这里只需要将 递归的结果存储上，然后把m位置的链表接上即可。
        head.next = next;
        return head;
    }


    private static void reverseVoid(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (null != curr) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }

    // 迭代
    static ListNode reverse0807(ListNode head) {
        if (head == null || head.next == null) {
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
    static ListNode reverse0807N(ListNode head, int n){
        if(n == 1){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (n >0){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            n--;
        }
        // 接上n+1节点
        head.next = curr;
        return prev;
    }
    static ListNode reverse0807Between(ListNode head, int left ,int right){
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        // 这个地方不要搞错了，节点的初始位置决定了他往下面要走几个节点的距离
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // 划定范围
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;
        // 切断
        pre.next = null;
        rightNode.next = null;
        // 反转 反转之后 头结点的next就指向空了，所以下面接腿的时候 直接把left.next 接上curr即可。
        reverseVoid(leftNode);
        // 接腿
        pre.next = rightNode;
        leftNode.next = curr;

        return dummyNode.next;
    }

    static ListNode reverse0807D(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode last = reverse0807D(head.next);
        head.next.next= head;
        head.next = null;
        return last;
    }
    static ListNode reverse0807DN(ListNode head,int n){
        if(n == 1){
            successor = head.next;
            return head;
        }
        ListNode last = reverse0807DN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
    static ListNode reverse0807DBetween(ListNode head,int m,int n){
        if(m==1){
            return reverse0807DN(head,n);
        }
        // 此处的处理思路，最终可以简化为一个子问题，那就是反转前n个数的方法，这样就容易理解了
        // reverse0807DBetween这个方法不断的递归，然后m-1n-1最后发现m=1的时候 就调用反转前n个数的方法，然后不断的进行返回
        // 最红我们将递归的结果存储住，然后接上m位置就可以了。
        ListNode next = reverse0807DBetween(head.next, m - 1, n - 1);
        head.next = next;
        return head;
    }

    // 反转链表
    static ListNode reverse0821(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    static ListNode reverse0821N(ListNode head, int n){
        if(n == 1){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while(n > 0){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            n--;
        }
        head.next = curr;
        return prev;
    }

    static ListNode reverse0821Between(ListNode head,int left, int right){
        // 找到一个虚拟节点
        ListNode dummyNode = new ListNode(-1);
        // 与当前链表挂载上
        dummyNode.next = head;
        // 定义第一个节点，用来寻找待排序链表的左侧位置
        ListNode pre = dummyNode;
        // 找到左边界
        for(int i = 0; i < left - 1; i++){
            pre = pre.next;
        }
        // 找到右边界
        ListNode rightNode = pre;
        for(int i = 0; i < right-left+1;i++){
            rightNode = rightNode.next;
        }

        // 切割
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;
        // 断开链接
        pre.next = null;
        rightNode.next=null;
        // 反转
        reverseVoid(leftNode);
        // 接腿
        pre.next = rightNode;
        leftNode.next = curr;
        return dummyNode.next;
    }

    static ListNode reverse0821D(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        // 把当前链表的 后半部分全部反转 返回反转后的链表头结点
        ListNode last = reverse0821D(head.next);
        // 将反转过的链表 和 头结点的关系重新构建 需要把头结点挂载到链表的最后
        head.next.next = head;
        // 并把链表的最后节点置空
        head.next = null;
        // 返回反转之后的链表的头结点
        return last;
    }

    static ListNode reverse0821DN(ListNode head, int n){
        if(n ==1){
            successor = head.next;
            return head;
        }
        // 链表的第一节点之后的所有节点反转
        ListNode last = reverse0821DN(head.next, n - 1);
        // 带上第一个节点
        head.next.next = head;
        // 把排好序的节点和 后续的节点连接上
        head.next = successor;
        return last;
    }
    static ListNode reverse0821DBetween(ListNode head, int m, int n){
        if(m == 1){
            return reverse0821DN(head,n);
        }
        // 递归直到问题转化为 反转链表的前N个节点
        ListNode next = reverse0821DBetween(head.next, m - 1, n - 1);
        //
        head.next = next;
        return head;

    }
    public static void main(String[] args) {
        ListNode head = NumberUtil.getIntegerListNodeByNum(16);
        PrintUtil.printListNode(head);
        ListNode node = reverse0821DBetween(head,6,11);
        PrintUtil.printListNode(node);
    }

}
