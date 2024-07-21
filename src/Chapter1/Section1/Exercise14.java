package Chapter1.Section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise14
{
  public static int lg(int N){
    if (N < 1) return -1;
    int i = 1;
    int base = 0;
    while (i * 2 <= N){
      i *= 2;
      base++;
    }
    return base;
  }

  public static void main(String[] args)
  {
    StdOut.println(lg(100));
    StdOut.println(lg(5));
    StdOut.println(lg(1231));
  }
}
