package Chapter1.Section3;

import edu.princeton.cs.algs4.StdOut;
/*
Write a method insertAfter() that takes two linked-list
Node arguments and inserts the second after the first on
its list (and does nothing if either argument is null).

Method contained within LinkedList class
*/
public class Exercise25
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

    //Test for exercise 25
    StdOut.println("List:                              " + test);
    Node newNode = new Node();
    newNode.item = "TEST";
    test.insertAfter(test.getHead(), newNode);
    StdOut.println("List after adding TEST after head: " + test);

  }
}
