package midterm.labs;

public class Lab7 {

    static void inOrderTraversal(AVLNode node) {
        // prints the tree in inorder traversal
        // time complexity: O(n) because the total number of transactions is n
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.data + ",");
            inOrderTraversal(node.right);
        }
    }

    static AVLNode arrayToAVL(int[] arr, int start, int end) {
        // converts the given sorted array to an AVL tree and returns the root of the tree
        // time complexity is O(n) because it visits each node once

        // base case
        if (start > end) {
            return null;
        }
        // determines the middle element of the array
        int mid = (start + end) / 2;
        // creates a new node with the middle element of the array
        AVLNode node = new AVLNode(arr[mid]);

        // recursively builds the left and right subtree
        node.left = arrayToAVL(arr, start, mid - 1);
        node.right = arrayToAVL(arr, mid + 1, end);

        return node;
    }

    public static void main(String[] args) {
        int[] testArray = {3, 6, 7, 8, 9, 11};

        // converts the given sorted array to an AVL tree
        AVLNode root = arrayToAVL(testArray, 0, testArray.length - 1);

        // prints the root of the AVL Tree with inorder traversal
        inOrderTraversal(root);

    }

    static class AVLNode {
        int data;
        AVLNode left;
        AVLNode right;

        AVLNode(int data) {
            this.data = data;
        }
    }

}
