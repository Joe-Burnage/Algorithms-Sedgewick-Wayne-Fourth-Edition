package Chapter1.Section1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise36
{
  public static void shuffle(int[] a)
  {
    int N = a.length;
    for (int i = 0; i < N; i++)
    { // Exchange a[i] with random element in a[i..N-1]
      int r = i + StdRandom.uniformInt(N - i);
      int temp = a[i];
      a[i] = a[r];
      a[r] = temp;
    }
  }

  public static void shuffleTest(int M, int N)
  {
    int[][] results = new int[M][M];
    for (int i = 0; i < N; i++)
    {
      int[] array = new int[M];
      for (int j = 0; j < M; j++)
        array[j] = j;
      shuffle(array);
      for (int j = 0; j < M; j++)
      {
        results[j][array[j]]++;
      }
    }
    for (int i = 0; i < M; i++)
    {
      for (int j = 0; j < M; j++)
        StdOut.printf("%4d ", results[i][j]);
      StdOut.println();
    }
  }

  public static void main(String[] args)
  {
    int M = Integer.parseInt(args[0]);
    int N = Integer.parseInt(args[1]);
    shuffleTest(M, N);
  }
}
