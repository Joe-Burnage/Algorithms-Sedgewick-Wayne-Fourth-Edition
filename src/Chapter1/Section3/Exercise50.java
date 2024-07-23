package Chapter1.Section3;

import edu.princeton.cs.algs4.StdOut;
import org.jetbrains.annotations.NotNull;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/*
Fail-fast iterator. Modify the iterator code in Stack to immediately throw a
java.util.ConcurrentModificationException if the client modifies the collection
(via push() or pop()) during iteration?).
 */
public class Exercise50
{
  public static void main()
  {
    FastFailStack stack = new FastFailStack();
    for (int i = 0; i < 5; i++)
      stack.push(i + 1);
    StdOut.println("Exception should be raised for trying to pop during an iteration.");
    for (Object _ : stack)
      stack.pop();
  }
}

class FastFailStack<Item> implements Iterable<Item>
{
  private Node<Item> first;
  private int        n;
  private int        operations;

  private static class Node<Item>
  {
    private Item       item;
    private Node<Item> next;
  }

  public boolean isEmpty()
  {
    return first == null;
  }

  public int size()
  {
    return n;
  }

  public void push(Item item)
  {
    Node<Item> oldfirst = first;
    first = new Node<>();
    first.item = item;
    first.next = oldfirst;
    n++;
    operations++;
  }

  public Item pop()
  {
    if (isEmpty()) throw new NoSuchElementException("Stack underflow");
    Item item = first.item;        // save item to return
    first = first.next;            // delete first node
    n--;
    operations++;
    return item;                   // return the saved item
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
    return new LinkedIterator(first, operations);
  }

  // the iterator
  private class LinkedIterator implements Iterator<Item>
  {
    private Node<Item> current;
    int counter;

    public LinkedIterator(Node<Item> first, int operations)
    {
      current = first;
      counter = operations;
    }

    public boolean hasNext()
    {
      if (counter != operations) throw new ConcurrentModificationException();
      return current != null;
    }

    // returns the next item
    public Item next()
    {
      if (counter != operations) throw new ConcurrentModificationException();
      if (!hasNext()) throw new NoSuchElementException();
      Item item = current.item;
      current = current.next;
      return item;
    }
  }
}

