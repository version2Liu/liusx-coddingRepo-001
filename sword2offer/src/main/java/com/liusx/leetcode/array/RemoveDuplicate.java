package com.liusx.leetcode.array;

/**
 * description: RemoveDuplicate 删除有序数组中的重复元素<br>
 * date: 2020/8/3 0003 21:43 <br>
 * author: Administrator <br>
 * version: 1.0 <br>
 * 题目描述：给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间(即不要在新开辟数组了)，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 示例 1:
 给定数组 nums = [1,1,2],
 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 你不需要考虑数组中超出新长度后面的元素。

 示例 2:
 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 你不需要考虑数组中超出新长度后面的元素。这句话的意思是，除了不重复的元素之外的其他数组位置上的元素不管是什么都不重要了，只需要将不重复的元素连在一起，就可以
 */
public class RemoveDuplicate {



    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums)+"------");
        for (int i = 0; i <nums.length ; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     * description: removeDuplicates 我自己写的第一个版本，看了其他群友写的版代码发现，我可以优化一下空间，减少空间使用率<br>
     * version: 1.0 <br>
     * date: 2020/8/3 0003 22:05 <br>
     * author: liusx <br>
     * @param: nums
     * @return int
    */
    public static int removeDuplicates(int[] nums) {
        //因为是有的数组，所以就比较简单点。可以通过设置标志变量的方式，来做检查
        //我把下面这种设置标志变量的方法叫做，傻狍子捡苞米。index变量就好像是一个傻狍子。index只要找到一个不一样的上一个我就扔掉了，不要了。一直比下去，如果有不一样的我才捡起来，然后之前的那个就扔掉
        if(nums.length == 0){
            return 0;
        }
        int index = 0;
        int temp = nums[0];
        for (int i=1; i<nums.length; i++){
            if(nums[i] != temp){
                temp = nums[i];
                nums[++index] = nums[i];
            }
        }
        return index+1;
    }

    public static int removeDuplicates2(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int index = 0;
        for (int i=1; i<nums.length; i++){
            if(nums[i] != nums[index]){
                nums[++index] = nums[i];
            }
        }
        return index+1;
    }
}
