package Chapter1.Section4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.ThreeSum;

public class Exercise38
{
  public static void main()
  {
    for (int i = 250; i < 1E5; i *= 2)
    {
      int[] array = randomArray(i, 100000);
      Stopwatch naiveTimer = new Stopwatch();
      int naiveOutput = threeSumNaive(array);
      double naiveTime = naiveTimer.elapsedTime();

      Stopwatch regularTimer = new Stopwatch();
      int regularOutput = ThreeSum.count(array);
      double regularTime = regularTimer.elapsedTime();

      StdOut.printf("""
                        Array size: %d
                        Three sum output: %d
                        Naive output:     %d
                        Three sum time:   %.3f
                        Naive time:       %.3f
                        
                        """, i, regularOutput, naiveOutput, regularTime, naiveTime);
    }

  }

  public static int threeSumNaive(int[] a)
  {
    int N   = a.length;
    int cnt = 0;
    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++)
        for (int k = 0; k < N; k++)
          if (i < j && j < k)
            if (a[i] + a[j] + a[k] == 0)
              cnt++;
    return cnt;
  }

  public static int[] randomArray(int size, int maxValue)
  {
    int[] a = new int[size];
    for (int i = 0; i < size; i++)
      a[i] = (int) ((Math.random() - 0.5) * maxValue * 2);
    return a;
  }
}
