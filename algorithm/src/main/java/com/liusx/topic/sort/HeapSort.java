package com.liusx.topic.sort;

import java.util.PriorityQueue;

/**
 * @author ：liusx
 * @date ：Created in 2022/2/19 12:25
 * @description：堆排序相关
 * @version: 1.0
 */
public class HeapSort {

    //时间复杂度是 O(NlogN) 空间复杂度O(1)
    public static void heapSort(int[] arr){
        //先将排序数组 变成一个大根堆
//        for(int i = 1; i < arr.length; i++){ //O(N)
//            //将排序数组中的数字依次插入堆中 就是将这个数组变成一个大根堆
//            heapInsert(arr,i); //O(logN)
//        }

        for(int i = arr.length - 1; i >= 0; i--){
            heapify(arr,i,arr.length);
        }
        //当前堆的大小 就是数组的大小
        int heapSize = arr.length;
        //此处需要两步操作 1、交换堆顶元素 2、将堆的大小减一
        //一个 --heap 直接搞定
        swap(arr,0,--heapSize);
        //只要堆的大小大于0 一直重复上述操作即可
        while (heapSize > 0){ //O(N)
            //堆顶元素移除后 剩下的部分需要做堆化处理
            heapify(arr,0,heapSize); //O(logN)
            //堆化处理后 继续将堆顶元素交换并移除
            swap(arr,0,--heapSize);  //O(1)
        }
    }

    /**
     * Java和c 语言中数的运算有他们的一套逻辑。
     * 整型和整型运算得到的结果也一定是整型
     * 整型 和 浮点型运算 是先将整数转化为浮点数 再运算 得到的是一个浮点数
     * 但是如果要是将一个浮点类型的数赋值给整型数 将会进行强制类型转换，不是四舍五入而是直接去掉小数部分。
     *
     * 堆操作
     * 如果已经是大根堆的数组 改变数组中的其中一个数字，这个时候想要维持堆结构 有两个操作
     * 如果改变之后这个位置的数 是变大了 那么就让他往上经历一个heapInsert过程
     * 如果改变之后这个位置的数 是变小了 那么就让他往下经历一个heapify过程
     * */

    /**
     * 大根堆堆插入 index表示的是当前要插入数字所在的数组中的位置
     * @param arr
     * @param index
     */
    public static void heapInsert(int[] arr, int index){
        //插入的这个数首先找到自己的父节点，两者进行比较 如果当前节点不大于父节点 或者当前节点是0(换句话说就是没有父节点) 就说明当前的插入已完成
        while (arr[index] > arr[(index - 1) / 2]){
            //如果当前节点大于父节点 就交换当前节点 和 父节点位置的值
            swap(arr,index,(index - 1) / 2);
            //交换完了 当前位置要要往上走 来到了之前的那个节点的父节点位置 继续循环进行判断
            index = (index - 1)/2;
        }
    }

    /**
     * 要求是把当前大根堆中最大的数字移除掉，并且保证剩下的数字依然是大根堆结构
     * 也可以说成是 把给定的数组变成大根堆
     * @param arr
     * @param index 表示当前数组堆化结构的起始位置
     * @param size 表示当前数组堆化结构的终止位置
     *             也就是说这个方法的作用就是 要把arr index-size范围的数字 搞成大根堆
     */
    public static void heapify(int[] arr, int index, int size){
        //找到初始位置的左孩子下标
        int left = index * 2 + 1;
        //如果左孩子小于边界 就继续循环 内部有判断右孩子的代码
        while (left < size){
            //取出左孩子和右孩子较大的一个的下标
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            //比较父节点和较大孩子 谁大 取谁的下标
            largest = arr[largest] > arr[index] ? largest : index;
            //如果最大值就是当前的父节点 了 就不用再继续搞了
            if(largest == index){
                break;
            }
            //交换较大孩子 和 父节点位置的数值
            swap(arr,largest,index);
            //移动当前节点
            index = largest;
            //计算当前节点的左孩子 继续循环
            left = index * 2 + 1;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void sortK(int[] arr, int k){
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        //先把前K个数搞进小根堆
        for(; index < Math.min(arr.length,k);index++){
            heap.add(arr[index]);
        }
        int i = 0;
        //遍历剩下的数
        for(;index < arr.length;index++,i++){
            //把剩下的数add进去小根堆
            heap.add(arr[index]);
            //把小根堆的堆顶元素最小的数移动到数组中
            arr[i] = heap.poll();
        }
        //把剩下的小根堆中的数据移动到数组中
        while(!heap.isEmpty()){
            arr[i++]= heap.poll();
        }
    }






    public static void main(String[] args) {
        int[] arr = {3,5,1,7,8,3,2,4,6,3,4,9};
        heapSort(arr);
        System.out.println("dsf");
        System.out.println(arr);
    }


}
