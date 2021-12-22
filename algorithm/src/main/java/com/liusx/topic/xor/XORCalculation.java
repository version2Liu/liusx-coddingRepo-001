package com.liusx.topic.xor;

/**
 * @author ：liusx
 * @date ：Created in 2021/12/19 16:16
 * @description：异或运算练习
 * @version: 1.0
 */
public class XORCalculation {


    /**
     * 已知一个数组中只有一个数出现了奇数次，其他的所有数都出现了偶数次，请找出这个数组中出现了奇数次的这个数字
     * @param arr
     * @return
     * 思路：通过异或运算特点来解决。一堆数字异或顺序如何无所谓
     * 假设数组为[a,b,c,a,b,c,a]
     * 调整一下异或运算[b^b ^ c^c ^ a^a ^a]
     * 如上所示，按照上述顺序异或出来的结果就是a本身，这个时候再用0异或一下结果就得到了a本身
     */
    public static int findOddNumOne(int[] arr) {
        //定义一个0 目的是为了最终让我们的奇数次的数字现身
        int eor = 0;
        for (int cur : arr) {
            eor = eor ^ cur;
        }
        System.out.println(eor);
        return eor;
    }


    /**
     * 已知一个数组中只有两个不相等数字出现了奇数次，其余所有的数字都出现了偶数次，请找出这两个出现了奇数次的数字 并打印出来
     * @param arr
     * 假设数组如下所示：[a,b,c,d,e,c,d,e]
     * 根据异或运算的特点异或一遍的结果是[c^c ^ d^d ^ e^e ^ a^b] = a^b
     * 因为题目说了是两个数字不相等，那么最后异或出来 a^b的结果一定不是0 (ps:虽然说相同为0，不同为1 但是实际上计算机在计算数字之间的异或结果的时候是把数字先转换成二进制，然后对二进制的每一位进行异或运算，所以3^8 的结果不是1而是11 即计算机会把异或之后的二进制再转换成十进制)
     * 假设eor = a^b 那么eor!= 0  就代表着，eor这个数的某一位上一定是1，
     * 因为整数是32位的，我们这个时候不妨假设eor的第x位上面的数字是1。（x其实指代任何一位）
     * 那么就代表着，a和b在第x位上一定是不一样的，这样他们俩才能异或的结果等于1
     * 并且，数组中的所有数字的 第x位 也要么是0 ，要么是1，不过由于其他的数字都是偶数出现的
     * 假设我们用0去异或 第x位上为1的所有数字，在异或的过程中偶数次出现的数字的 第x位上的数字都会被过滤掉 所以留下的就是奇数次出现的数字
     * 所以说我们就再找一个eor'=0 让eor' 只去 异或第x位上是0或者第x位上是1 的数字，最后一圈异或结束后得到的数字要么就是a要么就是b
     *
     * 那么代码怎么写呢 看下方代码及注释
     */
    public static void findOddNumTwo(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        //eor = a ^ b 并且 eor != 0  因为a与b 不相等
        //因此上面循环结束之后 eor 必然有一个位置是1

        //一个数取反加一 再跟自己 与运算 得到的结果是 这个数的最右边一位上的1
        int rightOne = eor & (~eor + 1);
        //通过上面一步我们就已经拿到了eor位数为1的那一位数字了，我们就可以用他来作为区分 将a和b区分开了。

        //用来异或得到a 或者 b
        int onlyOne = 0;
        for (int cur : arr) {
            //这一次遍历只需要异或第x位上是0或者1的，所以这里需要一个判断，&运算等于0或者等于1 都可以
            if ((cur & rightOne) == 1) {
                onlyOne ^= cur;
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));

    }
    public static void main(String[] args) {
        System.out.println(3 ^8);

    }



    public static void findOddNum2(int[] arr) {
        //1.找出来两个奇数的异或结果
        int eor = 0;
        for (int cur : arr) {
            eor ^= cur;
        }

        //找出来
        int rightOne = eor & (~eor + 1);

        int onlyOne = 0;
        for (int cur1 : arr) {
            if (((rightOne & cur1) == 0)) {
                onlyOne ^= cur1;
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }
}
