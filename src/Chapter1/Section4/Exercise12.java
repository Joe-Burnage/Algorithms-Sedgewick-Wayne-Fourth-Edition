package Chapter1.Section4;

import edu.princeton.cs.algs4.StdOut;

public class Exercise12
{
  public static void main()
  {
    int[] a = { 1, 2, 3, 4, 5 };
    int[] b = { 3, 4, 5, 6, 7, 8 };
    printCommonElements(a, b);
  }


  public static void printCommonElements(int[] sorted_a, int[] sorted_b)
  {
    int a_index = 0;
    int b_index = 0;
    while (a_index < sorted_a.length && b_index < sorted_b.length)
    {
      if (sorted_a[a_index] == sorted_b[b_index]) {
        StdOut.println(sorted_a[a_index]);
        a_index++;
        b_index++;
      }
      else if (sorted_a[a_index] < sorted_b[b_index]) a_index++;
      else b_index++;
    }
  }
}
