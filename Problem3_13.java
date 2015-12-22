import java.util.Scanner;
public class Problem3_13
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String input = "";
        System.out.println("Enter a string please: ");
        input = scan.nextLine();
        String j;
        
        // Strings to compare characters to
        final String consonants = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
        final String upperVowels = "AEIOU";

        int Acounter = 0;
        int Ecounter = 0;
        int Icounter = 0;
        int Ocounter = 0;
        int Ucounter = 0;
        int ConsCounter = 0;
        int SpacesCounter = 0;
        int PuncCounter = 0;
        int upperVowelsCounter = 0;

        for (int i = 0; i<input.length(); i++)
        {
            j = input.substring(i, i+1);
            switch(j)
            {
                case "a":
                { 
                    Acounter++;
                    break;
                }
                case "e":
                {
                    Ecounter++;
                    break;
                }
                case "i":
                {
                    Icounter++;
                    break;
                }
                case "o":
                {
                    Ocounter++;
                    break;
                }
                case "u":
                {
                    Ucounter++;
                    break;
                }
                case " ":
                {
                    SpacesCounter++;
                    break;
                }
                default:
                    if (consonants.contains(j) && !upperVowels.contains(j))
                        ConsCounter++;
                    else if (upperVowels.contains(j))
                        upperVowelsCounter++;
                    else
                        continue;
            }
        }
        int VowelCount =   Acounter + Ecounter + Icounter + Ocounter + Ucounter;
        PuncCounter = (input.length() - (ConsCounter + VowelCount + SpacesCounter)) - upperVowelsCounter;

        System.out.println("A occurs " + Acounter + " time(s).");
        System.out.println("E occurs " + Ecounter + " time(s).");
        System.out.println("I occurs " + Icounter + " time(s).");
        System.out.println("O occurs " + Ocounter + " time(s).");
        System.out.println("U occurs " + Ucounter + " time(s).");

        System.out.println("Spaces: " + SpacesCounter);
        System.out.println("Punctuation marks: " + PuncCounter);
        System.out.println("Consonants: " + ConsCounter);
        scan.nextLine();
    }
    
}
