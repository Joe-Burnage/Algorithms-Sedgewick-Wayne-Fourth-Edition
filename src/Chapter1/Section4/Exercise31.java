package Chapter1.Section4;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/*
Deque with three stacks. Implement a deque with three stacks so that each
deque operation takes a constant amortized number of stack operations.
*/
public class Exercise31
{
  public static void main()
  {
    ThreeStackDeque deque = new ThreeStackDeque();
    deque.pushLeft(1);
    deque.pushRight(2);
    deque.pushLeft(3);
    deque.pushRight(4);
    deque.pushLeft(5);
    deque.pushRight(6);
    StdOut.println(deque.popLeft());
    StdOut.println(deque.popLeft());
    StdOut.println(deque.popRight());
    StdOut.println(deque.popLeft());
    StdOut.println(deque.popLeft());
    StdOut.println(deque.popLeft());
  }
}

class ThreeStackDeque<Item>
{
  Stack head = new Stack();
  Stack mid = new Stack();
  Stack tail = new Stack();

  public void pushLeft(Item item) { head.push(item); }

  public void pushRight(Item item) { tail.push(item); }

  public Item popLeft()
  {
    if (head.isEmpty()) balance(tail, head);
    return (Item) head.pop();
  }

  public Item popRight()
  {
    if (tail.isEmpty()) balance(head, tail);
    return (Item) tail.pop();
  }

  private void balance(Stack full, Stack empty)
  {
    int halfSize = full.size() / 2;
    for (int i = 0; i < halfSize; i++)
      mid.push(full.pop());
    while (!full.isEmpty()) empty.push(full.pop());
    while (!mid.isEmpty()) full.push(mid.pop());
  }
}
