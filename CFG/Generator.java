//Program:  CFG Generator
//Author:   Chris Seifried
//Date:     13 April 2014

import java.util.Random;

public class Generator
{
    public static String Generate_Sentence(String category)
    {
        String sentence = "";

        // Is the current string actually a category/set of categories and must it be split?
        if(isCategory(category) && needsToBeSplit(category))
        {
            // Split subcategories into array, using a space as the delimiter
            String[] subcategories = category.split(" ");

            for(int i = 0; i < subcategories.length; i++)
            {
                // Set the current subcategory as the current "category"
                category = subcategories[i];
                sentence += Generate_Sentence(Select_Expansion(category));  //Expand category & reiterate
            }
        }

        // What if it is just a single category?
        else if(isCategory(category))
        {
            sentence += Generate_Sentence(Select_Expansion(category));
        }

        // For actual words, etc.
        else
        {
            sentence += category + ' ';
        }

        return sentence;
    }
    
    public static boolean isCategory(String category)
    {
        return Character.isUpperCase(category.charAt(0));
    }
    
    public static boolean needsToBeSplit(String category)
    {
        return category.contains(" ");
    }
    
    //YOUR OTHER FUNCTIONS GO HERE!!!!!

    //  Select_Expansion will randomly expand Category according to the following
    //  grammar.  Returns category name in lowercase letters if there is no expansion.

    static String[] Grammar =  {
        "S -> NAME VP",
        "VP -> V NP",
        "NP -> ART NN",
        "NN -> ADJ NN",
        "NN -> N",
        "ART -> a",
        "V -> is",
        "V -> looks like",
        "V -> acts like",
        "NAME -> george",
        "NAME -> mr novacky",
        "NAME -> prof novacky",
        "NAME -> jon",
        "NAME -> obien",
        "NAME -> steve",
        "NAME -> luke",
        "ADJ -> nice",
        "ADJ -> mean",
        "ADJ -> smart",
        "ADJ -> stupid",
        "ADJ -> hip",
        "ADJ -> geeky",
        "ADJ -> normal",
        "ADJ -> strange",
        "ADJ -> terrible",
        "ADJ -> great",
        "N -> person",
        "N -> fool",
        "N -> smarty-pants",
        "N -> ninja"
    };
    
    static Random generator = new Random();

    public static String Select_Expansion(String Category)
    {
        //Variables:
        String This_Rule = " ", Rule_RHS = " ", Rule_LHS = " ";
        int Number_of_Expansions = 0, Expansion_to_Use = 0;
        //Count expansions for Category:
        for (int n = 0 ; n < Grammar.length; n++)
        {
            This_Rule = Grammar[n];
            Rule_LHS = This_Rule.substring(0,This_Rule.indexOf(" -> "));
            if (Rule_LHS.equals(Category)) Number_of_Expansions++;
        }
    
        //return category in lowercase letters if no expansions:
        if ( Number_of_Expansions == 0) return Category.toLowerCase();
        //Randomly select which expansion to use:
        Expansion_to_Use =  generator.nextInt(Number_of_Expansions);
        //Go through rules while counting down through expansions of Category,
        //and break with selected expansion:
        for ( int n = 0;  n < Grammar.length; n++)
        {
            This_Rule  =  Grammar[n];
            Rule_LHS = This_Rule.substring(0, This_Rule.indexOf(" "));
            Rule_RHS = This_Rule.substring(This_Rule.indexOf(" -> ")  + 4);
            if ( Rule_LHS.equals(Category)  &&  (Expansion_to_Use == 0) )
                break;  
            if ( Rule_LHS.equals(Category) )  Expansion_to_Use--;
        }
        
        return Rule_RHS;
    
    }
}   
// End-of-File
