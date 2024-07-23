package Chapter1.Section1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
/*
Remove duplicates. Modify the test client in BinarySearch to remove any
duplicate keys in the whitelist after the sort.
*/
public class Exercise28
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
    else return mid;
  }

  public static int[] deleteDuplicates(int[] whitelist){
    int[] noDuplicates = new int[whitelist.length];
    int duplicateCount = 0;
    noDuplicates[0] = whitelist[0];
    for (int i = 1; i < whitelist.length; i++)
    {
      if (whitelist[i] == whitelist[i-1]){
        duplicateCount++;
      } else
      {
        noDuplicates[i - duplicateCount] = whitelist[i];
      }
    }
    if (duplicateCount == 0) return whitelist;
    int[] output = new int[whitelist.length - duplicateCount];
    for (int i = 0; i < output.length; i++)
    {
      output[i] = noDuplicates[i];
    }
    return output;
  }

  public static void main(String[] args)
  {
    int[] whitelist = new In(args[0]).readAllInts();
    Arrays.sort(whitelist);
    StdOut.println(Arrays.toString(whitelist));
    int[] newWhitelist = deleteDuplicates(whitelist);
    StdOut.println(Arrays.toString(newWhitelist));
    while (!StdIn.isEmpty())
    {
      int key = StdIn.readInt();
      if (rank(key, newWhitelist) < 0)
        StdOut.println(key);
    }
  }
}
