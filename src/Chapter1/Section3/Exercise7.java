package Chapter1.Section3;

import edu.princeton.cs.algs4.StdOut;

/*
Add a method peek() to Stack that returns the most recently inserted item on
the stack (without popping it).
*/
public class Exercise7
{
  public static void main()
  {
    PeekStack<Integer> test = new PeekStack<>(5);
    test.push(9);
    StdOut.println("Push 9 to stack and peek: " + test.peek());
    StdOut.println("Size of stack after peek: " + test.size());
  }
}

class PeekStack<Item>
{
  Item[] stack;
  private int N;

  public PeekStack(int size)
  { stack = (Item[]) new Object[size]; }

  public Item peek() { return stack[N - 1]; }

  public boolean isEmpty() { return N == 0; }

  public int size() { return N; }

  public void push(Item item)
  { stack[N++] = item; }

  public Item pop()
  { return stack[--N]; }
}
