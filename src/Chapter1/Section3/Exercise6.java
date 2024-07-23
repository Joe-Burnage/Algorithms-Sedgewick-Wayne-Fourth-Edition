package Chapter1.Section3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/*
What does the following code fragment do to the queue q?
Stack<String> stack = new Stack<String>();
while (!q.isEmpty())
  stack.push(q.dequeue());
while (!stack.isEmpty())
  q.enqueue(stack.pop());

Answer:
The code fragment reverses the queue.
*/
public class Exercise6
{
  public static void main()
  {
    Queue<String> q = new Queue<>();
    q.enqueue("1");
    q.enqueue("2");
    q.enqueue("3");
    q.enqueue("4");
    Stack<String> stack = new Stack<>();
    while (!q.isEmpty())
      stack.push(q.dequeue());
    while (!stack.isEmpty())
      q.enqueue(stack.pop());
    StdOut.println(q);
  }
}
