package Chapter1.Section3;

import edu.princeton.cs.algs4.StdOut;

/*
Two stacks with a deque. Implement two stacks with a single deque so that each
operation takes a constant number of deque operations (see Exercise 1.3.33).
*/
public class Exercise48
{
  public static void main()
  {
    TwoStackDeque twoStackDeque = new TwoStackDeque();
    twoStackDeque.pushLeft(1);
    twoStackDeque.pushLeft(2);
    twoStackDeque.pushLeft(3);
    twoStackDeque.pushLeft(4);
    StdOut.println("Push 1-4 on left");
    StdOut.println("Deque:            " + twoStackDeque);
    StdOut.println("Left stack size:  " + twoStackDeque.leftSize());
    StdOut.println("Pop left:         " + twoStackDeque.popLeft());
    StdOut.println("Left stack size:  " + twoStackDeque.leftSize());
    StdOut.println("Left stack:       " + twoStackDeque.leftString());
    StdOut.println("Deque size:       " + twoStackDeque.size());
    twoStackDeque.pushRight(1);
    twoStackDeque.pushRight(2);
    twoStackDeque.pushRight(3);
    twoStackDeque.pushRight(4);
    StdOut.println("\nPush 1-4 on right");
    StdOut.println("Deque:            " + twoStackDeque);
    StdOut.println("Right stack size: " + twoStackDeque.rightSize());
    StdOut.println("Pop right:        " + twoStackDeque.popRight());
    StdOut.println("Right stack size: " + twoStackDeque.rightSize());
    StdOut.println("Deque:            " + twoStackDeque);
    StdOut.println("Deque size:       " + twoStackDeque.size());
  }

}

class TwoStackDeque<Item>
{
  private int   leftSize;
  private int   rightSize;
  private       int   size;
  private final Deque deque = new Deque();

  public void pushLeft(Item item)
  {
    deque.pushLeft(item);
    leftSize++;
    size++;
  }

  public void pushRight(Item item)
  {
    deque.pushRight(item);
    rightSize++;
    size++;
  }

  public Item popLeft()
  {
    size--;
    leftSize--;
    if (leftSize < 0) throw new ArrayIndexOutOfBoundsException("Queue underflow");
    return (Item) deque.popLeft();
  }

  public Item popRight()
  {
    size--;
    rightSize--;
    if (rightSize < 0) throw new ArrayIndexOutOfBoundsException("Queue underflow");
    return (Item) deque.popRight();
  }

  public int size() { return size; }

  public int leftSize() { return leftSize; }

  public int rightSize() { return rightSize; }

  public String leftString()
  {
    StringBuilder s = new StringBuilder();
    int           i = 0;
    for (Object item : deque)
    {
      s.append(item);
      i++;
      if (i == leftSize) break;
      s.append(" <- ");
    }
    return s.toString();
  }

  public String toString()
  {
    StringBuilder s = new StringBuilder();
    int           i = 0;
    for (Object item : deque)
    {
      s.append(item);
      i++;
      if (i < leftSize) s.append(" <- ");
      else if (i == leftSize) s.append(" | ");
      else if (i != size) s.append(" -> ");
    }
    return s.toString();
  }
}
