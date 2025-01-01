package com.test.practices.hashing;

import java.util.LinkedList;

public class MyHashMap<V> {
    private final int bucket;
    private LinkedList<Node<V>>[] table;
    private int size;

    public static void main(String[] args) {
        int[] a = {15,11,27,8,12};
       /* MyHash hash = new MyHash(7);
        for (int x : a){
            hash.insertKey(x);
        }
        hash.deleteKey(12);
        hash.displayHash();*/

        MyHashMap  myHashMap = new MyHashMap(7);
        myHashMap.insertKey(1,"A");
        myHashMap.insertKey(28,"B");
        myHashMap.insertKey(7,"C");
//        myHashMap.deleteKey(1);
//        myHashMap.deleteKey(7);
        myHashMap.insertKey(8,"D");
        myHashMap.displayHash();
        System.out.println(myHashMap.search(28));

    }

    class Node<V> {
        int key;
        V val;
        Node<V> next;

        Node(int key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public Boolean isEmpty() {
        return size == 0;
    }

    MyHashMap(int bucket){
        this.bucket = bucket;
        this.table = new LinkedList[bucket];
        for (int i = 0; i<bucket; i++){
            table[i] = new LinkedList<>();
        }
    }

    public int hashFunction(int key){
        return key % bucket;
    }

    public void insertKey(int key, V val){
        int index = hashFunction(key);
        LinkedList<Node<V>> nodes = table[index];
        for (Node<V> node : nodes){
            if (node.key == key){
                node.val = val;
                return;
            }
        }
        Node<V> node = new Node<V>(key,val);
        nodes.addFirst(node);
        size++;
    }

    public void deleteKey(int key){
        int index = hashFunction(key);
        LinkedList<Node<V>> nodes = table[index];
        Node<V> prev = null;
        Node<V> target = null;
        for (Node<V> node : nodes){
            if (node.key == key){
                target = node;
                if (prev == null)
                    nodes.removeFirst();
                else
                    nodes.remove(target);
                size--;
                return;
            }
            prev = node;
        }
    }

    public V search(int key){
        int index = hashFunction(key);
        LinkedList<Node<V>> nodes = table[index];
        for (Node<V> node : nodes){
            if (node.key == key){
                return node.val;
            }
        }
        return null;
    }

    public void displayHash(){
        for (int i = 0; i<bucket; i++){
            System.out.print(i);
            for (Node<V> x: table[i]){
                System.out.print(" --> { "+x.key+" = "+x.val +" }");
            }
            System.out.println();
        }
    }
}
