package Chapter1.Section3;


import edu.princeton.cs.algs4.StdOut;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/*
Implement a nested class DoubleNode for building doubly-linked lists, where
each node contains a reference to the item preceding it and the item following it in the
list (null if there is no such item). Then implement static methods for the following
tasks: insert at the beginning, insert at the end, remove from the beginning, remove
from the end, insert before a given node, insert after a given node, and remove a given
node.

Static and dynamic methods included for most tasks.
*/

public class DoublyLinkedList<Item> implements Iterable<Item>
{
  private DoubleNode<Item> head;
  private DoubleNode<Item> tail;
  private int              N;

  public static class DoubleNode<Item>
  {
    Item             item;
    DoubleNode<Item> next;
    DoubleNode<Item> prev;

    DoubleNode(Item item)
    {
      this.item = item;
    }

    DoubleNode()
    { }
  }

  public boolean isEmpty()
  { return N == 0; }

  public int size()
  { return N; }

  public DoubleNode getHead()
  { return head; }

  public DoubleNode getTail()
  { return tail; }

  public static <Item> void insertHead(DoublyLinkedList list, Item item)
  {
    DoubleNode node = new DoubleNode(item);
    if (list.isEmpty()) list.tail = node;
    else
    {
      node.next = list.head;
      list.head.prev = node;
    }
    list.head = node;
    list.N++;
  }

  public void insertHead(Item item)
  { insertHead(this, item); }

  public static <Item> void insertTail(DoublyLinkedList list, Item item)
  {
    DoubleNode node = new DoubleNode(item);
    if (list.isEmpty()) list.head = node;
    else
    {
      list.tail.next = node;
      node.prev = list.tail;
    }
    list.tail = node;
    list.N++;
  }

  public void insertTail(Item item)
  {
    insertTail(this, item);
  }

  public static <Item> Item popHead(DoublyLinkedList list)
  {
    if (list.isEmpty()) throw new RuntimeException("Can't remove element from empty list");
    Item item = (Item) list.head.item;
    if (list.size() == 1)
    {
      list.head = null;
      list.tail = null;
    } else
    {
      list.head = list.head.next;
      list.head.prev = null;
    }
    list.N--;
    return item;
  }

  public Item popHead()
  { return popHead(this); }

  public static <Item> Item popTail(DoublyLinkedList list)
  {
    if (list.isEmpty()) throw new RuntimeException("Can't remove element from empty list");
    Item item = (Item) list.tail.item;
    if (list.size() == 1)
    {
      list.head = null;
      list.tail = null;
    } else
    {
      list.tail = list.tail.prev;
      list.tail.next = null;
    }
    list.N--;
    return item;
  }

  public Item popTail()
  { return popTail(this); }

  public static <Item> void insertBeforeNode(DoublyLinkedList list, Item item, DoubleNode node)
  {
    DoubleNode newNode = new DoubleNode(item);
    if (node.prev == null)
    {
      node.prev = newNode;
      newNode.next = node;
      list.head = newNode;
      list.N++;
      return;
    }
    DoubleNode temp = node.prev;
    node.prev = newNode;
    temp.next = newNode;
    newNode.prev = temp;
    newNode.next = node;
    list.N++;
  }

  public void insertBeforeNode(Item item, DoubleNode node)
  { insertBeforeNode(this, item, node); }

  //Zero index
  public static <Item> void insertBeforeIndex(DoublyLinkedList list, Item item, int index)
  {
    if (list.N - 1 < index) throw new RuntimeException("Index out of bounds.");
    DoubleNode temp = list.head;
    for (int i = 0; i < index; i++)
      temp = temp.next;
    insertBeforeNode(list, item, temp);
  }

  public void insertBeforeIndex(Item item, int index)
  { insertBeforeIndex(this, item, index); }

  public static <Item> void insertAfterNode(DoublyLinkedList list, Item item, DoubleNode node)
  {
    DoubleNode newNode = new DoubleNode(item);
    if (node.next == null)
    {
      node.next = newNode;
      newNode.prev = node;
      list.tail = newNode;
      list.N++;
      return;
    }
    DoubleNode temp = node.next;
    node.next = newNode;
    temp.prev = newNode;
    newNode.next = temp;
    newNode.prev = node;
    list.N++;
  }

  public void insertAfterNode(Item item, DoubleNode node)
  { insertAfterNode(this, item, node); }

  //Zero index
  public static <Item> void insertAfterIndex(DoublyLinkedList list, Item item, int index)
  {
    if (list.N - 1 < index) throw new RuntimeException("Index out of bounds");
    DoubleNode temp = list.head;
    for (int i = 0; i < index; i++)
      temp = temp.next;
    insertAfterNode(list, item, temp);
  }

  public void insertAfterIndex(Item item, int index)
  { insertAfterIndex(this, item, index); }

  public Item popNode(DoubleNode node)
  {
    if (isEmpty()) throw new RuntimeException("Cannot remove element from empty list.");
    Item item = (Item) node.item;
    N--;
    if (node.next == null)
    {
      node.prev.next = null;
      return item;
    }
    if (node.prev == null)
    {
      node.next.prev = null;
      return item;
    }
    DoubleNode prev = node.prev;
    DoubleNode next = node.next;
    prev.next = next;
    next.prev = prev;
    return item;
  }

  public Item popIndex(int index)
  {
    if (N - 1 < index) throw new RuntimeException("Index out of bounds");
    if (index == 0) popHead();
    if (index == N - 1) popTail();
    DoubleNode temp = head;
    for (int i = 0; i < index; i++)
      temp = temp.next;
    return popNode(temp);
  }

  @Override
  public String toString()
  {
    StringBuilder s    = new StringBuilder();
    DoubleNode    temp = head;
    while (temp.next != null)
    {
      s.append(temp.item).append(" <-> ");
      temp = temp.next;
    }
    s.append(temp.item);
    return s.toString();
  }

  public @NotNull Iterator<Item> iterator()
  {
    return new Iterator<>()
    {
      DoubleNode<Item> temp = head;

      @Override
      public boolean hasNext()
      { return temp != null; }

      @Override
      public Item next()
      {
        Item item = temp.item;
        temp = temp.next;
        return item;
      }
    };
  }

  public static void main()
  {
    DoublyLinkedList<String> list = new DoublyLinkedList<>();
    list.insertTail("B");
    StdOut.println("Add B at tail:        " + list);
    list.insertTail("C");
    StdOut.println("Add C at tail:        " + list);
    insertTail(list, "D");
    StdOut.println("Add D at tail:        " + list);
    list.insertHead("A");
    StdOut.println("Add A at head:        " + list);
    popHead(list);
    StdOut.println("Remove head:          " + list);
    popTail(list);
    StdOut.println("Remove tail:          " + list);
    insertBeforeIndex(list, "A", 0);
    StdOut.println("Add A before index 0: " + list);
    insertAfterIndex(list, "D", 2);
    StdOut.println("Add A after index 3:  " + list);
    StdOut.println("Pop index 1:          " + list.popIndex(1));
    StdOut.println("List after pop:       " + list);
    list.insertAfterIndex("B", 0);
    StdOut.println("Add B after index 0:  " + list);
  }

}
