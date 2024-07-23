package Chapter1.Section2;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
/*
Write an Interval2D client that takes command-line arguments N, min, and max
and generates N random 2D intervals whose width and height are uniformly distributed
between min and max in the unit square. Draw them on StdDraw and print the number
of pairs of intervals that intersect and the number of intervals that are contained in one
another.
*/
public class Exercise3
{
  //Extending Interval2D to make Interval1D x and y public
  static class Interval extends Interval2D
  {
    public Interval1D x;
    public Interval1D y;

    public Interval(Interval1D x, Interval1D y)
    {
      super(x, y);
      this.x = x;
      this.y = y;
    }

    public boolean contains(Interval that)
    {
      return
          this.x.min() > that.x.min() && this.x.max() < that.x.max() &&
          this.y.min() > that.y.min() && this.y.max() < that.y.max()
              ||
          that.x.min() > this.x.min() && that.x.max() < this.x.max() &&
          that.y.min() > this.y.min() && that.y.max() < this.y.max();
    }

    public static Interval makeInterval(double min, double max)
    {
      double x1 = StdRandom.uniformDouble(min, max);
      double x2 = StdRandom.uniformDouble(min, max);
      double y1 = StdRandom.uniformDouble(min, max);
      double y2 = StdRandom.uniformDouble(min, max);
      Interval1D x = new Interval1D(Math.min(x1, x2), Math.max(x1, x2));
      Interval1D y = new Interval1D(Math.min(y1, y2), Math.max(y1, y2));
      return new Interval(x, y);
    }

    public static Interval[] makeIntervals(int N, double min, double max)
    {
      Interval[] intervals = new Interval[N];
      for (int i = 0; i < N; i++)
        intervals[i] = makeInterval(min, max);
      return intervals;
    }
  }

  public static void main(String[] args)
  {
    int N = Integer.parseInt(args[0]);
    double min = Double.parseDouble(args[1]);
    double max = Double.parseDouble(args[2]);
    int intersects = 0;
    int contains = 0;
    Interval[] intervals = Interval.makeIntervals(N, min, max);

    for (int i = 0; i < N; i++)
    {
      intervals[i].draw();
      for (int j = 0; j < i; j++)
      {
        if (intervals[i].contains(intervals[j]))
        {
          intersects++;
          contains++;
        } else if (intervals[i].intersects(intervals[j])) intersects++;
      }
    }
    StdOut.printf("""
        Pairs of intersecting intervals:              %d
        Number of intervals contained within another: %d
        """, intersects, contains);
  }
}

