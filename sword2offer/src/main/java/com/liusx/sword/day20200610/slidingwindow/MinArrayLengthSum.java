package com.liusx.sword.day20200610.slidingwindow;

/**
 * description: MinArrayLengthSum <br>
 * date: 2020/6/10 10:46 <br>
 * author: liusx <br>
 * version: 1.0 <br>
 *     滑动窗口算法应用：求长度最小的子数组
 */
public class MinArrayLengthSum {

    /*
    * 题目描述
       给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
        示例:
        输入: s = 7, nums = [2,3,1,2,4,3]
        输出: 2
        解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
    * */

    public static int minSubArrayLen(int s, int[] nums) {
        //首先判断极端情况
        if(nums.length <= 0){
            return 0;
        }
        //从pos 到 end 的值总和  是sum。 最小长度是min
        int end = 0;
        int min = Integer.MAX_VALUE;
        int sum = nums[0];

        for (int pos = 0; pos < nums.length ; pos++) {
            //不断查找大于等于 s  的区间
            while(sum < s){
                if(end + 1 < nums.length){
                    end++;
                    sum += nums[end];
                }else{
                    break;
                }
            }
            //找到了区间之后，计算数组长度
            if(sum >= s){
                min = ((end - pos +1) < min) ? (end - pos +1) : min;
            }
            //窗口左边移动一个位置，继续下一轮
            sum -= nums[pos];
        }
        
        return  min == Integer.MAX_VALUE ? 0 : min;
    }


    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7,nums));
    }
}
