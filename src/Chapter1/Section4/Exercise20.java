package Chapter1.Section4;

import edu.princeton.cs.algs4.StdOut;
/*
Bitonic search. An array is bitonic if it comprises an increasing sequence
of integers followed immediately by a decreasing sequence of integers. Write a program
that, given a bitonic array of N distinct int values, determines whether a given integer
is in the array. Your program should use ~3lg N compares in the worst case.
*/
public class Exercise20
{
  public static void main()
  {
    int[]  bitonicArray = { 1, 2, 3, 4, 5, 6, 7, 100, 76, 54, 32, 13, 10 };
    int    int1         = 100;
    String check1       = bitonicSearch(bitonicArray, int1) ? "Found" : "Not found";
    int    int2         = 10;
    String check2       = bitonicSearch(bitonicArray, int2) ? "Found" : "Not found";
    int    int3         = 11;
    String check3       = bitonicSearch(bitonicArray, int3) ? "Found" : "Not found";
    StdOut.printf("""
                                             Peak vvv
                      Array: 1, 2, 3, 4, 5, 6, 7, 100, 76, 54, 32, 13, 10
                      Search for: %3d - %s
                      Search for: %3d - %s
                      Search for: %3d - %s
                      """, int1, check1, int2, check2, int3, check3);
  }

  public static boolean bitonicSearch(int[] ints, int key)
  {
    int peak = bitonicPeak(ints);
    return (binarySearch(ints, key, 0, peak) || reverseBinarySearch(ints, key, peak, ints.length - 1));
  }

  public static boolean binarySearch(int[] ints, int key, int left, int right)
  {
    while (left <= right)
    {
      int mid = (left + right) / 2;
      if (ints[mid] == key) return true;
      if (ints[mid] < key) left = mid + 1;
      else right = mid - 1;
    }
    return false;
  }
  public static boolean reverseBinarySearch(int[] ints, int key, int left, int right)
  {
    while (left <= right)
    {
      int mid = (left + right) / 2;
      if (ints[mid] == key) return true;
      if (ints[mid] > key) left = mid + 1;
      else right = mid - 1;
    }
    return false;
  }

  public static int bitonicPeak(int[] ints)
  {
    int left  = 0;
    int right = ints.length;
    while (true)
    {
      int mid = (left + right) / 2;
      if (ints[mid - 1] < ints[mid] && ints[mid] > ints[mid + 1]) return mid;
      if (ints[mid - 1] < ints[mid]) left = mid + 1;
      else right = mid - 1;
    }
  }
}
