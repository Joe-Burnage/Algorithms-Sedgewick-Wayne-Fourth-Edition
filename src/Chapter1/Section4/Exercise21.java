package Chapter1.Section4;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

import static Chapter1.Section4.Exercise10.rank;

/*
Binary search on distinct values. Develop an implementation of binary search
for StaticSETofInts (see page 98) where the running time of contains() is
guaranteed to be ~ lg R, where R is the number of different integers in the
array given as argument to the constructor.


*/
public class Exercise21
{
  public static void main()
  {
    ContainsStaticSETofInts test = new ContainsStaticSETofInts(new int[] { 1, 5, 2, -4, -6, 3, 100 });
    StdOut.println(test.contains(5));

  }

}

class ContainsStaticSETofInts
{
  private final int[] a;

  public ContainsStaticSETofInts(int[] keys)
  {
    a = new int[keys.length];
    System.arraycopy(keys, 0, a, 0, keys.length);
    Arrays.sort(a);
    for (int i = 1; i < a.length; i++)
      if (a[i] == a[i - 1])
        throw new IllegalArgumentException("Argument arrays contains duplicate keys.");
  }

  public boolean contains(int key) { return rank(key, a) != -1; }

}
