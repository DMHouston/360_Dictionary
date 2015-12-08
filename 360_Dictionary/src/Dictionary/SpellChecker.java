package Dictionary;

public class SpellChecker {
	private Dictionary dictionary;
	private TextFile file;
	public static void main(String[] args) {
	
	ArrayList inputWords = new ArrayList();
	boolean fileExists = false;
		 		 
	try
	{		
		while(!fileExists)
		{
			Scanner input = new Scanner(System.in);
			System.out.print("Enter file name with extension(.txt): ");
			File inputFile = new File(input.nextLine());
			
			if(inputFile.exists())
			{
				fileExists = true;
					
				input = new Scanner(inputFile);
				while(input.hasNext())			//needs to account for whitespace/punctuation.
				{
					String word = input.next();
					word = word.toLowerCase();
					inputWords.add(word);      //needs to account for duplicates
				}
				input. close();
			}
			else
			{
				System.out.println("Could not find file. Please make sure the file is in the directory and try again.");
			}
		}
	}		
		catch (Exception e){}
		
		Collections.sort(inputWords);   //end result is alphabetical order of words in text. 
		System.out.println(inputWords);	////Send inputWords to the GUI to decide on adding or ignoring the words
	}
		
		
	private void runSpellcheck(TextFile file, Dictionary dictionary) {
		
	}
}
