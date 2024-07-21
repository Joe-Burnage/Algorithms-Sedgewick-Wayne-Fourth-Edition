package Chapter1.Section1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Exercise39
{

  public static int[] makeArray(int N)
  {
    int[] array = new int[N];
    for (int i = 0; i < N; i++)
      array[i] = StdRandom.uniformInt(100000, 1000000);
    Arrays.sort(array);
    return array;
  }

  public static int compareArrays(int[] a, int[] b)
  {
    int count = 0;
    int a_index = 0;
    int b_index = 0;
    while (b_index < b.length)
    {
      while (a_index < a.length && b[b_index] > a[a_index]) a_index++;
      if (a_index == a.length) break;
      if (b[b_index] == a[a_index]) count++;
      while (b_index < b.length - 1 && b[b_index] == b[b_index + 1]) b_index++;
      b_index++;
    }
    return count;

  }

  public static void main(String[] args)
  {
    int T = Integer.parseInt(args[0]);
    int count1 = 0;
    int count2 = 0;
    int count3 = 0;
    int count4 = 0;
    for (int i = 0; i < T; i++)
    {
    int[] a1 = makeArray(1000);
    int[] b1 = makeArray(1000);
    count1 += compareArrays(a1, b1);
    int[] a2 = makeArray(10000);
    int[] b2 = makeArray(10000);
    count2 += compareArrays(a2, b2);
    int[] a3 = makeArray(100000);
    int[] b3 = makeArray(100000);
    count3 += compareArrays(a3, b3);
    int[] a4 = makeArray(1000000);
    int[] b4 = makeArray(1000000);
    count4 += compareArrays(a4, b4);
    }

    StdOut.printf(
        """
            ╔════════════╦══════════════════════════╗
            ║ Array size ║ no. shared values (avg.) ║
            ╠════════════╬══════════════════════════╣
            ║    1000    ║   %-10.1f             ║
            ║   10000    ║   %-10.1f             ║
            ║  100000    ║   %-10.1f             ║
            ║ 1000000    ║   %-10.1f             ║
            ╚════════════╩══════════════════════════╝
            """,
        (double) count1 / T,
        (double) count2 / T,
        (double) count3 / T,
        (double) count4 / T);
  }
}
