package com.liusx.topic.comparators;

/**
 * @author ：liusx
 * @date ：Created in 2022/3/7 17:44
 * @description：比较器实现
 * @version: 1.0
 */
public class Student {

    static boolean Student(String c){
        System.out.println(c);
        return true;
    }

    public static void main(String[] args) {

//        int i = 0;
//        for (Student("a"); Student("b") && (i<2) ;Student("c")) {
//            i++;
//            Student("d");
//        }
        int max = 132;
        int res = 0;
        while (max > 0) {
            res++;
            max = max / 10;
        }
        System.out.println(res);
        System.out.println(9 / 10);
    }


}
