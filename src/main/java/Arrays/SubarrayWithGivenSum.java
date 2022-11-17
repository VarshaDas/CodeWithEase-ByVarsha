package Arrays;

/**
 * @Problem: Sub array with given sum - GfG
 *
 * Given an unsorted array A of size N that contains only non-negative integers,
 * find a continuous sub-array which adds to a given number S.
 * In case of multiple subarrays, return the subarray which comes first on moving from left to right.
 *
 * Example 1:
 *
 * Input:
 * N = 5, S = 12
 * A[] = {1,2,3,7,5}
 * Output: 2 4
 * Explanation: The sum of elements
 * from 2nd position to 4th position
 * is 12.
 *
 *
 * Example 2:
 *
 * Input:
 * N = 10, S = 15
 * A[] = {1,2,3,4,5,6,7,8,9,10}
 * Output: 1 5
 * Explanation: The sum of elements
 * from 1st position to 5th position
 * is 15.
 *
 */


import java.util.ArrayList;

public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(subarraySum(arr, arr.length, 0));
        System.out.println(subarraySumOptimal(arr, arr.length, 0));
    }

    /*
        By Using Brute force:
          TC - O(n^2)
     */
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        // Your code here
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sum = arr[i];
            for (int j = i + 1; j < n; j++) {
                if (sum == s) {
                    result.add(i);
                    result.add(j - 1);
                    return result;
                }
                if (sum > s) {
                    break;
                }
                sum = sum + arr[j];
            }
        }
        result.add(-1);
        return result;
    }


    /*
        By Applying Sliding Window Technique:
           take two variables: current_sum (target) and start_index (j)
           If target < req_sum then add the element with the target
           If target = req_sum  return the starting and ending position of the window
           If the target > req_sum, then target = target - ith element and shift the window.
           If none is satisfying return -1.

         TC - O(n)

     */
    static ArrayList<Integer> subarraySumOptimal(int[] arr, int n, int s) {
        // Your code here
        ArrayList<Integer> result = new ArrayList<>();
        int j = 0, i = 0, target = 0;
        while (j < n) {
            target = target + arr[j];
            while (target > s) {
                target -= arr[i];
                i++;
            }
            if (s == target && i <= j) {
                result.add(i);
                result.add(j);
                return result;
            }
            j++;
        }
        result.add(-1);
        return result;
    }

}
