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
	
	//Returns true if this list contains the specified element.
	public boolean searchWord(ArrayList<String> thisArrayList, String word) {
		boolean elementFound = thisArrayList.contains(word);
		return elementFound;
	}
	
	//Appends the specified element to the end of this list.
	public void addWord(ArrayList<String> thisArrayList, String word) {
		thisArrayList.ensureCapacity(thisArrayList.size() +1);	//ensures the capacity is enough to add the next word
		thisArrayList.add(word);
	}
	
	//Outputs the file to standard out, may need to be changed for GUI
	public void displayOutput(ArrayList<String> Dictionary, ArrayList<String> wordsAdded, ArrayList<String> ignoredWords) {
        System.out.println("Words in Dictionary: ");
        System.out.println(dictToString(Dictionary));
        
        System.out.println("Words added: ");
        System.out.println(dictToString(wordsAdded));

        System.out.println("Ignored Words: ");
        System.out.println(dictToString(Dictionary));
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
