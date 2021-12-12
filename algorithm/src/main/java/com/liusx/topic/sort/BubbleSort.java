package com.liusx.topic.sort;

import com.liusx.util.NumberUtil;
import com.liusx.util.PrintUtil;

/**
 * @author ：liusx
 * @date ：Created in 2021/12/11 17:33
 * @description：冒泡排序
 * @version: 1.0
 */
public class BubbleSort {
    /**
     * 冒泡排序的思路 相邻两个数比较，比较之后谁大谁往右移
     * 注意每个数都需要和左右两个数交换位置 向右交换
     * 肯定是双重循环
     */


    public static void bubbleSortMy(int[] arr){

        for(int i = 0; i < arr.length; i++){
            for(int j = i; j < arr.length - 1; j++){
                if(arr[j] > arr[j+1]){
                    swap(arr,i,j);
                }
            }
        }
    }

    public static void bubbleSort(int[] arr){
        for(int e = arr.length - 1; e > 0; e--){
            for(int i = 0; i < e; i++){
                if(arr[i] > arr[i + 1]){
                    swap(arr,i,i+1);
                }
            }
        }
    }


    private static void swap(int[] arr, int max, int min) {
        int temp = arr[min];
        arr[min] = arr[max];
        arr[max] = temp;
    }

    public static void main(String[] args){

        int[] arr = NumberUtil.getIntArrBySize(5,300);
        PrintUtil.printArr(arr);
        bubbleSort(arr);
        PrintUtil.printArr(arr);

    }


}
