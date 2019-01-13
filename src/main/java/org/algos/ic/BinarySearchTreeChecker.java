package org.algos.ic;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.*;

public class BinarySearchTreeChecker {

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

        public void insert(BinaryTreeNode node, Integer toInsert){

            BinaryTreeNode current = node;

           if(toInsert.compareTo(value) < 0){

               if(current.left == null) {
                   node.insertLeft(toInsert);
               }
               else {
                   insert(current.left,toInsert);
               }

           }
           else {
               if(current.right == null){
                   node.insertRight(toInsert);
               }
               else{
                   insert(current.right, toInsert);
               }
           }
        }
    }

    static class NodeBounds
    {
        int lowerBound;
        int upperBound;
        BinaryTreeNode node;

        public NodeBounds(int lowerBound, int upperBound, BinaryTreeNode node){
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
            this.node = node;
        }
    }
    public static boolean isBinarySearchTree(BinaryTreeNode root, int min, int max) {

        if(root == null) return true;

        if(root.value <= min || root.value > max)
            return false;


        return isBinarySearchTree(root.left, min, root.value)
             && (isBinarySearchTree(root.right, root.value, max));


    }
    public static boolean isBinarySearchTree(BinaryTreeNode root) {

        Deque<NodeBounds> nodes = new ArrayDeque();
        nodes.push(new NodeBounds(Integer.MIN_VALUE, Integer.MAX_VALUE, root));


        while(!nodes.isEmpty()){

           NodeBounds nodeBounds =  nodes.pop();
           int lowerBound = nodeBounds.lowerBound;
           int upperBound = nodeBounds.upperBound;
           BinaryTreeNode node = nodeBounds.node;



           if(node.value > upperBound || node.value <= lowerBound) return false;
           if(node.left!=null) {
               nodes.push(new NodeBounds(lowerBound, node.value, node.left));
               System.out.println("Pushed left Node with values -> "+ " lowerBound-> "+ lowerBound + " upperBound/AncestorNode Val -> "+ node.value + " And left-node value -> "+ node.left.value );
           }

           if(node.right!=null) {
               nodes.push(new NodeBounds(node.value, upperBound, node.right));
               System.out.println("Pushed right Node with values -> "+ " lowerBound-> "+ node.value + " upperBound itself -> "+ upperBound + " And right-node value -> "+ node.right.value );
           }


        }

        return true;

    }


    // tests

    @Test
    public void validFullTreeTest() {
        final BinaryTreeNode root = new BinaryTreeNode(50);
        final BinaryTreeNode a = root.insertLeft(30);
        a.insertLeft(30);
        //a.insertRight(40);
        final BinaryTreeNode b = root.insertRight(70);
        b.insertLeft(60).insertRight(90);
        b.insertRight(80);
        final boolean result = isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
//        final boolean result = isBinarySearchTree(root);
        assertTrue(result);
    }

    @Test
    public void bothSubtreesValidTest() {
        final BinaryTreeNode root = new BinaryTreeNode(50);
        final BinaryTreeNode a = root.insertLeft(30);
        a.insertLeft(20);
        a.insertRight(60);
        final BinaryTreeNode b = root.insertRight(80);
        b.insertLeft(70);
        b.insertRight(90);
        final boolean result = isBinarySearchTree(root);
        assertFalse(result);
    }

    @Test
    public void descendingLinkedListTest() {
        final BinaryTreeNode root = new BinaryTreeNode(50);
        root.insertLeft(40).insertLeft(30).insertLeft(20).insertLeft(10);
        final boolean result = isBinarySearchTree(root);
        assertTrue(result);
    }

    @Test
    public void outOfOrderLinkedListTest() {
        final BinaryTreeNode root = new BinaryTreeNode(50);
        root.insertRight(70).insertRight(60).insertRight(80);
        final boolean result = isBinarySearchTree(root);
        assertFalse(result);
    }

    @Test
    public void oneNodeTreeTest() {
        final BinaryTreeNode root = new BinaryTreeNode(50);
        final boolean result = isBinarySearchTree(root);
        assertTrue(result);
    }

    @Test
    public void insertTest(){
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.insert(root,5);
        root.insert(root,4);
        root.insert(root,11);
        root.insert(root,12);

        System.out.println(root);


    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(BinarySearchTreeChecker.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }

}
