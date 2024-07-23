package Chapter1.Section3;

import edu.princeton.cs.algs4.StdOut;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
Copy a stack. Create a new constructor for the linked-list implementation of
Stack so that
Stack<Item> t = new Stack<Item>(s);
makes t a reference to a new and independent copy of the stack s.
*/
public class Exercise42
{
  public static void main()
  {
    Stack q = new Stack();
    for (int i = 0; i < 5; i++)
      q.push(i + 1);
    StdOut.println("q:       " + q);
    Stack r = new Stack(q);
    StdOut.println("q:       " + q);
    StdOut.println("r:       " + r);
    StdOut.println("q.pop(): " + q.pop());
    StdOut.println("q:       " + q);
    StdOut.println("r:       " + r);
  }
}

class Stack<Item> implements Iterable<Item>
{
  private Node<Item> first;     // top of stack
  private int        n;                // size of the stack

  // helper linked list class
  private static class Node<Item>
  {
    private Item       item;
    private Node<Item> next;
  }

  public Stack()
  {
    first = null;
    n = 0;
  }

  public Stack(Stack s)
  {
    first = null;
    n = 0;
    int i = 0;
    int size = s.size();
    Item[] temp = (Item[]) new Object[size];
    for (Object _ : s)
    {
      temp[i] = (Item) s.pop();
      i++;
    }
    for (int j = size; j > 0; j--)
    {
      s.push(temp[j - 1]);
      this.push(temp[j - 1]);
    }
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
  }

  public Item pop()
  {
    if (isEmpty()) throw new NoSuchElementException("Stack underflow");
    Item item = first.item;        // save item to return
    first = first.next;            // delete first node
    n--;
    return item;                   // return the saved item
  }

  public Item peek()
  {
    if (isEmpty()) throw new NoSuchElementException("Stack underflow");
    return first.item;
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

  // the iterator
  private class LinkedIterator implements Iterator<Item>
  {
    private Node<Item> current;

    public LinkedIterator(Node<Item> first)
    {
      current = first;
    }

    // is there a next item?
    public boolean hasNext()
    {
      return current != null;
    }

    // returns the next item
    public Item next()
    {
      if (!hasNext()) throw new NoSuchElementException();
      Item item = current.item;
      current = current.next;
      return item;
    }
  }
}
