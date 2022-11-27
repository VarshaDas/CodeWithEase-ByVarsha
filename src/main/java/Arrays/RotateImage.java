package Arrays;

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * <p>
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 * Example 2:
 * <p>
 * <p>
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 */


public class RotateImage {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] arr1 = rotateBruteForce(arr);
        display2D(arr1);
        System.out.println();
        rotate(arr);
        display2D(arr);

    }

    /*
            We will create another matrix of n*n,
            and then take the first row of the matrix and put it in the last column of the matrix,
            take the second row of the matrix, and put it in the second last column of the matrix and till last.

            TC - O(n^2)
            SC - O(n^2)

     */
    public static int[][] rotateBruteForce(int[][] matrix) {

        int rotated[][] = new int[matrix.length][matrix.length];
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - i - 1] = matrix[i][j];
            }
        }
        return rotated;
    }

    /*
         2nd Approach:
         We will first transpose the matrix. and then we wll reverse all rows in-place.
         The transpose of a matrix is found by interchanging its rows into columns or columns into rows.
         The transpose of a matrix can be computed by assigning [i][j] element in the transpose matrix equal to the [j][i] in the original matrix.
        Suppose this is the matrix:
        1 2 3
        4 5 6
        7 8 9
        Then transpose of the above matrix is:
        1 4 7
        2 5 8
        3 6 9

         TC - O(n^2)
         SC - O(1)
     */

    public static void rotate(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }

    }
    public static void display2D(int[][] arr){
        for (int[] x : arr) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }

}
