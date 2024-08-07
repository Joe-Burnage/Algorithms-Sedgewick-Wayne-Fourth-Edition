package Chapter1.Section4;

import edu.princeton.cs.algs4.StdOut;

/*
Modify binary search so that it always returns the element with the smallest
index that matches the search element (and still guarantees logarithmic running time).
*/
public class Exercise10
{

  public static void main()
  {
    int[] a =  {1, 2, 3, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10};
    int index = rank(5, a);
    StdOut.println(lowestIndex(a, 5, index));
    StdOut.println(highestIndex(a, 5, index));
  }

  public static int lowestIndex(int[] a, int key, int index)
  {
    int lo = 0;
    int hi = index;
    while (lo < hi)
    {
      int mid = lo + (hi - lo) / 2;
      if (key == a[mid]) hi = mid;
      else lo = mid + 1;
    }
    return lo;
  }

  public static int highestIndex(int[] a, int key, int index)
  {
    int lo = index;
    int hi = a.length - 1;
    while (lo < hi)
    {
      int mid = lo + (hi - lo + 1) / 2;
      if (key == a[mid]) lo = mid;
      else hi = mid - 1;
    }
    return hi;
  }

  public static int rank(int key, int[] a)
  {
    int lo = 0;
    int hi = a.length - 1;
    while (lo <= hi)
    {
      int mid = lo + (hi - lo) / 2;
      if (key < a[mid]) hi = mid - 1;
      else if (key > a[mid]) lo = mid + 1;
      else return mid;
    }
    return -1;
  }
}
