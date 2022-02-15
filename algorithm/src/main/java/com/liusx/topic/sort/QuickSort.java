package com.liusx.topic.sort;

/**
 * @author ：liusx
 * @date ：Created in 2022/2/13 16:16
 * @description：快排相关
 * @version: 1.0
 */
public class QuickSort {

    /**
     * 快排就是选择一个比较数n 比n大的放在右边，比n小的放在左边，与n相等的放在中间。这样的操作过后，在中间的数的位置一定是正确的
     * 接下来开始递归 在左边比n小的数中在选举一个数n，再进行上面的一遍操作 在右边比n小的数中在选取一个数n进行上面的操作
     * 直到递归到只剩下两个数循环结束
     * @param arr
     */
    public static void quickSort(int[] arr){
        if (null == arr || arr.length < 2){
            return;
        }
        quickSort(arr,0,arr.length-1);
    }

    private static void quickSort(int[] arr, int l, int r) {
        if(l < r){
            //随机选取数组中的一个数 作为数组的最后一个比较数字
            int random = (int) (Math.random() * (r - l + 1));
            swap(arr, l + random,r);
            //进行partition操作
            int[] p = partition(arr,l,r);
            //把等于去约左右两边的数字分别进行partition
            quickSort(arr,l,p[0] - 1);
            quickSort(arr,p[1]+1,r);
        }
    }
    //partition就是把给定数组中的数字分为三类 小于某个数 大于某个数  等于某个数
    private static int[] partition(int[] arr, int l, int r) {
        //小于区域左边界值
        int less = l - 1;
        //大于区域右边界值
        int more = r;
        //循环开始的下标就是l 只要l没有碰到大于去约的边界就继续循环
        while(l < more){
            if(arr[l] < arr[r]){
                //如果当前数字小于比较数字 就把当前数字和小于区域的笑一个数字进行交换 然后小于区域下标加一 当前数字下标加一
                swap(arr,++less,l++);
            }else if(arr[l] > arr[r]){
                //如果当前数字大于比较数字 就把当前数字和大于区域的前一个数字交换，并切将大于区域的下标向左移动一位 当前数字
                swap(arr,--more,l);
            }else{
                l++;
            }
        }
        //最后把末尾的比较数字移动到大于区域边界的左侧 这样就完成了
        swap(arr,more,r);
        //这个时候需要返回整个数组排列好的区域的左右下标
        return new int[]{less+1,more};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        swap(arr,1,3);
        int[] arr1 = {0,1,2,3,4,5,6,7,8,9};
        swap(arr1,3,1);
        System.out.println(1);
    }

}
