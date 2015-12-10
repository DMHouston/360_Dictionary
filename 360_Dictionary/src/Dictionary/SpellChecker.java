package Dictionary;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class SpellChecker
{
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		boolean continueLoadingFiles = false;
		
		do
		{
			Dictionary dictionary =  null;
			TextFile file = null;
		
			boolean fileExists = false;
			
			//Attempt to load the dictionary
			ArrayList<String> dictionaryArray = new ArrayList<String>();
			
			Scanner fileScanner = null;
			
			try
			{
				//Create the scanner to take in input
				fileScanner = new Scanner(new File("Dictionary.txt"));
				String line = fileScanner.next();
				
				//Add one line at a time to the dictionary array
				while (fileScanner.hasNext())
				{
					dictionaryArray.add(line);
					line = fileScanner.next();
				}
				
				//Must add the last line
				dictionaryArray.add(line);
				
				fileScanner.close();
			}
			catch (Exception e)
			{
				System.out.println("The dictionary.txt file cannot be found."
						+ "\nNo words will be found correct."
						+ "\nA new dictionary.txt file will be output after "
						+ "a file is finished being processed.");
				
				//Close the file in case of an exception
				if (fileScanner != null)
					fileScanner.close();
				
				dictionaryArray = new ArrayList<String>();
			}
			
			dictionary = new Dictionary(dictionaryArray);
			
			
			try
			{	
				//Keep taking input until a proper file is found
				while(!fileExists)
				{
					System.out.print("Enter file name with extension(.txt): ");
					file = new TextFile(input.nextLine());
					
					fileExists = true;
					
					runSpellcheck(input, file, dictionary);
					
					dictionary.saveOutput(input);
				}
			}	
			catch (Exception e)
			{
				System.out.println("Could not find file."
						+ "\nPlease make sure the file is in the directory and try again.");
			}
			
			
			System.out.println("Continue loading files? Enter yes or no.");
			String line = null;
			while (line == null)
			{
				line = input.nextLine();
				if (line.toLowerCase().equals("yes"))
					continueLoadingFiles = true;
				else if (line.toLowerCase().equals("no"))
					continueLoadingFiles = false;
				else
				{
					line = null;
					System.out.println("Please enter yes or no.");
				}
			}
		}
		while (continueLoadingFiles);
		input.close();
	}
		
	private static void runSpellcheck(Scanner input, TextFile file, Dictionary dictionary)
	{
		//Replace input with GUI interaction
		//Scanner input = new Scanner(System.in);
		
		ArrayList<String> wordList = file.getDocument();
		
		//Ask the user for each word not found
		for (int wordNum = 0; wordNum < wordList.size(); wordNum ++)
		{
			if (!dictionary.searchWord(wordList.get(wordNum)))
			{
				//Replace with GUI interaction
				System.out.println("'" + wordList.get(wordNum) + "' is not in the dictionary."
						+ "\nWould you like to add it? Please enter yes or no.");
				
				String answer = null;
				//Continue prompting for input until "yes" or "no" is received
				while (answer == null)
				{
					answer = input.nextLine();
					//Add word
					if (answer.toLowerCase().equals("yes"))
						dictionary.addWord(wordList.get(wordNum));
					//Ignore word
					else if (answer.toLowerCase().equals("no"))
						dictionary.ignoreWord(wordList.get(wordNum));
					//Continue prompting input for yes or no
					else
					{
						System.out.println("Please enter yes or no.");
						answer = null;
					}
				}
			}
		}
	}
}
