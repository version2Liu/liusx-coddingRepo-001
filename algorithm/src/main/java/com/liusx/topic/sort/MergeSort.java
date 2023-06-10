package com.liusx.topic.sort;

/**
 * @author ：liusx
 * @date ：Created in 2022/1/16 12:50
 * @description：归并排序
 * 归并排序算法 一种是能够看到非常明显的阶段排序结果的算法  这是归并排序算法的显著特点和应用场景
 * @version: 1.0
 */
public class MergeSort {

    public static void mergeSort(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        // 处理排序的逻辑
        processSort(arr,0,arr.length-1);
    }

    private static void processSort(int[] arr, int l, int r) {
        // 递归到终点，返回
        if(l == r){
            return;
        }
        // 取中间位置
        int mid = l + ((r - l) >> 1);
        // 处理左部分
        processSort(arr,l,mid);
        // 处理右部分
        processSort(arr,mid+1,r);
        // 将处理好的左右部分合并到一起 注意 此处是利用了上面两步排好序的结果 所以这是归并排序的优点 比较结果并没有被浪费
        mergeArr(arr,l,mid,r);
    }

    private static void mergeArr(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l+ 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;

        while(p1 <= mid && p2 <= r){
            //左右两边 谁小移动谁
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        //当一边下标越界之后，处理剩下的另一边
        while(p1 <= mid){
            help[i++] = arr[p1++];
        }
        while(p2 <= r){
            help[i++] = arr[p2++];
        }
        for(i = 0; i < help.length; i++){
            arr[l+i] = help[i];
        }
    }

    /**
     * 小和问题描述：在一个数组，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组的小和就是这个问题的目标。
     * 例子：[1,3,4,2,5] 1左边比1小的数没有，3左边比3小的数为1，4左边比4小的数1、3，2左边比2小的数1，5左边比5小的数1、3、4、2
     * 所以上面的数组的小和是1+1+3+1+1+3+4+2 = 16
     * 但是这道题的解题思路可以转换为：每一个数右边有几个数比当前数大 就产生多少个这个数的小和。
     * 还是上面的例子，对1 来说。右边4个数都比1大，那么就会产生4*1 个小和。2右边有两个数比他大，所以产生2*3个小和，4右边只有一个数比他大，所以产生1*4个小和，2右边有一个数比他大所以产生1*2个小和，5没有
     * 所以小和为：4*1 + 2*3 + 1*4 + 1*2 = 16
     *
     * 所以求小和就可以利用归并排序来处理，每次排好数进行合并数组之前先计算一个小和，然后在排序。
     * 注意必须排序，不能省略排序，因为排序是为了后面计算值来做的
     * @param arr
     * @return
     */
    public static int smallSumProblem(int[] arr){
        if(null == arr || arr.length < 2){
            return 0;
        }
        return processSum(arr,0,arr.length - 1);
    }

    private static int processSum(int[] arr, int l, int r) {
        if(l == r){
           return 0;
        }
        int mid = l + ((r - l) >> 1);
        //在处理左边，处理右边，以及合并左右两边的过程中都会产生小和 所以要相加
        return processSum(arr,l,mid) + processSum(arr,mid+1,r) + mergeArrSum(arr,l,mid,r);
    }

    private static int mergeArrSum(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid+1;
        //小和结果
        int res = 0;
        while (p1 <= mid && p2 <= r){
            res += arr[p1] < arr[p2] ? (r - p2 + 1)*arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= mid){
            help[i++] = arr[p1++];
        }
        while(p2 <= r){
            help[i++] = arr[p2++];
        }
        for(i = 0; i < help.length;i++){
            arr[l+i] = help[i];
        }
        return res;
    }

    /**
     * 逆序对问题
     * 在一个数组中，左边的数如果比右边的数大 则这两个数构成一个逆序对 请找出数组中的所有逆序对的总和。
     *
     * 解题思路：利用归并排序 归并排序中，如果左侧的当前数字比右侧的大，那么左侧的数剩余的数一定也会比右侧的当前数大
     * 所以说当左侧的当前数比右侧的当前述大的时候 就会产生(mid - p1 + 1)个逆序对
     *
     * 着重注意点：
     * 1、是(mid - p1 + 1) 不是 (mid -l + 1)
     * 2、在合并数组时，当左右两边两个数 相等的时候 一定要先移动左边的数，在移动右边的数 这个注意点和求小和问题处理正好相反，
     *          求小和问题处理时，当左右两边相等时，先移动右边的数，再移动左边的数
     * 为什么呢？
     * 因为求小和问题时，是定住左边然后穷举右边，直到找到一个右边比左边大的数为止
     * 逆序对问题，是定住右边，穷举左边，任何一个左边比右边大的情况都不能放过，所以必须先移动右边再移动左边。
     *
     * 延伸：
     * 1、逆序对问题其实是反应一个数组的有序程度的一个指标。
     * 如果逆序对数量过多，代表着这个数组的有序程度很低，如果逆序对数量很少，代表着这个数组的有序程度很高。
     * 2、这道题目的优化部分：
     * 我们可以在合并两个两个数组之前，先进行一次判断，如果左边数组的左右一个数字 已经小于了右边数组的第一个数字，那么就不会产生逆序对了
     * 直接返回即可。
     * @param arr
     */
    public static int reversePair(int[] arr){
        if(null == arr || arr.length < 2){
            return 0 ;
        }
        return reverse(arr,0,arr.length-1);
    }
    private static int reverse(int[] arr, int l, int r) {
        if(l == r){
           return 0;
        }
        int mid = l + ((r - l) >> 1);
        return  reverse(arr,l,mid)+
                reverse(arr,mid+1,r)+
                reversePairPrint(arr,l,mid,r);
    }
    private static int reversePairPrint(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid+1;
        int res = 0;
        while (p1 <= mid && p2 <= r){
            res += arr[p1] > arr[p2] ? (mid - p1 + 1) : 0;
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= mid){
            help[i++] = arr[p1++];
        }
        while(p2 <= r){
            help[i++] = arr[p2++];
        }
        for(i = 0; i < help.length;i++){
            arr[l+i] = help[i];
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {1,3,2,3,1};
        System.out.println(reversePair(arr));
    }



}
