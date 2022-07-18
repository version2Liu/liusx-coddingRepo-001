package com.algorithm.memory.sort;

import com.liusx.util.NumberUtil;
import com.liusx.util.PrintUtil;

/**
 * @author ：liusx
 * @date ：Created in 2022/6/20 22:32
 * @description：
 * @version:
 */
public class SortPracticeEveryDay06 {

    // 选择排序 每次找到当下的最小的数字，然后按顺序的从小到大的把找出来的数字排列好，这就完成了一次排序
    // 同理我们每次找最大的也是这个道理。但是这样的话思路和原理其实都是一样的。那么还有没有其他的方法了？
    public static void selectSort1(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        int minIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[minIndex] < arr[j] ? minIndex : j;
            }
            NumberUtil.swap(arr, minIndex, i);
        }
    }

    // 冒泡排序
    // 我们看冒泡。冒泡呢就是一个不断浮动的的过程，两两相邻的进行比较 把不符合从小到大顺序的元素都矫正过来
    // 这样一来每次都能把当前待排序数组中的最大的数字给冒泡出去。
    public static void bubbleSort1(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int e = arr.length - 1; e > 0; e--) {
            for (int i = 0; i < e; i++) {
                if (arr[i] > arr[i + 1]) {
                    NumberUtil.swap(arr, i, i + 1);
                }
            }
        }
    }

    // 插入排序
    // 插入排序是默认当前已经有了一个排好序的队列，然后我们把一个新的数字 直接插入到排好序数组的尾部
    // 然后再把这个插入完数据的数组 重新排序。实现整个数组的排序。
    // 演化一下流程就是 排好序的队列不断扩充，然后每次插入进来的这个数字都要和原版排好序的每一个数字都比较一下
    // 如果有顺序不对劲的就要给他们调整一下
    public static void insertSort1(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                NumberUtil.swap(arr, j, j + 1);
            }
        }
    }

    // 归并排序
    // 归并排序就是无限制的递归来分解待排序数组。当递归数组被分解为一个不能再分解的数的时候，就把两个递归结果合并起来
    // 无限制分解，把数组拆成越来越小的几个数，最后剩一个数的时候，合并，合并的时候谁小先合并谁
    // 递归的精髓就是每一次递归的结果都会被记录并且返回回去。
    public static void mergeSort1(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        process1(arr, 0, arr.length - 1);
    }

    private static void process1(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        process1(arr, l, mid);
        process1(arr, mid + 1, r);
        mergeLeftAndRight1(arr, l, mid, r);
    }

    private static void mergeLeftAndRight1(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = mid + 1;
        int i = 0;
        // 两边都没有越界的时候 谁小先取谁
        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 有一个越界了之后就分别对剩下的两个进行处理
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }

    // 快排
    // 快排 也是一个递归 他的递归的方式是，先把整个数组随机选取一个数字，然后大于这个数字的放在一个区域，小于这个数字的放在一个区域
    // 等于的放在一个区域，这样一圈之后，整体上，就是三块区域：小于，等于，大于。这三块的区域之间就是相对稳定的不需要再改变次序的
    // 然后呢在对每一个小于区域内部 大于区域内部 分别做上面操作 最后就全部有序了

    public static void quickSort1(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        quickSort1(arr, 0, arr.length - 1);
    }
    private static void quickSort1(int[] arr, int l, int r) {
        if (l < r) {
            int random = l + (int) Math.random() * (r - l);
            NumberUtil.swap(arr, random, r);
            int[] p = partition1(arr, l, r);
            quickSort1(arr, l, p[0] - 1);
            quickSort1(arr, p[1] + 1, r);
        }
    }
    private static int[] partition1(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                NumberUtil.swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                NumberUtil.swap(arr, --more, l);
            } else {
                l++;
            }
        }
        NumberUtil.swap(arr, r, more);
        return new int[]{less + 1, more};
    }
    // 堆排
    // 桶排序


    public static void main(String[] args) {
        pressureTest();
    }

    public static void pressureTest() {
        int testTIme = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTIme; i++) {
            int[] arr1 = NumberUtil.generateRandomArray(maxSize, maxValue);
            int[] arr2 = NumberUtil.copyArray(arr1);
            int[] arr3 = {7, 3, 2, 5};
            quickSort1(arr1);
            NumberUtil.comparator(arr2);
            if (!NumberUtil.isEqual(arr1, arr2)) {
                succeed = false;
                PrintUtil.printArr(arr1);
                PrintUtil.printArr(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Oh no u are fail!");

        int[] arr = NumberUtil.generateRandomArray(maxSize, maxValue);
        PrintUtil.printArr(arr);
        quickSort1(arr);
        PrintUtil.printArr(arr);
    }
}
