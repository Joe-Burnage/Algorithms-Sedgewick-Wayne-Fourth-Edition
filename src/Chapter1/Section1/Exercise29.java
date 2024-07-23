package Chapter1.Section1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
/*
Equal keys. Add to BinarySearch a static method rank() that takes a key and
a sorted array of int values (some of which may be equal) as arguments and returns the
number of elements that are smaller than the key and a similar method count() that
returns the number of elements equal to the key. Note : If i and j are the values returned
by rank(key, a) and count(key, a) respectively, then a[i..i+j-1] are the values in
the array that are equal to key.
*/
public class Exercise29
{
  public static int rank(int key, int[] a)
  {
    return rank(key, a, 0, a.length - 1, 0);
  }

  public static int rank(int key, int[] a, int lo, int hi, int depth)
  {
    if (lo > hi) return hi;
    int mid = lo + (hi - lo) / 2;
    if (key < a[mid]) return rank(key, a, lo, mid - 1, depth + 1);
    else if (key > a[mid]) return rank(key, a, mid + 1, hi, depth + 1);
    else
    {
      if (mid == 0) return 0;
      while (a[mid] == a[mid - 1])
        mid--;
      return mid;
    }
  }

  public static int count(int key, int[] a)
  {
    int index = rank(key, a);
    int count = 1;
    while (a[index] == a[index + 1])
    {
      count++;
      index++;
    }
    return count;
  }


  public static void main(String[] args)
  {
    int[] whitelist = new In(args[0]).readAllInts();
    Arrays.sort(whitelist);
    StdOut.println(Arrays.toString(whitelist));
    while (!StdIn.isEmpty())
    {
      int key = StdIn.readInt();
      StdOut.println(rank(key, whitelist));
      StdOut.println(count(key, whitelist));
    }
  }
}
