package Chapter1.Section3;

import edu.princeton.cs.algs4.StdOut;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/*
Write an iterable Stack client that has a static method copy() that
takes a stack of strings as argument and returns a copy of the stack.
Note: This ability is a prime example of the value of having an iterator,
because it allows development of such functionality without changing the basic API.
*/
public class Exercise12
{
  public static void main()
  {
    LinkedStack<String> a = new LinkedStack<>();
    a.push("1");
    a.push("2");
    a.push("3");
    a.push("4");
    LinkedStack<String> b = a.copy();
    StdOut.println("a:            " + a);
    StdOut.println("b = a.copy(): " + b);
    StdOut.println("a.pop():      " + a.pop());
    StdOut.println("a:            " + a);
    StdOut.println("b:            " + b);
  }
}

class LinkedStack<Item> implements Iterable<Item>
{
  private Node first;
  private int  N;

  public LinkedStack<Item> copy()
  {
    LinkedStack<Item> temp = new LinkedStack<>();
    LinkedStack<Item> out  = new LinkedStack<>();
    for (Item i : this) temp.push(i);
    for (Item i : temp) out.push(i);
    return out;
  }

  public Node getFirst()
  { return first; }

  public boolean isEmpty() { return N == 0; }

  public int size() { return N; }

  public void push(Item item)
  {
    Node newfirst = new Node();
    newfirst.item = item;
    newfirst.next = first;
    first = newfirst;
    N++;
  }

  public Item pop()
  {
    Item item = (Item) first.item;
    first = first.next;
    N--;
    return item;
  }

  public @NotNull Iterator<Item> iterator()
  {
    return new Iterator<>()
    {
      private Node temp = first;
      private int  i    = N;

      @Override
      public boolean hasNext()
      { return i != 0; }

      @Override
      public Item next()
      {
        Item item = (Item) temp.item;
        temp = temp.next;
        i--;
        return item;
      }
    };
  }

  @Override
  public String toString()
  {
    StringBuilder s    = new StringBuilder();
    Node          temp = first;
    while (temp.next != null)
    {
      s.append(temp.item).append(" -> ");
      temp = temp.next;
    }
    s.append(temp.item);
    return s.toString();
  }

}
