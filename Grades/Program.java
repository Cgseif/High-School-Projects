package Grades;

import java.util.*;
import java.io.*;

public class Program
{
    static Student[] students;
    static String[] linebyline;

    public static void main(String[] args) throws IOException
    {
        Scanner fileScan;
        fileScan = new Scanner(new File("/home/chris/IdeaProjects/Chapter-3-Projects/src/Grades/input.txt"));

        int numberOfStudents = 0;
        numberOfStudents = Integer.parseInt(fileScan.nextLine());

        // These run parallel
        students = new Student[numberOfStudents];
        linebyline = new String[numberOfStudents];

        for(int i = 1; i <= linebyline.length; i++)
        {
            linebyline[i-1] = fileScan.nextLine();
        }

        alphabetize();

        // initialize student array with lines from the text file
        for(int i = 0; i < linebyline.length; i++)
        {
            students[i] = makeNewStudent(linebyline[i]);
        }

        displayOutput();
    }

    public static void displayHeading() throws IOException
    {
        FileWriter fileWriter = new FileWriter("/home/chris/IdeaProjects/Chapter-3-Projects/src/Grades/output.txt");
        BufferedWriter bufferedFile = new BufferedWriter(fileWriter);
        PrintWriter outFile = new PrintWriter(bufferedFile);

        outFile.println("  Student Name             e1  e2  e3  e4   avg");
        outFile.println("------------------------------------------------");

        System.out.println("  Student Name              e1  e2  e3  e4   avg");
        System.out.println("------------------------------------------------");

    }

    public static void alphabetize()
    {
        Arrays.sort(linebyline, 0, 17);
    }

    // Splits string from file into actual data we can use
    public static Student makeNewStudent(String line)
    {
        Student result = new Student();
        String delim = ":";
        String[] delimitedLine = line.split(delim);
        String[] grades = new String[4];

        // Copy last 4 elements of delimitedLine into an array of just the grades (in other words, exclude the name)
        System.arraycopy(delimitedLine, 1, grades, 0, 4);

        result.setName(delimitedLine[0]);
        result.setGrades(grades);

        return result;
    }

    public static void displayOutput() throws IOException
    {
        displayHeading();

        for(int i = 0; i < students.length; i++)
        {
            students[i].displayLine();
        }
    }
}
