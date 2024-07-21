package Chapter1.Section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise11
{
  public static void printBooleanArray(boolean[][] array)
  {
    int x = array.length;
    int y = array[0].length;
    StdOut.print("  ");
    for (int j = 0; j < y; j++)
      StdOut.printf("%3d", j + 1);
    StdOut.println();
    for (int i = 0; i < x; i++)
    {
      StdOut.printf("%3d", i + 1);
      for (int j = 0; j < y; j++)
      {
        if (array[i][j]) StdOut.printf(" * ");
        else StdOut.printf("   ");
      }
      StdOut.println();
    }
  }

  public static void main(String[] args)
  {
    boolean[][] array = {
        { true, false, true },
        { false, false, true },
        { false, true, true },
        { true, true, true } };
    printBooleanArray(array);
  }
}
