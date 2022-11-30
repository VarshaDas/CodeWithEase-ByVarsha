package Arrays;

/**
 * Given an integer array nums, return the length of the longest strictly increasing
 * subsequence
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Example 2:
 * <p>
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * Example 3:
 * <p>
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 */

import java.util.ArrayList;


public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 1};
        System.out.println(lengthOfLISNaive(nums));
        System.out.println(lengthOfLIS(nums));
    }

    /*
        Brute Force Approach:
        TC - O(n^2)
        SC - O(n)
     */
    public static int lengthOfLISNaive(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        int result = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    arr[i] = Math.max(arr[i], arr[j] + 1);
                }
            }
            result = Math.max(arr[i], result);
        }
        return result;
    }


    /*
        Binary Search Approach:

        We will use a list to put the elements.
        We will traverse the array:
        If list is empty then add the element in the list
        If nums[i] > last element in list then also we will add the element in the list
        If nums[i] < last element in list we will replace the element in the list which is the smallest but bigger than nums[i]
        Then return the list size.

        TC - O(nlogn)
        SC - O(n)
     */
    public static int lengthOfLIS(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int num : nums) {
            if (arr.size() == 0 || num > arr.get(arr.size() - 1)) {
                arr.add(num);
            } else {
                int i = 0;
                int j = arr.size() - 1;

                while (i < j) {
                    int mid = (i + j) / 2;
                    if (arr.get(mid) < num) {
                        i = mid + 1;
                    } else {
                        j = mid;
                    }
                }

                arr.set(j, num);
            }
        }

        return arr.size();
    }
}
