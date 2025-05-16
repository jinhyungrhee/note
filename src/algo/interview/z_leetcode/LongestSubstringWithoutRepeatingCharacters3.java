package algo.interview.z_leetcode;

import java.util.*;
public class LongestSubstringWithoutRepeatingCharacters3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));

    }

    public static int lengthOfLongestSubstring(String s) {

        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        /**
         sliding window
         */
        HashSet<Character> table = new HashSet<>();

        int left = 0;
        int right = 1;
        int end = s.length() - 1;

        table.add(s.charAt(left));

        int maxSize = 0;
        while (right <= end) {

            // System.out.println("l = " + left + ", r = " + right + ", e = " + end);

            if (!table.contains(s.charAt(right))) {
                table.add(s.charAt(right));
            } else {
                // 중복된 문자면 윈도우 이동
                while(table.contains(s.charAt(right))) {
                    table.remove(s.charAt(left));
                    left++;
                }
                table.add(s.charAt(right));
            }

            int tableSize = table.size();
            if (tableSize > maxSize) maxSize = tableSize;

            right++;
        }

        return maxSize;
    }

    /**
    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        // sliding window

        HashSet<Character> table = new HashSet<>();

        int left = 0;
        int right = 1;
        int end = s.length() - 1;

        table.add(s.charAt(left));

        int maxSize = 0;
        while (right <= end) {

            // System.out.println("l = " + left + ", r = " + right + ", e = " + end);

            if (!table.contains(s.charAt(right))) {
                table.add(s.charAt(right));
            } else {
                // 중복된 문자면 윈도우 이동
                while(table.contains(s.charAt(right))) {
                    table.remove(s.charAt(left));
                    left++;
                }
                table.add(s.charAt(right));
            }

            int tableSize = table.size();
            if (tableSize > maxSize) maxSize = tableSize;

            right++;
        }

        return maxSize;
    }
     */

    /**
    public static int lengthOfLongestSubstring(String s) {

        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;

         // sliding window

        HashSet<Character> table = new HashSet<>();
        int left = 0;
        int right = 1;
        int end = s.length() - 1; // 7

        table.add(s.charAt(left));

        int maxSize = 0;
        while (right <= end) {

            // System.out.println("l = " + left + ", r = " + right + ", e = " + end);

            if (!table.contains(s.charAt(right))) {
                table.add(s.charAt(right));
            } else { // 중복된 문자면 윈도우 이동
                left++;
                right = left + 1;
                table = new HashSet<>();
                table.add(s.charAt(left));
            }
            System.out.println(table);
            int tableSize = table.size();
            if (tableSize > maxSize) maxSize = tableSize;

            right++;
        }
        System.out.println("result : " + maxSize);

        return maxSize;
    }
     */
}
