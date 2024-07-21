package Chapter1.Section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise27
{

  public static double binomialInitialise(int N, int k, double p)
  {
    double[][] array = new double[N + 1][k + 1];
    for (int i = 0; i < N + 1; i++)
    {
      for (int j = 0; j < k + 1; j++)
      {
        array[i][j] = -1;
      }
    }

    return binomialImproved(N, k, p, array);
  }

  public static double binomialImproved(int N, int k, double p, double[][] array)
  {
    if ((N == 0) && (k == 0))
    {
      array[N][k] = 1.0;
      return 1.0;
    }
    if ((N < 0) || (k < 0))
    {
      return 0.0;
    }
    if (array[N][k] != -1) return array[N][k];
    array[N][k] = (1.0 - p) * binomialImproved(N - 1, k, p, array) +
        p * binomialImproved(N - 1, k - 1, p, array);
    return array[N][k];
  }

  public static void main(String[] args)
  {
    final long startTime = System.currentTimeMillis();
    double answer = binomialInitialise(1004, 17, 0.6);
    final long endTime = System.currentTimeMillis();
    double runTime = (double) (endTime - startTime) / 1000.0;
    StdOut.printf("Answer: %.6f\nRun time: %.3fs", answer, runTime);
  }
}
