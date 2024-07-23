package Chapter1.Section3;

/*
Text editor buffer. Develop a data type for a buffer in a text
editor that implements the following API:

public class Buffer

      Buffer()        create an empty buffer
void  insert(char c)  insert c at the cursor position
char  delete()        delete and return the character at the cursor
void  left(int k)     move the cursor k positions to the left
void  right(int k)    move the cursor k positions to the right
int   size()          number of characters in the buffer


Hint : Use two stacks.
*/

import edu.princeton.cs.algs4.StdOut;

public class Exercise44
{
  public static void main()
  {
    Buffer buffer = new Buffer();
    buffer.insert('b');
    StdOut.println("insert('b'):" + buffer);
    buffer.insert('u');
    StdOut.println("insert('u'):" + buffer);
    buffer.insert('f');
    StdOut.println("insert('f'):" + buffer);
    buffer.insert('e');
    StdOut.println("insert('e'):" + buffer);
    buffer.insert('e');
    StdOut.println("insert('e'):" + buffer);
    buffer.insert('r');
    StdOut.println("insert('r'):" + buffer);
    buffer.left(3);
    buffer.insert('f');
    StdOut.println("insert('f'):" + buffer);
    StdOut.println("size():      " + buffer.size());
    StdOut.println("left(3):    " + buffer);
    buffer.right(1);
    StdOut.println("delete():    " + buffer.delete());
    StdOut.println("buffer:     " + buffer);
    StdOut.println("size():      " + buffer.size());
    buffer.right(2);
    StdOut.println("right(2):   " + buffer);
  }
}

class Buffer<Item>
{
  private final Stack leftStack  = new Stack();
  private final Stack rightStack = new Stack();
  private       int   size;

  public int size()
  { return size; }

  public void insert(Item item)
  {
    leftStack.push(item);
    size++;
  }

  public Item delete()
  {
    if (leftStack.isEmpty()) throw new ArrayIndexOutOfBoundsException();
    size--;
    return (Item) leftStack.pop();
  }

  public void left(int k)
  {
    if (leftStack.size() < k) throw new ArrayIndexOutOfBoundsException();
    for (int i = 0; i < k; i++)
      rightStack.push(leftStack.pop());
  }

  public void right(int k)
  {
    if (rightStack.size() < k) throw new ArrayIndexOutOfBoundsException();
    for (int i = 0; i < k; i++)
    {
      leftStack.push(rightStack.pop());
    }
  }

  public String toString()
  {
    String        s = leftStack.toString();
    StringBuilder t = new StringBuilder();
    for (int i = 0; i < s.length(); i++)
    {
      t.insert(0, s.charAt(i));
    }
    return t + " █ " + rightStack;
  }
}
