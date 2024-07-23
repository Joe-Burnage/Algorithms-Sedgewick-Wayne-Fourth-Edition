package Chapter1.Section2;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.awt.*;
/*
Write a Point2D client that takes an integer value N from the command line,
generates N random points in the unit square, and computes the distance separating
the closest pair of points.
*/
public class Exercise1
{
  public static Point2D[] closestPair(Point2D[] array)
  {
    double closest = Double.POSITIVE_INFINITY;
    int N = array.length;
    Point2D[] pair = new Point2D[2];
    for (int i = 1; i < N; i++)
    {
      for (int j = 0; j < i; j++)
      {
        double distance = array[i].distanceTo(array[j]);
        if (distance < closest)
        {
          closest = distance;
          pair[0] = array[i];
          pair[1] = array[j];
        }
      }
    }
    return pair;
  }

  //Visualisation of points and closest pair on canvas
  public static void drawPoints(Point2D[] points)
  {
    StdDraw.setCanvasSize(1024, 1024);
    StdDraw.setPenRadius(0.005);
    for (Point2D point : points)
      StdDraw.point(point.x(), point.y());
  }

  public static void circleClosest(Point2D[] closest)
  {
    StdDraw.setPenColor(Color.red);
    StdDraw.circle(
        (closest[0].x() + closest[1].x()) / 2,
        (closest[0].y() + closest[1].y()) / 2,
        0.01);
  }


  public static void main(String[] args)
  {
    int N = Integer.parseInt(args[0]);
    Point2D[] points = new Point2D[N];

    for (int i = 0; i < N; i++)
    {
      double x = Math.random();
      double y = Math.random();
      points[i] = new Point2D(x, y);
    }
    drawPoints(points);
    Point2D[] closest = closestPair(points);
    circleClosest(closest);
    double distance = closest[0].distanceTo(closest[1]);
    StdOut.printf("Distance between closest pair of points: %.4f", distance);
  }
}
