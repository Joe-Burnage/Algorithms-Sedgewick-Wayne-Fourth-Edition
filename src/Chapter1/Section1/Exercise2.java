package Chapter1.Section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise2
{
  public static void main(String[] args)
  {
    double expr1 = (1 + 2.236) / 2;
    StdOut.print("a)\nInput: (1 + 2.236) / 2\nExpected: 1.618, type: double\nActual:   ");
    StdOut.println(expr1 + ", type: " + ((Object) expr1).getClass().getSimpleName());

    double expr2 = 1 + 2 + 3 + 4.0;
    StdOut.print("b)\nInput: 1 + 2 + 3 + 4.0\nExpected: 10.0, type: double\nActual:   ");
    StdOut.println(expr2 + ", type: " + ((Object) expr2).getClass().getSimpleName());

    boolean expr3 = 4.1 >= 4;
    StdOut.print("c)\nInput: 4.1 >= 4\nExpected: true, type: boolean\nActual:   ");
    StdOut.println(expr3 + ", type: " + ((Object) expr3).getClass().getSimpleName());

    String expr4 = 1 + 2 + "3";
    StdOut.print("d)\nInput: 1 + 2 + \"3\"\nExpected: 33, type: String\nActual:   ");
    StdOut.println(expr4 + ", type: " + ((Object) expr4).getClass().getSimpleName());
  }
}