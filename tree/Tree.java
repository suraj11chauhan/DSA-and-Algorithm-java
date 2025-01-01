package com.test.practices.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class Tree {
    Node root;
    static class Node {
        public int key;
        public Node left;
        public Node right;

        public Node(int key, Node left,Node right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }

        public Node(int key) {
            this.key = key;
            this.left = null;
            this.right = null;
        }
    }

    public Node insert(int key){
        return insert(this.root,key);
    }
    
    public Node insert(Node root, int key){
        if(root == null){
            return new Node(key);
        }else if(root.key == key){
            return root;
        }else if(root.key>key){
            root.left = insert(root.left, key);
        }else {
            root.right = insert(root.right, key);
        }
        return root;
    }

    //pre-order root-left-right
    public static void preorder(Node root){
        if (root == null)
            return;
        System.out.print(root.key+"  ");
        preorder(root.left);
        preorder(root.right);
    }
    //in-order  left-root-right
    public static void inorder(Node root){
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.key+"  ");
        inorder(root.right);
    }
    //post-order left-right-root
    public static void postorder(Node root){
        if (root == null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.key+"  ");
    }
    //contains
    public static boolean contains(Node root, int key){
        if (root == null)
            return false;
        if(root.key == key){
            return true;
        }
        else if (key > root.key) {
            return contains(root.left, key);
        } else {
            return contains(root.right, key);
        }
    }
    //find
    public static int find(Node root, int key){
        if (root == null)
            return -1;
        if(root.key == key){
            return root.key;
        }
        else if (key > root.key) {
            return find(root.left, key);
        } else {
            return find(root.right, key);
        }
    }

    public static int height(Node root){
        if (root == null)
            return -1;
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh,rh)+1;
    }
    public  static void printAtKthDistance(Node root,int k){
        if (root == null)
            return;
        if (k == 0){
            System.out.print(root.key+ " ");
        }else {
            printAtKthDistance(root.left,k-1);
            printAtKthDistance(root.right,k-1);
        }
    }

    public static void levelOrder(Node root){
        if (root == null)
            return;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (queue.size() > 0){
            Node node = queue.remove();
            System.out.print(node.key+" ");
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
    }

    public static int size(Node root){
        if (root == null)
            return 0;
        else {
            int lh = size(root.left);
            int rh = size(root.right);
            return lh + rh + 1;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
//        preorder(root);
//        System.out.println();
//        inorder(root);
//        System.out.println();
//        postorder(root);
//        System.out.println();
//        System.out.println(contains(root,1));
//        int h = height(root);
//        System.out.println(h);
//        printAtKthDistance(root,1);
        levelOrder(root);
        System.out.println();
        System.out.println(size(root));
    }
}
