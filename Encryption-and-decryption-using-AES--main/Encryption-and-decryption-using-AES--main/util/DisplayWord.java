package in.sts.sts_project.util;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;


public class DisplayWord {
	final Logger log=Logger.getLogger(DisplayWord.class);
	int count=0;

	public ArrayList<String> wordsDisplay(ArrayList<String>listOfFiles){

		count=0;
		String word="";
		ArrayList<String>words=new ArrayList<String>();

		for(String line:listOfFiles) {                                   //Iterating each files


			if ( line== null || line.isEmpty()) 
			{
				return null; 

			}

			boolean isWord = false; 
			int endOfLine = line.length() - 1;
			char[] characters = line.toCharArray();


			ArrayList<Character> character=new ArrayList<Character>();
			for (int i = 0; i < characters.length; i++) {

				if (Character.isLetter(characters[i]) && i != endOfLine) // if the char is a letter, word = true. 
				{ 
					isWord = true; 
					character.add(characters[i]);
				}
				else if (!Character.isLetter(characters[i]) && isWord)   // if char isn't a letter and there have been letters before, // counter goes up. 
				{
					character.add(null);

					isWord = false; 
				}
				else if (Character.isLetter(characters[i]) && i == endOfLine)  // last word of String; if it doesn't end with a non letter, it // wouldn't count without this.
				{

					character.add(characters[i]);

					character.add(null);
				} 

			}
			//			System.out.println(characters);
			//			System.out.println(character);

			for(int i = 0; i < character.size(); i++) {
				if(character.get(i)!=null) {
					word=word+character.get(i);
					if(i==character.size()-1) {
						words.add(character.get(i).toString());
					}


				}
				else if(character.get(i)==null) {
					words.add(word);
					word="";

				}

			}


		}

		return words;


	}
	public HashMap<String, ArrayList<String>>  wordsDisplay(HashMap<String, ArrayList<String>> fileMap) {
		count=0;
		HashMap<String, ArrayList<String>> multipleWords=new HashMap<String, ArrayList<String>>();
		for (Map.Entry<String, ArrayList<String>> set : fileMap.entrySet()) {                //iterating each file from filemap of fileshashmap in the form of key and value pair  

			String fileName=set.getKey() ;    
			log.info(fileName);   //show thw file
			ArrayList<String>listOfFiles=set.getValue();                    
			ArrayList<String> fileList=wordsDisplay(listOfFiles);
			multipleWords.put(fileName, fileList);
		}
		return multipleWords;

	}

}





