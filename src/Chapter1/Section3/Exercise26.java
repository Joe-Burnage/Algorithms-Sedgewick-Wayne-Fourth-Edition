package Chapter1.Section3;

/*
Write a method remove() that takes a linked list and a string
key as arguments and removes all nodes in the list
that have key as its item field.

Method contained within LinkedList class*/

import edu.princeton.cs.algs4.StdOut;

public class Exercise26
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

    //Test for exercise 26
    StdOut.println("List:                                      " + test);
    test.remove("be");
    StdOut.println("List after removing all instances of 'be': " + test);
  }
}
