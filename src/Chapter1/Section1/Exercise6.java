package Chapter1.Section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise6
{
  public static void main(String[] args)
  {
    StdOut.println("The program prints the first 16 numbers in the Fibonacci sequence.");
    int f = 0;
    int g = 1;
    for (int i = 0; i <= 15; i++)
    {
      StdOut.printf("%-2d: %d\n", i + 1, f);
      f = f + g;
      g = f - g;
    }
  }
}
