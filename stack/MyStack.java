package com.test.practices.stack;


public class MyStack<T> {
    public Node head;
    public int size;


    static class Node<T> {
        T data;
        Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public MyStack(){
        size = -1;
    }
    public void push(T data){
        if (head == null){
            head = new Node(data);
            size++;
            return;
        }
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
        size++;
    }

    public T pop(){
        if (head == null){
            return null;
        }
        T temp = (T) head.data;
        head = head.next;
        size--;
        return temp;

    }
    public T peek(){
        if (head == null){
            return null;
        }
        return (T)head.data;
    }
    public int size(){
        return size+1;
    }
    public void print() {
        if (head == null) {
            return;
        }
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("NULL");
    }

    public boolean isEmpty() {
        return size == -1;
    }


    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(10);
        stack.push(20);
        System.out.println(stack.peek());
        System.out.println(stack.size());
        stack.pop();
        stack.pop();
        stack.push(30);
        System.out.println(stack.peek());
        stack.print();
    }
}
