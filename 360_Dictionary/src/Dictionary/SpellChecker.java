package Dictionary;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class SpellChecker
{
	
	public static void main(String[] args)
	{
		
		Dictionary dictionary =  null;
		TextFile file = null;
	
		boolean fileExists = false;
		
		//Attempt to load the dictionary
		Scanner input = null;
		ArrayList<String> dictionaryArray = new ArrayList<String>();
		
		try
		{
			//Create the scanner to take in input
			input = new Scanner(new File("Dictionary.txt"));
			String line = input.next();
			
			//Add one line at a time to the dictionary array
			while (input.hasNext())
			{
				dictionaryArray.add(line);
				line = input.next();
			}
			
			input.close();
		}
		catch (Exception e)
		{
			System.out.println("The dictionary.txt file cannot be found."
					+ "\nNo words will be found correct."
					+ "\nA new dictionary.txt file will be output after "
					+ "a file is finished being processed.");
			
			//Close the file in case of an exception
			if (input != null)
				input.close();
			
			dictionaryArray = new ArrayList<String>();
		}
		
		dictionary = new Dictionary(dictionaryArray);
		
		//Prompt user for the file to input
		try
		{	
			//Keep taking input until a proper file is found
			while(!fileExists)
			{
				input = new Scanner(System.in);
				System.out.print("Enter file name with extension(.txt): ");
				file = new TextFile(input.nextLine());
				
				fileExists = true;
			}
		}	
		catch (Exception e)
		{
			System.out.println("Could not find file. Please make sure the file is in the directory and try again.");
		}
		
		
		runSpellcheck(file, dictionary);
	}
		
	private static void runSpellcheck(TextFile file, Dictionary dictionary)
	{
		
	}
}
