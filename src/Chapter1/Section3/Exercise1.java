package Chapter1.Section3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
/*
Add a method isFull() to FixedCapacityStackOfStrings.
*/
public class Exercise1
{
  public static void main()
  {
    FixedCapacityStackOfStrings s;
    s = new FixedCapacityStackOfStrings(5);
    while (!StdIn.isEmpty())
    {
      String item = StdIn.readString();
      if (!item.equals("-")) s.push(item);
      else if (!s.isEmpty()) StdOut.println(s.pop());
    }
    StdOut.printf("(%d left on stack)", s.size());
  }
}

class FixedCapacityStackOfStrings
{
  private final String[] a;
  private       int      N;

  public FixedCapacityStackOfStrings(int cap)
  { a = new String[cap]; }

  public boolean isEmpty() { return N == 0; }

  public int size() { return N; }

  public void push(String item) { a[N++] = item; }

  public String pop() { return a[--N]; }

  public boolean isFull() { return N == a.length; }
}
