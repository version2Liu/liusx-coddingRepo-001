package com.algorithm.memory.sort;

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

    ///外层循环控制着合适排序位置的下标 内层循环找到最小的那个数 然后移动到指定位置
    public static void selectSort24(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            for(int j = i+1; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j :minIndex;
            }
            NumberUtil.swap(arr,i,minIndex);
        }
    }
    //一直冒泡将最大的数移动到右边
    public static void bubbleSort24(int[] arr){
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
    //保证每个范围内的数字都有序
    public static void insertSort20(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 1; i < arr.length; i++){
            for(int j = i-1; j>=0 && arr[j]>arr[j+1];j--){
                NumberUtil.swap(arr,j,j+1);
            }
        }
    }
    public static void mergeSort15(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        process15(arr,0,arr.length-1);
    }
    private static void process15(int[] arr, int l, int r) {
        //二分到只剩下一个数就停止 开始向上收网
        if(l == r){
           return;
        }
        //找中间位置
        int mid = l + (r-l)/2;
        //处理左边
        process15(arr,l,mid);
        //处理右边
        process15(arr,mid+1,r);
        //合并处理好的左边和右边 通过下标位置 记录着 左边和右边的边界
        mergeArr15(arr,l,mid,r);
    }
    private static void mergeArr15(int[] arr, int l, int mid, int r) {
        int[] help = new int[r-l+1];
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
        for(i = 0; i < help.length; i++){
            //////严格注意 l+i 和 i 的区别 可一点也不是0+i 和 i的区别。在递归过程中，l可是代表着左边数字的下标啊。
            ///签完不能把l+i忘记了
            arr[l+i] = help[i];
        }
    }

    public static void selectSort25(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        //选择排序，每次选出一个最小的数字 放在数组的前方位置
        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            for(int j = i; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr,i,minIndex);
        }
    }
    public static void bubbleSort25(int[] arr){
        if(null == arr || arr.length < 2){
            return ;
        }
        //冒泡排序 每次比较相邻两个数 如果左边的数比右边的数字大 那么就交换两个数 每一轮比较的最后都会有一个当前最大数字移动最右边
        for(int e = arr.length - 1; e > 0; e--){
            for(int i = 0; i < e; i++){
                //核心逻辑是下面的if判断 其余的都是边界条件的设定
                if(arr[i] > arr[i+1]){
                    NumberUtil.swap(arr,i,i++);
                }
            }
        }
    }
    public static void insertSort21(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        //插入排序 保证任意范围内的包含数字都是有序的 如果不有序就将正确的数字插入进去
        for(int i = 1; i <arr.length; i++){
            for(int j = i-1; j >= 0 && arr[j] > arr[j+1]; j--){
                NumberUtil.swap(arr,j,j+1);
            }
        }
    }

    //每次选择一个最小的数 放在i的位置 i一次递增
    public static void selectSort26(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            for(int j = i+1; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            //一圈循环下来找到了最小的那个数 这里要给他移动过去
            NumberUtil.swap(arr,i,minIndex);
        }
    }
    public static void bubbleSort26(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        //冒泡排序就是每次都比较相邻两个数 如果左边比右边数大 就交换
        for(int end = arr.length - 1; end > 0;end--){
            for(int i = 0; i < end; i++){
                //每一次循环都会把一个最大的数字移动到最右侧
                if(arr[i] > arr[i+1]){
                    NumberUtil.swap(arr,i,i+1);
                }
            }
        }
    }
    public static void insertSort22(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        //保证每一个范围内的数字都有序
        for(int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                NumberUtil.swap(arr,j,j+1);
            }
        }
    }
    public static void mergeSort16(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        process16(arr,0,arr.length - 1);
    }
    private static void process16(int[] arr, int l, int r) {
        if(l == r){
            return;
        }
        int mid = l + (r - l) /2;
        process16(arr,l,mid);
        process16(arr,mid+1,r);
        mergeArr16(arr,l,mid,r);
    }
    private static void mergeArr16(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
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
        for(i = 0; i < help.length; i++){
            arr[l+i] = help[i];
        }
    }
    public static void quickSort1(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        quickSort1(arr,0,arr.length-1);
    }
    private static void quickSort1(int[] arr, int l, int r) {
        if(l < r){
            //交换
            int random = (int) (Math.random() * (r - l + 1));
            swap(arr,l+random,r);
            int[] p = partition(arr,l,r);
            quickSort1(arr,l,p[0]-1);
            quickSort1(arr,p[1]+1,r);

        }
    }
    private static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while(l < more){
            if(arr[l] < arr[r]){
                swap(arr,++less,l++);
            }else if(arr[l] > arr[r]){
                swap(arr,--more,l);
            }else{
                l++;
            }
        }
        swap(arr,more,r);
        return new int[]{less+1,more} ;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j] ;
        arr[j] = temp;
    }


    public static void selectSort27(int[] arr){
        if(null == arr || arr.length <2){
            return;
        }
        //选择排序 选择最小的数字 放在合适的位置
        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            for(int j = i+1; j < arr.length;j++){
                minIndex = arr[j] < arr[minIndex] ? j:minIndex;
            }
            //每一圈循环结束寻找出来的数字要放在合适的位置
            NumberUtil.swap(arr,i,minIndex);
        }
    }
    public static void bubbleSort27(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        //冒泡 把大数全部筛除移动带最右侧 每一轮移动一个最大的到右边
        for(int e = arr.length - 1; e > 0; e--){
            for(int i = 0; i < e; i++){
                if(arr[i] > arr[i+1]){
                    NumberUtil.swap(arr,i,i+1);
                }
            }
        }
    }
    public static void insertSort23(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        //保证每一个范围内地数字都是左边小于右边的
        for(int i= 1; i < arr.length; i++){
            for(int j = i-1; j>=0&&arr[j]>arr[j+1]; j--){
                NumberUtil.swap(arr,j,j+1);
            }
        }
    }
    public static void mergeSort17(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        process17(arr,0,arr.length-1);
    }
    private static void process17(int[] arr, int l, int r) {
        if(l == r){
            return;
        }
        int m = l + (r - l) /2;
        process17(arr,l,m);
        process17(arr,m+1,r);
        mergeArr17(arr,l,m,r);
    }
    private static void mergeArr17(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = m + 1;
        int i = 0;
        while(p1 <= m && p2 <= r){
            //谁小谁先走
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
    }
    public static void quickSort2(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        quickSort2(arr,0,arr.length-1);
    }
    private static void quickSort2(int[] arr, int l, int r) {
        if(l < r){
            int random = (int)Math.random() * (r - l + 1);
            swap(arr,l+random,r);
            int[] p = partition2(arr,l,r);
            quickSort2(arr,l,p[0]-1);
            quickSort2(arr,p[1]+1,r);
        }
    }
    private static int[] partition2(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while(l < more){
            if(arr[l] < arr[r]){
                swap(arr,++less,l++);
            }else if(arr[l] > arr[r]){
                swap(arr,--more,l);
            }else{
                l++;
            }
        }
        swap(arr,more,r);
        return new int[]{less+1,more};
    }

    public static void quickSort3(int[] arr){
        if(null == arr || arr.length < 2){
            return ;
        }
        quickSort3(arr,0,arr.length-1);
    }
    private static void quickSort3(int[] arr, int l, int r) {
        if(l < r){
            //随机选取一个数
            int random = (int) Math.random() * (r - l + 1);
            //放到最后作为比较数
            swap(arr,l+random,r);
            int[] p = partition3(arr,l,r);
            quickSort3(arr,l,p[0]-1);
            quickSort3(arr,p[1]+1,r);
        }
    }
    private static int[] partition3(int[] arr, int l, int r) {
        //左边界
        int less = l - 1;
        //右边界
        int more = r;
        //只要两个区域没有重合 就一直工作
        while(l < more){
            if(arr[l] < arr[r]){
                //如果小于就移动到小于的区域
                swap(arr,++less,l++);
            }else if(arr[l] > arr[r]){
                //如果大于就移动到大于的区域 但是这个时候循环的指针l不能移动 要继续比较一下
                swap(arr,--more,l);
            }else{
                l++;
            }
        }
        swap(arr,more,r);
        return new int[]{less+1,more};
    }

    public static void selectSort28(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        //选择排序顾名思义 将数字通过选择的方式使其有序 每次选择出来最小的放在数组的左侧。
        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr,i,minIndex);
        }
    }
    public static void bubbleSort28(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        //冒泡排序 顾名思义 就是通过冒泡的形式 一个泡一个泡的冒过去 大数就都跑到右边了
        for(int e = arr.length - 1; e > 0; e--){
            for(int i = 0; i < e; i++){
               if(arr[i] > arr[i+1]){
                   NumberUtil.swap(arr,i,i+1);
               }
            }
        }
    }
    public static void insertSort24(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        //插入排序 顾名思义 不选择也不冒泡就是通过插入的方式 将数字插入到他合适的位置
        for(int i = 1; i < arr.length; i++){
            for(int j = i - 1; j >=0 && arr[j] > arr[j+1];j--){
                NumberUtil.swap(arr,j,j+1);
            }
        }
    }
    public static void mergeSort18(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        //归并逻辑开始进行
        process18(arr,0,arr.length-1);
    }
    private static void process18(int[] arr, int l, int r) {
        //递归二分
        if(l == r){
            return;
        }
        //取中间位置
        int mid = l + (r - l)/2;
        //处理左边
        process18(arr,l,mid);
        //处理右边
        process18(arr,mid+1,r);
        //将左右两边合并
        mergeLAndR18(arr,l,mid,r);
    }
    private static void mergeLAndR18(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
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
        for(i = 0; i < help.length; i++){
            arr[l+i] = help[i];
        }
    }
    public static void quickSort4(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        quickSort4(arr,0,arr.length-1);
    }
    private static void quickSort4(int[] arr, int l, int r) {
        if(l < r){
            //随机选取一个数
            int random = l + (int)Math.random() * (r - l + 1);

            //交换最后一个数字和随机选取的数字
            swap(arr,random,r);
            //给数分拨 求得分拨后的分堆情况
            int[] p = partition4(arr,l,r);
            //处理 分拨之后小于选择数的那一波
            quickSort4(arr,l,p[0]-1);
            //处理 分拨之后大于选择数的那一波
            quickSort4(arr,p[1]+1,r);
        }
    }
    private static int[] partition4(int[] arr, int l, int r) {
        //分拨小于部分边界
        int less = l - 1;
        //分拨大于部分边界索引
        int more = r;
        //注意 循环截止条件是游标 和 大于部分边界索引的比较
        while(l < more){
            if(arr[l] < arr[r]){
                swap(arr,++less,l++);
            }else if(arr[l] > arr[r]){
                swap(arr,--more,l);
            }else{
                l++;
            }
        }
        //把比较数跟边界值换一下 其实这个时候跟大于边界 和小于边界换都可以
        //fixme 错大错特错 不是跟哪个换都行，必须是跟大的数换 因为换过去的区域是大于数的区域 换小的不是乱套了吗
        swap(arr,more,r);
        return new int[]{less+1,more};
    }


    //选择排序
    public static void selectSort29(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        //每次选出最小数 放在他应该在的位置
        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            for(int j = i+1; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr,i,minIndex);
        }
    }
    //冒泡排序
    public static void bubbleSort29(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        //每次都把最大的数给冒到右边去 最后就完成了排序
        for(int e = arr.length - 1; e > 0 ;e--){
            for(int i = 0; i < e; i++){
                if(arr[i] > arr[i+1]){
                    NumberUtil.swap(arr,i,i+1);
                }
            }
        }
    }
    //插入排序
    public static void insertSort25(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        //保证每一个范围的数字都有序 如果无序 就直接插入(进行交换)
        for(int i = 1; i < arr.length; i++){
            for(int j = i - 1; j >=0 && arr[j] > arr[j+1]; j--){
                NumberUtil.swap(arr,j,j+1);
            }
        }
    }
    //归并排序
    public static void mergeSort19(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        //递归二分 分化处理每一个小范围的数字 然后分化结束后在合并
        process19(arr,0,arr.length-1);
    }
    private static void process19(int[] arr, int l, int r) {
        if(l == r){
            return;
        }
        int mid = l + (r - l)/2;
        process19(arr,l,mid);
        process19(arr,mid+1,r);
        mergeLAndR19(arr,l,mid,r);
    }
    private static void mergeLAndR19(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = mid+1;
        int i = 0;
        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= mid){
            help[i++] = arr[p1++];
        }
        while(p2 <= r){
            help[i++] = arr[p2++];
        }
        for(i = 0; i < help.length;i++){
            arr[l+i] = help[i];
        }
    }
    //快排
    public static void quickSort5(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        //快排就是选定一个数 根据这个数把数组分为三个区域大于 、小于 、 等于
        quickSort5(arr,0,arr.length-1);
    }
    private static void quickSort5(int[] arr, int l, int r) {
        if(l < r){
            //每次都选定一个随机位置的数
            int random = l + (int)Math.random() * (r - l + 1);
            //交换
            swap(arr,random,r);
            //开始做工 分类
            int[] p = partition5(arr,l,r);
            //处理小于区域
            quickSort5(arr,l,p[0]-1);
            //处理大于区域
            quickSort5(arr,p[1]+1,r);
        }
    }
    private static int[] partition5(int[] arr, int l, int r) {
        // 大于小于边界索引
        int less = l - 1,more = r;
        //循环终止条件为 循环下标 与 大于边界相遇
        while(l < more){
            if(arr[l] < arr[r]){
                swap(arr,++less,l++);
            }else if(arr[l] > arr[r]){
                //大于区域的数交换后 遍历指针不动
                swap(arr,--more,l);
            }else{
                l++;
            }
        }
        //把比较数跟 大于区域第一个数做交换
        swap(arr,more,r);
        //返回当前比较结果区域边界 more不用加1 因为已经把最后的比较数移动过来了
        return new int[]{less+1,more};
    }
    //堆排
    public static void heapSort1(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        //把待排数组变成一个大根堆
        for(int i = 0; i < arr.length; i++){
            heapInsert(arr,i);
        }
//        for(int i = arr.length - 1; i > 0; i--){
//            heapify(arr,i,arr.length);
//        }
        //大根堆大小
        int heapSize = arr.length;
        swap(arr,0,--heapSize);
        while(heapSize > 0){
            //保持堆化
            heapify(arr,0,heapSize);
            //将大根堆堆顶数字交换到最后数组的最后一个位置 并将堆的大小减一
            swap(arr,0,--heapSize);
        }
    }

    /**
     * 孩子插入时需要跟 父节点 比较 如果孩子大于父节点就需要交换
     * @param arr
     * @param index
     */
    public static void heapInsert(int[] arr , int index){
        while(arr[index] > arr[(index - 1) / 2]){
            swap(arr,index,(index - 1)/2);
            index = (index - 1) / 2;
        }
    }
    /**
     * 将一个被改变的大根堆 调整为新的大根堆
     * @param arr
     * @param index
     * @param size
     */
    public static void heapify(int[] arr ,int index ,int size){
        //找左孩子
        int left = index * 2 + 1;
        //左孩子作为本次循环的终止判断条件之一
        while (left < size){
            //找出左孩子 和 右孩子之间 最大的一个
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left+1 : left;
            //比较左孩子 和 父节点之间谁大
            largest = arr[index] > arr[largest] ? index : largest;
            //如果最大的节点就是父节点，那么就不需要调整了 直接返回
            if(largest == index){
                break;
            }
            //交换最大的节点 和 当前父节点
            swap(arr,index,largest);
            //当前位置来到了 下面
            index = largest;
            left = index * 2 + 1;
        }
    }

    //选择排序
    public static void selectSort30(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        //选择最小的数 排左边 为防止+1越界 就必须把边界定为arr.length - 1
        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr,i,minIndex);
        }
    }
    //冒泡排序
    public static void bubbleSort30(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        //把相邻两个数之间不正确的大小关系改正  为防止+1越界 就必须把边界定为arr.length - 1
        //当然是要循环n次了 因为每一次只能找出来一个当前最大的数移动到右边 只要出现一个当前最大数，那么就是一直在移动他，其他的数字都没参与感 就是在被动筛选
        for(int e = arr.length - 1; e > 0; e--){
            for(int i = 0; i < e; i++){
                if(arr[i] > arr[i+1]){
                    NumberUtil.swap(arr,i,i+1);
                }
            }
        }
    }
    //插入排序
    public static void insertSort26(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        //比较每一个指定范围内的数 顺序不正确就把正确的数插到正确的位置来
        for(int i = 1; i < arr.length; i++){
            for(int j = i - 1; j >= 0 && arr[j]>arr[j+1];j--){
                NumberUtil.swap(arr,j,j+1);
            }
        }
    }
    //归并排序
    public static void mergeSort20(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        process20(arr,0,arr.length-1);
    }
    private static void process20(int[] arr, int l, int r) {
        if(l == r){
            return;
        }
        int mid = l + (r - l) / 2;
        process20(arr,l,mid);
        process20(arr,mid+1,r);
        mergeLAndR20(arr,l,mid,r);
    }
    private static void mergeLAndR20(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l +1];
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
        for(i = 0; i < help.length;i++){
            arr[l+i] = help[i];
        }
    }
    //快排
    public static void quickSort6(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        quickSort6(arr,0,arr.length-1);
    }
    private static void quickSort6(int[] arr, int l, int r) {
        if(l < r){
            int random = l + (int)Math.random() * (r - l +1);
            swap(arr,random,r);
            int[] p = partition6(arr,l,r);
            quickSort6(arr,l,p[0] - 1);
            quickSort6(arr,p[1]+1,r);
        }
    }
    private static int[] partition6(int[] arr, int l, int r) {
        //定义左右区域下标
        int less = l - 1;
        int more = r;
        //循环遍历下标 与大于范围相遇
        while(l < more){
            if(arr[l] < arr[r]){
                swap(arr,++less,l++);
            }else if(arr[l] > arr[r]){
                swap(arr,--more,l);
            }else{
                l++;
            }
        }
        swap(arr,more,r);
        //返回的是等于比较数的范围 那必定只有等于数 没有其他数
        return new int[]{less+1,more};
    }
    //堆排
    public static void heapSort2(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        //调整出来一个大根堆
//        for(int i = 0; i < arr.length;i++){
//            heapInsert2(arr,i);
//        }
        for(int i = arr.length - 1; i >= 0; i--){
            heapify2(arr,i,arr.length);
        }
        int size = arr.length;
        swap(arr,0,--size);
        while(size > 0){
            heapify2(arr,0,size);
            swap(arr,0,--size);
        }
    }
    /**
     * 向堆插入元素 需要比较的是与父节点的大小
     * @param arr
     * @param index
     */
    public static void heapInsert2(int[] arr, int index){
        while(arr[index] > arr[(index - 1)/2]){
            swap(arr,index,(index - 1)/2);
            index = (index - 1)/2;
        }
    }
    /**
     * 调整大根堆、结构 需要向下比较当前节点 和 孩子节点的关系
     * @param arr
     * @param index
     * @param size
     */
    public static void heapify2(int[] arr, int index , int size){
        int left = index * 2 + 1;
        while(left < size){
            int largest = left+1 < size && arr[left+1] > arr[left] ? left+1 : left;
            largest = arr[index] > arr[largest] ? index : largest;
            if(index == largest){
                break;
            }
            swap(arr,index,largest);
            //index的值也是必须要变的
            index = largest;
            left = index * 2 + 1;
        }
    }

    //快排
    public static void quickSort7(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        quickSort7(arr,0,arr.length - 1);
    }
    private static void quickSort7(int[] arr, int l, int r) {
        if(l < r){
            int random = l + (int)Math.random() * (r - l + 1);
            swap(arr,random,r);
            int[] p = partition7(arr,l,r);
            quickSort7(arr,l,p[0] - 1);
            quickSort7(arr,p[1]+1,r);
        }
    }
    private static int[] partition7(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while(l < more){
            if(arr[l] < arr[r]){
                swap(arr,++less,l++);
            }else if(arr[l] > arr[r]){
                swap(arr,--more,l);
            }else{
                l++;
            }
        }
        //交换比较数和大于区域的左边界
        swap(arr,more,r);
        //因为大于区域的左边界就是比较数了所以more不用变直接用 less需要加1
        return new int[]{less+1,more};
    }
    //堆排
    public static void heapSort3(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        //把数组变成大根堆
//        for(int i = 0; i < arr.length;i++){
//            heapInsert3(arr,i);
//        }
        for(int i = arr.length-1; i >=0 ; i--){
            heapify3(arr,i,arr.length);
        }
        //交换堆顶数字
        int size = arr.length;
        swap(arr,0,--size);
        //只要大小大于0 就继续搞
        while(size > 0){
            //堆化
            heapify3(arr,0,size);
            //交换堆顶元素 并移除堆尾元素
            swap(arr,0,--size);
        }
    }
    public static void heapInsert3(int[] arr ,int index){
        while(arr[index] > arr[(index - 1) / 2]){
            swap(arr,index,(index - 1) / 2);
            index = (index - 1) / 2;
        }
    }
    public static void heapify3(int[] arr,int index,int size){
        int left = index * 2 + 1;
        while(left < size){
            //比较左右孩子中最大的
            int largest = left + 1 < size && arr[left+1] > arr[left] ? left+1 : left;
            //比较当前节点 和 较大孩子之间谁大
            largest = arr[index] > arr[largest] ? index : largest;
            if(index == largest){
                break;
            }
            //交换父节点和子节点
            swap(arr,index,largest);
            //当前位置来到子节点
            index = largest;
            //再次寻找当前节点的左孩子
            left = index * 2 + 1;
        }
    }
    public static void quickSort8(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        quickSort8(arr,0,arr.length - 1);
    }
    private static void quickSort8(int[] arr, int l, int r) {
        if(l < r){
            //选取一个随机的数
            int random = l + (int)Math.random() * (r - l + 1);
            //跟最后一个数做交换
            swap(arr,random,r);
            //划分出一个距离 大于小于区域
            int[] p = partition8(arr,l,r);
            //在小于区域继续递归划分范围
            quickSort8(arr,l,p[0]-1);
            //在大于区域继续递归划分范围
            quickSort8(arr,p[1]+1,r);
        }
    }
    private static int[] partition8(int[] arr, int l, int r) {
        //左右范围的下标
        int less = l - 1;
        int more = r;
        //只要循环下标与大于区域下标不相遇  就继续循环
        while(l < more){
            //大于小于等于 分别处理
            if(arr[l] < arr[r]){
                swap(arr,++less,l++);
            }else if(arr[l] > arr[r]){
                swap(arr,--more,l);
            }else{
                l++;
            }
        }
        //交换最后一个比较数
        swap(arr,more,r);
        //返回等于区域的范围
        return new int[]{less+1,more};
    }
    public static void heapSort4(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 0; i <= arr.length - 1; i++){
            heapInsert4(arr,i);
        }
        int size = arr.length;
        //移除堆顶元素
        swap(arr,0,--size);
        //堆大小大于0 就一直执行
        while(size > 0){
            //从0 开始继续堆化
            heapify4(arr,0,size);
            //堆化之后移除堆顶元素
            swap(arr,0,--size);
        }
    }
    //插入元素需要和父节点比较
    public static void heapInsert4(int[] arr, int index){
        while(arr[index] > arr[(index - 1) / 2]){
            swap(arr,index,(index - 1) / 2);
            index = (index - 1) / 2;
        }
    }
    //堆化需要往下走
    public static void heapify4(int[] arr, int index, int size){
        int left = index * 2 + 1;
        while(left < size){
            int largest = left+1 < size && arr[left+1] > arr[left] ? left+1 : left;
            largest = arr[index] > arr[largest] ? index : largest;
            if(index == largest){
                break;
            }
            swap(arr,index,largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    //选择排序
    //冒泡排序
    //插入排序
    //归并排序
    //快排
    public static void quickSort9(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        
        quickSort9(arr,0,arr.length - 1);
    }
    private static void quickSort9(int[] arr, int l, int r) {
        if(l < r){
            int random = l + (int)Math.random() * (r - l + 1);
            swap(arr,random,r);
            int[] p = partition9(arr,l,r);
            quickSort9(arr,l,p[0] - 1);
            quickSort9(arr,p[1]+1,r);
        }
    }
    private static int[] partition9(int[] arr, int l, int r) {
        int less = l -1 ;
        int more = r;
        while(l < more){
            if(arr[l] < arr[r]){
                swap(arr,++less,l++);
            }else if(arr[l] > arr[r]){
                swap(arr,--more,l);
            }else{
                l++;
            }
        }
        swap(arr,r,more);
        return new int[]{less+1,more};
    }

    //堆排
    public static void heapSort5(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        //转换大根堆
        for(int i = 0; i <= arr.length - 1; i++){
            heapInsert5(arr,i);
        }
        //移除堆顶元素
        int size = arr.length ;
        swap(arr,0,--size);
        while(size > 0){
            //保护大根堆结构
            heapify5(arr,0,size);
            //移除堆顶元素
            swap(arr,0,--size);
        }
    }
    //插入新节点，只需要与父节点比较即可
    public static void heapInsert5(int[] arr, int index){
        while(arr[index] > arr[(index - 1) / 2]){
            swap(arr,index,(index - 1) / 2);
            index = (index - 1) / 2;
        }
    }
    //修改了堆顶的元素，那么就需要做到保证大根堆结构的不变
    public static void heapify5(int[] arr, int index, int size){
        int left = index * 2 + 1;
        while(left < size){
            int largest = left + 1 < size && arr[left+1] > arr[left] ? left+1 : left;
            largest = arr[index] > arr[largest] ? index : largest;
            //判断孩子和父节点中最大值 是否就是父节点
            if(index == largest){
                break;
            }
            //交换最大值 和父节点
            swap(arr,index,largest);
            //游标移动
            index = largest;
            //重新计算左孩子
            left = index * 2 + 1;
        }
    }



    //选择排序
    public static void selectSort31(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        //选择排序就是利用双层循环，内层循环每次找出一个相对最小的数字，然后依次移动到相对左侧 的过程
        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr,i,minIndex);
        }
    }
    //冒泡排序
    public static void bubbleSort31(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        //冒泡排序就是 大的数应该都移动到右边，依次都移动过去 排序就完成了
        for(int e = arr.length - 1; e > 0; e--){
            for(int i = 0; i < e; i++){
                if(arr[i] > arr[i+1]){
                    NumberUtil.swap(arr,i,i+1);
                }
            }
        }
    }
    //插入排序
    public static void insertSort27(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 1; i < arr.length; i++){
            for(int j = i - 1; j >= 0 && arr[j] > arr[j+1];j--){
                NumberUtil.swap(arr,j,j+1);
            }
        }
    }
    //归并排序
    public static void mergeSort21(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        process21(arr,0,arr.length - 1);
    }
    private static void process21(int[] arr, int l, int r) {
        if(l == r){
            return;
        }
        //取中间下标
        int mid = l + (r - l)/2;
        //递归处理左边
        process21(arr,l,mid);
        //递归处理右边
        process21(arr,mid+1,r);
        //合并处理结果
        mergeLAndR21(arr,l,mid,r);
    }
    private static void mergeLAndR21(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l +1];
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
        for(i = 0; i < help.length;i++){
            arr[l + i] = help[i];
        }
    }
    //快排
    public static void quickSort10(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        quickSort10(arr,0,arr.length-1);
    }
    private static void quickSort10(int[] arr, int l, int r) {
        if(l < r){
            //随机选取一个数 交换最后一个数字
            int random = l + (int)Math.random() * (r - l + 1);
            swap(arr,random,r);
            int[] p = partition10(arr,l,r);
            quickSort10(arr,l,p[0]-1);
            quickSort10(arr,p[1]+1,r);
        }
    }
    private static int[] partition10(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while(l < more){
            if(arr[l] < arr[r]){
                swap(arr,++less,l++);
            }else if(arr[l] > arr[r]){
                swap(arr,--more,l);
            }else{
                l++;
            }
        }
        //最后一个比较数换回来
        swap(arr,more,r);
        return new int[]{less+1,more};
    }
    //堆排
    public static void heapSort6(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int  i = 0 ; i<= arr.length - 1;i++){
            heapInsert6(arr,i);
        }
        //取出堆顶元素
        int size = arr.length;
        swap(arr,0,--size);
        while(size > 0){
            //堆化
            heapify6(arr,0,size);
            //继续溢出堆顶元素
            swap(arr,0,--size);
        }
    }
    //大根堆插入 只需要比较父节点即可
    public static void heapInsert6(int[] arr, int index){
        while(arr[index] > arr[(index - 1)/2]){
            //如果 当前节点大于父节点就交换
            swap(arr,index,(index - 1)/2);
            //移动指针位置 继续向上比较父节点 直到比较结束
            index = (index - 1)/2;
        }
    }
    //堆化就需要跟孩子进行比较 是自上而下的
    public static void heapify6(int[] arr,int index,int size){
        int left = index * 2 + 1;
        while(left < size){
            //找到孩子中最大的那个孩子 并且与父节点进行比较
            int largest = left+1 < size && arr[left+1] > arr[left] ? left+1 : left;
            largest = arr[index] > arr[largest] ? index : largest;
            if(index == largest){
                //说明孩子当中已经没有比父亲更大的节点了
                break;
            }
            swap(arr,index,largest);
            //指针移动
            index = largest;
            left = index * 2 +1;
        }
    }

    //选择排序
    public static void selectSort32(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 0; i < arr.length - 1; i++){
            //最小元素从0开始
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr,i,minIndex);
        }
    }
    //冒泡排序
    public static void bubbleSort32(int[] arr){
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
    //插入排序
    public static void insertSort28(int[] arr){
        if(null == arr || arr.length <2){
            return;
        }
        for(int i = 1; i < arr.length ; i++){
            for(int j = i - 1; j>=0 && arr[j]>arr[j+1];j--){
                NumberUtil.swap(arr,j,j+1);
            }
        }
    }
    //归并排序
    public static void mergeSort22(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        process22(arr,0,arr.length-1);
    }
    private static void process22(int[] arr, int l, int r) {
        if(l == r){
            return;
        }
        int mid = l + (r - l)/2;
        process22(arr,l,mid);
        process22(arr,mid+1,r);
        mergeLAndR22(arr,l,mid,r);
    }
    private static void mergeLAndR22(int[] arr, int l, int mid, int r) {
        //数组长度必须加1
        int[] help = new int[r - l + 1];
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
        for(i = 0; i < help.length;i++){
            arr[l+i] = help[i];
        }
    }
    //快排
    public static void quickSort11(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        quickSort11(arr,0,arr.length - 1);
    }
    private static void quickSort11(int[] arr, int l, int r) {
        if(l < r){
            int random = l + (int)Math.random() * (r - l + 1);
            swap(arr,random,r);
            int[] p = partition11(arr,l,r);
            quickSort11(arr,l,p[0]-1);
            quickSort11(arr,p[1]+1,r);
        }
    }
    private static int[] partition11(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while(l < more){
            if(arr[l] < arr[r]){
                swap(arr,++less,l++);
            }else if(arr[l] > arr[r]){
                swap(arr,--more,l);
            }else{
                l++;
            }
        }
        swap(arr,r,more);
        return new int[]{less+1,more};
    }
    //堆排
    public static void heapSort7(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        //构造大根堆
        for(int i = arr.length-1 ; i >=0;i--){
            heapify7(arr,i,arr.length);
        }
        int size = arr.length;
        swap(arr,0,--size);
        while(size > 0){
            heapify7(arr,0,size);
            swap(arr,0,--size);
        }
    }
    public static void heapInsert7(int[] arr,int index){
        while(arr[index] > arr[(index - 1)/2]){
            swap(arr,index,(index - 1)/2);
            index = (index - 1)/2;
        }
    }
    public static void heapify7(int[] arr,int index, int size){
        int left = index*2 +1;
        while(left < size){
            int largest = left+1 <size && arr[left+1]>arr[left] ? left+1:left;
            largest = arr[index] > arr[largest] ? index : largest;
            if(index == largest){
                break;
            }
            swap(arr,index,largest);
            index = largest;
            left = index * 2 +1;
        }
    }


    //每次温顾的时候，注意要理解不同算法之间的对比，同时也应该注意每一种算法的本质，快排为什么很快。插入排序为什么叫插入排序
    // 前三种排序浪费了每一次的比较行为 比较的结果都没有被记录下来，所以这种算法的时间复杂度会很高
    //选择排序
    public static void selectSort33(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 0; i < arr.length - 1; i++ ){
            int minIndex = i;
            for(int j = i+1; j < arr.length;j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr,i,minIndex);
        }
    }
    //冒泡排序
    public static void bubbleSort33(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int e = arr.length - 1; e > 0; e--){
            for(int i = 0; i< e; i++){
                if(arr[i] > arr[i+1]){
                    NumberUtil.swap(arr,i,i+1);
                }
            }
        }
    }
    //插入排序
    public static void insertSort29(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 1; i < arr.length; i++){
            for(int j = i - 1; j >= 0 && arr[j] > arr[j+1]; j--){
                NumberUtil.swap(arr,j,j+1);
            }
        }
    }
    //归并排序
    public static void mergeSort23(int[] arr){
        if(null == arr || arr.length <2){
            return;
        }
        process23(arr,0,arr.length - 1);
    }
    private static void process23(int[] arr, int l, int r) {
        if(l == r){
           return;
        }
        //不可以+1 会死循环 Stack Overflow
        int mid = l + (r - l)/2;
        process23(arr,l,mid);
        process23(arr,mid+1,r);
        mergeLAndR23(arr,l,mid,r);
    }
    private static void mergeLAndR23(int[] arr, int l, int mid, int r) {
        //数组长度必须加1 要不就不够存储元素了
        int[] help = new int[r - l + 1];
        //p1 和 p2 必须根据着每次方法调用传递进来的l mid 来定
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
        for(i = 0; i < help.length; i++){
            arr[l+i] = help[i];
        }
    }
    //快排
    public static void quickSort12(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        quickSort12(arr,0,arr.length-1);
    }
    private static void quickSort12(int[] arr, int l, int r) {
        if(l<r) {
            //所及选择一个数 交换到末尾 准备开始做工比较求范围
            int random = l + (int) Math.random() * (r - l );
            swap(arr, random, r);
            //开始做工 求比较范围
            int[] p = partition12(arr, l, r);
            quickSort12(arr, l, p[0] - 1);
            quickSort12(arr, p[1] + 1, r);
        }
    }
    private static int[] partition12(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while(l < more){
            if(arr[l] < arr[r]){
                swap(arr,++less,l++);
            }else if(arr[l] > arr[r]){
                swap(arr,--more,l);
            }else{
                l++;
            }
        }
        //一轮比较结束后  最后需要交换一下比较数
        swap(arr,more,r);
        //返回的是等于比较数的范围 所以要less+1
        return new int[]{less+1,more};
    }
    //堆排
    public static void heapSort8(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        //构造一个大根堆
        for(int i = 0; i < arr.length;i++){
            heapInsert8(arr,i);
        }
        int size = arr.length;
        //移除堆顶元素
        swap(arr,0,--size);
        while(size > 0){
            //把0-size 范围内的数字继续保持为大根堆
            heapify8(arr,0,size);
            swap(arr,0,--size);
        }
    }
    //堆插入向上比较 每次只需要比较当前插入的节点和父节点的关系
    public static void heapInsert8(int[] arr, int index){
        //只要子节点大于父节点 就一直向上
        while(arr[index] > arr[(index - 1)/2]){
            //交换子节点 与 父节点
            swap(arr,index,(index - 1)/2);
            //当前节点来到 父节点位置
            index = (index - 1)/2;
        }
    }
    //堆结构化 要向下追溯 判断范围index起始  到 size 位置的数组是否满足堆结构化 不满足就进行操作
    public static void heapify8(int[] arr, int index, int size){
        int left = index * 2 + 1;
        while(left < size){
            //比较左右孩子 取较大孩子
            int largest = left+1 < size && arr[left+1] > arr[left] ? left+1: left;
            //比较较大孩子 和 父节点
            largest = arr[largest] > arr[index] ? largest : index;
            if(index == largest){
                break;
            }
            swap(arr,index,largest);
            index = largest;
            left = index * 2 +1;
        }
    }

    //选择排序 时间复杂度O(n^2) 空间复杂度O(1)
    public static void selectSort34(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        int minIndex;
        for(int i = 0; i < arr.length - 1; i++){
             minIndex = i;
            for(int j = i+1; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr,i,minIndex);
        }
    }
    //冒泡排序 时间复杂度O(N^2) 空间复杂度 O(1)
    public static void bubbleSort34(int[] arr){
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
    //插入排序 时间复杂度O(n^2) 空间复杂度O(1)
    public static void insertSort30(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 1; i < arr.length; i++){
            for(int j = i - 1; j >= 0 && arr[j] > arr[j+1];j--){
                NumberUtil.swap(arr,j,j+1);
            }
        }
    }
    //归并排序
    public static void mergeSort24(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        process24(arr,0,arr.length-1);
    }
    private static void process24(int[] arr, int l, int r) {
        //如果左右两边已经相遇 则结束循环
        if(l == r){
            return;
        }
        //求中间位置
        int mid = l + (r - l)/2;
        //处理左边数据
        process24(arr,l,mid);
        //处理右边数据
        process24(arr,mid+1,r);
        //合并已经拍好需的左右两边
        mergeLAndR24(arr,l,mid,r);

    }
    private static void mergeLAndR24(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
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
        for(i = 0; i < help.length; i++){
            arr[l+i] = help[i];
        }
    }
    //快排
    public static void quickSort13(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        quickSort13(arr,0,arr.length-1);
    }
    private static void quickSort13(int[] arr, int l, int r) {
        if(l < r){
            int random = l + (int)Math.random() * (r - l);
            swap(arr,random,r);

            int[] p = partition13(arr,l,r);
            quickSort13(arr,l,p[0]-1);
            quickSort13(arr,p[1]+1,r);
        }
    }
    private static int[] partition13(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while(l < more){
            if(arr[l] < arr[r]){
                swap(arr,++less,l++);
            }else if(arr[l] > arr[r]){
                swap(arr,--more,l);
            }else{
                l++;
            }
        }
        //把比较数交换回来 他的位置应该是大于数的那一边
        swap(arr,more,r);
        return new int[]{less+1,more};
    }
    //堆排
    public static void heapSort9(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 0; i <= arr.length-1;i++){
            heapInsert9(arr,i);
        }
        int size = arr.length;
        swap(arr,0,--size);
        heapify9(arr,0,size);
        while(size > 0){
            swap(arr,0,--size);
            heapify9(arr,0,size);
        }
    }
    //堆插入 跟父节点比较
    public static void heapInsert9(int[] arr, int index){
        while(arr[index] > arr[(index - 1) /2] ){
            swap(arr,index,(index - 1) /2);
            index = (index - 1) /2;
        }
    }
    //堆化需要比较孩子
    public static void heapify9(int[] arr, int index, int size){
        int left = index*2 + 1;
        while(left < size){
            int largest = left+1 < size && arr[left+1] > arr[left] ? left+1 : left;
            largest = arr[index] > arr[largest] ? index : largest;
            if(index == largest){
                break;
            }
            swap(arr,index,largest);
            index = largest;
            left = index*2 + 1;
        }
    }

    //选择排序
    public static void selectSort35(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        int minIndex ;
        for(int i = 0; i < arr.length - 1; i++){
            minIndex = i;
            for(int j = i+1; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr,i,minIndex);
        }
    }
    //冒泡排序
    public static void bubbleSort35(int[] arr){
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
    //插入排序
    public static void insertSort31(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 1; i < arr.length; i++){
            for(int j = i - 1; j >= 0 && arr[j]>arr[j+1]; j--){
                NumberUtil.swap(arr,j,j+1);
            }
        }
    }
    //归并排序
    public static void mergeSort25(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        process25(arr,0,arr.length-1);
    }
    private static void process25(int[] arr, int l, int r) {
        if(l == r){ //左右下标相遇 时 代表着不需要递归 了直接返回合并左右两边 ，进行mergeArr的操作
            return;
        }
        //这个地方求mid是(r-l)加不加1都不重要，因为无非是给左边多一个距离和给右边多一个距离的问题，最终都会被分开成一半知道相遇 所以这里无所谓
        int mid = l + (r - l) /2;
        process25(arr,l,mid);
        process25(arr,mid+1,r);
        mergeLAndR25(arr,l,mid,r);
    }
    private static void mergeLAndR25(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
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
        for(i = 0; i < help.length; i++){
            arr[l+i] = help[i];
        }
    }
    //快排
    public static void quickSort14(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        quickSort14(arr,0,arr.length-1);
    }
    private static void quickSort14(int[] arr, int l, int r) {
        if(l < r){
            //随机找到一个索引 交换到最后一个数字上去
            int random = l + (int)Math.random() * (r - l);
            swap(arr,r,random);
            //然后进行排列求出一个大于小于等于的单位
            int[] p = partition14(arr,l,r);
            //根据返回的等于的范围 对大于小于的范围继续递归调用 求出他们内部的合理排列
            quickSort14(arr,l,p[0]-1);
            quickSort14(arr,p[1]+1,r);
        }
    }
    private static int[] partition14(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while(l < more){
            if(arr[l] < arr[r]){
                swap(arr,++less,l++);
            }else if(arr[l] > arr[r]){
                swap(arr,--more,l);
            }else{
                l++;
            }
        }
        //此时more不用--是因为 这个时候是吧一个等于比较数的数交换过来 然后把当前位置more这个大于比较数的数移动到最后
        swap(arr,more,r);
        return new int[]{less+1,more};
    }
    //堆排
    public static void heapSort10(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        //把数组构造成一个大根堆
        for(int i = 0; i < arr.length;i++){
            heapInsert10(arr,i);
        }
        //移除堆顶最大元素 并将堆结构大小减一
        int size = arr.length;
        swap(arr,0,--size);
        while(size > 0){
            //调整剩下元素为堆结构
            heapify(arr,0,size);
            //移除堆顶
            swap(arr,0,--size);
        }
    }
    public static void heapInsert10(int[] arr, int index){
        while(arr[index] > arr[(index - 1)/2]){
            swap(arr,index,(index - 1)/2);
            //index代表的是新插入的数，如果新插入这个数比较大，那么他就得一路比较上去 直到他不比他的父节点数字大为止
            index = (index - 1)/2;
        }
    }
    public static void heapify10(int[] arr,int index,int size){
        int left = index * 2 + 1;
        while(left < size){
            //找到当前节点的左右孩子中的较大值 跟父节点比较 把关系确定下来就是父节点必须大于子节点
            int largest = left+1 < size && arr[left+1] > arr[left] ? left+1 : left;
            largest = arr[index] > arr[largest] ? index : largest;
            if(index == largest){
                break;
            }
            swap(arr,index,largest);
            //下标往下移动
            index = largest;
            //继续寻找当前节点的左右孩子
            left = index * 2 + 1;
        }
    }

    //选择排序
    public static void selectSort36(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        int minIndex;
        for(int i = 0; i < arr.length-1;i++){
            minIndex = i;
            for(int j = i+1; j < arr.length;j++){
                minIndex = arr[j]<arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr,i,minIndex);
        }
    }
    //冒泡排序
    public static void bubbleSort36(int[] arr){
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
    //插入排序
    public static void insertSort32(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 1; i < arr.length;i++){
            for(int j = i-1; j >=0 && arr[j]>arr[j+1];j--){
                NumberUtil.swap(arr,j,j+1);
            }
        }
    }
    //归并排序
    public static void mergeSort26(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        process26(arr,0,arr.length-1);
    }
    private static void process26(int[] arr, int l, int r) {
        if(l == r){
            return;
        }
        int mid = l + (r - l)/2;
        process26(arr,l,mid);
        process26(arr,mid+1,r);
        mergeLAndR26(arr,l,mid,r);
    }
    private static void mergeLAndR26(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
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
        for(i = 0; i< help.length;i++){
            arr[l+i] = help[i];
        }
    }
    //快排
    public static void quickSort15(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        quickSort15(arr,0,arr.length-1);
    }
    private static void quickSort15(int[] arr, int l, int r) {
        if(l < r){
            int random = l + (int)Math.random()*(r - l);
            swap(arr,random,r);
            //摆楞摆楞 找到范围之后就行摆楞
            int[] p = partition15(arr,l,r);
            quickSort15(arr,l,p[0]-1);
            quickSort15(arr,p[1]+1,r);
        }
    }
    private static int[] partition15(int[] arr, int l, int r) {
        int less = l-1;
        int more = r;
        while(l < more){
            if(arr[l] < arr[r]){
                swap(arr,++less,l++);
            }else if(arr[l] > arr[r]){
                swap(arr,--more,l);
            }else {
                l++;
            }
        }
        swap(arr,more,r);
        return new int[]{less+1,more};
    }
    //堆排
    public static void heapSort11(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 0; i < arr.length; i++){
            heapInsert11(arr,i);
        }
        int size = arr.length;
        swap(arr,0,--size);
        while(size > 0){
            heapify11(arr,0,size);
            swap(arr,0,--size);
        }

    }
    public static void heapInsert11(int[] arr ,int index){
        while(arr[index] > arr[(index - 1)/2]){
            swap(arr,index,(index - 1)/2);
            index = (index - 1)/2;
        }
    }
    public static void heapify11(int[] arr ,int index, int size){
        int left = index * 2 + 1;
        while(left < size){
            int largest = left+1 < size && arr[left+1] > arr[left] ? left+1 : left;
            largest  = arr[index] > arr[largest] ? index : largest;
            if(index == largest){
                break;
            }
            swap(arr,index,largest);
            index = largest;
            left = index * 2 +1;
        }
    }



    //选择排序
    public static void selectSort37(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        int minIndex;
        for(int i = 0; i< arr.length - 1; i++){
            minIndex = i;
            for(int j = i + 1; j < arr.length;j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr,i,minIndex);
        }
    }
    //冒泡排序
    public static void bubbleSort37(int[] arr){
        if(null == arr || arr.length <2){
            return;
        }
        for(int e = arr.length-1; e > 0; e--){
            for(int i = 0; i < e; i++){
                if(arr[i] > arr[i+1]){
                    NumberUtil.swap(arr,i,i+1);
                }
            }
        }
    }
    //插入排序
    public static void insertSort33(int[] arr){
        if(null == arr || arr.length<2){
            return;
        }
        for(int i = 1;i < arr.length;i++){
            for(int  j = i -1; j >= 0 && arr[j]>arr[j+1];j--){
                NumberUtil.swap(arr,j,j+1);
            }
        }
    }
    //归并排序
    public static void mergeSort27(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        process27(arr,0,arr.length-1);
    }
    private static void process27(int[] arr, int l, int r) {
        if(l == r){
            return;
        }
        int mid = l + (r - l)/2;
        process27(arr,l,mid);
        process27(arr,mid+1,r);
        mergeLAndR27(arr,l,mid,r);
    }
    private static void mergeLAndR27(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
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
        for(i = 0; i < help.length; i++){
            arr[l+i] = help[i];
        }
    }
    //快排
    public static void quickSort16(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        quickSort16(arr,0,arr.length-1);
    }
    private static void quickSort16(int[] arr, int l, int r) {
        if(l < r){
            int random = l + (int)Math.random() * (r - l);
            swap(arr,random,r);
            int[] p = partition17(arr,l,r);
            quickSort16(arr,l,p[0]-1);
            quickSort16(arr,p[1]+1,r);
        }
    }
    private static int[] partition16(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while(l < more){
            if(arr[l] < arr[r]){
                swap(arr,++less,l++);
            }else if(arr[l] > arr[r]){
                swap(arr,--more,l);
            }else{
                l++;
            }
        }
        swap(arr,more,r);
        return new int[]{less+1,more};
    }
    //堆排
    public static void heapSort12(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 0 ; i< arr.length;i++){
            heapInsert12(arr,i);
        }
        int size = arr.length;
        swap(arr,0,--size);
        while(size > 0){
            heapify12(arr,0,size);
            swap(arr,0,--size);
        }
    }
    public static void heapInsert12(int[] arr,int index){
        while(arr[index] > arr[(index - 1)/2]){
            swap(arr,index,(index - 1)/2);
            index = (index - 1)/2;
        }
    }
    public static void heapify12(int[] arr,int index, int size){
        int left = index *2 +1;
        while(left < size){
            int largest = left+1 < size && arr[left+1] > arr[left] ? left+1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if(largest == index){
                break;
            }
            swap(arr,largest,index);
            index = largest;
            left = index * 2 +1;
        }
    }

    //选择排序
    public static void selectSort38(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        int minIndex;
        for(int i = 0; i < arr.length - 1; i++){
            minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr,i,minIndex);
        }
    }
    //冒泡排序
    public static void bubbleSort38(int[] arr){
        if(null == arr || arr.length <2){
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
    //插入排序
    public static void insertSort34(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 1; i < arr.length;i++){
            for(int j = i - 1; j >= 0 && arr[j] > arr[j+1]; j--){
                NumberUtil.swap(arr,j,j+1);
            }
        }
    }
    //归并排序
    public static void mergeSort28(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        process28(arr,0,arr.length-1);
    }
    private static void process28(int[] arr, int l, int r) {
        if(l == r){
            return;
        }
        int mid = l + (r - l)/2;
        process28(arr,l,mid);
        process28(arr,mid+1,r);
        mergeLAndR28(arr,l,mid,r);
    }
    private static void mergeLAndR28(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
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
        for(i = 0; i < help.length;i++){
            arr[l+i] = help[i];
        }
    }
    //快排
    public static void quickSort17(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        quickSort17(arr,0,arr.length-1);
    }
    private static void quickSort17(int[] arr, int l, int r) {
        if(l < r){
            int random = l + (int)Math.random() * (r -l);
            swap(arr,random,r);
            int[] p = partition17(arr,l,r);
            quickSort17(arr,l,p[0]-1);
            quickSort17(arr,p[1]+1,r);
        }
    }
    private static int[] partition17(int[] arr, int l, int r) {
        int less = l-1;
        int more = r;
        while(l < more){
            if(arr[l] < arr[r]){
                swap(arr,++less,l++);
            }else if(arr[l] > arr[r]){
                swap(arr,--more,l);
            }else{
                l++;
            }
        }
        swap(arr,more,r);
        return new int[]{less+1,more};
    }
    //堆排
    public static void heapSort13(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 0; i < arr.length;i++){
            heapInsert13(arr,i);
        }
        int size = arr.length;
        swap(arr,0,--size);
        while(size > 0){
            heapify13(arr,0,size);
            swap(arr,0,--size);
        }
    }
    public static void heapInsert13(int[] arr,int index){
        while(arr[index] > arr[(index - 1)/2]){
            swap(arr,index,(index - 1)/2);
            index = (index - 1)/2;
        }
    }
    public static void heapify13(int[] arr,int index, int size){
        int left = index * 2 +1;
        while(left < size){
            int largest = left+1 < size && arr[left+1] > arr[left] ? left+1 : left;
            largest = arr[index] > arr[largest] ? index :largest;
            if(index == largest){
                break;
            }
            swap(arr,index,largest);
            index = largest;
            left =  index * 2 +1;
        }
    }

    //选择排序
    public static void selectSort39(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        int minIndex;
        for(int i = 0; i < arr.length - 1; i++){
            minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr,i,minIndex);
        }
    }
    //冒泡排序
    public static void bubbleSort39(int[] arr){
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
    //插入排序
    public static void insertSort35(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 1; i < arr.length; i++){
            for(int j = i - 1; j >= 0 && arr[j] > arr[j+1]; j--){
                NumberUtil.swap(arr,j,j+1);
            }
        }
    }
    //归并排序
    public static void mergeSort29(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        process29(arr,0,arr.length - 1);
    }
    private static void process29(int[] arr, int l, int r) {
        if(l == r){
            return;
        }
        int mid = l + (r - l)/2;
        process29(arr,l,mid);
        process29(arr,mid+1,r);
        mergeLAndR29(arr,l,mid,r);
    }
    private static void mergeLAndR29(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
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
        for(i = 0; i < help.length; i++){
            arr[l+i] = help[i];
        }
    }
    //快排
    public static void quickSort18(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        quickSort18(arr,0,arr.length - 1);
    }
    private static void quickSort18(int[] arr, int l, int r) {
        if(l < r){
            int random = l + (int)Math.random() * (r - l);
            swap(arr,random,r);
            int[] p = partition18(arr,l,r);
            quickSort18(arr,l,p[0]-1);
            quickSort18(arr,p[1]+1,r);
        }
    }
    private static int[] partition18(int[] arr, int l, int r) {
        int less = l-1;
        int more = r;
        while(l < more){
            if(arr[l] < arr[r]){
                swap(arr,++less,l++);
            }else if(arr[l] > arr[r]){
                swap(arr,--more,l);
            }else{
                l++;
            }
        }
        swap(arr,more,r);
        return new int[]{less+1,more};
    }
    //堆排
    public static void heapSort14(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 0; i < arr.length;i++){
            heapInsert14(arr,i);
        }
        int size = arr.length;
        swap(arr,0,--size);
        while(size > 0){
            heapify14(arr,0,size);
            swap(arr,0,--size);
        }
    }
    public static void heapInsert14(int[] arr,int index){
        while(arr[index] > arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index = (index-1)/2;
        }
    }
    public static void heapify14(int[] arr, int index, int size){
        int left = index * 2 +1;
        while(left < size){
            int largest = left+1 < size && arr[left+1] > arr[left] ? left+1 : left;
            largest = arr[index] > arr[largest] ? index : largest;
            if(largest == index){
                break;
            }
            swap(arr,index,largest);
            index = largest;
            left = index * 2 +1;
        }
    }

    //选择排序
    public static void selectSort40(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        int minIndex;
        for(int i = 0; i < arr.length - 1; i++){
            minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr,i,minIndex);
        }
    }
    //冒泡排序
    public static void bubbleSort40(int[] arr){
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
    //插入排序
    public static void insertSort36(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 1; i < arr.length;i++){
            for(int j = i - 1; j >= 0 && arr[j] > arr[j+1]; j--){
                NumberUtil.swap(arr,j,j+1);
            }
        }
    }
    //归并排序
    public static void mergeSort30(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        process30(arr,0,arr.length-1);
    }
    private static void process30(int[] arr, int l, int r) {
        if(l == r){
            return;
        }
        int mid = l + (r - l)/2;
        process30(arr,l,mid);
        process30(arr,mid+1,r);
        mergeLAndR30(arr,l,mid,r);
    }
    private static void mergeLAndR30(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
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
        for(i = 0; i < help.length; i++){
            arr[l+i] = help[i];
        }
    }
    //快排
    public static void quickSort19(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        quickSort19(arr,0,arr.length-1);
    }
    private static void quickSort19(int[] arr, int l, int r) {
        if(l < r){
            int random = l + (int)Math.random() * (r - l);
            swap(arr,random,r);
            int[] p = partition19(arr,l,r);
            quickSort19(arr,l,p[0]-1);
            quickSort19(arr,p[1]+1,r);
        }
    }
    private static int[] partition19(int[] arr, int l, int r) {
        int less = l-1;
        int more = r;
        while(l < more){
            if(arr[l] < arr[r]){
                swap(arr,++less,l++);
            }else if(arr[l] > arr[r]){
                swap(arr,--more,l);
            }else{
                l++;
            }
        }
        swap(arr,more,r);
        return new int[]{less+1,more};
    }
    //堆排
    public static void heapSort15(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = arr.length-1; i >= 0; i--){
            heapify15(arr,i,arr.length);
        }
        int size = arr.length ;
        swap(arr,0,--size);
        while(size > 0){
            heapify15(arr,0,size);
            swap(arr,0,--size);
        }
    }
    public static void heapInsert15(int[] arr, int index){
        while(arr[index] > arr[(index - 1)/2]){
            swap(arr,index,(index - 1)/2);
            index = (index - 1)/2;
        }
    }
    public static void heapify15(int[] arr, int index, int size){
        int left = index * 2 + 1;
        while(left < size){
            int largest = left + 1 < size && arr[left+1] > arr[left] ? left + 1 : left;
            largest = arr[index] > arr[largest] ? index : largest;
            if(index == largest){
                break;
            }
            swap(arr,index,largest);
            //探针需要 移动到 子节点上
            index = largest;
            left = index * 2 + 1;
        }
    }



    //讲一个数组里面的奇数放左边 偶数放在右边
    public static void method1(int[] arr){
        int left = 0;
        int right = arr.length-1;
        while(left < right){
            while(left < right && ((arr[left] % 2 )!= 0)){
                left++;
            }
            while(left < right && ((arr[right] % 2) == 0)){
                right--;
            }
            swap(arr,left,right);
        }
    }
//
//    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5,6,7,8,9};
//        method1(arr);
//        PrintUtil.printArr(arr);
//    }

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
            int[] arr3 = {7,3,2,5};
            selectSort40(arr1);
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
        selectSort40(arr);
        PrintUtil.printArr(arr);
    }


}
