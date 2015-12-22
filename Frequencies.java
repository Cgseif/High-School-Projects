import java.util.Scanner;
class Problem6_4
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int[] storeValues = new int[9];
        int userInput = 0;
        System.out.println("Enter some integers between 1 and 100. Type '-1' when you are finished");
        while(userInput > 0)
        {
            userInput = scan.nextInt();
            
            if (userInput >= 1 && userInput <= 10)
                storeValues[0]++;
            
            else if (userInput >= 11 && userInput <= 20)
                storeValues[1]++;
            
            else if (userInput >= 21 && userInput <= 30)
                storeValues[2]++;
            
            else if (userInput >= 31 && userInput <= 40)
                storeValues[3]++;
            
            else if (userInput >= 41 && userInput <= 50)
                storeValues[4]++;
            
            else if (userInput >= 31 && userInput <= 40)
                storeValues[5]++;
            
            else if (userInput >= 31 && userInput <= 40)
                storeValues[6]++;
            
            else if (userInput >= 31 && userInput <= 40)
                storeValues[7]++;
            
            else if (userInput >= 31 && userInput <= 40)
                storeValues[8]++;
            
            else if (userInput >= 31 && userInput <= 40)
                storeValues[9]++;
       
        }
    }
    
    public static void showResults()
    {
        System.out.println("Here are the frequencies...");
        
        for (int i = 0; i < 10; i++)
        {
            System.out.println("*");
        }
    }
}
