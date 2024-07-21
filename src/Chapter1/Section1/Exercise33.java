package Chapter1.Section1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise33
{

  public static double dot(double[] x, double[] y) throws Exception
  {
    if (x.length != y.length) throw new Exception("x and y must be of the same length");
    double dotProduct = 0;
    for (int i = 0; i < x.length; i++)
    {
      dotProduct += x[i] * y[i];
    }
    return dotProduct;
  }

  public static double[][] mult(double[][] a, double[][] b) throws Exception
  {
    if (a[0].length != b.length)
      throw new Exception("The number of rows in matrix A must equal the number of columns in matrix B");
    double[][] output = new double[a.length][b[0].length];
    b = transpose(b);
    for (int i = 0; i < output.length; i++)
    {
      for (int j = 0; j < output[i].length; j++)
      {
        output[i][j] += dot(a[i], b[j]);
      }
    }
    return output;
  }

  public static double[][] transpose(double[][] a)
  {
    double[][] output = new double[a[0].length][a.length];
    for (int i = 0; i < a.length; i++)
    {
      for (int j = 0; j < a[0].length; j++)
      {
        output[j][i] = a[i][j];
      }
    }
    return output;
  }

  public static double[] mult(double[][] a, double[] x) throws Exception
  {
    double[] out = new double[a.length];
    for (int i = 0; i < out.length; i++)
    {
      out[i] = dot(x, a[i]);
    }
    return out;
  }

  public static double[] mult(double[] y, double[][] a) throws Exception
  {
    double[] out = new double[a[0].length];
    a = transpose(a);
    for (int i = 0; i < out.length; i++)
    {
      out[i] = dot(a[i], y);
    }
    return out;
  }

  public static void main(String[] args) throws Exception
  {
    double[][] a = { { 1, 2, 3 }, { 4, 5, 6 } };
    double[][] b = { { 7, 8 }, { 9, 10 }, { 11, 12 } };
    double[] x = { 5, 6, 7 };
    StdOut.println("Matrix a:");
    StdOut.println(Arrays.deepToString(a));
    StdOut.println("Matrix b:");
    StdOut.println(Arrays.deepToString(b));
    StdOut.println("Vector x:");
    StdOut.println(Arrays.toString(x));
    StdOut.println("\na * b\nExpected:\n[58, 64], [139, 154]\nActual: ");
    StdOut.println(Arrays.deepToString(mult(a, b)));
    StdOut.println("\na * x\nExpected:\n[38, 92]\nActual: ");
    StdOut.println(Arrays.toString(mult(a, x)));
    StdOut.println("\nx * b\nExpected:\n[166, 184]\nActual: ");
    StdOut.println(Arrays.toString(mult(x, b)));
  }
}
