import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {3, 2, 4};
        int arr1[] = twoSum(arr, 6);
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
    }

    /*
   Brute Force:
   outer loop: points to each element,
   inner loop: traverse rest of the array and check sum of two element = target.

   TC - O(n^2)
    */
    public int[] twoSumBruteForce(int[] nums, int target) {
        int arr[] = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }
        return arr;
    }
    /*
        By using hashmap:
            We will take a hashmap keeping note of the index position and the value.
            We will point to an element in the array and traverse the list.
            we will check whether the numbers are present in the map, target - ith value
            if present we will return the positions, ie. ith and index of counterpart.
            else we will store it in the hashmap and move the pointer to next index ie. i+1.

            TC - O(n)
            SC - O(n)
     */
    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> hm = new HashMap<>();
        int arr[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(target - nums[i])) {
                arr[0] = hm.get(target - nums[i]);
                arr[1] = i;
                return arr;
            }
            hm.put(nums[i], i);
        }
        return arr;
    }
}
