package midterm.labs;

import java.util.Arrays;

public class Lab1 {

    public static int[] removeDuplicates(int[] arr) { //Total: 60 pt
        int n = arr.length;
        if (n <= 1)  //5pt
            return arr;

        int uniqueCount = 1; // At least one unique element

        for (int i = 1; i < n; i++) { //15pt
            boolean isDuplicate = false;
            for (int j = 0; j < uniqueCount; j++) {
                if (arr[i] == arr[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) { //10pt
                if (uniqueCount != i) {
                    // Shift elements to maintain order
                    int temp = arr[i];
                    for (int k = i; k > uniqueCount; k--) {
                        arr[k] = arr[k - 1];
                    }
                    arr[uniqueCount] = temp;
                }
                uniqueCount++;
            }
        }

        // Truncating the array to remove extra elements
        return Arrays.copyOfRange(arr, 0, uniqueCount); //10pt
    }

    // Function to count the number of unique elements in an array
    public static int countUniqueElements(int[] arr) { //20pt
        int count = 0;
        int prev = -1;
        for (int num : arr) {
            if (num != prev) {
                count++;
                prev = num;
            }
        }
        return count;
    }

    public static void main(String[] args) { //Total: 10 pt

        int[] arr = {8, 5, 3, 5, 7, 1, 2, 3, 9, 4, 2, 4, 7, 0, 3};
        int[] result = removeDuplicates(arr); //calling function 5pt
        int uniqueCount = countUniqueElements(result);

        // Printing the remaining array //5pt
        System.out.print("Output: ");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

        // Printing the number of unique elements
        System.out.println("\nThere are " + uniqueCount + " elements in the remaining array.");
    }


}
