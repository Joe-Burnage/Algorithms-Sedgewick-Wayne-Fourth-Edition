package Chapter1.Section3;

import edu.princeton.cs.algs4.StdOut;

/*
Write a method find() that takes a linked list and a string key as arguments
and returns true if some node in the list has key as its item field,
false otherwise.
*/
public class Exercise21
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
    StdOut.println("List:      " + test);
    StdOut.println("find(be):  " + find(test, "be"));
    StdOut.println("find(bet): " + find(test, "bet"));
  }

  static boolean find(LinkedList<String> list, String key)
  {
    for (String s : list)
      if (s.equals(key)) return true;
    return false;
  }
}
