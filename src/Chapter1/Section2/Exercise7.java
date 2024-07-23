package Chapter1.Section2;

import edu.princeton.cs.algs4.StdOut;
/*
What does the following recursive function return?
public static String mystery(String s)
{
  int N = s.length();
  if (N <= 1) return s;
  String a = s.substring(0, N/2);
  String b = s.substring(N/2, N);
  return mystery(b) + mystery(a);
}
*/
public class Exercise7
{
  public static String mystery(String s)
  {
    //The function outputs the reverse of the input string.
    int N = s.length();
    if (N <= 1) return s;
    String a = s.substring(0, N/2);
    String b = s.substring(N/2, N);
    return mystery(b) + mystery(a);
  }

  public static void main(String[] args)
  {
    StdOut.println(mystery("Hello"));
  }
}
