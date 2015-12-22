import java.util.*;
public class RockPaperScissors
{
    static int userWins = 0;
    static int userLosses = 0;
    static int ties = 0;
    
    public enum Hand
    {
        Rock,
        Paper,
        Scissors
    }
    
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Hand user;
        Hand AI;
        String playAgain = "y";

        getTeamName();
        do
        {
            AI = generateHand(3);
            user = getUserHand();

            System.out.println("\nThe PC chose " + AI);

            determineWinner(AI, user);
            
            System.out.println("Would you like to play again? (y/n): ");
            playAgain = scan.nextLine();
            

        }while(!playAgain.equalsIgnoreCase("n"));
        
        showScore();
    }
    
    public static String getTeamName()
    {
        String teamName = "";
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello, welcome to Rock, Paper, Scissors Ultimate!\n");
        System.out.println("Enter a team name: ");
        teamName = scan.nextLine();
        return teamName;
    }
    
    public static Hand generateHand(int max)
    {
        int cpuChoice = 0;
        Random gen = new Random();
        cpuChoice = gen.nextInt(max) + 1;
        
        if(cpuChoice == 1)
            return Hand.Rock;
        else if(cpuChoice == 2)
            return Hand.Paper;
        else if(cpuChoice == 3)
            return Hand.Scissors;
        else
            return Hand.Rock;
    }
    
    public static Hand getUserHand()
    {
        String userChoice = "";
        Scanner scan = new Scanner(System.in);
        System.out.println("\nWhat do you choose (Rock, Paper, or Scissors)?: ");
        userChoice = scan.nextLine();
        
        if(userChoice.equalsIgnoreCase("Rock"))
            return Hand.Rock;
        else if(userChoice.equalsIgnoreCase("Paper"))
            return Hand.Paper;
        else if(userChoice.equalsIgnoreCase("Scissors"))
            return Hand.Scissors;
        else
            return Hand.Rock;
    }
    
    public static void determineWinner(Hand PC, Hand user)
    {
        if(PC == user)
        {
            System.out.println("It's a tie!");
            ties++;
        }
        
        else if(PC == Hand.Rock && user == Hand.Paper)
        {
            System.out.println("You win. Congrats.");
            userWins++;
        }
        
        else if(PC == Hand.Rock && user == Hand.Scissors)
        {
            System.out.println("You lose. Wow.");
            userLosses++;
        }
        
        else if(PC == Hand.Paper && user == Hand.Rock)
        {
            System.out.println("You lose. Wow.");
            userLosses++;
        }
        
        else if(PC == Hand.Paper && user == Hand.Scissors)
        {
            System.out.println("You win. Congrats.");
            userWins++;
        }
        
        else if(PC == Hand.Scissors && user == Hand.Rock)
        {
            System.out.println("You win. Congrats.");
            userWins++;
        }
        
        else if(PC == Hand.Scissors && user == Hand.Paper)
        {
            System.out.println("You lose. Wow.");
            userLosses++;
        }
    }
    
    public static void showScore()
    {
        System.out.println("\nWins: " + userWins);
        System.out.println("Losses: " + userLosses);
        System.out.println("Ties: " + ties);
    }
}
