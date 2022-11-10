public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {2, 1, -4, -15, 3, 5, 89, -78};
        BubbleSort1(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static int[] BubbleSort1(int[] arr){
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
        return arr;
    }
}
