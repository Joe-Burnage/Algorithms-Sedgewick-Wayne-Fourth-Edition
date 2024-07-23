package Chapter1.Section2;

import edu.princeton.cs.algs4.StdOut;
/*
Parsing. Develop the parse constructors for your Date and Transaction implementations
of Exercise 1.2.13 that take a single String argument to specify the
initialization values, using the formats given in the table below.

type                      format                          example

Date           integers separated by slashes             5/22/1939

Transaction     customer, date, and amount,
                  separated by whitespace         Turing 5/22/1939 11.99
*/

public class Exercise19
{
  public static void main(String[] args)
  {
    Date_v2 date = new Date_v2("1996/9/22");
    StdOut.println(date);
    Transaction_v2 transaction = new Transaction_v2("Turing 1939/5/22 11.99");
    StdOut.println(transaction);
  }
}

class Date_v2 extends Date_v1
{
  public Date_v2(String date){
    String[] fields = date.split("/");
    if (fields.length != 3) throw new RuntimeException("Date must be in the form YYYY/MM/DD");
    int y = Integer.parseInt(fields[0]);
    int m = Integer.parseInt(fields[1]);
    int d = Integer.parseInt(fields[2]);
    super(y, m, d);
  }
}

class Transaction_v2 extends Transaction_v1
{

  public Transaction_v2(String transaction)
  {
    String[] fields = transaction.split(" ");
    if (fields.length != 3) throw new RuntimeException("Please enter transaction in the form NAME YYYY/MM/DD AMOUNT");
    String who = fields[0];
    Date_v2 when = new Date_v2(fields[1]);
    double amount = Double.parseDouble(fields[2]);
    super(who, when, amount);
  }
}
