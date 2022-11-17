package javaCode.Arrays;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must be unique, and you may return the result in any order.
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Explanation: [4,9] is also accepted.
 *
 *
 * Constraints:
 *
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] arr = intersection(nums1,nums2);
        int[] ints = intersectionTwoPointers(nums1, nums2);
        for (int a:ints) {
            System.out.print(a+" ");
        }
    }

    /*
        Hashning method:
            We will take two hashsets and put the elements of the first array in the hashset.
            Then we will compare the elements of the second array with the first one. if the first set contains any
            element from the second array we will put that in the second hashset. This will be our intersection.

            After that we will put the elements of the second hashset in an array and return it.

            TC - O(n+m)
            SC - O(n+m)
     */

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hs = new HashSet<>();
        Set<Integer> intersec = new HashSet<>();
        for (Integer a: nums1) {
            hs.add(a);
        }
        for (Integer b:nums2) {
            if(hs.contains(b)){
                intersec.add(b);
            }
        }
        int i = 0;
        int[] arr = new int[intersec.size()];
        for (Integer c:intersec) {
            arr[i++] = c;
        }
        return arr;
    }

    /*
        Two Pointers Method:
            We will first sort the arrays. Then we will use two pointers to traverse the array and check whether the
            elements are equal or not.
            If the elements are equal then its an intersection and we will store that in set.

            TC - O(nlogn)
            SC- O(n)
     */
    public static int[] intersectionTwoPointers(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[set.size()];
        int k = 0;
        for (Integer num : set) {
            result[k++] = num;
        }
        return result;
    }
}

