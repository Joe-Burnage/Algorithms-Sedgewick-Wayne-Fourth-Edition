package Chapter1.Section3;

import edu.princeton.cs.algs4.StdOut;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class LinkedList<Item> implements Iterable<Item>
{
  private Node head;
  private Node tail;
  private int  N;

  public Node getHead()
  { return head; }

  public void setHead(Node node)
  {
    node.next = head;
    head = node;
  }

  public boolean isEmpty()
  { return head == null; }

  public int size()
  { return N; }

  public void removeAfter(Node n)
  {
    if (n == null) return;
    if (n.next == null) return;
    n.next = n.next.next;
  }

  public void insertAfter(Node a, Node b)
  {
    if (a == null || b == null) return;
    b.next = a.next;
    a.next = b;
  }

  public void delete(int k)
  {
    if (k > N) return;
    N--;
    if (k == 1)
    {
      head = head.next;
      return;
    }
    Node temp = head;
    for (int i = 2; i < k; i++)
      temp = temp.next;
    temp.next = temp.next.next;
  }

  public boolean find(Item key)
  {
    for (Item item : this)
      if (item.equals(key)) return true;
    return false;
  }

  public void add(Item item)
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

  public void remove(Item key)
  {
    while (head.item.equals(key)) head = head.next;
    Node temp = head;
    Node prev;
    while (temp.next != null)
    {
      prev = temp;
      temp = temp.next;
      if (temp.item.equals(key))
        prev.next = temp.next;
    }
  }

  @Override
  public String toString()
  {
    StringBuilder s    = new StringBuilder();
    Node          temp = head;
    while (temp.next != null)
    {
      s.append(temp.item).append(" -> ");
      temp = temp.next;
    }
    s.append(temp.item);
    return s.toString();
  }

  @Override
  public @NotNull Iterator<Item> iterator()
  {
    return new Iterator<>()
    {
      Node temp = head;

      @Override
      public boolean hasNext()
      { return temp != null; }

      @Override
      public Item next()
      {
        Item item = (Item) temp.item;
        temp = temp.next;
        return item;
      }
    };
  }

  public static void main()
  {
    LinkedList test = new LinkedList();
    test.add("to");
    test.add("be");
    test.add("or");
    test.add("not");
    test.add("to");
    test.add("be");

    //Test for exercise 24
    StdOut.println("List before removal:\n" + test);
    test.removeAfter(test.getHead().next);
    StdOut.println("List after removing element after element after head (third element):\n" + test);
    StdOut.println();

    LinkedList test2 = new LinkedList();
    test2.add("to");
    test2.add("be");
    test2.add("or");
    test2.add("not");
    test2.add("to");
    test2.add("be");
    //Test for exercise 25
    StdOut.println("List:                              " + test2);
    Node newNode = new Node();
    newNode.item = "TEST";
    test2.insertAfter(test2.getHead(), newNode);
    StdOut.println("List after adding TEST after head: " + test2);
    StdOut.println();

    LinkedList test3 = new LinkedList();
    test3.add("to");
    test3.add("be");
    test3.add("or");
    test3.add("not");
    test3.add("to");
    test3.add("be");
    //Test for exercise 26
    StdOut.println("List:                                      " + test3);
    test3.remove("be");
    StdOut.println("List after removing all instances of 'be': " + test3);

  }
}
