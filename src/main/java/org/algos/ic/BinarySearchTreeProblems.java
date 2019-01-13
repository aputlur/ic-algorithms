package org.algos.ic;

import org.junit.Test;
import static org.junit.Assert.*;


public class BinarySearchTreeProblems {

    public static class BinaryTreeNode {

        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        public BinaryTreeNode insertLeft(int leftValue) {
            this.left = new BinaryTreeNode(leftValue);
            return this.left;
        }

        public BinaryTreeNode insertRight(int rightValue) {
            this.right = new BinaryTreeNode(rightValue);
            return this.right;
        }
    }

    private static void print(BinaryTreeNode node){
        if(node == null) return;

        System.out.print(node.value + "->");
        print(node.left);
        print(node.right);
    }
    public static int findMinValueInBinarySearchTree(BinaryTreeNode root){

        if(root == null) return Integer.MIN_VALUE;

        if(root.left == null) return root.value;

        return findMinValueInBinarySearchTree(root.left);
    }

    public static int findMaxDepthOfTheTree(BinaryTreeNode head){


        if(head == null) return 0;

        if(head.left == null && head.right == null) return 0;

        int leftMaxDepth = 1 + findMaxDepthOfTheTree(head.left);
        int rightMaxDepth = 1 + findMaxDepthOfTheTree(head.right);

        return Math.max(leftMaxDepth, rightMaxDepth);

    }

    public static void mirrorBinaryTree(BinaryTreeNode root){
        if(root == null) return;

        mirrorBinaryTree(root.left);
        mirrorBinaryTree(root.right);

        BinaryTreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    @Test
    public void fullTreeTest() {
        final BinaryTreeNode root = new BinaryTreeNode(5);
        final BinaryTreeNode a = root.insertLeft(8);
        final BinaryTreeNode b = root.insertRight(6);
        a.insertLeft(1);
        a.insertRight(2);
        b.insertLeft(3);
        b.insertRight(4);
        int result = findMinValueInBinarySearchTree(root);
        assertSame(result, 1);
    }

    @Test
    public void findDepthOfTheTree() {
        final BinaryTreeNode root = new BinaryTreeNode(5);
        final BinaryTreeNode a = root.insertLeft(8);
        final BinaryTreeNode b = root.insertRight(6);
        a.insertLeft(1);
        a.insertRight(2);
        b.insertLeft(3);
        b.insertRight(4);
        int result = findMaxDepthOfTheTree(root);
        assertSame(2, result);
    }

    @Test
    public void mirrorBinaryTree(){
        final BinaryTreeNode root = new BinaryTreeNode(5);
        final BinaryTreeNode a = root.insertLeft(8);
        final BinaryTreeNode b = root.insertRight(6);
        a.insertLeft(1);
        a.insertRight(2);
        b.insertLeft(3);
        b.insertRight(4);
        print(root);
        System.out.println("\n");
        mirrorBinaryTree(root);
        print(root);
    }

}
