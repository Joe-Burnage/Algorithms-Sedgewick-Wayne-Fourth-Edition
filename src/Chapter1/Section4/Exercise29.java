package Chapter1.Section4;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/*
Steque with two stacks. Implement a steque with two stacks so that each steque
operation (see Exercise 1.3.32) takes a constant amortized number of stack operations.
*/
public class Exercise29
{
  public static void main()
  {
    TwoStackSteque steque = new TwoStackSteque();
    steque.push(1);
    steque.push(2);
    steque.push(3);
    steque.push(4);
    steque.enqueue(5);
    steque.enqueue(6);
    while (!steque.isEmpty())
      StdOut.println(steque.pop());
  }
}

class TwoStackSteque<Item>
{
  private final Stack head = new Stack();
  private final Stack tail = new Stack();

  public int size() { return head.size() + tail.size(); }

  public boolean isEmpty() { return head.isEmpty() && tail.isEmpty(); }

  public void push(Item item) { head.push(item); }

  public Item pop() {
    if (!head.isEmpty()) return (Item) head.pop();
    if (tail.isEmpty()) throw new ArrayIndexOutOfBoundsException();
    while (!tail.isEmpty()) head.push(tail.pop());
    return (Item) head.pop();
  }

  public void enqueue(Item item) { tail.push(item); }


}