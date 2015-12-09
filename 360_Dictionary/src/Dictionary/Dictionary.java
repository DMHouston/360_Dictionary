package Dictionary;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//Dictionary class handles creating the ArrayLists, searching for a word(boolean), adding a word(void), displaying output(void), toSting(String)
public class Dictionary
{
	// note for array list, default starting size is 10
	private ArrayList<String> dictionary = new ArrayList<String>();
	private ArrayList<String> wordsAdded = new ArrayList<String>();
	private ArrayList<String> ignoredWords = new ArrayList<String>();
	
	public Dictionary(ArrayList<String> wordList)
	{
		dictionary = wordList;
	}
	
	//Returns true if the word is found in dictionary or ignoredWords.
	public boolean searchWord(String word)
	{
		boolean foundInEither = dictionary.contains(word);
		return foundInEither;
	}
	
	//Appends the specified element to the end of the wordsAdded and dictionary ArrayLists
	public void addWord(String word)
	{
		//If this word is not found
		if(!(searchWord(word)))					
		{
			//Ensures the capacity is enough to add the next word
			dictionary.ensureCapacity(dictionary.size() + 1);
			dictionary.add(word);
			wordsAdded.ensureCapacity(wordsAdded.size() + 1);
			wordsAdded.add(word);
		}
	}
	
	//Appends the specified element to the end of the ignored word
	public void ignoreWord(String word)
		{
			ignoredWords.ensureCapacity(ignoredWords.size() + 1);
			ignoredWords.add(word);
		}
	
	//Outputs the file to standard out, may need to be changed for GUI
	public void saveOutput()
	{
		//Sort all of the ArrayLists first
		Collections.sort(dictionary);
		Collections.sort(wordsAdded);
		Collections.sort(ignoredWords);
		
		PrintWriter programDictionaryFile = null;
		PrintWriter userDictionaryFile = null;
		PrintWriter ignoredFile = null;
		PrintWriter addedFile = null;
		
		Scanner input = null;
		
		//Try saving all the output files
        try
        {
        	input = new Scanner(System.in);
        	
        	//Get the filename of the new dictionary
        	System.out.println("Please enter a name for the new dictionary");
            String fileName = input.nextLine();
        	userDictionaryFile = new PrintWriter(fileName);
        	
        	//Print each word on a different line
        	printArrayList(dictionary, userDictionaryFile);
        	
        	userDictionaryFile.close();
        	
        	//Get the filename of the added words file
        	System.out.println("Please enter a name for the added words file");
            fileName = input.nextLine();
            addedFile = new PrintWriter(fileName);
            
            //Print each word on a different line
            printArrayList(wordsAdded, addedFile);
            
            addedFile.close();

            //Get the filename of the ignored words file
            System.out.println("Please enter a name for the ignored words file");
            fileName = input.nextLine();
            ignoredFile = new PrintWriter(fileName);
            
            //Print each word on a different line
            printArrayList(ignoredWords, ignoredFile);
            
            ignoredFile.close();
            
          //Get the filename of the new dictionary
        	programDictionaryFile = new PrintWriter("Dictionary.txt");
        	
        	//Print each word on a different line
        	printArrayList(dictionary, programDictionaryFile);
        	
        	programDictionaryFile.close();
        }
        catch (IOException e)
        {
        	System.out.println("Output error");
        }
        finally
        {
        	//Close all files in case of exceptions
	        if (programDictionaryFile != null)
	        	programDictionaryFile.close();
	        if (userDictionaryFile != null)
	        	userDictionaryFile.close();
	        if (ignoredFile != null)
	        	ignoredFile.close();
	        if (addedFile != null)
	        	addedFile.close();
        }
        
        input.close();
	}

	//Iterates through an ArrayList returning a String with each word separated by a new line.
	private void printArrayList(ArrayList<String> list, PrintWriter file)
	{
        for (int index = 0; index < list.size(); index ++)
            file.println(list.get(index));
	}
}
