package Chapter1.Section1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
/*
Add to the BinarySearch test client the ability to respond to a second argument:
+ to print numbers from standard input that are not in the whitelist, - to print
numbers that are in the whitelist.
*/
public class Exercise23
{

  public static int rank(int key, int[] a)
  {
    return rank(key, a, 0, a.length - 1, 0);
  }

  public static int rank(int key, int[] a, int lo, int hi, int depth)
  {
    if (lo > hi) return -1;
    int mid = lo + (hi - lo) / 2;
    if (key < a[mid]) return rank(key, a, lo, mid - 1, depth + 1);
    else if (key > a[mid]) return rank(key, a, mid + 1, hi, depth + 1);
    else return mid + 1;
  }

  public static void main(String[] args)
  {
    int[] whitelist = new In(args[0]).readAllInts();
    Arrays.sort(whitelist);
    int mult = 1;
    //+ operator doesn't change functionality.
    // If second argument given is -, change mult to -1 which will be
    // multiplied by the return value from rank. Return value on successful
    // search adjusted to mid + 1 so that index 0 returns a positive value.
    if (args.length > 1)
    {
      if (args[1].equals("-"))
        mult = -1;
    }
    while (!StdIn.isEmpty())
    {
      int key = StdIn.readInt();
      if (mult * rank(key, whitelist) < 0) StdOut.println(key);
    }
  }

}
