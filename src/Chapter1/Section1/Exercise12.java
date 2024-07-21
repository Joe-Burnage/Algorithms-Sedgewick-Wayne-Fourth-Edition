package Chapter1.Section1;

public class Exercise12
{
  public static void main(String[] args)
  {
    //Initialise length 10 array
    int[] a = new int[10];

    //Assign values to array => {9, 8, 7, 6, 5, 4, 3, 2, 1, 0}
    for (int i = 0; i < 10; i++)
      a[i] = 9 - i;

    //Reassign values
    //a[0] = a[a[0]]
    //a[0] was previously 9, thus
    //a[0] = a[9] = 0
    //Process continues, as we reach the second half of the array, the values in the indexes have already changed.
    //e.g. a[9] = a[a[9]]
    //a[9] was previously 0, thus
    //a[9] = a[0] = 0
    for (int i = 0; i < 10; i++)
      a[i] = a[a[i]];

    //Print the array
    for (int i = 0; i < 10; i++)
      System.out.println(a[i]);
  }
}
