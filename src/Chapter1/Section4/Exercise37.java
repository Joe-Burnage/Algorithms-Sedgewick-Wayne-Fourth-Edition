package Chapter1.Section4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

/*
Autoboxing performance penalty. Run experiments to determine the performance
penalty on your machine for using autoboxing and auto-unboxing. Develop an
implementation FixedCapacityStackOfInts and use a client such as DoublingRatio
to compare its performance with the generic FixedCapacityStack<Integer>, for a
large number of push() and pop() operations.
*/
public class Exercise37
{
  public static void main()
  {
    for (int i = 250; i < 5E8; i *= 8)
    {
      Stopwatch                   autoboxTimer = new Stopwatch();
      FixedCapacityStack<Integer> autoboxTest  = new FixedCapacityStack<>(i);
      randomActions(autoboxTest);
      double                   autoboxTime    = autoboxTimer.elapsedTime();
      Stopwatch                primitiveTimer = new Stopwatch();
      FixedCapacityStackOfInts primitiveTest  = new FixedCapacityStackOfInts(i);
      randomActions(primitiveTest);
      double primitiveTime = primitiveTimer.elapsedTime();
      StdOut.printf("""
                        Test size: %d
                        Primitive stack time:  %.3f
                        Autoboxing stack time: %.3f
                        
                        """, i, primitiveTime, autoboxTime);
    }
  }

  static void randomActions(FixedCapacityStack stack)
  {
    int capacity = stack.capacity();
    for (int i = 0; i < capacity / 100; i++)
      stack.push((int) (Math.random() * 10000));
    for (int i = 0; i < capacity; i++)
    {
      if (Math.random() > 0.3) stack.push((int) (Math.random() * capacity));
      else stack.pop();
    }
  }

  static void randomActions(FixedCapacityStackOfInts stack)
  {
    int capacity = stack.capacity();
    for (int i = 0; i < capacity / 10; i++)
      stack.push((int) (Math.random() * 10000));
    for (int i = 0; i < capacity; i++)
    {
      if (Math.random() > 0.5) stack.push((int) (Math.random() * capacity));
      else stack.pop();
    }
  }

}


class FixedCapacityStack<Item>
{
  private final Item[] a;
  private       int    N;

  public FixedCapacityStack(int cap) { this.a = (Item[]) new Object[cap]; }

  public boolean isEmpty() { return N == 0; }

  public boolean isFull() { return N == a.length; }

  public int size() { return N; }

  public int capacity() { return a.length; }

  public void push(Item item) { a[N++] = item; }

  public Item pop() { return a[--N]; }

}

class FixedCapacityStackOfInts
{
  private final int[] a;
  private       int   N;

  public FixedCapacityStackOfInts(int cap) { a = new int[cap]; }

  public boolean isEmpty() { return N == 0; }

  public boolean isFull() { return N == a.length; }

  public int size() { return N; }

  public int capacity() { return a.length; }

  public void push(int x) { a[N++] = x; }

  public int pop() { return a[--N]; }


}
