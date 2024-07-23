package Chapter1.Section1;

import edu.princeton.cs.algs4.StdOut;

/*
Consider the following recursive function:
public static int mystery(int a, int b)
{
if (b == 0) return 0;
if (b % 2 == 0) return mystery(a+a, b/2);
return mystery(a+a, b/2) + a;
}
What are the values of mystery(2, 25) and mystery(3, 11)? Given positive integers
a and b, describe what value mystery(a, b) computes. Answer the same question, but
replace + with * and replace return 0 with return 1.
*/
public class Exercise18
{
  public static int mystery(int a, int b)
  {
    //Returns a * b
    if (b == 0) return 0;
    if (b % 2 == 0) return mystery(a + a, b / 2);
    return mystery(a + a, b / 2) + a;
  }

  public static int mystery2(int a, int b)
  {
    //Returns a ^ b
    if (b == 0) return 1;
    if (b % 2 == 0) return mystery2(a * a, b / 2);
    return mystery2(a * a, b / 2) * a;
  }

  public static void main(String[] args)
  {
    StdOut.println(mystery(3, 2));
    StdOut.println(mystery(2, 3));

    StdOut.println(mystery2(3, 2));
    StdOut.println(mystery2(2, 3));
  }
}
