package Chapter1.Section1;

import edu.princeton.cs.algs4.StdOut;
/*
Write a code fragment that prints true if the double variables x and y are both
strictly between 0 and 1 and false otherwise.
*/
public class Exercise5
{

  public static void between0And1(double x, double y)
  {
    StdOut.println(x > 0 && x < 1 && y > 0 && y < 1);
  }

  public static void main(String[] args)
  {
    StdOut.print("x: 0.5, y: 0.5\nExpected: true\nActual:   ");
    between0And1(0.5, 0.5);
    StdOut.print("x: 1, y: 0.5\nExpected: false\nActual:   ");
    between0And1(1, 0.5);
  }
}
