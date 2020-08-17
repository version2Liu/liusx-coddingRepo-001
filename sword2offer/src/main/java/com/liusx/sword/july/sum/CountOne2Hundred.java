package com.liusx.sword.july.sum;

/**
 * description: CountOne2Hundred 求1到100的累加和，用不的方法，求效率最大<br>
 * date: 2020/7/27 8:32 <br>
 * author: liusx <br>
 * version: 1.0 <br>
 */
public class CountOne2Hundred {

    public static void main(String[] args) {
//        System.out.println("for-----"+addFor(100));
//        System.out.println("recursion--"+addRecursion(1,100));
        Integer a = 123;
        System.out.println("周瑜1".hashCode());
    }

    /**
     * description: addFor for循环的方式进行求解，计算1到某个数字之间的和<br>
     * version: 1.0 <br>
     * date: 2020/7/27 8:53 <br>
     * author: liusx <br>
     * @param: num
     * @return int
    */
    public static int addFor(int num){
        int sum = 0;
        for (int i = 1; i <= num ; i++) {
            sum += i;
        }
        return sum;
    }

    /**
     * description: addRecursion 递归方式 计算两个数之间的累加和<br>
     * version: 1.0 <br>
     * date: 2020/7/27 8:50 <br>
     * author: liusx <br>
     * @param: begin 从begin开始加
     * @param: end 加到end为止
     * @return int
    */
    public static int addRecursion(int begin,int end){
        //如果begin小于end，并且begin大于0，那么就计算begin+1的值并加上begin。这样递归下去就能一直求到想要计算的数字为止
        if(begin < end && begin > 0 ){
            return begin + addRecursion(begin + 1,end);
        }else{
            return begin;
        }
    }

}
