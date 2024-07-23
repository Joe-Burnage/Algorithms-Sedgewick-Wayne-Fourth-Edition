package Chapter1.Section3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;
import static Chapter1.Section3.Exercise10.infixToPostfix;

/*
Write a program EvaluatePostfix that takes a postfix expression from standard
input, evaluates it, and prints the value (piping the output of your program from
the previous exercise to this program gives equivalent behavior to Evaluate).
*/
public class Exercise11
{
  public static void main()
  {
    StdOut.println("Infix expression:   ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) ) )");
    StdOut.println("Output:             " + (double) ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) ) );
    String postfix = infixToPostfix("( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )");
    StdOut.println("Postfix expression: " + postfix);
    StdOut.println("Output:             " + evaluatePostfix(postfix));
  }

  public static double evaluatePostfix(String postfix)
  {
    Stack<String> operands        = new Stack<>();
    String[]      postfix_strings = postfix.split(" ");
    for (String s : postfix_strings)
    {
      if (s.matches("[0-9]+")) operands.push(s);
      else
      {
        double d2 = Double.parseDouble(operands.pop());
        double d1 = Double.parseDouble(operands.pop());
        switch (s)
        {
          case "+" -> operands.push(String.valueOf(d1 + d2));
          case "-" -> operands.push(String.valueOf(d1 - d2));
          case "*" -> operands.push(String.valueOf(d1 * d2));
          case "/" -> operands.push(String.valueOf(d1 / d2));
          default -> { }
        }
      }
    }
    return Double.parseDouble(operands.pop());
  }
}

