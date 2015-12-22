import java.util.Scanner;
public class Program
{
    static Customer sid = new Customer("Sidney Crosby", new Address("123", "Pens Way", "Pittsburgh", "PA", "15312"), new Account(99000.0));
    static Customer peduto = new Customer("Bill Peduto", new Address("876", "Grant Street", "Pittsburgh","PA", "15112"), new Account(43216.67));
    static Customer brown = new Customer("Antonio Brown", new Address("1286", "Steeler Avenue", "Homestead", "PA", "15182"), new Account(87943.97));
    static Customer gates = new Customer("Bill Gates", new Address("400", "Microsoft Drive", "Redmond", "WA", "98052"), new Account(3858372.0));
    static Customer obama = new Customer("Barack Obama", new Address("1600", "Pennsylvania Avenue", "Washington", "D.C.", "20500"), new Account(12345.32));
    static Customer user;


    public static void main(String[] args)
    {
        String input = "";

        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Seifried National Bank! Thanks for choosing us!");
        System.out.println("Would you like to create an account with us?");

        if (scan.nextLine().equalsIgnoreCase("yes"))
        {
            user = createUserCustomer(); // Populates user properties with this method
        }


        do
        {
            displayCustomers();

            System.out.println("\nChoose an account to access...");
            input = scan.nextLine();

            chooseCustomerToAccess(input);

            // Type quit or restart
            System.out.println("Type 'quit' to exit, or 'return' to go back");
            input = scan.nextLine();
        }while(!input.equalsIgnoreCase("quit"));
    }

    // Display only the name and account number
    public static void displayCustomers()
    {
        System.out.println("\nHere is the current list of customers...\n");

        System.out.println("1: " + sid.getName() + " #" + sid.getAccount().getAccountNumber());
        System.out.println("2: " + peduto.getName() + " #" + peduto.getAccount().getAccountNumber());
        System.out.println("3: " + brown.getName() + " #" + brown.getAccount().getAccountNumber());
        System.out.println("4: " + gates.getName() + " #" + gates.getAccount().getAccountNumber());
        System.out.println("5: " + obama.getName() + " #" + obama.getAccount().getAccountNumber());
        if (user != null)
        {
            System.out.println("6: " + user.getName() + " #" + user.getAccount().getAccountNumber());
        }
    }

    public static void chooseCustomerToAccess(String choice)
    {
        switch(choice)
        {
            case "1":
                System.out.println("\n" + sid); // remove toString
                break;

            case "2":
                System.out.println(peduto);
                break;

            case "3":
                System.out.println(brown);
                break;

            case "4":
                System.out.println(gates);
                break;

            case "5":
                System.out.println(obama);
                break;

            case "6":
                if (user != null) // If the user didn't create an account...
                {
                    accessAccount(user);
                    break;
                }

            default:
                System.out.println("No data found.");
                break;
        }
    }

    public static void accessAccount(Customer cust)
    {

        Scanner scan = new Scanner(System.in);
        System.out.println("\nAccessing the account of " + cust.getName());
        System.out.println(cust.toString());
        System.out.println("Possible actions...");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. <Set balance>");
        System.out.println("4. Apply Interest");

        switch(scan.nextInt())
        {
            case 1:
                System.out.println("How much?: ");
                double w = scan.nextFloat();
                cust.getAccount().withdraw(w);
                System.out.println("\nYour new balance is " + cust.getAccount().getBalance());
                break;

            case 2:
                System.out.println("How much?: ");
                double d = scan.nextFloat();
                cust.getAccount().deposit(d);
                System.out.println("\nYour new balance is " + cust.getAccount().getBalance());
                break;

            case 3:
                System.out.println("New balance: ");
                double bal = scan.nextFloat();
                cust.getAccount().setBalance(bal);
                System.out.println("\nYour new balance is " + cust.getAccount().getBalance());
                break;
            case 4:
                System.out.println("\nYour new balance is " + cust.getAccount().addInterest());
                break;

            default:
                break;
        }
    }

    public static Customer createUserCustomer()
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nWhat is your name?");
        String name = scan.nextLine();

        System.out.println("\nHouse number?");
        String houseNum = scan.nextLine();

        System.out.println("\nStreet name?");
        String streetName = scan.nextLine();

        System.out.println("\nCity?");
        String city = scan.nextLine();

        System.out.println("\nState?");
        String state = scan.nextLine();

        System.out.println("\nZIP Code?");
        String zip = scan.nextLine();

        System.out.println("\nHow much would you like to initially deposit?");
        double balance = (scan.nextFloat());

        System.out.println("\nAccount created!");
        return new Customer(name, new Address(houseNum, streetName, city, state, zip), new Account(balance));
    }
}
