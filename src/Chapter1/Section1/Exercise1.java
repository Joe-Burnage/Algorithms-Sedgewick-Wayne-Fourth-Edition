package Chapter1.Section1;

import edu.princeton.cs.algs4.StdOut;
/*
Give the value of each of the following expressions:
a. ( 0 + 15 ) / 2
b. 2.0e-6 * 100000000.1
c. true && false || true && true
*/
public class Exercise1
{
  public static void main(String[] args)
  {
    //Expression (0 + 15) / 2
    StdOut.print("a)\nInput:    (0 + 15) / 2)\nExpected: 7\nActual:   ");
    StdOut.println((0 + 15) / 2);

    //Expression 2.0e-6 * 100000000.1
    StdOut.print("b)\nInput:    2.0e-6 * 100000000.1\nExpected: 200.0000002\nActual:   ");
    StdOut.println(2.0e-6 * 100000000.1);

    //Expression true && false || true && true
    StdOut.print("c)\nInput:    true && false || true && true\nExpected: true\nActual:   ");
    StdOut.println(true && false || true && true);
  }
}
