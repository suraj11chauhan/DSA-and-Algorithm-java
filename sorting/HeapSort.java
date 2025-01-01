package com.test.practices.sorting;

public class HeapSort {

    public static void main(String[] args) {
        int[] a = {4,2,7,6,8,9,0,1,3,5};
        heapSort(a);
        for (int aa:a){
            System.out.print(aa+" ");
        }
        System.out.println();
    }

    public static void heapSort(int[] arr){
        int n = arr.length;
        buildHeap(arr);
        for (int i = n-1; i>=0; i--){
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapifyMax(arr,i,0);
            //heapifyMin(arr,i,0);
        }
    }
    public static void buildHeap(int[] arr){
        int n = arr.length;
        for(int i = n / 2 - 1; i >= 0;i--){
            heapifyMax(arr,n,i);
        }
    }
    public static void heapifyMin(int[] arr,int n, int i){
        int smallest = i;
        int l = (2*i)+1;
        int r = (2*i)+2;
        if (l < n && arr[l] < arr[smallest]){
            smallest = l;
        }
        if (r < n && arr[r] < arr[smallest]){
            smallest = r;
        }
        if(smallest != i){
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            heapifyMin(arr,n,smallest);
        }
    }
    public static void heapifyMax(int[] arr,int n, int i){
        int largest = i;
        int l = (2*i)+1;
        int r = (2*i)+2;
        if (l < n && arr[l] > arr[largest]){
            largest = l;
        }
        if (r < n && arr[r] > arr[largest]){
            largest = r;
        }
        if(largest != i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapifyMax(arr,n,largest);
        }
    }
}
