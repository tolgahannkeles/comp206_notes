package midterm.homeworks;

import java.util.ArrayList;
import java.util.Arrays;

public class Homework1 {
    public static void main(String[] args) {
        Question1.test();
        //Question2.test();
        //Question3.test();
        //Question4.test();
    }

    static class Question1 {
        public static void rotate(int[] arr, int k) {
            /*
            Because it iterates every element kth times, the time complexity is O(kN);
            * */
            // it pushes k times elements to forward
            if (k < 0 || k > arr.length) throw new IllegalArgumentException("K must be between 0 and arr.length");
            for (int i = 0; i < k; i++) {
                rotateRight1step(arr);
            }
        }

        public static void rotateRight1step(int[] arr) {
            /*
            This is a helper method for the first question.
            It has O(n) time complexity because total job is maximum n+2;
            * */
            /*
            last element is stored as temporarily and the other elements are pushed 1 forward
             */

            int temp = arr[arr.length - 1];
            for (int j = arr.length - 1; j > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[0] = temp;
        }

        public static void test() {
            System.out.println("------------Question 1--------------------");
            int[] arr = {-1, -100, 3, 99};
            System.out.println("Before rotation: " + Arrays.toString(arr));
            rotate(arr, 2);
            System.out.println("After 2 times rotation: " + Arrays.toString(arr));
            System.out.println("------------------------------------------");

        }
    }

    static class Question2 {

        public static String intToRomen(int num) {
            /*
            Because it iterates the 13 elements for every time and the max job will be done that method is about 13, but it relational with the number that is given,
            the time complexity can be O(1)
             */
            // defines the romens numbers and its values with same indices
            int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] romens = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

            String result = "";

            // iterates all the nums and corresponding romen numbers
            for (int i = 0; i < nums.length; i++) {
                // until the current value can be subtracted from 'num', it iterates
                while (num >= nums[i]) {
                    // Subtract the value from 'num' and add the romen numeral to the result
                    num -= nums[i];
                    result += romens[i];
                }
            }
            return result;
        }


        public static void test() {
            System.out.println("------------Question 2--------------------");
            System.out.println("1994 -> " + intToRomen(1994));
            System.out.println("------------------------------------------");
        }
    }

    static class Question3 {

        public static boolean isValidSudoku(char[][] board) {
            /*
            because it iterates the 9x9 matrix with performing constant time operations, the time complexity is O(1)
             */


            boolean[][] rowUsed = new boolean[9][9]; // rowUsed[i][num] is true if number 'num' is used in row 'i'
            boolean[][] colUsed = new boolean[9][9]; // same purpose as above
            boolean[][] boxUsed = new boolean[9][9]; // same purpose as above

            // iterates over each loc in the sudoku
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    // checks if the current loc is filled with a number
                    if (board[i][j] != '.') {
                        int num = board[i][j] - '1'; // converts the sudoku value to (0-8) integer
                        int boxIndex = (i / 3) * 3 + j / 3; // calculate the index of the subbox in the current loc

                        // checks if the current number is used or not
                        if (rowUsed[i][num] || colUsed[j][num] || boxUsed[boxIndex][num])
                            return false;

                        // write the current number as used
                        rowUsed[i][num] = colUsed[j][num] = boxUsed[boxIndex][num] = true;
                    }
                }
            }
            return true;
        }

        static void test() {
            char[][] sudoku = {
                    {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                    {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                    {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                    {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                    {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                    {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                    {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                    {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                    {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
            };
            System.out.println("------------Question 3--------------------");
            System.out.println("The given sudeko isValid?: " + isValidSudoku(sudoku));
            System.out.println("------------------------------------------");
        }
    }

    static class Question4 {
        static ArrayList<String> generateParenthesis(int n) {
            // to store the elements, arraylist is created
            ArrayList<String> resultArr = new ArrayList<>();
            // recursive method is called to form the array
            recurse(resultArr, 0, 0, "", n);
            return resultArr;
        }

        private static void recurse(ArrayList<String> res, int left, int right, String s, int n) {
            /*
            Because the function is called recursively twice in each iteration, the time complexity of the method is O(2^n)
            */
            if (s.length() == n * 2) {
                // if the paranthesis is complete add to arraylist
                res.add(s);
                return;
            }

            if (left < n) {
                // if the missing part is opening one, it adds it to string and iterates again
                recurse(res, left + 1, right, s + "(", n);
            }

            if (right < left) {
                // if the missing part is closing one, it adds it to string and iterates again
                recurse(res, left, right + 1, s + ")", n);
            }
        }


        static void test() {
            System.out.println("------------Question 4--------------------");
            System.out.println(generateParenthesis(10));
            System.out.println("------------------------------------------");
        }
    }

}
