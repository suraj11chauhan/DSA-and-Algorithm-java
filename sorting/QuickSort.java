package com.test.practices.sorting;

public class QuickSort {

    // we can use lumuto and hourse partition algo to sort the arrays
    // these partition method return the pivot index, and left side of element are less than pivot
    // and right side of element ara greater than pivot,But its not guarantee elements are in sorting order
    public static int lumotoPartition(int[] arr,int l,int h){
        int i = l-1;
        int pivot = arr[h];
        for (int j=l;j<=h;j++){
            if(arr[j]<pivot){
                i=i+1;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = pivot;
        arr[h] = temp;
        return i+1;
    }

    public static int hoursePartition(int[] arr,int l,int h){
        int pivot = arr[l];
        int i = l-1,j = h+1;
        while (true){
            i=i+1;
            if(arr[i]<pivot){
                i=i+1;
            }
            j=j-1;
            if(arr[j]>pivot){
                j=j-1;
            }
            if(i>=j)
                return j;
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
    }

    public static void quickSort(int[] arr,int l, int h){
        if(l<h){
            int pivot = lumotoPartition(arr,l,h);
            quickSort(arr,l,pivot-1);
            quickSort(arr,pivot+1,h);
        }
    }
    public static void quickSort1(int[] arr,int l, int h){
        if(l<h){
            int pivot = hoursePartition(arr,l,h);
            quickSort1(arr,l,pivot);
            quickSort1(arr,pivot+1,h);
        }
    }

    public static void main(String[] args) {
        int[] a = {2,5,2,6};
        quickSort1(a,0,a.length-1);
        //System.out.println("pivot :: "+pivot);
        for (int aa:a){
            System.out.print(aa+" ");
        }
        System.out.println();
    }


}
