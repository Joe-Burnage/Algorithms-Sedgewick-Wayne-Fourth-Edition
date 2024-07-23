package Chapter1.Section1;

import edu.princeton.cs.algs4.StdOut;
/*
Write a program that takes three integer command-line arguments and prints
equal if all three are equal, and not equal otherwise.
*/
public class Exercise3
{
  public static void main(String[] args)
  {
    int a = Integer.parseInt(args[0]);
    int b = Integer.parseInt(args[1]);
    int c = Integer.parseInt(args[2]);

    if (a == b && b == c)
      StdOut.print("equal");
    else StdOut.print("not equal");
  }
}
