// Chris Seifried
// Project: Hangman - Guess the puzzle read in randomly from a file
// Date: 19 March 2014

import java.util.*;
import java.io.*;

public class Program
{
    static ArrayList<Character> guesses = new ArrayList();
    static ArrayList<Character> correctGuesses = new ArrayList();
    static int wrongGuesses = 0;

    public static void main(String[] args) throws IOException
    {
        Scanner scan = new Scanner(System.in);
        boolean hasQuit = false;
        boolean gameOver = false;
        String input = "";

        System.out.println("Welcome to Hangman!");

        do
        {
            // Reset all lists and counters
            guesses.clear();
            correctGuesses.clear();
            wrongGuesses = 0;

            System.out.println("You get 6 guesses. Good luck! (Or you can type 'solve'\n" +
                                        "to try and solve it in one go)\n");
            Puzzle game = new Puzzle();
            System.out.println("Category: " + game.getCategory());

            do
            {
                System.out.println(showUnderscores(game));

                input = scan.nextLine().toUpperCase();
                if (guesses.contains(input)) 
                    System.out.println("You already guessed that letter!");
                
                else if (input.equalsIgnoreCase("solve"))
                {
                   boolean didSolve = trySolve(game);
                   if (didSolve)
                   {
                       System.out.println("Nice job!");
                       gameOver = true;
                   }
                   
                   else
                   {
                       System.out.println("\nWrong, but nice try!");
                   }
                }
                
                else
                    test(game, input);

                // No underscores left means the user solved the puzzle
                if (!showUnderscores(game).contains("_"))
                {
                    System.out.println(game.getPuzzle());
                    System.out.println("Nice job!");
                    gameOver = true;
                }

                else if (wrongGuesses == 6)
                {
                    System.out.println("Game over! The answer was " + game.getPuzzle());
                    gameOver = true;
                }
                else
                    continue;
            }while(gameOver == false);

            System.out.println("Would you like to start a new game of Hangman? [y/n]");
            input = scan.nextLine();
            if (!input.equalsIgnoreCase("y"))
                hasQuit = true;
            gameOver = false; // Reassign as false if they continue playing more games
        }while(hasQuit == false);
    }

    public static String getRandomLine() throws IOException
    {
        Scanner fileScan;
        Random rand = new Random();
        fileScan = new Scanner(new File("puzzles.txt"));
        ArrayList<String> lines = new ArrayList();
        int numberOfLines = 0;
        int randomLineNumber = 0;

        // Count the lines
        do
        {
            lines.add(fileScan.nextLine());
        }while(fileScan.hasNext());

        // Grab a random one
        randomLineNumber = rand.nextInt(lines.size());
        return lines.get(randomLineNumber);
    }

    public static String showUnderscores(Puzzle temp)
    {
        String underscores = "";
        if (correctGuesses.size() == 0)
        {
            for(int i = 0; i < temp.charArray().length; ++i)
            {
                if (temp.charArray()[i] == ' ') // include for all types of punctuation
                    underscores += " ";
                else
                    underscores += "_ ";
            }
        }

        else
        {
            for(int i = 0; i < temp.charArray().length; ++i)
            {
                if (temp.charArray()[i] == ' ') // include for all types of punctuation
                    underscores += " ";
                else if (correctGuesses.contains(temp.charArray()[i]))
                    underscores += temp.charArray()[i] + " ";
                else
                    underscores += "_ ";
            }
        }

        return underscores;

    }

    public static void test(Puzzle temp, String guess)
    {
        int counter = 0;
        char g = guess.charAt(0);

        if (!guesses.contains(g))
            guesses.add(g);

        for(int i = 0; i < temp.charArray().length; ++i) //For each char in the puzzle
        {
            if(temp.charArray()[i] == g) //if the current char is the guess
            {
                counter++;
            }
        }

        if(counter >= 1)
            correctGuesses.add(g);
        else
        {
            System.out.println("Wrong!");
            wrongGuesses++;
        }
    }
    
    public static boolean trySolve(Puzzle temp)
    {
        String guess = "";
        Scanner scan = new Scanner(System.in);
        System.out.println("What's the puzzle?: ");
        guess = scan.nextLine();
        
        if(temp.getPuzzle().equalsIgnoreCase(guess))
            return true;
        else
        {
            wrongGuesses++;
            return false;
        }   
        
    }
}
