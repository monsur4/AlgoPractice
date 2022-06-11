package com.mon.trees;

public class BST {

    public BST(){}
    public Node insertNode(Node head, int data){
        if(head == null){
            head = new Node(data);
            return head;
        }

        if(data < head.val){
            head.left = insertNode(head.left, data);
        }else{
            head.right = insertNode(head.right, data);
        }
        return head;
    }

    public void printLeafNodes(Node head){
        if(head == null) return;
        if(head.left == null && head.right == null){
            System.out.print(head.val +", ");
            return;
        }
        //if(head.left != null) -> checks before going down a path, but there is no need as head == null will still be checked after recursion
            printLeafNodes(head.left);
        //if(head.right != null)
            printLeafNodes(head.right);
    }

    class Node{
        private int val;
        private Node left;
        private Node right;

        public Node(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        BST bst = new BST();
        // data
        int[] arr = new int[]{100, 80, 90, 50, 120, 85, 60, 140, 110, 115, 150, 30, 95, 108};

        // insert into bst
        Node head = null;
        for(int data: arr){
            head = bst.insertNode(head, data);
        }

        // print leaf nodes
        bst.printLeafNodes(head);

    }

}
