package javaCode.Arrays;

/**
 * @Problem: Longest Consecutive Sequence - Leetcode(128)
 *
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 * Example 1:
    Input: nums = [100,4,200,1,3,2]
    Output: 4
    Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

 *  Example 2:
    Input: nums = [0,3,7,2,5,8,4,6,0,1]
    Output: 9

 *  Constraints:
    0 <= nums.length <= 105
    -109 <= nums[i] <= 109

 */

import java.util.Arrays;
import java.util.HashSet;


public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        int[] arr = {10, 11, 12, 15, 13, 15, 18, 16, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(long_consecutive(arr));
        System.out.println(longestConsecutiveSort(arr));
        System.out.println(longestConsecutive(arr));
    }

    /*
    Taking max = 0.
    Traverse the array:
    Taking a variable (consecutive) stores the longest streak with the current element.
    Using linear search to find the next number if present.
    performing the same for consecutive elements greater than the current element.
    Update max if consecutive is greater.

    TC - O(n^3)
     */
    public static int long_consecutive(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i] - 1;
            int con = 1;

            while (search(nums, value) >= 0) {
                con = con + 1;
                value = value - 1;
            }

            value = nums[i] + 1;
            while (search(nums, value) >= 0) {
                con = con + 1;
                value = value + 1;
            }
            max = Math.max(max, con);
        }
        return max;

    }

    public static int search(int[] arr, int x) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }



    /*
        By using sorting:
        TC - O(nlogn)
     */

    public static int longestConsecutiveSort(int[] nums) {
        int max = 0, sub = 0;
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length) {
            sub = 1;
            while (i < nums.length - 1 && nums[i + 1] == nums[i] + 1) {
                sub += 1;
                i += 1;
            }
            if (sub == 1)
                i += 1;
            max = Math.max(max, sub);
        }
        return max;
    }
    /*
        By using HashSet:
        Create a hashset and add all the values in the set.
        Take a variable (max) to store the longest consecutive value.
        Traverse the array to check if nums[i]-1 is present in the set then nums[i] is not the starting element of that consecutive seq.
        If not exist, then it is the first element of its corresponding sequence.
        We will check for consecutive numbers greater than nums[i] in the hashset and keep on increasing sub.
        We will check if max > sub: if not then we will update the max.

        TC - O(n)
     */

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> hm = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hm.add(nums[i]);
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!hm.contains(nums[i] - 1)) {
                int sub = nums[i];
                while (hm.contains(sub)) {
                    sub++;
                }
                if (max < sub - nums[i]) {
                    max = sub - nums[i];
                }
            }
        }
        return max;
    }
}
