package Chapter1.Section4;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
/*
Farthest pair (in one dimension). Write a program that, given an array a[] of N
double values, finds a farthest pair : two values whose difference is no smaller than the
the difference of any other pair (in absolute value). The running time of your program
should be linear in the worst case.
*/
public class Exercise17
{
  public static void main()
  {//                                 vvv  vvvv
    double[] doubles = {-0.1, 0, 1.2, 3.5, -6.4, -0.001, 3.1};
    StdOut.print("Expected output: [-6.4, 3.5]\nActual output:   ");
    StdOut.println(Arrays.toString(farthestPair(doubles)));
  }

  public static double[] farthestPair(double[] doubles)
  {
    if (doubles.length == 0) return null;
    if (doubles.length == 1) return new double[] {doubles[0], doubles[0]};
    double min = Double.MAX_VALUE;
    double max = Double.MIN_VALUE;
    for (double d : doubles)
    {
      min = Math.min(min, d);
      max = Math.max(max, d);
    }
    return new double[] {min, max};
  }
}
