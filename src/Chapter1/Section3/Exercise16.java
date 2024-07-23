package Chapter1.Section3;

import edu.princeton.cs.algs4.*;

import java.util.Arrays;
/*
Using readInts() on page 126 as a model, write a static method readDates() for
Date that reads dates from standard input in the format specified in the table on page 119
and returns an array containing them.
*/
public class Exercise16
{
  public static void main(String[] args)
  {
    if (args.length == 1) StdOut.println(Arrays.toString(readDates(args[0])));
    else throw new RuntimeException("Must include filename of a file containing dates in the format MM/DD/YYYY.");
  }

  public static Date[] readDates(String name)
  {
    In          in = new In(name);
    Queue<Date> q  = new Queue<>();
    while (!in.isEmpty())
    {
      String line = in.readLine();
      q.enqueue(new Date(line));
    }
      int    N = q.size();
    Date[] a = new Date[N];
    for (int i = 0; i < N; i++)
      a[i] = q.dequeue();
    return a;
  }
}
