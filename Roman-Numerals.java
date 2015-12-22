// Chris Seifried
// 12-16-13
// Integer to Roman Numeral:  The program asks for a user to enter an integer from 1 up to 25 and 
//                            converts it to a Roman numeral format.  It then asks the user if 
//                            they want to convert another number.

import java.util.Scanner;

class Seifried_Roman_Numerals
{ // begin class
    public static void main(String[] args)
    { // begin main
        Scanner scan = new Scanner(System.in);
        int nInput = 0;
        String sInput = "";
        String piece = "";
        String output = "";
        String numeralOne = "I", numeralFour = "IV", numeralFive = "V", numeralNine = "IX", numeralTen = "X";
        String runAgain = "yes";
        // Declares an array (basically a list) of 2 empty characters
        // cInput[0] returns the first character, cInput[1] returns the second character in the list 
        char[] cInput = new char[1];
        
        do
        {
            System.out.println("Enter the number you wish to convert to roman numerals");
            nInput = scan.nextInt();
            sInput = Integer.toString(nInput);
           if (nInput < 1 || nInput > 25)
            {
                System.out.println("You entered a number out of the range.");
            }
            else
            {
                // Add a 0 to the input if it is only 1 digit
                if(sInput.length() == 1)
                    sInput = "0" + sInput;
                
                 // Assign the characters of the input string to the array already defined (cInput)
                 cInput = sInput.toCharArray();

                switch(cInput[0])
                {
                    case '0':
                    break;
                    
                    case '1':
                    output += numeralTen;
                    break;
                    
                    case '2':
                    output+= numeralTen + numeralTen;
                    break;
                    
                    default:
                    break;
                }
                
                switch(cInput[1])
                {
                    case '0':
                    break;

                    case '1':
                    output = output + numeralOne;
                    break;
                    
                    case '2':
                    output = output + numeralOne + numeralOne;
                    break;
                    
                    case '3':
                    output = output + numeralOne + numeralOne + numeralOne;
                    break;
                    
                    case '4':
                    output = output + numeralFour;
                    break;
                    
                    case '5':
                    output += numeralFive;
                    break;
                    
                    case '6':
                    output += numeralFive + numeralOne;
                    break;
                    
                    case '7':
                    output += numeralFive + numeralOne + numeralOne;
                    break;
                    
                    case '8':
                    output += numeralFive + numeralOne + numeralOne + numeralOne;
                    break;
                    
                    case '9':
                    output += numeralNine;
                    break;
                    
                    default:
                    break;
                }
            
                System.out.println(output);
                output = "";
                System.out.println("\nWould you like to enter another number?");
                runAgain = scan.next();
            }
        }while(runAgain.equalsIgnoreCase("yes"));
    } // end main
} // end class
