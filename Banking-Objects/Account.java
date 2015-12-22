import java.util.Random;
import java.text.*;

public class Account
{
    private String accNumber = "";
    private double balance;
    static double interestRate = .03;

    // Generate account number upon object initialization (constructor)
    public Account()
    {
        Random gen = new Random();
        for (int i=0; i < 5; i++)
        {
            accNumber += gen.nextInt(10);
        }

        balance = 0.0;
    }

    public Account(double bal)
    {
        Random gen = new Random();
        for (int i=0; i < 5; i++)
        {
            accNumber += gen.nextInt(10);
        }

        balance = bal;
    }

    public String getAccountNumber()
    {
        return accNumber;
    }

    public String getBalance()
    {
        NumberFormat money = NumberFormat.getCurrencyInstance();
        return money.format(balance);
    }

    public void setBalance(double newBalance)
    {
        balance = newBalance;
    }

    public void withdraw(double amount)
    {

        if (balance > amount)
            balance -= amount;
        else
            System.out.println("Not enough to withdraw.");
    }

    public void deposit(double amount)
    {
        balance += amount;
    }

    public String addInterest()
    {
       NumberFormat money = NumberFormat.getCurrencyInstance();
       deposit(balance * interestRate);
       return money.format(balance);
    }
}
