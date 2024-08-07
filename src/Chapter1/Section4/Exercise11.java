package Chapter1.Section4;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

import static Chapter1.Section4.Exercise10.rank;

/*
Add an instance method howMany() to StaticSETofInts (page 99) that finds the
number of occurrences of a given key in time proportional to log N in the worst case.
*/
public class Exercise11
{
  public static void main()
  {
    HowManyStaticSETofInts a = new HowManyStaticSETofInts(new int[] { 1, 2, 3, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10 });
    StdOut.println(a.howMany(5));
  }
}

class HowManyStaticSETofInts
{
  private final int[] a;

  public HowManyStaticSETofInts(int[] keys)
  {
    a = new int[keys.length];
    System.arraycopy(keys, 0, a, 0, keys.length);
    Arrays.sort(a);
  }

  public boolean contains(int key) { return rank(key, a) != -1; }

  public int howMany(int key) { return howMany(key, a); }

  public static int howMany(int key, int[] a)
  {
    int index = rank(key, a);
    if (index == -1) return 0;
    int hi = Exercise10.highestIndex(a, key, index);
    int lo = Exercise10.lowestIndex(a, key, index);
    return hi - lo + 1;
  }
}

