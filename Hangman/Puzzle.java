import java.io.*;

public class Puzzle
{
    static String category;
    static String puzzle;
    static String line;

    public Puzzle() throws IOException
    {
        line = Program.getRandomLine();
        String temp[] = line.split(":");
        category = temp[0];
        puzzle = temp[1];
    }

    public static String getLine()
    {
        return line;
    }

    public static String getCategory()
    {
        return category;
    }

    public static String getPuzzle()
    {
        return puzzle;
    }

    public static char[] charArray()
    {
        return puzzle.toCharArray();
    }
}
