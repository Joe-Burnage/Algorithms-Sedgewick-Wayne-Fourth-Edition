package Chapter1.Section3;

import edu.princeton.cs.algs4.StdOut;

/*
Josephus problem. In the Josephus problem from antiquity, N people are in dire
straits and agree to the following strategy to reduce the population. They
arrange themselves in a circle (at positions numbered from 0 to N–1) and proceed around the circle,
eliminating every Mth person until only one person is left. Legend has it that Josephus
figured out where to sit to avoid being eliminated. Write a Queue client Josephus that
takes N and M from the command line and prints out the order in which people are
eliminated (and thus would show Josephus where to sit in the circle).

% java Josephus 7 2
1 3 5 0 4 2 6
*/
public class Exercise37
{
  public static void main()
  {
    StdOut.println("Josephus 7 2:");
    josephus(7, 2);
  }

  public static void josephus(int N, int M)
  {
    CircularLinkedList<Integer> circle = new CircularLinkedList<>();
    for (int i = 0; i < N; i++)
    {
      circle.enqueue(i);
    }
    while (!circle.isEmpty())
    {
      CircularLinkedList<Integer>.Node focus = circle.last;
      for (int i = 0; i < M - 1; i++)
        focus = focus.next;
      circle.last = focus;
      StdOut.print(circle.dequeue() + " ");
    }
  }
}
