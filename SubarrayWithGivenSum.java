import java.util.ArrayList;

public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(subarraySum(arr, arr.length, 0));
        System.out.println(subarraySumOptimal(arr, arr.length, 0));
    }

    /*
        By Using Brute force:
          TC - O(n^2)
     */
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        // Your code here
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sum = arr[i];
            for (int j = i + 1; j < n; j++) {
                if (sum == s) {
                    result.add(i);
                    result.add(j - 1);
                    return result;
                }
                if (sum > s) {
                    break;
                }
                sum = sum + arr[j];
            }
        }
        result.add(-1);
        return result;
    }


    /*
        By Applying Sliding Window Technique:
           take two variables: current_sum (target) and start_index (j)
           If target < req_sum then add the element with the target
           If target = req_sum  return the starting and ending position of the window
           If the target > req_sum, then target = target - ith element and shift the window.
           If none is satisfying return -1.

         TC - O(n)

     */
    static ArrayList<Integer> subarraySumOptimal(int[] arr, int n, int s) {
        // Your code here
        ArrayList<Integer> result = new ArrayList<>();
        int j = 0, i = 0, target = 0;
        while (j < n) {
            target = target + arr[j];
            while (target > s) {
                target -= arr[i];
                i++;
            }
            if (s == target && i <= j) {
                result.add(i);
                result.add(j);
                return result;
            }
            j++;
        }
        result.add(-1);
        return result;
    }

}
