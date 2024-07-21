package Chapter1.Section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise18
{
  public static int mystery(int a, int b)
  {
    if (b == 0) return 1;
    if (b % 2 == 0) return mystery(a*a, b/2);
    return mystery(a*a, b/2) * a;
  }

  public static void main(String[] args)
  {
    StdOut.println(mystery(25, 2));
    StdOut.println(mystery(2, 25));
    StdOut.println(mystery(25, 25));
  }
}
