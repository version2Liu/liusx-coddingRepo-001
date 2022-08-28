package com.algorithm.memory.sort;

import com.liusx.util.NumberUtil;
import com.liusx.util.PrintUtil;

/**
 * @author ：liusx
 * @date ：Created in 2022/8/3 22:47
 * @description：排序联系月份8 坚持
 * @version:
 */
public class SortPracticeEveryDayMonth08 {

    // 选择排序
    public static void selectSort1(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
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
            int random = l + (int) (Math.random() * (r - l));
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
        NumberUtil.swap(arr, more, r);
        return new int[]{less + 1, more};
    }

    // 堆排序
    public static void heapSort1(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert1(arr, i);
        }
        int size = arr.length;
        while (size > 0) {
            NumberUtil.swap(arr, 0, --size);
            heapify1(arr, 0, size);
        }
    }

    private static void heapify1(int[] arr, int index, int size) {
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

    private static void heapInsert1(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            NumberUtil.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // 桶排序
    public static void bucketSort1(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        int digit = getDigitByArr(arr);
        int[][] bucket = new int[10][arr.length];
        int[] bucketCount = new int[bucket.length];
        for (int d = 1, n = 1; d <= digit; d++, n = n * 10) {
            // 入桶
            for (int i = 0; i < arr.length; i++) {
                int bucketIndex = (arr[i] / n) % 10;
                bucket[bucketIndex][bucketCount[bucketIndex]] = arr[i];
                bucketCount[bucketIndex]++;
            }
            int index = 0;
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

    private static int getDigitByArr(int[] arr) {
        int max = 0;
        for (int i : arr) {
            max = max > i ? max : i;
        }
        int res = 0;
        while (max > 0) {
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
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr, minIndex, i);
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
            int random = l + (int) (Math.random() * (r - l));
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
        while (size > 0) {
            NumberUtil.swap(arr, 0, --size);
            heapify2(arr, 0, size);
        }
    }

    private static void heapify2(int[] arr, int index, int size) {
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

    private static void heapInsert2(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            NumberUtil.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // 桶排序
    public static void bucketSort2(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        int digit = getDigitByArr(arr);
        int[][] bucket = new int[10][arr.length];
        int[] bucketCount = new int[bucket.length];
        for (int d = 1, n = 1; d <= digit; d++, n = n * 10) {
            // 入桶
            for (int i = 0; i < arr.length; i++) {
                int bucketIndex = (arr[i] / n) % 10;
                bucket[bucketIndex][bucketCount[bucketIndex]] = arr[i];
                bucketCount[bucketIndex]++;
            }
            int index = 0;
            // 出桶
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

    // 选择排序 时间复杂度O(N2) 空间复杂度 O(1)
    public static void selectSort3(int[] arr) {
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

    // 冒泡排序 时间复杂度O(n2) 空间复杂度O(1)
    public static void bubbleSort3(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int e = arr.length - 1; e > 0; e--) {
            for (int i = 0; i < e; i++) {
                if (arr[i] > arr[i + 1]) {
                    // 交换的都是相邻的两个数字
                    NumberUtil.swap(arr, i, i + 1);
                }
            }
        }
    }

    // 插入排序 时间复杂度O(n2) 空间复杂度O(1)
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

    // 归并排序 O(NlogN) 空间复杂度 O(n)
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

    // 快排 O(NlogN) O(logN)
    public static void quickSort3(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        quickSort3(arr, 0, arr.length - 1);
    }

    private static void quickSort3(int[] arr, int l, int r) {
        if (l < r) {
            int random = l + (int) (Math.random() * (r - l));
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

    // 堆排 O(NlogN) O(1)
    public static void heapSort3(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert3(arr, i);
        }
        int size = arr.length;
        while (size > 0) {
            NumberUtil.swap(arr, 0, --size);
            heapify3(arr, 0, size);
        }
    }

    private static void heapify3(int[] arr, int index, int size) {
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

    private static void heapInsert3(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            NumberUtil.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // 桶排序
    public static void bucketSort3(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        int digit = getDigitByArr(arr);
        int[][] bucket = new int[10][arr.length];
        int[] bucketCount = new int[bucket.length];
        for (int d = 1, n = 1; d <= digit; d++, n = n * 10) {
            for (int i = 0; i < arr.length; i++) {
                int bucketIndex = (arr[i] / n) % 10;
                bucket[bucketIndex][bucketCount[bucketIndex]] = arr[i];
                bucketCount[bucketIndex]++;
            }
            int index = 0;
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
            NumberUtil.swap(arr, minIndex, i);
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
            int random = l + (int) (Math.random() * (r - l));
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
            // 肯定是跟r比较啊，因为r是选出来的随机数啊
            if (arr[l] < arr[r]) {
                NumberUtil.swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                NumberUtil.swap(arr, --more, l);
            } else {
                l++;
            }
        }
        // 把比较数字移动到范围的大于的边界处
        NumberUtil.swap(arr, more, r);
        return new int[]{less + 1, more};
    }
    // 堆排
    // 桶排序


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
            int random = l + (int) (Math.random() * (r - l));
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
        for (int i = 0; i < arr.length; i++) {
            heapInsert5(arr, i);
        }
        int size = arr.length;
        while (size > 0) {
            NumberUtil.swap(arr, 0, --size);
            hepify5(arr, 0, size);
        }
    }

    private static void hepify5(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (index == largest) {
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
    public static void bucketSort5(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        int digit = getDigitByArr(arr);
        int[][] bucket = new int[10][arr.length];
        int[] bucketCount = new int[bucket.length];
        for (int d = 1, n = 1; d <= digit; d++, n = n * 10) {
            //
            for (int i = 0; i < arr.length; i++) {
                int bucketIndex = (arr[i] / n) % 10;
                bucket[bucketIndex][bucketCount[bucketIndex]] = arr[i];
                bucketCount[bucketIndex]++;
            }
            //
            int index = 0;
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

    // 插入排序
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
            int random = l + (int) (Math.random() * (r - l));
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
        while (size > 0) {
            NumberUtil.swap(arr, 0, --size);
            heapify6(arr, 0, size);
        }
    }

    private static void heapify6(int[] arr, int index, int size) {
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

    private static void heapInsert6(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            NumberUtil.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // 桶排序
    public static void bucketSort6(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        int digit = getDigitByArr(arr);
        int[][] bucket = new int[10][arr.length];
        int[] bucketCount = new int[bucket.length];
        for (int d = 1, n = 1; d <= digit; d++, n = n * 10) {
            for (int i = 0; i < arr.length; i++) {
                int bucketIndex = (arr[i] / n) % 10;
                bucket[bucketIndex][bucketCount[bucketIndex]] = arr[i];
                bucketCount[bucketIndex]++;
            }
            int index = 0;
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
            bucketSort6(arr1);
            NumberUtil.comparator(arr2);
            if (!NumberUtil.isEqual(arr1, arr2)) {
                succeed = false;
                PrintUtil.printArr(arr1);
                PrintUtil.printArr(arr2);
                break;
            }
        }
        String method = "bucketSort6";
        System.out.println(succeed ? method + " --> 完美通过。你真是太帅了！！！！！！！！！！！" : "Oh no u are fail!");

        int[] arr = NumberUtil.generateRandomArray(maxSize, maxValue);
        PrintUtil.printArr(arr);
        bucketSort6(arr);
        PrintUtil.printArr(arr);
    }

}
