package Chapter1.Section1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise31
{
  public static void main(String[] args)
  {
    StdDraw.setCanvasSize(1024, 1024);
    StdDraw.setPenRadius(0.005);
    int N = Integer.parseInt(args[0]);
    double p = Double.parseDouble(args[1]);
    double[][] coords = new double[N][2];
    for (int i = 0; i < N; i++)
    {
      coords[i][0] = 0.5 + 0.4 * Math.cos(2 * Math.PI * i / N);
      coords[i][1] = 0.5 + 0.4 * Math.sin(2 * Math.PI * i / N);
      StdDraw.point(coords[i][0], coords[i][1]);
    }
    for (int i = 0; i < N; i++)
    {
      for (int j = i; j < N; j++)
      {
        if (StdRandom.uniformDouble() < p)
          StdDraw.line(coords[i][0],coords[i][1], coords[j][0], coords[j][1]);
      }
    }
  }
}
