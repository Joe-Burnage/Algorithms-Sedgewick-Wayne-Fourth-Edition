package Chapter1.Section1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise22
{
  public static int rank(int key, int[] a)
  {
    return rank(key, a, 0, a.length - 1, 0);
  }

  public static int rank(int key, int[] a, int lo, int hi, int depth)
  {
    for (int i = 0; i < depth; i++)
    {
      StdOut.print(" ");
    }
    StdOut.printf("%d %d\n", lo, hi);
    if (lo > hi) return -1;
    int mid = lo + (hi - lo) / 2;
    if (key < a[mid]) return rank(key, a, lo, mid - 1, depth + 1);
    else if (key > a[mid]) return rank(key, a, mid + 1, hi, depth + 1);
    else return mid;
  }

  public static void main(String[] args)
  {
    int[] whitelist = new In(args[0]).readAllInts();
    Arrays.sort(whitelist);
    while (!StdIn.isEmpty())
    {
      int key = StdIn.readInt();
      if (rank(key, whitelist) < 0)
        StdOut.println(key);
    }
  }
}
