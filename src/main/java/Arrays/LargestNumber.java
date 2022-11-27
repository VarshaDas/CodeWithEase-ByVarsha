package Arrays;

/**
 * Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
 * <p>
 * Since the result may be very large, so you need to return a string instead of an integer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [10,2]
 * Output: "210"
 * Example 2:
 * <p>
 * Input: nums = [3,30,34,5,9]
 * Output: "9534330"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 */

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public static void main(String[] args) {
        int arr[] = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(arr));
    }
/*
    We will create a String array having the values.
    Then we will sort the Array by using a comparator which will check whether AB is greater than BA (A and B are the elements of array
    and it will be concatenated )
    As the sorting will be performed in descending order. We will use a string builder and append the values of the array after sorting.
    The result will be our output.

    TC - O(nlogn) due to sorting.
 */
    public static String largestNumber(int[] nums) {
        if (nums.length == 0)
            return "";
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
//        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        StringBuilder stringBuilder = new StringBuilder();
        for (String a : arr) {
            stringBuilder.append(a);
        }
        return stringBuilder.toString();
    }

}
