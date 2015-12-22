// Chris Seifried
// 11-22-13


import java.text.NumberFormat;
import java.util.Scanner;

public class LoanProject
{ // - begin LoanProject
    public static void main(String[] args)
    { // - begin main
        Scanner scan = new Scanner(System.in);
        NumberFormat money = NumberFormat.getCurrencyInstance();
        double principal = 0.0;
        double percentInterest = 0.0;
        double monthlyPayment = 0.0;
        double financeCharges = 0.0;

        int loanMonths = 0;
        String doAnotherCalc = "yes";

        System.out.println("Welcome to the Shaler Area Loan Calculator!");

        while (doAnotherCalc.equals("yes"))
        {
            System.out.println("Enter the amount that you want to borrow: ");
            principal = scan.nextFloat();

            System.out.println("Enter the interest rate (as a percent): ");
            percentInterest = scan.nextFloat();

            System.out.println("Enter the term of your loan (in months): ");
            loanMonths = scan.nextInt();

            System.out.println("Here is some information about your loan: ");

            double rate = percentInterest / 1200;

            // Calculate monthly payment
            // monthlyPayment = (  rate + ( rate/(Math.pow((1.0+rate), loanMonths))-1.0 )   ) * principal;
            monthlyPayment = principal * rate / (1 - 1/Math.pow(1 + rate, loanMonths));

            // Calculate financial charges
            financeCharges = (monthlyPayment * loanMonths) - principal;

            System.out.println("Your monthly payment is: " + money.format(monthlyPayment));
            System.out.println("Your total finance charges are: " + money.format(financeCharges));

            System.out.println("Do another calculation? [yes/no]");
            scan.nextLine();      // Purges the output buffer so that the user has a chance to enter their choice
            doAnotherCalc = scan.nextLine().toLowerCase();
            System.out.println();

            if (doAnotherCalc.equals("no"))
            {
                break;
            }
        }
    } // - end main
} // - end LoanProject

// - end file
