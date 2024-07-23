package Chapter1.Section3;

import edu.princeton.cs.algs4.*;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/*
Do Exercise 1.3.16 for Transaction.
*/
public class Exercise17
{
  public static void main(String @NotNull [] args)
  {
    if (args.length == 1) StdOut.println(Arrays.toString(readTransactions(args[0])));
    else
      throw new RuntimeException("Must include filename of a file containing transactions in the format who | Date | amount");
  }

  public static Transaction[] readTransactions(String name)
  {
    In                 in = new In(name);
    Queue<Transaction> q  = new Queue<>();
    while (!in.isEmpty())
    {
      String line = in.readLine();
      q.enqueue(new Transaction(line));
    }
    int           N = q.size();
    Transaction[] a = new Transaction[N];
    for (int i = 0; i < N; i++)
      a[i] = q.dequeue();
    return a;
  }
}
