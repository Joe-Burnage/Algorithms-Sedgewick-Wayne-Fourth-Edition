package Chapter1.Section1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
/*
Dice simulation. The following code computes the exact probability
distribution for the sum of two dice:

int SIDES = 6;
double[] dist = new double[2*SIDES+1];
for (int i = 1; i <= SIDES; i++)
  for (int j = 1; j <= SIDES; j++)
    dist[i+j] += 1.0;
for (int k = 2; k <= 2*SIDES; k++)
  dist[k] /= 36.0;

The value dist[i] is the probability that the dice sum to k. Run experiments to
validate this calculation simulating N dice throws, keeping track of the frequencies of
occurrence of each value when you compute the sum of two random integers between 1
and 6. How large does N have to be before your empirical results match the exact results
to three decimal places?
*/
public class Exercise35
{
  public static int[] simulate(int N){
    int[] rolls = new int[13];
    for (int i = 0; i < N; i++)
    {
      int dice1 = StdRandom.uniformInt(1,7);
      int dice2 = StdRandom.uniformInt(1,7);
      rolls[dice1 + dice2]++;
    }
    return rolls;
  }

  public static void main(String[] args)
  {
    //Roughly 5e6 simulations to match exactly to three decimal places, empirically.
    int N = 5000000;
    int[] sim = simulate(N);

    int SIDES = 6;
    double[] dist = new double[2 * SIDES + 1];
    for (int i = 1; i <= SIDES; i++)
      for (int j = 1; j <= SIDES; j++)
        dist[i + j] += 1.0;
    for (int k = 2; k <= 2 * SIDES; k++)
    {
      dist[k] /= 36.0;
      StdOut.printf("roll: %d\nProbability: %.3f\nFrequency:   %.3f\n", k, dist[k], (double) sim[k] / N);
    }
  }
}
