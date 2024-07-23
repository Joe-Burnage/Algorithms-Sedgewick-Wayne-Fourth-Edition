package Chapter1.Section3;

import edu.princeton.cs.algs4.StdOut;
import org.jetbrains.annotations.NotNull;

/*
Stack generability. Suppose that we have a sequence of intermixed push and
pop operations as with our test stack client, where the integers 0, 1, ..., N-1 in that
order (push directives) are intermixed with N minus signs (pop directives). Devise an
algorithm that determines whether the intermixed sequence causes the stack to underflow.
(You may use only an amount of space independent of N—you cannot store the
integers in a data structure.) Devise a linear-time algorithm that determines whether a
given permutation can be generated as output by our test client (depending on where
the pop directives occur).*/

public class Exercise45
{

  public static void main()
  {
    StdOut.println("Will 1, -, - underflow?:       " + (underflow(new String[] { "1", "-", "-" }) ? "yes":"no"));
    StdOut.println("Will 1, 2, -, - underflow?:    " + (underflow(new String[] { "1", "2", "-", "-" }) ? "yes":"no"));
    StdOut.println("Is 4 3 2 1 0 9 8 7 6 5 valid?: " + (validPermutation(new int[] {4, 3, 2, 1, 0, 9, 8, 7, 6, 5}) ? "yes":"no"));
    StdOut.println("Is 4 6 8 7 5 3 2 9 0 1 valid?: " + (validPermutation(new int[] {4, 6, 8, 7, 5, 3, 2, 9, 0, 1}) ? "yes":"no"));
    StdOut.println("Is 2 5 6 7 4 8 9 3 1 0 valid?: " + (validPermutation(new int[] {2, 5, 6, 7, 4, 8, 9, 3, 1, 0}) ? "yes":"no"));
    StdOut.println("Is 4 3 2 1 0 5 6 7 8 9 valid?: " + (validPermutation(new int[] {4, 3, 2, 1, 0, 5, 6, 7, 8, 9}) ? "yes":"no"));
    StdOut.println("Is 1 2 3 4 5 6 9 8 7 0 valid?: " + (validPermutation(new int[] {1, 2, 3, 4, 5, 6, 9, 8, 7, 0}) ? "yes":"no"));
    StdOut.println("Is 0 4 6 5 3 8 1 7 2 9 valid?: " + (validPermutation(new int[] {0, 4, 6, 5, 3, 8, 1, 7, 2, 9}) ? "yes":"no"));
    StdOut.println("Is 1 4 7 9 8 6 5 3 0 2 valid?: " + (validPermutation(new int[] {1, 4, 7, 9, 8, 6, 5, 3, 0, 2}) ? "yes":"no"));
    StdOut.println("Is 2 1 4 3 6 5 8 7 9 0 valid?: " + (validPermutation(new int[] {2, 1, 4, 3, 6, 5, 8, 7, 9, 0}) ? "yes":"no"));
  }

  public static boolean underflow(String @NotNull [] input)
  {
    int n = 0;
    for (String s : input)
    {
      n = s.equals("-") ? n-1 : n+1;
      if (n < 0) return true;
    }
    return false;
  }

  public static boolean validPermutation(int @NotNull [] input)
  {
    int stackTop = -1;
    Stack stack = new Stack();
    for (int i : input)
    {
      while (stackTop < i)
        stack.push(++stackTop);
      if (!stack.peek().equals(i)) return false;
      stack.pop();
    }
    return true;
  }
}
