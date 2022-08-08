package com.liusx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：liusx
 * @date ：Created in 2022/8/6 21:08
 * @description：八月份做的leetcode 题目思路详细说明
 * @version: 1.0
 */
public class TopicsListForAugust {


    /**
     * topic one 合并两个有序数组
     * 本质上就是归并排序的merge过程。在这个方法中 m和n的大小非常重要 这决定着循环的终止条件
     *
     * @param nums1 数组1
     * @param m     数组1的长度
     * @param nums2 数组2
     * @param n     数组2的长度
     */
    static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;
        int index = 0;
        int[] help = new int[m + n];
        while (p1 < m && p2 < n) {
            help[index++] = nums1[p1] <= nums2[p2] ? nums1[p1++] : nums2[p2++];
        }
        while (p1 < m) {
            help[index++] = nums1[p1++];
        }
        while (p2 < n) {
            help[index++] = nums2[p2++];
        }
        for (index = 0; index < help.length; index++) {
            nums1[index] = help[index];
        }
    }

    /**
     * topic two ： 数组中的字符串匹配
     * 给你一个字符串数组 words ，数组中的每个字符串都可以看作是一个单词。请你按 任意 顺序返回 words 中是其他单词的子字符串的所有单词。
     * 例如：
     * 输入：words = ["leetcode","et","code"]
     * 输出：["et","code"]
     * 解释："et" 和 "code" 都是 "leetcode" 的子字符串。
     * <p>
     * 输入：words = ["blue","green","bu"]
     * 输出：[]
     * <p>
     * 注意：这题的关键点是 去重
     * 怎么做到去重呢？关键点是要深挖出题目中的隐藏含义：一个字符串如果成为子串之后，就不能作为别的字符串的母串了
     * 比如{"navigate","av","ga","vi","navigat"};
     * navigat 是 navigate的子串 那么他就不可能成为其他任何字符串的母串。
     * 所以说下面的第一种解法，直接break的原因就是因为 让j循环的里面的数字挨个跟i比较 而不是让i这个字符串 挨个是比较j循环
     * 因为 法1中的字符串i只可能是一个字符串的子串，所以一旦找到一个contains 成功的就直接break；这样就避免的了方法2的重复
     *
     * @param words 字符串数组
     * @return 返回一个子串集合
     */
    public static List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<String>();
        int length = words.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                // i 只要是j中任何一个字符串的子串 直接结束
                if (i != j && words[j].contains(words[i])) {
                    result.add(words[i]);
                    break;
                }
            }
        }
        return result;
    }

    public static List<String> stringMatching1(String[] words) {
        List<String> result = new ArrayList<String>();
        int length = words.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i != j && words[i].contains(words[j])) {
                    result.add(words[j]);
                    // i 去挨个的找j中的哪个是他的孩子 就会重复
                    continue;
                }
            }
        }
        return result;
    }

    /*public static void main(String[] args) {
        String[] words = {"navigate","av","ga","vi","navigat"};

        List<String> list = stringMatching1(words);
        for (String s : list) {
            System.out.println(s);
        }
    }*/


    /**
     * 数组中的多数元素
     * 给定一个数组，大小为n，返回这个数组中出现次数大于n/2 的数字 数组中总是会存在多数元素即数组的重复度很高 一定会有一个数出现了一半的次数
     * <p>
     * 属于排序标签的题目，那么它到底应该用哪个思路来做呢？
     * 他要知道数组中某个数字出现的次数，这不首先想到词频的概念吗，那不就是桶排序来解决吗
     * <p>
     * 还是自己轻敌了，这道题不是用桶排序来做的。官方给的解答中有两个比较值得借鉴的思想
     * 1、排序然后直接取中间位置数字的思想。这个思想的重要性是，完完全全读懂了题目，给出的最省力的最简单最直接的方法
     * 因为题目说了一定会存在出现次数大于n/2的数字，那么就说明有一个数一定是出现次数是大于一半的
     * 那么我们就直接实现一个排序算法，然后排完序之后，去中间位置的那个数字就是这个出现次数最多的
     * 即：无论是1 1 1 2 3，0 1 1 1 2还是-1 0 1 1 1，数组中间的元素总是“多数元素”，毕竟它长度> ⌊ n/2 ⌋。
     * <p>
     * 2、摩尔投票法思路
     * 这个思路就是我最开始想要用的计数的方式，但是我想到这种方式之后没有继续深入的去思考，他的思路是这样的
     * 遍历数组，候选人初始化是nums[0]即默认第一个数字是候选人，然后候选人的票数默认是1
     * 当遇到和候选人相同的数字时 票数加1 当遇到和候选人不一致的数字时 票数减1
     * 当票数等于0的时候更换候选人，并且将候选人的票数重置为1
     * 遍历完数组之后 留下的候选人一定是出现次数最多的那个。
     * 为何这样的方式行得通呢？
     * 因为“多数元素”的个数 - 其余元素的个数总和 的结果 肯定 >= 1。
     * 所以最终多数元素和 其余元素之间 两两抵消 抵消到最后肯定还剩下至少 1 个 多数元素
     * 这就是摩尔投票法
     */
    static int majorityElement(int[] nums) {
        // 自己实现一个堆排序方法 因为只有它是复合 时间复杂度O(N)以下，然后空间复杂度O(1)
        heapSort(nums);
        // 返回n/2位置的数字
        return nums[(nums.length >> 1)];
    }

    static void heapSort(int[] nums) {
        Arrays.sort(nums);
    }
    // 投票法
    static int majorityElement2(int[] nums) {
        int candidate = nums[0];
        int votes = 1;
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] == candidate)) {
                votes++;
            } else {
                votes--;
            }
            if (votes == 0) {
                candidate = nums[i];
                votes = 1;
            }
        }
        return candidate;
    }

 /*   public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 2, 2, 2, 2, 3, 4};
        int i = majorityElement2(nums);
        System.out.println(i);
    }
*/
    //给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
    static boolean containsDuplicate(int[] nums) {
        // 暴力迭代 双层循环
        for (int i = 0; i < nums.length-1; i++) {
            // 注意自己不能跟自己比 同时每一个数只需要跟自己后面的数比就可以了，因为前面的数都跟自己比较过了
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
    static boolean containsDuplicate1(int[] nums) {
        // 排序后 判断相邻两个数是否相等
        Arrays.sort(nums);
        // 循环的边界条件注意
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,1};
        boolean result = containsDuplicate1(nums);
        System.out.println(result);
    }
}
