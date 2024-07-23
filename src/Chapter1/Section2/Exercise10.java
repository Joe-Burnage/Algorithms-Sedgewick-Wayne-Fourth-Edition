package Chapter1.Section2;

import edu.princeton.cs.algs4.StdDraw;
/*
Develop a class VisualCounter that allows both increment and decrement
operations. Take two arguments N and max in the constructor, where N specifies the
maximum number of operations and max specifies the maximum absolute value for
the counter. As a side effect, create a plot showing the value of the counter each time its
tally changes.
*/
public class Exercise10
{
  public static void main(String[] args)
  {
    VisualCounter test = new VisualCounter(10, 10);
    test.increment();
    test.increment();
    test.decrement();
    test.increment();
    test.decrement();
    test.decrement();
    test.decrement();
    test.decrement();
    test.decrement();
    test.increment();
  }
}

class VisualCounter
{
  private final int N;
  private final int max;
  private int operations;
  private int counter;

  public VisualCounter(int N, int max)
  {
    this.N = Math.abs(N);
    this.max = Math.abs(max);
    this.operations = 0;
    this.counter = 0;
    StdDraw.setCanvasSize(1024, 1024);
    StdDraw.setPenRadius(0.01);
    StdDraw.setXscale(0, this.N + 1);
    StdDraw.setYscale(-(this.max + 1), this.max + 1);
  }

  public void increment()
  {
    if (operations < N)
    {
      operations++;
      if (counter < max) counter++;
    }
    plot();
  }

  public void decrement()
  {
    if (operations < N)
    {
      operations++;
      if (counter > -max) counter--;
    }
    plot();
  }

  private void plot()
  {
    StdDraw.point(operations, counter);
  }
}
