package Chapter1.Section2;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
/*
Instrument BinarySearch (page 47) to use a Counter to count the total number
of keys examined during all searches and then print the total after all searches are
complete. Hint : Create a Counter in main() and pass it as an argument to rank().
*/
public class Exercise9
{
  public static int rank(int key, int[] a, Counter counter)
  {
    int lo = 0;
    int hi = a.length - 1;
    while (lo <= hi)
    {
      counter.increment();
      int mid = lo + (hi - lo) / 2;
      if (key < a[mid]) hi = mid - 1;
      else if (key > a[mid]) lo = mid + 1;
      else return mid;
    }
    return -1;
  }
  public static void main(String[] args)
  {
    Counter counter = new Counter("Keys");
    int[] whitelist = new In(args[0]).readAllInts();
    Arrays.sort(whitelist);
    while (StdIn.hasNextLine())
    {
      String line = StdIn.readLine();
      if (line.isEmpty()) break;
      int key = Integer.parseInt(line);
      if (rank(key, whitelist, counter) < 0)
        StdOut.println(key);
    }
    StdOut.printf("Total increments: %d", counter.tally());
  }
}
