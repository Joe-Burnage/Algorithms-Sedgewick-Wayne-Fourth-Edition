package Chapter1.Section3;

/*
Write a function that takes the first Node in a linked list as
argument and (destructively) reverses the list, returning the
first Node in the result.
*/
public class Exercise30
{
  public static void main()
  {

  }
  public static Node reverseIterate(Node x)
  {
    Node first   = x;
    Node reverse = null;
    while (first != null)
    {
      Node second = first.next;
      first.next = reverse;
      reverse = first;
      first = second;
    }
    return first;
  }

  public static Node reverseRecursive(Node first)
  {
    if (first == null) return null;
    if (first.next == null) return first;
    Node second = first.next;
    Node rest = reverseRecursive(second);
    second.next = first;
    first.next = null;
    return rest;
  }
}
