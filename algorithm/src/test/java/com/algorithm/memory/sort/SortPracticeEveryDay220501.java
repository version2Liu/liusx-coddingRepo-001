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

    // 选择排序
    public static void selectSort3(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        int minIndex;
        for (int i = 0; i < arr.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[minIndex] < arr[j] ? minIndex : j;
            }
            NumberUtil.swap(arr, i, minIndex);
        }
    }

    // 冒泡排序
    public static void bubbleSort3(int[] arr) {
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
    public static void insertSort3(int[] arr) {
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
    public static void mergeSort3(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        process3(arr, 0, arr.length - 1);
    }

    private static void process3(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        process3(arr, l, mid);
        process3(arr, mid + 1, r);
        mergeLeftAndRight3(arr, l, mid, r);
    }

    private static void mergeLeftAndRight3(int[] arr, int l, int mid, int r) {
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
    public static void quickSort3(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        quickSort3(arr, 0, arr.length - 1);
    }

    private static void quickSort3(int[] arr, int l, int r) {
        if (l < r) {
            int random = ThreadLocalRandom.current().nextInt(l, r);
            NumberUtil.swap(arr, random, r);
            int[] p = partition3(arr, l, r);
            quickSort3(arr, l, p[0] - 1);
            quickSort3(arr, p[1] + 1, r);
        }
    }

    private static int[] partition3(int[] arr, int l, int r) {
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
    public static void heapSort3(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert3(arr, i);
        }
        int size = arr.length;
        NumberUtil.swap(arr, 0, --size);
        while (size > 0) {
            heapify3(arr, 0, size);
            NumberUtil.swap(arr, 0, --size);
        }
    }

    public static void heapInsert3(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            NumberUtil.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify3(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[index] > arr[largest] ? index : largest;
            if (largest == index) {
                break;
            }
            NumberUtil.swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }

    }

    // 桶排序
    public static void radixSort3(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        int digit = getDigitByArr3(arr);
        int[][] bucket = new int[10][arr.length];
        int[] bucketCount = new int[bucket.length];
        for (int d = 1, n = 1; d <= digit; d++, n = n * 10) {
            // 入桶遍历数组
            for (int i = 0; i < arr.length; i++) {
                int bucketIndex = (arr[i] / n) % 10;
                bucket[bucketIndex][bucketCount[bucketIndex]] = arr[i];
                bucketCount[bucketIndex]++;
            }
            int index = 0;
            // 出桶遍历桶
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

    private static int getDigitByArr3(int[] arr) {
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
    public static void selectSort4(int[] arr) {
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
    public static void bubbleSort4(int[] arr) {
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
    public static void insertSort4(int[] arr) {
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
    public static void mergeSort4(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        process4(arr, 0, arr.length - 1);
    }

    private static void process4(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        process4(arr, l, mid);
        process4(arr, mid + 1, r);
        mergeLeftAndRight4(arr, l, mid, r);
    }

    private static void mergeLeftAndRight4(int[] arr, int l, int mid, int r) {
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
    public static void quickSort4(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        quickSort4(arr, 0, arr.length - 1);
    }

    private static void quickSort4(int[] arr, int l, int r) {
        if (l < r) {
            int random = ThreadLocalRandom.current().nextInt(l, r);
            NumberUtil.swap(arr, random, r);
            int[] p = partition4(arr, l, r);
            quickSort4(arr, l, p[0] - 1);
            quickSort4(arr, p[1] + 1, r);
        }
    }

    private static int[] partition4(int[] arr, int l, int r) {
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
    public static void heapSort4(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert4(arr, i);
        }
        int size = arr.length;
        NumberUtil.swap(arr, 0, --size);
        while (size > 0) {
            heapify4(arr, 0, size);
            NumberUtil.swap(arr, 0, --size);
        }
    }

    public static void heapInsert4(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            NumberUtil.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify4(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[index] > arr[largest] ? index : largest;
            if (index == largest) {
                break;
            }
            NumberUtil.swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    // 桶排序
    public static void radixSort4(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        int digit = getDigitByArr4(arr);
        int[][] bucket = new int[10][arr.length];
        int[] bucketCount = new int[bucket.length];
        for (int d = 1, n = 1; d <= digit; d++, n = n * 10) {
            // 入桶遍历数组
            for (int i = 0; i < arr.length; i++) {
                int bucketIndex = (arr[i] / n) % 10;
                bucket[bucketIndex][bucketCount[bucketIndex]] = arr[i];
                bucketCount[bucketIndex]++;
            }
            int index = 0;
            //  出桶遍历桶
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

    private static int getDigitByArr4(int[] arr) {
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
    public static void selectSort5(int[] arr) {
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
    public static void bubbleSort5(int[] arr) {
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
    public static void insertSort5(int[] arr) {
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
    public static void mergeSort5(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        process5(arr, 0, arr.length - 1);
    }

    private static void process5(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        process5(arr, l, mid);
        process5(arr, mid + 1, r);
        mergeLeftAndRight5(arr, l, mid, r);
    }

    private static void mergeLeftAndRight5(int[] arr, int l, int mid, int r) {
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
    public static void quickSort5(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        quickSort5(arr, 0, arr.length - 1);
    }

    private static void quickSort5(int[] arr, int l, int r) {
        if (l < r) {
            int random = l + (int) Math.random() * (r - l);
            NumberUtil.swap(arr, random, r);
            int[] p = partition5(arr, l, r);
            quickSort5(arr, l, p[0] - 1);
            quickSort5(arr, p[1] + 1, r);
        }
    }

    private static int[] partition5(int[] arr, int l, int r) {
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
    public static void heapSort5(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        // 转换大根堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert5(arr, i);
        }
        int size = arr.length;
        NumberUtil.swap(arr, 0, --size);
        while (size > 0) {
            heapify5(arr, 0, size);
            NumberUtil.swap(arr, 0, --size);
        }
    }

    private static void heapify5(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[index] > arr[largest] ? index : largest;
            if (largest == index) {
                break;
            }
            NumberUtil.swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    private static void heapInsert5(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            NumberUtil.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // 桶排序
    public static void radixSort5(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        // 获取最高位数
        int digit = getDigitByArr5(arr);
        int[][] bucket = new int[10][arr.length];
        int[] bucketCount = new int[bucket.length];
        for (int d = 1, n = 1; d <= digit; d++, n = n * 10) {
            // 入桶遍历数组
            for (int i = 0; i < arr.length; i++) {
                int bucketIndex = (arr[i] / n) % 10;
                bucket[bucketIndex][bucketCount[bucketIndex]] = arr[i];
                bucketCount[bucketIndex]++;
            }
            int index = 0;
            // 出桶遍历桶
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

    private static int getDigitByArr5(int[] arr) {
        int max = 0;
        // 先找到最大的数
        for (int i : arr) {
            max = max > i ? max : i;
        }
        int res = 0;
        // 每次 除10 取余
        while (max >= 1) {
            res++;
            max = max / 10;
        }
        return res;
    }

    // 选择排序
    public static void selectSort6(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        int minIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr, i, minIndex);
        }
    }

    // 冒泡排序
    public static void bubbleSort6(int[] arr) {
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

    // 插入排序 每次都往排好序的队列中插入一个数 然后使得新产生的队列都有序 就是插入排序
    // 向一个排好序的队列中插入一个数字，就需要从队尾一直回溯到第一个数，比较检查所有的数是否都有序
    public static void insertSort6(int[] arr) {
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
    public static void mergeSort6(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        process6(arr, 0, arr.length - 1);
    }

    private static void process6(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        process6(arr, l, mid);
        process6(arr, mid + 1, r);
        mergeLeftAndRight6(arr, l, mid, r);
    }

    private static void mergeLeftAndRight6(int[] arr, int l, int mid, int r) {
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
    public static void quickSort6(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        quickSort6(arr, 0, arr.length - 1);
    }

    private static void quickSort6(int[] arr, int l, int r) {
        if (l < r) {
            int random = l + (int) Math.random() * (r - l);
            NumberUtil.swap(arr, random, r);
            int[] p = partition6(arr, l, r);
            quickSort6(arr, l, p[0] - 1);
            quickSort6(arr, p[1] + 1, r);
        }
    }

    private static int[] partition6(int[] arr, int l, int r) {
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
    public static void heapSort6(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert6(arr, i);
        }
        int size = arr.length;
        NumberUtil.swap(arr, 0, --size);
        while (size > 0) {
            heapify6(arr, 0, size);
            NumberUtil.swap(arr, 0, --size);
        }
    }

    // 插入堆结构 只需要比较新插入节点和父节点之间谁大谁小即可，因为新插入的就是子节点
    public static void heapInsert6(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            NumberUtil.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // 先找到孩子中最大的哪一个
    public static void heapify6(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[index] > arr[largest] ? index : largest;
            if (largest == index) {
                break;
            }
            NumberUtil.swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    // 桶排序
    public static void radixSort6(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        int digit = getDigitByArr6(arr);
        int[][] bucket = new int[10][arr.length];
        int[] bucketCount = new int[bucket.length];
        for (int d = 1, n = 1; d <= digit; d++, n = n * 10) {
            // 入桶遍历待排序数组
            for (int i = 0; i < arr.length; i++) {
                int bucketIndex = (arr[i] / n) % 10;
                bucket[bucketIndex][bucketCount[bucketIndex]] = arr[i];
                bucketCount[bucketIndex]++;
            }
            int index = 0;
            // 出桶遍历桶
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

    private static int getDigitByArr6(int[] arr) {
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
    public static void selectSort7(int[] arr) {
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
    public static void bubbleSort7(int[] arr) {
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

    // 插入排序 本来人家是排好序的，你非得插一个进来 然后还得麻烦人家把顺序排好  这就是插入排序
    public static void insertSort7(int[] arr) {
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
    public static void mergeSort7(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        process7(arr, 0, arr.length - 1);
    }

    private static void process7(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        process7(arr, l, mid);
        process7(arr, mid + 1, r);
        mergeLeftAndRight7(arr, l, mid, r);
    }

    private static void mergeLeftAndRight7(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 < mid) {
            help[i++] = arr[p1++];
        }
        while (p2 < r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }

    // 快排
    public static void quickSort7(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        quickSort7(arr, 0, arr.length - 1);
    }

    private static void quickSort7(int[] arr, int l, int r) {
        if (l < r) {
            // 随机找个数 交换
            int random = (int) Math.random() * (r - l);
            NumberUtil.swap(arr, r, random);
            // 然后开始做比较站队操作
            int[] p = partition7(arr, l, r);
            quickSort7(arr, l, p[0] - 1);
            quickSort7(arr, p[1] + 1, r);
        }
    }

    private static int[] partition7(int[] arr, int l, int r) {
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
    public static void heapSort7(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        // 大根堆化
        for (int i = 0; i < arr.length; i++) {
            heapInsert7(arr, i);
        }
        int size = arr.length;
        NumberUtil.swap(arr, 0, --size);
        while (size > 0) {
            heapify7(arr, 0, size);
            NumberUtil.swap(arr, 0, --size);
        }
    }

    public static void heapInsert7(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            NumberUtil.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify7(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[index] > arr[largest] ? index : largest;
            if (index == largest) {
                break;
            }
            NumberUtil.swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    // 桶排序
    public static void radixSort7(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        int digit = getDigitByArr7(arr);
        int[][] bucket = new int[10][arr.length];
        int[] bucketCount = new int[bucket.length];
        for (int d = 1, n = 1; d <= digit; d++, n = n * 10) {
            // 入桶遍历数组
            for (int i = 0; i < arr.length; i++) {
                int bucketIndex = (arr[i] / n) % 10;
                bucket[bucketIndex][bucketCount[bucketIndex]] = arr[i];
                bucketCount[bucketIndex]++;
            }
            int index = 0;
            // 出桶遍历桶
            for (int i = 0; i < bucket.length; i++) {
                if (bucketCount[i] < 0) {
                    continue;
                }
                for (int j = 0; j < bucketCount[i]; j++) {
                    arr[index++] = bucket[i][j];
                }
                bucketCount[i] = 0;
            }
        }
    }

    private static int getDigitByArr7(int[] arr) {
        int max = 0;
        for (int i : arr) {
            max = max > i ? max : i;
        }
        int res = 0;
        while (max >= 1) {
            res++;
            max = max / 10;
        }
        return 0;
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
            radixSort7(arr1);
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
        radixSort7(arr);
        PrintUtil.printArr(arr);
    }

}
