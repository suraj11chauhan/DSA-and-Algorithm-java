package com.test.practices.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class MyHash {
    private final int bucket;
    private ArrayList<Integer>[] table;
    private int size;

    public static void main(String[] args) {
        int[] a = {15,11,27,8,12};
        MyHash hash = new MyHash(7);
        for (int x : a){
            hash.insertKey(x);
        }
        hash.deleteKey(12);
        hash.displayHash();
    }

    class Node {
        int key;
        int val;
        Node next;

        Node(int key, int val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public Boolean isEmpty() {
        return size == 0;
    }

    MyHash(int bucket){
        this.bucket = bucket;
        this.table = new ArrayList[bucket];
        for (int i = 0; i<bucket; i++){
            table[i] = new ArrayList<>();
        }
    }

    public int hashFunction(int key){
        return key % bucket;
    }

    public void insertKey(int key){
        int index = hashFunction(key);
        table[index].add(key);
    }

    public void deleteKey(int key){
        int index = hashFunction(key);
        if (!table[index].contains(key))
            return;
        table[index].remove(Integer.valueOf(key));
    }

    public void displayHash(){
        for (int i = 0; i<bucket; i++){
            System.out.print(i);
            for (int x: table[i]){
                System.out.print(" --> "+x);
            }
            System.out.println();
        }
    }
}
