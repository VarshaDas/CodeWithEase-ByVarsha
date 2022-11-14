package javaCode.String;

import java.util.HashSet;
import java.util.Set;

/**
 * @Problem: Longest Substring without repeating characters - Leetcode(3)
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */


public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "pwwkew";
        int ans = lengthOfLongestSubstring(s);
        System.out.println(ans);

        int ans1 = lengthOfLongestSubstringSlidingWindow(s);
        System.out.println(ans1);

        int ans2 = lengthOfLongestSubstringOptimisedSlidingWindow(s);
        System.out.println(ans2);
    }

    /*
        To generate all substrings of a string, loop from the start till the end index of the string.
        Outer loop to traverse the String:  i
        Iner loop for i+1 to last index.
        We can use a hashset to check whether the substring contains unique characters or not.
        If its not unique then pass to next string and check its length and find maximum.

        TC - O(n^3)
        SC - O(n) or O(l)  l = length of substring.

     */
    public static int lengthOfLongestSubstring(String s) {

        int n = s.length();

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (checkRepetition(s, i, j)) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }

        return res;
    }

    private static boolean checkRepetition(String s, int start, int end) {
        int[] chars = new int[128];
        HashSet<Character> hs = new HashSet<>();
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            if (hs.contains(c)) {
                return false;
            } else {
                hs.add(c);
            }
        }
        return true;
    }

    /*
        Sliding Window :
        We will loop from start to end and keep record for a visited array.
        Inner loop from start + 1 to end – 1 and check whether the current character has already been visited.
        If visited we will break from the loop and move to the next window.
        If not vidited, we will continue and maximize the length.
        Then we will return the max length.

        TC - O(n^2)
        SC - O(n) or O(l)  l = length of substring.
     */

    public static int lengthOfLongestSubstringSlidingWindow(String str) {
        int n = str.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[256];
            for (int j = i; j < n; j++) {
                if (visited[str.charAt(j)] == true)
                    break;
                else {
                    res = Math.max(res, j - i + 1);
                    visited[str.charAt(j)] = true;
                }
            }
            visited[str.charAt(i)] = false;
        }
        return res;
    }


    /*
        Optimised Sliding Window:
        TC - O(n)
        SC - O(n) or O(l)  l = length of substring.
     */

    public static int lengthOfLongestSubstringOptimisedSlidingWindow(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int start = 0;
        int end = 0;
        int max = 0;
        Set<Character> uniqueCharacters = new HashSet<>();
        while (end < s.length()) {
            if (uniqueCharacters.add(s.charAt(end))) {
                end++;
                max = Math.max(max, uniqueCharacters.size());
            } else {
                uniqueCharacters.remove(s.charAt(start));
                start++;
            }
        }
        return max;
    }


}
