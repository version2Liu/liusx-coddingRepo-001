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

    public static void findOddNumTimeTwo2(int[] arr){
        int eor = 0;
        for (int cur : arr) {
            eor ^= cur;
        }

        int rightOne = eor & (~eor + 1);
        int onlyOne = 0;
        for (int cur : arr) {
            //这里只能用不等于0  和 等于0
            //想想都知道啊，肯定是要么等于0 要么就是另外一个数啊，这都不是二进制都是十进制，肯定是要么等于0要么不等于0
            if((cur & rightOne) != 0){
                onlyOne ^= cur;
            }
        }
        System.out.println(onlyOne + " " + (onlyOne^eor));
    }

    public static void findOddNumTimeTwo3(int[] arr){
        int eor = 0;
        for (int cur : arr) {
            eor ^= cur;
        }

        int rightOne = eor & (~eor + 1);

        int onlyOne = 0;
        for (int cur : arr) {
            if( (rightOne & cur) == 0){
                onlyOne ^= cur;
            }
        }
        System.out.println(onlyOne + " " + (eor^onlyOne));
    }

    public static void findOddNumTimeTwo4(int[] arr){
        int eor = 0;
        for (int cur : arr) {
            eor ^= cur;
        }

        int rightOne = eor & (~eor + 1);
        int onlyOne = 0;

        for (int cur : arr) {
            if((cur & rightOne) == 0){
                onlyOne ^= cur;
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }

    public static void findOddNumTimeTwo5(int[] arr){
        int eor = 0;
        for (int cur : arr) {
            eor ^= cur;
        }

        int rightOne = eor & (~eor + 1);
        int onlyOne = 0;
        for (int cur : arr) {
            if((rightOne & cur) == 0){
                onlyOne ^= cur;
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }

    public static void findOddNumTimeTwo6(int[] arr){
        int eor = 0 ;
        for (int cur : arr) {
            eor ^= cur;
        }
        int rightOne = eor & (~eor + 1);
        int onlyOne = 0;
        for (int cur : arr) {
            if((rightOne & cur) == 0){
                onlyOne ^= cur;
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }

    public static void findOddNumTimeTwo7(int[] arr){
        int eor = 0;
        for (int cur : arr) {
            eor ^= cur;
        }

        int rightOne = eor & (~eor + 1);
        int onlyOne = 0;
        for (int cur : arr) {
            if((rightOne & cur) == 0){
                onlyOne ^= cur;
            }
        }
        System.out.println(onlyOne + "  " + (eor ^ onlyOne));
    }



    public static void main(String[] args) {
        int[] arr = {1,1, 2, 2, 3, 4, 3, 4, 5,5, 6, 6,7,7,9,9,10,12,12,16};
        findOddNumTimeTwo7(arr);
//        System.out.println(1 & 5);
    }
}
