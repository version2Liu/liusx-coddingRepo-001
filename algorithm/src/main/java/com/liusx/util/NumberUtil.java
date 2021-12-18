package com.liusx.util;

import java.util.Random;

/**
 * @author ：liusx
 * @date ：Created in 2021/12/11 17:47
 * @description：数字工具类
 * @version: 1.0
 */
public class NumberUtil {

    /**
     * 交换数组中两个位置的数
     * @param arr 数组
     * @param left 左边的数的下标
     * @param right 右边的数的下标
     */
    public static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }



    /**
     * 获取指定范围内 指定 个数 的int类型数组
     * @param size 数组大小
     * @param max 数组内的最大数字
     * @return
     */
    public static int[] getIntArrBySize(int size,int max){
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = getRandomIntNumber(max);
        }
        return arr;
    }

    /**
     * 获取不大于指定数字的随机数
     * @param max
     * @return
     */
    private static int getRandomIntNumber(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }


    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            System.out.println(random.nextInt(100)+1);
        }
    }
}
