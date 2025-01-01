package com.test.practices.heap;

import jnr.ffi.annotations.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Heap {
    List<Integer> heap;
    public Heap() {
        heap = new ArrayList<>();
    }
    //Utility Functions
    public int parent(int i){
        return (i-1)/2;
    }
    public int lChild(int i){
        return (2*i)+1;
    }
    public int rChild(int i){
        return (2*i)+2;
    }

    private void swap(List<Integer> heap, int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    //O(log n)
    public void insert(int val){
        if(heap != null){
            heap.add(Integer.valueOf(val));
            int i = heap.size()-1;
            while (i > 0 && heap.get(this.parent(i)) > heap.get(i)){
                int p = this.parent(i);
                /*int temp = heap.get(p);
                heap.set(p,heap.get(i));
                heap.set(i,temp);*/
                swap(heap,p,i);
                i = p;
            }
        }
    }
    //O(log n)
    public int extractMin(){
        int n = this.heap.size();
        if (n == 0){
            return Integer.MAX_VALUE;
        }
        int res = heap.get(0);
        heap.set(0,heap.get(n-1));
        heap.remove(n-1);
        minHeapify(heap,0);
        return res;

    }
    //O(log n)
    private void minHeapify(List<Integer> heap, int i){
        int l = this.lChild(i);
        int r = this.rChild(i);
        int smallest = i;
        int n = heap.size();
        if(l < n && heap.get(l) < heap.get(smallest)){
            smallest = l;
        }
        if(r < n && heap.get(r) < heap.get(smallest)){
            smallest = r;
        }
        if(smallest != i ){
            /*int temp = heap.get(smallest);
           heap.set(smallest,heap.get(i));
           heap.set(i,temp);*/
           swap(heap,i,smallest);
           minHeapify(heap,smallest);
        }
    }
    private void minHeapify2(List<Integer> heap, int i){
        int l = this.lChild(i);
        int r = this.rChild(i);
        int smallest = i;
        int n = heap.size();
        if(l < n && heap.get(l) < heap.get(smallest)){
            smallest = l;
        }
        if(r < n && heap.get(r) < heap.get(smallest)){
            smallest = r;
        }
        if(smallest != i  ){
            swap(heap,i,smallest);
            minHeapify2(heap,smallest);
        }
    }

    // Heapify a subtree rooted at index i (min-heap)
    private void heapifyMin(List<Integer> heap, int i) {
        int smallest = i;
        int left = lChild(i);
        int right = rChild(i);

        // Check left child
        if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }

        // Check right child
        if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }

        // If the smallest is not the root, swap and heapifyMin
        if (smallest != i) {
            swap(heap,i, smallest);
            heapifyMin(heap,smallest);
        }
    }

    // Heapify a subtree rooted at index i (max-heap)
    private void heapifyMax(List<Integer> heap, int i) {
        int largest = i;
        int left = lChild(i);
        int right = rChild(i);

        // Check left child
        if (left < heap.size() && heap.get(left) > heap.get(largest)) {
            largest = left;
        }

        // Check right child
        if (right < heap.size() && heap.get(right) > heap.get(largest)) {
            largest = right;
        }

        // If the largest is not the root, swap and heapifyMax
        if (largest != i) {
            swap(heap,i, largest);
            heapifyMax(heap,largest);
        }
    }
    //O(log n)
    public void decreaseKey(int i, int x){
        if(this.heap != null && i < this.heap.size()){
            this.heap.set(i,x);
            int smallest = i;
            while (smallest != 0 && heap.get(this.parent(smallest))> heap.get(smallest)){
                int p = this.parent(smallest);
                swap(heap,p,smallest);
                smallest = p;
            }
        }
    }
    //O(log n)
    public void deleteKey(int i){
        int n = heap.size();
        if(i < n) {
            decreaseKey(i, Integer.MIN_VALUE);
            extractMin();
        }
    }

    public void buildHeapMin(List<Integer> list){
        int i = list.size() / 2 - 1 ;
        while (i >= 0){
            heapifyMin(list,i);
            i= i-1;
        }
//        int n = list.size();
//        // Start from the last non-leaf node and heapify each node
//        for (int i = n / 2 - 1; i >= 0; i--) {
//            minHeapify2(list, i);
//        }
    }
    public void buildHeapMax(List<Integer> list){
        int i = list.size() / 2 - 1 ;
        while (i >= 0){
            heapifyMax(list,i);
            i= i-1;
        }
    }
    
    public static void main(String[] args) {
        Heap heap1 = new Heap();
        System.out.println(heap1.parent(1));
        System.out.println(heap1.lChild(1));
        System.out.println(heap1.rChild(1));

        heap1.heap.add(100);
        heap1.heap.add(200);
        heap1.heap.add(300);
        heap1.heap.add(400);
        heap1.heap.add(500);
        System.out.println(heap1.heap);
        heap1.insert(50);
        System.out.println(heap1.heap);
        System.out.println(".extractMin() : - "+heap1.extractMin());
        System.out.println(heap1.heap);
        System.out.println("decreaseKey-----");
        heap1.decreaseKey(3,0);
        System.out.println(heap1.heap);
        System.out.println("deleteKey-----");
        heap1.deleteKey(3);
        System.out.println(heap1.heap);

//        List<Integer> x = Arrays.asList(2, 3, 1, 6, 7 ,0,4, 6, 9,100,0,-1,4000);
//        System.out.println("min-heap x: "+x);
//        heap1.buildHeapMin(x);
//        System.out.println("min-heap list: "+x);
//
//
//        x = Arrays.asList(2, 3, 1, 6, 7 ,0,4, 6, 9,100,0,-1,4000);
//        System.out.println("max-heap x: "+x);
//        heap1.buildHeapMax(x);
//        System.out.println("max-heap list: "+x);


//        PriorityQueue<Integer> pQueue
//                = new PriorityQueue<Integer>();
//
//        // Adding items to the priority queue
//        // using add() method
//        pQueue.add(10);
//        pQueue.add(30);
//        pQueue.add(20);
//        pQueue.add(400);
//        pQueue.add(4);
//        pQueue.add(4);
//        System.out.println(pQueue);
//        pQueue.poll();
//        pQueue.poll();
//        System.out.println(pQueue);
//
//        System.out.println("Max heap:--------------");
//        // Creating empty priority queue
//        PriorityQueue<Integer> pQueue1
//                = new PriorityQueue<Integer>(
//                Collections.reverseOrder());
//
//        // Adding items to our priority queue
//        // using add() method
//        pQueue1.add(10);
//        pQueue1.add(3000);
//        pQueue1.add(20);
//        pQueue1.add(400);
//        pQueue1.add(500);
//        System.out.println(pQueue1);
//        pQueue1.poll();
//        pQueue1.remove(10);
//        //pQueue1.poll();
//        System.out.println(pQueue1);

    }
}
