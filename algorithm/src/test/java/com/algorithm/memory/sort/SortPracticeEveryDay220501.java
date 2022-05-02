package com.algorithm.memory.sort;

import com.liusx.util.NumberUtil;
import com.liusx.util.PrintUtil;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author ：liusx
 * @date ：Created in 2022/5/1 16:36
 * @description：劳动节快乐
 * @version: 1.0
 */
public class SortPracticeEveryDay220501 {

    // 选择排序
    public static void selectSort1(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        // 记录每一轮遍历中的最小值的索引
        int minIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr, minIndex, i);
        }
    }

    // 冒泡排序
    public static void bubbleSort1(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        // 每次比较找出一个最大的数 放在最右边
        for (int e = arr.length - 1; e > 0; e--) {
            for (int i = 0; i < e; i++) {
                if (arr[i] > arr[i + 1]) {
                    NumberUtil.swap(arr, i, i + 1);
                }
            }
        }
    }

    // 插入排序
    public static void insertSort1(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        // 每次把新的数 插入到排好序的数组中 所以交插入排序？？？？
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                NumberUtil.swap(arr, j, j + 1);
            }
        }
    }

    // 归并排序
    public static void mergeSort1(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        process1(arr, 0, arr.length - 1);
    }

    private static void process1(int[] arr, int l, int r) {
        // 如果二分到终点 直接返回
        if (l == r) {
            return;
        }
        // 找中点
        int mid = l + ((r - l) >> 1);
        // 处理左边
        process1(arr, l, mid);
        // 处理右边
        process1(arr, mid + 1, r);
        // 合并左右处理结果
        mergeLeftAndRight1(arr, l, mid, r);
    }

    private static void mergeLeftAndRight1(int[] arr, int l, int mid, int r) {
        // 借助空间
        int[] help = new int[r - l + 1];
        // 合并数组时 左右两边的游标
        int p1 = l;
        int p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
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
    public static void quickSort1(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        quickSort1(arr, 0, arr.length - 1);
    }

    private static void quickSort1(int[] arr, int l, int r) {
        if (l < r) {
            // 随机找出来一个比较值
            int random = ThreadLocalRandom.current().nextInt(l, r);
            NumberUtil.swap(arr, random, r);
            // 分治
            int[] p = partition1(arr, l, r);
            // 递归处理排序
            quickSort1(arr, l, p[0] - 1);
            quickSort1(arr, p[1] + 1, r);
        }
    }

    // 大于比较数放左边、等于放中间、大于放右边
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
        NumberUtil.swap(arr, more, r);
        return new int[]{less + 1, more};
    }

    // 堆排
    public static void heapSort1(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        // 将数组大根堆化
        for (int i = 0; i < arr.length; i++) {
            heapInsert1(arr, i);
        }
        // 计算数组大小
        int size = arr.length;
        // 将数组第一个元素移除 放在最后面 这个就是最大的数
        NumberUtil.swap(arr, 0, --size);
        while (size > 0) {
            // 堆化
            heapify1(arr, 0, size);
            // 移除
            NumberUtil.swap(arr, 0, --size);
        }
    }

    // 堆插入 只需要比较新插入元素 和 父节点的大小
    public static void heapInsert1(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            NumberUtil.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // 堆化 需要找到两个孩子中的最大值 然后与父节点比较 依次往下
    public static void heapify1(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[index] > arr[largest] ? index : largest;
            if (index == largest) {
                break;
            }
            NumberUtil.swap(arr, index, largest);
            // index 每次都定位到本次交换的那个位置，然后那个位置网上肯定都已经比较完毕了 剩下的就是往下继续推
            index = largest;
            left = index * 2 + 1;
        }
    }

    // 桶排序
    public static void radixSort1(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        // 找出最高位 位数
        int digit = getDigitByArr(arr);
        // 定义桶
        int[][] bucket = new int[10][arr.length];
        // 存储每一个桶元素个数
        int[] bucketCount = new int[bucket.length];
        for (int d = 1, n = 1; d <= digit; d++, n = n * 10) {
            // 入桶 遍历每一个数
            for (int i = 0; i < arr.length; i++) {
                // 求出每个数在桶中的下标
                int bucketIndex = (arr[i] / n) % 10;
                // 入桶
                bucket[bucketIndex][bucketCount[bucketIndex]] = arr[i];
                // 记录桶元素个数
                bucketCount[bucketIndex]++;
            }
            // 出桶 index 为出桶时原数组的下标
            int index = 0;
            for (int i = 0; i < bucket.length; i++) {
                if (bucketCount[i] == 0) {
                    // 当前桶如果没有存储元素则直接跳过
                    continue;
                }
                // 遍历当前桶号中的所有元素 注意循环终止条件
                for (int j = 0; j < bucketCount[i]; j++) {
                    arr[index++] = bucket[i][j];
                }
                // 出桶结束后 需要将桶元素个数置为0
                bucketCount[i] = 0;
            }
        }
    }

    private static int getDigitByArr(int[] arr) {
        int max = 0;
        for (int i : arr) {
            max = max > i ? max : i;
        }
        int res = 0;
        while (max >= 1) {
            res++;
            max = max / 10;
        }
        return res;
    }

    // 选择排序
    public static void selectSort2(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        int minIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[minIndex] < arr[j] ? minIndex : j;
            }
            NumberUtil.swap(arr, i, minIndex);
        }
    }

    // 冒泡排序
    public static void bubbleSort2(int[] arr) {
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
    public static void insertSort2(int[] arr) {
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
    public static void mergeSort2(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        process2(arr, 0, arr.length - 1);
    }

    private static void process2(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        process2(arr, l, mid);
        process2(arr, mid + 1, r);
        mergeLeftAndRight2(arr, l, mid, r);
    }

    private static void mergeLeftAndRight2(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
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
    public static void quickSort2(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        quickSort2(arr, 0, arr.length - 1);
    }

    private static void quickSort2(int[] arr, int l, int r) {
        if (l < r) {
            int random = ThreadLocalRandom.current().nextInt(l, r);
            NumberUtil.swap(arr, random, r);
            int[] p = partition2(arr, l, r);
            quickSort2(arr, l, p[0] - 1);
            quickSort2(arr, p[1] + 1, r);
        }
    }

    private static int[] partition2(int[] arr, int l, int r) {
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
        NumberUtil.swap(arr, more, r);
        return new int[]{less + 1, more};
    }

    // 堆排
    public static void heapSort2(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert2(arr, i);
        }
        int size = arr.length;
        NumberUtil.swap(arr, 0, --size);
        while (size > 0) {
            heapify2(arr, 0, size);
            NumberUtil.swap(arr, 0, --size);
        }
    }

    public static void heapInsert2(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            NumberUtil.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify2(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            NumberUtil.swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    // 桶排序
    public static void radixSort2(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        int digit = getDigitByArr2(arr);
        int[][] bucket = new int[10][arr.length];
        int[] bucketCount = new int[bucket.length];

        for (int d = 1, n = 1; d <= digit; d++, n = n * 10) {
            // 入桶遍历 所有的元素
            for (int i = 0; i < arr.length; i++) {
                int bucketIndex = (arr[i] / n) % 10;
                bucket[bucketIndex][bucketCount[bucketIndex]] = arr[i];
                bucketCount[bucketIndex]++;
            }
            int index = 0;
            // 出桶遍历 所有的桶
            for (int i = 0; i < bucket.length; i++) {
                if (bucketCount[i] == 0) {
                    continue;
                }
                for (int j = 0; j < bucketCount[i]; j++) {
                    arr[index++] = bucket[i][j];
                }
                bucketCount[i] = 0;
            }
        }
    }

    private static int getDigitByArr2(int[] arr) {
        int max = 0;
        for (int i : arr) {
            max = max > i ? max : i;
        }
        int res = 0;
        while (max >= 1) {
            res++;
            max = max / 10;
        }
        return res;
    }

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
            radixSort2(arr1);
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
        radixSort2(arr);
        PrintUtil.printArr(arr);
    }

}
