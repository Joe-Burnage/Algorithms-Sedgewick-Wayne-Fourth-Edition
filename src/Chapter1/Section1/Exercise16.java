package Chapter1.Section1;

import edu.princeton.cs.algs4.StdOut;
/*
Give the value of exR1(6):
public static String exR1(int n)
{
if (n <= 0) return "";
return exR1(n-3) + n + exR1(n-2) + n;
}
*/
public class Exercise16
{
    public static String exR1(int n)
    {
      if (n <= 0) return "";
      return exR1(n-3) + n + exR1(n-2) + n;
    }
  public static void main(String[] args)
  {
    StdOut.println(exR1(6));
  }
}
