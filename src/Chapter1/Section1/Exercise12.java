package Chapter1.Section1;
/*
What does the following code fragment print?
int[] a = new int[10];
for (int i = 0; i < 10; i++)
  a[i] = 9 - i;
for (int i = 0; i < 10; i++)
  a[i] = a[a[i]];
for (int i = 0; i < 10; i++)
  System.out.println(i);
*/
public class Exercise12
{
  public static void main(String[] args)
  {
    int[] a = new int[10];

    //Assign values to array => {9, 8, 7, 6, 5, 4, 3, 2, 1, 0}
    for (int i = 0; i < 10; i++)
      a[i] = 9 - i;

/*  Reassign values
    a[0] = a[a[0]]
    a[0] = a[9] = 0
    ...
    e.g. a[9] = a[a[9]]
    a[9] = a[0] = 0
    */
    for (int i = 0; i < 10; i++)
      a[i] = a[a[i]];

    for (int i = 0; i < 10; i++)
      System.out.println(a[i]);
  }
}
