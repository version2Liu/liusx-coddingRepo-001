package com.liusx.sword.day20200604;

/**
 * description: Matrix 在二维数组中查找目标元素<br>
 * date: 2020/6/4 8:41 <br>
 * author: liusx <br>
 * version: 1.0 <br>
 */
public class Matrix {

    /*
    * 题目： 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
    * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
    * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
    * 示例：现有如下矩阵：
    *   [
          [1,   4,  7, 11, 15],
          [2,   5,  8, 12, 19],
          [3,   6,  9, 16, 22],
          [10, 13, 14, 17, 24],
          [18, 21, 23, 26, 30]
        ]
            给定 target = 5，返回 true。
            给定 target = 20，返回 false。
        限制：
            0 <= n <= 1000
            0 <= m <= 1000
    *
    * 我的解题思路 ：
    * 遍历二维数组，并对每一列的第一行进行判断，如果小于目标数则可以继续遍历，如果大于目标数则结束遍历
    *
    * */


    public static boolean findNumberIn2DArray(int[][] matrix, int target) {

        //防止传入空数组
        if(null == matrix || matrix.length == 0 || matrix[0].length ==0)
            return false;

        //这道题研究的是二维数组的使用。
        for (int[] ints : matrix) {
            if (ints[0] > target)
                continue;
            for (int anInt : ints) {
                if (anInt == target)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] param = {
                {1,4,7,11,20}, {2,5,8,12,19}, {3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}
            };
//        int [][] param2 = {{}};
        System.out.println(findNumberIn2DArray(param,20));

    }

}
