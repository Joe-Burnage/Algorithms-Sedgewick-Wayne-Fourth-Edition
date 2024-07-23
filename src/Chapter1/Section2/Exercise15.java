package Chapter1.Section2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
/*
File input. Develop a possible implementation of the static readInts() method
from In (which we use for various test clients, such as binary search on page 47)
that is based on the split() method in String.
*/
public class Exercise15
{
  public static int[] readInts(String name)
  {
    In in = new In(name);
    String input = in.readAll();
    String[] words = input.trim().split("\\s+");
    int[] ints = new int[words.length];
    for (int i = 0; i < words.length; i++){
      ints[i] = Integer.parseInt(words[i]);
    }
    return ints;
  }

  public static void main(String[] args)
  {
    //Takes file name as command-line argument and reads ints from file
    StdOut.println(Arrays.toString(readInts(args[0])));
  }
}
