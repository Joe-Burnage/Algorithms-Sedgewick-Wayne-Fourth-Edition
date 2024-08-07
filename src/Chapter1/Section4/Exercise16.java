package Chapter1.Section4;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/*
Closest pair (in one dimension). Write a program that, given an array a[] of N
double values, finds a closest pair : two values whose difference is no greater than the
the difference of any other pair (in absolute value). The running time of your program
should be linearithmic in the worst case.
*/
public class Exercise16
{
  public static void main()
  {//                         v                  vvvvvv
    double[] doubles = {-0.1, 0, 1.2, 3.5, -6.4, -0.001, 3.1};
    StdOut.print("Expected output: [-0.001, 0.0]\nActual output:   ");
    StdOut.println(Arrays.toString(closestPair(doubles)));
  }

  public static double[] closestPair(double[] doubles)
  {
    double min = Double.MAX_VALUE;
    double[] pair = new double[2];
    Arrays.sort(doubles);
    for (int i = 1; i < doubles.length; i++)
      if (doubles[i] - doubles[i - 1] < min)
      {
        min = doubles[i] - doubles[i - 1];
        pair[0] = doubles[i - 1];
        pair[1] = doubles[i];
      }
    return pair;
  }
}
