package com.test.practices.linkedlist;

import java.util.Stack;

public class LinkedList {
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

    //10 20  40 50 \30\
    public static Node sortedInsert(Node head, int data) {
        if (head == null)
            return new Node(data);
        Node temp = head;
        while (temp != null) {
            if (temp.data < data) {
                temp = temp.next;
            } else {
                int t1 = temp.data;
                temp.data = data;
                Node newNode = new Node(t1);
                newNode.next = temp.next;
                temp.next = newNode;
                return head;
            }
        }
        return head;
    }

    public static Node sortedInsert2(Node head, int data) {
        Node temp = new Node(data);
        if (head == null)
            return temp;
        else if (data < head.data) {
            temp.next = head;
            return temp;
        } else {
            Node curr = head;
            while (curr.next != null && curr.next.data < data) {
                curr = curr.next;
            }
            temp.next = curr.next;
            curr.next = temp;
            return head;
        }
    }

    public static void print(Node node) {
        if (node == null) {
            return;
        }
        Node curr = node;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("NULL");
    }

    public static void deleteGivenNode(Node node) {
        Node temp = node.next;
        node.data = temp.data;
        node.next = temp.next;
    }

    public static Node  add(Node head, int data){
        if (head == null)
            return new Node(data);
        Node curr = head;
        while (curr.next!=null){
            curr = curr.next;
        }
        if (curr!=null) {
            curr.next = new Node(data);

        }

        return head;
    }

    public static Node add(Node node, int data, int pos) {
        if (node == null || pos == 0) {
            Node temp = new Node(data);
            temp.next = node;
            node = temp;
            return node;
        }
        Node curr = node.next;//10 , 30 , 40 > 20 at 1
        for (int i = 1; i < pos && curr.next != null; i++) {
            if (i == pos - 1) {
                Node temp = new Node(data);
                temp.next = curr.next;
                curr.next = temp;
            }
        }
        return node;
    }

    public static int printMiddle(Node head) {
        if (head == null)
            return -1;
        int count = 0;
        Node curr = head;
        while (curr != null) {
            curr = curr.next;
            count++;
        }
        curr = head;
        for (int i = 0; i < count / 2; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    public static int printMiddle2(Node head) {
        if (head == null)
            return -1;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    public static int nthNodeFromEnd(Node head, int n) {
        if (head == null)
            return -1;
        int count = 0;
        Node curr = head;
        while (curr != null) {
            curr = curr.next;
            count++;
        }
        if (n > count)
            return -1;
        int nth = count - n + 1;

        curr = head;
        for (int i = 1; i < nth; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    public static int nthNodeFromEnd2(Node head, int n) {
        if (head == null)
            return -1;
        Node first = head;
        for (int i = 1; i < n; i++) {
            if (first == null)
                return -1;
            first = first.next;
        }
        Node second = head;
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        return second.data;
    }

    public static Node removeDuplicate(Node head) {
        Node curr = head;
        while (curr != null && curr.next != null) {
            if (curr.data == curr.next.data)
                curr.next = curr.next.next;
            else
                curr = curr.next;
        }
        return head;
    }

    //Naive solution
    public static Node reverse(Node head){
        Stack stack = new Stack();
        Node curr = head;
        while (curr!=null){
            stack.add(curr.data);
            curr=curr.next;
        }
        curr = head;
        while (curr!=null){
            curr.data = (int) stack.pop();
            curr=curr.next;
        }
        return head;
    }
    //Efficient Solution
    public static Node reverse1(Node head){
        Node curr = head;
        Node prev = null;
        while (curr!=null){
            Node next =curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    //reverse using recursion (part 1)
    public static Node reverseList(Node  head){
        if (head == null)
            return head;
        if (head.next == null)
            return head;
        Node rest_head = reverseList(head.next);
        print(rest_head);
        Node rest_tail = head.next;
        rest_tail.next = head;
        head.next = null;
        return rest_head;
    }

    //reverse using recursion (part 2)
    public static Node reverseList(Node curr, Node prev){
        if(curr == null)
            return prev;
        /*if (curr.next == null)
            return prev;*/
        Node next = curr.next;
        curr.next = prev;
        return reverseList(next,curr);
    }


    public static void main(String[] args) {
        Node head = new Node(10);
        add(head,20);
       /* add(head,20);
        add(head,30);
        add(head,30);
        add(head,30);*/
        add(head,50);
        /*head.next = new Node(20);
        head.next.next = new Node(20);
        head.next.next.next = new Node(30);
        head.next.next.next.next = new Node(30);
        head.next.next.next.next.next = new Node(30);
        head.next.next.next.next.next.next = new Node(50);*/
        // head = sortedInsert2(head, 5);
        //deleteGivenNode(head.next.next);
        System.out.print("Before :: ");
        print(head);
        //System.out.println("middle:: "+printMiddle(head));
        //System.out.println("middle 2:: "+printMiddle2(head));
        //System.out.println("nthNodeFromEnd :: "+nthNodeFromEnd(head,3));
        //System.out.println("nthNodeFromEnd2 :: "+nthNodeFromEnd2(head,3));
        /* Node add = add(head, 100, 0);
        System.out.print("After :: ");
        print(add);*/

        /*head = removeDuplicate(head);
        System.out.print("removeDuplicate :: ");
        print(head);*/

        /*head = reverse(head);
        head = reverse1(head);*/
        //head = reverseList(head);
        head =  reverseList(head,null);
        System.out.print("removeDuplicate :: ");
        print(head);
    }
}
