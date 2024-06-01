package midterm.labs;

import java.util.ArrayList;

public class Lab2 {
    /*
    Input: s = "the sky is blue"
    Output: "blue is sky the"
     */
    static String reverse(String word) {
        // Because it does total 3n+4 processes in the bad case, it has O(n) time complexity.
        // Because it does total 3n+4 processes in the bad case, it has O(n) space complexity.

        String[] chars = word.split(" "); // 1 process
        ArrayList<String> newArray = new ArrayList<>(); // 1 process

        // reversing array
        for (int i = chars.length - 1; 0 <= i; i--) { // 2n process
            if (chars[i] != "") {
                newArray.add(chars[i]);
            }
        }

        // builting new string from an array
        String newString = ""; // 1 process
        for (String temp2 : newArray) { // n process
            newString += (temp2 + " ");
        }

        return newString.trim(); // 1 process
    }

    // Test Code
    public static void main(String[] args) // Total 10pt
    {
        System.out.println(reverse("the  sky is blue"));
        System.out.println(reverse("  hello   world  "));
        System.out.println(reverse("a  good   example "));
    }

}
