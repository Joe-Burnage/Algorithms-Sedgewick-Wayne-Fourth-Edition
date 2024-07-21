package Chapter1.Section1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise21
{

  private static void printTableHeader()
  {
    StdOut.printf("╔════════════╦═════════╦═════════╦════════════╗\n");
    StdOut.printf("║    Name    ║  Score  ║  Total  ║   Result   ║\n");
    StdOut.printf("╠════════════╬═════════╬═════════╬════════════╣\n");
  }

  public static void printTableRow(String input)
  {
    String[] values = input.split(" ");
    String name = values[0];
    String score = values[1];
    String total = values[2];
    double result = Double.parseDouble(score) / Double.parseDouble(total);
    StdOut.printf("║%12s║%9s║%9s║%12.3f║\n", name, score, total, result);
  }


  public static void main(String[] args)
  {
    int i = 0;
    while (StdIn.hasNextLine())
    {
      if (i == 0)
        printTableHeader();
      String line = StdIn.readLine();
      if (line.isEmpty())
      {
        StdOut.printf("╚════════════╩═════════╩═════════╩════════════╝\n");
        break;
      } else if (i != 0)
      {
        StdOut.printf("╠════════════╬═════════╬═════════╬════════════╣\n");
      }
      printTableRow(line);
      i++;
    }
  }
}
