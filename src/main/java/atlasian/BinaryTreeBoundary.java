package atlasian;

public class BinaryTreeBoundary {

    /*
Given a binary tree, print boundary nodes of the binary tree counter-clockwise starting from the root.
For example, boundary traversal of the following tree is “20 8 4 10 14 25 22”

                  20
                /   \
              8       22
            /  \        \
          4     12       25
              /   \
            10     14

  // root = 20
  // root.left = 8
  // root.left.left = 4

  20 -> 8 -> 4 -> 10 -> 14 -> 25 -> 22

  20 -> 8 -> 4 -> 10 -> 14 -> 22 -> 25


    // Construct the tree given in the above diagram
    struct node *root         = newNode(20);
    root->left                = newNode(8);
    root->left->left          = newNode(4);
    root->left->right         = newNode(12);
    root->left->right->left   = newNode(10);
    root->left->right->right  = newNode(14);
    root->right               = newNode(22);
    root->right->right        = newNode(25);
    /*
Given a binary tree, print boundary nodes of the binary tree counter-clockwise starting from the root.
For example, boundary traversal of the following tree is “20 8 4 10 14 25 22”

                  20
                /   \
              8       22
            /  \        \
          4     12       25
              /   \
            10     14
            */

        public static void main(String[] as){

            BinaryTree binaryTree  = new BinaryTree(20);
            binaryTree.left = new BinaryTree(8);
            binaryTree.left.left = new BinaryTree(4);
            binaryTree.left.right = new BinaryTree(12);
            binaryTree.left.right.left = new BinaryTree(10);
            binaryTree.left.right.right = new BinaryTree(14);

            binaryTree.right = new BinaryTree(22);
            binaryTree.right.right = new BinaryTree(25);

            printTree(binaryTree);
        }

        private static void printTree(BinaryTree root){

            if(root == null || (root.left==null && root.right==null)) return;

            System.out.println(root.val + " -> ");

            printLeftNodes(root.left);
            printLeafNodes(root);
            printRightNodes(root.right);
        }

        private static void printLeftNodes(BinaryTree root){

            if(root==null) return;

            if(root.left!=null || root.right!=null) {
                System.out.println(root.val + " -> ");
            }
            printLeftNodes(root.left);

        }


        private static void printLeafNodes(BinaryTree root){
            if(root==null) return;

            if(root.left==null && root.right==null) {
                System.out.println(root.val + " -> ");
            }
            printLeafNodes(root.left);
            printLeafNodes(root.right);

        }

        private static void printRightNodes(BinaryTree root){
            if(root==null) return;

            printRightNodes(root.right);
            if(root.left!=null || root.right!=null) {
                System.out.println(root.val + " -> ");

            }
        }

        private static class BinaryTree{

            int val;
            BinaryTree left;
            BinaryTree right;


            public BinaryTree(int val){
                this.val = val;
            }
        }
    }

