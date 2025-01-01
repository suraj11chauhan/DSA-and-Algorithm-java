package com.test.practices.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
//        int[] a = {2,3,4,1,3};
//        int[] b = {7,8,5};
//        Arrays.stream(merge(a, b)).forEach(System.out::println);

        int[] a = {2,5,1,6,2,7,3,7,3,-1,100};
        mergeSort(a,0,a.length-1);
        for (int i: a){
            System.out.print(i+",  ");
        }
    }

    public static void mergeSort(int[] arr,int l,int h){
        if(l<h) {
            int m = (h + (l - 1)) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, h);
            merge(arr,l,m,h);
        }
    }

    public static void merge(int[] arr,int l, int m, int h){
        int n1 = m - l + 1;
        int n2 = h - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        //copy data into left and right
        for(int i = 0; i < n1; i++){
            L[i] = arr[l+i];
        }
        for(int j = 0; j < n2; j++){
            R[j] = arr[m+1+j];
        }
        mergeSubArrays(L,R,l,arr);

    }
    public static void mergeSubArrays(int[] left, int[] right, int k, int[] res){
        int i=0,j=0;
        while (i < left.length && j < right.length){
            if(i < left.length && left[i] <= right[j]){
                res[k] = left[i];
                i+=1;
                k++;
            }else{
                res[k] = right[j];
                j+=1;
                k++;
            }
        }

        while (i < left.length){
            res[k] = left[i];
            k++;
            i++;
        }
        while (j < right.length){
            res[k] = right[j];
            k++;
            j++;
        }
    }

    public static int[] merge(int[] left,int[] right){
        int[] sortedArray = new int[left.length+right.length];
        int i=0,j=0,k=0;
        for (k=0;k<sortedArray.length;){
            if(i < left.length && left[i] <= right[j]){
                sortedArray[k] = left[i];
                i+=1;
                k++;
            }else{
                sortedArray[k] = right[j];
                j+=1;
                k++;
            }
        }

        while (i < left.length){
            sortedArray[k] = left[i];
            k++;
            i++;
        }
        while (j < right.length){
            sortedArray[k] = right[i];
            k++;
            j++;
        }
        return sortedArray;

    }
}
