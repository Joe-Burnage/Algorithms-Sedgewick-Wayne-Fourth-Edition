package Chapter1.Section2;

import edu.princeton.cs.algs4.*;
/*
Write an Interval1D client that takes an int value N as command-line argument,
reads N intervals (each defined by a pair of double values) from standard input,
and prints all pairs that intersect.
*/
public class Exercise2
{
  public static void draw(Interval1D line, int N, int i)
  {
    //Display intervals on canvas
    double y = (i + 0.5) / N;
    StdDraw.line(line.min(), y, line.max(), y);
  }

  public static void main(String[] args)
  {
    int N = Integer.parseInt(args[0]);
    Interval1D[] intervals = new Interval1D[N];
    In input = new In();
    for (int i = 0; i < N; i++)
    {
      double a = Double.parseDouble(input.readLine());
      double b = Double.parseDouble(input.readLine());
      intervals[i] = new Interval1D(Math.min(a, b), Math.max(a, b));
      draw(intervals[i], N, i);
    }
    input.close();
    for (int i = 0; i < N; i++)
    {
      for (int j = 0; j < i; j++)
      {
        if (intervals[i].intersects(intervals[j]))
          StdOut.printf("""
             Interval %d and Interval %d intersect
             Interval %d: (%.2f, %.2f)
             Interval %d: (%.2f, %.2f)
             \s
            """,
              j, i,
              j, intervals[j].min(), intervals[j].max(),
              i, intervals[i].min(), intervals[i].max()
              );
      }
    }
  }
}
