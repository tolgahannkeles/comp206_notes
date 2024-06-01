package midterm.labs;

public class Lab6 {

    public static void main(String[] args) {
        // Creating AVL tree
        AVLTree tree = new AVLTree();
        tree.root = new AVLNode(8);
        tree.root.left = new AVLNode(3);
        tree.root.left.left = new AVLNode(1);
        tree.root.left.right = new AVLNode(6);
        tree.root.left.right.left = new AVLNode(4);
        tree.root.left.right.right = new AVLNode(7);

        tree.root.right = new AVLNode(10);
        tree.root.right.right = new AVLNode(14);
        tree.root.right.right.left = new AVLNode(13);

        System.out.println(AVLTree.isBalanced(tree.root) ? "it is an AVL tree" : "it is not an AVL tree");

    }

    static class AVLNode {
        int data;
        AVLNode left; // Left child
        AVLNode right; // Right child

        public AVLNode(int data) {
            this.data = data;
        }
    }

    static class AVLTree {
        AVLNode root; // Root of the AVL tree
        private static int height(AVLNode node) {
            // because it checks the every node to find the height of the tree, it has O(n) time complexity
            if (node == null) {
                return -1; // if node is empty, return -1
            }
            int leftHeight = height(node.left); // finds left height
            int rightHeight = height(node.right); // finds right height
            return Math.max(leftHeight, rightHeight) + 1; // returns the maximum one of the left and right subtree
        }

        public static boolean isBalanced(AVLNode root) {
            // time complexity is O(n^2) because it calls the height method for every node in the tree
            if (root == null) {
                return true; // if it is an empty tree, return true
            }
            int difference = height(root.left) - height(root.right); // calculates the differences between height of the left and right subtree
            return (Math.abs(difference) <= 1) && isBalanced(root.left) && isBalanced(root.right);
        }
    }

}
