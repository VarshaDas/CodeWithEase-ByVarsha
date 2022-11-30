package Arrays;

/**
 * Given an array Arr[] of N integers. Find the contiguous sub-array(containing at least one number)
 * which has the maximum sum and return its sum.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * N = 5
 * Arr[] = {1,2,3,-2,5}
 * Output:
 * 9
 * Explanation:
 * Max subarray sum is 9
 * of elements (1, 2, 3, -2, 5) which
 * is a contiguous subarray.
 * Example 2:
 * <p>
 * Input:
 * N = 4
 * Arr[] = {-1,-2,-3,-4}
 * Output:
 * -1
 * Explanation:
 * Max subarray sum is -1
 * of element (-1)
 * <p>
 * Your Task:
 * You don't need to read input or print anything. The task is to complete the function maxSubarraySum() which takes Arr[] and N as input parameters and returns the sum of subarray with maximum sum.
 * <p>
 * <p>
 * Expected Time Complexity: O(N)
 * Expected Auxiliary Space: O(1)
 */
public class MaxSubarraySum {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, -2, 5};
        long max = maxSubarraySum(arr, arr.length);
        System.out.println(max);
    }

    /*
        Kadane’s Algorithm is an iterative dynamic programming algorithm.
        It calculates the maximum sum sub array ending at a particular position by using the maximum sum subarray ending at the previous position.

        We will consider two elements, one will store the maximum end of the subarray
        The other one will store the maximum sum.
        We will traverse the array.
        Each time we get a positive sum, we will compare it with max and update the max.

        TC - O(n)
        SC - O(1)
    */
    public static long maxSubarraySum(int arr[], int n) {
        // Your code here
        long max = arr[0], sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
            if (sum > max)
                max = sum;
            if (sum < 0)
                sum = 0;
        }
        return max;

    }
}
