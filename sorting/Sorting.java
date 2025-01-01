package com.test.practices.sorting;

public class Sorting {
    public static void main(String[] args) {
        /*int[][] a = {{1, 4, 6, 7}, { 2,3, 5, 8}};
        int[] ints = mergeSubArrays(a);
        for (int ai : ints) {
            System.out.print(ai+" ");
        }*/
//        int[] a = {0,1,0,1,0,0,1};
//        a = binSort(a);
//        for (int ai : a) {
//            System.out.print(ai+" ");
//        }
        int[] a = {10,80,30,90,40,50,70};
        int[] a1 = {2,5,2,6};
        //System.out.println(lumotoPartition(a1,0,a1.length-1));
        //System.out.println(hoarsePartition(a1,0,a1.length-1));
        //quickSort(a1,0,a1.length-1);
        quickSort1(a1,0,a1.length-1);
//        mergeSort(a1,0,a1.length-1);
        for (int ai : a1) {
            System.out.print(ai+" ");
        }
    }

    public static int[] mergeSubArrays(int[][] a) {
        if (a.length < 1)
            return a[0];

        int bl = 0;
        for (int[] ai : a) {
            bl += bl + ai.length;
        }
        int[] res = new int[bl];
        // Copy all elements from the input arrays to the result array
       /*for (int i = 1; i<a.length;i++){
           res = mergeTwoArrays(a[0],a[i],0);
       }*/

        return res;
    }

    public static int[] mergeTwoArrays(int[] a, int[] b, int k,int[] res) {
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                res[k] = a[i];
                i++;
            } else {
                res[k] = b[j];
                j++;
            }
            k++;
        }

        while (i < a.length) {
            res[k] = a[i];
            i++;
            k++;
        }
        while (j < b.length) {
            res[k] = b[j];
            j++;
            k++;
        }
        return res;
    }
    //01
    public static int[] binSort(int[] a){
        int n = a.length;
        int l=0,r=n-1;
        while (l<=r){
            if(a[l] == 0 )
                l++;
            if(a[r] == 1)
                r--;

            else if(a[l]!=0 && a[r]!=1){
                int temp = a[r];
                a[r]=a[l];
                a[l]=temp;
            }
        }
        return a;
    }

    public static int lumotoPartition(int[] a,int l, int h){
        int pivot = a[h];
        int i = l-1;
        for (int j=l;j<h;j++){// 10,70,40,80,20,30
            if(a[j]<pivot){// j=4, 20 < 30, i=0,
                i=i+1;// i = 1
                int temp = a[i]; //temp = 70
                a[i] = a[j];
                a[j] = temp;
            }
        }// 10, 20, 30 , 80, 70 , 40
        int temp = a[i+1];// i=2, temp=40
        a[i+1] = pivot;
        a[h] = temp;
        return i+1;
    }

    //{100,70,40,80,20,30}
    public static int hoarsePartition(int[] a,int l, int h){
        int i  = l-1, j =h+1;
        int pivot = a[l];
        while (true){
            i=i+1;//i=5
            while (a[i]<pivot){// 30<100
                i=i+1;
            }
            j=j-1;// j = 5
            while (a[j]>pivot){ // 10 > 10
                j=j-1;
            }
            if(i>=j)
                return j;
            int temp = a[j];
            a[j] = a[i];
            a[i] = temp;
        }
    }

   static public void quickSort(int[] a,int l, int h){
        if(l<h){
            int pivot = lumotoPartition(a,l,h);
            quickSort(a,l,pivot-1);
            quickSort(a,pivot+1,h);
        }
    }
    static public void quickSort1(int[] a,int l, int h){
        if(l<h){
            int pivot = hoarsePartition(a,l,h);
            quickSort1(a,l,pivot);
            quickSort1(a,pivot+1,h);
        }
    }

    public static void merge(int[] a,int l, int m,int h){
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = h - m;

        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = a[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = a[m + 1 + j];

        mergeTwoArrays(L,R,l,a);
    }
    public static void mergeSort(int[] a,int l, int h){
        if(l<h){
            int m =  (h+(l-1))/2;
            // Sort first and second halves
            mergeSort(a, l, m);
            mergeSort(a, m + 1, h);
            merge(a,l,m,h);
        }
    }

}
