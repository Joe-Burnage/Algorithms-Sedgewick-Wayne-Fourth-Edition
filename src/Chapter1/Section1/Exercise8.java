package Chapter1.Section1;

/*
What do each of the following print?
a. System.out.println('b');
b. System.out.println('b' + 'c');
c. System.out.println((char) ('a' + 4));
Explain each outcome.
*/
public class Exercise8
{
  public static void main(String[] args)
  {

    System.out.print("a)\nExpression:  System.out.println('b')\nOutput:      ");
    System.out.println('b');
    System.out.println("Explanation: Prints the character 'b'.");
    System.out.print("b)\nExpression:  System.out.println('b' + 'c')\nOutput:      ");
    System.out.println('b' + 'c');
    System.out.println("Explanation: Sums the character values for b (98) and c(99), giving 197.");
    System.out.print("c)\nExpression:  System.out.println('a' + 4)\nOutput:      ");
    System.out.println((char) ('a' + 4));
    System.out.println("Explanation: Adds 4 to the character value for a (97)," +
        " and prints the character with value 101 (e).");

  }
}
