package Chapter1.Section3;


import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/*
Ring buffer. A ring buffer, or circular queue, is a FIFO data structure of a fixed
size N. It is useful for transferring data between asynchronous processes or for storing
log files. When the buffer is empty, the consumer waits until data is deposited; when the
buffer is full, the producer waits to deposit data. Develop an API for a RingBuffer and
an implementation that uses an array representation (with circular wrap-around).
*/
public class Exercise39
{
  public static void main()
  {
    StdOut.println("Linked list RingBuffer tests:");
    RingBuffer list = new RingBuffer(3);
    StdOut.println("Empty list isEmpty(): " + list.isEmpty());
    StdOut.println("Empty list isFull():  " + list.isFull());
    list.enqueue(1);
    list.enqueue(2);
    list.enqueue(3);
    StdOut.println("Full list isEmpty():  " + list.isEmpty());
    StdOut.println("Full list isFull():   " + list.isFull());
    StdOut.println(list);
    StdOut.println("Dequeue: " + list.dequeue());
    StdOut.println(list);

    StdOut.println("\nArray RingBuffer tests:");
    RingBufferArray array = new RingBufferArray(3);
    StdOut.println("Empty array isEmpty(): " + array.isEmpty());
    StdOut.println("Empty array isFull():  " + array.isFull());
    array.enqueue(1);
    array.enqueue(2);
    array.enqueue(3);
    StdOut.println("Full array isEmpty():  " + array.isEmpty());
    StdOut.println("Full array isFull():   " + array.isFull());
    StdOut.println(array);
    StdOut.println("Dequeue: " + array.dequeue());
    StdOut.println(array);

  }

}

class RingBuffer<Item>
{
  //Node class and last made public for use in Exercise 37
  public        Node last  = new Node();
  public        Node first = last;
  private       int  N;
  private final int  max;

  public class Node
  {
    Item item;
    Node next;
  }

  public RingBuffer(int max)
  {
    if (max < 1) throw new RuntimeException("Ring buffer size must be at least 1.");
    this.max = max;
    for (int i = 1; i < max; i++)
    {
      Node x = new Node();
      last.next = x;
      last = x;
    }
    last.next = first;
  }

  public boolean isFull() { return N == max; }

  public boolean isEmpty() { return N == 0; }

  public int size() { return N; }

  public void enqueue(Item item)
  {
    if (isEmpty())
    {
      first.item = item;
      last = first;
    } else if (isFull()) throw new RuntimeException("Buffer overflow");
    else
    {
      last = last.next;
      last.item = item;
    }
    N++;
  }

  public Item dequeue()
  {
    if (N == 0) throw new RuntimeException("Cannot dequeue an empty queue");
    Item item = first.item;
    first.item = null;
    first = first.next;
    N--;
    return item;
  }

  public String toString()
  {
    StringBuilder s    = new StringBuilder();
    Node          temp = first;
    for (int i = 1; i < max; i++)
    {
      s.append(temp.item).append(" -> ");
      temp = temp.next;
    }
    s.append(temp.item).append(" ⤾");
    return s.toString();
  }
}

class RingBufferArray<Item>
{
  Item[] array;
  int    N;
  int    frontindex;
  int    max;

  public boolean isFull()
  { return N == max; }

  public boolean isEmpty()
  { return N == 0; }

  public RingBufferArray(int max)
  {
    this.array = (Item[]) new Object[max];
    this.max = max;
  }

  public void enqueue(Item item)
  {
    if (isFull()) throw new RuntimeException("Buffer overflow");
    array[(frontindex + N) % max] = item;
    N++;
  }

  public Item dequeue()
  {
    if (isEmpty()) throw new RuntimeException("Queue is empty");
    Item item = array[frontindex];
    array[frontindex] = null;
    frontindex = (frontindex + 1) % max;
    N--;
    return item;
  }

  public String toString()
  {
    return Arrays.toString(array);
  }
}
