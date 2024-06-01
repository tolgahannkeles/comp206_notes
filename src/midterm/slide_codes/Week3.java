package midterm.slide_codes;

public class Week3 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearch(arr, 0, arr.length, 5));
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if target is present at mid
            if (arr[mid] == target) {
                return mid;
            }

            // If target greater, ignore left half
            if (arr[mid] < target) {
                left = mid + 1;
            }
            // If target is smaller, ignore right half
            else {
                right = mid - 1;
            }
        }

        // Target not found
        return -1;
    }

    static int binarySearch(int[] arr, int start, int finish, int target) {
        if (start > finish) {
            return -1;
        }
        int mid = start + (finish - start + 1) / 2;
        if (target < arr[mid]) {
            return binarySearch(arr, start, mid - 1, target);
        } else if (target > arr[mid]) {
            return binarySearch(arr, mid + 1, finish, target);
        } else {
            return mid;
        }
    }


    public static int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static void printPrimesUpToN(int n) {
        for (int num = 2; num <= n; num++) {
            boolean isPrime = true;

            // Check if num is divisible by any number from 2 to its square root
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.print(num + " ");
            }
        }
        System.out.println(); // Print newline after all prime numbers
    }


    static class MergeSort {
        public static void mergeSort(int[] arr) {
            if (arr == null || arr.length <= 1) {
                return;
            }
            int[] helper = new int[arr.length];
            mergeSort(arr, helper, 0, arr.length - 1);
        }

        private static void mergeSort(int[] arr, int[] helper, int left, int right) {
            if (left < right) {
                int mid = left + (right - left) / 2;
                mergeSort(arr, helper, left, mid);
                mergeSort(arr, helper, mid + 1, right);
                merge(arr, helper, left, mid, right);
            }
        }

        private static void merge(int[] arr, int[] helper, int left, int mid, int right) {
            // Copy both halves into the helper array
            for (int i = left; i <= right; i++) {
                helper[i] = arr[i];
            }

            int i = left;
            int j = mid + 1;
            int k = left;

            // Merge the two halves back into the original array
            while (i <= mid && j <= right) {
                if (helper[i] <= helper[j]) {
                    arr[k] = helper[i];
                    i++;
                } else {
                    arr[k] = helper[j];
                    j++;
                }
                k++;
            }

            // Copy the rest of the left side of the array into the target array
            while (i <= mid) {
                arr[k] = helper[i];
                k++;
                i++;
            }
        }
    }
}
