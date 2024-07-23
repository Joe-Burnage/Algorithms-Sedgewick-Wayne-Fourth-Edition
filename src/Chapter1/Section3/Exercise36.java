package Chapter1.Section3;

import edu.princeton.cs.algs4.StdOut;

/*
Random iterator. Write an iterator for RandomQueue<Item> from the previous
exercise that returns the items in random order.

Demonstration below.
Implementation in RandomQueue (Class contained in Exercise35.java)
*/
public class Exercise36
{
  public static void main()
  {
    RandomQueue<Card> randomDeck = new RandomQueue<>();
    for (String suit : Card.SUITS)
      for (String rank : Card.RANKS)
        randomDeck.enqueue(new Card(rank, suit));
    for (Card card : randomDeck)
      StdOut.println(card);
    StdOut.println("Randomly ordered deck of cards");
  }
}
