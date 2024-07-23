package Chapter1.Section3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;

/*
Random queue. A random queue stores a collection of items
and supports the following API:

public class RandomQueue<Item>
         RandomQueue() create an empty random queue
boolean  isEmpty() is the queue empty?
void     enqueue(Item item) add an item
Item     dequeue() remove and return a random item (sample without replacement)
Item     sample() return a random item, but do not remove (sample with replacement)

Write a class RandomQueue that implements this API. Hint : Use an array
representation (with resizing). To remove an item, swap one at a random
position (indexed 0 through N-1) with the one at the last position
(index N-1). Then delete and return the last object, as in
ResizingArrayStack. Write a client that deals bridge hands
(13 cards each) using RandomQueue<Card>.
*/
public class Exercise35
{
  public static void main()
  {
    RandomQueue<Integer> test = new RandomQueue<>();
    StdOut.print("Enqueue numbers from 0 to 4: ");
    for (int i = 0; i < 5; i++)
      test.enqueue(i);
    StdOut.println(test);
    StdOut.print("Random sample:               ");
    for (int i = 0; i < 5; i++)
      StdOut.print(test.sample() + ", ");
    StdOut.println("\nQueue:                       " + test);
    StdOut.print("Dequeue randomly:            ");
    for (int i = 0; i < 3; i++)
      StdOut.print(test.dequeue() + ", ");
    StdOut.println("\nRemaining in queue           " + test + "\n\n\n");

    RandomQueue<Card> randomDeck = new RandomQueue<>();
    for (String suit : Card.SUITS)
      for (String rank : Card.RANKS)
        randomDeck.enqueue(new Card(rank, suit));
    StdOut.println("Cards in deck: " + randomDeck.size() + "\nDeal hand:");
    StdOut.println(Arrays.toString(randomDeck.randomDeal(13)));
    StdOut.println("Cards remaining in deck: " + randomDeck.size());
  }
}

class RandomQueue<Item> implements Iterable<Item>
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

  public void enqueue(Item item)
  {
    items[N++] = item;
    if (N == items.length) resize(N * 2);
  }

  public Item dequeue()
  {
    if (isEmpty()) throw new ArrayIndexOutOfBoundsException("Can't dequeue an empty queue.");
    int  index = StdRandom.uniformInt(N);
    Item temp  = items[index];
    items[index] = items[N - 1];
    items[N - 1] = null;
    N--;
    if (N == items.length / 4) resize(N * 2);
    return temp;
  }

  public Item sample()
  {
    if (isEmpty()) throw new ArrayIndexOutOfBoundsException("Can't dequeue an empty queue.");
    return items[StdRandom.uniformInt(N)];
  }

  public void shuffle()
  {
    for (int i = 0; i < N; i++)
    {
      int  r    = i + StdRandom.uniformInt(N - i);
      Item temp = items[i];
      items[i] = items[r];
      items[r] = temp;
    }
  }

  public Item[] randomDeal(int n)
  {
    if (size() < n) throw new RuntimeException("n out of bounds");
    Item[] hand = (Item[]) new Object[n];
    for (int i = 0; i < n; i++)
      hand[i] = dequeue();
    return hand;
  }


  public String toString()
  {
    StringBuilder s = new StringBuilder();
    for (int i = 0; i < N - 1; i++)
      s.append(items[i]).append(", ");
    s.append(items[N - 1]);
    return s.toString();
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

class Card
{
  static final String[] RANKS = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
  static final String[] SUITS = { "Spades", "Clubs", "Hearts", "Diamonds" };
  String value;
  String suit;

  public Card(String rank, String suit)
  {
    this.value = RANKS[StdRandom.uniformInt(13)];
    this.suit = SUITS[StdRandom.uniformInt(4)];
    for (String v : RANKS)
      if (rank.equals(v))
      {
        this.value = rank;
        break;
      }
    for (String s : SUITS)
      if (suit.equals(s))
      {
        this.suit = suit;
        break;
      }
  }

  public String toString()
  {
    return this.value + " of " + this.suit;
  }
}
