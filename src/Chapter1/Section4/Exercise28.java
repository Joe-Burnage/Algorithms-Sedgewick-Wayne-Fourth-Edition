package Chapter1.Section4;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/*
Stack with a queue. Implement a stack with a single queue so that each stack
operations takes a linear number of queue operations. Hint : To delete an item, get all
of the elements on the queue one at a time, and put them at the end, except for the last
one which you should delete and return. (This solution is admittedly very inefficient.)
*/
public class Exercise28
{
  public static void main()
  {
    QueueStack stack = new QueueStack();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    StdOut.println(stack.pop());
  }
}

class QueueStack<Item>
{
  Queue q = new Queue();

  public void push(Item item)
  { q.enqueue(item); }

  public Item pop()
  {
    int size = q.size();
    for (int i = 0; i < size - 1; i++)
      q.enqueue(q.dequeue());
    return (Item) q.dequeue();
  }
}