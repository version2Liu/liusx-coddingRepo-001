package com.liusx.util;

import com.liusx.structure.basic.ListNode;

import java.util.Arrays;
import java.util.Random;

/**
 * @author ：liusx
 * @date ：Created in 2021/12/11 17:47
 * @description：数字工具类
 * @version: 1.0
 */
public class NumberUtil {


    public static ListNode getIntegerListNodeByNum(int size){
        ListNode head = new ListNode(1);
        ListNode next = head;
        for (int i = 1; i < size; i++) {
            ListNode node = new ListNode(i+1);
            next.next = node;
            next = node;
        }
        return head;
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

    /**
     * 交换数组中两个位置的数
     * @param arr 数组
     * @param left 左边的数的下标
     * @param right 右边的数的下标
     */
    public static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }



    /**
     * 获取指定范围内 指定 个数 的int类型数组
     * @param size 数组大小
     * @param max 数组内的最大数字
     * @return
     */
    public static int[] getIntArrBySize(int size,int max){
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = getRandomIntNumber(max);
        }
        return arr;
    }

    /**
     * 获取不大于指定数字的随机数
     * @param max
     * @return
     */
    private static int getRandomIntNumber(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }

    /**
     * 封装jdk的排序方法
     * @param arr
     */
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    /**
     * 根据入参初始化一个随机数组 数组大小随机 数组内的数字随机
     * @param maxSize 随机数组长度的最大值
     * @param maxValue 随即数组中每一个数的最大值
     * @return
     */
    public static int[] generateRandomArray(int maxSize, int maxValue){
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for(int i = 0; i < arr.length; i++){
            int num = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
//            arr[i] = Math.abs(num);
            arr[i] = num;
        }
        return arr;
    }


    /**
     * 给定一个数组，返回跟这个数组相同的一个新的数组
     * @param arr
     * @return
     */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    /**
     * 比较两个数组是否相同
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }





    public static void main(String[] args) {
//        Random random = new Random();
//        for (int i = 0; i < 100; i++) {
//            System.out.println(random.nextInt(100)+1);
//        }

        for (int i = 0; i < 10; i++) {
            int i1 = (int) ((12 + 1) * Math.random());
            System.out.println(i1);
        }
    }
}
