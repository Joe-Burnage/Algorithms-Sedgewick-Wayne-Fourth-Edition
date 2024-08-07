package Chapter1.Section4;

import edu.princeton.cs.algs4.*;

import java.awt.*;

/*
Modify DoublingTest to use StdDraw to produce plots like the standard and
log-log plots in the text, rescaling as necessary so that the plot always fills a substantial
portion of the window.
*/
public class Exercise3

{
  public static double timeTrial(int N)
  {
    int   MAX = 1000000;
    int[] a   = new int[N];
    for (int i = 0; i < N; i++)
      a[i] = StdRandom.uniformInt(-MAX, MAX);
    Stopwatch timer = new Stopwatch();
    int       _   = ThreeSum.count(a);
    return timer.elapsedTime();
  }

  public static void drawPlot(double[][] points, int i)
  {
    StdDraw.setXscale(0, points[i][0]);
    StdDraw.setYscale(0, points[i][1]);
    for (int j = 0; j < i; j++)
    {
      StdDraw.setPenColor(Color.black);
      StdDraw.setPenRadius(0.005);
      StdDraw.line(points[j][0], points[j][1], points[j + 1][0], points[j + 1][1]);
      StdDraw.setPenRadius(0.015);
      StdDraw.setPenColor(Color.red);
      StdDraw.point(points[j][0], points[j][1]);
    }
    StdDraw.point(points[i][0], points[i][1]);
  }

  public static void drawLogPlot(double[][] points, int i)
  {
    points[i][0] = Math.log(points[i][0]);
    points[i][1] = Math.log(points[i][1]*1000);
    StdDraw.setXscale(5.5, points[i][0]);
    StdDraw.setYscale(0, points[i][1]);
    for (int j = 0; j < i; j++)
    {
      StdDraw.setPenColor(Color.black);
      StdDraw.setPenRadius(0.005);
      StdDraw.line(points[j][0], points[j][1], points[j + 1][0], points[j + 1][1]);
      StdDraw.setPenRadius(0.015);
      StdDraw.setPenColor(Color.red);
      StdDraw.point(points[j][0], points[j][1]);
    }
    StdDraw.point(points[i][0], points[i][1]);
  }

  public static void main()
  {
    StdDraw.setCanvasSize(800, 800);
    double[][] points = new double[10][2];
    int        i      = 0;
    for (int N = 250; N < 1E6; N += N)
    {
      double time = timeTrial(N);
      StdDraw.clear();
      points[i][0] = N;
      points[i][1] = time;
      drawLogPlot(points, i);
      drawPlot(points, i);
      i++;
      StdOut.printf("%7d %5.1f\n", N, time);
    }
  }
}
