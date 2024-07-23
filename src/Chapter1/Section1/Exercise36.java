package Chapter1.Section1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
/*
Empirical shuffle check. Run computational experiments to check that our
shuffling code on page 32 works as advertised. Write a program ShuffleTest that takes
command-line arguments M and N, does N shuffles of an array of size M that is initialized
with a[i] = i before each shuffle, and prints an M-by-M table such that row i
gives the number of times i wound up in position j for all j. All entries in the array
should be close to N/M.
*/
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
