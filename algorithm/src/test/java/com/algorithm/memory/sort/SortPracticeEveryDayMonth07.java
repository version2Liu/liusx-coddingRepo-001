package com.algorithm.memory.sort;

import com.liusx.util.NumberUtil;
import com.liusx.util.PrintUtil;

/**
 * @author ：liusx
 * @date ：Created in 2022/7/17 21:03
 * @description：排序练习月份7
 * @version:
 */
public class SortPracticeEveryDayMonth07 {

    // 选择排序
    public static void selectSort1(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        // 内层循环每走一遍就会选出一个最小的数字 然后跟最前面的数字交换
        int minIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            // 内层循环直接从i+1 开始
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
        // 因为判断比较的时候用到了i+1 所以这里必须是length - 1
        for (int end = arr.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    // 每次都从0开始寻找 只要左边的数字比右边的数字大 那么就交换两个数的位置
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
            // 每次把待排序的数字插入到一个已经排好序的数组中，然后再进行调整，最后得到一个排好组的数组
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
        int[] help = new int[r - l + 1];// 借助中间数组
        int p1 = l;
        int p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= r) {
            // 借助中间数组把两个递归结果数组合并到一起 谁小先移动谁 保证了算法的稳定性
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        // 所有数字都排好序并且进入到中间数字之后 将中间数组的数字移动到原数组
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
            // 每次随机找一个数字 跟数组最后一个数字交换位置 作为比较标杆
            int random = l + (int) Math.random() * (r - l);
            NumberUtil.swap(arr, random, r);
            // 根据比较标杆 将数组分割为三部分 返回的数组是中间的区域部分 不需要再做操作 两边的需要重新进行分割和交换
            int[] p = partition(arr, l, r);
            quickSort1(arr, l, p[0] - 1);
            quickSort1(arr, p[1] + 1, r);
        }
    }

    private static int[] partition(int[] arr, int l, int r) {
        // less 和 more 为区分数字大小的区域边界指针
        int less = l - 1;
        int more = r;
        // 循环终止条件为 两个边界相交
        while (l < more) {
            // 从最左边开始比较 小于放less 并且把遍历指针加1
            if (arr[l] < arr[r]) {
                NumberUtil.swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                // 大于放右边 因为右边交换过来一个数 所以遍历指针不用移动
                NumberUtil.swap(arr, --more, l);
            } else {
                // 等于就继续向下遍历
                l++;
            }
        }
        // 最后交换最后的比价数字和more
        NumberUtil.swap(arr, more, r);
        return new int[]{less + 1, more};
    }

    // 堆排
    public static void heapSort1(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert1(arr, i);
        }
        // 这里是怎么做到把第一个节点的数字移除到最后的？ 看下面的解释
        int size = arr.length;
        while (size > 0) {
            // 注意这个交换的代码中 有一个--size的动作 实际上这就是在将大根堆的大小减小
            // 数组已经成为大根堆之后，第一个数字就是最大的，此时应该把他放在最后一个 然后其余的继续去做堆化操作

            NumberUtil.swap(arr, 0, --size);
            heapify1(arr, 0, size);
        }
    }

    // 堆结构就是一个完全二叉树
    private static void heapInsert1(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            NumberUtil.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // 堆化 从上往下就行比较 比较自己和子节点的大小
    public static void heapify1(int[] arr, int index, int size) {

        int left = index * 2 + 1;
        while (left < size) {
            // 先找到子节点中最大的位置
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            // 然后比较最大的节点的和当前的节点的关系
            largest = arr[index] > arr[largest] ? index : largest;
            // 如果当前节点就是比父节点大的话 这里break 的原因是啥？？？
            if (index == largest) {
                break;
            }
            NumberUtil.swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    // todo 桶排序


    // 选择排序
    public static void selectSort2(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        // 循环一轮找出一个最小的数字 然后把他放在最前面
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
    public static void bubbleSort2(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int e = arr.length - 1; e > 0; e--) {
            for (int i = 0; i < e; i++) {
                // 如果左边的数大于右边的数 就交换这两个数
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
        // 每次都用一颗石子搅动一潭静水。扔进去一个数字之后再将秩序维持起来。就是插入排序
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
        mergeLeftAndSoft(arr, l, mid, r);
    }

    private static void mergeLeftAndSoft(int[] arr, int l, int mid, int r) {
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

    /**
     * 这么写这个方法的原因是因为想要实现一个公共的方法 对指定范围的数组进行快排
     *
     * @param arr
     * @param l
     * @param r
     */
    private static void quickSort2(int[] arr, int l, int r) {
        if (l < r) {
            int random = l + (int) Math.random() * (r - l);
            NumberUtil.swap(arr, random, r);
            int[] p = partition2(arr, l, r);
            // 得到分区函数之后 再继续对大于区域 和 小于区域进行分区。
            quickSort2(arr, l, p[0] - 1);
            quickSort2(arr, p[1] + 1, r);
        }
    }

    /**
     * 分区函数 对数组中的数字根据最后一个比较数进行分区 分为 大于 等于 小于 三个区
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int[] partition2(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                NumberUtil.swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                // 遍历指针右边的数来跟当前指针的数交换了，所以遍历指针不需要移动
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

    /**
     * 堆化 就是从根节点往下推
     *
     * @param arr
     * @param index
     * @param size
     */
    private static void heapify2(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[index] > arr[largest] ? index : largest;
            if (index == largest) {
                // 如果当前节点比自己的两个子节点都大 那就没有必要再继续往下看了。这个的前提是保证该节点往下的数都遵循二叉树的规则
                break;
            }
            NumberUtil.swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }

    }

    /**
     * 想象大根堆的插入过程，被插入的肯定是子节点，那么就需要和自己的父节点比较大小即可
     *
     * @param arr
     * @param index
     */
    private static void heapInsert2(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            // 将当前的节点交换到父节点位置
            NumberUtil.swap(arr, index, (index - 1) / 2);
            // 然后把index的值改变为当前父节点的位置 然后while继续计算当前节点的父节点
            index = (index - 1) / 2;
        }
    }

    // 桶排序
    public static void radixSort2(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        int digit = getDigitByArr(arr);
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
                // 每一个桶出完之后 需要将个数置为0
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
    public static void selectSort3(int[] arr) {
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

    // 堆排
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

    /**
     * 大根堆插入 就好比升级打怪一样，插入就要和父节点比下去，只要你大你就可以一直打下去，知道你变成根节点(没有父节点为止)
     *
     * @param arr
     * @param index
     */
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
        int digit = getDigitByArr2(arr);
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

    private static int getDigitByArr2(int[] arr) {
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
        // 内层循环每次都是从0开始遍历的 所以外层循环就不要等于0 了
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

    // 堆排
    public static void heapSort4(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert4(arr, i);
        }
        int size = arr.length;
        while (size > 0) {
            NumberUtil.swap(arr, 0, --size);
            heapify4(arr, 0, size);
        }
    }

    private static void heapify4(int[] arr, int index, int size) {
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

    private static void heapInsert4(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            NumberUtil.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // 桶排序
    public static void bucketSort4(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        int digit = getDigitByArr2(arr);
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
            NumberUtil.swap(arr, minIndex, i);
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
        for (int i = 0; i < arr.length; i++) {
            heapInsert5(arr, i);
        }
        int size = arr.length;
        while (size > 0) {
            NumberUtil.swap(arr, 0, --size);
            heapify5(arr, 0, size);
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
    public static void bucketSort5(int[] arr) {
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
    public static void selectSort6(int[] arr) {
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
            if (index == largest) {
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
            // 入桶遍历数组
            for (int i = 0; i < arr.length; i++) {
                int bucketIndex = (arr[i] / n) % 10;
                bucket[bucketIndex][bucketCount[bucketIndex]] = arr[i];
                bucketCount[bucketIndex]++;
            }
            int index = 0;
            // 出桶 遍历桶
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

    //
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
            NumberUtil.swap(arr, minIndex, i);
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

    // 插入排序
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
    public static void quickSort7(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        quickSort7(arr, 0, arr.length - 1);
    }

    private static void quickSort7(int[] arr, int l, int r) {
        if (l < r) {
            int random = l + (int) (Math.random() * (r - l));
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

    // 堆排
    public static void heapSort7(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert7(arr, i);
        }
        int size = arr.length;
        while (size > 0) {
            NumberUtil.swap(arr, 0, --size);
            heapify7(arr, 0, size);

        }
    }

    private static void heapify7(int[] arr, int index, int size) {
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

    private static void heapInsert7(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            NumberUtil.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // 桶排序
    public static void bucketSort7(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        int digit = getDigitByArr7(arr);
        int[][] bucket = new int[10][arr.length];
        int[] bucketCount = new int[bucket.length];

        for (int d = 1, n = 1; d <= digit; d++, n = n * 10) {
            // 入桶遍历桶
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

    private static int getDigitByArr7(int[] arr) {
        int max = 0;
        for (int i : arr) {
            max = max > i ? max : i;
        }
        int res = 0;
        while (max > 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    // 选择排序
    public static void selectSort8(int[] arr) {
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

    // 插入排序
    public static void insertSort8(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        // 每次都先认为已经有一部分数组是有序的，然后每次给这个数组末尾加上1 然后再将加上的数字整体进行排序。
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                NumberUtil.swap(arr, j, j + 1);
            }
        }
    }

    // 归并排序
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

    // 快排
    public static void quickSort8(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        quickSort8(arr, 0, arr.length - 1);
    }

    private static void quickSort8(int[] arr, int l, int r) {
        if (l < r) {
            int random = l + (int) (Math.random() * (r - l));
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

    // 堆排
    public static void heapSort8(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert8(arr, i);
        }
        int size = arr.length;
        while (size > 0) {
            NumberUtil.swap(arr, 0, --size);
            heapify8(arr, 0, size);
        }
    }

    private static void heapify8(int[] arr, int index, int size) {
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

    private static void heapInsert8(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            NumberUtil.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // 桶排序
    public static void bucketSort8(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        int digit = getDigitByArr8(arr);
        int[][] bucket = new int[10][arr.length];
        int[] bucketCount = new int[bucket.length];
        for (int d = 1, n = 1; d <= digit; d++, n = n * 10) {
            // 入桶遍历数组
            for (int i = 0; i < arr.length; i++) {
                int bucketIndex = (arr[i] / n) % 10;
                bucket[bucketIndex][bucketCount[bucketIndex]] = arr[i];
                bucketCount[bucketIndex]++;
            }
            // 出桶遍历桶
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

    private static int getDigitByArr8(int[] arr) {
        int max = 0;
        for (int i : arr) {
            max = max > i ? max : i;
        }
        int res = 0;
        while (max > 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    // 选择排序
    public static void selectSort9(int[] arr) {
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
    public static void bubbleSort9(int[] arr) {
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
    public static void insertSort9(int[] arr) {
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
    public static void mergeSort9(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        process9(arr, 0, arr.length - 1);
    }

    private static void process9(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        process9(arr, l, mid);
        process9(arr, mid + 1, r);
        mergeLeftAndRight9(arr, l, mid, r);
    }

    // 合并数组的左右两部分 也可变种为 合并两个有序数组
    private static void mergeLeftAndRight9(int[] arr, int l, int mid, int r) {
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
    public static void quickSort9(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        quickSort9(arr, 0, arr.length - 1);
    }

    private static void quickSort9(int[] arr, int l, int r) {
        if (l < r) {
            int random = l + (int) (Math.random() * (r - l));
            NumberUtil.swap(arr, random, r);
            int[] p = partition9(arr, l, r);
            quickSort9(arr, l, p[0] - 1);
            quickSort9(arr, p[1] + 1, r);
        }
    }

    private static int[] partition9(int[] arr, int l, int r) {
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
    public static void heapSort9(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert9(arr, i);
        }
        int size = arr.length;
        while (size > 0) {
            NumberUtil.swap(arr, 0, --size);
            heapify9(arr, 0, size);
        }
    }

    private static void heapify9(int[] arr, int index, int size) {
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

    private static void heapInsert9(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            NumberUtil.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // 桶排序
    public static void bucketSort9(int[] arr) {
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
            heapSort9(arr1);
            NumberUtil.comparator(arr2);
            if (!NumberUtil.isEqual(arr1, arr2)) {
                succeed = false;
                PrintUtil.printArr(arr1);
                PrintUtil.printArr(arr2);
                break;
            }
        }
        String method = "heapSort9";
        System.out.println(succeed ? method + " --> 完美通过。你真是太帅了！！！！！！！！！！！" : "Oh no u are fail!");

        int[] arr = NumberUtil.generateRandomArray(maxSize, maxValue);
        PrintUtil.printArr(arr);
        heapSort9(arr);
        PrintUtil.printArr(arr);
    }
}
