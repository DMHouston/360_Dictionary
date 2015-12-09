package Dictionary;
import java.util.ArrayList;

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
		return dictionary.contains(word);
	}
	
	//Appends the specified element to the end of the dictionary list, adding to either ignored or added words respectively
	public void addWord(String word)
	{
		//If this word is not found
		if(!(searchWord(word)))					
		{
			//ensures the capacity is enough to add the next word
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
	public void displayOutput()
	{
        System.out.println("Words in Dictionary: ");
        System.out.println(dictToString(dictionary));
        
        System.out.println("Words added: ");
        System.out.println(dictToString(wordsAdded));

        System.out.println("Ignored Words: ");
        System.out.println(dictToString(ignoredWords));
	}

	//Iterates through an ArrayList returning a String with each word separated by a new line.
	private String dictToString(ArrayList<String> thisArrayList)
	{
		String returnString = "";
		
        for (int index = 0; index < thisArrayList.size(); index ++)
        {
            returnString += thisArrayList.get(index);
            returnString += "\r\n";			//Using "/n" does not work on every platform
        }
        return returnString;
	}
}
