package Chapter1.Section1;

import edu.princeton.cs.algs4.StdOut;
/*
1.1.7 Give the value printed by each of the following code fragments:
a.
double t = 9.0;
while (Math.abs(t - 9.0/t) > .001)
  t = (9.0/t + t) / 2.0;
StdOut.printf("%.5f\n", t);

b.
int sum = 0;
for (int i = 1; i < 1000; i++)
  for (int j = 0; j < i; j++)
    sum++;
StdOut.println(sum);

c.
int sum = 0;
for (int i = 1; i < 1000; i *= 2)
  for (int j = 0; j < N; j++)
    sum++;
StdOut.println(sum);

*/
public class Exercise7
{

  public static void main(String[] args)
  {

    StdOut.print("""
        a)
        Uses Newton's method to approximate the \
        square root of 9.
        Output:\s""");
    double t = 9.0;
    while (Math.abs(t - 9.0 / t) > .001)
      t = (9.0 / t + t) / 2.0;
    StdOut.printf("%.5f\n", t);

    StdOut.print("b)\nSums the numbers from 1 to 999.\nOutput: ");
    int sum = 0;
    for (int i = 1; i < 1000; i++)
      for (int j = 0; j < i; j++)
      {
        sum++;
      }
    StdOut.println(sum);

    StdOut.print ("c)\nSums the powers of 2 between 1 and 999.\nOutput: ");
    int sum2 = 0;
    for (int i = 1; i < 1000; i*=2)
      for (int j = 0; j < i; j++)
        sum2++;
    StdOut.println(sum2);


  }
}
