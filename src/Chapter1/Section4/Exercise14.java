package Chapter1.Section4;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

import static Chapter1.Section4.Exercise10.lowestIndex;
import static Chapter1.Section4.Exercise10.rank;
/*
4-sum. Develop an algorithm for the 4-sum problem.
*/
public class Exercise14
{
  public static void main()
  {
    int[] a = { 1, 2, 3, -1, -2, -3};
    Arrays.sort(a);
    StdOut.println(fourSum(a));
  }

  public static int fourSum(int[] sorted_array)
  {
    int count = 0;
    int min   = sorted_array[0];
    int max   = sorted_array[sorted_array.length - 1];
    if (min > 0 || max < 0) return 0;
    for (int i = 3; i < sorted_array.length; i++)
      for (int j = 2; j < i; j++)
        for (int k = 0; k < j; k++)
        {
          int key  = -sorted_array[i] - sorted_array[j] - sorted_array[k];
          int rank = rank(key, sorted_array);
          if (rank > -1)
            count = lowestIndex(sorted_array, key, rank) < k ? count + 1 : count;
        }
    return count;
  }
}

