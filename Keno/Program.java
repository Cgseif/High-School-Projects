// Chris Seifried
// Date: 27 May 2014
// Keno - Allows the user to guess 7 numbers and, depending on how many match
//        compared to a board of 20 random numbers, win a given amount of money


import java.util.*;

public class Program
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        boolean[] inputPicks = new boolean[81];
        int[] randomPicks = new int[20];
        String name = "";
        int money = 100;
        int bet = 0;
        boolean hasQuit = false;

        System.out.println("Welcome to the Four Rivers Casino!\nWhat is your name?: ");
        name = scan.nextLine();
        
        do
        { 
            // Clear the arrays before a new round
            Arrays.fill(inputPicks, false);
            Arrays.fill(randomPicks, 0);
            
            if(money <= 0) // Is the user out of money?
            {
                System.out.println("You're out of money! Game over!");
                hasQuit = true;
            }
            
            else
            {
                System.out.println("Ok " + name + ", you have $" + money
                                        + ". Would you like to play or quit [play/quit]?:");
                String playOrQuit = scan.nextLine();
                if (!playOrQuit.equalsIgnoreCase("play"))
                {
                    hasQuit = true;
                }
    
                else
                {
                    randomPicks = generateNumbers();
                    
                    System.out.println("How much would you like to bet?:");
                    bet = scan.nextInt();
                    money -= bet;

                    inputPicks = getUserPicks();
                    displayBoard(randomPicks);
                    int matches = checkMatchingNumbers(randomPicks, inputPicks);
                    money += determinePayout(matches, bet);
                    
                }
            }
            
        } while(!hasQuit);
    }

    public static boolean[] getUserPicks()
    {
        int currentNum = 1; // Which number the user currently needs to enter
        boolean[] pickArray = new boolean[81];
        Scanner scan = new Scanner(System.in);
        boolean isNumberOk;
        int pick; // What their current pick actually is

        System.out.println("Please enter 7 unique numbers from 1 to 80");
        for (int i = 1; i < 8; i++)
        {
            isNumberOk = false; // Reset it
            while(!isNumberOk)
            {
                System.out.println("Enter your number " + currentNum + ": ");
                pick = scan.nextInt();
                scan.nextLine();
                if (pick < 1 || pick > 80)
                {
                    System.out.println("Sorry, that number is out of range. The number must be between 1 and 80");
                }

                else if (pickArray[pick]) // Did the user already select this number?
                {
                    System.out.println("You've already entered that number, please choose another");
                }

                else
                {
                    isNumberOk = true;
                    pickArray[pick] = true;
                    currentNum++;
                }
            }
        }

        return pickArray;
    }

    public static int[] generateNumbers()
    {
        Random gen = new Random();
        ArrayList<Integer> board = new ArrayList<Integer>();
        int[] numbers = new int[20];
        int temp = 0;

        for(int i = 0; i < 20; i++)
        {
            do
            {
              temp = gen.nextInt(80)+1;
            }while(board.contains(temp));
            board.add(temp);
            temp = 0;
        }
        
        // Takes the board and converts it to an int[]
        for (int i = 0; i < board.size(); i++)
        {
            numbers[i] = board.get(i);
        }
        return numbers;
    }
    
    public static void displayBoard(int[] board)
    {
        System.out.println("The computer has picked the following numbers:");
        for(int i = 0; i < board.length; i++)
        {
            System.out.print(board[i] + "  "); 
        }
        System.out.println();
    }
    
    public static int checkMatchingNumbers(int[] board, boolean[] userPicks)
    {
        int n = 0;
        int matches = 0;
        int[] listOfPicks = new int[7];
        
        // Converts boolean array into an array of integers we can work with
        for(int j = 0; j < 80; j++)
        {
            if(userPicks[j])
            {
                listOfPicks[n] = j;
                n++;
            }
        }
        
        // Check between listOfPicks and the board
        for(int i = 0; i < listOfPicks.length; i++)
        {
            for(int number : board)
            {
                if(number == listOfPicks[i])
                    matches++;
            }
        }

        return matches;
    }
    
    public static int determinePayout(int matches, int wager)
    {
        int winnings;

        switch (matches)
        {
            case 4:
                winnings = wager;
                break;
            case 5:
                winnings = wager * 20;
                break;
            case 6:
                winnings = wager * 200;
                break;
            case 7:
                winnings = wager * 12000;
                break;
            default:
                winnings = 0;
                break;
        }
        
        System.out.println("You matched " + matches +  " number(s); you win $" + winnings + ".");
        
        return winnings;
    }
}
