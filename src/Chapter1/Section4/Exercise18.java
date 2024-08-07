package Chapter1.Section4;

import edu.princeton.cs.algs4.StdOut;

/*
Local minimum of an array. Write a program that, given an array a[] of N
distinct integers, finds a local minimum: an index i such that
a[i-1] > a[i] < a[i+1]
Your program should use ~2lg N compares in the worst case.
*/
public class Exercise18
{
  public static void main()
  {
    int[] ints = { 50, 40, 30, 20, 10 };
    StdOut.println("Index of a local minimum in {50, 40, 30, 20, 10}: " + localMin(ints));
    int[] ints2 = { 50, 40, 30, 20, 100, 30, 20, 60, 132, 21, -1, 1, 64};
    StdOut.println("Index of a local minimum in { 50, 40, 30, 20, 100, 30, 20, 60, 132, 21, -1, 1, 64}: " + localMin(ints2));
  }

  public static int localMin(int[] ints)
  {
    //Handle arrays of size 2 or less
    if (ints.length < 2) return 0;
    if (ints.length == 2)
      if (ints[0] > ints[1]) return 1;
      else return 0;

    int left  = 0;
    int right = ints.length - 1;
    while (true)
    {
      //Go to the middle of the two reference points left and right.
      int mid = (left + right) / 2;
      //If we have reached one end of the array, return the index as it is a local min
      if (mid == 0 || mid == ints.length - 1) return mid;
      //If the mid-point is smaller than two adjacent entries, return index
      if (ints[mid] <= ints[mid - 1] && ints[mid] <= ints[mid + 1]) return mid;
      //If mid is larger than the entry to the right, move left index to mid + 1
      if (ints[mid] > ints[mid + 1]) left = mid + 1;
      //Otherwise mid is larger than entry to the left, and move right index to mid - 1
      else right = mid - 1;
    }
  }
}
