package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Problem: Alternate positive and negative numbers - GFG
 * <p>
 * Given an unsorted array Arr of N positive and negative numbers.
 * Your task is to create an array of alternate positive and negative numbers without changing the
 * relative order of positive and negative numbers.
 * Note: Array should start with a positive number.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * N = 9
 * Arr[] = {9, 4, -2, -1, 5, 0, -5, -3, 2}
 * Output:
 * 9 -2 4 -1 5 -5 0 -3 2
 * Explanation : Positive elements : 9,4,5,0,2
 * Negative elements : -2,-1,-5,-3
 * As we need to maintain the relative order of
 * postive elements and negative elements we will pick
 * each element from the positive and negative and will
 * store them. If any of the positive and negative numbers
 * are completed. we will continue with the remaining signed
 * elements.The output is 9,-2,4,-1,5,-5,0,-3,2.
 * <p>
 * Example 2:
 * <p>
 * Input:
 * N = 10
 * Arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
 * Output:
 * 5 -5 2 -2 4 -8 7 1 8 0
 * Explanation : Positive elements : 5,2,4,7,1,8,0
 * Negative elements : -5,-2,-8
 * As we need to maintain the relative order of
 * postive elements and negative elements we will pick
 * each element from the positive and negative and will
 * store them. If any of the positive and negative numbers
 * are completed. we will continue with the remaining signed
 * elements.The output is 5,-5,2,-2,4,-8,7,1,8,0.
 * Your Task:
 * <p>
 * You don't need to read input or print anything.
 * Your task is to complete the function rearrange() which takes the array of integers arr[] and n as parameters.
 * You need to modify the array itself.
 * Expected Time Complexity: O(N)
 * Expected Auxiliary Space: O(N)
 */
public class AlternatePositiveAndNegativeNumbers {
    public static void main(String[] args) {
        int arr[] = {9, 4, -2, -1, 5, 0, -5, -3, 2};
        alterPosAndNeg(arr, arr.length);
        System.out.println(Arrays.toString(arr));

    }

    /*
           We can take 2 different Data Structure to store the positive and negative numbers.
           Then we can traverse the array and put one by one from the above one by one and modify the array.

           TC - O(n)
           SC - O(n) due to extra data structure.
     */

    private static void alterPosAndNeg(int[] arr, int length) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            if (arr[i] >= 0) {
                pos.add(arr[i]);
            } else
                neg.add(arr[i]);
        }
        int i = 0, j = 0, k = 0;
        while (i < neg.size() && j < pos.size()) {
            arr[k++] = pos.get(j++);
            arr[k++] = neg.get(i++);
        }
        while (j < pos.size()) {
            arr[k++] = pos.get(j++);
        }
        while (i < neg.size()) {
            arr[k++] = neg.get(i++);
        }
    }
}
