package SearchingSorting;

/**
 * Linear search also known as sequential search.
 * In this we go through the entire list and try to find a match for a single element.
 * If we find a match, then the address of the target element is returned.
 *
 * TC - O(n)
 * SC - O(n)
 */

class LinearSearch {

    public static void main(String args[]) {
        int arr[] = {100, 4, 200, 1, 3, 2};
        int result = search(arr, 200);

        if (result != -1)
            System.out.print("Element is at index "+result);
        else
            System.out.print("Not found");

    }

    public static int search(int arr[], int x) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }

}