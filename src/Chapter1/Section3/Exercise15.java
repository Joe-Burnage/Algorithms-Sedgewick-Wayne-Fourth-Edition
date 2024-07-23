package Chapter1.Section3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import org.jetbrains.annotations.NotNull;

/*
Write a Queue client that takes a command-line argument k and prints the kth
from the last string found on standard input (assuming that standard input
has k or more strings).
*/
public class Exercise15
{
  public static void main(String @NotNull [] args)
  {
    if (args.length != 1) throw new IllegalArgumentException("Must enter an integer k");
    int k = Integer.parseInt(args[0]);
    StdOut.println("Enter a string and hit return to add to queue. Ctrl+D to quit and receive the kth last input.");
    Queue<String> queue = new Queue<>();
    while (StdIn.hasNextLine())
    {
      String line = StdIn.readLine();
      queue.enqueue(line);
    }
    while (queue.size() > k) queue.dequeue();
    StdOut.println(queue.dequeue());
  }
}
