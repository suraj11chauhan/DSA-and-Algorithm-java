package com.test.practices.linkedlist;

public class CicularLinkedList {
    static class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static void print(Node head) {
        if (head == null) {
            return;
        }
        Node curr = head;
        do {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        } while (curr != head) ;
        System.out.println("NULL");
    }
    public static void push(Node head,int data){
        Node temp = new Node(data);
        if (head == null){
            head = temp;
        }
        if (head.next == null){
            head.next = head;
        }
        Node curr = head;
        while (curr != null){
            curr = curr.next;
        }
        curr.next= temp;
    }
    public static Node insertFirst(Node head,int data){
        Node temp = new Node(data);
        if (head == null){
            head = temp;
        }
        else if (head.next == null){
            head.next = head;
        }else {
            Node curr = head;
            while (curr.next != head) {
                curr = curr.next;
            }
            curr.next = temp;
            temp.next = head;
            head = temp;
        }
        return  head;
    }

    public static void insertFirst1(Node head,int data){
        Node temp = new Node(data);
        if (head == null){
            head = temp;
        }
        if (head.next == null){
            head.next = head;
        }
        int t = head.data;
        head.data = temp.data;
        temp.data = t;
        temp.next = head.next;
        head.next = temp;
    }

    public static Node insertLast(Node head,int data){
        Node temp = new Node(data);
        if (head == null){
            head = temp;
        }
        if (head.next == null){
            head.next = head;
        }
        Node curr = head;
        while (curr != null){
            curr = curr.next;
        }
        curr.next= temp;
        temp.next = head;
        return curr;
    }
    public static Node deleteLast(Node head){
        if (head == null){
            return null;
        }
        Node curr = head;
        while (curr.next.next != head){
            curr = curr.next;
        }
        curr.next = head;
        return head;

    }

    public static Node deleteFirst(Node head){
        if (head == null){
            return null;
        }
        Node curr = head;
        while (curr.next != head){
            curr = curr.next;
        }
        Node temp = head.next;
        curr.next = temp;
        head = temp;
        return head;

    }
    public static Node delete(Node head,int key){
        if (head == null){
            return null;
        }
        if (head.data == key){
            return deleteFirst(head);
        }
        Node curr = head.next;
        //Node prev = null;
        while (curr != head){
            if(curr.next.data == key){
                curr.next = curr.next.next;
                return head;
            }else {
                curr = curr.next;
            }
        }
        return head;
    }


    public static Node reverseList(Node curr, Node prev,Node head){
        if(curr == null)
            return prev;
        if (curr == head)
            return prev;
        Node next = curr.next;
        curr.next = prev;
        return reverseList(next,curr,head);
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        /*head.next = new Node(20);
        head.next.next = new Node(30);*/
        head.next = head;
        /*head.next.next.next.next = new Node(30);
        head.next.next.next.next.next = new Node(30);
        head.next.next.next.next.next.next = new Node(50);*/
        /*head = insertFirst(head,40);
        print(head);

        insertFirst1(head,50);
        print(head);

        Node rhead = deleteFirst(head);
        print(rhead);*/

        Node dhead = delete(head,30);
        print(dhead);
    }
}
