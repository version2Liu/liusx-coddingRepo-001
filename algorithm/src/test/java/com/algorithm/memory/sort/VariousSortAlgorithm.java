package com.algorithm.memory.sort;

import com.liusx.topic.sort.InsertSort;
import com.liusx.util.NumberUtil;
import com.liusx.util.PrintUtil;

/**
 * @author ：liusx
 * @date ：Created in 2021/12/17 14:43
 * @description：各种排序算法思路回忆 手法练习
 * @version: 1.0
 */
public class VariousSortAlgorithm {

    /**
     * 选择排序
     * 每次找到一个最大的数 把它放在最左侧
     *
     * @param arr
     */
    public static void selectionSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) { //第一个循环 遍历 0 ~ N-1
            int minIndex = i; //最小数字下标
            for (int j = i + 1; j < arr.length; j++) {
                //内层循环遍历寻找最小数值 的下标
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            //一层循环结束后，交换位置。
            NumberUtil.swap(arr, i, minIndex);
        }
    }

    /**
     * 两两比较 如果发现有相邻两个数中左边数大于右边的数 就把大数移动到右边
     * 所以指针的移动就是应该由最右边开始 每次循环之后，右边都会多一个最大的数
     * 为什么这样移动 最大的那个数字一定会被移动到右边呢？？？？
     * 这样移动的特点就是 每次都能把剩下数里面最大的数移动到右边
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        //对 0 ~ length-1 的数进行两两比较 右边界就是最后一个数
        for (int e = arr.length - 1; e > 0; e--) {
            for (int i = 0; i < e; i++) {
                if (arr[i] > arr[i + 1]) {
                    NumberUtil.swap(arr, i, i + 1);
                }
            }
        }
    }


    //选择排序 双层循环 内层循环每次找出来当前最小的一个数，放在最左边
    //做算法题 想好起始条件，想好终止条件(终止条件其实就是边界问题) 这个问题中边界问题就是保证内层循环不要越界
    public static void selectSort1(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {//保证内层循环不越界
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr, i, minIndex);
        }
    }

    //冒泡排序 如果发现有左边的数 比右边的数大的，就把这两个数交换一下
    public static void bubbleSort1(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int e = arr.length - 1; e > 0; e--) {// 防止下方i+1 越界 所以e是最外层的屏障
            for (int i = 0; i < e; i++) {
                if (arr[i] > arr[i + 1]) {
                    NumberUtil.swap(arr, i, i + 1);
                }
            }
        }
    }

    //选择排序每次找最大的，放在最左边，双层循环，注意下标悦姐问题
    public static void selectSort2(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr, i, minIndex);
        }
    }

    // 双层循环 如果发现左边数比右边数大 就移动位置
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

    //选择排序，双层循环 内层每次找到一个最小的数字 放在最左侧
    public static void selectSort3(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr, i, minIndex);
        }
    }

    //冒泡排序 如果存在左侧大于右侧的数，就把两个数交换位置
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

    //选择排序 双层循环 选出最小的数字放在最左边 重点循环条件
    public static void selectSort4(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr, i, minIndex);
        }
    }

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

    //选择排序每次找到最小的数字 放在最左侧
    public static void selectSort5(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            //内侧循环执行一遍 找出来一个最小的数字 j从i+1开始，因为已经移动到左侧的数字就不用判断了
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr, i, minIndex);
        }
    }

    //冒泡排序 只要存在左侧数字大于右侧数字 就把两者交换位置
    public static void bubbleSort5(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        //这个说是不着最大，其实冒泡一次，就会有一个最大的数移动到最右边。
        for (int e = arr.length - 1; e > 0; e--) {
            for (int i = 0; i < e; i++) {
                if (arr[i] > arr[i + 1]) {
                    NumberUtil.swap(arr, i, i + 1);
                }
            }
        }
    }

    //插入排序，保证0 ~ N 之间的数 都有序 双层循环，外层控制的是 0~N中的N
    public static void insertSort1(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        // 0~0 只有一个数字，不需要保证，直接从1开始
        // 0~n 注意内存循环的终止条件 j>=0并且 左边的数还比右边的数大 那就交换
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                NumberUtil.swap(arr, j, j + 1);
            }
        }
    }

    //选择排序，每次寻找最小数移动到最左侧
    public static void selectSort6(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr, i, minIndex);
        }
    }

    //存在左侧数字比右侧数字大 就把两个数字交换，最后最大的一个数字会移动到最右侧
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

    //插入排序要做到0~N每一个范围内的数字都有序 所以双层循环 外层循环控制范围 内层循环控制有序 无需就交换
    //当
    public static void insertSort2(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        //从第一个数字开始 比较 0-1之间是否有序
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                NumberUtil.swap(arr, j, j + 1);
            }
        }
    }

    //选择排序 每次找出最小值然后放在最左边
    public static void selectSort7(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr, i, minIndex);
        }
    }

    //冒泡排序 如果存在左边的数比右边的数大，交换 实际每次循环结束都会找到一个最大的移动到右边
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

    //保证0-N之间的每一个范围内都是有序的
    public static void insertSort3(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        //从1开始
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                NumberUtil.swap(arr, j, j + 1);
            }
        }
    }

    //每次循环找出最小的数字，放在做左侧
    public static void selectSort8(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr, i, minIndex);
        }
    }

    //如果出现 左大于右 就移动，每次内层循环都要找到一个当前最大的数来移动
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

    //保证0——N之间的数有序
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

    public static void selectSort9(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr, i, minIndex);
        }
    }

    public static void bubbleSort9(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int e = arr.length - 1; e > 0; e--) {
            for (int i = 0; i < e; i++) {
                //左侧数大于右侧数就交换
                if (arr[i] > arr[i + 1]) {
                    NumberUtil.swap(arr, i, i + 1);
                }
            }
        }
    }

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
        mergeArr1(arr, l, mid, r);
    }
    private static void mergeArr1(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        //最后将数据移动到原数组
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }

    public static void selectSort10(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr, i, minIndex);
        }
    }
    public static void bubbleSort10(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int e = arr.length - 1; e > 0; e--) {
            //如果存在左边大于右边 就交换
            for (int i = 0; i < e; i++) {
                if (arr[i] > arr[i + 1]) {
                    NumberUtil.swap(arr, i, i + 1);
                }
            }
        }
    }
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
        int m = l + ((r - l) >> 1);
        process2(arr, l, m);
        process2(arr, m + 1, r);
        mergeArr2(arr, l, m, r);
    }
    private static void mergeArr2(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l+i] = help[i];
        }
    }

    public static void selectSort11(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            //每次都有一个最小的数移动到右边，j要从i+1开始
            for(int j = i + 1; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr,i,minIndex);
        }
    }
    public static void bubbleSort11(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int e = arr.length - 1; e > 0; e--){
            //每次都有一个最大的数被移动到右边 所以i的终止条件就是e
            for(int i = 0; i < e; i++){
                if(arr[i] > arr[i+1]){
                    NumberUtil.swap(arr,i,i+1);
                }
            }
        }
    }
    public static void insertSort7(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 1; i < arr.length; i++){
            for(int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--){
                NumberUtil.swap(arr,j,j+1);
            }
        }
    }
    public static void mergeSort3(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        process3(arr,0,arr.length - 1);
    }
    private static void process3(int[] arr, int l, int r) {
        if(l == r){
            return;
        }
        int m = l + ((r - l ) >> 1);
        process3(arr,l,m);
        process3(arr,m + 1,r);
        mergeArr3(arr,l,m,r);
    }
    private static void mergeArr3(int[] arr, int l, int m, int r) {
        int [] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= m){
            help[i++] = arr[p1++];
        }
        while(p2 <= r){
            help[i++] = arr[p2++];
        }
        for(i = 0; i < help.length; i++){
            arr[l + i] = help[i];
        }
    }

    public static void selectSort12(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr,i,minIndex);
        }
    }
    public static void bubbleSort12(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int e = arr.length - 1;e > 0; e--){
            for(int i = 0; i < e; i++){
                if(arr[i] > arr[i+1]){
                    NumberUtil.swap(arr,i,i+1);
                }
            }
        }
    }
    public static void insertSort8(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 1;i < arr.length; i++){
            for(int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--){
                NumberUtil.swap(arr,j,j+1);
            }
        }
    }
    public static void mergeSort4(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        process4(arr,0,arr.length-1);
    }

    private static void process4(int[] arr, int l, int r) {
        if(l == r){
           return;
        }
        int m = l + ((r -l ) >> 1);
        process4(arr,l,m);
        process4(arr,m+1,r);
        mergeArr4(arr,l,m,r);
    }

    private static void mergeArr4(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m+1;
        while(p1 <= m && p2 <= r){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= m){
            help[i++] = arr[p1++];
        }
        while(p2 <= r){
            help[i++] = arr[p2++];
        }
        for(i = 0; i < help.length; i++){
            arr[l+i] = help[i];
        }

    }

    public static void selectSort13(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            for(int j = i +1; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr,i,minIndex);
        }
    }
    public static void bubbleSort13(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int e = arr.length - 1 ;e > 0; e--){
            for(int i = 0; i < e; i++){
                if(arr[i] > arr[i + 1]){
                    NumberUtil.swap(arr,i,i+1);
                }
            }
        }
    }
    public static void insertSort9(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 1; i < arr.length; i++){
            for(int j = i - 1; j >= 0 && arr[j] > arr[j+1]; j--){
                NumberUtil.swap(arr,j,j+1);
            }
        }
    }

    public static void mergeSort5(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        process5(arr,0,arr.length-1);
    }

    private static void process5(int[] arr, int l, int r) {
        if(l == r){
          return;
        }
        int m = l + ((r - l) >> 1);
        //处理左边
        process5(arr,l,m);
        //处理右边
        process5(arr,m+1,r);
        //合并两边的数组
        mergeArr5(arr,l,m,r);
    }

    private static void mergeArr5(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        //注意边界问题
        int p2 = m+1;
        while (p1 <= m && p2 <= r){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m){
            help[i++] = arr[p1++];
        }
        while (p2 <= r){
            help[i++] = arr[p2++];
        }
        for(i = 0;i < help.length;i++){
            arr[l+i] = help[i];
        }
    }

    //选择排序 每次选出最小的那个数 排在最左侧
    public static void selectSort14(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j <arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr,i,minIndex);
        }
    }

    public static void bubbleSort14(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        //冒泡排序 让大的数像冒泡一样一点一点移动到最右边
        for(int e = arr.length - 1; e > 0; e--){
            for(int i = 0; i < e; i++){
                if(arr[i] > arr[i + 1]){
                    NumberUtil.swap(arr,i,i+1);
                }
            }
        }
    }
    public static void insertSort10(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        //插入排序 保证每一个小范围的数字都有序，大范围就有序了
        for(int i = 1; i < arr.length; i++){
            for(int j = i - 1; j >=0 && arr[j] > arr[j+1]; j--){
                NumberUtil.swap(arr,j,j+1);
            }
        }
    }
    public static void mergeSort6(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        process6(arr,0,arr.length - 1);
    }

    private static void process6(int[] arr, int l, int r) {
        //开始处理
        //如果已经只剩一个数字 就返回
        if(l == r){
            return;
        }
        //否则开始拆分 二分的搞 取中间值
        int m = l + ((r - l) >> 1);
        process6(arr,l,m);
        process6(arr,m+1,r);
        mergeArr6(arr,l,m,r);

    }

    private static void mergeArr6(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m+1;
        while (p1 <= m && p2 <= r){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while(p1 <= m){
            help[i++] = arr[p1++];
        }
        while(p2 <= r){
            help[i++] = arr[p2++];
        }
        for(i = 0; i < help.length; i++){
            arr[l+i] = help[i];
        }
    }

    public static void selectSort15(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            //内层循环每次都从最左侧加1开始
            for(int j = i+1; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            //找到最小的 就把它放在最左侧
            NumberUtil.swap(arr,i,minIndex);
        }
    }
    public static void bubbleSort15(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int e = arr.length - 1; e > 0; e--){
            //内层循环每次到最右侧就是边界 因为最右侧每次都会有一个已经拍好的最大数过去
            for(int i = 0; i < e; i++){
                if(arr[i] > arr[i + 1]){
                    NumberUtil.swap(arr,i,i+1);
                }
            }
        }
    }
    public static void insertSort11(int[] arr){
        if(null == arr || arr.length < 1){
            return;
        }
        for(int i = 1; i < arr.length; i++){
            for(int j = i - 1; j >=0 && arr[j] > arr[j+1]; j--){
                NumberUtil.swap(arr,j,j+1);
            }
        }
    }

    public static void mergeSort7(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        process7(arr,0,arr.length-1);
    }

    private static void process7(int[] arr, int l, int r) {
        if(l == r){
            return;
        }
        int m = l + ((r - l) >> 1);
        process7(arr,l,m);
        process7(arr,m+1,r);
        mergeArr7(arr,l,m,r);
    }
    private static void mergeArr7(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= m){
          help[i++] = arr[p1++];
        }
        while(p2 <= r){
            help[i++] = arr[p2++];
        }
        for(i = 0; i < help.length; i++){
            arr[l+i] = help[i];
        }
    }
    public static void selectSort16(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            //每次从i+1开始
            for(int j = i + 1; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr,i,minIndex);
        }
    }
    public static void bubbleSort16(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int e = arr.length - 1; e > 0; e--){
            for(int i = 0; i < e; i++){
                if(arr[i] > arr[i+1]){
                    //左比右大就交换
                    NumberUtil.swap(arr,i,i+1);
                }
            }
        }
    }
    public static void insertSort12(int[] arr){
        if(null == arr || arr.length < 2){
            return ;
        }
        for(int i = 1;i < arr.length; i++){
            for(int j = i - 1; j >=0 && arr[j]>arr[j+1]; j--){
                NumberUtil.swap(arr,j,j+1);
            }
        }
    }
    public static void mergeSort8(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        process8(arr,0,arr.length-1);
    }

    private static void process8(int[] arr, int l, int r) {
        if(l == r){
            return;
        }
        int m = l + ((r - l) >> 1);
        process8(arr,l,m);
        process8(arr,m+1,r);
        mergeArr8(arr,l,m,r);
    }

    private static void mergeArr8(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m+1;
        while(p1 <= m && p2 <= r){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= m){
            help[i++] = arr[p1++];
        }
        while(p2 <= r){
            help[i++] = arr[p2++];
        }
        for(i=0; i < help.length; i++){
            arr[l+i] = help[i];
        }
    }

    public static void selectSort17(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i =0; i< arr.length - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr,i,minIndex);
        }
    }
    public static void bubbleSort17(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int e = arr.length - 1; e > 0; e--){
            for(int i = 0; i < e; i++){
                if(arr[i] > arr[i+1]){
                    NumberUtil.swap(arr,i,i+1);
                }
            }
        }
    }
    public static void insertSort13(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 1; i < arr.length; i++){
            //虽然实现有序从i=1开始，但是每次比较还是从第一个数来比较
            for(int j = i - 1;j>=0 && arr[j] > arr[j+1];j--){
                NumberUtil.swap(arr,j,j+1);
            }
        }
    }
    public static void mergeSort9(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        process9(arr,0,arr.length-1);
    }
    private static void process9(int[] arr, int l, int r) {
        if(l == r){
           return;
        }
        int m = l + ((r - l) >> 1);
        process9(arr,l,m);
        process9(arr,m+1,r);
        mergeArr9(arr,l,m,r);
    }

    private static void mergeArr9(int[] arr, int l, int m, int r) {
        int[] help = new int[r- l +1];
        int i = 0;
        int p1 = l;
        int p2 = m+1;
        while(p1 <= m && p2 <= r){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= m){
            help[i++] = arr[p1++];
        }
        while(p2 <= r){
            help[i++] = arr[p2++];
        }
        for(i=0;i<help.length;i++){
            arr[l+i] = help[i];
        }
    }
    public static void selectSort18(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 0; i <arr.length; i++){
            int minIndex = i;
            //每次找到最小的数字 把他放在最左边
            for(int j = i + 1; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr,i,minIndex);
        }
    }
    public static void bubbleSort18(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int e = arr.length - 1; e > 0; e--){
            for(int i = 0; i < e; i++){
                //每次遍历只要发现有左边数字大于右边数字 就交换
                if(arr[i] > arr[i+1]){
                    NumberUtil.swap(arr,i,i+1);
                }
            }
        }
    }
    public static void insertSort14(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 1; i < arr.length; i ++){
            for(int j = i - 1; j >=0 && arr[j] > arr[j+1];j--){
                NumberUtil.swap(arr,j,j+1);
            }
        }
    }
    public static void mergeSort10(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        process10(arr,0,arr.length-1);
    }
    private static void process10(int[] arr, int l, int r) {
        //分到终点就返回
        if(l == r){
           return;
        }
        //找中间位置
        int m = l + ((r - l) >> 1);
        //处理左边的数
        process10(arr,l,m);
        //处理右边的数
        process10(arr,m+1,r);
        //排序
        mergeArr10(arr,l,m,r);
    }

    private static void mergeArr10(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m+1;
        int res = 0;
        while(p1 <= m && p2 <= r){
            //这个求和代码必须放在移动数组元素代码的前面
            res += arr[p1] < arr[p2] ? (r-p2+1)*arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= m){
            help[i++] = arr[p1++];
        }
        while(p2 <= r){
            help[i++] = arr[p2++];
        }
        for(i = 0; i<help.length;i++){
            arr[l+i] = help[i];
        }
    }

    public static void selectSort19(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            //排好序的数字依次往右移动 所以内层循环需要从i+1开始
            for(int j = i + 1; j < arr.length;j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr,i,minIndex);
        }
    }
    public static void bubbleSort19(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int e = arr.length - 1; e > 0; e--){
            //右侧一直存放的是最大的数字 所以右边界从最右边开始
            for(int i = 0; i < e; i++){
                if(arr[i] > arr[i+1]){
                    NumberUtil.swap(arr,i,i+1);
                }
            }
        }
    }
    public static void insertSort15(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 1; i < arr.length;i++){
            for(int j = i - 1;j>= 0 && arr[j] > arr[j+1]; j--){
                NumberUtil.swap(arr,j,j+1);
            }
        }
    }
    public static void mergeSort11(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        process11(arr,0,arr.length-1);
    }

    private static void process11(int[] arr, int l, int r) {
        if(l == r){
            return;
        }
        int m = l + ((r - l ) >> 1);
        process11(arr,l,m);
        process11(arr,m+1,r);
        mergeArr11(arr,l,m,r);
    }

    private static void mergeArr11(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m+1;
        while (p1 <= m && p2 <= r){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= m){
            help[i++] = arr[p1++];
        }
        while (p2 <= r){
            help[i++] = arr[p2++];
        }
        for(i = 0; i < help.length;i++){
            arr[l+i] = help[i];
        }
    }

    public static int smallNum1(int[] arr){
        if(null == arr || arr.length < 2){
            return 0;
        }
        return processSum1(arr,0,arr.length-1);
    }

    private static int processSum1(int[] arr, int l, int r) {
        if(l == r){
            return 0 ;
        }
        int mid = l + ((r - l) >> 1);
        return processSum1(arr,l,mid) +
                processSum1(arr,mid+1,r) +
                mergeSumArr(arr,l,mid,r);
    }

    private static int mergeSumArr(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        int res = 0;
        while(p1 <= m && p2 <= r){
            res += arr[p1] < arr[p2] ? (r - p2 + 1)*arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= m){
            help[i++] = arr[p1++];
        }
        while(p2 <= r){
            help[i++] = arr[p2++];
        }
        for(i = 0; i < help.length;i++){
            arr[l+i] = help[i];
        }
        return res;
    }

    //每次找到一个最小的数 把他放在做左侧 然后循环往复
    public static void selectSort20(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j :minIndex;
            }
            NumberUtil.swap(arr,i,minIndex);
        }
    }
    //如果存在左侧的数大于右侧的数就把左侧数和右侧的数交换。每一轮都会有一个大的数移动到最右侧
    public static void bubbleSort20(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int e = arr.length - 1; e > 0; e--){
            for(int i = 0; i < e; i++){
                if(arr[i] > arr[i+1]){
                    NumberUtil.swap(arr,i,i+1);
                }
            }
        }
    }
    public static void insertSort16(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 1; i < arr.length;i++){
            for(int j = i - 1; j >= 0 && arr[j] > arr[j+1];j--){
                NumberUtil.swap(arr,j,j+1);
            }
        }
    }
    ///每一轮找一个当前轮次最小的数 移动到指定位置 最终完成排序
    public static void selectSort21(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 0; i < arr.length - 1;i++){
            //记录最小元素下标位置
            int minIndex = i;
            //上一轮中已经是最小的数字就不动了 j=i+1
            for(int j = i + 1; j < arr.length; j++){
                minIndex = arr[minIndex] > arr[j] ? j :minIndex;
            }
            //移动每一轮次最小的数字到指定位置
            NumberUtil.swap(arr,i,minIndex);
        }
    }
    //只要发现有左边的数比右边的数大 就交换 交换的结果就是最大的数会被移动到右边
    public static void bubbleSort21(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        //确定每次循环的终点 最右边是排好的数 不动
        for(int e = arr.length - 1; e > 0; e--){
            for(int i = 0; i < e;i++){
                if(arr[i] > arr[i+1]){
                    NumberUtil.swap(arr,i,i+1);
                }
            }
        }
    }
    //从小到大 保证从0-i每一个范围内的数都有序
    public static void insertSort17(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        //只有一个数字肯定有序不需要比较 从第二个数开始
        for(int i = 1; i < arr.length; i++){
            //i每往前移动一个数字 j就从他的上一个数开始，往前走 发现与当前位置的i顺序不对的数字就改变顺序
            for(int j = i - 1; j>=0 && arr[j]>arr[j+1]; j--){
                NumberUtil.swap(arr,j,j+1);
            }
        }
    }
    public static void mergeSort12(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        process12(arr,0,arr.length - 1);
    }

    private static void process12(int[] arr, int l, int r) {
        if(l == r){
            return;
        }
        int mid = l + ((r - l) >> 1);
        process12(arr,l,mid);
        process12(arr,mid+1,r);
        mergeArr12(arr,l,mid,r,new int[r - l + 1]);
    }

    private static void mergeArr12(int[] arr, int l, int mid, int r,int[] help) {
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while(p1 <= mid && p2 <= r){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1  <= mid){
            help[i++] = arr[p1++];
        }
        while(p2 <= r){
            help[i++] = arr[p2++];
        }
        for(i = 0; i < help.length; i++){
            arr[l+i] = help[i];
        }
    }

    //选择排序 每轮循环找最小，然后移动到右边
    public static void selectSort22(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 0; i < arr.length - 1; i++){
            //记录最小值的下标 然后把最小值移动到正确位置
            int minIndex = i;
            for(int j = i+1; j < arr.length; j++){
                
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            //每次循环结束 找到本轮循环中最小的一个数 交换位置
            NumberUtil.swap(arr,i,minIndex);
        }
    }
    //冒泡排序 左边的数比右边的数大 就把两个数交换位置，一直交换下去，每次都会把最大的一个数移动到右边 
    public static void bubbleSort22(int[] arr){
        if(null == arr  || arr.length < 2){
         return;   
        }
        for(int e = arr.length - 1; e > 0; e--){
            //e位置存放的就是排好序的，不用再排了
            for(int i = 0; i < e; i++){
                if(arr[i] > arr[i+1]){
                    NumberUtil.swap(arr,i,i+1);
                }
            }
        }
    }
    //插入排序，保证每一个范围的数都有序 先保证2有序
    public static void insertSort18(int[] arr){
        if(null == arr || arr.length < 2){
            return ;
        }
        for(int i = 1; i < arr.length; i++){
            //每次都两个数 只要左边比右边数字大就执行交换 
            for(int j = i - 1; j >=0 && arr[j] > arr[j+1]; j--){
                NumberUtil.swap(arr,j,j+1);
            }
        }
    }
    public static void mergeSort13(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        process13(arr,0,arr.length-1);
    }

    private static void process13(int[] arr, int l, int r) {
        if(l == r){
          return;
        }
        int mid = l + (r-l)/2;
        process13(arr,l,mid);
        process13(arr,mid+1,r);
        mergeArr13(arr,l,mid,r);
    }

    private static void mergeArr13(int[] arr, int l, int mid, int r) {
        int help[] = new int[r - l + 1];
        int p1 = l;
        int p2 = mid+1;
        int i = 0;
        while(p1 <= mid && p2 <= r){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= mid){
            help[i++] = arr[p1++];
        }
        while(p2 <= r){
            help[i++] = arr[p2++];
        }
        for(i = 0 ; i < help.length; i++){
            arr[l+i] = help[i];
        }
    }
    //选择排序 双层循环，每层循环都要选择出来一个最小的数字 然后把它放到正确的位置上来
    // 外层循环控制正确的位置 内层循环控制选择相出最小的数字
    public static void selectSort23(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i= 0; i < arr.length - 1; i++ ){
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr,i,minIndex);
        }
    }
    //冒泡排序 双层循环 找到是否存在左边的数比右边的数还大 如果存在就交换两个数的位置
    //第一层循环控待比较的范围，第二层循环每次都从0开始进行比较。到范围就停止
    public static void bubbleSort23(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int e = arr.length- 1; e > 0; e--){
            for(int i = 0; i < e; i++){
                if(arr[i] > arr[i+1]){
                    NumberUtil.swap(arr,i,i+1);
                }
            }
        }
    }
    //插入排序 保证每一个范围内的数字都是有序的 从两个数一直到N个数内都要保证有序。
    //双层循环
    public static void insertSort19(int[] arr){
        if(null == arr || arr.length < 2){
            return ;
        }
        for(int i = 1; i < arr.length; i++){
            for(int j = i-1; j >=0 && arr[j] > arr[j+1]; j--){
                NumberUtil.swap(arr,j,j+1);
            }
        }
    }

    public static void mergeSort14(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        process14(arr,0,arr.length-1);
    }

    private static void process14(int[] arr, int l, int r) {
        if(l == r){
            return;
        }
        int mid = l + (r-l)/2;
        process14(arr,l,mid);
        process14(arr,mid+1,r);
        mergeArr14(arr,l,mid,r);
    }

    private static void mergeArr14(int[] arr, int l, int mid, int r) {
        int help[] = new int[r - l + 1];
        int p1 = l;
        int p2 = mid+1;
        int i = 0;
        while(p1 <= mid && p2 <= r){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= mid){
            help[i++] = arr[p1++];
        }
        while (p2 <= r){
            help[i++] = arr[p2++];
        }
        for(i = 0; i < help.length; i++){
            arr[l + i] = help[i];
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
            insertSort19(arr1);
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
        insertSort19(arr);
        PrintUtil.printArr(arr);
    }


}
