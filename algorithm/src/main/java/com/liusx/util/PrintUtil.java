package com.liusx.util;

import com.liusx.structure.basic.ListNode;

/**
 * @author ：liusx
 * @date ：Created in 2021/12/11 17:45
 * @description：遍历输出数据结构工具类
 * @version: 1.0
 */
public class PrintUtil {


    /**
     * 将一个数组以[a,b,c,d ... ]的形式输出到控制台
     * @param arr
     */
    public static void printArr(int[] arr){
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            sb.append(",");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
    public static void printListNode(ListNode head){
        StringBuilder sb = new StringBuilder("[");
        while(head.next != null){
            sb.append(head.val);
            sb.append(" -> ");
            head = head.next;
        }
        sb.append(head.val);
        sb.append("] ");
        System.out.println(sb.toString());
    }
}
