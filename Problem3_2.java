import java.util.Scanner;

public class Problem3_2
{
    public static void main(String[] args)
    {
        int input = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a year: ");
        input = scan.nextInt();

        if (input % 100 == 0 && input % 400 == 0)
            System.out.println("That is a leap year.");


        else if (input < 1582)
            System.out.println("The calendar didn't even exist in that year!");

        else
            System.out.println("That is not a leap year");
    }
}
