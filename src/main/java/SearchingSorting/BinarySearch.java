package SearchingSorting;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearchIterative(arr, 8));
        System.out.println(binarySearchRecursive(arr, 7, 0, arr.length - 1));
    }

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
