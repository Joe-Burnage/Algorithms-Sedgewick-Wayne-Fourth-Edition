package Chapter1.Section1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise32
{
  public static void main(String[] args)
  {
    int N = Integer.parseInt(args[0]);
    double l = Double.parseDouble(args[1]);
    double r = Double.parseDouble(args[2]);
    double intervalSize = (r - l) / N;
    int[] histogram = new int[N];
    int max = 0;
    while (StdIn.hasNextLine())
    {
      String line = StdIn.readLine();
      if (line.isEmpty()) break;
      double val = Double.parseDouble(line);
      if (val > l && val < r)
      {
        int interval = (int) Math.floor((val - l) / intervalSize);
        StdOut.println(interval);
        histogram[interval]++;
        if (histogram[interval] > max)
        {
          max = histogram[interval];
        }
      }
    }
    StdOut.println(Arrays.toString(histogram));
    StdDraw.setYscale(0, max);
    double halfwidth = 0.5 / N;
    double xloc = 1.0 / N;
    for (int i = 0; i < N; i++)
    {
      StdDraw.filledRectangle(i*xloc + halfwidth, 0, halfwidth, histogram[i]);
    }
  }
}
