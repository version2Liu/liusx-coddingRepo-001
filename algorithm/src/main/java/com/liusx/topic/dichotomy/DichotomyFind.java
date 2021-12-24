package com.liusx.topic.dichotomy;

import com.liusx.util.NumberUtil;
import com.liusx.util.PrintUtil;

/**
 * @author ：liusx
 * @date ：Created in 2021/12/23 19:48
 * @description：二分查找专题
 * @version: 1.0
 */
public class DichotomyFind {

    public static int findNum(int[] arr, int num){
        if(null == arr || arr.length < 1){
            return -1;
        }
//        if(arr[0] == num){
//            return 0;
//        }
        int start = 0;
        int end = arr.length - 1;
        while(end >= start){
            int middle = (start + end) / 2 ;
            if(arr[middle] == num){
                return middle;
            }
            if(arr[middle] > num){
                end = middle - 1;
            }else{
                start = middle + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
//        int[] arr = {7};
//        PrintUtil.printArr(arr);
//        int key = 7;
//        int num = findNum(arr, key);
//        System.out.println("we look ："+ key + "   it's index is：" + num);

        int middle = (2 + 7) / 2;
        int mid = 2 + ((7 -2) >> 1);

        System.out.println(middle);
        System.out.println(mid);


    }




}
