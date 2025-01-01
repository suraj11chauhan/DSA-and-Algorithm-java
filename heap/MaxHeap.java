package com.test.practices.heap;

public class MaxHeap {

    private int[] heap;  // Array to store heap elements
    private int size;    // Current number of elements in the heap
    private int capacity; // Maximum size of the heap

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    // Function to build a max heap
    public void buildMaxHeap(int[] arr) {
        int n = arr.length;

        // Start from the last non-leaf node and heapify each node
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    // Heapify a subtree rooted at node i
    private void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = HeapUtils.leftChild(i); // Left child index
        int right = HeapUtils.rightChild(i); // Right child index

        // If the left child is larger than the root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If the right child is larger than the current largest
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If the largest is not the root
        if (largest != i) {
            // Swap the root with the largest
            HeapUtils.swap(arr,i,largest);
            // Recursively heapify the affected subtree
            heapify(arr, n, largest);
        }
    }

    private void insert(int val) throws IllegalAccessException {
        if(size <= capacity ){
            heap[size++] = val;
            int i = size-1;
            while (i > 0 && heap[HeapUtils.parent(i)] < heap[i]){
                int p = HeapUtils.parent(i);
                HeapUtils.swap(heap,p,i);
                i = p;
            }
        }else {
            throw new IllegalAccessException("heap capacity full! the heap capacity "+capacity);
        }
    }
    public int extractMax(){
        int n = size;
        if (n == 0){
            return Integer.MIN_VALUE;
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


    public void deleteKey(int i){
        int n = this.size;
        if(i < n){
            increaseKey(i,Integer.MAX_VALUE);
            extractMax();
        }
    }

    public void increaseKey(int i, int newValue) {
        if (i < this.size) {
            this.heap[i] = newValue;
            // Bubble up to restore the max-heap property
            while (i != 0 && this.heap[HeapUtils.parent(i)] < this.heap[i]) {
                HeapUtils.swap(this.heap, i, HeapUtils.parent(i));
                i = HeapUtils.parent(i);
            }
        }
    }
    public void heapsort(int[] arr){
        int n = arr.length;
        buildMaxHeap(arr);
        for (int i = n-1; i >= 0;i--){
            HeapUtils.swap(arr,i,0);
            heapify(arr,i,0);
        }
    }

    public static void main(String[] args) throws IllegalAccessException {
        MaxHeap heap = new MaxHeap(10);
        int[] arr = {3, 9, 2, 1, 4, 5};

        System.out.println("Original array:");
        HeapUtils.printHeap(arr);

//        heap.buildMaxHeap(arr);
//
//        System.out.println("Max-MaxHeap array:");
//        HeapUtils.printHeap(arr);

//        for (int i: arr){
//            heap.insert(i);
//        }
//        System.out.println("Max-Heap array:");
//        HeapUtils.printHeap(heap.heap,heap.size);
//
//        System.out.println(heap.extractMax());
//        HeapUtils.printHeap(heap.heap,heap.size);
//
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
