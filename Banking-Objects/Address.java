public class Address
{
    private String streetNum;
    private String streetName;
    private String city;
    private String state;
    private String zip;

    public Address(String num, String name, String c, String st, String z)
    {
        streetNum = num;
        streetName = name;
        city = c;
        state = st;
        zip = z;
    }

    // No address data given
    public Address()
    {
        streetNum = "";
        streetName = ": No address data available. ";
        city = "N/A";
        state = "N/A";
        zip = "00000";
    }

    public String toString()
    {
        String result;
        return result = streetNum + " " + streetName + "\n\t" + city + ", " + state + " " + zip;
    }
}
