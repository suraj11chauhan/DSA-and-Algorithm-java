package com.test.practices.sorting;

public class Test {

    public static void main(String[] args) {
        int[] a1 = {4,2,7,6,8,9,0,1,3,5};
        int[] a2 = {4,2,7,6,8,9,0,1,3,5};
        int[] a3 = {4,2,7,6,8,9,0,1,3,5};
        int[] a4 = {4,2,7,6,8,9,0,1,3,5};
        System.out.println("mergesort");
        mergesort(a1,0,a1.length-1);
        for (int a:a1){
            System.out.print(a+ " ");
        }
        System.out.println();
        System.out.println("quickSort with lumoto partition");
        quickSort(a2,0,a2.length-1);
        for (int a:a2){
            System.out.print(a+ " ");
        }
        System.out.println();
        System.out.println("quickSort with hoarse Partition");
        quickSort1(a3,0,a3.length-1);
        for (int a:a3){
            System.out.print(a+ " ");
        }
        System.out.println();
        System.out.println("heap sort");
        heapSort(a4);
        for (int a:a4){
            System.out.print(a+ " ");
        }
        System.out.println();
    }

    //Heap sorting'
    public static void heapSort(int[] a){
        int n = a.length;
        buildheap(a);
        for (int i = n-1; i >= 0; i--){
            int temp = a[i];
            a[i] = a[0];
            a[0] = temp;
            heapify(a,i,0);
        }
    }
    public static void buildheap(int[] a){
        int n = a.length;
        for (int i = (n / 2) - 1; i >= 0; i--){
            heapify(a,n,i);
        }
    }

    public static void heapify(int[] a,int n,int i){
        int largest = i;
        int lchild = (2*i)+1;
        int rchild = (2*i)+2;
        if(lchild < n && a[lchild] > a[largest])
            largest = lchild;
        if(rchild < n  && a[rchild] > a[largest])
            largest = rchild;
        if(largest != i){
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            heapify(a,n,largest);
        }
    }

    //Quick sorting
    public static void quickSort(int[] a,int l, int h){
        if(l<h){
            int pivot = lumotoPartition(a,l,h);
            quickSort(a,l,pivot-1);
            quickSort(a,pivot+1,h);
        }
    }

    public static void quickSort1(int[] a,int l, int h){
        if(l<h){
            int pivot = hoarsePartition(a,l,h);
            quickSort1(a,l,pivot);
            quickSort1(a,pivot+1,h);
        }
    }

    public static int lumotoPartition(int[] a, int l ,int h){
        int pivot = a[h];
        int i = l-1;
        for (int j = l; j<a.length; j++){
            if(a[j]<pivot){
                i += 1;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[i+1];
        a[i+1] = pivot;
        a[h] = temp;
        return i+1;
    }

    public static int hoarsePartition(int[] a, int l, int h){
        int pivot = a[l];
        int i = l-1,j = h + 1;
        while (true){
            i=i+1;
            while (a[i]<pivot){
                i=i+1;
            }
            j=j-1;
            while (a[j]>pivot){
                j=j-1;
            }
            if (i >= j)
                return j;

            int temp =  a[j];
            a[j] = a[i];
            a[i] = temp;
        }
    }


    //merge sorting
    public static void mergesort(int[] a,int l, int h){
        if(l<h){
            int m = (h + (l - 1)) /2;
            mergesort(a,l,m);
            mergesort(a,m+1,h);
            merge(a,l,m,h);
        }
    }
    public static void merge(int[] a, int l,int m,int h){
        int n1 = m - l + 1;
        int n2 = h - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        //copy arrays
        for (int i = 0; i< n1; i++){
            L[i] = a[l+i];
        }
        for (int j = 0; j< n2; j++){
            R[j] = a[m+1+j];
        }
        mergeSubArrays(L,R,l,a);

    }
    public static void mergeSubArrays(int[] left, int[] right,int k, int[] res){
        int i=0,j=0;
        while (i < left.length && j <  right.length){
            if(left[i] <= right[j]){
                res[k] = left[i];
                i++;
            }else{
                res[k] = right[j];
                j++;
            }
            k++;
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
}
