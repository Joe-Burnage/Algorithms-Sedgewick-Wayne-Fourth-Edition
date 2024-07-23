package Chapter1.Section3;

import edu.princeton.cs.algs4.StdOut;

/*
Catenable queues, stacks, or steques. Add an extra operation catenation that (de-
structively) concatenates two queues, stacks, or steques (see Exercise 1.3.32). Hint : Use
a circular linked list, maintaining a pointer to the last item.
*/

public class Exercise47
{
  public static void main()
  {
    Catenable a = new Catenable();
    Catenable b = new Catenable();
    a.enqueue(1);
    a.enqueue(2);
    b.enqueue(3);
    b.enqueue(4);
    StdOut.println("a: " + a);
    StdOut.println("b: " + b);
    StdOut.println("a.catenation(b)");

    a.catenation(b);
    StdOut.println("a: " + a);
  }
}

class Catenable<Item>
{
  //Node class and last made public for use in Exercise 37
  public  Node last;
  private int  N;

  public void catenation(Catenable b)
  {
    Node first_a = last.next;
    Node last_a = last;
    Node first_b = b.last.next;
    last = b.last;
    last.next = first_a;
    last_a.next = first_b;
  }

  public Catenable(){}


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
    Item item = (Item) last.next.item;
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