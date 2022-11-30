package Arrays;

import java.util.Arrays;

/**
 * Given an array arr[] denoting heights of N towers and a positive integer K,
 * you have to modify the height of each tower either by increasing or decreasing them by K only once.
 * Find out what could be the possible minimum difference of the height of shortest and
 * longest towers after you have modified each tower.
 * Note: Assume that height of the tower can be negative.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * K = 2, N = 4
 * Arr[] = {1, 5, 8, 10}
 * Output:
 * 5
 * Explanation:
 * The array can be modified as
 * {3, 3, 6, 8}. The difference between
 * the largest and the smallest is 8-3 = 5.
 * Example 2:
 * <p>
 * Input:
 * K = 3, N = 5
 * Arr[] = {3, 9, 12, 16, 20}
 * Output:
 * 11
 * Explanation:
 * The array can be modified as
 * {6, 12, 9, 13, 17}. The difference between
 * the largest and the smallest is 17-6 = 11.
 * <p>
 * Your Task:
 * You don't need to read input or print anything. Your task is to complete the function getMinDiff() which takes the arr[], n and k as input parameters and returns an integer denoting the minimum difference.
 * <p>
 * <p>
 * Expected Time Complexity: O(N*logN)
 * Expected Auxiliary Space: O(N)
 * <p>
 * Constraints
 * 1 ≤ K ≤ 104
 * 1 ≤ N ≤ 105
 * 1 ≤ Arr[i] ≤ 105
 */


public class MinimizeHeight {
    public static void main(String[] args) {
        int Arr[] = {2, 6, 3, 4, 7, 2, 10, 3, 2, 1};
        int minDiff = getMinDiff(Arr, 10, 5);
        System.out.println(minDiff);
    }

    /*
          arr =  2, 6, 3, 4, 7, 2, 10, 3, 2, 1
          After Sort: 1, 2, 2, 2, 3, 3, 4, 6, 7, 10
          After sorting we can say that the maximum difference between two towers is the height of
          the highest tower and the lowest tower.
          Loop: i to n
              min checks minimum value for current i'th position value.
              max checks maximum value for previous i'th position value.

            Then we will find the minimum from height and max-min difference and store it in height.

            TC - O(nlogn)
            SC - O(1)
     */


    public static int getMinDiff(int[] arr, int n, int k) {
        // code here
        Arrays.sort(arr);
        int min, max;

        int minimizedHeight = arr[n - 1] - arr[0];
        for (int i = 1; i < n; i++) {

            max = Math.max(arr[i - 1] + k, arr[n - 1] - k);
            min = Math.min(arr[0] + k, arr[i] - k);
            minimizedHeight = Math.min(minimizedHeight, max - min);

        }
        return minimizedHeight;
    }
}
