package Chapter1.Section4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import static java.lang.System.exit;

/*
Hot or cold. Your goal is to guess a secret integer between 1 and N. You repeatedly
 guess integers between 1 and N. After each guess you learn if your guess equals the
secret integer (and the game stops). Otherwise, you learn if the guess is hotter (closer to)
or colder (farther from) the secret number than your previous guess. Design an
algorithm that finds the secret number in at most ~2 lg N guesses. Then design an
algorithm that finds the secret number in at most ~ 1 lg N guesses.
*/
public class Exercise34
{
  public static void main()
  {
    playHotOrCold(1000000);
  }

  public static void playHotOrCold(int N)
  {
    int       left  = 1;
    int       right = N;
    HotOrCold game  = new HotOrCold(N);
    game.guess(1);
    game.guess(N);
    while (true)
      if (!game.hotter) game.guess(game.lastGuess);
      else
      {
        if (game.thisGuess > game.lastGuess)
        {
          left = (game.thisGuess + game.lastGuess) / 2;
          game.guess((left + right) / 2 + 1);
        } else
        {
          right = (game.thisGuess + game.lastGuess) / 2 + 1;
          game.guess((left + right) / 2 - 1);
        }
      }
  }
}

class HotOrCold
{
  public        int     N;
  public        int     guesses;
  private final int     target;
  public        int     thisGuess;
  public        int     lastGuess = Integer.MIN_VALUE;
  public        boolean hotter;

  public HotOrCold(int N)
  {
    this.N = N;
    this.target = StdRandom.uniformInt(N) + 1;
    StdOut.println(target);
  }

  public void guess(int x)
  { // Returns -1 if colder, 0 if correct, 1 if hotter
    guesses++;
    lastGuess = thisGuess;
    thisGuess = x;
    if (x == target)
    {
      StdOut.printf("Answer: %d\nFound in %d guesses\n", x, guesses);
      exit(0);
    }
    hotter = Math.abs(thisGuess - target) <= Math.abs(lastGuess - target);
  }
}