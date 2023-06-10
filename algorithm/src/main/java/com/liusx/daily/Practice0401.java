package com.liusx.daily;

import com.liusx.util.NumberUtil;

/**
 * @author ：liusx
 * @date ：Created in 2023/4/1 16:08
 * @description：4月1号练习
 * @version:
 */
public class Practice0401 {

    // 选择排序
    public static void selectSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            // 筛选出来一圈最小的数 就交换
            NumberUtil.swap(arr, i, minIndex);
        }
    }

    // 冒泡排序
    public static void bubbleSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        // 冒泡就是从头开始两两比较，当出现左边比右边大的时候 就交换 最后最大的数会自己默默的浮动到最右侧
        for (int e = arr.length - 1; e > 0; e--) {
            for (int i = 0; i < e; i++) {
                if (arr[i] > arr[i + 1]) {
                    NumberUtil.swap(arr, i, i + 1);
                }
            }
        }
    }

    // 插入排序
    public static void insertSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j + 1] > arr[j]; j--) {
                NumberUtil.swap(arr, j, j + 1);
            }
        }
    }

    // 归并排序
    public static void mergeSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        processSort(arr, 0, arr.length - 1);
    }

    private static void processSort(int[] arr, int l, int r) {
        // 递归到一个元素时  返回
        if (l == r) {
            return;
        }
        // 取中点位置
        int mid = l + ((r - l) >> 1);
        // 处理左部分
        processSort(arr, l, mid);
        // 处理右部分
        processSort(arr, mid + 1, r);
        // 把两部分处理结果合并起来
        mergeLeftAndRight(arr, l, mid, r);
    }

    private static void mergeLeftAndRight(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= l) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }
    // 快排
    public static void quickSort(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        quickSort(arr,0,arr.length-1);
    }
    public static void quickSort(int[] arr, int l, int r){
        if(l < r){
            int random = (int)(l + Math.random()*(r -l+1));
            NumberUtil.swap(arr,l+random,r);
            int[] p = partition(arr,l,r);
        }
    }

    private static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        return new int[]{1, 2};
    }
    // 堆排
    // 桶排序

    // 链表反转迭代
    // 链表反转递归


    // 其他练习题

}
