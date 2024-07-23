package Chapter1.Section2;

import edu.princeton.cs.algs4.StdOut;
/*
A string s is a circular rotation of a string t if it matches when the characters
are circularly shifted by any number of positions; e.g., ACTGACG is a circular shift of
TGACGAC, and vice versa. Detecting this condition is important in the study of genomic
sequences. Write a program that checks whether two given strings s and t are circular
shifts of one another. Hint : The solution is a one-liner with indexOf(), length(), and
string concatenation.
*/
public class Exercise6
{
  public static boolean isCircular(String s, String t)
  {
    return (t + t).contains(s) && s.length() == t.length();
  }

  public static void main(String[] args)
  {
    String s1 = "Hello";
    String t1 = "World";
    String out1 = isCircular(s1, t1) ? "" : "not ";
    StdOut.printf("%s is %sa circular rotation of %s.\n", s1, out1, t1);

    String s2 = "ACTGACG";
    String t2 = "TGACGAC";
    String out2 = isCircular(s2, t2) ? "" : "not ";
    StdOut.printf("%s is %sa circular rotation of %s.\n", s2, out2, t2);
  }
}
