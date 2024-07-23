package Chapter1.Section3;


import edu.princeton.cs.algs4.StdOut;

/*
Write a method delete() that takes an int argument k and deletes the kth
element in a linked list, if it exists.

Functionality included in LinkedList class. This class only tests functionality.
*/
public class Exercise20
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
    StdOut.println("\nInitial list");
    StdOut.println(test);
    StdOut.println("Delete first node");
    test.delete(1);
    StdOut.println(test);
    StdOut.println("Delete third node");
    test.delete(3);
    StdOut.println(test);
  }

}


