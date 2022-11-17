package javaCode.Arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.
    Note that it is the kth smallest element in the sorted order, not the kth distinct element.

    You must find a solution with a memory complexity better than O(n2).

    Example 1:

    Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
    Output: 13
    Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
    Example 2:

    Input: matrix = [[-5]], k = 1
    Output: -5
    

    Constraints:
    n == matrix.length == matrix[i].length
    1 <= n <= 300
    -109 <= matrix[i][j] <= 109
    All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
    1 <= k <= n2
 */


public class KthSmallestElementInSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        System.out.println(kthSmallest(matrix, 8));
        System.out.println(kthSmallestBinarySearch(matrix, 8));

    }

    /*
        Brute force approach: 
        We will traverse the matrix and store the elements in a 1-d array/ list.
        Then we will sort the array and return the element at the Kth position.

        TC - O(n^2) because of traversal
        SC - O(n)
     */



    public static int kthSmallest(int[][] matrix, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                arr.add(matrix[i][j]);
            }
        }
        Collections.sort(arr);
        return arr.get(k-1);      

    }


    /*
        We will use Binary Search with low = matrix[0][0] and high = matrix[n-1][n-1].
        Then find mid of the low and the high.
        We will count all the numbers smaller than or equal to mid in the matrix. 
        If the count is less than k, we will update low = mid+1 to search in the higher part of the matrix
        Else if the count is greater than or equal to k we will update high = mid to search in the lower part of the matrix.
        At some point low and high become equal in values and the loop terminates.
        low contains the value of k-th smallest element.

        TC - O(n) 
        SC - O(1)
     */

    public static int kthSmallestBinarySearch(int[][] matrix, int k) {
        int low = matrix[0][0];
        int high = matrix[matrix.length - 1][matrix[0].length - 1];
        while(low < high) {
            int mid = low + (high - low) / 2;
            int count = 0,  j = matrix[0].length - 1;
            for(int i = 0; i < matrix.length; i++) {
                while(j >= 0 && matrix[i][j] > mid){
                    j--;
                } 
                count += (j + 1);
            }
            if(count < k) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
            
        }
        return low;
    }

}
