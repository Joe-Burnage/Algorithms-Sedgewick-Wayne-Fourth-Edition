package Chapter1.Section3;

import edu.princeton.cs.algs4.StdOut;

/*
Delete kth element. Implement a class that supports the following API:

public class GeneralizedQueue<Item>

         GeneralizedQueue() create an empty queue
boolean  isEmpty() is the queue empty?
void     insert(Item x) add an item
Item     delete(int k) delete and return the kth least recently inserted item

First, develop an implementation that uses an array implementation, and then develop
one that uses a linked-list implementation. Note : the algorithms and data structures
that we introduce in Chapter 3 make it possible to develop an implementation that
can guarantee that both insert() and delete() take time proportional to the logarithm
of the number of items in the queue — see Exercise 3.5.27.
*/
public class Exercise38
{
  public static void main()
  {
    GeneralizedQueueArray array = new GeneralizedQueueArray();
    StdOut.println("Empty array isEmpty:           " + array.isEmpty());
    array.insert(1);
    StdOut.println("Non-empty array isEmpty:       " + array.isEmpty());
    for (int i = 0; i < 5; i++)
      array.insert(i);
    //One index deletion (delete(1) deletes the least recently inserted item)
    StdOut.println("Array:                         " + array);
    StdOut.println("Delete fifth entry from array: " + array.delete(5));
    StdOut.println("Array after deletion:          " + array + "\n\n\n");

    GeneralizedQueueList list = new GeneralizedQueueList();
    StdOut.println("Empty list isEmpty:           " + list.isEmpty());
    list.insert(1);
    StdOut.println("Non-empty list isEmpty:       " + list.isEmpty());
    for (int i = 0; i < 5; i++)
      list.insert(i);
    //One index deletion (delete(1) deletes the least recently inserted item)
    StdOut.println("List:                         " + list);
    StdOut.println("Delete fifth entry from list: " + list.delete(5));
    StdOut.println("List after deletion:          " + list);

  }
}

class GeneralizedQueueArray<Item>
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

  public void insert(Item item)
  {
    items[N++] = item;
    if (N == items.length) resize(N * 2);
  }

  public Item delete(int k)
  {
    if (isEmpty()) throw new ArrayIndexOutOfBoundsException("Can't dequeue an empty queue.");
    if (k > size()) throw new ArrayIndexOutOfBoundsException("k out of bounds");
    Item item = items[k - 1];
    for (int i = k - 1; i < N; i++)
      items[i] = items[i + 1];
    N--;
    if (N == items.length / 4) resize(N * 2);
    return item;
  }

  public String toString()
  {
    StringBuilder s = new StringBuilder();
    for (int i = 0; i < N - 1; i++)
      s.append(items[i]).append(" -> ");
    s.append(items[N - 1]);
    return s.toString();
  }
}

class GeneralizedQueueList<Item>
{
  private Node head;
  private Node tail;
  private int  N;

  public Node<Item> getHead()
  { return head; }

  public int size()
  { return N; }

  public boolean isEmpty()
  { return head == null; }

  public Item delete(int k)
  {
    if (k > N) throw new RuntimeException("k out of bounds");
    N--;
    if (k == 1)
    {
      Item item = (Item) head.item;
      head = head.next;
      return item;
    }
    Node<Item> temp = head;
    for (int i = 2; i < k; i++)
      temp = temp.next;
    Item item = temp.next.item;
    temp.next = temp.next.next;
    return item;
  }

  public void insert(Item item)
  {
    N++;
    if (isEmpty())
    {
      head = new Node();
      head.item = item;
      tail = head;
    } else
    {
      Node newtail = new Node();
      newtail.item = item;
      tail.next = newtail;
      tail = newtail;
    }
  }

  @Override
  public String toString()
  {
    StringBuilder s    = new StringBuilder();
    Node<Item>    temp = head;
    while (temp.next != null)
    {
      s.append(temp.item).append(" -> ");
      temp = temp.next;
    }
    s.append(temp.item);
    return s.toString();
  }
}
