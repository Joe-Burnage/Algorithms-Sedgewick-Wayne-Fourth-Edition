package Chapter1.Section3;

import edu.princeton.cs.algs4.StdOut;

/*
Steque. A stack-ended queue or steque is a data type that supports push, pop, and
enqueue. Articulate an API for this ADT. Develop a linked-list-based implementation.
*/
public class Exercise32
{
  public static void main()
  {
    Steque<Integer> steque = new Steque<>();
    for (int i = 0; i < 5; i++)
    {
      steque.push(i+1);
      StdOut.printf("push(%d):           ", i+1);
      StdOut.println(steque);
    }
    StdOut.printf("steque.pop():      " + steque.pop());
    StdOut.print("\nSteque:            " + steque);
    steque.enqueue(6);
    StdOut.println("\nsteque.enqueue(6): " + steque);
    StdOut.printf("steque.pop():      " + steque.pop());
  }
}
class Steque<Item> extends LinkedStack
{
  public void enqueue(Item item)
  {
    Node temp = getFirst();
    while (temp.next != null)
      temp = temp.next;
    Node node = new Node();
    node.item = item;
    temp.next = node;
  }
}