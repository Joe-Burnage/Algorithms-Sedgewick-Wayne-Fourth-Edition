package Chapter1.Section3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/*
Write a filter InfixToPostfix that converts an arithmetic expression from
infix to postfix.
*/
public class Exercise10
{
  public static void main()
  {
    StdOut.println("Infix:   ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )");
    StdOut.println("Postfix: " + infixToPostfix("( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )"));
  }

  public static String infixToPostfix(String expression)
  {
    Stack<Character> operators = new Stack<>();
    StringBuilder    output    = new StringBuilder();
    char[]           in        = expression.toCharArray();
    for (char c : in)
    {
      if (c == ' ') continue;
      if (Character.isDigit(c)) output.append(" ").append(c);
      else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(') operators.push(c);
      else if (c == ')'){
        while (operators.peek() != '(') output.append(" ").append(operators.pop());
        operators.pop();
      }
    }
    return output.toString().strip();
  }
}
