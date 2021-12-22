package com.algorithm.memory.xor;

/**
 * @author ：liusx
 * @date ：Created in 2021/12/19 23:03
 * @description：异或运算相关练习
 * @version: 1.0
 */
public class XORCalculationPractice {

    public static void findOddNumTime2(int[] arr) {
        int eor = 0;
        for (int cur : arr) {
            eor ^= cur;
        }

        int rightOne = eor & (~eor + 1);

        int onlyOne = 0;
        for (int cur : arr) {
            if ((rightOne & cur) == 1) {
                onlyOne ^= cur;
            }
        }

        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }


    public static void findOddTime2(int[] arr) {
        int eor = 0;
        for (int cur : arr) {
            eor ^= cur;
        }

        int rightOne = eor & (~eor + 1);

        int onlyOne = 0;
        for (int cur : arr) {
            int temp = cur & rightOne;
            if (temp == 1) {
                onlyOne ^= cur;
            }
        }

        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 3, 4, 5, 6, 6};
        findOddTime2(arr);
//        System.out.println(1 & 5);
    }
}
