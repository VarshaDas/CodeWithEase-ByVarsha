package Arrays;

public class MaxSubarraySum {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, -2, 5};
        long max = maxSubarraySum(arr, arr.length);
        System.out.println(max);
    }
    /*
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
