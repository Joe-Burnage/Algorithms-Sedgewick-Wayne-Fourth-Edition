package Chapter1.Section2;

import edu.princeton.cs.algs4.StdOut;
/*
What does the following code fragment print?
String s = "Hello World";
s.toUpperCase();
s.substring(6, 11);
StdOut.println(s);
*/
public class Exercise5
{
  public static void main(String[] args)
  {/*
  Prints "Hello World"
  String objects are immutable. s.toUpperCase returns a new String object,
  it performs no action of the object s.
  To correctly output "WORLD", we must use
  s = s.toUpperCase();
  s = s.substring(6, 11);
  */
    String s = "Hello World";
    s.toUpperCase();
    s.substring(6, 11);
    StdOut.println(s);
  }
}
