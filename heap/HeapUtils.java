package com.test.practices.heap;

public class HeapUtils {

    public static int parent(int i){
        return (i-1)/2;
    }
    public static int leftChild(int i){
        return (2*i)+1;
    }
    public static int rightChild(int i){
        return (2*i)+2;
    }

    public static void swap(int[] arr, int i, int j) {
        int swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
    }
    // Utility function to print the array
    public static void printHeap(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    public static void printHeap(int[] arr, int size) {
        for (int i=0;i<size;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
