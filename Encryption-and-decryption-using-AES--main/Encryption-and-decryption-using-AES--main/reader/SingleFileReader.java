
	package in.sts.sts_project.reader;
	import java.io.BufferedReader;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.ArrayList;
	import org.apache.log4j.Logger;




	public class SingleFileReader {
		final Logger log=Logger.getLogger(MultipleFileReader.class);      
		          //Create a logger object for  print the statement                                                     
		public ArrayList<String> singleFileRead(String fileName)  {
			ArrayList<String> fileContent=new ArrayList<String>();                //Creating arrylist object for storing the filecontent of file

			BufferedReader bufferReader=null;
			try {

				FileReader file = new FileReader(fileName);                          //Opens a file in read mode  
				bufferReader = new BufferedReader(file);                             //read file 
				String line;                                                       //line variable for storing each statement in that line


				while((line = bufferReader.readLine()) != null)                   //if the files i not null then loop has been executed 
				{             
					fileContent.add(line) ;                                      //total count of words
				}
				

			}
			catch(IOException ioException) {

			System.out.println("Cannot read filw properly");	
			}finally {
				if(bufferReader!=null) {
					try {
						bufferReader.close();
					} catch (IOException ioException) {
						System.out.println("cannot read file properly");
					}
				}

			}
			return fileContent;
		}
	}

