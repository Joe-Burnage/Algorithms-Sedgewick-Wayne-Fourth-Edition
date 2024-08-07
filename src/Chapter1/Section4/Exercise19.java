package Chapter1.Section4;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/*
Local minimum of a matrix. Given an N-by-N array a[] of N 2 distinct integers,
design an algorithm that runs in time proportional to N to find a local minimum:
a pair of indices i and j such that a[i][j] < a[i+1][j], a[i][j] < a[i][j+1],
a[i][j] < a[i-1][j], and a[i][j] < a[i][j-1]. The running time of your program
should be proportional to N in the worst case.
*/
public class Exercise19
{
  public static void main()
  {
    int[][] matrix = {
        { 3, 2, 1, 7 },
        { 9, 11, 5, 4 },
        { 6, 0, 13, 17 },
        { 7, 21, 14, 15 } };
    StdOut.println(Arrays.toString(localMinMatrix(matrix)));

    int[][] matrix2 = {
        { 1, 2, 3 },
        { 4, 6, 7 },
        { 0, 0, 0 } };
    StdOut.println(Arrays.toString(localMinMatrix(matrix2)));

    int[][] matrix3 = {
        { 3, 2 },
        { 0, 1 } };
    StdOut.println(Arrays.toString(localMinMatrix(matrix3)));

    int[][] matrix4 = { { 0 } };
    StdOut.println(Arrays.toString(localMinMatrix(matrix4)));
  }


  public static boolean checkLocalMinMatrix(int[][] matrix, int row, int col)
  {
    //Check if a given cell is a local min
    boolean minRow = row == 0;
    boolean maxRow = row == matrix.length - 1;
    boolean minCol = col == 0;
    boolean maxCol = col == matrix.length - 1;
    if (!minRow) if (matrix[row][col] > matrix[row - 1][col]) return false;
    if (!maxRow) if (matrix[row][col] > matrix[row + 1][col]) return false;
    if (!minCol) if (matrix[row][col] > matrix[row][col - 1]) return false;
    if (!maxCol) return matrix[row][col] <= matrix[row][col + 1];
    return true;
  }

  public static int[] localMinMatrix(int[][] matrix)
  {
    int left_row  = 0;
    int right_row = matrix.length - 1;
    int left_col  = 0;
    int right_col = matrix.length - 1;
    while (true)
    {
      int mid_row = (left_row + right_row) / 2;
      int mid_col = (left_col + right_col) / 2;
      if (checkLocalMinMatrix(matrix, mid_row, mid_col)) return new int[] { mid_row, mid_col };

      if (mid_row != 0 &&
          matrix[mid_row][mid_col] > matrix[mid_row - 1][mid_col])
        right_row = mid_row - 1;

      else if (mid_row != matrix.length - 1 &&
          matrix[mid_row][mid_col] > matrix[mid_row + 1][mid_col])
        left_row = mid_row + 1;

      else if (mid_col != 0 &&
          matrix[mid_row][mid_col] > matrix[mid_row][mid_col - 1])
        right_col = mid_col - 1;

      else left_col = mid_col + 1;
    }
  }
}
