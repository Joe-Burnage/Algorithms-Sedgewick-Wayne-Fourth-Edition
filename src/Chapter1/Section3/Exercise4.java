package Chapter1.Section3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
/*
Write a stack client Parentheses that reads in a text stream from standard input
and uses a stack to determine whether its parentheses are properly balanced. For
example, your program should print true for [()]{}{[()()]()} and false for [(]).
*/
public class Exercise4
{
  public static void main()
  {
    StdOut.println("[()]{}{[()()]()}   " + isBalanced("[()]{}{[()()]()}"));
    StdOut.println("[(])               " + isBalanced("[(])"));
    while (StdIn.hasNextLine())
    {
      String line = StdIn.readLine();
      StdOut.printf("%-19s" + isBalanced(line), line);
    }
  }

  private static boolean isBalanced(String s)
  {
    if (s.length() % 2 != 0) return false;
    Stack<Character> temp = new Stack<>();
    for (int i = 0; i < s.length(); i++)
    {
      if ("()[]{}".indexOf((s.charAt(i))) == -1) return false;
      if ("([{".indexOf(s.charAt(i)) != -1) temp.push(s.charAt(i));
      else if (temp.isEmpty()) return false;
      else if (')' == s.charAt(i) && temp.pop() != '(') return false;
      else if (']' == s.charAt(i) && temp.pop() != '[') return false;
      else if ('}' == s.charAt(i) && temp.pop() != '{') return false;
    }
    return temp.isEmpty();
  }
}
