package com.liusx.topic.recursion;

import com.liusx.util.NumberUtil;
import com.liusx.util.PrintUtil;

/**
 * @author ：liusx
 * @date ：Created in 2021/12/24 10:08
 * @description：普通递归
 * @version:
 */
public class SimpleRecursion {

    /**
     * 求数组在 l - r 范围内的最大值
     * @param arr 数组
     * @param l 左范围
     * @param r 右范围
     */
    public static int process(int[] arr, int l, int r){
        //递归的终极奥义就是 将所有复杂的问题 最后都拆解为一个数或者两个数来搞
        if(l == r){
            //这就是终极奥义，最后都变成了一个数，然后返回，返回之后通过Math的max函数有比较就的出来了两个数的最大的数
            //以此类推网上倒追就发现所有的数都被比较了一遍
            return arr[l];
        }
        //防止内存溢出，不推荐采用(l+r)/2的方式求中间值
        int mid = l + ((r - l) >> 1);
        int leftMax = process(arr,l,mid);
        int rightMax = process(arr,mid + 1,r);
        return Math.max(leftMax,rightMax);
    }

    public static void main(String[] args) {
        int[] arr = NumberUtil.getIntArrBySize(11, 100);
        PrintUtil.printArr(arr);
        int process = process(arr, 3, 7);
        System.out.println(process);
    }


}
