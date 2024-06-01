package midterm.slide_codes;

import midterm.data_structures.BinarySearchTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Week4 {

    public static String longestCommonPrefix(String[] strs) {
        // Because it does total 3n+4 processes in the bad case, it has O(n) time complexity.
        // Because it does total 3n+4 processes in the bad case, it has O(n) space complexity.

        if (strs.length == 0) return "";
        Arrays.sort(strs);
        char[] prefix = strs[0].toCharArray();
        char[] suffix = strs[strs.length - 1].toCharArray();
        int min= Math.min(prefix.length, suffix.length);
        for(int i=0; i<min; i++){
            if(prefix[i] != suffix[i]){
                prefix = Arrays.copyOfRange(prefix, 0, i);
                break;
            }
        }


        return String.copyValueOf(prefix);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        // Because it does total 3n+4 processes in the bad case, it has O(n) time complexity.
        // Because it does total 3n+4 processes in the bad case, it has O(n) space complexity.

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) { // n process
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
                while (lo < hi) { // 2n process
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (nums[lo] + nums[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }

    public int containerWithMostWater(int[] height) {
        // Because it does total 3n+4 processes in the bad case, it has O(n) time complexity.
        // Because it does total 3n+4 processes in the bad case, it has O(n) space complexity.

        int max = 0, i = 0, j = height.length - 1;
        while (i < j) { // n process
            max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) i++;
            else j--;
        }
        return max;
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return minHeap.peek();
    }


    public static int findKthLargest2(int[] nums, int k){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for(int num: nums){
            bst.insert(num);
        }

        List<Integer> inorder = bst.inorderTraversal();
        return  inorder.get(inorder.size()-k);
    }


    public int findKthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int i = 0; i < k; i++) {
            maxHeap.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(nums[i]);
            }
        }
        return maxHeap.peek();
    }

    public static int findKthSmallest2(int[] nums, int k){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for(int num: nums){
            bst.insert(num);
        }

        List<Integer> inorder = bst.inorderTraversal();
        return inorder.get(k-1);
    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        permuteHelper(nums, new ArrayList<>(), permutations);
        return permutations;
    }

    private void permuteHelper(int[] nums, List<Integer> current, List<List<Integer>> permutations) {
        if (current.size() == nums.length) {
            permutations.add(new ArrayList<>(current));
            return;
        }

        for (int num : nums) {
            if (!current.contains(num)) {
                current.add(num);
                permuteHelper(nums, current, permutations);
                current.remove(current.size() - 1);
            }
        }
    }

    public List<Integer> countGoodNumbers(long n) {
        long mod = 1000000007;
        long odd = (n + 1) / 2;
        long even = n / 2;
        long result = 1;
        long base = 20;
        while (odd > 0) {
            if (odd % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            odd /= 2;
        }
        base = 5;
        while (even > 0) {
            if (even % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            even /= 2;
        }
        return Arrays.asList((int) result);
    }
}
