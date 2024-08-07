package Chapter1.Section4;

import edu.princeton.cs.algs4.StdOut;

/*
Throwing eggs from a building. Suppose that you have an N-story building and
plenty of eggs. Suppose also that an egg is broken if it is thrown off floor F or higher,
and unhurt otherwise. First, devise a strategy to determine the value of F such that the
number of broken eggs is ~lg N when using ~lg N throws, then find a way to reduce the
cost to ~2lg F.
*/
public class Exercise24
{

  public static void main()
  {
    boolean[] floors = {false, false, false, false, false, false, true, true, true, true, true, true};
    StdOut.println(brokenEgg(floors));
    StdOut.println(brokenEggFast(floors));
  }

  public static int brokenEggFast(boolean[] floors)
  {
    int left;
    int right = 1;
    while (true)
    {
      left = right;
      right = Math.min(floors.length - 1, right * 2);
      if (!floors[left] && floors[right]) return brokenEgg(floors, left, right);
    }
  }

  public static int brokenEgg(boolean[] floors, int left, int right)
  {
    while (left < right)
    {
      int mid = (left + right) / 2;
      if (floors[mid] && !floors[mid - 1]) return mid;
      if (floors[mid]) right = mid - 1;
      else left = mid + 1;
    }
    return right;
  }

  public static int brokenEgg(boolean[] floors) { return brokenEgg(floors, 0, floors.length - 1); }
}
