package Dictionary;

import java.io.*;
import java.util.ArrayList;

public class TextFile
{
	
	private ArrayList<String> documentToCheck;
	private BufferedReader file;
	
	public TextFile(String fileName) throws IOException
	{
		try
		{
			documentToCheck = new ArrayList<String>();
			
			//Create the buffer and file reader to take in input
			file = new BufferedReader(new FileReader(fileName));
			String line = file.readLine();
			
			//Split the words from each line into an ArrayList
			while (line != null)
			{
				String [] split = line.split("\\s+");
				for (int index = 0; index < split.length; index++)
				{
					//Remove punctuation and whitespace
					split[index] = split[index].replaceAll("[^\\w]", "");
					//Remove numbers
					split[index] = split[index].replaceAll("\\d+", "");
					//Change to lower case
					split[index] = split[index].toLowerCase();
					//Make sure the word has a value
					if (split[index] != null && split[index].length() != 0)
						//Ensure there are no duplicates
						if (!documentToCheck.contains(split[index]))
							documentToCheck.add(split[index]);
				}
				
				//Load the next line
				line = file.readLine();
			}
			
		}
		finally
		{
			//Must close the file
			if (file != null)
				file.close();
		}
	}
	
	public ArrayList<String> getDocument()
	{
		return documentToCheck;
	}
}
