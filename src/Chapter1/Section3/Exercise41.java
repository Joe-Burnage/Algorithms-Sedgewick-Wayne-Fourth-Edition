package Chapter1.Section3;

import edu.princeton.cs.algs4.StdOut;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
Copy a queue. Create a new constructor so that
Queue<Item> r = new Queue<Item>(q);
makes r a reference to a new and independent copy of the queue q. You should be able
to push and pop from either q or r without influencing the other.
*/
public class Exercise41
{
  public static void main()
  {
    Queue q = new Queue();
    for (int i = 0; i < 5; i++)
      q.enqueue(i + 1);
    StdOut.println("q:         " + q);
    Queue r = new Queue(q);
    StdOut.println("r:         " + r);
    StdOut.println("q.dequeue: " + q.dequeue());
    StdOut.println("q:         " + q);
    StdOut.println("r:         " + r);
  }
}

class Queue<Item> implements Iterable<Item>
{
  private Node<Item> first;
  private Node<Item> last;
  private int        n;

  private static class Node<Item>
  {
    private Item       item;
    private Node<Item> next;
  }

  public Queue()
  {
    first = null;
    last = null;
    n = 0;
  }

  public Queue(Queue q)
  {
    first = null;
    last = null;
    n = 0;
    for (Object item : q)
      enqueue((Item) item);
  }

  boolean isEmpty()
  {
    return first == null;
  }

  public int size()
  {
    return n;
  }

  public void enqueue(Item item)
  {
    Node<Item> oldlast = last;
    last = new Node<>();
    last.item = item;
    last.next = null;
    if (isEmpty()) first = last;
    else oldlast.next = last;
    n++;
  }

  public Item dequeue()
  {
    if (isEmpty()) throw new NoSuchElementException("Queue underflow");
    Item item = first.item;
    first = first.next;
    n--;
    if (isEmpty()) last = null;   // to avoid loitering
    return item;
  }

  public String toString()
  {
    StringBuilder s = new StringBuilder();
    for (Item item : this)
    {
      s.append(item);
      s.append(' ');
    }
    return s.toString();
  }

  public @NotNull Iterator<Item> iterator()
  {
    return new LinkedIterator(first);
  }

  private class LinkedIterator implements Iterator<Item>
  {
    private Node<Item> current;

    public LinkedIterator(Node<Item> first)
    {
      current = first;
    }

    public boolean hasNext()
    {
      return current != null;
    }

    public Item next()
    {
      if (!hasNext()) throw new NoSuchElementException();
      Item item = current.item;
      current = current.next;
      return item;
    }
  }
}

