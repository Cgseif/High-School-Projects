public class Customer
{
    private String name;
    private Address address;
    private Account account = new Account();

    public Customer(String n, Address add, Account acc)
    {
        name = n;
        address = add;
        account = acc;
    }

    // Maybe the user doesn't want to enter an address at this time
    public Customer(String n, Account acc)
    {
        name = n;
        account = acc;
    }

    public Customer()
    {
    }

    public String getName()
    {
        return name;
    }

    public void setName(String n)
    {
        name = n;
    }

    public Account getAccount()
    {
        return account;
    }

    public Address getAddress()
    {
        return address;
    }


    public String toString()
    {
        String output = "\t" + name + " : #" + account.getAccountNumber() + "\n\t" + address.toString() + "\n\t" +
                "Balance: " + account.getBalance() + "\n";
        return output;
    }

    public boolean equals(Customer cust)
    {
        return (name == cust.name);
    }
}
