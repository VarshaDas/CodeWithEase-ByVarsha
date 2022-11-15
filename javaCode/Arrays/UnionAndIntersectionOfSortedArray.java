package javaCode.Arrays;

import java.util.ArrayList;
import java.util.HashSet;

public class UnionAndIntersectionOfSortedArray {
    public static void main(String[] args) {
        int arr1[] = {1, 2, 3, 4};
        int arr2[] = {1, 2, 3, 4, 5, 7};
        System.out.println(doUnion(arr1, arr1.length, arr2, arr2.length));
        System.out.println(findUnion(arr1, arr2));
    }

    /*
        Two Pointer Approach:
        We will take two pointers, and we will compare both the arrays
        we will put the smaller value in arraylist and increase the pointer by 1
        If both array value is same, then, we will put any array value in arraylist and increase both the pointers
        If we have any item left in any array, we will put all values of that array in new array

        TC- O(n + m)
        SC- O(n + m)

     */

    public static int findUnion(int[] arr1, int[] arr2) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            while ((i < arr1.length - 1) && (arr1[i] == arr1[i + 1])) {
                i++;
            }
            while ((j < arr2.length - 1) && (arr2[j] == arr2[j + 1])) {
                j++;
            }
            if (arr1[i] < arr2[j]) {
                arrayList.add(arr1[i++]);
            } else if (arr1[i] > arr2[j]) {
                arrayList.add(arr2[j++]);
            } else {
                arrayList.add(arr1[i]);
                i++;
                j++;
            }
        }
        while (i < arr1.length) {
            if ((i < arr1.length - 1) && (arr1[i] == arr1[i + 1])) {
                i++;
            } else {
                arrayList.add(arr1[i++]);
            }
        }
        while (j < arr2.length) {
            if ((j < arr2.length - 1) && (arr2[j] == arr2[j + 1])) {
                j++;
            } else {
                arrayList.add(arr2[j++]);
            }
        }


        return arrayList.size();
    }


    /*
        By Hashing:
        We will use a hash set.
        We will traverse both the arrays and store it in the hashset.
        As Hashset doesn't allow duplicates. So the size of the set will be our output.

        TC - O(n + m)
        SC - O(n+m)
     */
    public static int doUnion(int a[], int n, int b[], int m) {

        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hs.add(a[i]);
        }
        for (int i = 0; i < m; i++) {
            hs.add(b[i]);
        }
        return hs.size();
    }
}
