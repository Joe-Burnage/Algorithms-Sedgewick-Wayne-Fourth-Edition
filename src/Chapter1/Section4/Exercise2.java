package Chapter1.Section4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.jetbrains.annotations.NotNull;
/*
Modify ThreeSum to work properly even when the int values are so large that
adding two of them might cause overflow.
*/
public class Exercise2
{

  public static int count(int @NotNull [] a)
  {
    int N = a.length;
    int cnt = 0;
    for (int i = 0; i < N; i++)
      for (int j = i+1; j < N; j++)
        for (int k = j+1; k < N; k++)
          if ((long) a[i] + (long) a[j] + (long) a[k] == 0)
            cnt++;
    return cnt;
  }
  public static void main(String @NotNull [] args)
  {
    int[] a = new In(args[0]).readAllInts();
    StdOut.println(count(a));
  }
}
