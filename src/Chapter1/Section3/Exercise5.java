package Chapter1.Section3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/*
What does the following code fragment print when N is 50? Give a high-level
description of what it does when presented with a positive integer N.
Stack<Integer> stack = new Stack<Integer>();
while (N > 0)
{
  stack.push(N % 2);
  N = N / 2;
}
for (int d : stack) StdOut.print(d);
StdOut.println();
Answer:
Prints the binary representation of N
N = 50
Output: 110010
*/
public class Exercise5
{
  public static void main()
  {
    mystery(50);
    mystery(500);
  }

  public static void mystery(int N)
  {
    Stack<Integer> stack = new Stack<>();
    while (N > 0)
    {
      stack.push(N % 2);
      N = N / 2;
    }
    for (int d : stack)
      StdOut.print(d);
    StdOut.println();
  }
}
