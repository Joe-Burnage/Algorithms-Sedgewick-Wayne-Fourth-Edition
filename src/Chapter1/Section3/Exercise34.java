package Chapter1.Section3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/*
Random bag. A random bag stores a collection of items and
supports the following API:

public class RandomBag<Item> implements Iterable<Item>

          RandomBag()     create an empty random bag
boolean   isEmpty()       is the bag empty?
int       size()          number of items in the bag
void      add(Item item)  add an item

Write a class RandomBag that implements this API. Note that this API is the same as for
Bag, except for the adjective random, which indicates that the iteration should provide
the items in random order (all N ! permutations equally likely, for each iterator). Hint :
Put the items in an array and randomize their order in the iterator’s constructor.
*/

public class Exercise34
{
  public static void main()
  {
    RandomBag<Integer> ints = new RandomBag<>();
    StdOut.println("Randomly iterate through and print to standard output bag of integers from 1 - 10");
    for (int i = 0; i < 10; i++)
      ints.add(i + 1);
    for (int i: ints)
      StdOut.print(i + ", ");
  }
}

class RandomBag<Item> implements Iterable<Item>
{
  private Item[] items = (Item[]) new Object[1];
  private int    N;

  private void resize(int max)
  {
    Item[] s = (Item[]) new Object[max];
    System.arraycopy(items, 0, s, 0, N);
    items = s;
  }

  public boolean isEmpty() { return N == 0; }

  public int size() { return N; }

  public void add(Item item)
  {
    items[N++] = item;
    if (N == items.length) resize(N * 2);
  }

  public void shuffle()
  {
    for (int i = 0; i < N; i++)
    {
      int r = i + StdRandom.uniformInt(N-i);
      Item temp = items[i];
      items[i] = items[r];
      items[r] = temp;
    }
  }

  public @NotNull Iterator<Item> iterator()
  {
    shuffle();
    return new Iterator<>()
    {
      int i = 0;
      @Override
      public boolean hasNext()
      { return i < N - 1; }

      @Override
      public Item next()
      {
        return items[i++];
      }
    };
  }
}

