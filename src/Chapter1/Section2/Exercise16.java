package Chapter1.Section2;

import edu.princeton.cs.algs4.StdOut;

public class Exercise16
{

  public static void main(String[] args)
  {
    Rational_v0[] rationals = new Rational_v0[4];
    rationals[0] = new Rational_v0(2, 3);
    rationals[1] = new Rational_v0(9, 6);
    rationals[2] = new Rational_v0(500, 23);
    rationals[3] = new Rational_v0(6, 9);
    for (Rational_v0 rational : rationals)
    {
      StdOut.println(rational);
    }
    StdOut.printf("%s + %s = %s\n", rationals[0], rationals[1], rationals[0].plus(rationals[1]));
    StdOut.printf("%s - %s = %s\n", rationals[0], rationals[3], rationals[0].minus(rationals[3]));
    StdOut.printf("%s * %s = %s\n", rationals[0], rationals[1], rationals[0].times(rationals[1]));
    StdOut.printf("%s ÷ %s = %s\n", rationals[0], rationals[3], rationals[0].divides(rationals[3]));
    StdOut.printf("%s == %s = %s\n", rationals[0], rationals[3], rationals[0].equals(rationals[3]));
    StdOut.printf("%s == %s = %s\n", rationals[0], rationals[2], rationals[0].equals(rationals[2]));
  }
}
  class Rational_v0{

    public final long numerator;
    public final long denominator;

    public Rational_v0(int numerator, int denominator)
    {
      if (denominator == 0) throw new RuntimeException("Cannot divide by 0.");
      int gcd = gcd(numerator, denominator);
      this.numerator = numerator / gcd;
      this.denominator = denominator / gcd;
    }

    public static int gcd(int p, int q)
    {
      if (q == 0) return p;
      return gcd(q, p % q);
    }

    public int numerator()
    {
      return (int) numerator;
    }

    public int denominator()
    {
      return (int) denominator;
    }

    public Rational_v0 plus(Rational_v0 b)
    {
      int num1 = this.numerator() * b.denominator();
      int num2 = b.numerator() * this.denominator();
      int denominator = this.denominator() * b.denominator();
      int gcd = gcd(num1 + num2, denominator);
      int numerator = (num1 + num2) / gcd;
      return new Rational_v0(numerator, denominator);
    }

    public Rational_v0 minus(Rational_v0 b)
    {
      int num1 = this.numerator() * b.denominator();
      int num2 = b.numerator() * this.denominator();
      int denominator = this.denominator() * b.denominator();
      int gcd = gcd(num1 - num2, denominator);
      int numerator = (num1 - num2) / gcd;
      return new Rational_v0(numerator, denominator);
    }

    public Rational_v0 times(Rational_v0 b)
    {
      int num = this.numerator() * b.numerator();
      int denominator = this.denominator() * b.denominator();
      return new Rational_v0(num, denominator);
    }

    public Rational_v0 divides(Rational_v0 b)
    {
      int num = this.numerator() * b.denominator();
      int denominator = this.denominator() * b.numerator();
      return new Rational_v0(num, denominator);
    }

    public boolean equals(Object x)
    {
      if (this == x) return true;
      if (x == null) return false;
      if (this.getClass() != x.getClass()) return false;
      Rational_v0 that = (Rational_v0) x;
      if (this.numerator() != that.numerator()) return false;
      if (this.denominator() != that.denominator()) return false;
      return true;
    }

    public String toString()
    {
      return String.format("%d / %d", this.numerator(), this.denominator());
    }
  }

