package com.liusx.topic.sort;

import java.util.Arrays;

/**
 * @author ：liusx
 * @date ：Created in 2022/4/5 15:21
 * @description：基数排序
 * @version:
 */
public class RadixSort {
    /***
     * 基数排序的思想：将所有待排序的数字，找出最大的数确定整体位数，位数是几就需要操作几个进出桶的操作。
     * 操作的开始是从最低位各位来开始的，一次是十位，百位。。。。。
     * 每次根据每一轮的位数上的值确定好在哪一个桶中之后，再出桶，出桶的时候先入桶的元素先出桶。然后接着进行高位的操作。
     */

    //接着我们先来一遍推导过程
    public static void processDemo() {
        int arr[] = {53, 3, 542, 748, 14, 214};
        System.out.println("原始数组为：" + Arrays.toString(arr));
        processRadixSort(arr);
    }

    private static void processRadixSort(int[] arr) {
        // 定义10个桶，每一个桶是一个一维数组 因为并不知道每个桶中的数据长度，所以先将每个桶的长度声明为 待排序数组的长度。
        int[][] buckets = new int[10][arr.length];
        // 定义一个数组，记录每一个桶中有效的数据的个数
        int[] bucketCounts = new int[buckets.length];

        // 开始第一轮 从个位数进行切割并入桶
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i] % 10;
            buckets[temp][bucketCounts[temp]] = arr[i];
            bucketCounts[temp]++;
        }
        // 先入桶的数据线出桶 依次取出桶中的数据 放回原来的数组
        int index = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (bucketCounts[i] == 0) {
                //有效数字大小为0 表示这个位数上没有数据
                continue;
            }
            for (int j = 0; j < bucketCounts[i]; j++) {
                arr[index++] = buckets[i][j];
            }
            //取完数据后，要重置每个桶的有效数据个数
            bucketCounts[i] = 0;
        }
        System.out.println("第一轮排序后：" + Arrays.toString(arr));

        //第二轮比较十位数字
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i] / 10 % 10;
            buckets[temp][bucketCounts[temp]] = arr[i];
            bucketCounts[temp]++;
        }
        //在出桶的时候 标识当前出桶的数据情况
        index = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (bucketCounts[i] == 0) {
                continue;
            }
            for (int j = 0; j < bucketCounts[i]; j++) {
                arr[index++] = buckets[i][j];
            }
            bucketCounts[i] = 0;
        }
        System.out.println("第二轮排序：" + Arrays.toString(arr));

        //开始第三轮
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i] / 100 % 10;
            buckets[temp][bucketCounts[temp]] = arr[i];
            bucketCounts[temp]++;
        }
        index = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (bucketCounts[i] == 0) {
                continue;
            }
            for (int j = 0; j < bucketCounts[i]; j++) {
                arr[index++] = buckets[i][j];
            }
            bucketCounts[i] = 0;
        }
        System.out.println("第三轮比较后:" + Arrays.toString(arr));
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{38, 4, 52, 19, 12376, 2, 63, 100, 1001, 5899, 2};
//        System.out.println(Arrays.toString(arr));
//        radixSort(arr);
//        System.out.println(Arrays.toString(arr));

        int a = -50;
        System.out.println(a % 10);
    }

    //正常逻辑的桶排序实现
    public static void radixSortNormal(int[] arr) {
        // 获取数组中最大的数
        int max = getMaxByArr(arr);
        // 获取最大的数的位数
        int digits = getDigitsByNum(max);
        // 定义桶 以及 标识桶中元素个数的数组
        int[][] bucket = new int[10][arr.length];
        int[] bucketCount = new int[bucket.length];
        // 循环执行digits次 k记录循环执行次数 n是为了每一次出入桶 数组中的数取哪一位来做辅助的
        for (int k = 1, n = 1; k <= digits; k++, n = n * 10) {
            // 进行桶排序
            for (int i = 0; i < arr.length; i++) {
                // 获取本轮出入桶数据在桶中的位置
                int bucketIndex = (arr[i] / n) % 10;
                // 入桶
                bucket[bucketIndex][bucketCount[bucketIndex]] = arr[i];
                // 标识对应位数存入的数字个数
                bucketCount[bucketIndex]++;
            }
            //出桶时 原数组下标索引
            int index = 0;
            //出桶
            for (int i = 0; i < bucket.length; i++) {
                if (bucketCount[i] == 0) {
                    continue;
                }
                for (int j = 0; j < bucketCount[i]; j++) {
                    arr[index++] = bucket[i][j];
                }
                //每次出桶之后需要将原数组下标置为0
                bucketCount[i] = 0;
            }
            System.out.println("第" + k + "轮排序后：" + Arrays.toString(arr));
        }

    }

    /**
     * 获取一个数字的位数有多少
     *
     * @param max
     * @return
     */
    private static int getDigitsByNum(int max) {
        int i = 0;
        while (max >= 1) {
            max = max / 10;
            i++;
        }
        return i;
    }

    /**
     * 获取一个数组中的最大的数
     *
     * @param arr
     * @return
     */
    private static int getMaxByArr(int[] arr) {
        int max = arr[0];
        for (int i : arr) {
            max = max > i ? max : i;
        }
        return max;
    }

    public static void radixSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxBits(arr));
    }

    private static void radixSort(int[] arr, int begin, int end, int digit) {
        final int radix = 10;
        int i = 0, j = 0;

        int[] bucket = new int[end - begin + 1];
        for (int d = 1; d <= digit; d++) {
            int[] count = new int[radix];
            for (i = begin; i <= end; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }
            for (i = end; i >= begin; i--) {
                j = getDigit(arr[i], d);
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }
            for (i = begin, j = 0; i <= end; i++, j++) {
                arr[i] = bucket[j];
            }
        }

    }

    private static int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }

    private static int maxBits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

}
