package javaCode.Arrays;

import java.util.Arrays;

public class MaxandMinInArray {
    public static void main(String[] args) {
        int[] arr = {2, 1, -4, -15, 3, 5, 89, -78};
        findMaxandMin(arr);
        findMaxandMinOptimal(arr);

        //Recursion
        int max = maxRec(arr, arr.length);
        System.out.println("Maximum using Recursion: " + max);
        int min = minRec(arr, arr.length);
        System.out.println("Minimum using Recursion: " + min);
    }

    /*
     By using sorting method:
     T.C. - O( nlogn )
   */
    public static void findMaxandMin(int[] arr) {
        Arrays.sort(arr);
        System.out.println("Max Ele = " + arr[arr.length - 1] + " Min Ele = " + arr[0]);
    }

    /*
    Optimised:
        By traversing the array and comparing the elements.
        Taking two pointers (maxi and mini), pointing to the 0th element.
        We will traverse the array and check whether the element is greater or smaller.
        max = min = arr[0]
        for loop: 0 - arr length
            check if the value at that position is smaller or greater
                assign the respective values.

        TC - O(n)
     */
    public static void findMaxandMinOptimal(int[] arr) {
        int maxi = arr[0];
        int mini = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < mini) {
                mini = arr[i];
            } else {
                maxi = arr[i];
            }
        }
        System.out.println("Max Ele = " + maxi + " Min Ele = " + mini);

    }

     /*
            2, 1, -4, 15, 3
            first we will find the maximum element from the 1st index to last index of the array.
                recursive call - max =   recursiveMax ( arr[1] to arr[pos-1])

            then we will compare the 0th value with the above maximum.
                if arr[pos] > max : then  arr[pos] is the maximum value of the array
                else: max is the maximum value of the array.


            similarly for minimum element:
                if arr[pos] < max : then  arr[pos] is the minimum value of the array
                else: max is the minimum value of the array.

             TC - O(n)
     */

    public static int maxRec(int[] A, int n) {
        if (n == 1)
            return A[0];

        return Math.max(A[n - 1], maxRec(A, n - 1));
    }

    public static int minRec(int[] A, int n) {

        if (n == 1)
            return A[0];

        return Math.min(A[n - 1], minRec(A, n - 1));
    }
}
