package Chapter1.Section3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
Write a Queue implementation that uses a circular linked list, which is the same
as a linked list except that no links are null and the value of last.next is first
whenever the list is not empty. Keep only one Node instance variable (last).
*/
public class Exercise29
{
  public static void main()
  {
    CircularLinkedList<String> q = new CircularLinkedList<>();
    while (!StdIn.isEmpty())
    {
      String item = StdIn.readString();
      if (!item.equals("-"))
        q.enqueue(item);
      else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
    }
    StdOut.print(q);
    StdOut.println("(" + q.size() + " left on queue)");
  }
}

class CircularLinkedList<Item>
{
  //Node class and last made public for use in Exercise 37
  public  Node last;
  private int  N;

  public class Node
  {
    Item item;
    Node next;
  }

  public boolean isEmpty() { return N == 0; }

  public int size() { return N; }

  public void enqueue(Item item)
  {
    if (isEmpty())
    {
      last = new Node();
      last.item = item;
      last.next = last;
      N++;
    } else
    {
      Node newlast = new Node();
      newlast.item = item;
      newlast.next = last.next;
      last.next = newlast;
      last = newlast;
      N++;
    }
  }

  public Item dequeue()
  {
    if (N == 0) throw new RuntimeException("Cannot dequeue an empty queue");
    Item item = last.next.item;
    last.next = last.next.next;
    if (isEmpty()) last = null;
    N--;
    return item;
  }

  public String toString()
  {
    StringBuilder s    = new StringBuilder();
    Node          temp = last.next;
    while (temp != last)
    {
      s.append(temp.item).append(" -> ");
      temp = temp.next;
    }
    s.append(temp.item).append(" ⤾");
    return s.toString();
  }

}
