package Chapter1.Section3;

import edu.princeton.cs.algs4.StdOut;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.Objects;

/*
Listing files. A folder is a list of files and folders. Write a program that takes the
name of a folder as a command-line argument and prints out all the files contained
in that folder, with the contents of each folder recursively listed (indented) under that
folder’s name. Hint : Use a queue, and see java.io.File.
*/
public class Exercise43
{
  public static void main(@NotNull String @NotNull [] args)
  {
    File folder = new File(args[0]);
    if (!folder.isDirectory()) throw new RuntimeException("Couldn't find folder");
    printFolder(folder, 0);
  }

  public static void printFolder(@NotNull File folder, int depth)
  {
    String folderPath = folder.getAbsolutePath();
    Queue files = new Queue();
    if (Objects.isNull(folder.list())) return;
    for (String file : Objects.requireNonNull(folder.list()))
      files.enqueue(file);
    while (!files.isEmpty())
    {
      File file = new File(folderPath + "\\" + files.dequeue());
      for (int i = 0; i < depth; i++)
        StdOut.print("  ");
      StdOut.println(file.getName());
      if (file.isDirectory()) printFolder(file, depth + 1);
    }
  }
}
