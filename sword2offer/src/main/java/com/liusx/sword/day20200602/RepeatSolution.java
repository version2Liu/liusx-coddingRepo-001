package com.liusx.sword.day20200602;

import java.util.HashSet;
import java.util.Set;

/**
 * description: RepeatSolution <br>
 * date: 2020/6/2 11:46 <br>
 * author: liusx <br>
 * version: 1.0 <br>

 title :找出数组中重复的数字。
    在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
    数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

 示例 1：
 输入：
 [2, 3, 1, 0, 2, 5, 3]
 输出：2 或 3
 限制：
 2 <= n <= 100000
 */
public class RepeatSolution {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(nums));
        System.out.println(findRepeatNumberGF(nums));
    }

    /**
     * description: findRepeatNumberGF <br>
     *     官方解法利用set的不可重复性来做去重操作。只需要遍历一遍数组即可，时间复杂度为O(n).空间复杂度也为O(n)
     * version: 1.0 <br>
     * date: 2020/6/2 13:50 <br>
     * author: liusx <br>
     * @param: nums
     * @return int
    */
    public static int findRepeatNumberGF(int[] nums) {
        int repeatNum = -1;
        Set<Integer> set = new HashSet<Integer>();
        for (int num: nums) {
            if(!set.add(num)){
                //set.add()如果已存在元素，则返回false。则说明已重复。所以set可以用来去重。
                repeatNum = num;
                break;
            }
        }
        return repeatNum;
    }




    /**
     * description: findRepeatNumber <br>
     *      解题思路：双层循环遍历数组，从第1个数字开始，依次拿着后面的数字跟这个数字进行比较，如果有相等的直接返回。
     * version: 1.0 <br>
     * date: 2020/6/2 11:47 <br>
     * author: liusx <br>
     * @param: nums 一组包含重复数字的数组
     * @return int 要求找到数组中任意一个重复的数字，所以只需要返回一个数字即可。
    */
    public static int findRepeatNumber(int[] nums) {
        int length = nums.length;
        if(length < 2 || length > 100000){
            throw new IllegalArgumentException("No two sum solution");
        }

        int temp;
        for (int i = 0; i < length; i++) {
            temp = nums[i];
            for (int j = i+1; j < length ; j++) {
                if(nums[j] == temp){
                    return temp;
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


}
