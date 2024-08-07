package Chapter1.Section4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;
/*
Write a program to determine the number pairs of values in an input file that
are equal. If your first try is quadratic, think again and use Arrays.sort() to develop
a linearithmic solution.
*/
public class Exercise8
{
  public static void main(String[] args)
  {
    Stopwatch time = new Stopwatch();
    int[] nums = new In(args[0]).readAllInts();
    StdOut.printf("%d equal pairs found in %.2f seconds.", countEqualPairs(nums), time.elapsedTime());
  }

  public static int countEqualPairs(int[] nums)
  {
    Arrays.sort(nums);
    int count = 0;
    int index = 0;
    while (index < nums.length - 1)
    { // If there are 5 integers all with the same value, there are 4 + 3 + 2 + 1 pairs
      // which are equal. Create a running count of the number of 'copies' of numbers
      // when we encounter two integers with the same value. Once we find an integer with
      // a new value, we add the triangular number (1 + 2 + 3 + ... + n) = n (n + 1) / 2
      // to our total count. Solution is linearithmic as array must be sorted.
      if (nums[index] == nums[index + 1])
      {
        int copies = 0;
        while (nums[index] == nums[index + 1])
        {
          copies++;
          index++;
        }
        count += copies * (copies + 1) / 2;
      }
      index++;
    }
    return count;
  }
}