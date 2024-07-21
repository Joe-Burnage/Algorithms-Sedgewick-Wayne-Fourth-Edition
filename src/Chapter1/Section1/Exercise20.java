package Chapter1.Section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise20
{
  public static double lnFactorial(int N)
  {
    if (N == 1) return 0;
    return Math.log(N) + lnFactorial(N-1);
  }

  public static void main(String[] args)
  {
    StdOut.println(lnFactorial(5));
  }
}
