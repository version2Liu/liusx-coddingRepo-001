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
     * @param arr
     */
    public static void selectionSort(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 0; i < arr.length - 1; i++){ //第一个循环 遍历 0 ~ N-1
            int minIndex = i; //最小数字下标
            for(int j = i + 1; j < arr.length; j++){
                //内层循环遍历寻找最小数值 的下标
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            //一层循环结束后，交换位置。
            NumberUtil.swap(arr,i,minIndex);
        }
    }

    /**
     * 两两比较 如果发现有相邻两个数中左边数大于右边的数 就把大数移动到右边
     * 所以指针的移动就是应该由最右边开始 每次循环之后，右边都会多一个最大的数
     * 为什么这样移动 最大的那个数字一定会被移动到右边呢？？？？
     * 这样移动的特点就是 每次都能把剩下数里面最大的数移动到右边
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        if(null == arr || arr.length < 2){
            return ;
        }
        //对 0 ~ length-1 的数进行两两比较 右边界就是最后一个数
        for(int e = arr.length - 1; e > 0; e--){
            for(int i = 0; i < e; i++){
                if(arr[i] > arr[i + 1]){
                    NumberUtil.swap(arr,i,i+1);
                }
            }
        }
    }


    //选择排序 双层循环 内层循环每次找出来当前最小的一个数，放在最左边
    //做算法题 想好起始条件，想好终止条件(终止条件其实就是边界问题) 这个问题中边界问题就是保证内层循环不要越界
    public static void selectSort1(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 0; i < arr.length - 1; i++){//保证内层循环不越界
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr,i,minIndex);
        }
    }
    //冒泡排序 如果发现有左边的数 比右边的数大的，就把这两个数交换一下
    public static void bubbleSort1(int[] arr){
        if(null == arr || arr.length < 2){
            return ;
        }
        for(int e = arr.length - 1; e > 0; e--){// 防止下方i+1 越界 所以e是最外层的屏障
            for(int i = 0; i < e; i++){
                if(arr[i] > arr[i+1]){
                    NumberUtil.swap(arr,i,i+1);
                }
            }
        }
    }

    //选择排序每次找最大的，放在最左边，双层循环，注意下标悦姐问题
    public static void selectSort2(int[] arr){
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

    // 双层循环 如果发现左边数比右边数大 就移动位置
    public static void bubbleSort2(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int e = arr.length - 1; e > 0; e--){
            for(int i = 0; i < e; i++){
                if(arr[i] > arr[i +1]){
                    NumberUtil.swap(arr,i,i+1);
                }
            }
        }
    }

    //选择排序，双层循环 内层每次找到一个最小的数字 放在最左侧
    public static void selectSort3(int[] arr){
        if(null == arr || arr.length < 2){
            return ;
        }
        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr,i,minIndex);
        }
    }

    //冒泡排序 如果存在左侧大于右侧的数，就把两个数交换位置
    public static void bubbleSort3(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int e = arr.length - 1; e > 0; e--){
            for(int i = 0; i < e; i++){
                if(arr[i] > arr[i + 1]){
                    NumberUtil.swap(arr,i,i + 1);
                }
            }
        }
    }

    //选择排序 双层循环 选出最小的数字放在最左边 重点循环条件
    public static void selectSort4(int[] arr){
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

    public static void bubbleSort4(int[] arr){
        if(null == arr || arr.length < 2){
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


    public static void main(String[] args) {
        int[] intArrBySize = NumberUtil.getIntArrBySize(10, 100);
        PrintUtil.printArr(intArrBySize);
        selectSort4(intArrBySize);
        PrintUtil.printArr(intArrBySize);
    }


}
