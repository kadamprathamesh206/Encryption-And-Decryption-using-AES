
package in.sts.sts_project.services;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import in.sts.sts_project.input.FileInput;
import in.sts.sts_project.reader.MultipleFileReader;
import in.sts.sts_project.util.DisplayWord;
import in.sts.sts_project.util.FileWordsCount;
import in.sts.sts_project.reader.*;



public class Operation {                                                                       //Operation class for performing the business logic
	int count=0;                   
	final Logger log=Logger.getLogger(MultipleFileReader.class);                                  //Creating a logger class for for print
	
	SingleFileReader singleFileReadr=new SingleFileReader();                                         //Single File reader object create for for read the single  file           
	MultipleFileReader multipleFileReadr=new MultipleFileReader();                                   //creating MultifileReader object for read the MultipleFile file

	public HashMap<String, Integer> fileCountOpertion(String operation) {
		HashMap<String, Integer> countHashMap=new HashMap<String, Integer>();                     //Creating hashmap object for storing the file and count
		FileWordsCount wordCount=new FileWordsCount();                                          //Creating the Counting Class Object For Counting the words in the file                 
		switch(operation) {                                        
		case "1":
			
			count=wordCount.wordsCount(singleFileReadr.singleFileRead (FileInput.getSingleFileInput()));       //For Single File Read 
			countHashMap.put("file", count);                                                           

			return countHashMap;

		case "2":                                                                                              //For MultipleFile File Read
			
			HashMap<String, Integer> multipleFileCount =wordCount.wordsCount(multipleFileReadr.multiFileRead(FileInput.getMultipleFileInput()));               
			for (Map.Entry<String, Integer> set : multipleFileCount.entrySet()) {

				countHashMap.put(set.getKey(), set.getValue());
			}
			return countHashMap;	

		default:
			log.info("Wrong input given");                                                      //if user give the other input than given then it will be comes in the default case
		}
		return null;

	}

	public HashMap<String ,ArrayList<String>>  fileWordDisplayOperation(String operation){
		HashMap<String , ArrayList<String>> wordsHashMap=new HashMap<String,ArrayList<String>> ();    //Creating WordHashMap Object for Storing the words into HashMap
		DisplayWord displayWord=new DisplayWord();
		switch(operation) {
		case "1":                                                                                      //Case 1 for SingleFile
			ArrayList<String> words=displayWord.wordsDisplay(singleFileReadr.singleFileRead (FileInput.getSingleFileInput()));
		
			wordsHashMap.put("Filename",words);

			return wordsHashMap;
		case "2":                                                                                      //Case 2 for MultiFile
			wordsHashMap=displayWord.wordsDisplay((multipleFileReadr.multiFileRead(FileInput.getMultipleFileInput())));
			return wordsHashMap;
		}
		return null;

	}
}
