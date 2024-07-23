package Chapter1.Section1;

import edu.princeton.cs.algs4.StdOut;
/*
Write a static method histogram() that takes an array a[] of int values and
an integer M as arguments and returns an array of length M whose ith entry is the
number of times the integer i appeared in the argument array. If the values in a[] are all
between 0 and M–1, the sum of the values in the returned array should be equal to a.length.
*/
public class Exercise15
{
  public static int[] histogram(int[] a, int M){
    int[] output = new int[M];
    for (int i: a){
      if (i < M) {
        output[i]++;
      }
    }
    return output;
  }

  public static void print(int[] a){
    for (int i: a){
      StdOut.println(i);
    }
  }

  public static void main(String[] args)
  {
    int[] a = {1, 2, 3, 4, 5, 0, 0, 0, 2, 3, 10, 12, 4, 4, 4};
    print(histogram(a, 12));
  }
}
