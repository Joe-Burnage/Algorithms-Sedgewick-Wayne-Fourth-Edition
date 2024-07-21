package Chapter1.Section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise19
{
  public static long F(int N, long[] values)
  {
    if (N == 0) return 0;
    if (N == 1) return 1;
    return values[N - 2] + values[N - 1];
  }

  public static void main(String[] args)
  {
    int M = 90;
    long[] values = new long[M];
    for (int N = 0; N < M; N++)
    {
      values[N] = F(N, values);
      StdOut.printf("F(%d) = %d\n", N, values[N]);
    }
  }
}
