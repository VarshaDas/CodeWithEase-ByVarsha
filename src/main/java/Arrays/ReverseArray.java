package Arrays;

/**
 *  Given an array A of size N, print the reverse of it.
 *
 * Example:
 *
 * Input:
 * 1
 * 4
 * 1 2 3 4
 * Output:
 * 4 3 2 1
 * Input:
 * First line contains an integer denoting the test cases 'T'. T testcases follow. Each testcase contains two lines of input. First line contains N the size of the array A. The second line contains the elements of the array.
 *
 * Output:
 * For each testcase, in a new line, print the array in reverse order.
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <=100
 * 0 <= Ai <= 100
 */

import java.util.*;


class ReverseArray {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            int size = sc.nextInt();
            int[] arr = new int[size];
            for(int i=0;i<size;i++){
                arr[i] = sc.nextInt();
            }
            reverseArray(arr,0, size-1);
            for(int i = 0; i < size; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            t--;
        }

    }
    public static int[] reverseArray(int[] arr, int i, int j){

        if(i<j){
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            reverseArray(arr, ++i, --j);
        }
        return arr;
    }
}