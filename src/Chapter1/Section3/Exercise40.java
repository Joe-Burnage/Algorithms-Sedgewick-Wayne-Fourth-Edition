package Chapter1.Section3;


import edu.princeton.cs.algs4.StdOut;

/*
Move-to-front. Read in a sequence of characters from standard input and
maintain the characters in a linked list with no duplicates. When you read in a
previously unseen character, insert it at the front of the list. When you read in a duplicate
character, delete it from the list and reinsert it at the beginning. Name your program
MoveToFront: it implements the well-known move-to-front strategy, which is useful for
caching, data compression, and many other applications where items that have been
recently accessed are more likely to be reaccessed.
*/
public class Exercise40
{
  public static void main()
  {
    MoveToFront test = new MoveToFront();
    test.addToFront('a');
    test.addToFront('b');
    test.addToFront('c');
    test.addToFront('d');
    StdOut.println(test);
    test.addToFront('a');
    StdOut.println(test);
  }
}

class MoveToFront<Character> extends LinkedList
{
  public void pushHead(Character c)
  {
    Node newHead = new Node();
    newHead.item = c;
    setHead(newHead);
  }
  public void addToFront(Character c)
  {
    for (Object i : this)
    {
      if (i.equals(c))
      {
        remove(i);
        break;
      }
    }
    pushHead(c);
  }
}

