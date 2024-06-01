package midterm.labs;

import java.util.ArrayList;
import java.util.Arrays;

public class Lab3 {
    public static Object[] maxSubArray(int[] arr) {
        /***
         * to find the index of max sub array, the max total job is n
         * to create the array with the given indeces, the max total job is n
         * so, when we sum both, it result 2n and that means it has O(n) time complexity.
         *
         * total used memory is around 2n and this also means O(n) space complexity.
         *
         * ***/
        int max = Integer.MIN_VALUE;
        int maxLocal = 0;
        int start = 0;
        int end = 0;
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            maxLocal += arr[i];
            if (max < maxLocal) {
                max = maxLocal;
                start = temp;
                end = i;
            }
            if (maxLocal < 0) {
                maxLocal = 0;
                temp = i + 1;
            }
        }

        ArrayList<Integer> subArray= new ArrayList<>();
        for(int i=start; i<end+1; i++){
            subArray.add(arr[i]);
        }

        return subArray.toArray();
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(Arrays.toString(maxSubArray(nums)));
    }
}
