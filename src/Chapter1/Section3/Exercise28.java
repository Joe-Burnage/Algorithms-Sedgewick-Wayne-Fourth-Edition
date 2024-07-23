package Chapter1.Section3;

import edu.princeton.cs.algs4.StdOut;

/*
Develop a recursive solution to the previous question.
*/
public class Exercise28
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
    if (head.item == null) return 0;
    return max(head, 0);
  }

  private static int max(Node<Integer> node, int max)
  {
    if (node == null) return max;
    return max(node.next, Math.max(max, node.item));
  }

}
