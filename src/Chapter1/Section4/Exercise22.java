package Chapter1.Section4;

import edu.princeton.cs.algs4.StdOut;

/*
Binary search with only addition and subtraction. [Mihai Patrascu] Write a
program that, given an array of N distinct int values in ascending order, determines
whether a given integer is in the array. You may use only additions and subtractions
and a constant amount of extra memory. The running time of your program should be
proportional to log N in the worst case.
*/
public class Exercise22
{
  public static void main()
  {
    int[] array = {1,4,6,7,8,9,10};
    StdOut.println(binarySearchAddSubtract(array, 10));
  }

  public static void fibonacciBefore(int[] f)
  {
    f[0] = f[1] - f[0];
    f[1] -= f[0];
  }

  public static int binarySearchAddSubtract(int[] ints, int key)
  {
    int[] f = {0, 1};
    int left = 0;
    int right = 1;
    while (f[1] + f[0] < ints.length) {
      int temp = f[0];
      f[0] = f[1];
      f[1] += temp;
    }
    while (left < right)
    {
      int mid = left + f[1];
      fibonacciBefore(f);
      if (ints[mid] == key) return mid;
      if (ints[mid] < key) left = mid + 1;
      else right = mid - 1;
    }
    return -1;
  }
}
