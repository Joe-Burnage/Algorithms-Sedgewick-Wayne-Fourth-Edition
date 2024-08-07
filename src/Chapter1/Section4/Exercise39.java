package Chapter1.Section4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.ThreeSum;

public class Exercise39
{
  public static void main()
  {
    double prev = DoublingRatio.timeTrial(125, 100);
    for (int N = 250; N < 1E8; N += N)
    {
      double time = DoublingRatio.timeTrial(N, 100);
      StdOut.printf("%6d %7.1f ", N, time);
      StdOut.printf("%5.1f\n", time / prev);
      prev = time;
    }
  }
}

class DoublingRatio
{
  public static double timeTrial(int N, int trials)
  {
    Stopwatch timer = new Stopwatch();
    for (int i = 0; i < trials; i++)
    {
      int   MAX = 1000000;
      int[] a   = new int[N];
      for (int j = 0; j < N; j++)
        a[j] = StdRandom.uniformInt(-MAX, MAX);
      int _ = ThreeSum.count(a);
    }
    return timer.elapsedTime();
  }


}