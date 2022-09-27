package in.sts.sts_project.output;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import java.util.Map;

import in.sts.sts_project.input.FileInput;





public class FileOutput {
	public  void  getWordCountOutput(HashMap<String , Integer> fileList) {
		//call the fileOpration object for output
		for(Map.Entry<String,Integer>filemap:fileList.entrySet()) {                           //iterating each file into ky and value pair
			String filename=filemap.getKey();                                                  //store the key into file
			int count=filemap.getValue();                                                      //store the wordcount into count variable; 
			System.out.println(filename);
			System.out.println("count = "+count);
		}

	}
	public void getWordDisplayOutput(HashMap<String,ArrayList<String>> fileList) {         //Creating getWordDisplayUtput Method fo display word 
		String fileName=null;
		ArrayList<String>allWords=new ArrayList<String>();
		for(Map.Entry<String, ArrayList<String>> files:fileList.entrySet()) {

			fileName=files.getKey();
			System.out.println(fileName );

			ArrayList<String> words=files.getValue();

			allWords.addAll(words);

		}
		Collections.sort(allWords);

		FileInput.txtFileDisplay(allWords);

	}

	
	

	public void getEncryptWordDisplay(HashMap<String,ArrayList<String>> fileList) {         //Creating getWordDisplayUtput Method fo display word in encrpt format 
		int key=3; 
		String fileName=null;
		ArrayList<String> encrypt=new ArrayList<String>();
		ArrayList<String>allWords=new ArrayList<String>();
		for(Map.Entry<String, ArrayList<String>> files:fileList.entrySet()) {

			 fileName=files.getKey();
			System.out.println(fileName );
		
			ArrayList<String> words=files.getValue();
			allWords.addAll(words);

		}
		for(int i=0;i<allWords.size();i++) {
			String word=allWords.get(i);
			char[]characters=word.toCharArray();
			String charToWords="";
			for(char character:characters) {
				character+=key;
				charToWords=charToWords+character;
			}
			encrypt.add(charToWords);
			charToWords="";
		}
		System.out.println(""); 
		Collections.sort(encrypt); 
		FileInput.displayWordEncryptForm(encrypt);                                               //call the txtFile
	

	}

}






