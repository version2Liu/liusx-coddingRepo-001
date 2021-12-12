package com.liusx.topic.sort;

import com.liusx.util.NumberUtil;
import com.liusx.util.PrintUtil;

/**
 * @author ：liusx
 * @date ：Created in 2021/12/11 15:40
 * @description：选择排序
 * @version: 1.0
 */
public class SelectSort {


    /**
     * 选择排序算法思路
     * 对长度为N的数组 遍历N-1 次 每次找一个最小的数 放在i的位置 i 从0开始
     *
     * @param arr
     * @return
     */
    public static int[] selectSort(int[] arr){
        //遍历整个数组
        for (int i = 0; i < arr.length; i++) {
            //记录最小值的值
            int minNUm = arr[i];
            //记录最小值的索引 从i开始
            int index = i;
            for(int j = i+1; j <= arr.length-1; j++){
                //寻找最小数每次从i开始，找到后赋值给minNum
                if(minNUm > arr[j]){
                    //找到最小数就改变这两个变量的值
                    minNUm = arr[j];
                    index = j;
                }
            }
            //一次变量结束后 就进行一次交换
            int temp = arr[i];
            arr[i] = minNUm;
            arr[index] = temp;
        }

        return arr;
    }

    /**
     * 选择排序优化算法
     * @return
     */
    public static void selectionSort(int[] arr){
        //写算法必须考虑计算情况
        if(null == arr ||  arr.length < 2){
            return ;
        }
        for(int i = 0 ; i < arr.length - 1; i++){ //排查 i ~ N-1 的数
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr,i,minIndex);
        }
    }

    private static void swap(int[] arr, int i, int minIndex) {
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }


    public static void main(String[] args){

        int[] arr = NumberUtil.getIntArrBySize(11,100);
        PrintUtil.printArr(arr);
        selectionSort(arr);
        PrintUtil.printArr(arr);

    }


}
