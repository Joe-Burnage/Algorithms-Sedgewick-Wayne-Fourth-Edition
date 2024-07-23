package Chapter1.Section2;

import edu.princeton.cs.algs4.StdOut;


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
    Date_v2 temp = new Date_v2(fields[1]);
    //super class in Exercise13 requires Date_v1.Date object
    Date_v1 when = new Date_v1(temp.getYear(), temp.getMonth(), temp.getDay());
    double amount = Double.parseDouble(fields[2]);
    super(who, when, amount);
  }
}
