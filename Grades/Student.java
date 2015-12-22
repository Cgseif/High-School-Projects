package Grades;

import java.io.*;

public class Student
{
    private String fullName = "";
    private int[] grades = new int[4];

    public Student()
    {
    }

//    public Student(String name, int[] scores)
//    {
//        fullName = name;
//        grades = scores;
//    }

    public double averageGrade()
    {
        double result = 0.0D;
        for (int i = 0; i < grades.length; i++)
        {
            result += grades[i];
        }

        return result /= grades.length;
    }

    public String getName()
    {
        return fullName;
    }

    public int[] getGrades()
    {
        return grades;
    }

    public void setName(String name)
    {
        fullName = name;
    }

    public void setGrades(String[] sGrades)
    {
        for(int i = 0; i < sGrades.length; i++)
        {
            grades[i] = Integer.parseInt(sGrades[i]);
        }
    }

    public void displayLine() throws IOException
    {
        FileWriter fileWriter = new FileWriter("/home/chris/IdeaProjects/Chapter-3-Projects/src/Grades/output.txt");
        BufferedWriter bufferedFile = new BufferedWriter(fileWriter);
        PrintWriter outFile = new PrintWriter(bufferedFile);

        System.out.printf("%-27s %2d  %2d  %2d  %2d  %2.1f  %n", this.getName(), this.getGrades()[0],
                this.getGrades()[1], this.getGrades()[2], this.getGrades()[3], this.averageGrade());

        outFile.printf("%-27s %2d  %2d  %2d  %2d  %2.1f  %n", this.getName(), this.getGrades()[0],
                this.getGrades()[1], this.getGrades()[2], this.getGrades()[3], this.averageGrade());
    }
}
