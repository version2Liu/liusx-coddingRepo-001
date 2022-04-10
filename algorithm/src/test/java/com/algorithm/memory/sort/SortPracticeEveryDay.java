package com.algorithm.memory.sort;

import com.liusx.util.NumberUtil;
import com.liusx.util.PrintUtil;

import java.util.Arrays;

/**
 * @author ：liusx
 * @date ：Created in 2022/3/27 21:08
 * @description：一日一练一日功，一日不练十日空
 * @version: 1.0
 */
public class SortPracticeEveryDay {

    //选择排序
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
            NumberUtil.swap(arr, i, minIndex);
        }
    }

    //冒泡排序
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

    //插入排序
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

    //归并排序
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
        int mid = l + (r - l) / 2;
        process1(arr, l, mid);
        process1(arr, mid + 1, r);
        mergeLAndR1(arr, l, mid, r);
    }

    private static void mergeLAndR1(int[] arr, int l, int mid, int r) {
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

    //快排
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
        NumberUtil.swap(arr, more, r);
        return new int[]{less + 1, more};
    }

    //堆排
    public static void heapSort1(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify1(arr, i, arr.length);
        }
        int size = arr.length;
        NumberUtil.swap(arr, 0, --size);
        while (size > 0) {
            heapify1(arr, 0, size);
            NumberUtil.swap(arr, 0, --size);
        }
    }

    public static void heapInsert1(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            NumberUtil.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify1(int[] arr, int index, int size) {
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

    //选择排序
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
            NumberUtil.swap(arr, i, minIndex);
        }
    }

    //冒泡排序
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

    //插入排序
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

    //归并排序
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
        int mid = l + (r - l) / 2;
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

    //快排
    public static void quickSort2(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        quickSort2(arr, 0, arr.length - 1);
    }

    private static void quickSort2(int[] arr, int l, int r) {
        if (l < r) {
            int random = l + (int) Math.random() * (r - l);
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

    //堆排
    public static void heapSort2(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify2(arr, i, arr.length);
        }
        int size = arr.length;
        NumberUtil.swap(arr, 0, --size);
        while (size > 0) {
            heapify2(arr, 0, size);
            NumberUtil.swap(arr, 0, --size);
        }
    }

    //比较的时候父节点和插入当前节点的大小
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
            largest = arr[index] > arr[largest] ? index : largest;
            if (largest == index) {
                break;
            }
            NumberUtil.swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }


    //选择排序
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

    //冒泡排序
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

    //插入排序
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

    //归并排序
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
        int mid = l + (r - l) / 2;
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

    //快排
    public static void quickSort3(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        quickSort3(arr, 0, arr.length - 1);
    }

    private static void quickSort3(int[] arr, int l, int r) {
        if (l < r) {
            int random = l + (int) Math.random() * (r - l);
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

    //堆排
    public static void heapSort3(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify3(arr, i, arr.length);
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
            if (index == largest) {
                break;
            }
            NumberUtil.swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    //改造思路就是加开关，所有跟刷单相关的逻辑都加上开关，这样就不会影响线上逻辑就算合并代码到线上也没事
    //选择排序
    public static void selectSort4(int[] arr) {
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

    //冒泡排序
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

    //插入排序
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

    //归并排序
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

    //快排
    public static void quickSort4(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        quickSort4(arr, 0, arr.length - 1);
    }

    private static void quickSort4(int[] arr, int l, int r) {
        if (l < r) {
            int random = l + (int) Math.random() * (r - l);
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

    //堆排
    public static void heapSort4(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify4(arr, i, arr.length);
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

    //选择排序
    public static void selectSort5(int[] arr) {
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

    //冒泡排序
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

    //插入排序
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

    //归并排序
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

    //快排
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

    //堆排
    public static void heapSort5(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
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

    public static void heapInsert5(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            NumberUtil.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify5(int[] arr, int index, int size) {
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

    //选择排序
    public static void selectSort6(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        int minIndex;
        for (int i = 0; i < arr.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            //每次都要找出一个最小的 然后交换位置 破坏了排序的稳定性
            NumberUtil.swap(arr, i, minIndex);
        }
    }

    //冒泡排序
    public static void bubbleSort6(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int e = arr.length - 1; e > 0; e--) {
            for (int i = 0; i < e; i++) {
                if (arr[i] > arr[i + 1]) {
                    //只有大于才会交换 等于不会变 保证了数组的稳定性
                    NumberUtil.swap(arr, i, i + 1);
                }
            }
        }
    }

    //插入排序
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

    //归并排序
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
        int mid = l + ((r - l) >> 1) / 2;
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

    //快排
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

    //堆排
    public static void heapSort6(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify6(arr, i, arr.length);
        }
        int size = arr.length;
        NumberUtil.swap(arr, 0, --size);
        while (size > 0) {
            heapify6(arr, 0, size);
            NumberUtil.swap(arr, 0, --size);
        }
    }

    public static void heapInsert6(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            NumberUtil.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify6(int[] arr, int index, int size) {
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

    //桶排序
    public static void radixSort1(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        //找到最大的数
        int max = getMaxByArr(arr);
        //找到最大的数的位数
        int digit = getDigitByNum(max);
        //兼容负数的情况 需要设置20个桶 0-9 存放负数 10-19 存放正数
        int[][] bucket = new int[20][arr.length];
        int[] bucketCount = new int[bucket.length];

        for (int d = 1, n = 1; d <= digit; d++, n = n * 10) {
            //入桶
            for (int i = 0; i < arr.length; i++) {
                int bucketIndex = (arr[i] / n) % 10;
                //bucketIndex 的取值范围就是[-9,-8,-7,...,-1,-2,-3,0,1,2,3,...,7,8,9]
                if (arr[i] < 0) {
                    bucketIndex = Math.abs(bucketIndex);
                } else {
                    bucketIndex += 10;
                }
                bucket[bucketIndex][bucketCount[bucketIndex]] = arr[i];

                bucketCount[bucketIndex]++;
            }
            int index = 0;
            //出桶
            for (int i = 9; i >= 0; i--) {
                if (bucketCount[i] == 0) {
                    continue;
                }
                for (int j = 0; j < bucketCount[i]; j++) {
                    arr[index++] = bucket[i][j];
                }
                bucketCount[i] = 0;
            }
            for (int i = 10; i < bucket.length; i++) {
                if (bucketCount[i] == 0) {
                    continue;
                }
                //对于正数应该是从0号桶开始出桶
                for (int j = 0; j < bucketCount[i]; j++) {
                    arr[index++] = bucket[i][j];
                }

                bucketCount[i] = 0;
            }
//            System.out.println("第 " + d + "轮排序后：" + Arrays.toString(arr));
        }
    }

    private static int getDigitByNum(int max) {
        int res = 0;
        while (max >= 1) {
            max = max / 10;
            res++;
        }
        return res;
    }

    private static int getMaxByArr(int[] arr) {
        int max = 0;
        for (int i : arr) {
            max = i > max ? i : max;
        }
        return max;
    }


    //选择排序
    public static void selectSort7(int[] arr) {
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

    //冒泡排序
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

    //插入排序
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

    //归并排序
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

    //快排
    public static void quickSort7(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        quickSort7(arr, 0, arr.length - 1);
    }

    private static void quickSort7(int[] arr, int l, int r) {
        if (l < r) {
            int random = l + (int) Math.random() * (r - l);
            NumberUtil.swap(arr, random, r);
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

    //堆排
    public static void heapSort7(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify7(arr, i, arr.length);
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

    //桶排序
    public static void radixSort2(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        int digit = getDigitByArr(arr);

        int[][] bucket = new int[10][arr.length];
        int[] bucketCount = new int[bucket.length];

        for (int d = 1, n = 1; d <= digit; d++, n = n * 10) {
            //入桶
            for (int i = 0; i < arr.length; i++) {
                int bucketIndex = (arr[i] / n) % 10;
                bucket[bucketIndex][bucketCount[bucketIndex]] = arr[i];
                bucketCount[bucketIndex]++;
            }
            //出桶
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
            max = i > max ? i : max;
        }
        int res = 0;
        while (max != 0) {
            max = max / 10;
            res++;
        }
        return res;
    }


    //选择排序
    public static void selectSort8(int[] arr) {
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

    //冒泡排序
    public static void bubbleSort8(int[] arr) {
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

    //插入排序
    public static void insertSort8(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                NumberUtil.swap(arr, j, j + 1);
            }
        }
    }

    //归并排序
    public static void mergeSort8(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        process8(arr, 0, arr.length - 1);
    }

    private static void process8(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        process8(arr, l, mid);
        process8(arr, mid + 1, r);
        mergeLeftAndRight8(arr, l, mid, r);
    }

    private static void mergeLeftAndRight8(int[] arr, int l, int mid, int r) {
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

    //快排
    public static void quickSort8(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        quickSort8(arr, 0, arr.length - 1);
    }

    private static void quickSort8(int[] arr, int l, int r) {
        if (l < r) {
            int random = l + (int)Math.random()*(r - l);
            NumberUtil.swap(arr, random, r);
            int[] p = partition8(arr, l, r);
            quickSort8(arr, l, p[0] - 1);
            quickSort8(arr, p[1] + 1, r);
        }
    }

    private static int[] partition8(int[] arr, int l, int r) {
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
    //堆排
    public static void heapSort8(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 0; i < arr.length; i++){
            heapInsert8(arr,i);
        }
        int size = arr.length;
        NumberUtil.swap(arr,0,--size);
        while (size > 0){
            heapify8(arr,0,size);
            NumberUtil.swap(arr,0,--size);
        }
    }
    public static void heapInsert8(int[] arr,int index){
        while(arr[index] > arr[(index - 1) / 2]){
            NumberUtil.swap(arr,index,(index - 1) / 2);
            index = (index - 1) / 2;
        }
    }
    public static void heapify8(int[] arr,int index,int size){
        int left = index * 2 + 1;
        while(left < size){
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[index] > arr[largest] ? index : largest;
            while(index == largest){
                break;
            }
            NumberUtil.swap(arr,index,largest);
            index = largest;
            left = index * 2 + 1;
        }
    }
    //桶排序
    public static void radixSort8(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        //找到最大的位数
        int digit = getDigitByArr8(arr);

        int[][] bucket = new int[10][arr.length];
        int[] bucketCount = new int[bucket.length];

        for(int d = 1,n=1;d <= digit;d++,n = n*10) {
            //开始入桶
            for (int i = 0; i < arr.length; i++) {
                int bucketIndex = (arr[i] / n) % 10;
                bucket[bucketIndex][bucketCount[bucketIndex]] = arr[i];
                bucketCount[bucketIndex]++;
            }
            ///出桶
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
//            System.out.println("第 "+ d + " 轮比较结果" + Arrays.toString(arr));
        }
    }
    private static int getDigitByArr8(int[] arr) {
        int max = 0;
        for (int i : arr) {
            max = max > i ? max : i;
        }
        int res = 0;
        while(max >= 1){
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
            quickSort8(arr1);
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
        quickSort8(arr);
        PrintUtil.printArr(arr);
    }

}
