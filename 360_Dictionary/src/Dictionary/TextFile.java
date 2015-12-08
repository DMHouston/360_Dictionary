package Dictionary;

import java.io.*;
import java.util.ArrayList;

public class TextFile {
	
	private ArrayList<String> documentToCheck;
	private BufferedReader file;
	
	public TextFile(String fileName) throws IOException {
		try	{
			documentToCheck = new ArrayList<String>();
			
			//Create the buffer and file reader to take in input
			file = new BufferedReader(new FileReader("Dictionary.txt"));
			String line = file.readLine();
			
			//Convert the line into an ArrayList
			String [] split = line.split("\\s*,\\s*");
			for (int index = 0; index < split.length; index++)
			{
				//Double check to make sure the word has a value
				if (split[index] != null && split[index].length() != 0)
					documentToCheck.add(split[index]);
			}
			
			//TEST REMOVE LATER: Outputs the elements in the ArrayList to check it works properly
			for (int i = 0; i < documentToCheck.size(); i++)
				System.out.println(documentToCheck.get(i));
			
		}
		finally {
			//Must close the file
			if (file != null)
				file.close();
		}
	}
	
	public ArrayList<String> getDocument() {
		return documentToCheck;
	}
}
