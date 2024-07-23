package Chapter1.Section2;

import edu.princeton.cs.algs4.StdOut;
/*
What does the following code fragment print?
String string1 = "hello";
String string2 = string1;
string1 = "world";
StdOut.println(string1);
StdOut.println(string2);
*/
public class Exercise4
{
  public static void main(String[] args)
  {
    /*
    world
    hello
    Since string objects are immutable and cannot be changed once created,
    giving the variable string1 the value "world" creates a new object.
    string2 refers to the previous String object with the value "hello"
     */

    String string1 = "hello";
    String string2 = string1;
    string1 = "world";
    StdOut.println(string1);
    StdOut.println(string2);
  }
}
