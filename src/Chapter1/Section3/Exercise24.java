package Chapter1.Section3;

import edu.princeton.cs.algs4.StdOut;
/*
Write a method removeAfter() that takes a linked-list Node
as argument and removes the node following the given one
(and does nothing if the argument or the next field in the
argument node is null).

Method contained within LinkedList class
*/
public class Exercise24
{
  public static void main()
  {
    LinkedList<String> test = new LinkedList<>();
    test.add("to");
    test.add("be");
    test.add("or");
    test.add("not");
    test.add("to");
    test.add("be");

    //Test for exercise 24
    StdOut.println("List before removal:\n" + test);
    test.removeAfter(test.getHead().next);
    StdOut.println("List after removing element after element after head (third element):\n" + test);

  }
}
