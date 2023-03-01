package com.simplilearn.Excercise;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FileOperation {
	static Scanner input = new Scanner(System.in);
	
	/* This method is used to validate the existence of file and the access restrictions
	 * based on the file mode which user specified...Then returns whether the file is valid
	 * or not
	 */
	public boolean validateFile(File fRef, String mode) throws Exception
	{
		//does some specific tasks with READ mode
		if (mode == "READ")
		{
			//checks whether the specified file exists before try to access
			if (!fRef.exists())
			{
				System.out.println("Error: File does not exist");
				return false;
			}
			//checks whether the specified item is a file or not
			if (!fRef.isFile())
			{
				System.out.println("Error: Provided file path is not file");
				return false;
			}
			//checks whether the given file is readable
			if(!fRef.canRead())
			{
				System.out.println("Error: Provided file path is not readable");
				return false;
			}
		}
		//if it is WRITE mode do the following things
		else if (mode == "WRITE" || mode == "APPEND")
		{
			//check whether the file exists if yes 
			if (fRef.exists())
			{
				if(!fRef.canWrite())
				{
					System.out.println("Error: Provided file path is not writeable");
					return false;
				}
				
				if (mode == "WRITE")
					System.out.println("File already exists.. Do you want to rewrite (Yes/No)");
				else if (mode == "APPEND")
					System.out.println("Do you really want to append the content (Yes/No)");
				//if user wants to rewrite returns true...
				if (input.next().equalsIgnoreCase("Yes"))
				{
					return true;
				}
				else
				{
					if (mode == "WRITE")
						System.out.println("Info: Rewrite is prohibited by User");//rewrite is prohibited by user...
					else if (mode == "APPEND")
						System.out.println("Info: Append is prohibited by User");//append is prohibited by user...
					return false;
				}	
			}
			else
			{
				//checks whether the file is writable
				if (mode == "WRITE")
				{
					//user wants to create a file....
					System.out.println("Do you want to create a file (Yes/No)");
					
					if (input.next().equalsIgnoreCase("Yes"))
					{
						fRef.createNewFile();
						return true;
					}
					else
					{
						//user denied creation of file...
						System.out.println("Info: Creating file is prohibited by User");
						return false;
					}
				}
				else if (mode == "APPEND")
					System.out.println("Info: Specified file does not exist");
			}
		}
		return true;
	}
	
	/* This method is used to read the file content from
	 * the specified file and display it on the console
	 */
	public void readFromFile(String filePath) throws Exception
	{
		File fRef = new File(filePath);
		boolean isFileValid = validateFile (fRef, "READ");
		if (isFileValid)
		{
			Scanner fileContent = new Scanner(fRef);
			//recurse through the file content until there is no more lines inside the file
		    while (fileContent.hasNextLine())
		      System.out.println(fileContent.nextLine());
		    
		    fileContent.close();
		}
	}
	
	/* This method gets the console input and write/append 
	 * to the file content based on user selection 
	 */
	public String getConsoleInput()
	{
		Scanner consoleInput = new Scanner(System.in);
		
        String finalContent = "";
        //iterate through the lines until the empty line is reached
        while(true){
        		String line = consoleInput.nextLine(); //read every line from console
        		if (finalContent.equals(""))
        			finalContent = line;
        		else
        			finalContent = finalContent + "\n" + line;
        	//when the empty line is found come out of the loop
            if(line.equals("")){
                break;
            }
        }
        consoleInput.close();
        return finalContent;
	}
	
	/* This method is used to read the user input from the console
	 * and write/append it to a specified file
	 */
	public void updateFile(String filePath, String mode, boolean type) throws Exception
	{
		File fRef = new File(filePath);
		boolean isFileValid = validateFile (fRef, mode);

		if (isFileValid)
		{
			System.out.println("Text to write/append to file");	
			//gets the user input from console
	        String consoleInput = getConsoleInput();
	        
			FileWriter fWriter = new FileWriter(filePath, type);
		 
		    // Writing into file
		    fWriter.write(consoleInput);
		 
		    // Closing the file writing connection
		    fWriter.close();
		 
		    // Display message for successful execution of
		    // program on the console
		    System.out.println("File is created/updated successfully with the content.");
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println("Provide File Operation to Perform");
		System.out.println("1. Read a File");
		System.out.println("2. Write to a File");
		System.out.println("3. Append to a File");
		
		
		int option = input.nextInt();
		
		FileOperation fOper = new FileOperation();
		switch(option)
		{
			case 1: System.out.println("File you want to read??");
					String fPathRead = input.next();
					fOper.readFromFile(fPathRead);
					break;
					
			case 2: System.out.println("File you want to write to??");
					String fPathWrite = input.next();
					fOper.updateFile(fPathWrite, "WRITE", false);
					break;
					
			case 3: System.out.println("File you want to append to??");
					String fPathAppend = input.next();
					fOper.updateFile(fPathAppend, "APPEND", true);
					break;
					
			default: System.out.println("Invalid Choice");
					 break;
		}
		input.close();
	}

}
