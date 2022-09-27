
	package in.sts.sts_project.reader;
	import java.io.File;
	import java.util.ArrayList;
	import java.util.HashMap;
	import org.apache.log4j.Logger;

	public class MultipleFileReader extends SingleFileReader {                     //Class for reading the multiple files
		final Logger log=Logger.getLogger(MultipleFileReader.class);               //create  logger object for print the statement


		public HashMap<String, ArrayList<String>>multiFileRead(String driveName) {                

			HashMap<String, ArrayList<String>> fileMap=new HashMap<String, ArrayList<String>>();	  //Creating hashmap object for storing the filename and filesValues 

			try {                              
				File file = new File(driveName);                                             //Storing path in the variable 
				File[] files=file.listFiles();		                                            //storing all the files in the directory in file array
				for(File file2:files) {                                                       //Creating arraylist object for storing the .txt files
					if(file2.getName().endsWith(".txt")==true) {                              //if the file ends with .txt then the file stored in the hashmap
						fileMap.put(driveName+file2.getName(), singleFileRead(driveName+file2.getName())); 
					}
				}

			}
			catch(NullPointerException nullPointerException)                                 //if their will be no file in the drive then the null pointer excpetion have been happened
			{
				log.error("Drive not found");
				System.out.println("Drive not found");
			}
			return fileMap;

		}
	}



