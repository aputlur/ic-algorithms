package org.algos.ic;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static org.junit.Assert.*;

public class BalancedBinaryTree {

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

    private static class NodeDepthPair {
        BinaryTreeNode node;
        int depth;

        NodeDepthPair(BinaryTreeNode node, int depth){
            this.node = node;
            this.depth = depth;
        }
    }

    public static boolean isBalanced(BinaryTreeNode treeRoot) {

        if(treeRoot == null) return true;

        List<Integer> depths = new ArrayList<>(3);

        Deque<NodeDepthPair> queue = new ArrayDeque<>();
        queue.push(new NodeDepthPair(treeRoot,0));

        while(!queue.isEmpty()){

            NodeDepthPair nodeDepthPair = queue.pop();
            BinaryTreeNode node = nodeDepthPair.node;
            int depth = nodeDepthPair.depth;

            //  System.out.println("depth -> "+ depth);
            if(node.left == null && node.right == null){

                if(!depths.contains(depth)){
                    depths.add(depth);


                    //two ways we might have an unbalanced tree:
                    // 1) more than 2 different leaf depths
                    // 2) leaf depths that are more than 1 apart

                    if(depths.size() > 2 || (depths.size() == 2
                            &&  Math.abs(depths.get(0) - depths.get(1)) > 1)){

                        return false;
                    }


                }

            }

            else{
                if(node.left!=null)
                    queue.push(new NodeDepthPair(node.left, depth + 1));
                if(node.right!=null)
                    queue.push(new NodeDepthPair(node.right, depth + 1));


            }

        }

        return true;
    }

    private static int findDepth(BinaryTreeNode treeRoot){

        if(treeRoot == null) return 0;

        if(treeRoot.left == null && treeRoot.right == null) return 0;

        int leftTreeDepth = 1 + findDepth(treeRoot.left);
        int rightTreeDepth = 1 + findDepth(treeRoot.right);

        // System.out.println("Left depth -> " + leftTreeDepth + " Righ-tree depth -> "+ rightTreeDepth);

        return Math.max(leftTreeDepth, rightTreeDepth);
    }


    @Test
    public void fullTreeTest() {
        final BinaryTreeNode root = new BinaryTreeNode(5);
        final BinaryTreeNode a = root.insertLeft(8);
        final BinaryTreeNode b = root.insertRight(6);
        a.insertLeft(1);
        a.insertRight(2);
        b.insertLeft(3);
        b.insertRight(4).insertRight(5);
        final boolean result = isBalanced(root);
        assertTrue(result);
    }

    @Test
    public void bothLeavesAtTheSameDepthTest() {
        final BinaryTreeNode root = new BinaryTreeNode(3);
        root.insertLeft(4).insertLeft(1);
        root.insertRight(2).insertRight(9);
        final boolean result = isBalanced(root);
        assertTrue(result);
    }

    @Test
    public void leafHeightsDifferByOneTest() {
        final BinaryTreeNode root = new BinaryTreeNode(6);
        root.insertLeft(1);
        root.insertRight(0).insertRight(7);
        final boolean result = isBalanced(root);
        assertTrue(result);
    }

    @Test
    public void leafHeightsDifferByTwoTest() {
        final BinaryTreeNode root = new BinaryTreeNode(6);
        root.insertLeft(1);
        root.insertRight(0).insertRight(7).insertRight(8);
        final boolean result = isBalanced(root);
        assertFalse(result);
    }

    @Test
    public void bothSubTreesSuperbalancedTest() {
        final BinaryTreeNode root = new BinaryTreeNode(1);
        root.insertLeft(5);
        final BinaryTreeNode b = root.insertRight(9);
        b.insertLeft(8).insertLeft(7);
        b.insertRight(5);
        final boolean result = isBalanced(root);
        assertFalse(result);
    }

    @Test
    public void onlyOneNodeTest() {
        final BinaryTreeNode root = new BinaryTreeNode(1);
        final boolean result = isBalanced(root);
        assertTrue(result);
    }

    @Test
    public void treeIsLinkedListTest() {
        final BinaryTreeNode root = new BinaryTreeNode(1);
        root.insertRight(2).insertRight(3).insertRight(4);
        final boolean result = isBalanced(root);
        assertTrue(result);
    }

}
