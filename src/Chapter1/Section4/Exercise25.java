package Chapter1.Section4;


/*
Throwing two eggs from a building. Consider the previous question, but now
suppose you only have two eggs, and your cost model is the number of throws. Devise
a strategy to determine F such that the number of throws is at most 2√N, then find a
way to reduce the cost to ~c √F. This is analogous to a situation where search hits (egg
intact) are much cheaper than misses (egg broken).
*/

import edu.princeton.cs.algs4.StdOut;

public class Exercise25
{
  public static void main()
  {

    boolean[] floors = { false, false, false, false, false, false, true, true, true, true, true, true };
    StdOut.println(twoEggs(floors));
    StdOut.println(reducedCostTwoEggs(floors));
  }

  public static int twoEggs(boolean[] floors)
  {
    int rootN = (int) Math.sqrt(floors.length);
    for (int i = 0; i * rootN < floors.length; i++)
      if (floors[rootN * i])
        return linearCheck(floors, (i - 1) * rootN);
    return linearCheck(floors, floors.length - rootN);
  }

  public static int reducedCostTwoEggs(boolean[] floors)
  {
    int i = 0;
    int j = 1;
    while (i < floors.length)
    {
      if (floors[i]) return linearCheck(floors, i - j);
      j++;
      i += j;
    }
    return linearCheck(floors, i - j);
  }

  public static int linearCheck(boolean[] floors, int min)
  {
    while (!floors[min])
      min++;
    return min;
  }
}
