package Chapter1.Section4;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/*
Deque with a stack and a steque. Implement a deque with a stack and a steque
(see Exercise 1.3.32) so that each deque operation takes a constant amortized number
of stack and steque operations.
*/
public class Exercise30
{
  public static void main()
  {
    StackStequeDeque deque = new StackStequeDeque();
    deque.pushLeft(1);
    deque.pushLeft(2);
    deque.pushLeft(3);
    deque.pushRight(4);
    deque.pushRight(5);
    deque.pushRight(6);
    StdOut.println(deque.popLeft());
    StdOut.println(deque.popRight());
    StdOut.println(deque.popLeft());
    StdOut.println(deque.popRight());
    StdOut.println(deque.popRight());
    StdOut.println(deque.popRight());
  }
}

class StackStequeDeque<Item>
{
  Stack          stack  = new Stack();
  TwoStackSteque steque = new TwoStackSteque();

  public boolean isEmpty() { return stack.isEmpty() && steque.isEmpty(); }

  public int size() { return stack.size() + steque.size(); }

  public void pushLeft(Item item)
  {
    stack.push(item);
  }

  public void pushRight(Item item)
  {
    steque.push(item);
  }

  public Item popLeft()
  {
    if (isEmpty()) throw new ArrayIndexOutOfBoundsException();
    if (!stack.isEmpty()) return (Item) stack.pop();
    while (!steque.isEmpty())
      stack.push(steque.pop());
    return (Item) stack.pop();
  }

  public Item popRight()
  {
    if (isEmpty()) throw new ArrayIndexOutOfBoundsException();
    if (steque.isEmpty())
      while (!stack.isEmpty()) steque.push(stack.pop());
    return (Item) steque.pop();
  }

}
