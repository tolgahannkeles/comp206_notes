package midterm.homeworks;

import java.util.*;

public class Homework2 {

    public static void main(String[] args) {
        StackFromQueue.test();
    }

    static class StackFromQueue {

        private Queue<Integer> queue1 = new LinkedList<>();
        private Queue<Integer> queue2 = new LinkedList<>();

        public void push(int x) {
            // Push x first in empty q2
            if (queue2 == null) queue2 = new LinkedList<>();
            queue2.add(x);

            // Push all the remaining
            // elements in q1 to q2.
            while (!queue1.isEmpty()) {
                queue2.add(queue1.poll());
            }

            // swap the two queues
            queue1 = queue2;
            queue2 = null;
        }

        public Integer pop() {
            return queue1.poll();
        }

        public Integer top() {
            return queue1.peek();
        }

        public boolean empty() {
            return queue1.isEmpty();
        }

        @Override
        public String toString() {
            return queue1.toString();
        }

        public static void test() {
            StackFromQueue stack = new StackFromQueue();
            stack.push(7);
            stack.push(9);
            stack.push(3);
            System.out.println("Created Stack: " + stack);
            System.out.println(stack.pop() + " is deleted from " + stack);
            System.out.println(stack.pop() + " is deleted from " + stack);
            System.out.println("Is stack empty? " + stack.empty());
        }
    }

    static class Frequency {
        public static Integer[] topKFrequent(int[] nums, int k) {
            // Time complexity: O(n) because the frequency of each number is calculated in O(n) time
            // Number of total operations is O(n) + O(n) + O(k) = O(n)

            Map<Integer, Integer> frequencies = new HashMap<>();  // öap to store frequency of each number
            List<Integer> result = new ArrayList<>();  //list to store the top k frequent elements

            // finding the frequency of each number in the array
            // time complexity: O(n)
            for (int n : nums) {
                if (frequencies.get(n) == null) {
                    frequencies.put(n, 1);
                } else {
                    frequencies.put(n, frequencies.get(n) + 1);
                }
            }

            // sorting the map by value in descending order
            // time complexity: O(n)
            frequencies.entrySet().stream()
                    .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                    .forEachOrdered(x -> result.add(x.getKey()));

            // returning the top k frequent elements, time complexity: O(k)
            return Arrays.copyOfRange(result.toArray(new Integer[0]), 0, k);
        }


        public static void test() {
            // Creating the given array
            int[] testArray1 = {1, 2, 1, 2, 3, 1};
            int[] testArray2 = {6, 7, 4, 5, 6, 7, 3, 7, 5};

            // Printing the top k frequent elements
            System.out.println("Example1: " + Arrays.toString(topKFrequent(testArray1, 2)));
            System.out.println("Example2: " + Arrays.toString(topKFrequent(testArray2, 3)));

        }
    }

    static class BSTChecker {

        public static boolean isBST(TreeNode root) {
            //Time complexity: O(n) because the isBSTHelper function has a time complexity of O(n)
            return isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private static boolean isBSTHelper(TreeNode root, int min, int max) {
            // This function checks if the given tree is a BST or not in a recursive manner
            // Time complexity: O(n) because it visits each node exactly once
            // Base case
            if (root == null) return true;
            // If the current node's value is outside the min-max range, return false
            if (root.val <= min || root.val >= max) return false;
            // Check the left and right subtrees
            boolean isLeftBST = isBSTHelper(root.left, min, root.val);
            boolean isRightBST = isBSTHelper(root.right, root.val, max);
            return isLeftBST && isRightBST;
        }

        public static void test() {
            // Creating the given Tree
            TreeNode root = new TreeNode(7);
            root.left = new TreeNode(6);
            root.right = new TreeNode(9);
            root.left.left = new TreeNode(3);
            root.left.right = new TreeNode(12);
            root.right.left = new TreeNode(8);
            root.right.right = new TreeNode(11);

            // Checking if the given tree is a BST
            System.out.println("Is given tree a BST Tree? " + BSTChecker.isBST(root) + ".");

        }

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }


    static class DuplicateFinder {

        public static Integer[] findDuplicate(int[] nums) {
            // Time complexity: O(n) because the number of total operations is O(n) + O(n) = O(n)
            // Space complexity: O(1) because the space used is independent of the input size

            HashMap<Integer, Integer> map = new HashMap<>();
            List<Integer> duplicates = new ArrayList<>();

            // Calculating how many times each number appears in the array, time complexity: O(n) because it visits each element exactly once
            for (int num : nums) {
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }
            }

            // Add the duplicates to the list, time complexity: O(n) because it visits each element exactly once
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 2) {
                    duplicates.add(entry.getKey());
                }
            }

            return duplicates.toArray(new Integer[0]);
        }


        public static void test() {
            // Creating the given array
            int[] testArray1 = {4, 3, 2, 7, 8, 2, 3, 1, 5, 7, 8, 9};

            // Finding the duplicate number in the given array
            System.out.println(Arrays.toString(findDuplicate(testArray1)));

        }
    }


}
