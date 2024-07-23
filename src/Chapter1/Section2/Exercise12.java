package Chapter1.Section2;

import edu.princeton.cs.algs4.StdOut;
/*
Add a method dayOfTheWeek() to SmartDate that returns a String value
Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, or Sunday, giving the
appropriate day of the week for the date. You may assume that the date
is in the 21st century.
*/
public class Exercise12
{
  public static void main(String[] args)
  {
    Date_v1 date1 = new Date_v1(1996, 12, 2);
    StdOut.printf("%s - %s\n", date1, date1.dayOfTheWeek());
    Date_v1 date2 = new Date_v1(2000, 2, 29);
    StdOut.printf("%s - %s\n", date2, date2.dayOfTheWeek());
    Date_v1 date3 = new Date_v1(1879, 3, 14);
    StdOut.printf("%s - %s\n", date3, date3.dayOfTheWeek());
  }
}

class Date_v1 extends Date_v0
{

  private final int[] MONTH_CODES = { 0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5 };
  private final int[] CENTURY_CODES = { 4, 2, 0, 6, 4, 2, 0 };
  public final String[] DAYS_OF_THE_WEEK = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

  public Date_v1(int y, int m, int d)
  {
    super(y, m, d);
  }

  private int subtractLeap()
  {
    int year = getYear();
    if (getMonth() > 2) return 0;
    if (year % 4 != 0) return 0;
    if (year % 400 == 0) return 1;
    return year % 100 == 0 ? 0 : 1;
  }

  public String dayOfTheWeek()
  {
    //Covers dates from September 14, 1752, to 2399
    //(the date the UK, Canada, and the US switched to the Gregorian calendar)
    //https://www.timeanddate.com/calendar/julian-gregorian-switch.html
    if (getYear() < 1752 || getYear() > 2399 ||
        getYear() == 1752 && (getMonth() < 9 ||
            getMonth() == 9 && getDay() < 14))
      throw new RuntimeException("Can't calculate the day of the week for years outside of the range 1700-2399.");

    int YY = getYear() % 100;
    int yearCode = (YY + (YY / 4)) % 7;
    int monthCode = MONTH_CODES[getMonth() - 1];
    int centuryCode = CENTURY_CODES[getYear() / 100 - 17];
    int dateCode = getDay();
    int leapCode = subtractLeap();
    int day = (yearCode + monthCode + centuryCode + dateCode - leapCode) % 7;
    return DAYS_OF_THE_WEEK[day];
  }
}