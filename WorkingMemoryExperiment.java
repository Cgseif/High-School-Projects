// Working Memory Experiment:  This program asks a user to recall a randomized string of up to 10 digits
//                             after a few seconds.  The results of the test are shown once the user
//                             decides to exit.
// Author: Chris Seifried
// Date: 1-13-14

import java.util.*;
public class WorkingMemoryExperiment
{
    static int Pause = 4 ;
    static int Screen_Size = 100;

    //Declare int arrays while setting the exact number of elements in each
    static int[] length = new int[10];          // Number of strings for each length
    static int[] RightPerLength = new int[10];  // How many are right for each length
    static int[] WrongPerLength = new int[10];  // How many are wrong for each length
    static String globalResult = "";
    static String guess = "";
    static boolean InstructionsUnderstood = true;
    static boolean userExited = false;
    
    //Most of the program is in main
    public static void main (String [] args)  
    {
        showDirections();

        while(!userExited)
        {
            clearScreen();
            generateDigits(10);
            System.out.println(globalResult);
            pause(Pause);
            clearScreen();
            getInput();
            if(userExited)
                showResults();
            getLength();
            countRightOrWrong(guess);
        }
    }

    public static String generateDigits(int maxDigits)  
    {
         Random generator = new Random( ) ;
         int numberDigits = generator.nextInt(maxDigits) + 1 ;
         String result = "";
         for ( int n = 0 ; n < numberDigits ; n++) {
              result  =  result  +  generator.nextInt(10) ;
         }

         globalResult = result;
         return result ;
    }

    //Go to sleep for a specified number of seconds.
    public static void pause (int seconds)  
    {
       try
       {
             Thread.sleep(seconds *1000)  ; 
       }
       catch ( InterruptedException e )  { }
    }

    public static void showDirections()
    {
        Scanner scan = new Scanner(System.in);
        String understood = "";
        while(!understood.equals("yes"))
        {
            System.out.println("This program will be used to test your short-term memory." +
            " A random number \nwill appear on the screen for a short time, and you will have to " + 
            "remember it \nand type it in afterwards.");
            
            System.out.println("Do you understand? [yes/no]");
            understood = scan.nextLine();
            
            if (understood.equals("yes"))
                InstructionsUnderstood = true;
        }
    }

    public static void clearScreen()
    {
        for(int i = 0; i <= 30; i++)
        {
            System.out.println();
        }
    }

    // If the length of generated string is n, count it to its own element (length[n-1]++)
    public static int[] getLength()
    {
         switch(globalResult.length())
         {
             case 1:
             length[0]++;
             break;
             
             case 2:
             length[1]++;
             break;
             
             case 3:             
             length[2]++;
             break;
             
             case 4:
             length[3]++;
             break;
             
             case 5:
             length[4]++;
             break;
             
             case 6:
             length[5]++;
             break;
             
             case 7:
             length[6]++;
             break;
             
             case 8:
             length[7]++;
             break;
             
             case 9:
             length[8]++;
             break;
             
             case 10:
             length[9]++;
             break;
             
             default:
             break;
         }
         return length;
    }
    
    public static String getInput()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the previous sequence (or 'exit' to quit):\n");
        guess = scan.nextLine();
        if (guess.equalsIgnoreCase("exit"))
            userExited = true;

        return guess;
    }

    // While the generated string is of length n, check if the user's guess equals the generated string
    // Then, if it is correct, count it as right and assign it to the corresponding element in the "RightPerLength"
    // array.  If wrong, count it as wrong and assign it to the corresponding element in the "WrongPerLength" array.
    public static void countRightOrWrong(String input)
    {
        switch(globalResult.length())
        {
            case 1:
                if (input.equals(globalResult))
                {
                    RightPerLength[0]++;
                    break;
                }

                else
                {
                    WrongPerLength[0]++;
                    break;
                }

            case 2:
                if(input.equals(globalResult))
                {
                    RightPerLength[1]++;
                    break;
                }

                else
                {
                    WrongPerLength[1]++;
                    break;
                }

            case 3:
                if(input.equals(globalResult))
                {
                    RightPerLength[2]++;
                    break;
                }

                else
                {
                    WrongPerLength[2]++;
                    break;
                }

            case 4:
                if(input.equals(globalResult))
                {
                    RightPerLength[3]++;
                    break;
                }

                else
                {
                    WrongPerLength[3]++;
                    break;
                }

            case 5:
                if(input.equals(globalResult))
                {
                    RightPerLength[4]++;
                    break;
                }

                else
                {
                    WrongPerLength[4]++;
                    break;
                }

            case 6:
                if(input.equals(globalResult))
                {
                    RightPerLength[5]++;
                    break;
                }

                else
                {
                    WrongPerLength[5]++;
                    break;
                }

            case 7:
                if(input.equals(globalResult))
                {
                    RightPerLength[6]++;
                    break;
                }

                else
                {
                    WrongPerLength[6]++;
                    break;
                }

            case 8:
                if(input.equals(globalResult))
                {
                    RightPerLength[7]++;
                    break;
                }

                else
                {
                    WrongPerLength[7]++;
                    break;
                }

            case 9:
                if(input.equals(globalResult))
                {
                    RightPerLength[8]++;
                    break;
                }

                else
                {
                    WrongPerLength[8]++;
                    break;
                }

            case 10:
                if(input.equals(globalResult))
                {
                    RightPerLength[9]++;
                    break;
                }

                else
                {
                    WrongPerLength[9]++;
                    break;
                }
            }
        }

    public static void showResults()
    {
        for(int i = 1; i <= 10; i++)
        {
            System.out.println("When the generated sequence was " + i + " numbers long, you guessed " + RightPerLength[i-1] +
            " right and " + WrongPerLength[i-1] + " wrong.\n");
        }
    }

    } //end class

//WM_Experiment

//End-Of-File

