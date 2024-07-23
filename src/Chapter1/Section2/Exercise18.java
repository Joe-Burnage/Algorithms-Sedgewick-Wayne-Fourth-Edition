package Chapter1.Section2;

import edu.princeton.cs.algs4.StdOut;
/*
Variance for accumulator. Validate that the following code, which adds the
methods var() and stddev() to Accumulator, computes both the mean and variance
of the numbers presented as arguments to addDataValue().
This implementation is less susceptible to roundoff error than the straightforward
implementation based on saving the sum of the squares of the numbers.
*/
public class Exercise18
{
  public static void main(String[] args)
  {
    Accumulator test = new Accumulator();
    test.addDataValue(10);
    test.addDataValue(12);
    test.addDataValue(5);
    test.addDataValue(8);
    test.addDataValue(12);
    StdOut.printf("""
                  Expected vs.  Actual
        Mean        9.4          %.1f
        Variance    8.8          %.1f
        Std dev     2.966        %.3f""",
        test.mean(), test.var(), test.stddev());
  }
}

class Accumulator
{

  private double m;
  private double s;
  private int N;

  public void addDataValue(double x)
  {
    N++;
    s = s + 1.0 * (N - 1) / N * (x - m) * (x - m);
    m = m + (x - m) / N;
  }

  public double mean()
  {
    return m;
  }

  public double var()
  {
    return s / (N - 1);
  }

  public double stddev()
  {
    return Math.sqrt(this.var());
  }

}
