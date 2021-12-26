package com.liusx.util;

import com.liusx.topic.sort.BubbleSort;
import com.liusx.topic.sort.InsertSort;
import com.liusx.topic.sort.SelectSort;

/**
 * @author ：liusx
 * @date ：Created in 2021/12/26 12:15
 * @description：压力测试验证算法的正确性
 * @version:
 */
public class PressureTest {

    public static void pressureTest(){
        int testTIme = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for(int i= 0; i < testTIme; i++){
            int[] arr1 = NumberUtil.generateRandomArray(maxSize,maxValue);
            int[] arr2 = NumberUtil.copyArray(arr1);
            InsertSort.insertSort1(arr1);
            NumberUtil.comparator(arr2);
            if(!NumberUtil.isEqual(arr1,arr2)){
                succeed = false;
                PrintUtil.printArr(arr1);
                PrintUtil.printArr(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Oh no u are fail!");

        int[] arr = NumberUtil.generateRandomArray(maxSize,maxValue);
        PrintUtil.printArr(arr);
        InsertSort.insertSort1(arr);
        PrintUtil.printArr(arr);
    }


    public static void main(String[] args) {
        pressureTest();
    }



}
