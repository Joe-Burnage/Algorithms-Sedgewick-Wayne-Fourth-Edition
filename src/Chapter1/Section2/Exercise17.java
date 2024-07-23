package Chapter1.Section2;

import edu.princeton.cs.algs4.StdOut;

/*
Robust implementation of rational numbers. Use assertions to develop an
implementation of Rational (see Exercise 1.2.16) that is immune to overflow.
*/

public class Exercise17
{
  public static void main(String[] args)
  {
    Rational_v1[] rationals = new Rational_v1[4];
    rationals[0] = new Rational_v1(2147000000, 214700000);
    rationals[1] = new Rational_v1(2147000000, 1);
    rationals[2] = new Rational_v1(2, 3);
    rationals[3] = new Rational_v1(6, 9);
    for (Rational_v1 rational : rationals)
    {
      StdOut.println(rational);
    }
    StdOut.printf("%s + %s = %s\n", rationals[0], rationals[1], rationals[0].plus(rationals[1]));
    StdOut.printf("%s - %s = %s\n", rationals[0], rationals[3], rationals[0].minus(rationals[3]));
    StdOut.printf("%s ÷ %s = %s\n", rationals[0], rationals[3], rationals[0].divides(rationals[3]));
    StdOut.printf("%s == %s = %s\n", rationals[2], rationals[3], rationals[2].equals(rationals[3]));
    StdOut.printf("%s == %s = %s\n", rationals[0], rationals[2], rationals[0].equals(rationals[2]));
    //Assertion error due to integer overflow occurs on next line
    StdOut.printf("%s * %s = %s\n", rationals[0], rationals[1], rationals[0].times(rationals[1]));
  }
}

class Rational_v1 extends Rational_v0
{
  public Rational_v1 plus(Rational_v1 b)
  {
    assert Math.abs(this.numerator * b.denominator) <= Integer.MAX_VALUE : "Integer Overflow";
    assert Math.abs(b.numerator * this.denominator) <= Integer.MAX_VALUE : "Integer Overflow";

    long num1 = (long) this.numerator() * b.denominator();
    long num2 = (long) b.numerator() * this.denominator();
    assert Math.abs(num1 + num2) <= Integer.MAX_VALUE : "Integer Overflow";

    long denominator = (long) this.denominator() * b.denominator();
    assert Math.abs(denominator) <= Integer.MAX_VALUE : "Integer Overflow";

    int gcd = Rational_v1.gcd((int) (num1 + num2), (int) denominator);
    int numerator = (int) (num1 + num2) / gcd;
    return new Rational_v1(numerator, (int) denominator);
  }

  public Rational_v1 minus(Rational_v1 b)
  {
    assert Math.abs(this.numerator * b.denominator) <= Integer.MAX_VALUE : "Integer Overflow";
    assert Math.abs(b.numerator * this.denominator) <= Integer.MAX_VALUE : "Integer Overflow";

    long num1 = (long) this.numerator() * b.denominator();
    long num2 = (long) b.numerator() * this.denominator();
    assert Math.abs(num1 + num2) <= Integer.MAX_VALUE : "Integer Overflow";

    long denominator = (long) this.denominator() * b.denominator();
    assert Math.abs(denominator) <= Integer.MAX_VALUE : "Integer Overflow";

    int gcd = Rational_v1.gcd((int) (num1 - num2), (int) denominator);
    int numerator = (int) (num1 - num2) / gcd;
    return new Rational_v1(numerator, (int) denominator);
  }

  public Rational_v1 times(Rational_v1 b)
  {
    assert Math.abs(this.numerator * b.numerator) <= Integer.MAX_VALUE : "Integer Overflow";
    assert Math.abs(this.denominator * this.denominator) <= Integer.MAX_VALUE : "Integer Overflow";
    int num = this.numerator() * b.numerator();
    int denominator = this.denominator() * b.denominator();
    return new Rational_v1(num, denominator);
  }

  public Rational_v1 divides(Rational_v1 b)
  {
    assert Math.abs(this.numerator * b.numerator) <= Integer.MAX_VALUE : "Integer Overflow";
    assert Math.abs(this.denominator * this.denominator) <= Integer.MAX_VALUE : "Integer Overflow";
    int num = this.numerator() * b.denominator();
    int denominator = this.denominator() * b.numerator();
    return new Rational_v1(num, denominator);
  }

  public Rational_v1(int numerator, int denominator)
  {
    super(numerator, denominator);
  }
}
