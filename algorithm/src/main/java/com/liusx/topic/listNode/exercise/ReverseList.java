package com.liusx.topic.listNode.exercise;

import com.liusx.structure.basic.ListNode;
import com.liusx.util.NumberUtil;

import java.util.List;


/**
 * @author ：liusx
 * @date ：Created in 2022/7/23 22:17
 * @description：反转链表习题
 * @version:
 */
public class ReverseList {

    // 递归方法 翻转链表
    ListNode reverse(ListNode head) {
        if (null == head || head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return head;
    }

    static ListNode reverseD(ListNode head) {
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

    // 递归方法 翻转链表前n个数
    ListNode nextList = null;// 后驱节点

    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            nextList = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = nextList;
        return last;
    }

    // 递归方法 翻转链表的部分数据
    ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        // 这个地方是要记录后去节点
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }


    // 反转单链表 迭代方法
    static ListNode reverse0728(ListNode head) {
        if (null == head || head.next == null) {
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

    static ListNode reverse0728N(ListNode head, int n) {
        if (n == 1) {
            // 此处就不用判断head是否等于null了。因为如果传了head为null那后面的n就没有意义了。
            // 因为head最少也得是一个节点，所以只需要判断n是否等于1即可
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (n > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            n--;
        }
        // 将反转之后的前N个链表和后续的链表接上
        // 因为当前curr的位置N+1位置 head是反转之后的链表的末尾 所以将二者相连之后，正好完美的 串起来。
        head.next = curr;
        return prev;
    }

    static ListNode reverseBetween0728(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        // 找到待排序数组的左边界-1位置
        ListNode pre = head;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        // 找到待排序数组的右边界位置
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }
        // 截取出来一个子链表
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;
        // 切断链接
        pre.next = null;
        rightNode.next = null;
        // 反转待排序链表
        reverseVoid(leftNode);

        // 接上链表
        pre.next = rightNode;
        leftNode.next = curr;
        return dummyNode.next;
    }

    // 不返回节点的反转
    static void reverseVoid(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }


    static ListNode reverse0728D(ListNode head) {
        if (null == head || head.next == null) {
            return head;
        }
        // 把第一个节点之后的数据反转成功
        ListNode last = reverse0728D(head.next);
        // 然后把第一个节点
        head.next.next = head;
        head.next = null;
        return last;
    }

    static ListNode successor0728;

    static ListNode reverse0728DN(ListNode head, int n) {
        if (n == 1) {
            // 继续递归最后一个节点的后驱节点
            successor0728 = head.next;
            return head;
        }
        // 原本链表节点数是10个，我们要排序前5个，然后递归的时候，从第二个节点递归去排好，那就是需要排第二个节点开始的钱4个节点
        ListNode last = reverse0728DN(head.next, n - 1);
        // 排好序之后，其实这个时候head.next.next是null，然后把head这个抛弃掉的尾节点挂上 就完成了前N个节点得操作
        head.next.next = head;
        // 最后在把前N个节点的尾结点挂在上后驱节点 就完成了
        head.next = successor0728;
        return last;
    }

    // 注意 n > m 所以如果m是1 难么就还是排序前n个节点
    static ListNode reverseBetween0728D(ListNode head, int m, int n) {
        if (m == 1) {
            return reverse0728DN(head, n);
        }
        head.next = reverseBetween0728(head.next, m - 1, n - 1);
        return head;
    }


    // 用迭代的当时解决问题
    static ListNode reverse0729(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            // 记录当前节点的下一个节点
            ListNode next = curr.next;
            // 当前节点下一个指向前一个节点
            curr.next = prev;
            // 指针开始向后移动
            prev = curr;
            curr = next;
        }
        // 返回的是prev 链表反转之后的头结点
        return prev;
    }

    static ListNode reverse0729N(ListNode head, int n) {
        if (n == 1) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (n > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            n--;
        }
        // 原来的头结点变成了反转之后的尾结点 尾结点接上剩下的节点 就串起来了一整个节点
        head.next = curr;
        // 返回的还是prev 他是反转之后的头结点
        return prev;
    }

    static ListNode reverse0729Between(ListNode head, int left, int right) {
        // 首先记录头结点的位置
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        // 然后找到待排序节点的左边界索引
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        // 再找右边界
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }
        // 分割左右区间
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;
        // 切断链接
        pre.next = null;
        rightNode.next = null;
        // 对中间区间进行排序
        reverseVoid(leftNode);
        // 接腿
        pre.next = rightNode;
        leftNode.next = curr;
        return dummyNode.next;
    }

    // 递归方式解决问题
    static ListNode reverse0729D(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverse0729D(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    static ListNode reverse0729DN(ListNode head, int n) {
        if (n == 1) {
            successor0728 = head.next;
            return head;
        }
        ListNode last = reverse0729DN(head.next, n - 1);
        head.next.next = head;
        head.next = successor0728;
        return last;
    }

    static ListNode reverse0729DBetween(ListNode head, int m, int n) {
        if (m == 1) {
            // 相当于反转前n个数
            return reverse0729DN(head, n);
        }
        head.next = reverse0729DBetween(head.next, m - 1, n - 1);
        return head;
    }

    // 迭代方法
    static ListNode reverse0730(ListNode head) {
        if (null == head || head.next == null) {
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

    static ListNode reverse0730N(ListNode head, int n) {
        if (n == 1) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (n > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            n--;
        }
        // 把排好序的数组末尾 跟 第N+1个节点连接起来
        head.next = curr;
        return prev;
    }

    static ListNode reverse0730Between(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        // 寻找待排序链表的左边界
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        // 寻找待排序链表的右边界
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }
        // 截取区间
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;
        // 切断链接
        pre.next = null;
        rightNode.next = null;

        // 排序
        reverseVoid(leftNode);
        // 接腿
        pre.next = rightNode;
        leftNode.next = curr;

        return dummyNode.next;
    }

    // 递归方法
    static ListNode reverse0730D(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode last = reverse0730D(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    static ListNode reverse0730DN(ListNode head, int n) {
        if (n == 1) {
            successor0728 = head.next;
            return head;
        }
        ListNode last = reverse0730DN(head.next, n - 1);
        head.next.next = head;
        head.next = successor0728;
        return last;
    }

    static ListNode reverse0730DBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverse0730DN(head, n);
        }
        ListNode next = reverse0730DBetween(head.next, m - 1, n - 1);
        head.next = next;
        return head;

    }

    // 迭代法
    static ListNode reverse0731(ListNode head) {
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

    static ListNode reverse0731N(ListNode head, int n) {
        if (n == 1) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (n > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            n--;
        }
        // 接上N+1 节点的值
        head.next = curr;
        return prev;
    }

    static ListNode reverse0731Between(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        // 找到左边界
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        // 找到右边界
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }
        // 截取数据
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;
        // 切断链接
        pre.next = null;
        rightNode.next = null;
        // 反转
        reverseVoid(leftNode);
        // 接腿
        pre.next = rightNode;
        leftNode.next = curr;
        // 返回
        return dummyNode.next;
    }

    // 递归法
    static ListNode reverse0731D(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverse0731D(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    static ListNode reverse0731DN(ListNode head, int n) {
        if (n == 1) {
            successor0728 = head.next;
            return head;
        }
        ListNode last = reverse0731DN(head.next, n - 1);
        head.next.next = head;
        head.next = successor0728;
        return last;
    }

    static ListNode reverse0731DBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverse0731DN(head, n);
        }
        ListNode next = reverse0731DBetween(head.next, m - 1, n - 1);
        head.next = next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = NumberUtil.getIntegerListNodeByNum(15);
        NumberUtil.printListNode(head);
        ListNode listNode = reverse0731DBetween(head,3,7);
        NumberUtil.printListNode(listNode);
    }


}
