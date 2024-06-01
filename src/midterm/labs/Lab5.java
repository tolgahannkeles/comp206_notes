package midterm.labs;

import java.util.ArrayList;
import java.util.HashMap;

public class Lab5 {
    static HashMap<Character, String> map = new HashMap<>();

    public static void main(String[] args) {
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        System.out.println(letterCombinations("1"));
        System.out.println(letterCombinations("2"));
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations("234"));
    }

    public static ArrayList<String> letterCombinations(String digits) {
        /*
        Time Complexity: O(4^n) because combine method has O(4^n) time complexity and the other are constant time operations.
         */

        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        ArrayList<String> combinations = new ArrayList<>();
        combine("", digits, 0, combinations);
        return combinations;
    }

    private static void combine(String first, String digits, int index, ArrayList<String> combinations) {

        /*
        	Because for each digit, there are 4 possible letters in the worst case scenario.
        	The recursive function combine is called for each digit to result in a total of 4^n combinations being generated.
        	Therefore, the time complexity is O(4^n).
         */

        // Base case
        if (index >= digits.length()) {
            // it adds the combination to the list
            combinations.add(first);
            return;
        }
        // Recursive case
        String letters = map.get(digits.charAt(index)); // it gets the letters for the current digit
        for (char letter : letters.toCharArray()) {
            // it calls the combine method for the next digit
            combine(first + letter, digits, index + 1, combinations);
        }
    }
}
