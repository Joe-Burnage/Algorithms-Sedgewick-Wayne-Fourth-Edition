package Chapter1.Section2;

import edu.princeton.cs.algs4.StdOut;
/*
Using our implementation of equals() in Date as a model (page 103), develop
implementations of equals() for Transaction.
*/
public class Exercise14
{

  public static void main(String[] args)
  {
    Transaction_v1 test = new Transaction_v1("Me", new Date_v1(7, 22, 2024), 10.0);
    Transaction_v1 same = new Transaction_v1("Me", new Date_v1(7, 22, 2024), 10.0);
    Transaction_v1 testwho = new Transaction_v1("You", new Date_v1(7, 22, 2024), 10.0);
    Transaction_v1 testwhen = new Transaction_v1("Me", new Date_v1(9, 22, 2024), 10.0);
    Transaction_v1 testamount = new Transaction_v1("Me", new Date_v1(7, 22, 2024), 100.0);
    StdOut.println(test.equals(same));
    StdOut.println(test.equals(testwho));
    StdOut.println(test.equals(testwhen));
    StdOut.println(test.equals(testamount));

  }
}

class Transaction_v1 extends Transaction_v0
{

  public boolean equals(Object x)
  {
    if (this == x) return true;
    if (x == null) return false;
    if (this.getClass() != x.getClass()) return false;
    Transaction_v1 that = (Transaction_v1) x;
    if (this.amount() != that.amount()) return false;
    if (!this.who().equals(that.who())) return false;
    if (!this.when().equals(that.when())) return false;
    return true;
  }

  public Transaction_v1(String who, Date_v1 when, double amount)
  {
    super(who, when, amount);
  }
}
