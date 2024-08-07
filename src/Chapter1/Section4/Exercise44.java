package Chapter1.Section4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

import static Chapter1.Section4.Exercise10.rank;

public class Exercise44
{
  public static void main(String[] args)
  {
    int size = Integer.parseInt(args[0]);
    int[] a = new int[size];
    int count = 0;
    while (true)
    {
      int n = StdRandom.uniformInt(size);
      if (rank(n, a) > -1) break;
      a[count] = n;
      Arrays.sort(a);
      count++;
    }
    StdOut.printf("Repeat after %d.", count);
  }
}
