package com.algorithm.memory;

import com.liusx.util.PrintUtil;

/**
 * @author ：liusx
 * @date ：Created in 2022/7/31 21:47
 * @description：
 * @version:
 */
public class TestMain {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        PrintUtil.printArr(nums1);
        PrintUtil.printArr(nums2);
        merge(nums1, 3, nums2, 3);
        PrintUtil.printArr(nums1);

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;
        int index = 0;
        int[] help = new int[m+n];
        while (p1 < m && p2 < n) {
            help[index++] = nums1[p1] <= nums2[p2] ? nums1[p1++] : nums2[p2++];
        }
        while (p1 < m) {
            help[index++] = nums1[p1++];
        }
        while (p2 < n) {
            help[index++] = nums2[p2++];
        }
        for(index = 0; index < help.length;index++){
            nums1[index] = help[index];
        }
    }

}
