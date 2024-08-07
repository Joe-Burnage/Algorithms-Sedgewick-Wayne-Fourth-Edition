package Chapter1.Section4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.ThreeSum;

import java.util.Arrays;

import static Chapter1.Section4.Exercise10.rank;
import static Chapter1.Section4.HowManyStaticSETofInts.howMany;

/*
Faster 3-sum. As a warmup, develop an implementation TwoSumFaster that
uses a linear algorithm to count the pairs that sum to zero after the array is
sorted (instead of the binary-search-based linearithmic algorithm). Then apply
a similar idea to develop a quadratic algorithm for the 3-sum problem.
*/
public class Exercise15
{
  public static void main()
  {
    int[] a = { -3, -2, -1, 0, 0, 0, 1, 2, 3 };
    int[] b = new In("dataFiles/1Kints.txt").readAllInts();
    int[] c = new In("dataFiles/2Kints.txt").readAllInts();
    int[] d = new In("dataFiles/4Kints.txt").readAllInts();
    int[] e = new In("dataFiles/8Kints.txt").readAllInts();


    Stopwatch slow_1k = new Stopwatch();
    int slow_1k_count = ThreeSum.count(b);
    double slow_1k_time = slow_1k.elapsedTime();

    Stopwatch fast_1k = new Stopwatch();
    Arrays.sort(b);
    int fast_1k_count = threeSumFaster(b);
    double fast_1k_time = fast_1k.elapsedTime();

    Stopwatch slow_2k = new Stopwatch();
    int slow_2k_count = ThreeSum.count(c);
    double slow_2k_time = slow_2k.elapsedTime();

    Stopwatch fast_2k = new Stopwatch();
    Arrays.sort(c);
    int fast_2k_count = threeSumFaster(c);
    double fast_2k_time = fast_2k.elapsedTime();

    Stopwatch slow_4k = new Stopwatch();
    int slow_4k_count = ThreeSum.count(d);
    double slow_4k_time = slow_4k.elapsedTime();

    Stopwatch fast_4k = new Stopwatch();
    Arrays.sort(d);
    int fast_4k_count = threeSumFaster(d);
    double fast_4k_time = fast_4k.elapsedTime();

    Stopwatch slow_8k = new Stopwatch();
    int slow_8k_count = ThreeSum.count(e);
    double slow_8k_time = slow_8k.elapsedTime();

    Stopwatch fast_8k = new Stopwatch();
    Arrays.sort(e);
    int fast_8k_count = threeSumFaster(e);
    double fast_8k_time = fast_8k.elapsedTime();

    StdOut.printf("""
                      Two Sum
                      Array:    -3, -2, -1, 0, 0, 0, 1, 2, 3
                      Output:   %d
                      Expected: 6

                      Three Sum
                      Array:    -3, -2, -1, 0, 0, 0, 1, 2, 3
                      Output:   %d
                      Expected: %d
                      
                      Three Sum
                      Array:    1Kints.txt
                      Output:   %d
                      Expected: %d
                      ThreeSum time:       %.5f
                      ThreeSumFaster time: %.5f
                      
                      Three Sum
                      Array:    2Kints.txt
                      Output:   %d
                      Expected: %d
                      ThreeSum time:       %.5f
                      ThreeSumFaster time: %.5f
                      
                      Three Sum
                      Array:    4Kints.txt
                      Output:   %d
                      Expected: %d
                      ThreeSum time:       %.5f
                      ThreeSumFaster time: %.5f
                      
                      Three Sum
                      Array:    8Kints.txt
                      Output:   %d
                      Expected: %d
                      ThreeSum time:       %.5f
                      ThreeSumFaster time: %.5f
                      """, twoSumFaster(a),
                  threeSumFaster(a), ThreeSum.count(a),
                  fast_1k_count, slow_1k_count, slow_1k_time, fast_1k_time,
                  fast_2k_count, slow_2k_count, slow_2k_time, fast_2k_time,
                  fast_4k_count, slow_4k_count, slow_4k_time, fast_4k_time,
                  fast_8k_count, slow_8k_count, slow_8k_time, fast_8k_time);
  }

  public static int twoSumFaster(int[] a)
  {
    int left  = 0;
    int right = a.length - 1;
    int count = 0;
    while (left < right)
    {
      if (a[left] + a[right] > 0) right--;
      else if (a[left] + a[right] < 0) left++;
      else if (a[left] == 0)
      {
        int diff = right - left;
        count += diff * (diff + 1) / 2;
        return count;
      } else
      {
        int l_index = left;
        int r_index = right;
        while (a[left] == a[++left]) ;
        while (a[right] == a[--right]) ;
        count += (left - l_index) * (r_index - right);
      }
    }
    return count;
  }

  public static int threeSumFaster(int[] a)
  {
    int count = 0;
    for (int right = a.length - 1; right > 1; right--)
    {
      int left = 0;
      while (left < right)
      {
        if (a[left] == 0 && a[right] == 0)
        {
          int zeros = howMany(0, a);
          if (zeros < 3) return count;
          int combinations = 1;
          for (int i = 0; i < 3; i++)
            combinations *= zeros--;
          return count + combinations / 6;
        }
        int sum = a[left] + a[right];
        int negativeSumIndex = rank(-sum, a);
        if (negativeSumIndex > left && negativeSumIndex < right)
         count += howMany(-sum, a);
        left++;
      }
    }
    return count;
  }
}
