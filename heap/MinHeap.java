package com.test.practices.heap;

public class MinHeap {

    private int[] heap;  // Array to store heap elements
    private int size;    // Current number of elements in the heap
    private int capacity; // Maximum size of the heap

    // Constructor
    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    // Function to build a min heap
    public void buildMinHeap(int[] arr) {
        int n = arr.length;
        // Start from the last non-leaf node and heapify each node
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    // Heapify a subtree rooted at node i
    private void heapify(int[] arr, int n, int i) {
        int smallest = i; // Initialize smallest as root
        int left = HeapUtils.leftChild(i); // Left child index
        int right = HeapUtils.rightChild(i); // Right child index

        // If the left child is smaller than the root
        if (left < n && arr[left] < arr[smallest]) {
            smallest = left;
        }

        // If the right child is smaller than the current smallest
        if (right < n && arr[right] < arr[smallest]) {
            smallest = right;
        }

        // If the smallest is not the root
        if (smallest != i) {
            // Swap the root with the smallest
            HeapUtils.swap(arr,i,smallest);
            // Recursively heapify the affected subtree
            heapify(arr, n, smallest);
        }
    }

    private void insert(int val) throws IllegalAccessException {
        if(size <= capacity ){
            heap[size++] = val;
            int i = size-1;
            while (i > 0 && heap[HeapUtils.parent(i)] > heap[i]){
                int p = HeapUtils.parent(i);
                HeapUtils.swap(heap,p,i);
                i = p;
            }
        }else {
            throw new IllegalAccessException("heap capacity full! the heap capacity "+capacity);
        }
    }
    public int extractMin(){
        int n = size;
        if (n == 0){
            return Integer.MAX_VALUE;
        }
        if (n == 1) {
            size--;
            return heap[0];
        }

        int res = heap[0];
        heap[0] = heap[n-1];
        size--;
        heapify(heap,size,0);
        return res;

    }

    //O(log n)
    public void decreaseKey(int i, int newValue){
        if(this.heap != null && i < this.size){
            this.heap[i]= newValue;
            int smallest = i;
            while (smallest != 0 && heap[HeapUtils.parent(smallest)]> heap[smallest]){
                int p = HeapUtils.parent(smallest);
                HeapUtils.swap(heap,p,smallest);
                smallest = p;
            }
        }
    }

    public void deleteKey(int i){
        int n = this.size;
        if (i < n){
            decreaseKey(i,Integer.MIN_VALUE);
            extractMin();
        }
    }
    public void heapsort(int[] arr){
        int n = arr.length;
        buildMinHeap(arr);
        for (int i = n-1; i >= 0;i--){
            HeapUtils.swap(arr,i,0);
            heapify(arr,i,0);
        }
    }

    public static void main(String[] args) throws IllegalAccessException {
        MinHeap heap = new MinHeap(10);
        int[] arr = {2, 3, 1, 6, 7, 4, 6};

        System.out.println("Original array:");
        HeapUtils.printHeap(arr);
//
//        heap.buildMinHeap(arr);
//
//        System.out.println("Min-Heap array:");
//        HeapUtils.printHeap(arr);

//        for (int i: arr){
//            heap.insert(i);
//        }
//        System.out.println("Min-Heap array:");
//        HeapUtils.printHeap(heap.heap,heap.size);
//        heap.deleteKey(3);
//        System.out.println("After deleteKey()");
//        HeapUtils.printHeap(heap.heap,heap.size);
//        heap.deleteKey(3);
//        System.out.println("After deleteKey()");
//        HeapUtils.printHeap(heap.heap,heap.size);
//        heap.deleteKey(0);
//        System.out.println("After deleteKey()");
//        HeapUtils.printHeap(heap.heap,heap.size);

        heap.heapsort(arr);
        System.out.println("After heapsort()");
        HeapUtils.printHeap(arr);
    }
}
