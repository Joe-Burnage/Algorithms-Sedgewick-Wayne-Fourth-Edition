package Chapter1.Section1;

import edu.princeton.cs.algs4.StdOut;
/*
Run the following program on your computer:
public class Fibonacci
{
  public static long F(int N)
  {
    if (N == 0) return 0;
    if (N == 1) return 1;
    return F(N-1) + F(N-2);
  }
  public static void main(String[] args)
  {
  for (int N = 0; N < 100; N++)
    StdOut.println(N + " " + F(N));
  }
}
What is the largest value of N for which this program takes less 1 hour to compute the
value of F(N)? Develop a better implementation of F(N) that saves computed values in
an array.
Largest value of N for which the program takes less than 1 hour to compute is 51.
*/
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
