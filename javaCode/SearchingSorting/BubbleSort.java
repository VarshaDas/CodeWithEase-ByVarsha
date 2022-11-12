/**
 * Bubble Sort works by iterating through the elements of the array and
 * doing pairwise swap of adjacent elements that are out of order.
 *
 *
 * TC - O(n^2),  Because of nested loops.
 * SC - O(1)
 */
package javaCode.SearchingSorting;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {2, 1, -4, -15, 3, 5, 89, -78};
        BubbleSort1(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static int[] BubbleSort1(int[] arr){
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
        return arr;
    }
}
