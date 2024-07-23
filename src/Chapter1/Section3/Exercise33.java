package Chapter1.Section3;

import edu.princeton.cs.algs4.StdOut;

/*
Deque. A double-ended queue or deque (pronounced “deck”) is like a stack
ora queue but supports adding and removing items at both ends. A deque
stores a collection of items and supports the following API:

public class Deque<Item> implements Iterable<Item>

        Deque()                create an empty deque
boolean isEmpty()              is the deque empty?
int     size()                 number of items in the deque
void    pushLeft(Item item)    add an item to the left end
void    pushRight(Item item)   add an item to the right end
Item    popLeft()              remove an item from the left end
Item    popRight()             remove an item from the right end

Write a class Deque that uses a doubly-linked list to implement this
API and a classResizingArrayDeque that uses a resizing array.

Linked list method implementation code can be found in DoublyLinkedList.java
*/
public class Exercise33
{
  public static void main()
  {
    Deque<Integer> ld = new Deque<>();
    StdOut.println("Linked Deque");
    ld.pushLeft(1);
    StdOut.println("pushLeft(1):  " + ld);
    ld.pushLeft(2);
    StdOut.println("pushLeft(2):  " + ld);
    ld.pushRight(3);
    StdOut.println("pushRight(3): " + ld);
    StdOut.println("popLeft():    " + ld.popLeft());
    StdOut.println("Deque:        " + ld);
    StdOut.println("popRight:     " + ld.popRight());
    StdOut.println("Deque:        " + ld);

    ArrayDeque<Integer> rad = new ArrayDeque<>();
    StdOut.println("\nResizing Array Deque");
    rad.pushLeft(1);
    StdOut.println("pushLeft(1):  " + rad);
    rad.pushLeft(2);
    StdOut.println("pushLeft(2):  " + rad);
    rad.pushRight(3);
    StdOut.println("pushRight(3): " + rad);
    StdOut.println("popLeft():    " + rad.popLeft());
    StdOut.println("Deque:        " + rad);
    StdOut.println("popRight:     " + rad.popRight());
    StdOut.println("Deque:        " + rad);
  }
}

class Deque<Item> extends DoublyLinkedList
{
  public void pushLeft(Item item)
  { insertHead(item); }

  public void pushRight(Item item)
  { insertTail(item); }

  public Item popLeft()
  { return (Item) this.popHead(); }

  public Item popRight()
  { return (Item) this.popTail(); }
}

class ArrayDeque<Item>
{
  private Item[] items = (Item[]) new Object[1];
  private int    N;

  private void resize(int max)
  {
    Item[] s = (Item[]) new Object[max];
    System.arraycopy(items, 0, s, 0, N);
    items = s;
  }

  public boolean isEmpty() { return N == 0; }

  public int size() { return N; }

  public void pushLeft(Item item)
  {
    for (int i = N; i > 0; i--)
      items[i] = items[i - 1];
    items[0] = item;
    N++;
    if (N == items.length) resize(N * 2);
  }

  public void pushRight(Item item)
  {
    items[N++] = item;
    if (N == items.length) resize(N * 2);
  }

  public Item popRight()
  {
    if (isEmpty()) throw new ArrayIndexOutOfBoundsException("Can't dequeue an empty queue.");
    Item item = items[--N];
    if (N == items.length / 4) resize(N * 2);
    return item;
  }

  public Item popLeft()
  {
    if (isEmpty()) throw new ArrayIndexOutOfBoundsException("Can't dequeue an empty queue.");
    Item item = items[0];
    N--;
    for (int i = 0; i < N; i++)
      items[i] = items[i + 1];
    if (N == items.length / 4) resize(N * 2);
    return item;
  }

  public String toString()
  {
    StringBuilder s = new StringBuilder();
    for (int i = 0; i < N - 1; i++)
      s.append(items[i]).append(" <-> ");
    s.append(items[N - 1]);
    return s.toString();
  }
}