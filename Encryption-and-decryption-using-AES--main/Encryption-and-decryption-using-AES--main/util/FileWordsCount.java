	package in.sts.sts_project.util;
	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.Map;

	import org.apache.log4j.Logger;
	public class FileWordsCount {
		final Logger log=Logger.getLogger(FileWordsCount.class);
		int count=0;

		public int wordsCount(ArrayList<String>listOfFiles){
			count=0;

			for(String line:listOfFiles) {                                   //Iterating each files


				if ( line== null || line.isEmpty()) 
				{
					return 0; 
					
				}

				boolean isWord = false; 
				int endOfLine = line.length() - 1;
				char[] characters = line.toCharArray(); 
				for (int i = 0; i < characters.length; i++) {
					
					if (Character.isLetter(characters[i]) && i != endOfLine) // if the char is a letter, word = true. 
					{ 
						isWord = true; 
					}
					else if (!Character.isLetter(characters[i]) && isWord)   // if char isn't a letter and there have been letters before, // counter goes up. 
					{
						count++; 
						isWord = false; 
					}
					else if (Character.isLetter(characters[i]) && i == endOfLine)  // last word of String; if it doesn't end with a non letter, it // wouldn't count without this.
					{
						count++; 
						
					} 
				}

			}
			return count;
		}



		public HashMap<String, Integer>  wordsCount(HashMap<String, ArrayList<String>> fileMap) {
			count=0;
			HashMap<String, Integer> multipleFileCount=new HashMap<String, Integer>();
			for (Map.Entry<String, ArrayList<String>> set : fileMap.entrySet()) {                //iterating each file from filemap of fileshashmap in the form of key and value pair  

				String fileName=set.getKey() ;    
				log.info(fileName);   //show thw file
				ArrayList<String>listOfFiles=set.getValue();                    
				int fileCount=wordsCount(listOfFiles);
				multipleFileCount.put(fileName, fileCount);
			}
			return multipleFileCount;

		}
	}




