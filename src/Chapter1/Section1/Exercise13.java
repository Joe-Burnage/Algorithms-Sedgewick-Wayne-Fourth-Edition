package Chapter1.Section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise13
{
  public static void printTransposition(int[][] a){
    int N = a[0].length;
    for (int i = 0; i < N; i++)
    {
      for (int[] ints : a)
      {
        StdOut.printf("%d ", ints[i]);
      }
      StdOut.println();
    }
  }
  public static void main(String[] args)
  {
    int[][] a = {{1,2},
                 {3,4},
                 {5,6}
    };
    printTransposition(a);
  }
}
