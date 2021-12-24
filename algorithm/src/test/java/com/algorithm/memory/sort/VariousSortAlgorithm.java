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
    public static void selectSort5(int[] arr){
        if(null == arr || arr.length < 2){
            return ;
        }
        for(int i = 0; i < arr.length - 1; i++){
            int minIndex= i;
            //内侧循环执行一遍 找出来一个最小的数字 j从i+1开始，因为已经移动到左侧的数字就不用判断了
            for(int j = i + 1; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr,i,minIndex);
        }
    }
    //冒泡排序 只要存在左侧数字大于右侧数字 就把两者交换位置
    public static void bubbleSort5(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        //这个说是不着最大，其实冒泡一次，就会有一个最大的数移动到最右边。
        for(int e = arr.length - 1; e > 0; e--){
            for(int i = 0; i < e; i++){
                if(arr[i] > arr[i + 1]){
                    NumberUtil.swap(arr,i,i+1);
                }
            }
        }
    }
    //插入排序，保证0 ~ N 之间的数 都有序 双层循环，外层控制的是 0~N中的N
    public static void insertSort1(int[] arr){
        if(null == arr || arr.length < 2){
            return ;
        }
        // 0~0 只有一个数字，不需要保证，直接从1开始
        // 0~n 注意内存循环的终止条件 j>=0并且 左边的数还比右边的数大 那就交换
        for(int i = 1; i < arr.length; i++){
            for(int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--){
                NumberUtil.swap(arr,j,j+1);
            }
        }
    }

    //选择排序，每次寻找最小数移动到最左侧
    public static void selectSort6(int[] arr){
        if(null == arr || arr.length < 2){
            return ;
        }
        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j <arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr,i,minIndex);
        }
    }
    //存在左侧数字比右侧数字大 就把两个数字交换，最后最大的一个数字会移动到最右侧
    public static void bubbleSort6(int[] arr){
        if(null == arr || arr.length < 2){
            return ;
        }
        for(int e = arr.length - 1; e > 0; e--){
            for(int i = 0; i < e; i++){
                if(arr[i] > arr[i + 1]){
                    NumberUtil.swap(arr,i, i+1);
                }
            }
        }
    }

    //插入排序要做到0~N每一个范围内的数字都有序 所以双层循环 外层循环控制范围 内层循环控制有序 无需就交换
    //当
    public static void insertSort2(int[] arr){
        if(null == arr || arr.length < 2){
            return ;
        }
        //从第一个数字开始 比较 0-1之间是否有序
        for(int i = 1; i < arr.length;i++){
            for(int j = i - 1; j >=0 && arr[j] > arr[j + 1]; j--){
                NumberUtil.swap(arr,j,j+1);
            }
        }
    }

    //选择排序 每次找出最小值然后放在最左边
    public static void selectSort7(int[] arr){
        if(null == arr || arr.length < 2){
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
    //冒泡排序 如果存在左边的数比右边的数大，交换 实际每次循环结束都会找到一个最大的移动到右边
    public static void bubbleSort7(int[] arr){
        if(null ==arr || arr.length < 2){
            return;
        }
        for(int e = arr.length - 1; e > 0; e--){
            for(int i = 0; i < e; i++){
                if(arr[i] > arr[i + 1]){
                    NumberUtil.swap(arr,i,i+1);
                }
            }
        }
    }
    //保证0-N之间的每一个范围内都是有序的
    public static void insertSort3(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        //从1开始
        for(int i = 1; i < arr.length ; i++){
            for(int j = i - 1; j >=0 && arr[j] > arr[j + 1];j--){
                NumberUtil.swap(arr,j,j+1);
            }
        }
    }

    public static void main(String[] args) {
        int[] intArrBySize = NumberUtil.getIntArrBySize(10, 100);
        PrintUtil.printArr(intArrBySize);
        insertSort3(intArrBySize);
        PrintUtil.printArr(intArrBySize);
    }


}
