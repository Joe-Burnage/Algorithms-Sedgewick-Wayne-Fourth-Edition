package Chapter1.Section1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise38
{
  public static int bruteForceSearch(int key, int[] a)
  {
    for (int i = 0; i < a.length; i++)
      if (a[i] == key) return i;
    return -1;
  }

  public static int binarySearch(int key, int[] a)
  {
    return binarySearch(key, a, 0, a.length - 1, 0);
  }

  public static int binarySearch(int key, int[] a, int lo, int hi, int depth)
  {
    if (lo > hi) return -1;
    int mid = lo + (hi - lo) / 2;
    if (key < a[mid]) return binarySearch(key, a, lo, mid - 1, depth + 1);
    else if (key > a[mid]) return binarySearch(key, a, mid + 1, hi, depth + 1);
    else return mid;
  }

  public static void main(String[] args)
  {
    int[] whitelist = new In(args[0]).readAllInts();
    Arrays.sort(whitelist);
    while (StdIn.hasNextLine())
    {
      String line = StdIn.readLine();
      if (line.isEmpty()) break;
      int key = Integer.parseInt(line);
      final long startTime1 = System.nanoTime();
      int result1 = binarySearch(key, whitelist);
      final long endTime1 = System.nanoTime();

      final long startTime2 = System.nanoTime();
      int result2 = bruteForceSearch(key, whitelist);
      final long endTime2 = System.nanoTime();

      StdOut.printf("""
              Binary Search:
              Output: %d
              Time:   %.6fs

              Brute Force Search:
              Output: %d
              Time:   %.6fs
              """,
          result1, (double) (endTime1 - startTime1) / 1000000000.0,
          result2, (double) (endTime2 - startTime2) / 1000000000.0);
    }
  }
}
