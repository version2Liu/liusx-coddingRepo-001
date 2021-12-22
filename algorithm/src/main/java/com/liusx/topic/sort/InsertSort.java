package com.liusx.topic.sort;

import com.liusx.util.NumberUtil;
import com.liusx.util.PrintUtil;

/**
 * @author ：liusx
 * @date ：Created in 2021/12/22 10:16
 * @description：插入排序
 * @version: 1.0
 */
public class InsertSort {

    /**
     * 解题思路：做到0~N位置上的数有序
     * 意思就是说先做到0~0，0~1，0~2，0~3，.... 0~N 这就是整体的解题思路。一点一点的保证每一个区间内的数都有序
     * 所以还是双层循环，外层循环控制的是有序的范围，内层循环负责比较是否需要交换
     * 比较内容：
     * 如果自己的左侧有比自己还大的数，就交换
     * 循环终止条件：
     * 1、左侧有没有比自己还大的数
     * 2、左侧没有数了。
     *
     * @param arr
     */
    public static void insertSort1(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        //因为0~0只有一个数字，肯定是有序的，所以直接从1开始
        for (int i = 1; i < arr.length; i++) {
            //[2,1,3,5,4,7]
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                NumberUtil.swap(arr, j, j + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = NumberUtil.getIntArrBySize(10, 100);
        PrintUtil.printArr(arr);
        insertSort1(arr);
        PrintUtil.printArr(arr);
    }


}
