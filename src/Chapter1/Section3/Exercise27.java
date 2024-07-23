package Chapter1.Section3;

import edu.princeton.cs.algs4.StdOut;

/*
Write a method max() that takes a reference to the first node in a linked list as
argument and returns the value of the maximum key in the list. Assume that all keys are
positive integers, and return 0 if the list is empty.
*/
public class Exercise27
{
  public static void main()
  {
    LinkedList<Integer> test = new LinkedList<>();
    test.add(5);
    test.add(10);
    test.add(50);
    test.add(2);
    test.add(100);
    StdOut.println("List:        " + test);
    StdOut.println("Max element: " + max(test.getHead()));
  }

  public static int max(Node<Integer> head)
  {
    int max = 0;
    if (head.item == null) return 0;
    while (head != null)
    {
      if (head.item > max) max = head.item;
      head = head.next;
    }
    return max;
  }
}
