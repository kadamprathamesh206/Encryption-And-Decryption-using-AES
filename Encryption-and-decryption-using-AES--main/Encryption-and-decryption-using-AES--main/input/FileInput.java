package in.sts.sts_project.input;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import org.apache.log4j.Logger;

import in.sts.sts_project.services.AES;



public class FileInput {
	final static Logger log=Logger.getLogger(FileInput.class);        //Creating Logger Object For Displaying the log

	static Scanner  scanner=new Scanner(System.in);                  //Creating Scanner class for taking input from user
	public String performFunction() {                                //Creating performFunction method for taking which opeartion user wants to perform       

		System.out.println("Enter 1 for wordCount of File");        
		System.out.println("Enter 2 for wordDisplay in Encrypt format from File");
		System.out.println("Enter 3 for wordDisplay from file");
		
		String Input=scanner.nextLine();
		System.out.println("");

		return Input;

	}
	
	public  String getWordCountInput() {                            //Creating getWordcountInput method for  wordCount Input 
		
		System.out.println("Enter 1 for Read only one file in drive");
		System.out.println("Enter 2 for Read all the files in drive");
		System.out.println("Enter the operation you want tro perform");
		String operation=scanner.nextLine();
		System.out.println("");

		return operation;
	}
	
	

	public String getEncryptWordInput() {                         //Creating getWordDisplayInput for taking the worddisplay Input
		System.out.println("Enter 1 for Display word in Encrypt Format  from one file");
		System.out.println("Enter 2 for Display word in Encrypt from  all the files");
		System.out.println("Enter the operation you want to perform");
		String operation=scanner.nextLine();
		return operation;

	}
	
	public String getWordDisplayInput() {                         //Creating getWordDisplayInput for taking the worddisplay Input
		System.out.println("Enter 1 for Display word from one file");
		System.out.println("Enter 2 for Display word from all the files");
		System.out.println("Enter the operation you want to perform");
		String operation=scanner.nextLine();
		return operation;

	}
	



	public static String getSingleFileInput() {                   //Creating getSingleFileInput for taking the one file as Input 
		String path=null;
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the drive name");
		String Drive=scanner.nextLine();
		System.out.println("Enter the file name");
		String file=scanner.nextLine();
		path=""+Drive+":\\"+file+".txt";
		
		return path;
	} 
	

	public static String getMultipleFileInput() {                //Creating getMultipleFileInput for taking the drive from user

		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the drive name ");
		String Drive=scanner.nextLine();
		String path=""+Drive+":\\";
		
		return path;


	}
	
	
	public static String inPass() {                               //inpass method for taking the input as key from user                     
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Key");
		String pass=sc.nextLine();
		return pass;
	}
	
	

	public static void displayWordEncryptForm(ArrayList<String> words) {            //creating txtFileDisplayEncryptForm  method for for storing the words into encrpt format into another txtfile
		try{    

			FileWriter fileWriter=new FileWriter("F:\\file.txt");    
			BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
			int count=1;

			for(String word:words) {
				bufferedWriter.write("word"+count+" = "+word);
				bufferedWriter.newLine();
				count++;

			}
			bufferedWriter.close();
			AES.getdecrypt(words);
			
			    
		}catch(Exception expection){

			log.error("File not found");

		}    
		System.out.println("Success...");    
	} 
	
	
	
	public static void txtFileDisplay(ArrayList<String> words) {            //creating txtFileDisplay method for for storing the words into another txtfile
		try{    
			FileWriter f=new FileWriter("F:\\file.txt");
			BufferedWriter fw=new BufferedWriter(f);
			int count=1;

			for(String word:words) {
				fw.write("word"+count+" = "+word);
				fw.newLine();
				count++;

			}

			fw.close();    
		}catch(Exception expection){

			log.error("File not found");

		}    
		System.out.println("Success...");    
	} 
}

