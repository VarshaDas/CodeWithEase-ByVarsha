package javaCode.Arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of N integers, and an integer K, find the number of pairs of elements in the array whose sum is equal to K.
 *
 *
 * Example 1:
 *
 * Input:
 * N = 4, K = 6
 * arr[] = {1, 5, 7, 1}
 * Output: 2
 * Explanation:
 * arr[0] + arr[1] = 1 + 5 = 6
 * and arr[1] + arr[3] = 5 + 1 = 6.
 *
 * Example 2:
 *
 * Input:
 * N = 4, K = 2
 * arr[] = {1, 1, 1, 1}
 * Output: 6
 * Explanation:
 * Each 1 will produce sum 2 with any 1.
 *
 * Your Task:
 * You don't need to read input or print anything. Your task is to complete the function getPairsCount() which takes arr[], n and k as input parameters and returns the number of pairs that have sum K.
 *
 *
 * Expected Time Complexity: O(N)
 * Expected Auxiliary Space: O(N)
 *
 * Constraints:
 * 1 <= N <= 105
 * 1 <= K <= 108
 * 1 <= Arr[i] <= 106
 *
 */

public class PairsWithGivenSum {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1};
        System.out.println(getPairsCount(nums, nums.length, 2));
        System.out.println(getPairsCountOptimal(nums, nums.length,2));
    }

    /*
        Brute Force Approach:
        By using two loops we can check if the sum of the elements is equal to the given sum and increase the count.

        TC - O(n^2)
        SC - O(1)
     */
    public static int getPairsCount(int[] arr, int n, int k) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (arr[i]+arr[j] == k){
                    count++;
                }
            }
        }


        return count;
    }


    /*
           Hashing Method:
           By using a hashmap, we can visit each of the element and check the sum as targetSum - arr[i]
           If its true then we will increase the count and put that element in the hashmap. and continue till last of the array.
           The count will be increase as count = count + V[element].

           TC - O(n)
           SC - O(n)
     */
    public static int getPairsCountOptimal(int[] arr, int n, int k) {
        int count = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int target = k - arr[i];
            if(hm.containsKey(target)){
                count = count + hm.get(target);
            }
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }

        return count;
    }
}
