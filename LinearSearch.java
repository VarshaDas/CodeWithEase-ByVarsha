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