package Chapter1.Section3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/*
Develop a class ResizingArrayQueueOfStrings that implements the queue
abstraction with a fixed-size array, and then extend your implementation
to use array resizing to remove the size restriction.
*/
public class Exercise14
{
  public static void main()
  {
    ResizingArrayQueueOfStrings<String> test = new ResizingArrayQueueOfStrings<>();
    StdOut.println("Enter - to remove from queue or any string to insert");
    while (StdIn.hasNextLine())
    {
      String line = StdIn.readLine();
      if (line.isEmpty()) continue;
      if (line.equals("-")) StdOut.println(test.dequeue());
      else test.enqueue(line);
      StdOut.printf("""
                        N:          %d
                        Array size: %d
                        """, test.size(), test.arraySize());
    }
  }
}

class ResizingArrayQueueOfStrings<String>
{
  private String[] strings = (String[]) new Object[1];
  private int      N;

  private void resize(int max)
  {
    String[] s = (String[]) new Object[max];
    System.arraycopy(strings, 0, s, 0, N);
    strings = s;
  }

  public boolean isEmpty() { return N == 0; }

  public int size() { return N; }

  public int arraySize() { return strings.length; }

  public void enqueue(String item)
  {
    strings[N++] = item;
    if (N == strings.length) resize(N * 2);
  }

  public String dequeue()
  {
    if (isEmpty()) throw new ArrayIndexOutOfBoundsException("Can't dequeue an empty queue.");
    String item = strings[0];
    N--;
    for (int i = 0; i < N; i++)
      strings[i] = strings[i + 1];
    if (N == strings.length / 4) resize(N * 2);
    return item;
  }
}
