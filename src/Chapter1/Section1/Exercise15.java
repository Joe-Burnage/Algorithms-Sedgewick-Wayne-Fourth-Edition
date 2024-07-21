package Chapter1.Section1;

import edu.princeton.cs.algs4.StdOut;

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
