public class Sort012 {
    public static void main(String[] args) {
        int[] arr = {0,0,2,0,1,0,2,0,1,1,1,2,1,2};
        sort012(arr, arr.length);
        for (int a: arr) {
            System.out.print(a+" ");
        }
    }

    /*
        Approach using loops: Counting Sort
            We will count the zeroes, ones, twos.
            Then we will insert in the array one by one.

            TC - O(n)
     */
    public static void sort012(int a[], int n)
    {
        // code here
        int zero = 0, one = 0, two =0;
        for (int i=0;i<a.length;i++){
            if(a[i]==0)
                zero++;
            if (a[i]==1)
                one++;
            if (a[i]==2)
                two++;
        }

        for (int i = 0; i < n; i++) {
            if(zero>0){
                a[i] = 0;
                zero--;
            } else if (one > 0) {
                a[i] = 1;
                one--;
            }
            else {
                a[i] = 2;
                two--;
            }
        }

    }




}
