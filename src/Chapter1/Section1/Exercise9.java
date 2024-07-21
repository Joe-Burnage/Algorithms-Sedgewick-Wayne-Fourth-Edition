package Chapter1.Section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise9
{
  public static String integerToBinaryString(int N){
    String s = "";
    for (int n = N; n > 0; n/=2)
      s = (n % 2) + s;
    return s;
  }

  public static void main(String[] args)
  {
    StdOut.printf("integerToBinaryString(7)   = %10s\n", integerToBinaryString(7));
    StdOut.printf("integerToBinaryString(14)  = %10s\n", integerToBinaryString(14));
    StdOut.printf("integerToBinaryString(982) = %10s\n", integerToBinaryString(982));
  }
}
