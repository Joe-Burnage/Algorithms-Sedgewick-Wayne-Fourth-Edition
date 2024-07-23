package Chapter1.Section2;

import edu.princeton.cs.algs4.StdOut;
/*
Using our implementation of Date as a model (page 91), develop an
implementation of Transaction.
*/
public class Exercise13
{
  public static void main(String[] args)
  {
    Date_v1 today = new Date_v1(7, 22, 2024);
    Transaction_v0 transaction = new Transaction_v0("Me", today, 10.0);
    StdOut.println(transaction);
  }
}

class Transaction_v0
{

  private final String who;
  private final Date_v1 when;
  private final double amount;

  @Override
  public String toString()
  {
    return String.format("%s: $%.2f - %s", when, amount, who);
  }

  public String who()
  {
    return who;
  }

  public Date_v1 when()
  {
    return when;
  }

  public double amount()
  {
    return amount;
  }

  public Transaction_v0(String who, Date_v1 when, double amount)
  {
    this.who = who;
    this.when = when;
    this.amount = amount;
  }
}
