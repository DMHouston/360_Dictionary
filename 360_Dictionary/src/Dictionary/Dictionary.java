package Dictionary;
import java.util.ArrayList;

//Dictonary class handles creating the ArrayLists, searching for a word(boolean), adding a word(void), displaying output(void), toSting(String)
public class Dictionary {
	// note for array list, default starting size is 10
	ArrayList<String> dictionary = new ArrayList<String>();
	ArrayList<String> wordsAdded = new ArrayList<String>();
	ArrayList<String> ignoredWords = new ArrayList<String>();
	public Dictionary(ArrayList<String> wordList) {
	}
	
	//Returns true if the word is found in dictionary or ignoredWords.
	public boolean searchWord(String word) {
		boolean foundInEither = (dictionary.contains(word) || ignoredWords.contains(word));
		return foundInEither;
	}
	
	//Appends the specified element to the end of the dictionary list, adding to either ignored or added words respectively
	public void addWord(String word) {
		if(!(searchWord(word)))							//If this word is not found
		{
			dictionary.ensureCapacity(dictionary.size() + 1);	//ensures the capacity is enough to add the next word
			dictionary.add(word);
			wordsAdded.ensureCapacity(wordsAdded.size() + 1);
			wordsAdded.add(word);
		}
		else
		{
			ignoredWords.ensureCapacity(ignoredWords.size() + 1);
			ignoredWords.add(word);
		}
	}
	
	//Outputs the file to standard out, may need to be changed for GUI
	public void displayOutput() {
        System.out.println("Words in Dictionary: ");
        System.out.println(dictToString(dictionary));
        
        System.out.println("Words added: ");
        System.out.println(dictToString(wordsAdded));

        System.out.println("Ignored Words: ");
        System.out.println(dictToString(ignoredWords));
	}

	//Iterates through an ArrayList returning a String with each word seperated by a new line.
	private String dictToString(ArrayList<String> thisArrayList){
		String returnString = "";
        for (int index = 0; index < thisArrayList.size(); index ++) {
            returnString += thisArrayList.get(index);
            returnString += "\r\n";			//simply using "/n" does not work on every platfrom, can change it if you want
        }
        return returnString;
	}
}
