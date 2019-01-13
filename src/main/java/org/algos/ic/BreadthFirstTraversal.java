package org.algos.ic;

import java.util.ArrayDeque;
import java.util.Deque;

public class BreadthFirstTraversal {

    public static void main(String[] args) {
        breadthFirstTraversal(BinarySearchTree.createBinarySearchTree());
    }

    public static void breadthFirstTraversal(TreeNode<Integer> root){

        if(root == null) return;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while(!queue.isEmpty()){

           TreeNode<Integer> node =  queue.pop();
            System.out.print(node.getData() + " --> ");

            if(node.getLeftNode()!=null)
                queue.add(node.getLeftNode());

            if(node.getRightNode()!=null)
                queue.add(node.getRightNode());

        }


    }

    static class BinarySearchTree {

        public static TreeNode<Integer> createBinarySearchTree() {
            TreeNode<Integer> treeNode = new TreeNode<>(1);
            TreeNode<Integer> leftNode = new TreeNode<>(2);
            TreeNode<Integer> rightNode = new TreeNode<>(3);
            leftNode.setLeftNode(new TreeNode(4));
            rightNode.setRightNode(new TreeNode(5));
            treeNode.setLeftNode(leftNode);
            treeNode.setRightNode(rightNode);
            return treeNode;
        }
    }


   static class TreeNode<T>{

        private T data;
        private TreeNode leftNode;
        private TreeNode rightNode;

        public TreeNode(T data){
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public TreeNode getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(TreeNode leftNode) {
            this.leftNode = leftNode;
        }

        public TreeNode getRightNode() {
            return rightNode;
        }

        public void setRightNode(TreeNode rightNode) {
            this.rightNode = rightNode;
        }
    }
}
