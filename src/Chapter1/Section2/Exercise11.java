package Chapter1.Section2;

import edu.princeton.cs.algs4.StdOut;
/*
Develop an implementation SmartDate of our Date API that raises an
exception if the date is not legal.
*/
public class Exercise11
{
  public static void main(String[] args)
  {
    Date_v0 smartDate = new Date_v0(1996, 12, 2);
    StdOut.println(smartDate);
    Date_v0 validLeapYear = new Date_v0(2000, 2, 29);
    StdOut.println(validLeapYear);
    Date_v0 invalidLeapYear = new Date_v0(1900, 2, 29);
    StdOut.println(invalidLeapYear);
  }
}

class Date_v0
{
  private final int year;
  private final int month;
  private final int day;
  public static final int[] DAYS_PER_MONTH = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

  public Date_v0(int y, int m, int d)
  {
    this.year = y;
    this.month = m;
    this.day = d;
    if (!validDate()) throw new RuntimeException("Invalid date.");
  }

  private boolean validDate()
  {
    if (day > 31) return false;
    if (month > 12 || month < 1) return false;
    if (day == 29 && month == 2)
    {
      if (year % 400 == 0) return true;
      if (year % 100 == 0) return false;
      if (year % 4 == 0) return true;
    }
    return day <= DAYS_PER_MONTH[month - 1];
  }

  public int getDay()
  {
    return day;
  }

  public int getYear()
  {
    return year;
  }

  public int getMonth()
  {
    return month;
  }

  @Override
  public String toString()
  {
    return String.format("%4d / %02d / %02d", year, month, day);
  }
}