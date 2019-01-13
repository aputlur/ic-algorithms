package org.algos.ic;

public class DepthFirstTraversal {

    static class BinarySearchTree {

        public static void main(String[] args) {
//            preOrderTraversal(createBinaryTree());
            inOrderTraversal(createBinaryTree());
            System.out.println("\n");
//            postOrderTraversal(createCharacterBinaryTree());
        }

        private static void postOrderTraversal(TreeNode<Character> root) {

            if(root == null) return;

            if(root.getLeftNode()!=null)
                postOrderTraversal(root.getLeftNode());
            if(root.getRightNode()!=null)
                postOrderTraversal(root.getRightNode());
            System.out.print(root.getData() + " -> ");
        }

        private static void inOrderTraversal(TreeNode<Integer> root) {

            if(root == null) return;

             if(root.leftNode!=null)
                 inOrderTraversal(root.leftNode);
            System.out.print(root.data + " -> ");
             if(root.rightNode!=null)
                 inOrderTraversal(root.rightNode);

        }


        private static void preOrderTraversal(TreeNode<Integer> root) {

            if (root == null)
                return;
            System.out.println(root.data + "->");
            preOrderTraversal(root.leftNode);
            preOrderTraversal(root.rightNode);

        }

        public static TreeNode<Character> createCharacterBinaryTree(){

            TreeNode<Character> treeNode = new TreeNode<>('A');
            TreeNode<Character> leftNode = new TreeNode<>('B');
            TreeNode<Character> rightNode = new TreeNode<>('C');

            TreeNode<Character> secondLeftNode = new TreeNode<>('D');
            secondLeftNode.setLeftNode(new TreeNode('F'));
            secondLeftNode.setRightNode(new TreeNode('H'));

            //c's left sub-tree
            rightNode.setLeftNode(secondLeftNode);

            TreeNode<Character> secondRightNode = new TreeNode<>('E');
            secondRightNode.setRightNode(new TreeNode('G'));


            rightNode.setRightNode(secondRightNode);
            treeNode.setLeftNode(leftNode);
            treeNode.setRightNode(rightNode);
            return treeNode;
        }

        public static TreeNode<Integer> createBinaryTree() {
            TreeNode<Integer> treeNode = new TreeNode<>(50);
            TreeNode<Integer> leftNode = new TreeNode<>(30);
            TreeNode<Integer> rightNode = new TreeNode<>(70);

            leftNode.setLeftNode(new TreeNode(10));
            leftNode.setRightNode(new TreeNode(40));

            rightNode.setLeftNode(new TreeNode(60));
            rightNode.setRightNode(new TreeNode(80));

            treeNode.setLeftNode(leftNode);
            treeNode.setRightNode(rightNode);

            return treeNode;
        }
    }

    static class TreeNode<T> {

        private T        data;
        private TreeNode leftNode;
        private TreeNode rightNode;

        public TreeNode(T data) {
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
