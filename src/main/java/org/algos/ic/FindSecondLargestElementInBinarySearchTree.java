package org.algos.ic;
import static org.junit.Assert.*;
import org.junit.Test;

public class FindSecondLargestElementInBinarySearchTree {

    @Test
   public void testFullTest() {
       final BinaryTreeNode root = new BinaryTreeNode(50);
       final BinaryTreeNode a = root.insertLeft(30);
       a.insertLeft(10);
       a.insertRight(40);
       final BinaryTreeNode b = root.insertRight(70);
       b.insertLeft(60);
       b.insertRight(80);
       final int actual = findSecondLargest(root);
       final int expected = 70;
       assertEquals(expected, actual);

    }
    //          ( 5 )
    //         /     \
    //       (3)     (8)
    //      /  \     /  \
    //   (1)  (4) (7)  (12)
    //                  /
    //               (10)
    //               /  \
    //              (9)  (11)

    @Test
    public void testLeftSubTreeTest(){
        final BinaryTreeNode root = new BinaryTreeNode(5);
        final BinaryTreeNode a = root.insertLeft(3);
        final BinaryTreeNode b = root.insertRight(8);

        a.insertLeft(1);
        a.insertRight(4);
        b.insertLeft(7);
        BinaryTreeNode right = b.insertRight(12);
        BinaryTreeNode leftSubTree =  right.insertLeft(10);
        leftSubTree.insertLeft(9);
        leftSubTree.insertRight(11);

        final int actual = findSecondLargest(root);
        final int expected = 11;
        assertEquals(expected, actual);
    }
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

    public static int findSecondLargest(BinaryTreeNode rootNode) {

        if(rootNode == null || (rootNode.left == null && rootNode.right == null))
            throw new IllegalArgumentException("must have more than 2 elements");

        BinaryTreeNode current = rootNode;

        while(true){

            //condition-1 : current.right.left and current.right.right is null

            if(current.right!=null && (current.right.left==null && current.right.right==null)){

                return current.value;
            }

            //          ( 5 )
            //         /     \
            //       (3)     (8)
            //      /  \     /  \
            //   (1)  (4) (7)  (12)
            //                  /
            //               (10)
            //               /  \
            //              (9)  (11)

            //condition -2, left-subtree is not null and find the largest
            if(current.right==null && current.left!=null){
               return findLargest(current.left);
            }
            current = current.right;
        }
    }


    public static int findLargest(BinaryTreeNode rootNode) {
        BinaryTreeNode current = rootNode;

        if (current.right != null) {
            return findLargest(current.right);
        }
        return current.value;
    }

}
