package com.algorithm.memory.sort;

import com.liusx.util.NumberUtil;
import com.liusx.util.PrintUtil;

/**
 * @author ：liusx
 * @date ：Created in 2022/3/27 21:08
 * @description：一日一练一日功，一日不练十日空
 * @version: 1.0
 */
public class SortPracticeEveryDay {

    //选择排序
    public static void selectSort1(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        int minIndex;
        for(int i = 0; i < arr.length - 1; i++){
            minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr,i,minIndex);
        }
    }
    //冒泡排序
    public static void bubbleSort1(int[] arr) {
        if(null == arr || arr.length < 2){
            return;
        }
        for(int e = arr.length - 1; e > 0; e--){
            for(int i = 0; i < e; i++){
                if(arr[i] > arr[i+1]){
                    NumberUtil.swap(arr,i,i+1);
                }
            }
        }
    }
    //插入排序
    public static void insertSort1(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 1; i < arr.length; i++){
            for(int j = i - 1; j >= 0 && arr[j] > arr[j+1]; j--){
                NumberUtil.swap(arr,j,j+1);
            }
        }
    }
    //归并排序
    public static void mergeSort1(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        process1(arr,0,arr.length-1);
    }
    private static void process1(int[] arr, int l, int r) {
        if(l == r){
            return;
        }
        int mid = l + (r - l)/2;
        process1(arr,l,mid);
        process1(arr,mid+1,r);
        mergeLAndR1(arr,l,mid,r);
    }
    private static void mergeLAndR1(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = mid+1;
        int i = 0;
        while(p1 <= mid && p2 <= r){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
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
    //快排
    public static void quickSort1(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        quickSort1(arr,0,arr.length - 1);
    }
    private static void quickSort1(int[] arr, int l, int r) {
        if(l < r){
            int random = l + (int)Math.random() * (r - l);
            NumberUtil.swap(arr,random,r);
            int[] p = partition1(arr,l,r);
            quickSort1(arr,l,p[0]-1);
            quickSort1(arr,p[1]+1,r);
        }
    }
    private static int[] partition1(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while(l < more ){
            if(arr[l] < arr[r]){
                NumberUtil.swap(arr,++less,l++);
            }else if(arr[l] > arr[r]){
                NumberUtil.swap(arr,--more,l);
            }else{
                l++;
            }
        }
        NumberUtil.swap(arr,more,r);
        return new int[]{less+1,more};
    }
    //堆排
    public static void heapSort1(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = arr.length - 1; i >= 0; i--){
            heapify1(arr,i,arr.length);
        }
        int size = arr.length;
        NumberUtil.swap(arr,0,--size);
        while(size > 0){
            heapify1(arr,0,size);
            NumberUtil.swap(arr,0,--size);
        }
    }
    public static void heapInsert1(int[] arr, int index){
        while(arr[index] > arr[(index - 1)/2]){
            NumberUtil.swap(arr,index,(index - 1)/2);
            index = (index - 1)/2;
        }
    }
    public static void heapify1(int[] arr, int index, int size){
        int left = index * 2 + 1;
        while(left < size){
            int largest = left + 1 < size && arr[left+1] > arr[left] ? left+1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if(largest == index){
                break;
            }
            NumberUtil.swap(arr,index,largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    //选择排序
    public static void selectSort2(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        int minIndex;
        for(int i = 0; i < arr.length - 1 ; i++){
            minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr,i,minIndex);
        }
    }
    //冒泡排序
    public static void bubbleSort2(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int e = arr.length - 1; e > 0; e--){
            for(int i = 0; i < e; i++){
                if(arr[i] > arr[i+1]){
                    NumberUtil.swap(arr,i,i+1);
                }
            }
        }
    }
    //插入排序
    public static void insertSort2(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 1; i < arr.length; i++){
            for(int j = i - 1; j >= 0 && arr[j] > arr[j+1]; j--){
                NumberUtil.swap(arr,j,j+1);
            }
        }
    }
    //归并排序
    public static void mergeSort2(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        process2(arr,0,arr.length-1);
    }
    private static void process2(int[] arr, int l, int r) {
        if(l == r){
            return;
        }
        int mid = l + (r - l) / 2;
        process2(arr,l,mid);
        process2(arr,mid+1,r);
        mergeLeftAndRight2(arr,l,mid,r);
    }
    private static void mergeLeftAndRight2(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = mid+1;
        int i = 0;
        while(p1 <= mid && p2 <= r){
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
    }
    //快排
    public static void quickSort2(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        quickSort2(arr,0,arr.length-1);
    }
    private static void quickSort2(int[] arr, int l, int r) {
        if(l < r){
            int random = l + (int)Math.random() * (r - l);
            NumberUtil.swap(arr,random,r);
            int[] p = partition2(arr,l,r);
            quickSort2(arr,l,p[0]-1);
            quickSort2(arr,p[1]+1,r);
        }
    }
    private static int[] partition2(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while(l < more){
            if(arr[l] < arr[r]){
                NumberUtil.swap(arr,++less,l++);
            }else if(arr[l] > arr[r]){
                NumberUtil.swap(arr,--more,l);
            }else{
                l++;
            }
        }
        NumberUtil.swap(arr,more,r);
        return new int[]{less+1,more};
    }
    //堆排
    public static void heapSort2(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = arr.length-1; i >= 0; i--){
            heapify2(arr,i,arr.length);
        }
        int size = arr.length;
        NumberUtil.swap(arr,0,--size);
        while(size > 0){
            heapify2(arr,0,size);
            NumberUtil.swap(arr,0,--size);
        }
    }
    //比较的时候父节点和插入当前节点的大小
    public static void heapInsert2(int[] arr, int index){
        while(arr[index] > arr[(index - 1) / 2]){
            NumberUtil.swap(arr,index,(index - 1) / 2);
            index = (index - 1) / 2;
        }
    }
    public static void heapify2(int[] arr, int index, int size){
        int left = index * 2 + 1;
        while(left < size){
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[index] > arr[largest] ? index : largest;
            if(largest == index){
                break;
            }
            NumberUtil.swap(arr,index,largest);
            index = largest;
            left = index * 2 + 1;
        }
    }


    //选择排序
    public static void selectSort3(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        int minIndex;
        for(int i = 0; i < arr.length - 1; i++){
            minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            NumberUtil.swap(arr,i,minIndex);
        }
    }
    //冒泡排序
    public static void bubbleSort3(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int e = arr.length - 1; e > 0; e--){
            for(int i = 0; i < e; i++){
                if(arr[i] > arr[i+1]){
                    NumberUtil.swap(arr,i,i+1);
                }
            }
        }
    }
    //插入排序
    public static void insertSort3(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = 1; i < arr.length; i++){
            for(int j = i - 1; j >= 0 && arr[j] > arr[j+1]; j--){
                NumberUtil.swap(arr,j,j+1);
            }
        }
    }
    //归并排序
    public static void mergeSort3(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        process3(arr,0,arr.length - 1);
    }
    private static void process3(int[] arr, int l, int r) {
        if(l == r){
            return;
        }
        int mid = l + (r - l) >> 1;
        process3(arr,l,mid);
        process3(arr,mid+1,r);
        mergeLeftAndRight3(arr,l,mid,r);
    }
    private static void mergeLeftAndRight3(int[] arr, int l, int mid, int r) {
        int[] help = new int[]{r - l + 1};
        int p1 = l;
        int p2 = mid+1;
        int i = 0;
        while(p1 <= mid && p2 <= r){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
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
    //快排
    public static void quickSort3(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        quickSort3(arr,0,arr.length-1);
    }
    private static void quickSort3(int[] arr, int l, int r) {
        if(l < r){
            int random = l + (int)Math.random() * (r - l);
            NumberUtil.swap(arr,random,r);
            int[] p = partition3(arr,l,r);
            quickSort3(arr,l,p[0]-1);
            quickSort3(arr,p[1]+1,r);
        }
    }
    private static int[] partition3(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while(l < more){
            if(arr[l] < arr[r]){
                NumberUtil.swap(arr,++less,l++);
            }else if(arr[l] > arr[r]){
                NumberUtil.swap(arr,--more,l);
            }else{
                l++;
            }
        }
        NumberUtil.swap(arr,more,r);
        return new int[]{less+1,more};
    }
    //堆排
    public static void heapSort3(int[] arr){
        if(null == arr || arr.length < 2){
            return;
        }
        for(int i = arr.length - 1; i >= 0; i--){
            heapify3(arr,i,arr.length);
        }
        int size = arr.length;
        NumberUtil.swap(arr,0,--size);
        while(size > 0){
            heapify3(arr,0,size);
            NumberUtil.swap(arr,0,--size);
        }
    }
    public static void heapInsert3(int[] arr, int index){
        while(arr[index] > arr[(index - 1) / 2]){
            NumberUtil.swap(arr,index,(index - 1) / 2);
            index = (index - 1) / 2;
        }
    }
    public static void heapify3(int[] arr,int index,int size){
        int left = index * 2 + 1;
        while(left < size){
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[index] > arr[largest] ? index : largest;
            if(index == largest){
                break;
            }
            NumberUtil.swap(arr,index,largest);
            index = largest;
            left = index * 2 + 1;
        }
    }




    public static void main(String[] args) {
        pressureTest();
    }
    public static void pressureTest() {
        int testTIme = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTIme; i++) {
            int[] arr1 = NumberUtil.generateRandomArray(maxSize, maxValue);
            int[] arr2 = NumberUtil.copyArray(arr1);
            int[] arr3 = {7,3,2,5};
            selectSort3(arr1);
            NumberUtil.comparator(arr2);
            if (!NumberUtil.isEqual(arr1, arr2)) {
                succeed = false;
                PrintUtil.printArr(arr1);
                PrintUtil.printArr(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Oh no u are fail!");

        int[] arr = NumberUtil.generateRandomArray(maxSize, maxValue);
        PrintUtil.printArr(arr);
        selectSort3(arr);
        PrintUtil.printArr(arr);
    }

}
