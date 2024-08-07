package Chapter1.Section4;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/*
Queue with two stacks. Implement a queue with two stacks so that each queue
operation takes a constant amortized number of stack operations. Hint : If you push
elements onto a stack and then pop them all, they appear in reverse order. If you repeat
this process, they’re now back in order.
*/
public class Exercise27
{
  public static void main()
  {
    TwoStackQueue queue = new TwoStackQueue();
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    StdOut.println(queue.dequeue());
  }
}

class TwoStackQueue<Item>
{
  Stack s1 = new Stack();
  Stack s2 = new Stack();

  private void swapStack(Stack from, Stack to)
  {
    while (!from.isEmpty())
      to.push(from.pop());
  }

  public void enqueue(Item item)
  { s1.push(item); }

  public Item dequeue()
  {
    swapStack(s1, s2);
    Item item = (Item) s2.pop();
    swapStack(s2, s1);
    return item;
  }
}
