package SearchingSorting;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearchIterative(arr, 8));
        System.out.println(binarySearchRecursive(arr, 7, 0, arr.length - 1));
    }

    /*
        The binary search algorithm always works on a sorted list.
        After sorting the middle element is checked whether it's the desired value or not.
            If the desired value is equal to the middle index’s value, then the index is the answer.
            If the desired value is lower than the middle index’s value, then we check the left side of the array, i.e  0th position to mid - 1.
            If the desired value is greater than the middle index’s value, then we check the right side of the array, i.e  mid + 1 position to last.
        The process is then repeated on shorted lists until the desired value is found.
        The worst case is when we have to keep reducing the search space till it has only one element.
        The worst-case time complexity of Binary search is O(logn).
     */


    public static int binarySearchIterative(int arr[], int x) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] < x)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static int binarySearchRecursive(int arr[], int x, int low, int high) {

        if (high >= low) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x)
                return mid;
            if (arr[mid] > x)
                return binarySearchRecursive(arr, x, low, mid - 1);
            return binarySearchRecursive(arr, x, mid + 1, high);
        }

        return -1;
    }
}
