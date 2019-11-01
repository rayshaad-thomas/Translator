/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yomommatranslator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author rtho137
 */
public class YoMommaTranslator 
{

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException 
    {
        Map <String, String> acronyms = new TreeMap<>();
        File input = new File ("acronyms.txt"); // READ FILE
        Scanner in = new Scanner (input);
        String line;
        while (in.hasNextLine()) 
        {
            line = in.nextLine();
            String[] split = line.split("\\t"); // SPLIT
            acronyms.put(split[0].toLowerCase(), split[1].toLowerCase()); // LOAD TREE MAP
        }
            System.out.println("Enter a sentence: "); // ASK FOR INPUT
            Scanner user = new Scanner(System.in).useDelimiter("\\n");
            String userInput = user.next(); // USER INPUT
            String [] split = userInput.split("\\s+");
            String expand = " ";
        for (String split1 : split) // GO THROUGH ARRAY, FIND KEYS AND REPLACE THEM
        {
            if (acronyms.containsKey(split1.toLowerCase())) 
            {
                expand += acronyms.get(split1.toLowerCase()) + " ";
            } 
            else 
            {
                expand += (split1) + " ";
            }
        }
        System.out.println(expand); // RETURN EXPANDED VERSION
    }
}
// DONE