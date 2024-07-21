package Chapter1.Section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise24
{
  public static int gcd(int p, int q)
  {
    StdOut.println("p: " + p + "\nq: " + q);
    if (q == 0) return p;
    int r = p % q;
    return gcd(q, r);
  }

  public static void main(String[] args)
  {
  int p = Integer.parseInt(args[0]);
  int q = Integer.parseInt(args[1]);
    StdOut.println(gcd(p, q));
  }
}
