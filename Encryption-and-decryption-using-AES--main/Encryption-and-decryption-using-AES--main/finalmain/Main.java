
package in.sts.sts_project.finalmain;
import java.io.FileNotFoundException;
import org.apache.log4j.BasicConfigurator;

import in.sts.sts_project.input.FileInput;
import in.sts.sts_project.output.FileOutput;

import in.sts.sts_project.services.Operation;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		BasicConfigurator.configure();

		FileInput fileInput=new FileInput();                         //Creating  FileInput Class for Taking the Input From user

		Operation fileOperation=new Operation();                     //Creating  Operation Class object for taking the opeartion  from user

		FileOutput fileOutput=new FileOutput();                       //Creating FileOutput Class object for display output  
		String performOperation=fileInput.performFunction();            //call the performFunction method of FileInput class for storing which operation user wants to perform
		if(performOperation.equals("1"))                               //For wordCount Input press 1 , WordEncrptFormat DisplayInput Press 2 ,Press 3 for wordDisplay Input if any other input given by user then it goes into else block
		{
			fileOutput.getWordCountOutput(fileOperation.fileCountOpertion(fileInput.getWordCountInput()));
		}
		else if(performOperation.equals("2"))
		{
			fileOutput.getEncryptWordDisplay(fileOperation.fileWordDisplayOperation(fileInput.getEncryptWordInput()));
		}else if(performOperation.equals("3")){
			fileOutput.getWordDisplayOutput(fileOperation.fileWordDisplayOperation(fileInput.getWordDisplayInput()));
		}
		
		else{
			System.out.println("Wrong Input given");
		}
		}
	}




	


