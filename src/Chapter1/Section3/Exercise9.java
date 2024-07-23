package Chapter1.Section3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
Write a program that takes from standard input an expression without left
parentheses and prints the equivalent infix expression with the parentheses
inserted. For example, given the input:
    1 + 2 ) *     3 - 4 ) *   5 - 6 ) ) )
your program should print
( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )
*/
public class Exercise9
{
  public static void main()
  {
    StdOut.println(addLeftParentheses("1 + 2 ) *     3 - 4 ) *   5 - 6 ) ) )"));
    StdOut.println("Insert expression:");
    StdOut.println(addLeftParentheses(StdIn.readLine()));
  }
  public static String addLeftParentheses(String expression)
  {
    char[]        in        = expression.toCharArray();
    Stack<String> operands  = new Stack<>();
    Stack<String> operators = new Stack<>();
    for (char c : in)
    {
      if (c == ' ') continue;
      if (Character.isDigit(c)) operands.push(String.valueOf(c));
      else if (c == '+' || c == '-' || c == '*' || c == '/')
        operators.push(String.valueOf(c));
      else if (c == ')') {
        String operand2 = operands.pop();
        String operand1 = operands.pop();
        String operator = operators.pop();
        String subExpression = String.format("( %s %s %s )", operand1, operator, operand2);
        operands.push(subExpression);
      }
    }
    return operands.pop();
  }
}
