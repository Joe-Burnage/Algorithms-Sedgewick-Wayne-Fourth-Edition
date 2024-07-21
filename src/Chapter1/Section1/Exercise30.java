package Chapter1.Section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise30
{
  public static int gcd(int p, int q)
  {
    if (q == 0) return p;
    int r = p % q;
    return gcd(q, r);
  }

  public static void coprimeArray(int N)
  {
    boolean[][] array = new boolean[N][N];
    for (int i = 0; i < N; i++)
    {
      for (int j = 0; j <= i; j++)
      {
        array[i][j] = gcd(i+1, j+1) == 1;
        array[j][i] = array[i][j];
      }
    }
    for (int i = 0; i < N; i++)
    {
      for (int j = 0; j < N; j++)
      {
        if (array[i][j])
          StdOut.print(" * ");
        else StdOut.print("   ");
      }
      StdOut.println();
    }
  }

  public static void main(String[] args)
  {
    int N = Integer.parseInt(args[0]);
    coprimeArray(N);
  }
}
